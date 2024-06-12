public class VerifyCodeUtils {
	public static final java.lang.String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

	public static final java.lang.String V_CODE = "_CODE";

	private static java.util.Random random = new java.util.Random();

	public static class Verify {
		private java.lang.String code;

		private java.lang.Integer value;

		public java.lang.String getCode() {
			return code;
		}

		public void setCode(java.lang.String code) {
			this.code = code;
		}

		public java.lang.Integer getValue() {
			return value;
		}

		public void setValue(java.lang.Integer value) {
			this.value = value;
		}
	}

	public static com.sojson.common.utils.VerifyCodeUtils.Verify generateVerify() {
		int number1 = new java.util.Random().nextInt(10) + 1;
		int number2 = new java.util.Random().nextInt(10) + 1;
		com.sojson.common.utils.VerifyCodeUtils.Verify entity = new com.sojson.common.utils.VerifyCodeUtils.Verify();
		entity.setCode((number1 + " x ") + number2);
		entity.setValue(number1 + number2);
		return entity;
	}

	public static java.lang.String generateVerifyCode(int verifySize) {
		return com.sojson.common.utils.VerifyCodeUtils.generateVerifyCode(verifySize, com.sojson.common.utils.VerifyCodeUtils.VERIFY_CODES);
	}

	public static void clearVerifyCode() {
		com.sojson.core.shiro.token.manager.TokenManager.getSession().removeAttribute(com.sojson.common.utils.VerifyCodeUtils.V_CODE);
	}

	public static boolean verifyCode(java.lang.String code) {
		java.lang.String v = ((java.lang.String) (com.sojson.core.shiro.token.manager.TokenManager.getVal2Session(com.sojson.common.utils.VerifyCodeUtils.V_CODE)));
		return com.sojson.common.utils.StringUtils.equals(v, com.sojson.common.utils.StringUtils.lowerCase(code));
	}

	public static java.lang.String generateVerifyCode(int verifySize, java.lang.String sources) {
		if ((sources == null) || (sources.length() == 0)) {
			sources = com.sojson.common.utils.VerifyCodeUtils.VERIFY_CODES;
		}
		int codesLen = sources.length();
		java.util.Random rand = new java.util.Random(java.lang.System.currentTimeMillis());
		java.lang.StringBuilder verifyCode = new java.lang.StringBuilder(verifySize);
		for (int i = 0; i < verifySize; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}
		return verifyCode.toString();
	}

	public static java.lang.String outputVerifyImage(int w, int h, java.io.File outputFile, int verifySize) throws java.io.IOException {
		java.lang.String verifyCode = com.sojson.common.utils.VerifyCodeUtils.generateVerifyCode(verifySize);
		com.sojson.common.utils.VerifyCodeUtils.outputImage(w, h, outputFile, verifyCode);
		return verifyCode;
	}

	public static java.lang.String outputVerifyImage(int w, int h, java.io.OutputStream os, int verifySize) throws java.io.IOException {
		java.lang.String verifyCode = com.sojson.common.utils.VerifyCodeUtils.generateVerifyCode(verifySize);
		com.sojson.common.utils.VerifyCodeUtils.outputImage(w, h, os, verifyCode);
		return verifyCode;
	}

	public static void outputImage(int w, int h, java.io.File outputFile, java.lang.String code) throws java.io.IOException {
		if (outputFile == null) {
			return;
		}
		java.io.File dir = outputFile.getParentFile();
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			outputFile.createNewFile();
			java.io.FileOutputStream fos = new java.io.FileOutputStream(outputFile);
			com.sojson.common.utils.VerifyCodeUtils.outputImage(w, h, fos, code);
			fos.close();
		} catch (java.io.IOException e) {
			throw e;
		}
	}

	public static void outputImage(int w, int h, java.io.OutputStream os, java.lang.String code) throws java.io.IOException {
		int verifySize = code.length();
		java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(w, h, java.awt.image.BufferedImage.TYPE_INT_RGB);
		java.util.Random rand = new java.util.Random();
		java.awt.Graphics2D g2 = image.createGraphics();
		g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
		java.awt.Color[] colors = new java.awt.Color[5];
		java.awt.Color[] colorSpaces = new java.awt.Color[]{ java.awt.Color.WHITE, java.awt.Color.CYAN, java.awt.Color.GRAY, java.awt.Color.LIGHT_GRAY, java.awt.Color.MAGENTA, java.awt.Color.ORANGE, java.awt.Color.PINK, java.awt.Color.YELLOW };
		float[] fractions = new float[colors.length];
		for (int i = 0; i < colors.length; i++) {
			colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];
			fractions[i] = rand.nextFloat();
		}
		java.util.Arrays.sort(fractions);
		g2.setColor(java.awt.Color.GRAY);
		g2.fillRect(0, 0, w, h);
		java.awt.Color c = com.sojson.common.utils.VerifyCodeUtils.getRandColor(200, 250);
		g2.setColor(c);
		g2.fillRect(0, 2, w, h - 4);
		java.util.Random random = new java.util.Random();
		g2.setColor(com.sojson.common.utils.VerifyCodeUtils.getRandColor(160, 200));
		for (int i = 0; i < 20; i++) {
			int x = random.nextInt(w - 1);
			int y = random.nextInt(h - 1);
			int xl = random.nextInt(6) + 1;
			int yl = random.nextInt(12) + 1;
			g2.drawLine(x, y, (x + xl) + 40, (y + yl) + 20);
		}
		float yawpRate = 0.05F;
		int area = ((int) ((yawpRate * w) * h));
		for (int i = 0; i < area; i++) {
			int x = random.nextInt(w);
			int y = random.nextInt(h);
			int rgb = com.sojson.common.utils.VerifyCodeUtils.getRandomIntColor();
			image.setRGB(x, y, rgb);
		}
		com.sojson.common.utils.VerifyCodeUtils.shear(g2, w, h, c);
		g2.setColor(com.sojson.common.utils.VerifyCodeUtils.getRandColor(100, 160));
		int fontSize = h - 4;
		java.awt.Font font = new java.awt.Font("Algerian", java.awt.Font.ITALIC, fontSize);
		g2.setFont(font);
		char[] chars = code.toCharArray();
		for (int i = 0; i < verifySize; i++) {
			java.awt.geom.AffineTransform affine = new java.awt.geom.AffineTransform();
			affine.setToRotation(((java.lang.Math.PI / 4) * rand.nextDouble()) * (rand.nextBoolean() ? 1 : -1), ((w / verifySize) * i) + (fontSize / 2), h / 2);
			g2.setTransform(affine);
			g2.drawChars(chars, i, 1, (((w - 10) / verifySize) * i) + 5, ((h / 2) + (fontSize / 2)) - 10);
		}
		g2.dispose();
		javax.imageio.ImageIO.write(image, "jpg", os);
	}

	private static java.awt.Color getRandColor(int fc, int bc) {
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + com.sojson.common.utils.VerifyCodeUtils.random.nextInt(bc - fc);
		int g = fc + com.sojson.common.utils.VerifyCodeUtils.random.nextInt(bc - fc);
		int b = fc + com.sojson.common.utils.VerifyCodeUtils.random.nextInt(bc - fc);
		return new java.awt.Color(r, g, b);
	}

	private static int getRandomIntColor() {
		int[] rgb = com.sojson.common.utils.VerifyCodeUtils.getRandomRgb();
		int color = 0;
		for (int c : rgb) {
			color = color << 8;
			color = color | c;
		}
		return color;
	}

	private static int[] getRandomRgb() {
		int[] rgb = new int[3];
		for (int i = 0; i < 3; i++) {
			rgb[i] = com.sojson.common.utils.VerifyCodeUtils.random.nextInt(255);
		}
		return rgb;
	}

	private static void shear(java.awt.Graphics g, int w1, int h1, java.awt.Color color) {
		com.sojson.common.utils.VerifyCodeUtils.shearX(g, w1, h1, color);
		com.sojson.common.utils.VerifyCodeUtils.shearY(g, w1, h1, color);
	}

	private static void shearX(java.awt.Graphics g, int w1, int h1, java.awt.Color color) {
		int period = com.sojson.common.utils.VerifyCodeUtils.random.nextInt(2);
		boolean borderGap = true;
		int frames = 1;
		int phase = com.sojson.common.utils.VerifyCodeUtils.random.nextInt(2);
		for (int i = 0; i < h1; i++) {
			double d = ((double) (period >> 1)) * java.lang.Math.sin((((double) (i)) / ((double) (period))) + ((6.283185307179586 * ((double) (phase))) / ((double) (frames))));
			g.copyArea(0, i, w1, 1, ((int) (d)), 0);
			if (borderGap) {
				g.setColor(color);
				g.drawLine(((int) (d)), i, 0, i);
				g.drawLine(((int) (d)) + w1, i, w1, i);
			}
		}
	}

	private static void shearY(java.awt.Graphics g, int w1, int h1, java.awt.Color color) {
		int period = com.sojson.common.utils.VerifyCodeUtils.random.nextInt(40) + 10;
		boolean borderGap = true;
		int frames = 20;
		int phase = 7;
		for (int i = 0; i < w1; i++) {
			double d = ((double) (period >> 1)) * java.lang.Math.sin((((double) (i)) / ((double) (period))) + ((6.283185307179586 * ((double) (phase))) / ((double) (frames))));
			g.copyArea(i, 0, 1, h1, 0, ((int) (d)));
			if (borderGap) {
				g.setColor(color);
				g.drawLine(i, ((int) (d)), i, 0);
				g.drawLine(i, ((int) (d)) + h1, i, h1);
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.io.File dir = new java.io.File("F:/verifies");
		int w = 200;
		int h = 80;
		for (int i = 0; i < 50; i++) {
			java.lang.String verifyCode = com.sojson.common.utils.VerifyCodeUtils.generateVerifyCode(4);
			java.io.File file = new java.io.File(dir, verifyCode + ".jpg");
			com.sojson.common.utils.VerifyCodeUtils.outputImage(w, h, file, verifyCode);
		}
	}
}