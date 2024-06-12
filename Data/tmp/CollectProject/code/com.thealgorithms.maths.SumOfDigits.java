public class SumOfDigits {
	public static void main(java.lang.String[] args) {
		assert ((com.thealgorithms.maths.SumOfDigits.sumOfDigits(-123) == 6) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsRecursion(-123) == 6)) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsFast(-123) == 6);
		assert ((com.thealgorithms.maths.SumOfDigits.sumOfDigits(0) == 0) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsRecursion(0) == 0)) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsFast(0) == 0);
		assert ((com.thealgorithms.maths.SumOfDigits.sumOfDigits(12345) == 15) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsRecursion(12345) == 15)) && (com.thealgorithms.maths.SumOfDigits.sumOfDigitsFast(12345) == 15);
	}

	public static int sumOfDigits(int number) {
		number = (number < 0) ? -number : number;
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		} 
		return sum;
	}

	public static int sumOfDigitsRecursion(int number) {
		number = (number < 0) ? -number : number;
		return number < 10 ? number : (number % 10) + com.thealgorithms.maths.SumOfDigits.sumOfDigitsRecursion(number / 10);
	}

	public static int sumOfDigitsFast(int number) {
		number = (number < 0) ? -number : number;
		char[] digits = (number + "").toCharArray();
		int sum = 0;
		for (int i = 0; i < digits.length; ++i) {
			sum += digits[i] - '0';
		}
		return sum;
	}
}