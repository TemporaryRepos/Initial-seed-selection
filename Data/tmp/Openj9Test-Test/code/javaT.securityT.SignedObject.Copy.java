public class Copy {
	private static final java.lang.String DSA = "DSA";

	private static final int KEY_SIZE = 512;

	private static final int MAGIC = 123;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.KeyPairGenerator kg = java.security.KeyPairGenerator.getInstance(javaT.securityT.SignedObject.Copy.DSA);
		kg.initialize(javaT.securityT.SignedObject.Copy.KEY_SIZE);
		java.security.KeyPair kp = kg.genKeyPair();
		java.security.Signature signature = java.security.Signature.getInstance(javaT.securityT.SignedObject.Copy.DSA);
		javaT.securityT.SignedObject.Copy.Test original = new javaT.securityT.SignedObject.Copy.Test();
		java.security.SignedObject so = new java.security.SignedObject(original, kp.getPrivate(), signature);
		java.lang.System.out.println("Signature algorithm: " + so.getAlgorithm());
		signature = java.security.Signature.getInstance(javaT.securityT.SignedObject.Copy.DSA, "SUN");
		if (!so.verify(kp.getPublic(), signature)) {
			throw new java.lang.RuntimeException("Verification failed");
		}
		kg = java.security.KeyPairGenerator.getInstance(javaT.securityT.SignedObject.Copy.DSA);
		kg.initialize(javaT.securityT.SignedObject.Copy.KEY_SIZE);
		kp = kg.genKeyPair();
		if (so.verify(kp.getPublic(), signature)) {
			throw new java.lang.RuntimeException("Unexpected success");
		}
		java.lang.Object copy = so.getObject();
		if (!original.equals(copy)) {
			throw new java.lang.RuntimeException(("Signed object is not equal " + "to original one: ") + copy);
		}
		original.set(javaT.securityT.SignedObject.Copy.MAGIC - 1);
		copy = so.getObject();
		if (original.equals(copy)) {
			throw new java.lang.RuntimeException(("Signed object is not a copy " + "of original one: ") + copy);
		}
		java.lang.System.out.println("Test passed");
	}

	private static class Test implements java.io.Serializable {
		private int number = javaT.securityT.SignedObject.Copy.MAGIC;

		public int get() {
			return number;
		}

		public void set(int magic) {
			this.number = magic;
		}

		@java.lang.Override
		public int hashCode() {
			return number;
		}

		@java.lang.Override
		public boolean equals(java.lang.Object obj) {
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof javaT.securityT.SignedObject.Copy.Test)) {
				return false;
			}
			javaT.securityT.SignedObject.Copy.Test other = ((javaT.securityT.SignedObject.Copy.Test) (obj));
			return number == other.number;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return "" + number;
		}
	}
}