class RedefineTarg {
	public static void show(java.lang.String where) {
		java.lang.System.out.println("Returned: " + where);
	}

	public static void lastly(java.lang.String where) {
	}

	public static void main(java.lang.String[] args) {
		com.sun.jdi.redefine.RedefineSubTarg sub = new com.sun.jdi.redefine.RedefineSubTarg();
		java.lang.String where = "";
		for (int i = 0; i < 5; ++i) {
			where = sub.foo(where);
			com.sun.jdi.redefine.RedefineTarg.show(where);
		}
		com.sun.jdi.redefine.RedefineTarg.lastly(where);
	}
}