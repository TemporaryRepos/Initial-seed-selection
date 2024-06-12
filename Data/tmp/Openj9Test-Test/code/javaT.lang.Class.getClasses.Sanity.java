public class Sanity {
	public class Base {
		public class BInner {}

		protected class BProtected {}

		class BPackage {}
	}

	public class Derived extends javaT.lang.Class.getClasses.Sanity.Base {
		public class DInner {}

		protected class DProtected {}

		class DPackage {}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Class[] c = javaT.lang.Class.getClasses.Sanity.Derived.class.getClasses();
		if (c.length != 2) {
			throw new java.lang.Exception("Incorrect number of public classes returned");
		}
		for (int i = 0; i < c.length; i++) {
			if ((c[i] != javaT.lang.Class.getClasses.Sanity.Base.BInner.class) && (c[i] != javaT.lang.Class.getClasses.Sanity.Derived.DInner.class)) {
				throw new java.lang.Exception("Garbage in declared classes");
			}
		}
	}
}