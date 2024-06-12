public class Test6792161 {
	static java.lang.reflect.Constructor test(java.lang.Class cls) throws java.lang.Exception {
		java.lang.Class[] args = new java.lang.Class[]{ java.lang.String.class };
		try {
			return cls.getConstructor(args);
		} catch (java.lang.NoSuchMethodException e) {
		}
		return cls.getConstructor(new java.lang.Class[0]);
	}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		try {
			for (int i = 0; i < 100000; i++) {
				java.lang.reflect.Constructor ctor = compiler.c2.Test6792161.test(java.lang.Class.forName("compiler.c2.Test6792161"));
			}
		} catch (java.lang.NoSuchMethodException e) {
		}
	}
}