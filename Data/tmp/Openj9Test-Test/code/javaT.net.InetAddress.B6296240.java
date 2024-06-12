public class B6296240 {
	public static void main(java.lang.String[] args) {
		java.lang.String[] malformedIPv4s = new java.lang.String[]{ "192.168.1.220..." };
		java.util.BitSet expectedExceptions = new java.util.BitSet(malformedIPv4s.length);
		expectedExceptions.clear();
		for (int i = 0; i < malformedIPv4s.length; i++) {
			try {
				java.net.InetAddress.getAllByName(malformedIPv4s[i]);
			} catch (java.net.UnknownHostException e) {
				expectedExceptions.set(i);
			}
		}
		for (int i = 0; i < malformedIPv4s.length; i++) {
			if (!expectedExceptions.get(i)) {
				java.lang.System.out.println(("getAllByName(\"" + malformedIPv4s[i]) + "\") should throw exception.");
			}
		}
		if (expectedExceptions.cardinality() != malformedIPv4s.length) {
			throw new java.lang.RuntimeException("Failed: some expected UnknownHostExceptions are not thrown.");
		}
	}
}