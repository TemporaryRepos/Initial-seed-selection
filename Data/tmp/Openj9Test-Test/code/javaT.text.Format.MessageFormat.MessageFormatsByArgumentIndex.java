public class MessageFormatsByArgumentIndex {
	private static java.lang.String choicePattern = "0.0#are no files|1.0#is one file|1.0<are {0,number,integer} files";

	public static void main(java.lang.String[] args) {
		java.text.Format[] subformats;
		java.text.MessageFormat format = new java.text.MessageFormat(("{3, choice," + javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern) + "}, {2}, {0}");
		subformats = format.getFormatsByArgumentIndex();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 4);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 3, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		subformats = format.getFormats();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 3);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, null);
		format.setFormatByArgumentIndex(0, java.text.NumberFormat.getInstance());
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkPattern(format.toPattern(), ("{3,choice," + javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern) + "}, {2}, {0,number}");
		subformats = format.getFormatsByArgumentIndex();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 4);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, java.text.NumberFormat.getInstance());
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 3, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		subformats = format.getFormats();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 3);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, java.text.NumberFormat.getInstance());
		format.setFormatsByArgumentIndex(subformats);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkPattern(format.toPattern(), ((("{3,choice," + javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern) + "}, {2,number}, {0,choice,") + javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern) + "}");
		subformats = format.getFormatsByArgumentIndex();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 4);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, null);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, java.text.NumberFormat.getInstance());
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 3, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		subformats = format.getFormats();
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformatLength(subformats, 3);
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 0, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 1, java.text.NumberFormat.getInstance());
		javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.checkSubformat(subformats, 2, new java.text.ChoiceFormat(javaT.text.Format.MessageFormat.MessageFormatsByArgumentIndex.choicePattern));
	}

	private static void checkPattern(java.lang.String actual, java.lang.String expected) {
		if (!expected.equals(actual)) {
			throw new java.lang.RuntimeException((("unexpected pattern:\n expected: " + expected) + "\n   actual: ") + actual);
		}
	}

	private static void checkSubformatLength(java.text.Format[] subformats, int expected) {
		if (subformats.length != expected) {
			throw new java.lang.RuntimeException((("unexpected subformat length:\n expected: " + expected) + "\n   actual: ") + subformats.length);
		}
	}

	private static void checkSubformat(java.text.Format[] subformats, int index, java.text.Format expected) {
		java.text.Format subformat = subformats[index];
		if (subformat == expected) {
			return;
		}
		if ((subformat != null) && subformat.equals(expected)) {
			return;
		}
		throw new java.lang.RuntimeException((((("found unexpected subformat for argument " + index) + ":\n expected: ") + expected) + "\n   actual: ") + subformat);
	}
}