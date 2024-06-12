public class DSASignerTest {
	public static void main(java.lang.String[] args) {
		cn.ponfee.commons.jce.Providers.set(Providers.BC);
		org.apache.commons.lang3.tuple.Pair<java.security.interfaces.DSAPublicKey, java.security.interfaces.DSAPrivateKey> keyPair = cn.ponfee.commons.jce.security.DSASigner.initKey();
		byte[] data = "123456".getBytes();
		byte[] signed = cn.ponfee.commons.jce.security.DSASigner.sign(data, keyPair.getRight());
		boolean flag = cn.ponfee.commons.jce.security.DSASigner.verify(data, keyPair.getLeft(), signed);
		java.lang.System.out.println(flag);
	}
}