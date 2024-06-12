public class RgbHsvConversion {
	public static void main(java.lang.String[] args) {
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(0, 0, 0), new int[]{ 0, 0, 0 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(0, 0, 1), new int[]{ 255, 255, 255 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(0, 1, 1), new int[]{ 255, 0, 0 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(60, 1, 1), new int[]{ 255, 255, 0 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(120, 1, 1), new int[]{ 0, 255, 0 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(240, 1, 1), new int[]{ 0, 0, 255 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(300, 1, 1), new int[]{ 255, 0, 255 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(180, 0.5, 0.5), new int[]{ 64, 128, 128 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(234, 0.14, 0.88), new int[]{ 193, 196, 224 });
		assert java.util.Arrays.equals(com.thealgorithms.conversions.RgbHsvConversion.hsvToRgb(330, 0.75, 0.5), new int[]{ 128, 32, 80 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(0, 0, 0), new double[]{ 0, 0, 0 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(255, 255, 255), new double[]{ 0, 0, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(255, 0, 0), new double[]{ 0, 1, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(255, 255, 0), new double[]{ 60, 1, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(0, 255, 0), new double[]{ 120, 1, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(0, 0, 255), new double[]{ 240, 1, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(255, 0, 255), new double[]{ 300, 1, 1 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(64, 128, 128), new double[]{ 180, 0.5, 0.5 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(193, 196, 224), new double[]{ 234, 0.14, 0.88 });
		assert com.thealgorithms.conversions.RgbHsvConversion.approximatelyEqualHsv(com.thealgorithms.conversions.RgbHsvConversion.rgbToHsv(128, 32, 80), new double[]{ 330, 0.75, 0.5 });
	}

	public static int[] hsvToRgb(double hue, double saturation, double value) {
		if ((hue < 0) || (hue > 360)) {
			throw new java.lang.IllegalArgumentException("hue should be between 0 and 360");
		}
		if ((saturation < 0) || (saturation > 1)) {
			throw new java.lang.IllegalArgumentException("saturation should be between 0 and 1");
		}
		if ((value < 0) || (value > 1)) {
			throw new java.lang.IllegalArgumentException("value should be between 0 and 1");
		}
		double chroma = value * saturation;
		double hueSection = hue / 60;
		double secondLargestComponent = chroma * (1 - java.lang.Math.abs((hueSection % 2) - 1));
		double matchValue = value - chroma;
		return com.thealgorithms.conversions.RgbHsvConversion.getRgbBySection(hueSection, chroma, matchValue, secondLargestComponent);
	}

	public static double[] rgbToHsv(int red, int green, int blue) {
		if ((red < 0) || (red > 255)) {
			throw new java.lang.IllegalArgumentException("red should be between 0 and 255");
		}
		if ((green < 0) || (green > 255)) {
			throw new java.lang.IllegalArgumentException("green should be between 0 and 255");
		}
		if ((blue < 0) || (blue > 255)) {
			throw new java.lang.IllegalArgumentException("blue should be between 0 and 255");
		}
		double dRed = ((double) (red)) / 255;
		double dGreen = ((double) (green)) / 255;
		double dBlue = ((double) (blue)) / 255;
		double value = java.lang.Math.max(java.lang.Math.max(dRed, dGreen), dBlue);
		double chroma = value - java.lang.Math.min(java.lang.Math.min(dRed, dGreen), dBlue);
		double saturation = (value == 0) ? 0 : chroma / value;
		double hue;
		if (chroma == 0) {
			hue = 0;
		} else if (value == dRed) {
			hue = 60 * (0 + ((dGreen - dBlue) / chroma));
		} else if (value == dGreen) {
			hue = 60 * (2 + ((dBlue - dRed) / chroma));
		} else {
			hue = 60 * (4 + ((dRed - dGreen) / chroma));
		}
		hue = (hue + 360) % 360;
		return new double[]{ hue, saturation, value };
	}

	private static boolean approximatelyEqualHsv(double[] hsv1, double[] hsv2) {
		boolean bHue = java.lang.Math.abs(hsv1[0] - hsv2[0]) < 0.2;
		boolean bSaturation = java.lang.Math.abs(hsv1[1] - hsv2[1]) < 0.002;
		boolean bValue = java.lang.Math.abs(hsv1[2] - hsv2[2]) < 0.002;
		return (bHue && bSaturation) && bValue;
	}

	private static int[] getRgbBySection(double hueSection, double chroma, double matchValue, double secondLargestComponent) {
		int red;
		int green;
		int blue;
		if ((hueSection >= 0) && (hueSection <= 1)) {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
		} else if ((hueSection > 1) && (hueSection <= 2)) {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
		} else if ((hueSection > 2) && (hueSection <= 3)) {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
		} else if ((hueSection > 3) && (hueSection <= 4)) {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
		} else if ((hueSection > 4) && (hueSection <= 5)) {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
		} else {
			red = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(chroma + matchValue);
			green = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(matchValue);
			blue = com.thealgorithms.conversions.RgbHsvConversion.convertToInt(secondLargestComponent + matchValue);
		}
		return new int[]{ red, green, blue };
	}

	private static int convertToInt(double input) {
		return ((int) (java.lang.Math.round(255 * input)));
	}
}