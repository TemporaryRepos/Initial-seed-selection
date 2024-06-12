public class nestedtypes002a {
	static final int PASSED = 0;

	static final int FAILED = 2;

	static final int PASS_BASE = 95;

	static boolean verbMode = false;

	private static void log1(java.lang.String message) {
		if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.verbMode) {
			java.lang.System.out.println("**>  debuggee: " + message);
		}
	}

	private static void logErr(java.lang.String message) {
		if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.verbMode) {
			java.lang.System.out.println("!!**>  debuggee: " + message);
		}
	}

	static int instruction = 1;

	static int end = 0;

	static int maxInstr = 1;

	static int lineForComm = 2;

	private static void methodForCommunication() {
		int i1 = nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.instruction;
		int i2 = i1;
		int i3 = i2;
	}

	public static void main(java.lang.String[] argv) {
		for (int i = 0; i < argv.length; i++) {
			if (argv[i].equals("-vbs") || argv[i].equals("-verbose")) {
				nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.verbMode = true;
				break;
			}
		}
		nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.log1("debuggee started!");
		int exitCode = nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.PASSED;
		label0 : for (int i = 0; ; i++) {
			if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.instruction > nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.maxInstr) {
				nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.logErr("ERROR: unexpected instruction: " + nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.instruction);
				exitCode = nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.FAILED;
				break;
			}
			switch (i) {
				case 0 :
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes002aTestClass[] testArray = new nsk.jdi.ReferenceType.nestedTypes.nestedtypes002aTestClass[]{ new nsk.jdi.ReferenceType.nestedTypes.nestedtypes002aTestClass() };
					java.lang.Class bl = java.lang.Boolean.TYPE;
					java.lang.Class bt = java.lang.Byte.TYPE;
					java.lang.Class ch = java.lang.Character.TYPE;
					java.lang.Class db = java.lang.Double.TYPE;
					java.lang.Class fl = java.lang.Float.TYPE;
					java.lang.Class in = java.lang.Integer.TYPE;
					java.lang.Class ln = java.lang.Long.TYPE;
					java.lang.Class sh = java.lang.Short.TYPE;
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.methodForCommunication();
					break;
				default :
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.instruction = nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.end;
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.methodForCommunication();
					break label0;
			}
		}
		java.lang.System.exit(exitCode + nsk.jdi.ReferenceType.nestedTypes.nestedtypes002a.PASS_BASE);
	}
}