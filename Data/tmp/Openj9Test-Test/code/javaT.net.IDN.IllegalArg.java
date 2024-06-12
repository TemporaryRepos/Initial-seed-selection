public class IllegalArg {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] illegalNames = new java.lang.String[]{ "com..net", "com..", ".com", ".com." };
		java.lang.String[] legalNames = new java.lang.String[]{ "example.com", "com。", "com.", "." };
		for (java.lang.String name : illegalNames) {
			try {
				java.net.IDN.toASCII(name, java.net.IDN.USE_STD3_ASCII_RULES);
				throw new java.lang.Exception("Expected to get IllegalArgumentException for " + name);
			} catch (java.lang.IllegalArgumentException iae) {
			}
			try {
				java.net.IDN.toASCII(name);
				throw new java.lang.Exception("Expected to get IllegalArgumentException for " + name);
			} catch (java.lang.IllegalArgumentException iae) {
			}
		}
		for (java.lang.String name : legalNames) {
			java.lang.System.out.println("Convering " + name);
			java.lang.System.out.println(java.net.IDN.toASCII(name, java.net.IDN.USE_STD3_ASCII_RULES));
		}
	}
}