public class JitBug1 {
	public static void main(java.lang.String[] args) {
		jit.misctests.JitBug1.JitBug1 me = new jit.misctests.JitBug1.JitBug1();
		java.lang.System.out.println(me.foo(10));
		java.lang.System.out.println(me.foo(10));
		java.lang.System.out.println(me.foo(10));
	}

	private int foo(long width) {
		width += bar();
		if (width > java.lang.Integer.MAX_VALUE) {
			width = java.lang.Integer.MAX_VALUE;
		}
		return ((int) (width));
	}

	public int bar() {
		return 5;
	}
}