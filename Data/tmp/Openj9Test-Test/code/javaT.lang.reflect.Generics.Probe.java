@javaT.lang.reflect.Generics.Classes({ "java.util.concurrent.FutureTask", "java.util.concurrent.ConcurrentHashMap$EntryIterator", "java.util.concurrent.ConcurrentHashMap$KeyIterator", "java.util.concurrent.ConcurrentHashMap$ValueIterator", "java.util.AbstractList$ListItr", "java.util.EnumMap$EntryIterator", "java.util.EnumMap$KeyIterator", "java.util.EnumMap$ValueIterator", "java.util.IdentityHashMap$EntryIterator", "java.util.IdentityHashMap$KeyIterator", "java.util.IdentityHashMap$ValueIterator", "java.util.WeakHashMap$EntryIterator", "java.util.WeakHashMap$KeyIterator", "java.util.WeakHashMap$ValueIterator", "java.util.HashMap$EntryIterator", "java.util.HashMap$KeyIterator", "java.util.HashMap$ValueIterator", "java.util.LinkedHashMap$LinkedEntryIterator", "java.util.LinkedHashMap$LinkedKeyIterator", "java.util.LinkedHashMap$LinkedValueIterator" })
public class Probe {
	public static void main(java.lang.String... args) throws java.lang.Throwable {
		javaT.lang.reflect.Generics.Classes classesAnnotation = javaT.lang.reflect.Generics.Probe.class.getAnnotation(javaT.lang.reflect.Generics.Classes.class);
		java.util.List<java.lang.String> names = new java.util.ArrayList<>(java.util.Arrays.asList(classesAnnotation.value()));
		int errs = 0;
		for (java.lang.String name : names) {
			java.lang.System.out.println("\nCLASS " + name);
			java.lang.Class c = java.lang.Class.forName(name, false, null);
			errs += javaT.lang.reflect.Generics.Probe.probe(c);
			java.lang.System.out.println(errs == 0 ? "  ok" : "  ERRORS:" + errs);
		}
		if (errs > 0) {
			throw new java.lang.RuntimeException("Errors during probing.");
		}
	}

	static int probe(java.lang.Class c) {
		int errs = 0;
		try {
			c.getTypeParameters();
			c.getGenericSuperclass();
			c.getGenericInterfaces();
		} catch (java.lang.Throwable t) {
			errs++;
			java.lang.System.err.println(t);
		}
		java.lang.reflect.Field[] fields = c.getDeclaredFields();
		if (fields != null) {
			for (java.lang.reflect.Field field : fields) {
				try {
					field.getGenericType();
				} catch (java.lang.Throwable t) {
					errs++;
					java.lang.System.err.println("FIELD " + field);
					java.lang.System.err.println(t);
				}
			}
		}
		java.lang.reflect.Method[] methods = c.getDeclaredMethods();
		if (methods != null) {
			for (java.lang.reflect.Method method : methods) {
				try {
					method.getTypeParameters();
					method.getGenericReturnType();
					method.getGenericParameterTypes();
					method.getGenericExceptionTypes();
				} catch (java.lang.Throwable t) {
					errs++;
					java.lang.System.err.println("METHOD " + method);
					java.lang.System.err.println(t);
				}
			}
		}
		java.lang.reflect.Constructor[] ctors = c.getDeclaredConstructors();
		if (ctors != null) {
			for (java.lang.reflect.Constructor ctor : ctors) {
				try {
					ctor.getTypeParameters();
					ctor.getGenericParameterTypes();
					ctor.getGenericExceptionTypes();
				} catch (java.lang.Throwable t) {
					errs++;
					java.lang.System.err.println("CONSTRUCTOR " + ctor);
					java.lang.System.err.println(t);
				}
			}
		}
		return errs;
	}
}