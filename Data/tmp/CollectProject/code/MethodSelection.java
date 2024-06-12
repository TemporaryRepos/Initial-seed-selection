public class MethodSelection {
	public java.lang.Class constructedWith;

	public java.lang.String which;

	public java.lang.String[] varargs;

	public MethodSelection(java.lang.Object o) {
		constructedWith = o.getClass();
	}

	public MethodSelection(java.lang.String o) {
		constructedWith = o.getClass();
		which = "one";
	}

	public MethodSelection(long o) {
		constructedWith = java.lang.Long.TYPE;
	}

	public MethodSelection(int o) {
		constructedWith = java.lang.Integer.TYPE;
	}

	public MethodSelection(byte o) {
		constructedWith = java.lang.Byte.TYPE;
	}

	public MethodSelection(short o) {
		constructedWith = java.lang.Short.TYPE;
	}

	public MethodSelection() {
		constructedWith = java.lang.Void.TYPE;
	}

	public MethodSelection(java.lang.String arg1, java.lang.String arg2) {
		constructedWith = new java.lang.String[0].getClass();
		which = "two";
	}

	public MethodSelection(java.lang.String... args) {
		constructedWith = new java.lang.String[0].getClass();
		which = "three";
	}

	public static java.lang.Class get_static(java.lang.Object o) {
		return o.getClass();
	}

	public static java.lang.Class get_static(java.lang.String o) {
		return o.getClass();
	}

	public static java.lang.Class get_static(int o) {
		return java.lang.Integer.TYPE;
	}

	public static java.lang.Class get_static(long o) {
		return java.lang.Long.TYPE;
	}

	public static java.lang.Class get_static(byte o) {
		return java.lang.Byte.TYPE;
	}

	public static java.lang.Class get_static(short o) {
		return java.lang.Short.TYPE;
	}

	public static java.lang.Class get_static() {
		return java.lang.Void.TYPE;
	}

	public java.lang.Class get_dynamic(java.lang.Object o) {
		return o.getClass();
	}

	public java.lang.Class get_dynamic(java.lang.String o) {
		return o.getClass();
	}

	public java.lang.Class get_dynamic(int o) {
		return java.lang.Integer.TYPE;
	}

	public java.lang.Class get_dynamic(long o) {
		return java.lang.Long.TYPE;
	}

	public java.lang.Class get_dynamic(byte o) {
		return java.lang.Byte.TYPE;
	}

	public java.lang.Class get_dynamic(short o) {
		return java.lang.Short.TYPE;
	}

	public java.lang.Class get_dynamic() {
		return java.lang.Void.TYPE;
	}

	public java.lang.String method1(java.lang.String str) {
		return "one";
	}

	public java.lang.String method1(java.lang.String str, java.lang.String[] strs) {
		return "two";
	}

	public java.lang.String method1(java.lang.StringBuilder sb, java.lang.String string, java.util.ArrayList list, int[] ints) {
		return "three";
	}

	public java.lang.String method1(java.lang.StringBuilder sb, java.lang.String string, java.util.ArrayList list, int[] ints, int int2, java.lang.String last) {
		return "four";
	}

	public java.lang.String method1(java.lang.StringBuilder sb, java.lang.String string, java.lang.String[] strs, int[] ints, int int2, java.lang.String last) {
		return "five";
	}

	public java.lang.String method2(java.lang.String str) {
		varargs = new java.lang.String[]{ str };
		return "one";
	}

	public java.lang.String method2(java.lang.String str, java.lang.String str1) {
		varargs = new java.lang.String[]{ str, str1 };
		return "two";
	}

	public java.lang.String method2(java.lang.String str, java.lang.String... str2) {
		varargs = str2;
		return "three";
	}

	public static java.lang.Class staticVsDynamic1(java.lang.Object obj) {
		return java.lang.Object.class;
	}

	public java.lang.Class staticVsDynamic1(java.lang.String obj) {
		return java.lang.String.class;
	}

	public static void main(java.lang.String[] args) {
		new MethodSelection().staticVsDynamic1("foo");
		new MethodSelection().staticVsDynamic1(new java.lang.Object());
	}

	private java.lang.String foo(java.lang.Integer x) {
		return "private";
	}

	public java.lang.String foo(java.lang.String x) {
		return "public";
	}
}