public class SimpleGraphics extends java.awt.Graphics2D {
	private final java.awt.image.BufferedImage image;

	private java.awt.Color background;

	private java.awt.Color color;

	private int[] pixels;

	private int tx;

	private int ty;

	public SimpleGraphics(java.awt.image.BufferedImage image) {
		this.image = image;
		this.pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
	}

	@java.lang.Override
	public void draw(java.awt.Shape s) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, java.awt.geom.AffineTransform xform, java.awt.image.ImageObserver obs) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawImage(java.awt.image.BufferedImage img, java.awt.image.BufferedImageOp op, int x, int y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawRenderedImage(java.awt.image.RenderedImage img, java.awt.geom.AffineTransform xform) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawRenderableImage(java.awt.image.renderable.RenderableImage img, java.awt.geom.AffineTransform xform) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawString(java.lang.String str, int x, int y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawString(java.lang.String str, float x, float y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawString(java.text.AttributedCharacterIterator iterator, int x, int y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawString(java.text.AttributedCharacterIterator iterator, float x, float y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawGlyphVector(java.awt.font.GlyphVector g, float x, float y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void fill(java.awt.Shape s) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public boolean hit(java.awt.Rectangle rect, java.awt.Shape s, boolean onStroke) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.GraphicsConfiguration getDeviceConfiguration() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setComposite(java.awt.Composite comp) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setPaint(java.awt.Paint paint) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setStroke(java.awt.Stroke s) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setRenderingHint(java.awt.RenderingHints.Key hintKey, java.lang.Object hintValue) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.lang.Object getRenderingHint(java.awt.RenderingHints.Key hintKey) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setRenderingHints(java.util.Map<?, ?> hints) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void addRenderingHints(java.util.Map<?, ?> hints) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.RenderingHints getRenderingHints() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void translate(int tx, int ty) {
		this.tx += tx;
		this.ty += ty;
	}

	@java.lang.Override
	public void translate(double tx, double ty) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void rotate(double theta) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void rotate(double theta, double x, double y) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void scale(double sx, double sy) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void shear(double shx, double shy) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void transform(java.awt.geom.AffineTransform Tx) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setTransform(java.awt.geom.AffineTransform Tx) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.geom.AffineTransform getTransform() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Paint getPaint() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Composite getComposite() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setBackground(java.awt.Color color) {
		this.background = color;
	}

	@java.lang.Override
	public java.awt.Color getBackground() {
		return background;
	}

	@java.lang.Override
	public java.awt.Stroke getStroke() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void clip(java.awt.Shape s) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.font.FontRenderContext getFontRenderContext() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Graphics create() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Color getColor() {
		return this.color;
	}

	@java.lang.Override
	public void setColor(java.awt.Color c) {
		this.color = c;
	}

	@java.lang.Override
	public void setPaintMode() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setXORMode(java.awt.Color c1) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Font getFont() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setFont(java.awt.Font font) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.FontMetrics getFontMetrics(java.awt.Font f) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Rectangle getClipBounds() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void clipRect(int x, int y, int width, int height) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setClip(int x, int y, int width, int height) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public java.awt.Shape getClip() {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void setClip(java.awt.Shape clip) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	protected void setPixel(int x, int y, int rgb) {
		x += tx;
		y += ty;
		if ((((x >= 0) && (y >= 0)) && (x < image.getWidth())) && (y < image.getHeight())) {
			int offset = (y * image.getWidth()) + x;
			int d_alpha = pixels[offset] >>> 24;
			int s_alpha = rgb >>> 24;
			if (d_alpha == 0) {
				pixels[offset] = rgb;
			} else if (s_alpha != 0) {
				int r_alpha = s_alpha + ((d_alpha * (255 - s_alpha)) / 256);
				int r_pixel = 0;
				for (int i = 0; i < 3; i++) {
					int s_component = (rgb >>> (8 * i)) & 0xff;
					int d_component = (pixels[offset] >>> (8 * i)) & 0xff;
					int merge_component = ((s_component * s_alpha) + (((d_component * d_alpha) * (255 - s_alpha)) / 256)) / r_alpha;
					r_pixel |= merge_component << (8 * i);
				}
				r_pixel |= r_alpha << 24;
				pixels[offset] = r_pixel;
			}
		}
	}

	@java.lang.Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		x1 += tx;
		y1 += ty;
		x2 += tx;
		y2 += ty;
		if ((y1 == y2) || (x1 == x2)) {
			if (x1 > x2) {
				x1 ^= x2;
				x2 ^= x1;
				x1 ^= x2;
			}
			if (y1 > y2) {
				y1 ^= y2;
				y2 ^= y1;
				y1 ^= y2;
			}
			if ((x2 < 0) || (y2 < 0)) {
				return;
			}
			if ((x1 >= image.getWidth()) && (x1 >= image.getHeight())) {
				return;
			}
			if (x1 < 0) {
				x1 = 0;
			}
			if (y1 < 0) {
				y1 = 0;
			}
			if (x2 >= image.getWidth()) {
				x2 = image.getWidth() - 1;
			}
			if (y2 >= image.getHeight()) {
				y2 = image.getHeight() - 1;
			}
			dumpRect(x1, y1, (x2 - x1) + 1, (y2 - y1) + 1, color);
		} else {
			int dx = java.lang.Math.abs(x2 - x1);
			int dy = java.lang.Math.abs(y2 - y1);
			if (dx > dy) {
				if (x1 > x2) {
					x1 ^= x2;
					x2 ^= x1;
					x1 ^= x2;
					y1 ^= y2;
					y2 ^= y1;
					y1 ^= y2;
				}
				int incy = (y1 < y2) ? 1 : -1;
				int p = dy - (dx / 2);
				int y = y1;
				for (int x = x1; x <= x2; x++) {
					setPixel(x, y, color.getRGB());
					if (p > 0) {
						y += incy;
						p += dy - dx;
					} else {
						p += dy;
					}
				}
			} else {
				if (y1 > y2) {
					x1 ^= x2;
					x2 ^= x1;
					x1 ^= x2;
					y1 ^= y2;
					y2 ^= y1;
					y1 ^= y2;
				}
				int incx = (x1 < x2) ? 1 : -1;
				int p = dx - (dy / 2);
				int x = x1;
				for (int y = y1; y <= y2; y++) {
					setPixel(x, y, color.getRGB());
					if (p > 0) {
						x += incx;
						p += dx - dy;
					} else {
						p += dx;
					}
				}
			}
		}
	}

	@java.lang.Override
	public void fillRect(int x, int y, int width, int height) {
		x += tx;
		y += ty;
		dumpRect(x, y, width, height, color);
	}

	@java.lang.Override
	public void clearRect(int x, int y, int width, int height) {
		x += tx;
		y += ty;
		dumpRect(x, y, width, height, background);
	}

	protected void dumpRect(int x, int y, int width, int height, java.awt.Color color) {
		if (x < 0) {
			width += x;
			x = 0;
		}
		if (y < 0) {
			height += y;
			y = 0;
		}
		if ((y + height) > image.getHeight()) {
			height -= (y + height) - image.getHeight();
		}
		if ((x + width) > image.getWidth()) {
			width = image.getWidth() - x;
		}
		if ((((x >= image.getWidth()) || (y >= image.getHeight())) || (width < 0)) || (height < 0)) {
			return;
		}
		while ((height--) > 0) {
			int offset = (y * image.getWidth()) + x;
			java.util.Arrays.fill(pixels, offset, offset + width, color.getRGB());
			y++;
		} 
	}

	@java.lang.Override
	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawOval(int x, int y, int width, int height) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void fillOval(int x, int y, int width, int height) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
		for (int i = 1; i < nPoints; i++) {
			drawLine(xPoints[i - 1], yPoints[i - 1], xPoints[i], yPoints[i]);
		}
	}

	@java.lang.Override
	public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		for (int i = 1; i < nPoints; i++) {
			drawLine(xPoints[i - 1], yPoints[i - 1], xPoints[i], yPoints[i]);
		}
		drawLine(xPoints[nPoints - 1], yPoints[nPoints - 1], xPoints[0], yPoints[0]);
	}

	@java.lang.Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int x, int y, java.awt.image.ImageObserver observer) {
		return drawImage(img, x, y, img.getWidth(observer), img.getHeight(observer), observer);
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int x, int y, int width, int height, java.awt.image.ImageObserver observer) {
		return drawImage(img, x, y, (x + width) - 1, (y + height) - 1, 0, 0, img.getWidth(observer) - 1, img.getHeight(observer) - 1, observer);
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int x, int y, java.awt.Color bgcolor, java.awt.image.ImageObserver observer) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int x, int y, int width, int height, java.awt.Color bgcolor, java.awt.image.ImageObserver observer) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, java.awt.image.ImageObserver observer) {
		dx1 += tx;
		dy1 += ty;
		dx2 += tx;
		dy2 += ty;
		if (img instanceof java.awt.image.BufferedImage) {
			java.awt.image.BufferedImage simg = ((java.awt.image.BufferedImage) (img));
			if (((dx2 - dx1) != (sx2 - sx1)) || ((dy2 - dy1) != (sy2 - sy1))) {
				throw new java.lang.RuntimeException("Cannot scale images");
			}
			if (dx1 < 0) {
				sx1 -= dx1;
				dx1 = 0;
			}
			if (dy1 < 0) {
				sy1 -= dy1;
				dy1 = 0;
			}
			if (dx2 >= image.getWidth()) {
				int diff = (dx2 - image.getWidth()) + 1;
				sx2 -= diff;
				dx2 -= diff;
			}
			if (dy2 >= image.getHeight()) {
				int diff = (dy2 - image.getHeight()) + 1;
				sy2 -= diff;
				dy2 -= diff;
			}
			if (sy1 < 0) {
				dy1 += sy1;
				sy1 = 0;
			}
			if (sx1 < 0) {
				dx1 += sx1;
				sx1 = 0;
			}
			if (sx2 >= simg.getWidth()) {
				int diff = (sx2 - simg.getWidth()) + 1;
				sx2 -= diff;
				dx2 -= diff;
			}
			if (sy2 >= simg.getHeight()) {
				int diff = (sy2 - simg.getHeight()) + 1;
				sy2 -= diff;
				dy2 -= diff;
			}
			int offset = (dy1 * image.getWidth()) + dx1;
			if ((((sx2 - sx1) + 1) * ((sy2 - sy1) + 1)) <= 0) {
				return true;
			}
			int[] spixels = new int[((sx2 - sx1) + 1) * ((sy2 - sy1) + 1)];
			simg.getRGB(sx1, sy1, (sx2 - sx1) + 1, (sy2 - sy1) + 1, spixels, 0, (sx2 - sx1) + 1);
			int s_pixel = 0;
			for (int dy = dy1; dy <= dy2; dy++) {
				int d_pixel = offset;
				for (int dx = dx1; dx <= dx2; dx++) {
					int d_alpha = pixels[d_pixel] >>> 24;
					int s_alpha = spixels[s_pixel] >>> 24;
					if (d_alpha == 0) {
						pixels[d_pixel] = spixels[s_pixel];
					} else if (s_alpha != 0) {
						int r_alpha = s_alpha + ((d_alpha * (255 - s_alpha)) / 256);
						int r_pixel = 0;
						for (int i = 0; i < 3; i++) {
							int s_component = (spixels[s_pixel] >>> (8 * i)) & 0xff;
							int d_component = (pixels[d_pixel] >>> (8 * i)) & 0xff;
							int merge_component = ((s_component * s_alpha) + (((d_component * d_alpha) * (255 - s_alpha)) / 256)) / r_alpha;
							r_pixel |= merge_component << (8 * i);
						}
						r_pixel |= r_alpha << 24;
						pixels[d_pixel] = r_pixel;
					}
					d_pixel++;
					s_pixel++;
				}
				offset += image.getWidth();
			}
			return true;
		} else {
			throw new java.lang.RuntimeException("Not implemented for " + img.getClass());
		}
	}

	@java.lang.Override
	public boolean drawImage(java.awt.Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, java.awt.Color bgcolor, java.awt.image.ImageObserver observer) {
		throw new java.lang.RuntimeException("Not implemented");
	}

	@java.lang.Override
	public void dispose() {
		image.setRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(100, 100, java.awt.image.BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics2D g = new edu.umn.cs.spatialHadoop.visualization.SimpleGraphics(image);
		g.setBackground(new java.awt.Color(255, 0, 0, 128));
		g.translate(20, 15);
		g.clearRect(0, 0, 100, 100);
		g.setColor(new java.awt.Color(0, 0, 0, 255));
		g.drawLine(0, 0, 50, 10);
		g.drawLine(0, 0, 10, 50);
		g.drawLine(50, 50, 80, 30);
		g.drawLine(50, 50, 30, 80);
		java.awt.image.BufferedImage image2 = new java.awt.image.BufferedImage(30, 30, java.awt.image.BufferedImage.TYPE_INT_ARGB);
		java.awt.Graphics2D g2 = image2.createGraphics();
		g2.setBackground(new java.awt.Color(0, 255, 0, 128));
		g2.clearRect(0, 0, 30, 30);
		g2.dispose();
		g.drawImage(image2, 70, 70, null);
		g.drawImage(image2, 0, 0, null);
		g.dispose();
		javax.imageio.ImageIO.write(image, "png", new java.io.File("test.png"));
	}
}