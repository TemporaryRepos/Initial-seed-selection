@org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Benchmark)
public class Benchmarks {
	static final java.lang.String lines = com.github.davidmoten.rx2.Benchmarks.create(10000, 100);

	static final io.reactivex.Flowable<java.lang.String> source = io.reactivex.Flowable.just(com.github.davidmoten.rx2.Benchmarks.lines, com.github.davidmoten.rx2.Benchmarks.lines, com.github.davidmoten.rx2.Benchmarks.lines, com.github.davidmoten.rx2.Benchmarks.lines, com.github.davidmoten.rx2.Benchmarks.lines);

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitStandardTake5() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.split("\n")).take(5).blockingLast();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitStandardWithPatternTake5() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.split(java.util.regex.Pattern.compile("\n"))).take(5).blockingLast();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitSimpleTake5() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.splitSimple("\n")).take(5).blockingLast();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitStandard() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.split("\n")).blockingLast();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitStandardWithPattern() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.split(java.util.regex.Pattern.compile("\n"))).blockingLast();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitSimple() {
		return com.github.davidmoten.rx2.Benchmarks.source.compose(com.github.davidmoten.rx2.Strings.splitSimple("\n")).blockingLast();
	}

	private static io.reactivex.Flowable<java.lang.Integer> range = io.reactivex.Flowable.defer(new java.util.concurrent.Callable<org.reactivestreams.Publisher<? extends java.lang.Integer>>() {
		@java.lang.Override
		public org.reactivestreams.Publisher<? extends java.lang.Integer> call() throws java.lang.Exception {
			return io.reactivex.Flowable.generate(new io.reactivex.functions.Consumer<io.reactivex.Emitter<java.lang.Integer>>() {
				final int[] count = new int[1];

				@java.lang.Override
				public void accept(io.reactivex.Emitter<java.lang.Integer> emitter) throws java.lang.Exception {
					count[0]++;
					emitter.onNext(count[0]);
					if (count[0] == 1000) {
						emitter.onComplete();
					}
				}
			});
		}
	});

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.Long mergeTwoStreams() {
		return io.reactivex.Flowable.merge(io.reactivex.Flowable.just(com.github.davidmoten.rx2.Benchmarks.range, com.github.davidmoten.rx2.Benchmarks.range, com.github.davidmoten.rx2.Benchmarks.range)).count().blockingGet();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.Long mergeTwoStreamsInterleaved() {
		return com.github.davidmoten.rx2.Flowables.mergeInterleaved(io.reactivex.Flowable.just(com.github.davidmoten.rx2.Benchmarks.range, com.github.davidmoten.rx2.Benchmarks.range, com.github.davidmoten.rx2.Benchmarks.range)).maxConcurrency(4).batchSize(128).build().count().blockingGet();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitRxJavaStringTake5() {
		return rx.Observable.just(com.github.davidmoten.rx2.Benchmarks.lines).compose(new rx.Observable.Transformer<java.lang.String, java.lang.String>() {
			@java.lang.Override
			public rx.Observable<java.lang.String> call(rx.Observable<java.lang.String> o) {
				return rx.observables.StringObservable.split(o, "\n");
			}
		}).take(5).last().toBlocking().last();
	}

	@org.openjdk.jmh.annotations.Benchmark
	public java.lang.String splitRxJavaString() {
		return rx.Observable.just(com.github.davidmoten.rx2.Benchmarks.lines).compose(new rx.Observable.Transformer<java.lang.String, java.lang.String>() {
			@java.lang.Override
			public rx.Observable<java.lang.String> call(rx.Observable<java.lang.String> o) {
				return rx.observables.StringObservable.split(o, "\n");
			}
		}).last().toBlocking().last();
	}

	private static java.lang.String create(int lines, int lineLength) {
		java.lang.StringBuilder s = new java.lang.StringBuilder(lines * lineLength);
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < lineLength; j++) {
				s.append(((char) (48 + (((i * 137) + j) % 74))));
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(java.lang.String[] args) {
		new com.github.davidmoten.rx2.Benchmarks().mergeTwoStreams();
	}
}