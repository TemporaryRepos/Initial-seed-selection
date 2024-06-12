class LogicalOperators {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(true && true);
		java.lang.System.out.println(true && false);
		java.lang.System.out.println(false && true);
		java.lang.System.out.println(false && false);
		java.lang.System.out.println(true || true);
		java.lang.System.out.println(true || false);
		java.lang.System.out.println(false || true);
		java.lang.System.out.println(false || false);
		int i = 10;
		java.lang.System.out.println(true || ((++i) == 11));
		java.lang.System.out.println(false && ((++i) == 11));
		java.lang.System.out.println(i);
		int j = 10;
		java.lang.System.out.println(true | ((++j) == 11));
		java.lang.System.out.println(false & ((++j) == 12));
		java.lang.System.out.println(j);
		java.lang.System.out.println(true ^ false);
		java.lang.System.out.println(false ^ true);
		java.lang.System.out.println(true ^ true);
		java.lang.System.out.println(false ^ false);
		java.lang.System.out.println(!false);
		java.lang.System.out.println(!true);
	}
}