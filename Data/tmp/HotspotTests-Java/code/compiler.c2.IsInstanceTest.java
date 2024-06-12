public class IsInstanceTest {
	public static void main(java.lang.String[] args) {
		compiler.c2.IsInstanceTest.BaseInterface baseInterfaceImpl = new compiler.c2.IsInstanceTest.BaseInterfaceImpl();
		for (int i = 0; i < 100000; i++) {
			if (compiler.c2.IsInstanceTest.isInstanceOf(baseInterfaceImpl, compiler.c2.IsInstanceTest.ExtendedInterface.class)) {
				throw new java.lang.AssertionError("Failed at index:" + i);
			}
		}
		java.lang.System.out.println("Done!");
	}

	public static boolean isInstanceOf(compiler.c2.IsInstanceTest.BaseInterface baseInterfaceImpl, java.lang.Class... baseInterfaceClasses) {
		for (java.lang.Class baseInterfaceClass : baseInterfaceClasses) {
			if (baseInterfaceClass.isInstance(baseInterfaceImpl)) {
				return true;
			}
		}
		return false;
	}

	private interface BaseInterface {}

	private interface ExtendedInterface extends compiler.c2.IsInstanceTest.BaseInterface {}

	private static class BaseInterfaceImpl implements compiler.c2.IsInstanceTest.BaseInterface {}
}