public class Test6875866 {
	static int IndexOfTest(java.lang.String str) {
		return str.indexOf("11111xx1x");
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str = "11111xx11111xx1x";
		int idx = compiler.codegen.Test6875866.IndexOfTest(str);
		java.lang.System.out.println("IndexOf = " + idx);
		if (idx != 7) {
			java.lang.System.exit(97);
		}
	}
}