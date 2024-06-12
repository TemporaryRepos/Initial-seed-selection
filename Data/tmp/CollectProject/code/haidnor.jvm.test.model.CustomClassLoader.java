public class CustomClassLoader extends java.lang.ClassLoader {
	@java.lang.Override
	protected java.lang.Class<?> findClass(java.lang.String name) throws java.lang.ClassNotFoundException {
		try {
			byte[] result = getClassFromCustomPath(name);
			if (result == null) {
				throw new java.io.FileNotFoundException();
			} else {
				return defineClass(name, result, 0, result.length);
			}
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		throw new java.lang.ClassNotFoundException(name);
	}

	private byte[] getClassFromCustomPath(java.lang.String name) {
		return null;
	}

	public static void main(java.lang.String[] args) {
		haidnor.jvm.test.model.CustomClassLoader customClassLoader = new haidnor.jvm.test.model.CustomClassLoader();
		try {
			java.lang.Class<?> clazz = java.lang.Class.forName("One", true, customClassLoader);
			java.lang.Object obj = clazz.newInstance();
			java.lang.System.out.println(obj.getClass().getClassLoader());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}