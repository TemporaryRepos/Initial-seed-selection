public class Cast {
	static class Foo {}

	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.lang.Object o = javaT.lang.Class.Cast.Foo.class.newInstance();
		javaT.lang.Class.Cast.Foo f = javaT.lang.Class.Cast.Foo.class.cast(o);
		if (f == null) {
			throw new java.lang.Error();
		}
		javaT.lang.Class.Cast.Foo f2 = javaT.lang.Class.Cast.Foo.class.cast(null);
	}
}