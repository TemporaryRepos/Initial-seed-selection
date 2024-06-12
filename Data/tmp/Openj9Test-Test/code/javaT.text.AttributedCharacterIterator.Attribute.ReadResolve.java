public class ReadResolve {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.testSerializationCycle(java.text.AttributedCharacterIterator.Attribute.LANGUAGE);
		javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.testSerializationCycle(java.awt.font.TextAttribute.INPUT_METHOD_HIGHLIGHT);
		boolean gotException = false;
		java.text.AttributedCharacterIterator.Attribute result = null;
		try {
			result = javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.doSerializationCycle(javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.FakeAttribute.LANGUAGE);
		} catch (java.lang.Throwable e) {
			gotException = true;
		}
		if (!gotException) {
			throw new java.lang.RuntimeException("Attribute should throw an exception when given a fake \"language\" attribute. Deserialized object: " + result);
		}
	}

	static java.text.AttributedCharacterIterator.Attribute doSerializationCycle(java.text.AttributedCharacterIterator.Attribute attribute) throws java.lang.Exception {
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(attribute);
		oos.flush();
		byte[] data = baos.toByteArray();
		java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(data);
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
		java.text.AttributedCharacterIterator.Attribute result = ((java.text.AttributedCharacterIterator.Attribute) (ois.readObject()));
		return result;
	}

	static void testSerializationCycle(java.text.AttributedCharacterIterator.Attribute attribute) throws java.lang.Exception {
		java.text.AttributedCharacterIterator.Attribute result = javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.doSerializationCycle(attribute);
		if (result != attribute) {
			throw new java.lang.RuntimeException("attribute changed identity during serialization/deserialization");
		}
	}

	private static class FakeAttribute extends java.text.AttributedCharacterIterator.Attribute {
		static final javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.FakeAttribute LANGUAGE = new javaT.text.AttributedCharacterIterator.Attribute.ReadResolve.FakeAttribute("language");

		FakeAttribute(java.lang.String name) {
			super(name);
		}
	}
}