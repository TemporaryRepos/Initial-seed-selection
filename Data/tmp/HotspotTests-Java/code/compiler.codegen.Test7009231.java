public class Test7009231 {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		compiler.codegen.Test7009231.doTest(8);
	}

	private static void doTest(int nThreads) throws java.lang.InterruptedException {
		java.lang.Thread[] aThreads = new java.lang.Thread[nThreads];
		final java.util.concurrent.atomic.AtomicLong atl = new java.util.concurrent.atomic.AtomicLong();
		for (int i = 0; i < nThreads; i++) {
			aThreads[i] = new compiler.codegen.Test7009231.RunnerThread(atl, 1L << (8 * i));
		}
		for (int i = 0; i < nThreads; i++) {
			aThreads[i].start();
		}
		for (int i = 0; i < nThreads; i++) {
			aThreads[i].join();
		}
	}

	public static class RunnerThread extends java.lang.Thread {
		public RunnerThread(java.util.concurrent.atomic.AtomicLong atomic, long lMask) {
			m_lMask = lMask;
			m_atomic = atomic;
		}

		public void run() {
			java.util.concurrent.atomic.AtomicLong atomic = m_atomic;
			long lMask = m_lMask;
			for (int i = 0; i < 100000; i++) {
				setBit(atomic, lMask);
				clearBit(atomic, lMask);
			}
		}

		protected void setBit(java.util.concurrent.atomic.AtomicLong atomic, long lMask) {
			long lWord;
			do {
				lWord = atomic.get();
			} while (!atomic.compareAndSet(lWord, lWord | lMask) );
			if ((atomic.get() & lMask) == 0L) {
				throw new java.lang.InternalError();
			}
		}

		protected void clearBit(java.util.concurrent.atomic.AtomicLong atomic, long lMask) {
			long lWord;
			do {
				lWord = atomic.get();
			} while (!atomic.compareAndSet(lWord, lWord & (~lMask)) );
			if ((atomic.get() & lMask) != 0L) {
				throw new java.lang.InternalError();
			}
		}

		private long m_lMask;

		private java.util.concurrent.atomic.AtomicLong m_atomic;
	}
}