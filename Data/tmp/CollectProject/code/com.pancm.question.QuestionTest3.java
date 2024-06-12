public class QuestionTest3 {
	public static void main(java.lang.String[] args) {
		java.lang.String str = "hello xuwujing";
		java.lang.System.out.println(com.pancm.question.QuestionTest3.reverseString(str));
	}

	public static java.lang.String reverseString(java.lang.String str) {
		if ((str == null) || (str.length() <= 1)) {
			return str;
		}
		return com.pancm.question.QuestionTest3.reverseString(str.substring(1)) + str.charAt(0);
	}
}