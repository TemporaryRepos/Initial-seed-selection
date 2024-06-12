public class Test {
	static java.lang.String var_1_copy = compiler.escapeAnalysis.cr6795161.Test_Class_1.var_1;

	static byte var_check;

	public static void main(java.lang.String[] args) {
		compiler.escapeAnalysis.cr6795161.Test.var_check = 1;
		compiler.escapeAnalysis.cr6795161.Test_Class_1.badFunc(-1);
		java.lang.System.out.println(("EATester.var_check = " + compiler.escapeAnalysis.cr6795161.Test.var_check) + " (expected 1)\n");
	}
}