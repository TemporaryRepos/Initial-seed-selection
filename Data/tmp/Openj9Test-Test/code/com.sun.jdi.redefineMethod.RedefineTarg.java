class RedefineTarg {
	public static void main(java.lang.String[] args) {
		com.sun.jdi.redefineMethod.RedefineSubTarg.stemcp();
		com.sun.jdi.redefineMethod.RedefineSubTarg sub = new com.sun.jdi.redefineMethod.RedefineSubTarg();
		sub.bottom();
		com.sun.jdi.redefineMethod.RedefineSubTarg.stnemcp();
		com.sun.jdi.redefineMethod.RedefineSubTarg.stemcp();
	}
}