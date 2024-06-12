public class QuestionTest2 {
	public static void main(java.lang.String[] args) {
		java.lang.StringBuffer str = new java.lang.StringBuffer("We Are Happy");
		java.lang.System.out.println(com.pancm.question.QuestionTest2.replaceString(str));
		java.lang.System.out.println(com.pancm.question.QuestionTest2.replaceString2(str));
	}

	public static java.lang.String replaceString(java.lang.StringBuffer str) {
		if (str == null) {
			return null;
		}
		return str.toString().replaceAll(" ", "%20");
	}

	public static java.lang.String replaceString2(java.lang.StringBuffer str) {
		if (str == null) {
			return null;
		}
		char[] c = str.toString().toCharArray();
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(c[i]);
			}
		}
		return sb.toString();
	}
}