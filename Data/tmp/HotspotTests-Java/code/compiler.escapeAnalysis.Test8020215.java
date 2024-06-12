public class Test8020215 {
	public static class NamedObject {
		public int id;

		public java.lang.String name;

		public NamedObject(int id, java.lang.String name) {
			this.id = id;
			this.name = name;
		}
	}

	public static class NamedObjectList {
		public java.util.List<compiler.escapeAnalysis.Test8020215.NamedObject> namedObjectList = new java.util.ArrayList<compiler.escapeAnalysis.Test8020215.NamedObject>();

		public compiler.escapeAnalysis.Test8020215.NamedObject getBest(int id) {
			compiler.escapeAnalysis.Test8020215.NamedObject bestObject = null;
			for (compiler.escapeAnalysis.Test8020215.NamedObject o : namedObjectList) {
				bestObject = (id == o.id) ? compiler.escapeAnalysis.Test8020215.NamedObjectList.getBetter(bestObject, o) : bestObject;
			}
			return bestObject != null ? bestObject : null;
		}

		private static compiler.escapeAnalysis.Test8020215.NamedObject getBetter(compiler.escapeAnalysis.Test8020215.NamedObject p1, compiler.escapeAnalysis.Test8020215.NamedObject p2) {
			return p1 == null ? p2 : p2 == null ? p1 : p2.name.compareTo(p1.name) >= 0 ? p2 : p1;
		}
	}

	static void test(compiler.escapeAnalysis.Test8020215.NamedObjectList b, int i) {
		compiler.escapeAnalysis.Test8020215.NamedObject x = b.getBest(2);
		if (x == null) {
			throw new java.lang.RuntimeException(("x should never be null here! (i=" + i) + ")");
		}
	}

	public static void main(java.lang.String[] args) {
		compiler.escapeAnalysis.Test8020215.NamedObjectList b = new compiler.escapeAnalysis.Test8020215.NamedObjectList();
		for (int i = 0; i < 10000; i++) {
			b.namedObjectList.add(new compiler.escapeAnalysis.Test8020215.NamedObject(1, "2012-12-31"));
		}
		b.namedObjectList.add(new compiler.escapeAnalysis.Test8020215.NamedObject(2, "2013-12-31"));
		for (int i = 0; i < 12000; i++) {
			compiler.escapeAnalysis.Test8020215.test(b, i);
		}
		java.lang.System.out.println("PASSED");
	}
}