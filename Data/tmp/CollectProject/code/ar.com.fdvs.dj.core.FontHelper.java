public class FontHelper {
	private static java.awt.Graphics graphics = new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_RGB).getGraphics();

	public static int getHeightFor(ar.com.fdvs.dj.domain.constants.Font font) {
		java.awt.FontMetrics fm = ar.com.fdvs.dj.core.FontHelper.getFontMetric(font);
		return fm.getHeight();
	}

	public static int getWidthFor(ar.com.fdvs.dj.domain.constants.Font font, java.lang.String text) {
		java.awt.FontMetrics fm = ar.com.fdvs.dj.core.FontHelper.getFontMetric(font);
		return fm.stringWidth(text);
	}

	private static java.awt.FontMetrics getFontMetric(ar.com.fdvs.dj.domain.constants.Font font) {
		java.awt.Font awtFont = java.awt.Font.decode(font.getStandardFontname());
		return ar.com.fdvs.dj.core.FontHelper.graphics.getFontMetrics(awtFont);
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(ar.com.fdvs.dj.core.FontHelper.getWidthFor(ar.com.fdvs.dj.domain.constants.Font.ARIAL_MEDIUM, "Ale Gomez"));
	}
}