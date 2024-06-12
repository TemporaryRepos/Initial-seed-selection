public class BoundaryFill {
	public static int getPixel(int[][] image, int x_co_ordinate, int y_co_ordinate) {
		return image[x_co_ordinate][y_co_ordinate];
	}

	public static void putPixel(int[][] image, int x_co_ordinate, int y_co_ordinate, int new_color) {
		image[x_co_ordinate][y_co_ordinate] = new_color;
	}

	public static void boundaryFill(int[][] image, int x_co_ordinate, int y_co_ordinate, int new_color, int boundary_color) {
		if ((((x_co_ordinate >= 0) && (y_co_ordinate >= 0)) && (com.thealgorithms.dynamicprogramming.BoundaryFill.getPixel(image, x_co_ordinate, y_co_ordinate) != new_color)) && (com.thealgorithms.dynamicprogramming.BoundaryFill.getPixel(image, x_co_ordinate, y_co_ordinate) != boundary_color)) {
			com.thealgorithms.dynamicprogramming.BoundaryFill.putPixel(image, x_co_ordinate, y_co_ordinate, new_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate + 1, y_co_ordinate, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate - 1, y_co_ordinate, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate, y_co_ordinate + 1, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate, y_co_ordinate - 1, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate + 1, y_co_ordinate - 1, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate - 1, y_co_ordinate + 1, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate + 1, y_co_ordinate + 1, new_color, boundary_color);
			com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, x_co_ordinate - 1, y_co_ordinate - 1, new_color, boundary_color);
		}
	}

	public static void printImageArray(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				java.lang.System.out.print(image[i][j] + "  ");
			}
			java.lang.System.out.println();
		}
	}

	public static void main(java.lang.String[] args) {
		int[][] image = new int[][]{ new int[]{ 0, 0, 0, 0, 0, 0, 0 }, new int[]{ 0, 3, 3, 3, 3, 0, 0 }, new int[]{ 0, 3, 0, 0, 3, 0, 0 }, new int[]{ 0, 3, 0, 0, 3, 3, 3 }, new int[]{ 0, 3, 3, 3, 0, 0, 3 }, new int[]{ 0, 0, 0, 3, 0, 0, 3 }, new int[]{ 0, 0, 0, 3, 3, 3, 3 } };
		com.thealgorithms.dynamicprogramming.BoundaryFill.boundaryFill(image, 2, 2, 5, 3);
		com.thealgorithms.dynamicprogramming.BoundaryFill.printImageArray(image);
	}
}