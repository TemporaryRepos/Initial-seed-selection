public class VectorCrossProduct {
	int x;

	int y;

	int z;

	VectorCrossProduct() {
		x = 0;
		y = 0;
		z = 0;
	}

	VectorCrossProduct(int _x, int _y, int _z) {
		x = _x;
		y = _y;
		z = _z;
	}

	double magnitude() {
		return java.lang.Math.sqrt(((x * x) + (y * y)) + (z * z));
	}

	int dotProduct(com.thealgorithms.maths.VectorCrossProduct b) {
		return ((x * b.x) + (y * b.y)) + (z * b.z);
	}

	com.thealgorithms.maths.VectorCrossProduct crossProduct(com.thealgorithms.maths.VectorCrossProduct b) {
		com.thealgorithms.maths.VectorCrossProduct product = new com.thealgorithms.maths.VectorCrossProduct();
		product.x = (y * b.z) - (z * b.y);
		product.y = -((x * b.z) - (z * b.x));
		product.z = (x * b.y) - (y * b.x);
		return product;
	}

	void displayVector() {
		java.lang.System.out.println((((("x : " + x) + "\ty : ") + y) + "\tz : ") + z);
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.maths.VectorCrossProduct.test();
	}

	static void test() {
		com.thealgorithms.maths.VectorCrossProduct A = new com.thealgorithms.maths.VectorCrossProduct(1, -2, 3);
		com.thealgorithms.maths.VectorCrossProduct B = new com.thealgorithms.maths.VectorCrossProduct(2, 0, 3);
		com.thealgorithms.maths.VectorCrossProduct crossProd = A.crossProduct(B);
		crossProd.displayVector();
		int dotProd = A.dotProduct(B);
		java.lang.System.out.println("Dot Product of A and B: " + dotProd);
	}
}