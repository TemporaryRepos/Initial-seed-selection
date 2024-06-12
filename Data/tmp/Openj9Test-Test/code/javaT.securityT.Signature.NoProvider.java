public class NoProvider {
	private static class NoProviderPublicKey implements java.security.PublicKey {
		public java.lang.String getAlgorithm() {
			return "NoProvider";
		}

		public java.lang.String getFormat() {
			return "none";
		}

		public byte[] getEncoded() {
			return new byte[1];
		}
	}

	private static class NoProviderSignature extends java.security.Signature {
		public NoProviderSignature() {
			super("NoProvider");
		}

		protected void engineInitVerify(java.security.PublicKey publicKey) throws java.security.InvalidKeyException {
		}

		protected void engineInitSign(java.security.PrivateKey privateKey) throws java.security.InvalidKeyException {
		}

		protected void engineUpdate(byte b) throws java.security.SignatureException {
		}

		protected void engineUpdate(byte[] b, int off, int len) throws java.security.SignatureException {
		}

		protected byte[] engineSign() throws java.security.SignatureException {
			return new byte[1];
		}

		protected boolean engineVerify(byte[] sigBytes) throws java.security.SignatureException {
			return false;
		}

		@java.lang.Deprecated
		protected void engineSetParameter(java.lang.String param, java.lang.Object value) throws java.security.InvalidParameterException {
		}

		@java.lang.Deprecated
		protected java.lang.Object engineGetParameter(java.lang.String param) throws java.security.InvalidParameterException {
			return null;
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.securityT.Signature.NoProvider.NoProviderSignature().initVerify(new javaT.securityT.Signature.NoProvider.NoProviderPublicKey());
	}
}