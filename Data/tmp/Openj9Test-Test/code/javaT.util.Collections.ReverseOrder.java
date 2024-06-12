public class ReverseOrder {
	static byte[] serialBytes(java.lang.Object o) {
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);
			oos.writeObject(o);
			oos.flush();
			oos.close();
			return bos.toByteArray();
		} catch (java.lang.Throwable t) {
			throw new java.lang.Error(t);
		}
	}

	@java.lang.SuppressWarnings("unchecked")
	static <T> T serialClone(T o) {
		try {
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(javaT.util.Collections.ReverseOrder.serialBytes(o)));
			T clone = ((T) (ois.readObject()));
			return clone;
		} catch (java.lang.Throwable t) {
			throw new java.lang.Error(t);
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.Collections.Foo[] a = new javaT.util.Collections.Foo[]{ new javaT.util.Collections.Foo(2), new javaT.util.Collections.Foo(3), new javaT.util.Collections.Foo(1) };
		java.util.List list = java.util.Arrays.asList(a);
		java.util.Comparator cmp = java.util.Collections.reverseOrder();
		java.util.Collections.sort(list, cmp);
		javaT.util.Collections.Foo[] golden = new javaT.util.Collections.Foo[]{ new javaT.util.Collections.Foo(3), new javaT.util.Collections.Foo(2), new javaT.util.Collections.Foo(1) };
		java.util.List goldenList = java.util.Arrays.asList(golden);
		if (!list.equals(goldenList)) {
			throw new java.lang.Exception(list.toString());
		}
		java.util.Comparator clone = javaT.util.Collections.ReverseOrder.serialClone(cmp);
		java.util.List list2 = java.util.Arrays.asList(a);
		java.util.Collections.sort(list2, clone);
		if (!list2.equals(goldenList)) {
			throw new java.lang.Exception(list.toString());
		}
	}
}