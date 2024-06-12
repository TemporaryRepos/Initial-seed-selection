public class PermitOverflow {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		for (boolean fair : new boolean[]{ true, false }) {
			java.util.concurrent.Semaphore sem = new java.util.concurrent.Semaphore(java.lang.Integer.MAX_VALUE - 1, fair);
			if (sem.availablePermits() != (java.lang.Integer.MAX_VALUE - 1)) {
				throw new java.lang.RuntimeException();
			}
			try {
				sem.release(2);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
			sem.release(1);
			if (sem.availablePermits() != java.lang.Integer.MAX_VALUE) {
				throw new java.lang.RuntimeException();
			}
			try {
				sem.release(1);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
			try {
				sem.release(java.lang.Integer.MAX_VALUE);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
		}
		class Sem extends java.util.concurrent.Semaphore {
			public Sem(int permits, boolean fair) {
				super(permits, fair);
			}

			public void reducePermits(int reduction) {
				super.reducePermits(reduction);
			}
		}
		for (boolean fair : new boolean[]{ true, false }) {
			Sem sem = new Sem(java.lang.Integer.MIN_VALUE + 1, fair);
			if (sem.availablePermits() != (java.lang.Integer.MIN_VALUE + 1)) {
				throw new java.lang.RuntimeException();
			}
			try {
				sem.reducePermits(2);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
			sem.reducePermits(1);
			if (sem.availablePermits() != java.lang.Integer.MIN_VALUE) {
				throw new java.lang.RuntimeException();
			}
			try {
				sem.reducePermits(1);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
			try {
				sem.reducePermits(java.lang.Integer.MAX_VALUE);
				throw new java.lang.RuntimeException();
			} catch (java.lang.Error expected) {
			}
		}
	}
}