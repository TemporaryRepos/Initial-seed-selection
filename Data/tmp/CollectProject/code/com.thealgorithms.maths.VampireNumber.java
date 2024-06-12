public class VampireNumber {
	public static void main(java.lang.String[] args) {
		com.thealgorithms.maths.VampireNumber.test(10, 1000);
	}

	static void test(int startValue, int stopValue) {
		int countofRes = 1;
		java.lang.StringBuilder res = new java.lang.StringBuilder();
		for (int i = startValue; i <= stopValue; i++) {
			for (int j = i; j <= stopValue; j++) {
				if (com.thealgorithms.maths.VampireNumber.isVampireNumber(i, j, true)) {
					countofRes++;
					res.append((((((((("" + countofRes) + ": = ( ") + i) + ",") + j) + " = ") + (i * j)) + ")") + "\n");
				}
			}
		}
		java.lang.System.out.println(res);
	}

	static boolean isVampireNumber(int a, int b, boolean noPseudoVamireNumbers) {
		if (noPseudoVamireNumbers) {
			if (((a * 10) <= b) || ((b * 10) <= a)) {
				return false;
			}
		}
		java.lang.String mulDigits = com.thealgorithms.maths.VampireNumber.splitIntoDigits(a * b, 0);
		java.lang.String faktorDigits = com.thealgorithms.maths.VampireNumber.splitIntoDigits(a, b);
		return mulDigits.equals(faktorDigits);
	}

	static java.lang.String splitIntoDigits(int num, int num2) {
		java.lang.StringBuilder res = new java.lang.StringBuilder();
		java.util.ArrayList<java.lang.Integer> digits = new java.util.ArrayList<>();
		while (num > 0) {
			digits.add(num % 10);
			num /= 10;
		} 
		while (num2 > 0) {
			digits.add(num2 % 10);
			num2 /= 10;
		} 
		java.util.Collections.sort(digits);
		for (int i : digits) {
			res.append(i);
		}
		return res.toString();
	}
}