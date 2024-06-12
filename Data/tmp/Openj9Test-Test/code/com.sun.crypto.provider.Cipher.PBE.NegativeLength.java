public class NegativeLength {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.SecretKeyFactory skf = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1", "SunJCE");
		javax.crypto.spec.PBEKeySpec pbeks = new javax.crypto.spec.PBEKeySpec(new char['p'], new byte[1], 1024, 8);
		java.lang.Class c = pbeks.getClass();
		java.lang.reflect.Field f = c.getDeclaredField("keyLength");
		f.setAccessible(true);
		f.setInt(pbeks, -8);
		java.lang.System.out.println("pbeks.getKeyLength(): " + pbeks.getKeyLength());
		try {
			skf.generateSecret(pbeks);
			throw new java.lang.Exception("We shouldn't get here.");
		} catch (java.security.spec.InvalidKeySpecException ike) {
			java.lang.System.out.println("Test Passed.");
		}
	}
}