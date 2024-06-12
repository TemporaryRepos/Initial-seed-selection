public class HmacMD5 {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		int i;
		int j;
		int n;
		javax.crypto.Mac mac;
		java.security.Provider jce = new com.sun.crypto.provider.SunJCE();
		java.security.Security.addProvider(jce);
		byte[][][] test_data = new byte[][][]{ new byte[][]{ new byte[]{ ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)), ((byte) (0xb)) }, "Hi There".getBytes(), new byte[]{ ((byte) (0x92)), ((byte) (0x94)), ((byte) (0x72)), ((byte) (0x7a)), ((byte) (0x36)), ((byte) (0x38)), ((byte) (0xbb)), ((byte) (0x1c)), ((byte) (0x13)), ((byte) (0xf4)), ((byte) (0x8e)), ((byte) (0xf8)), ((byte) (0x15)), ((byte) (0x8b)), ((byte) (0xfc)), ((byte) (0x9d)) } }, new byte[][]{ "Jefe".getBytes(), "what do ya want for nothing?".getBytes(), new byte[]{ ((byte) (0x75)), ((byte) (0xc)), ((byte) (0x78)), ((byte) (0x3e)), ((byte) (0x6a)), ((byte) (0xb0)), ((byte) (0xb5)), ((byte) (0x3)), ((byte) (0xea)), ((byte) (0xa8)), ((byte) (0x6e)), ((byte) (0x31)), ((byte) (0xa)), ((byte) (0x5d)), ((byte) (0xb7)), ((byte) (0x38)) } }, new byte[][]{ new byte[]{ ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)), ((byte) (0xaa)) }, new byte[]{ ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)), ((byte) (0xdd)) }, new byte[]{ ((byte) (0x56)), ((byte) (0xbe)), ((byte) (0x34)), ((byte) (0x52)), ((byte) (0x1d)), ((byte) (0x14)), ((byte) (0x4c)), ((byte) (0x88)), ((byte) (0xdb)), ((byte) (0xb8)), ((byte) (0xc7)), ((byte) (0x33)), ((byte) (0xf0)), ((byte) (0xe8)), ((byte) (0xb3)), ((byte) (0xf6)) } } };
		mac = javax.crypto.Mac.getInstance("HmacMD5");
		for (i = 0; i < 3; i++) {
			j = 0;
			mac.init(new javax.crypto.spec.SecretKeySpec(test_data[i][j++], "HMAC"));
			byte[] result = mac.doFinal(test_data[i][j++]);
			if (result.length != test_data[i][j].length) {
				throw new java.lang.Exception("Different result length");
			}
			for (n = 0; n < result.length; n++) {
				if (result[n] != test_data[i][j][n]) {
					throw new java.lang.Exception("Different");
				}
			}
		}
		mac = javax.crypto.Mac.getInstance("HmacMD5");
		mac.init(new javax.crypto.spec.SecretKeySpec("Jefe".getBytes(), "HMAC"));
		mac.update("what do ya ".getBytes());
		mac.update("want for ".getBytes());
		mac.update("nothing?".getBytes());
		byte[] result = mac.doFinal();
		if (result.length != test_data[1][2].length) {
			throw new java.lang.Exception("Different result length");
		}
		for (i = 0; i < result.length; i++) {
			if (result[i] != test_data[1][2][i]) {
				throw new java.lang.Exception("Different");
			}
		}
		java.lang.System.out.println("Test SUCCEEDED");
	}
}