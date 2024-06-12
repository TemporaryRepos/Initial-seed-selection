public class KochSnowflake {
	public static void main(java.lang.String[] args) {
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> vectors = new java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2>();
		vectors.add(new com.thealgorithms.others.KochSnowflake.Vector2(0, 0));
		vectors.add(new com.thealgorithms.others.KochSnowflake.Vector2(1, 0));
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> result = com.thealgorithms.others.KochSnowflake.Iterate(vectors, 1);
		assert result.get(0).x == 0;
		assert result.get(0).y == 0;
		assert result.get(1).x == (1.0 / 3);
		assert result.get(1).y == 0;
		assert result.get(2).x == (1.0 / 2);
		assert result.get(2).y == (java.lang.Math.sin(java.lang.Math.PI / 3) / 3);
		assert result.get(3).x == (2.0 / 3);
		assert result.get(3).y == 0;
		assert result.get(4).x == 1;
		assert result.get(4).y == 0;
		int imageWidth = 600;
		double offsetX = imageWidth / 10.0;
		double offsetY = imageWidth / 3.7;
		java.awt.image.BufferedImage image = com.thealgorithms.others.KochSnowflake.GetKochSnowflake(imageWidth, 5);
		assert image.getRGB(0, 0) == new java.awt.Color(255, 255, 255).getRGB();
		assert image.getRGB(((int) (offsetX)), ((int) (offsetY))) == new java.awt.Color(0, 0, 0).getRGB();
		try {
			javax.imageio.ImageIO.write(image, "png", new java.io.File("KochSnowflake.png"));
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public static java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> Iterate(java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> initialVectors, int steps) {
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> vectors = initialVectors;
		for (int i = 0; i < steps; i++) {
			vectors = com.thealgorithms.others.KochSnowflake.IterationStep(vectors);
		}
		return vectors;
	}

	public static java.awt.image.BufferedImage GetKochSnowflake(int imageWidth, int steps) {
		if (imageWidth <= 0) {
			throw new java.lang.IllegalArgumentException("imageWidth should be greater than zero");
		}
		double offsetX = imageWidth / 10.0;
		double offsetY = imageWidth / 3.7;
		com.thealgorithms.others.KochSnowflake.Vector2 vector1 = new com.thealgorithms.others.KochSnowflake.Vector2(offsetX, offsetY);
		com.thealgorithms.others.KochSnowflake.Vector2 vector2 = new com.thealgorithms.others.KochSnowflake.Vector2(imageWidth / 2, ((java.lang.Math.sin(java.lang.Math.PI / 3) * imageWidth) * 0.8) + offsetY);
		com.thealgorithms.others.KochSnowflake.Vector2 vector3 = new com.thealgorithms.others.KochSnowflake.Vector2(imageWidth - offsetX, offsetY);
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> initialVectors = new java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2>();
		initialVectors.add(vector1);
		initialVectors.add(vector2);
		initialVectors.add(vector3);
		initialVectors.add(vector1);
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> vectors = com.thealgorithms.others.KochSnowflake.Iterate(initialVectors, steps);
		return com.thealgorithms.others.KochSnowflake.GetImage(vectors, imageWidth, imageWidth);
	}

	private static java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> IterationStep(java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> vectors) {
		java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> newVectors = new java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2>();
		for (int i = 0; i < (vectors.size() - 1); i++) {
			com.thealgorithms.others.KochSnowflake.Vector2 startVector = vectors.get(i);
			com.thealgorithms.others.KochSnowflake.Vector2 endVector = vectors.get(i + 1);
			newVectors.add(startVector);
			com.thealgorithms.others.KochSnowflake.Vector2 differenceVector = endVector.subtract(startVector).multiply(1.0 / 3);
			newVectors.add(startVector.add(differenceVector));
			newVectors.add(startVector.add(differenceVector).add(differenceVector.rotate(60)));
			newVectors.add(startVector.add(differenceVector.multiply(2)));
		}
		newVectors.add(vectors.get(vectors.size() - 1));
		return newVectors;
	}

	private static java.awt.image.BufferedImage GetImage(java.util.ArrayList<com.thealgorithms.others.KochSnowflake.Vector2> vectors, int imageWidth, int imageHeight) {
		java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(imageWidth, imageHeight, java.awt.image.BufferedImage.TYPE_INT_RGB);
		java.awt.Graphics2D g2d = image.createGraphics();
		g2d.setBackground(java.awt.Color.WHITE);
		g2d.fillRect(0, 0, imageWidth, imageHeight);
		g2d.setColor(java.awt.Color.BLACK);
		java.awt.BasicStroke bs = new java.awt.BasicStroke(1);
		g2d.setStroke(bs);
		for (int i = 0; i < (vectors.size() - 1); i++) {
			int x1 = ((int) (vectors.get(i).x));
			int y1 = ((int) (vectors.get(i).y));
			int x2 = ((int) (vectors.get(i + 1).x));
			int y2 = ((int) (vectors.get(i + 1).y));
			g2d.drawLine(x1, y1, x2, y2);
		}
		return image;
	}

	private static class Vector2 {
		double x;

		double y;

		public Vector2(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return java.lang.String.format("[%f, %f]", this.x, this.y);
		}

		public com.thealgorithms.others.KochSnowflake.Vector2 add(com.thealgorithms.others.KochSnowflake.Vector2 vector) {
			double x = this.x + vector.x;
			double y = this.y + vector.y;
			return new com.thealgorithms.others.KochSnowflake.Vector2(x, y);
		}

		public com.thealgorithms.others.KochSnowflake.Vector2 subtract(com.thealgorithms.others.KochSnowflake.Vector2 vector) {
			double x = this.x - vector.x;
			double y = this.y - vector.y;
			return new com.thealgorithms.others.KochSnowflake.Vector2(x, y);
		}

		public com.thealgorithms.others.KochSnowflake.Vector2 multiply(double scalar) {
			double x = this.x * scalar;
			double y = this.y * scalar;
			return new com.thealgorithms.others.KochSnowflake.Vector2(x, y);
		}

		public com.thealgorithms.others.KochSnowflake.Vector2 rotate(double angleInDegrees) {
			double radians = (angleInDegrees * java.lang.Math.PI) / 180;
			double ca = java.lang.Math.cos(radians);
			double sa = java.lang.Math.sin(radians);
			double x = (ca * this.x) - (sa * this.y);
			double y = (sa * this.x) + (ca * this.y);
			return new com.thealgorithms.others.KochSnowflake.Vector2(x, y);
		}
	}
}