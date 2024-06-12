public class allclasses001a {
	static final int PASSED = 0;

	static final int FAILED = 2;

	static final int PASS_BASE = 95;

	static boolean verbMode = false;

	private static void log1(java.lang.String message) {
		if (nsk.jdi.VirtualMachine.allClasses.allclasses001a.verbMode) {
			java.lang.System.out.println("**> debuggee: " + message);
		}
	}

	private static void logErr(java.lang.String message) {
		if (nsk.jdi.VirtualMachine.allClasses.allclasses001a.verbMode) {
			java.lang.System.out.println("!!**> debuggee: " + message);
		}
	}

	static int instruction = 1;

	static int end = 0;

	static int maxInstr = 1;

	static int lineForComm = 2;

	private static void methodForCommunication() {
		int i1 = nsk.jdi.VirtualMachine.allClasses.allclasses001a.instruction;
		int i2 = i1;
		int i3 = i2;
	}

	public static void main(java.lang.String[] argv) {
		for (int i = 0; i < argv.length; i++) {
			if (argv[i].equals("-vbs") || argv[i].equals("-verbose")) {
				nsk.jdi.VirtualMachine.allClasses.allclasses001a.verbMode = true;
				break;
			}
		}
		nsk.jdi.VirtualMachine.allClasses.allclasses001a.log1("debuggee started!");
		int exitCode = nsk.jdi.VirtualMachine.allClasses.allclasses001a.PASSED;
		label0 : for (int i = 0; ; i++) {
			nsk.jdi.VirtualMachine.allClasses.Class1ForCheck obj11;
			nsk.jdi.VirtualMachine.allClasses.Class2ForCheck obj21;
			nsk.jdi.VirtualMachine.allClasses.Class2ForCheck obj22;
			nsk.jdi.VirtualMachine.allClasses.Class3ForCheck obj31;
			if ((nsk.jdi.VirtualMachine.allClasses.allclasses001a.instruction > nsk.jdi.VirtualMachine.allClasses.allclasses001a.maxInstr) || (nsk.jdi.VirtualMachine.allClasses.allclasses001a.instruction < 0)) {
				nsk.jdi.VirtualMachine.allClasses.allclasses001a.logErr("ERROR: unexpected instruction: " + nsk.jdi.VirtualMachine.allClasses.allclasses001a.instruction);
				exitCode = nsk.jdi.VirtualMachine.allClasses.allclasses001a.FAILED;
				break;
			}
			switch (i) {
				case 0 :
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break;
				case 1 :
					obj11 = new nsk.jdi.VirtualMachine.allClasses.Class1ForCheck();
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break;
				case 2 :
					obj21 = new nsk.jdi.VirtualMachine.allClasses.Class2ForCheck();
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break;
				case 3 :
					obj22 = new nsk.jdi.VirtualMachine.allClasses.Class2ForCheck();
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break;
				case 4 :
					obj31 = new nsk.jdi.VirtualMachine.allClasses.Class3ForCheck();
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break;
				default :
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.instruction = nsk.jdi.VirtualMachine.allClasses.allclasses001a.end;
					nsk.jdi.VirtualMachine.allClasses.allclasses001a.methodForCommunication();
					break label0;
			}
		}
		java.lang.System.exit(exitCode + nsk.jdi.VirtualMachine.allClasses.allclasses001a.PASS_BASE);
	}
}