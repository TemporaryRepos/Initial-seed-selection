public class Test6539464 {
	static double log_value = 17197;

	static double log_result = java.lang.Math.log(compiler.interpreter.Test6539464.log_value);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < 1000000; i++) {
			double log_result2 = java.lang.Math.log(compiler.interpreter.Test6539464.log_value);
			if (log_result2 != compiler.interpreter.Test6539464.log_result) {
				throw new java.lang.InternalError((("Math.log produces inconsistent results: " + log_result2) + " != ") + compiler.interpreter.Test6539464.log_result);
			}
		}
	}
}