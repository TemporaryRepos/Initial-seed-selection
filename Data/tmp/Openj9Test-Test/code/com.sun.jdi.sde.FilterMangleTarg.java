class FilterMangleTarg {
	public static void bkpt() {
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("calling mangle");
		com.sun.jdi.sde.onion.pickle.Mangle.main(args);
		java.lang.System.out.println("calling mangle");
		com.sun.jdi.sde.FilterMangleTarg.bkpt();
		java.lang.System.out.println("bkpt done");
	}
}