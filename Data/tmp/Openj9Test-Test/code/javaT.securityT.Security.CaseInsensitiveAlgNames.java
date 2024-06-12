public class CaseInsensitiveAlgNames {
	public static void main(java.lang.String[] args) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA");
		md = java.security.MessageDigest.getInstance("sha");
		md = java.security.MessageDigest.getInstance("Sha-1");
		md = java.security.MessageDigest.getInstance("shA1");
		md = java.security.MessageDigest.getInstance("SHA", "SUN");
		md = java.security.MessageDigest.getInstance("sha", "SUN");
		md = java.security.MessageDigest.getInstance("Sha-1", "SUN");
		md = java.security.MessageDigest.getInstance("shA1", "SUN");
		java.security.KeyPairGenerator kGen = java.security.KeyPairGenerator.getInstance("DSA");
		kGen = java.security.KeyPairGenerator.getInstance("dsa");
		kGen = java.security.KeyPairGenerator.getInstance("dSA");
		kGen = java.security.KeyPairGenerator.getInstance("OId.1.2.840.10040.4.1");
		kGen = java.security.KeyPairGenerator.getInstance("1.2.840.10040.4.1");
		kGen = java.security.KeyPairGenerator.getInstance("DSA", "SUN");
		kGen = java.security.KeyPairGenerator.getInstance("dsa", "SUN");
		kGen = java.security.KeyPairGenerator.getInstance("dSA", "SUN");
		kGen = java.security.KeyPairGenerator.getInstance("OId.1.2.840.10040.4.1", "SUN");
		kGen = java.security.KeyPairGenerator.getInstance("1.2.840.10040.4.1", "SUN");
	}
}