public class BoxDrawingRun {
	private static final java.lang.String[][] Interpreter_Value_Matrix = new java.lang.String[][]{ new java.lang.String[]{ "0", "Interpreter", "Value", "Range" }, new java.lang.String[]{ "1", "BasicInterpreter", "BasicValue", "7" }, new java.lang.String[]{ "2", "BasicVerifier", "BasicValue", "7" }, new java.lang.String[]{ "3", "SimpleVerifier", "BasicValue", "N" }, new java.lang.String[]{ "4", "SourceInterpreter", "SourceValue", "N" } };

	private static final java.lang.String[][] Analyzer_Frame_Interpreter_Value_Matrix = new java.lang.String[][]{ new java.lang.String[]{ "Fixed", "Analyzer" }, new java.lang.String[]{ "", "Frame" }, new java.lang.String[]{ "Variable", "Interpreter" }, new java.lang.String[]{ "", "Value" } };

	private static final java.lang.String[][] Top_Null_Void = new java.lang.String[][]{ new java.lang.String[]{ "", "ASM Type", "Frame Value" }, new java.lang.String[]{ "top", "null", "BasicValue.UNINITIALIZED_VALUE" }, new java.lang.String[]{ "aconst_null", "BasicInterpreter.NULL_TYPE", "BasicValue.REFERENCE_VALUE" }, new java.lang.String[]{ "void", "Type.VOID_TYPE", "null" } };

	public static void main(java.lang.String[] args) {
		lsieun.utils.BoxDrawingUtils.printTable(run.BoxDrawingRun.Top_Null_Void);
	}
}