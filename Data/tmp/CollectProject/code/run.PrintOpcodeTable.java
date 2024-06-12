public class PrintOpcodeTable {
	private static int start = 0;

	private static int stop = 256;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		run.PrintOpcodeTable.printOpcode();
	}

	public static void printOpcode() {
		if (run.PrintOpcodeTable.start < 0) {
			run.PrintOpcodeTable.start = 0;
		}
		if (run.PrintOpcodeTable.stop > 256) {
			run.PrintOpcodeTable.stop = 256;
		}
		int num = run.PrintOpcodeTable.stop - run.PrintOpcodeTable.start;
		int column = 4;
		int row = num / column;
		int remainder = num % column;
		if (remainder != 0) {
			row++;
		}
		java.lang.System.out.println("| opcode | mnemonic symbol | opcode | mnemonic symbol | opcode | mnemonic symbol | opcode | mnemonic symbol |");
		java.lang.System.out.println("|--------|-----------------|--------|-----------------|--------|-----------------|--------|-----------------|");
		for (int i = 0; i < row; i++) {
			int val1 = run.PrintOpcodeTable.start + i;
			int val2 = val1 + row;
			int val3 = val2 + row;
			int val4 = val3 + row;
			java.lang.String line = java.lang.String.format("| %-6d | %-15s | %-6d | %-15s | %-6d | %-15s | %-6d | %-15s |", val1, run.PrintOpcodeTable.getOpcodeName(val1), val2, run.PrintOpcodeTable.getOpcodeName(val2), val3, run.PrintOpcodeTable.getOpcodeName(val3), val4, run.PrintOpcodeTable.getOpcodeName(val4));
			java.lang.System.out.println(line);
		}
	}

	public static java.lang.String getOpcodeName(int i) {
		if ((i < 0) || (i >= lsieun.utils.OpcodeConst.OPCODE_NAMES_LENGTH)) {
			return "";
		}
		if ((i < run.PrintOpcodeTable.start) || (i >= run.PrintOpcodeTable.stop)) {
			return "";
		}
		java.lang.String opcodeName = lsieun.utils.OpcodeConst.getOpcodeName(i);
		if (lsieun.utils.OpcodeConst.ILLEGAL_OPCODE.equals(opcodeName)) {
			opcodeName = "";
		}
		return opcodeName;
	}
}