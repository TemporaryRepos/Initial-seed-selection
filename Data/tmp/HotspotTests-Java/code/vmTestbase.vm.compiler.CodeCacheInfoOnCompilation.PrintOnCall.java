public class PrintOnCall {
	public static void printOnCall() {
		java.lang.System.out.println("PrintOnCall");
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("before");
		vmTestbase.vm.compiler.CodeCacheInfoOnCompilation.PrintOnCall.printOnCall();
		java.lang.System.out.println("after");
	}
}