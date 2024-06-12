public class QuestionTest1 {
	public static void main(java.lang.String[] args) {
		int target = 4;
		int target1 = 5;
		int target2 = 6;
		int[][] array = new int[][]{ new int[]{ 1, 2, 3, 4 }, new int[]{ 1, 2, 3, 4, 5 } };
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find(target, array));
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find(target1, array));
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find(target2, array));
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find2(target, array));
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find2(target1, array));
		java.lang.System.out.println(com.pancm.question.QuestionTest1.Find2(target2, array));
	}

	public static boolean Find(int target, int[][] array) {
		for (int[] i : array) {
			for (int j : i) {
				if (j == target) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean Find2(int target, int[][] array) {
		int len = array.length - 1;
		int i = 0;
		while ((len > 0) && (i < array[0].length)) {
			if (array[len][i] > target) {
				len--;
			} else if (array[len][i] < target) {
				i++;
			} else {
				return true;
			}
		} 
		return false;
	}
}