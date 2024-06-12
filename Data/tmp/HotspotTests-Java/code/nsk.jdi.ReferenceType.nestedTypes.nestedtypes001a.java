public class nestedtypes001a {
	static final int PASSED = 0;

	static final int FAILED = 2;

	static final int PASS_BASE = 95;

	static boolean verbMode = false;

	private static void log1(java.lang.String message) {
		if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.verbMode) {
			java.lang.System.out.println("**>  debuggee: " + message);
		}
	}

	private static void logErr(java.lang.String message) {
		if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.verbMode) {
			java.lang.System.out.println("!!**>  debuggee: " + message);
		}
	}

	static int instruction = 1;

	static int end = 0;

	static int maxInstr = 1;

	static int lineForComm = 2;

	private static void methodForCommunication() {
		int i1 = nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.instruction;
		int i2 = i1;
		int i3 = i2;
	}

	public static void main(java.lang.String[] argv) {
		for (int i = 0; i < argv.length; i++) {
			if (argv[i].equals("-vbs") || argv[i].equals("-verbose")) {
				nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.verbMode = true;
				break;
			}
		}
		nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.log1("debuggee started!");
		int exitCode = nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.PASSED;
		label0 : for (int i = 0; ; i++) {
			if (nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.instruction > nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.maxInstr) {
				nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.logErr("ERROR: unexpected instruction: " + nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.instruction);
				exitCode = nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.FAILED;
				break;
			}
			switch (i) {
				case 0 :
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes001aTestClass check = new nsk.jdi.ReferenceType.nestedTypes.nestedtypes001aTestClass();
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.methodForCommunication();
					break;
				default :
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.instruction = nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.end;
					nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.methodForCommunication();
					break label0;
			}
		}
		java.lang.System.exit(exitCode + nsk.jdi.ReferenceType.nestedTypes.nestedtypes001a.PASS_BASE);
	}
}