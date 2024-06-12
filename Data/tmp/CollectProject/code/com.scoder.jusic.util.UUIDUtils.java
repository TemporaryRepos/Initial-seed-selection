public class UUIDUtils {
	public static java.lang.String[] chars = new java.lang.String[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	public static java.lang.String getUUID8Len(java.lang.String uuid) {
		uuid = uuid.replace("-", "");
		java.lang.StringBuffer shortBuffer = new java.lang.StringBuffer();
		for (int i = 0; i < 8; i++) {
			java.lang.String str = uuid.substring(i * 4, (i * 4) + 4);
			int x = java.lang.Integer.parseInt(str, 16);
			shortBuffer.append(com.scoder.jusic.util.UUIDUtils.chars[x % 0x3e]);
		}
		return shortBuffer.toString();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.scoder.jusic.util.UUIDUtils.getUUID8Len("88081313-9074-7b5c-068c-c6a813ce3601"));
	}
}