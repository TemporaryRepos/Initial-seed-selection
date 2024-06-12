public class InheritedMethods {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.lang.reflect.Method.InheritedMethods();
	}

	InheritedMethods() throws java.lang.Exception {
		java.lang.Class c = javaT.lang.reflect.Method.InheritedMethods.Foo.class;
		java.lang.reflect.Method m = c.getMethod("removeAll", new java.lang.Class[]{ java.util.Collection.class });
		if (m.getDeclaringClass() != java.util.List.class) {
			throw new java.lang.RuntimeException("TEST FAILED");
		}
	}

	interface Foo extends java.util.List {}
}