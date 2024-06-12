public class TestHmacSHAOids {
	private static final java.lang.String PROVIDER_NAME = "SunJCE";

	private static final byte[] INPUT = "1234567890".getBytes();

	private static final java.util.List<com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple> DATA = java.util.Arrays.asList(new com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple("1.2.840.113549.2.7", "HmacSHA1"), new com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple("1.2.840.113549.2.8", "HmacSHA224"), new com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple("1.2.840.113549.2.9", "HmacSHA256"), new com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple("1.2.840.113549.2.10", "HmacSHA384"), new com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple("1.2.840.113549.2.11", "HmacSHA512"));

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple dataTuple : com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DATA) {
			com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.runTest(dataTuple);
			java.lang.System.out.println("passed");
		}
		java.lang.System.out.println("All tests passed");
	}

	private static void runTest(com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.DataTuple dataTuple) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.InvalidKeyException {
		javax.crypto.Mac mcAlgorithm = javax.crypto.Mac.getInstance(dataTuple.algorithm, com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.PROVIDER_NAME);
		javax.crypto.Mac mcOid = javax.crypto.Mac.getInstance(dataTuple.oid, com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.PROVIDER_NAME);
		if (mcAlgorithm == null) {
			throw new java.lang.RuntimeException(java.lang.String.format("Test failed: Mac using algorithm " + "string %s getInstance failed.%n", dataTuple.algorithm));
		}
		if (mcOid == null) {
			throw new java.lang.RuntimeException(java.lang.String.format("Test failed: Mac using OID %s getInstance failed.%n", dataTuple.oid));
		}
		if (!mcAlgorithm.getAlgorithm().equals(dataTuple.algorithm)) {
			throw new java.lang.RuntimeException(java.lang.String.format("Test failed: Mac using algorithm string %s getInstance " + "doesn't generate expected algorithm.%n", dataTuple.algorithm));
		}
		javax.crypto.KeyGenerator kg = javax.crypto.KeyGenerator.getInstance(dataTuple.algorithm, com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.PROVIDER_NAME);
		javax.crypto.SecretKey key = kg.generateKey();
		mcAlgorithm.init(key);
		mcAlgorithm.update(com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.INPUT);
		mcOid.init(key);
		mcOid.update(com.sun.crypto.provider.NSASuiteB.TestHmacSHAOids.INPUT);
		if (!java.util.Arrays.equals(mcAlgorithm.doFinal(), mcOid.doFinal())) {
			throw new java.lang.RuntimeException("Digest comparison failed: " + "the two MACs are not the same");
		}
	}

	private static class DataTuple {
		private final java.lang.String oid;

		private final java.lang.String algorithm;

		private DataTuple(java.lang.String oid, java.lang.String algorithm) {
			this.oid = oid;
			this.algorithm = algorithm;
		}
	}
}