public class Mode {
	public static void main(java.lang.String[] args) {
		assert com.thealgorithms.maths.Mode.mode(new int[]{  }) == null;
		assert java.util.Arrays.equals(com.thealgorithms.maths.Mode.mode(new int[]{ 5 }), new int[]{ 5 });
		assert java.util.Arrays.equals(com.thealgorithms.maths.Mode.mode(new int[]{ 1, 2, 3, 4, 5 }), new int[]{ 1, 2, 3, 4, 5 });
		assert java.util.Arrays.equals(com.thealgorithms.maths.Mode.mode(new int[]{ 7, 9, 9, 4, 5, 6, 7, 7, 8 }), new int[]{ 7 });
		assert java.util.Arrays.equals(com.thealgorithms.maths.Mode.mode(new int[]{ 7, 9, 9, 4, 5, 6, 7, 7, 9 }), new int[]{ 7, 9 });
	}

	public static int[] mode(int[] numbers) {
		if (numbers.length == 0) {
			return null;
		}
		java.util.HashMap<java.lang.Integer, java.lang.Integer> count = new java.util.HashMap<>();
		for (int num : numbers) {
			if (count.containsKey(num)) {
				count.put(num, count.get(num) + 1);
			} else {
				count.put(num, 1);
			}
		}
		int max = java.util.Collections.max(count.values());
		java.util.ArrayList<java.lang.Integer> modes = new java.util.ArrayList<>();
		for (int num : count.keySet()) {
			if (count.get(num) == max) {
				modes.add(num);
			}
		}
		return modes.stream().mapToInt(( n) -> n).toArray();
	}
}