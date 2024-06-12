public class Paranthesis {
	private int maximumDepth(java.lang.String expression) {
		if (expression == null) {
			return -1;
		}
		char[] characters = expression.toCharArray();
		int current_max = 0;
		int max = 0;
		int i = 0;
		while (i < characters.length) {
			if (characters[i] == '(') {
				current_max++;
				if (current_max > max) {
					max = current_max;
				}
			} else if (characters[i] == ')') {
				current_max--;
			}
			i++;
		} 
		if (current_max != 0) {
			return -1;
		}
		return max;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String exp = "((((a)(b)c)d))";
		com.applications.Paranthesis pr = new com.applications.Paranthesis();
		java.lang.System.out.println(pr.maximumDepth(exp));
		exp = "((a)b))))";
		java.lang.System.out.println(pr.maximumDepth(exp));
		exp = " b) (c) d)";
		java.lang.System.out.println(pr.maximumDepth(exp));
		exp = "( p((q)) ((s)t) )";
		java.lang.System.out.println(pr.maximumDepth(exp));
		exp = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		java.lang.System.out.println(pr.maximumDepth(exp));
	}
}