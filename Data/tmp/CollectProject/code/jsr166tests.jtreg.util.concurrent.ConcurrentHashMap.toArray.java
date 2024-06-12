public class toArray {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		final java.lang.Throwable[] throwable = new java.lang.Throwable[1];
		final int maxSize = 1000;
		final java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> m = new java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer>();
		final java.lang.Thread t1 = new java.lang.Thread() {
			public void run() {
				for (int i = 0; i < maxSize; i++) {
					m.put(i, i);
				}
			}
		};
		final java.lang.Thread t2 = new java.lang.Thread() {
			public java.lang.Throwable exception = null;

			private int prevSize = 0;

			private boolean checkProgress(java.lang.Object[] a) {
				int size = a.length;
				if (size < prevSize) {
					throw new java.lang.RuntimeException("WRONG WAY");
				}
				if (size > maxSize) {
					throw new java.lang.RuntimeException("OVERSHOOT");
				}
				if (size == maxSize) {
					return true;
				}
				prevSize = size;
				return false;
			}

			public void run() {
				try {
					java.lang.Integer[] empty = new java.lang.Integer[0];
					while (true) {
						if (checkProgress(m.values().toArray())) {
							return;
						}
						if (checkProgress(m.keySet().toArray())) {
							return;
						}
						if (checkProgress(m.values().toArray(empty))) {
							return;
						}
						if (checkProgress(m.keySet().toArray(empty))) {
							return;
						}
					} 
				} catch (java.lang.Throwable t) {
					throwable[0] = t;
				}
			}
		};
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		if (throwable[0] != null) {
			throw throwable[0];
		}
	}
}