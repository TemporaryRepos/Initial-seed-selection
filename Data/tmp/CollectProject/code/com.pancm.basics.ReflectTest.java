public class ReflectTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Class clazz = com.pancm.basics.User.class;
		java.lang.Object obj = com.pancm.basics.ReflectTest.create(clazz);
		java.lang.System.out.println(obj);
		java.lang.System.out.println("---------");
		com.pancm.basics.ReflectTest.invoke1(obj, "getMessage");
	}

	static java.lang.Object create(java.lang.Class clazz) throws java.lang.Exception {
		java.lang.reflect.Constructor con = clazz.getConstructor(java.lang.String.class);
		java.lang.Object obj = con.newInstance("哈哈");
		return obj;
	}

	static void invoke1(java.lang.Object obj, java.lang.String methodName) throws java.lang.Exception {
		java.lang.reflect.Method[] ms = obj.getClass().getDeclaredMethods();
		ms = obj.getClass().getMethods();
		for (java.lang.reflect.Method m : ms) {
			if (methodName.equals(m.getName())) {
				m.invoke(obj, null);
			}
		}
	}

	static void field(java.lang.Class clazz) throws java.lang.Exception {
		java.lang.reflect.Field[] fs = clazz.getDeclaredFields();
		for (java.lang.reflect.Field f : fs) {
			java.lang.System.out.println(f.getName());
		}
	}

	static void annon(java.lang.Class clazz) throws java.lang.Exception {
		java.lang.annotation.Annotation[] as = clazz.getAnnotations();
		for (java.lang.annotation.Annotation a : as) {
			java.lang.System.out.println(((java.lang.reflect.Member) (a)).getName());
		}
	}
}