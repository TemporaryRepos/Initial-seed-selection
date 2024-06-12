public class AttributedStringTest {
	private static final java.lang.String text = "Hello, world!";

	private static final java.text.Annotation hi = new java.text.Annotation("hi");

	private static final int[] array5_13 = new int[]{ 5, 13 };

	private static final int[] array3_9_13 = new int[]{ 3, 9, 13 };

	private static final int[] array5_9_13 = new int[]{ 5, 9, 13 };

	private static final int[] array3_5_9_13 = new int[]{ 3, 5, 9, 13 };

	private static final java.text.AttributedCharacterIterator.Attribute[] arrayLanguage = new java.text.AttributedCharacterIterator.Attribute[]{ java.text.AttributedCharacterIterator.Attribute.LANGUAGE };

	private static final java.text.AttributedCharacterIterator.Attribute[] arrayLanguageReading = new java.text.AttributedCharacterIterator.Attribute[]{ java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.text.AttributedCharacterIterator.Attribute.READING };

	private static final java.util.Set setLanguageReading = new java.util.HashSet();

	static {
		setLanguageReading.add(java.text.AttributedCharacterIterator.Attribute.LANGUAGE);
		setLanguageReading.add(java.text.AttributedCharacterIterator.Attribute.READING);
	}

	public static final void main(java.lang.String[] argv) throws java.lang.Exception {
		java.text.AttributedString string;
		java.text.AttributedCharacterIterator iterator;
		string = new java.text.AttributedString(javaT.text.AttributedString.AttributedStringTest.text);
		iterator = string.getIterator();
		javaT.text.AttributedString.AttributedStringTest.checkIteratorText(iterator, javaT.text.AttributedString.AttributedStringTest.text);
		if (!iterator.getAllAttributeKeys().isEmpty()) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "iterator provides attributes where none are defined");
		}
		string.addAttribute(java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.ENGLISH, 3, 9);
		iterator = string.getIterator();
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttributeKeys(iterator, javaT.text.AttributedString.AttributedStringTest.arrayLanguage);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, javaT.text.AttributedString.AttributedStringTest.array3_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.ENGLISH);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 9, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, null);
		string.addAttribute(java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.hi, 0, 5);
		iterator = string.getIterator();
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttributeKeys(iterator, javaT.text.AttributedString.AttributedStringTest.arrayLanguageReading);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, javaT.text.AttributedString.AttributedStringTest.array3_5_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.hi);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.hi);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 5, java.text.AttributedCharacterIterator.Attribute.READING, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 9, java.text.AttributedCharacterIterator.Attribute.READING, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, javaT.text.AttributedString.AttributedStringTest.array3_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.ENGLISH);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 5, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.ENGLISH);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 9, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, javaT.text.AttributedString.AttributedStringTest.setLanguageReading, javaT.text.AttributedString.AttributedStringTest.array3_5_9_13);
		string.addAttribute(java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.US, 0, 5);
		iterator = string.getIterator();
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttributeKeys(iterator, javaT.text.AttributedString.AttributedStringTest.arrayLanguageReading);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, javaT.text.AttributedString.AttributedStringTest.array3_5_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, javaT.text.AttributedString.AttributedStringTest.array5_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.array5_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorSubranges(iterator, javaT.text.AttributedString.AttributedStringTest.setLanguageReading, javaT.text.AttributedString.AttributedStringTest.array5_9_13);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.US);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.US);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 5, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, java.util.Locale.ENGLISH);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 9, java.text.AttributedCharacterIterator.Attribute.LANGUAGE, null);
		iterator = string.getIterator(null, 3, 5);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.READING, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 5, java.text.AttributedCharacterIterator.Attribute.READING, null);
		iterator = string.getIterator(null, 0, 4);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.READING, null);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 3, java.text.AttributedCharacterIterator.Attribute.READING, null);
		iterator = string.getIterator(null, 0, 5);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 0, java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.hi);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 4, java.text.AttributedCharacterIterator.Attribute.READING, javaT.text.AttributedString.AttributedStringTest.hi);
		javaT.text.AttributedString.AttributedStringTest.checkIteratorAttribute(iterator, 5, java.text.AttributedCharacterIterator.Attribute.READING, null);
	}

	private static final void checkIteratorText(java.text.AttributedCharacterIterator iterator, java.lang.String expectedText) throws java.lang.Exception {
		if ((iterator.getEndIndex() - iterator.getBeginIndex()) != expectedText.length()) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "text length doesn't match between original text and iterator");
		}
		char c = iterator.first();
		for (int i = 0; i < expectedText.length(); i++) {
			if (c != expectedText.charAt(i)) {
				javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "text content doesn't match between original text and iterator");
			}
			c = iterator.next();
		}
		if (c != java.text.CharacterIterator.DONE) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "iterator text doesn't end with DONE");
		}
	}

	private static final void checkIteratorAttributeKeys(java.text.AttributedCharacterIterator iterator, java.text.AttributedCharacterIterator.Attribute[] expectedKeys) throws java.lang.Exception {
		java.util.Set iteratorKeys = iterator.getAllAttributeKeys();
		if (iteratorKeys.size() != expectedKeys.length) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "number of keys returned by iterator doesn't match expectation");
		}
		for (int i = 0; i < expectedKeys.length; i++) {
			if (!iteratorKeys.contains(expectedKeys[i])) {
				javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "expected key wasn't found in iterator's key set");
			}
		}
	}

	private static final void checkIteratorSubranges(java.text.AttributedCharacterIterator iterator, int[] expectedLimits) throws java.lang.Exception {
		int previous = 0;
		char c = iterator.first();
		for (int i = 0; i < expectedLimits.length; i++) {
			if ((iterator.getRunStart() != previous) || (iterator.getRunLimit() != expectedLimits[i])) {
				javaT.text.AttributedString.AttributedStringTest.throwException(iterator, (("run boundaries are not as expected: " + iterator.getRunStart()) + ", ") + iterator.getRunLimit());
			}
			previous = expectedLimits[i];
			c = iterator.setIndex(previous);
		}
		if (c != java.text.CharacterIterator.DONE) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "iterator's run sequence doesn't end with DONE");
		}
	}

	private static final void checkIteratorSubranges(java.text.AttributedCharacterIterator iterator, java.text.AttributedCharacterIterator.Attribute key, int[] expectedLimits) throws java.lang.Exception {
		int previous = 0;
		char c = iterator.first();
		for (int i = 0; i < expectedLimits.length; i++) {
			if ((iterator.getRunStart(key) != previous) || (iterator.getRunLimit(key) != expectedLimits[i])) {
				javaT.text.AttributedString.AttributedStringTest.throwException(iterator, (((("run boundaries are not as expected: " + iterator.getRunStart(key)) + ", ") + iterator.getRunLimit(key)) + " for key ") + key);
			}
			previous = expectedLimits[i];
			c = iterator.setIndex(previous);
		}
		if (c != java.text.CharacterIterator.DONE) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "iterator's run sequence doesn't end with DONE");
		}
	}

	private static final void checkIteratorSubranges(java.text.AttributedCharacterIterator iterator, java.util.Set keys, int[] expectedLimits) throws java.lang.Exception {
		int previous = 0;
		char c = iterator.first();
		for (int i = 0; i < expectedLimits.length; i++) {
			if ((iterator.getRunStart(keys) != previous) || (iterator.getRunLimit(keys) != expectedLimits[i])) {
				javaT.text.AttributedString.AttributedStringTest.throwException(iterator, (((("run boundaries are not as expected: " + iterator.getRunStart(keys)) + ", ") + iterator.getRunLimit(keys)) + " for keys ") + keys);
			}
			previous = expectedLimits[i];
			c = iterator.setIndex(previous);
		}
		if (c != java.text.CharacterIterator.DONE) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, "iterator's run sequence doesn't end with DONE");
		}
	}

	private static final void checkIteratorAttribute(java.text.AttributedCharacterIterator iterator, int index, java.text.AttributedCharacterIterator.Attribute key, java.lang.Object expectedValue) throws java.lang.Exception {
		iterator.setIndex(index);
		java.lang.Object value = iterator.getAttribute(key);
		if (!(((expectedValue == null) && (value == null)) || ((expectedValue != null) && expectedValue.equals(value)))) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, (("iterator returns wrong attribute value - " + value) + " instead of ") + expectedValue);
		}
		value = iterator.getAttributes().get(key);
		if (!(((expectedValue == null) && (value == null)) || ((expectedValue != null) && expectedValue.equals(value)))) {
			javaT.text.AttributedString.AttributedStringTest.throwException(iterator, (("iterator's map returns wrong attribute value - " + value) + " instead of ") + expectedValue);
		}
	}

	private static final void throwException(java.text.AttributedCharacterIterator iterator, java.lang.String details) throws java.lang.Exception {
		javaT.text.AttributedString.AttributedStringTest.dumpIterator(iterator);
		throw new java.lang.Exception(details);
	}

	private static final void dumpIterator(java.text.AttributedCharacterIterator iterator) {
		java.util.Set attributeKeys = iterator.getAllAttributeKeys();
		java.lang.System.out.print("All attributes: ");
		java.util.Iterator keyIterator = attributeKeys.iterator();
		while (keyIterator.hasNext()) {
			java.text.AttributedCharacterIterator.Attribute key = ((java.text.AttributedCharacterIterator.Attribute) (keyIterator.next()));
			java.lang.System.out.print(key);
		} 
		for (char c = iterator.first(); c != java.text.CharacterIterator.DONE; c = iterator.next()) {
			if ((iterator.getIndex() == iterator.getBeginIndex()) || (iterator.getIndex() == iterator.getRunStart())) {
				java.lang.System.out.println();
				java.util.Map attributes = iterator.getAttributes();
				java.util.Set entries = attributes.entrySet();
				java.util.Iterator attributeIterator = entries.iterator();
				while (attributeIterator.hasNext()) {
					java.util.Map.Entry entry = ((java.util.Map.Entry) (attributeIterator.next()));
					java.lang.System.out.print(((("<" + entry.getKey()) + ": ") + entry.getValue()) + ">");
				} 
			}
			java.lang.System.out.print(" ");
			java.lang.System.out.print(c);
		}
		java.lang.System.out.println();
		java.lang.System.out.println("done");
		java.lang.System.out.println();
	}
}