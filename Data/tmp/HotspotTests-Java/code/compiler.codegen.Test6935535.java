public class Test6935535 {
	static int IndexOfTest(java.lang.String str) {
		return str.indexOf("1111111111111xx1x");
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str = "1111111111111xx1111111111111xx1x";
		str = str.substring(0, 31);
		int idx = compiler.codegen.Test6935535.IndexOfTest(str);
		java.lang.System.out.println(((("IndexOf(" + ("1111111111111xx1x" + ") = ")) + idx) + " in ") + str);
		if (idx != (-1)) {
			java.lang.System.exit(97);
		}
	}
}