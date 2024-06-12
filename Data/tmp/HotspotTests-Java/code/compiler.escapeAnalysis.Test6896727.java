public class Test6896727 {
	static final java.lang.String testString = "abracadabra";

	public static void main(java.lang.String[] args) {
		java.lang.String[][] params = new java.lang.String[][]{ new java.lang.String[]{ "control", compiler.escapeAnalysis.Test6896727.testString } };
		for (int i = 0; i < params.length; i++) {
			try {
				java.lang.System.out.println((((("Params :" + compiler.escapeAnalysis.Test6896727.testString) + " and ") + params[i][0]) + ", ") + params[i][1]);
				if (params[i][1] == null) {
					java.lang.System.exit(97);
				}
			} catch (java.lang.Exception e) {
			}
		}
	}
}