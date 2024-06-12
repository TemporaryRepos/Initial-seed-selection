public class PBEKeyTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.crypto.SecretKeyFactory fac = javax.crypto.SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		char[] pass = new char[]{ 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
		javax.crypto.spec.PBEKeySpec spec = new javax.crypto.spec.PBEKeySpec(pass);
		javax.crypto.SecretKey skey = fac.generateSecret(spec);
		java.security.spec.KeySpec spec1 = fac.getKeySpec(skey, javax.crypto.spec.PBEKeySpec.class);
		javax.crypto.SecretKey skey1 = fac.generateSecret(spec1);
		if (!skey.equals(skey1)) {
			throw new java.lang.Exception("Equal keys not equal");
		}
		java.lang.System.out.println(new java.lang.String(((javax.crypto.spec.PBEKeySpec) (spec1)).getPassword()));
		pass = new char[]{ 'p', 'a', 's', 's', 'w', 'o', 'r', '\u0019' };
		spec = new javax.crypto.spec.PBEKeySpec(pass);
		try {
			skey = fac.generateSecret(spec);
			throw new java.lang.Exception("Expected exception not thrown");
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Expected exception thrown");
		}
	}
}