public class Test7042153 {
	public static class Bar {}

	public static class Foo {}

	static volatile boolean z;

	public static void main(java.lang.String[] args) {
		java.lang.Class cx = compiler.c1.Test7042153.Bar.class;
		java.lang.Class cy = compiler.c1.Test7042153.Foo.class;
		compiler.c1.Test7042153.z = cx == cy;
	}
}