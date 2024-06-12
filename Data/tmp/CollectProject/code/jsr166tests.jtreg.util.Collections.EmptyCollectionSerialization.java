public class EmptyCollectionSerialization {
	private static java.lang.Object patheticDeepCopy(java.lang.Object o) throws java.lang.Exception {
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);
		oos.writeObject(o);
		byte[] serializedForm = bos.toByteArray();
		java.io.InputStream is = new java.io.ByteArrayInputStream(serializedForm);
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(is);
		return ois.readObject();
	}

	private static boolean isSingleton(java.lang.Object o) throws java.lang.Exception {
		return jsr166tests.jtreg.util.Collections.EmptyCollectionSerialization.patheticDeepCopy(o) == o;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!jsr166tests.jtreg.util.Collections.EmptyCollectionSerialization.isSingleton(java.util.Collections.EMPTY_SET)) {
			throw new java.lang.Exception("EMPTY_SET");
		}
		if (!jsr166tests.jtreg.util.Collections.EmptyCollectionSerialization.isSingleton(java.util.Collections.EMPTY_LIST)) {
			throw new java.lang.Exception("EMPTY_LIST");
		}
		if (!jsr166tests.jtreg.util.Collections.EmptyCollectionSerialization.isSingleton(java.util.Collections.EMPTY_MAP)) {
			throw new java.lang.Exception("EMPTY_MAP");
		}
	}
}