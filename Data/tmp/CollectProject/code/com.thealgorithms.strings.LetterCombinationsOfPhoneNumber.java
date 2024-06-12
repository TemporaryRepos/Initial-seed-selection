public class LetterCombinationsOfPhoneNumber {
	static java.lang.Character[][] numberToCharMap;

	protected static java.util.List<java.lang.String> printWords(int[] numbers, int len, int numIndex, java.lang.String s) {
		if (len == numIndex) {
			return new java.util.ArrayList<>(java.util.Collections.singleton(s));
		}
		java.util.List<java.lang.String> stringList = new java.util.ArrayList<>();
		for (int i = 0; i < com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[numbers[numIndex]].length; i++) {
			java.lang.String sCopy = java.lang.String.copyValueOf(s.toCharArray());
			sCopy = sCopy.concat(com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[numbers[numIndex]][i].toString());
			stringList.addAll(com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.printWords(numbers, len, numIndex + 1, sCopy));
		}
		return stringList;
	}

	private static void printWords(int[] numbers) {
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.generateNumberToCharMap();
		java.util.List<java.lang.String> stringList = com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.printWords(numbers, numbers.length, 0, "");
		stringList.stream().forEach(java.lang.System.out::println);
	}

	protected static void generateNumberToCharMap() {
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap = new java.lang.Character[10][5];
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[0] = new java.lang.Character[]{ '\u0000' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[1] = new java.lang.Character[]{ '\u0000' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[2] = new java.lang.Character[]{ 'a', 'b', 'c' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[3] = new java.lang.Character[]{ 'd', 'e', 'f' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[4] = new java.lang.Character[]{ 'g', 'h', 'i' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[5] = new java.lang.Character[]{ 'j', 'k', 'l' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[6] = new java.lang.Character[]{ 'm', 'n', 'o' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[7] = new java.lang.Character[]{ 'p', 'q', 'r', 's' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[8] = new java.lang.Character[]{ 't', 'u', 'v' };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.numberToCharMap[9] = new java.lang.Character[]{ 'w', 'x', 'y', 'z' };
	}

	public static void main(java.lang.String[] args) {
		int[] number = new int[]{ 2, 3, 4 };
		com.thealgorithms.strings.LetterCombinationsOfPhoneNumber.printWords(number);
	}
}