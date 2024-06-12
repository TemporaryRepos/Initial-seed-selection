public class UseSTD3ASCIIRules {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] illegalNames = new java.lang.String[]{ "www.example.com-", "-www.example.com", "-www.example.com-", "www.ex,mple.com", "www.ex{mple.com", "www.ex\u007fmple.com" };
		java.lang.String[] legalNames = new java.lang.String[]{ "www.ex-ample.com", "www.ex-mple.com", "www.exzmple.com", "www.exあmple.com", "www.あいう.com", "www.示例.com" };
		for (java.lang.String name : illegalNames) {
			try {
				java.lang.System.out.println("Convering illegal IDN: " + name);
				java.net.IDN.toASCII(name, java.net.IDN.USE_STD3_ASCII_RULES);
				throw new java.lang.Exception("Expected to get IllegalArgumentException for " + name);
			} catch (java.lang.IllegalArgumentException iae) {
			}
		}
		for (java.lang.String name : legalNames) {
			java.lang.System.out.println("Convering legal IDN: " + name);
			java.lang.System.out.println("\tThe ACE form is: " + java.net.IDN.toASCII(name, java.net.IDN.USE_STD3_ASCII_RULES));
		}
	}
}