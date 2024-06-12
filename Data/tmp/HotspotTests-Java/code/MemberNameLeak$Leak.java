static class Leak {
	public void callMe() {
	}

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		MemberNameLeak.Leak leak = new MemberNameLeak.Leak();
		for (int i = 0; i < 10; i++) {
			java.lang.invoke.MethodHandles.Lookup lookup = java.lang.invoke.MethodHandles.lookup();
			java.lang.invoke.MethodType mt = java.lang.invoke.MethodType.fromMethodDescriptorString("()V", MemberNameLeak.Leak.class.getClassLoader());
			java.lang.invoke.MethodHandle mh = lookup.findSpecial(MemberNameLeak.Leak.class, "callMe", mt, MemberNameLeak.Leak.class);
			mh.invokeExact(leak);
		}
		java.lang.System.gc();
	}
}