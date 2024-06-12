public final class NPE {
	abstract static class Test {
		java.lang.String name;

		Test(java.lang.String name) {
			this.name = name;
		}

		abstract void run();
	}

	static javaT.util.ServiceLoader.NPE.Test load = new javaT.util.ServiceLoader.NPE.Test("ServiceLoader.load(null)") {
		void run() {
			java.util.ServiceLoader.load(null);
		}
	};

	static javaT.util.ServiceLoader.NPE.Test loadWithClassLoader = new javaT.util.ServiceLoader.NPE.Test("ServiceLoader.load(null, loader)") {
		void run() {
			java.util.ServiceLoader.load(null, javaT.util.ServiceLoader.NPE.class.getClassLoader());
		}
	};

	static javaT.util.ServiceLoader.NPE.Test loadInstalled = new javaT.util.ServiceLoader.NPE.Test("ServiceLoader.loadInstalled(null)") {
		void run() {
			java.util.ServiceLoader.loadInstalled(null);
		}
	};

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (javaT.util.ServiceLoader.NPE.Test t : java.util.Arrays.asList(javaT.util.ServiceLoader.NPE.load, javaT.util.ServiceLoader.NPE.loadWithClassLoader, javaT.util.ServiceLoader.NPE.loadInstalled)) {
			java.lang.NullPointerException caught = null;
			try {
				t.run();
			} catch (java.lang.NullPointerException e) {
				caught = e;
			}
			if (caught == null) {
				throw new java.lang.RuntimeException("NullPointerException expected for method invocation of " + t.name);
			}
		}
	}
}