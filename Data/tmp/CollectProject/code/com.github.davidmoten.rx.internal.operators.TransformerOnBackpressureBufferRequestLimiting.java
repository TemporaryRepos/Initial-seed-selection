public final class TransformerOnBackpressureBufferRequestLimiting<T> implements rx.Observable.Transformer<T, T> {
	private static final com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting<java.lang.Object> instance = new com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting<java.lang.Object>();

	@java.lang.SuppressWarnings("unchecked")
	public static final <T> com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting<T> instance() {
		return ((com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting<T>) (com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.instance));
	}

	@java.lang.Override
	public rx.Observable<T> call(final rx.Observable<T> o) {
		return rx.Observable.defer(new rx.functions.Func0<rx.Observable<T>>() {
			@java.lang.Override
			public rx.Observable<T> call() {
				final com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.OperatorPassThroughAdjustedRequest<T> op = new com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.OperatorPassThroughAdjustedRequest<T>();
				return o.lift(op).onBackpressureBuffer().doOnRequest(new rx.functions.Action1<java.lang.Long>() {
					@java.lang.Override
					public void call(java.lang.Long n) {
						op.requestMore(n);
					}
				});
			}
		});
	}

	private static final class OperatorPassThroughAdjustedRequest<T> implements rx.Observable.Operator<T, T> {
		private volatile com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.ParentSubscriber<T> parent;

		private final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();

		private final java.lang.Object lock = new java.lang.Object();

		@java.lang.Override
		public rx.Subscriber<? super T> call(rx.Subscriber<? super T> child) {
			com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.ParentSubscriber<T> p = new com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.ParentSubscriber<T>(child);
			synchronized(lock) {
				parent = p;
			}
			p.requestMore(requested.get());
			child.add(p);
			return p;
		}

		public void requestMore(long n) {
			com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.ParentSubscriber<T> p = parent;
			if (p != null) {
				p.requestMore(n);
			} else {
				synchronized(lock) {
					com.github.davidmoten.rx.internal.operators.TransformerOnBackpressureBufferRequestLimiting.ParentSubscriber<T> par = parent;
					if (par == null) {
						com.github.davidmoten.rx.util.BackpressureUtils.getAndAddRequest(requested, n);
					} else {
						par.requestMore(n);
					}
				}
			}
		}
	}

	private static final class ParentSubscriber<T> extends rx.Subscriber<T> {
		private final rx.Subscriber<? super T> child;

		private final java.util.concurrent.atomic.AtomicLong expected = new java.util.concurrent.atomic.AtomicLong();

		public ParentSubscriber(rx.Subscriber<? super T> child) {
			this.child = child;
			request(0);
		}

		public void requestMore(long n) {
			if (n <= 0) {
				return;
			}
			long r = expected.get();
			if (r == java.lang.Long.MAX_VALUE) {
				return;
			} else {
				long u = r;
				while (true) {
					long sum = u + n;
					final long v;
					if (sum < 0) {
						v = java.lang.Long.MAX_VALUE;
					} else {
						v = sum;
					}
					if (expected.compareAndSet(u, v)) {
						long diff = java.lang.Math.max(0, v);
						long req = java.lang.Math.min(n, diff);
						if (req > 0) {
							request(req);
						}
						return;
					} else {
						u = expected.get();
					}
				} 
			}
		}

		@java.lang.Override
		public void onCompleted() {
			child.onCompleted();
		}

		@java.lang.Override
		public void onError(java.lang.Throwable e) {
			child.onError(e);
		}

		@java.lang.Override
		public void onNext(T t) {
			expected.decrementAndGet();
			child.onNext(t);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		rx.Observable.range(1, 10000).doOnRequest(new rx.functions.Action1<java.lang.Long>() {
			@java.lang.Override
			public void call(java.lang.Long n) {
				java.lang.System.out.println("requested " + n);
			}
		}).doOnUnsubscribe(new rx.functions.Action0() {
			@java.lang.Override
			public void call() {
				java.lang.System.out.println("unsubscribed");
			}
		}).compose(com.github.davidmoten.rx.Transformers.<java.lang.Integer>onBackpressureBufferRequestLimiting()).take(10).subscribeOn(rx.schedulers.Schedulers.io()).doOnNext(com.github.davidmoten.rx.Actions.println()).count().toBlocking().single();
		java.lang.Thread.sleep(2000);
	}
}