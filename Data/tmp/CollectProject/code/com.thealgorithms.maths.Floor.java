public class Floor {
	public static void main(java.lang.String[] args) {
		java.util.Random random = new java.util.Random();
		for (int i = 1; i <= 1000; ++i) {
			double randomNumber = random.nextDouble();
			assert com.thealgorithms.maths.Floor.floor(randomNumber) == java.lang.Math.floor(randomNumber);
		}
	}

	public static double floor(double number) {
		if ((number - ((int) (number))) == 0) {
			return number;
		} else if ((number - ((int) (number))) > 0) {
			return ((int) (number));
		} else {
			return ((int) (number)) - 1;
		}
	}
}