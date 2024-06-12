public class PBECryptorTest {
	public static void main(java.lang.String[] args) {
		cn.ponfee.commons.jce.symmetric.PBECryptor.PBEAlgorithm alg = cn.ponfee.commons.jce.symmetric.PBECryptor.PBEAlgorithm.PBEWithSHA1AndDESede;
		char[] pass = "87654321".toCharArray();
		byte[] salt = "12345678".getBytes();
		int iterations = 100;
		cn.ponfee.commons.jce.symmetric.PBECryptor p = cn.ponfee.commons.jce.symmetric.PBECryptorBuilder.newBuilder(alg, pass).mode(Mode.CBC).padding(Padding.PKCS5Padding).parameter(salt, iterations).build();
		byte[] encrypted = p.encrypt("abc".getBytes());
		p = cn.ponfee.commons.jce.symmetric.PBECryptorBuilder.newBuilder(alg, p.getPass()).mode(p.getMode()).padding(p.getPadding()).parameter(p.getSalt(), p.getIterations()).build();
		byte[] decrypted = p.decrypt(encrypted);
		java.lang.System.out.println(new java.lang.String(decrypted));
	}
}