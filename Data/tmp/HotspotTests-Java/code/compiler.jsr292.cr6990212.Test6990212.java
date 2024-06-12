public class Test6990212 implements compiler.jsr292.cr6990212.intf {
	public java.lang.Object target() {
		return null;
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.lang.invoke.MethodHandle target = java.lang.invoke.MethodHandles.lookup().findVirtual(compiler.jsr292.cr6990212.intf.class, "target", java.lang.invoke.MethodType.methodType(java.lang.Object.class));
		try {
			target.invoke(new java.lang.Object());
		} catch (java.lang.ClassCastException cce) {
			java.lang.System.out.println("got expected ClassCastException");
		}
	}
}