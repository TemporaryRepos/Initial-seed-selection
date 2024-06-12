public class ColorContrastRatio {
	public double getContrastRatio(java.awt.Color a, java.awt.Color b) {
		final double aColorLuminance = getRelativeLuminance(a);
		final double bColorLuminance = getRelativeLuminance(b);
		if (aColorLuminance > bColorLuminance) {
			return (aColorLuminance + 0.05) / (bColorLuminance + 0.05);
		}
		return (bColorLuminance + 0.05) / (aColorLuminance + 0.05);
	}

	public double getRelativeLuminance(java.awt.Color color) {
		final double red = getColor(color.getRed());
		final double green = getColor(color.getGreen());
		final double blue = getColor(color.getBlue());
		return ((0.2126 * red) + (0.7152 * green)) + (0.0722 * blue);
	}

	public double getColor(int color8Bit) {
		final double sRgb = getColorSRgb(color8Bit);
		return sRgb <= 0.03928 ? sRgb / 12.92 : java.lang.Math.pow((sRgb + 0.055) / 1.055, 2.4);
	}

	private double getColorSRgb(double color8Bit) {
		return color8Bit / 255.0;
	}

	private static void test() {
		final com.thealgorithms.misc.ColorContrastRatio algImpl = new com.thealgorithms.misc.ColorContrastRatio();
		final java.awt.Color black = java.awt.Color.BLACK;
		final double blackLuminance = algImpl.getRelativeLuminance(black);
		assert blackLuminance == 0 : "Test 1 Failed - Incorrect relative luminance.";
		final java.awt.Color white = java.awt.Color.WHITE;
		final double whiteLuminance = algImpl.getRelativeLuminance(white);
		assert whiteLuminance == 1 : "Test 2 Failed - Incorrect relative luminance.";
		final double highestColorRatio = algImpl.getContrastRatio(black, white);
		assert highestColorRatio == 21 : "Test 3 Failed - Incorrect contrast ratio.";
		final java.awt.Color foreground = new java.awt.Color(23, 103, 154);
		final double foregroundLuminance = algImpl.getRelativeLuminance(foreground);
		assert foregroundLuminance == 0.12215748057375966 : "Test 4 Failed - Incorrect relative luminance.";
		final java.awt.Color background = new java.awt.Color(226, 229, 248);
		final double backgroundLuminance = algImpl.getRelativeLuminance(background);
		assert backgroundLuminance == 0.7898468477881603 : "Test 5 Failed - Incorrect relative luminance.";
		final double contrastRatio = algImpl.getContrastRatio(foreground, background);
		assert contrastRatio == 4.878363954846178 : "Test 6 Failed - Incorrect contrast ratio.";
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.misc.ColorContrastRatio.test();
	}
}