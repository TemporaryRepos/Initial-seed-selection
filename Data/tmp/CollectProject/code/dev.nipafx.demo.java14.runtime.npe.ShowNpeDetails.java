public class ShowNpeDetails {
	private final java.lang.String field = null;

	public static void main(java.lang.String[] args) {
	}

	private static void onVariable() {
		java.lang.String variable = null;
		variable.length();
	}

	private static void onField() {
		new dev.nipafx.demo.java14.runtime.npe.ShowNpeDetails().field.length();
	}

	private static void onMethodReturn() {
		new dev.nipafx.demo.java14.runtime.npe.ShowNpeDetails().returnNull().length();
	}

	private java.lang.String returnNull() {
		return null;
	}
}