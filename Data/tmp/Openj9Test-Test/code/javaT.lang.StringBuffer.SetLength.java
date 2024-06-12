public class SetLength {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		java.lang.StringBuffer active = new java.lang.StringBuffer();
		active.append("first one");
		java.lang.String a = active.toString();
		active.setLength(0);
		active.append("second");
		java.lang.String b = active.toString();
		active.setLength(0);
		java.lang.System.out.println("first: " + a);
		java.lang.System.out.println("second: " + b);
		if (!a.equals("first one")) {
			throw new java.lang.Exception("StringBuffer.setLength() overwrote string");
		}
	}
}