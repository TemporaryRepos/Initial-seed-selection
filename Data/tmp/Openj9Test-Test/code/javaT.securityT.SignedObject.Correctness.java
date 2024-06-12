public class Correctness {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String SIGALG = "SHA1withRSA";
		java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("RSA");
		java.security.KeyPair kp = kpg.generateKeyPair();
		java.security.SignedObject so1 = new java.security.SignedObject("Hello", kp.getPrivate(), java.security.Signature.getInstance(SIGALG));
		java.io.ByteArrayOutputStream byteOut = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(byteOut);
		out.writeObject(so1);
		out.close();
		byte[] data = byteOut.toByteArray();
		java.security.SignedObject so2 = ((java.security.SignedObject) (new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(data)).readObject()));
		if (!so2.getObject().equals("Hello")) {
			throw new java.lang.Exception("Content changed");
		}
		if (!so2.getAlgorithm().equals(SIGALG)) {
			throw new java.lang.Exception("Signature algorithm unknown");
		}
		if (!so2.verify(kp.getPublic(), java.security.Signature.getInstance(SIGALG))) {
			throw new java.lang.Exception("Not verified");
		}
	}
}