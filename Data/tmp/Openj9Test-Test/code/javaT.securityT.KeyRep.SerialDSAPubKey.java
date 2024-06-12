public class SerialDSAPubKey {
	private static final java.lang.String SUN = "SUN";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.KeyPairGenerator kpg = java.security.KeyPairGenerator.getInstance("DSA", javaT.securityT.KeyRep.SerialDSAPubKey.SUN);
		kpg.initialize(512);
		java.security.KeyPair dsaKp = kpg.genKeyPair();
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(dsaKp);
		oos.close();
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(baos.toByteArray()));
		java.security.KeyPair dsaKp2 = ((java.security.KeyPair) (ois.readObject()));
		ois.close();
		if ((!dsaKp2.getPublic().equals(dsaKp.getPublic())) || (!dsaKp2.getPrivate().equals(dsaKp.getPrivate()))) {
			throw new java.lang.SecurityException("DSA test failed");
		}
	}
}