public class ExceptionHidingLoader extends java.lang.ClassLoader {
	protected java.lang.Class findClass(java.lang.String name) throws java.lang.ClassNotFoundException {
		return null;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean exception = false;
		try {
			java.lang.Class.forName("aha", false, new javaT.lang.ClassLoader.ExceptionHidingLoader());
		} catch (java.lang.ClassNotFoundException e) {
			exception = true;
		}
		if (!exception) {
			throw new java.lang.Exception("Bogus loader behavior not being corrected");
		}
	}
}