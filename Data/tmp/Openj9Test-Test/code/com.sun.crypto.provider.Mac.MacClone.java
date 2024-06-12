public class MacClone {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String[] algos = new java.lang.String[]{ "HmacMD5", "HmacSHA1", "HmacSHA224", "HmacSHA256", "HmacSHA384", "HmacSHA512" };
		javax.crypto.KeyGenerator kgen = javax.crypto.KeyGenerator.getInstance("DES");
		javax.crypto.SecretKey skey = kgen.generateKey();
		for (java.lang.String algo : algos) {
			com.sun.crypto.provider.Mac.MacClone.doTest(algo, skey, null);
		}
		java.lang.String[] algos2 = new java.lang.String[]{ "HmacPBESHA1", "PBEWithHmacSHA1", "PBEWithHmacSHA224", "PBEWithHmacSHA256", "PBEWithHmacSHA384", "PBEWithHmacSHA512" };
		skey = new javax.crypto.spec.SecretKeySpec("whatever".getBytes(), "PBE");
		javax.crypto.spec.PBEParameterSpec params = new javax.crypto.spec.PBEParameterSpec("1234567890".getBytes(), 500);
		for (java.lang.String algo : algos2) {
			com.sun.crypto.provider.Mac.MacClone.doTest(algo, skey, params);
		}
		java.lang.System.out.println("Test Passed");
	}

	private static void doTest(java.lang.String algo, javax.crypto.SecretKey skey, java.security.spec.AlgorithmParameterSpec params) throws java.lang.Exception {
		javax.crypto.Mac mac = javax.crypto.Mac.getInstance(algo, "SunJCE");
		javax.crypto.Mac macClone = ((javax.crypto.Mac) (mac.clone()));
		java.lang.System.out.println(macClone.getProvider().toString());
		java.lang.System.out.println(macClone.getAlgorithm());
		boolean thrown = false;
		try {
			macClone.update(((byte) (0x12)));
		} catch (java.lang.IllegalStateException ise) {
			thrown = true;
		}
		if (!thrown) {
			throw new java.lang.Exception("Expected IllegalStateException not thrown");
		}
		mac = javax.crypto.Mac.getInstance(algo, "SunJCE");
		mac.init(skey, params);
		macClone = ((javax.crypto.Mac) (mac.clone()));
		java.lang.System.out.println(macClone.getProvider().toString());
		java.lang.System.out.println(macClone.getAlgorithm());
		mac.update(((byte) (0x12)));
		macClone.update(((byte) (0x12)));
		byte[] macFinal = mac.doFinal();
		byte[] macCloneFinal = macClone.doFinal();
		if (!java.util.Arrays.equals(macFinal, macCloneFinal)) {
			throw new java.lang.Exception("ERROR: MAC result of init clone is different");
		} else {
			java.lang.System.out.println("MAC check#1 passed");
		}
		mac.update(((byte) (0x12)));
		macClone = ((javax.crypto.Mac) (mac.clone()));
		mac.update(((byte) (0x34)));
		macClone.update(((byte) (0x34)));
		macFinal = mac.doFinal();
		macCloneFinal = macClone.doFinal();
		if (!java.util.Arrays.equals(macFinal, macCloneFinal)) {
			throw new java.lang.Exception("ERROR: MAC result of updated clone is different");
		} else {
			java.lang.System.out.println("MAC check#2 passed");
		}
	}
}