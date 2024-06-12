public class BytecodeRun {
	public static void main(java.lang.String[] args) {
		java.lang.String input = "    0x0000000: 121a 121c b600 2099 0022 b200 26b2 0026\n" + ((("    0x0000010: b200 2b04 bc0a 5903 044f b600 2fb6 0033\n" + "    0x0000020: c000 35b6 0039 a700 22b2 003e b600 42b2\n") + "    0x0000030: 0026 b200 2b04 bc0a 5903 044f b600 2fb6\n") + "    0x0000040: 0033 c000 35b6 0047 b0");
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		java.lang.String[] lines = input.split("\n");
		for (java.lang.String item : lines) {
			java.lang.System.out.println(item.trim());
			java.lang.String[] array = item.split(":");
			sb.append(array[1]);
		}
		java.lang.String bytecodeHexStr = sb.toString().replaceAll("\\s", "");
		java.lang.System.out.println(lsieun.cst.Const.DIVISION_LINE);
		byte[] bytes = lsieun.utils.HexUtils.parse(bytecodeHexStr);
		lsieun.classfile.InsnRaw insnRaw = new lsieun.classfile.InsnRaw(bytes);
		java.util.List<java.lang.String> instructions = insnRaw.getList();
		for (java.lang.String item : instructions) {
			java.lang.System.out.println(item);
		}
	}
}