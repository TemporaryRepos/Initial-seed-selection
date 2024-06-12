public class ToUpperCase {
	public static void main(java.lang.String[] args) {
		java.util.Locale turkish = new java.util.Locale("tr", "TR");
		java.util.Locale lt = new java.util.Locale("lt");
		java.util.Locale az = new java.util.Locale("az");
		javaT.lang.String.ToUpperCase.test("ß", turkish, "SS");
		javaT.lang.String.ToUpperCase.test("aß", turkish, "ASS");
		javaT.lang.String.ToUpperCase.test("i", turkish, "İ");
		javaT.lang.String.ToUpperCase.test("i", az, "İ");
		javaT.lang.String.ToUpperCase.test("ı", turkish, "I");
		javaT.lang.String.ToUpperCase.test("ß", java.util.Locale.GERMANY, "SS");
		javaT.lang.String.ToUpperCase.test("aß", java.util.Locale.GERMANY, "ASS");
		javaT.lang.String.ToUpperCase.test("i", java.util.Locale.GERMANY, "I");
		javaT.lang.String.ToUpperCase.test("abcß", java.util.Locale.US, "ABCSS");
		javaT.lang.String.ToUpperCase.test("ŉabc", java.util.Locale.US, "ʼNABC");
		javaT.lang.String.ToUpperCase.test("ŉabc", turkish, "ʼNABC");
		javaT.lang.String.ToUpperCase.test("ὒ", java.util.Locale.US, "Υ̓̀");
		javaT.lang.String.ToUpperCase.test("ŉὒ", java.util.Locale.US, "ʼNΥ̓̀");
		javaT.lang.String.ToUpperCase.test("ὔZZZ", java.util.Locale.US, "Υ̓́ZZZ");
		javaT.lang.String.ToUpperCase.test("ὔZZZ", turkish, "Υ̓́ZZZ");
		javaT.lang.String.ToUpperCase.test("aßὖ", java.util.Locale.US, "ASSΥ̓͂");
		javaT.lang.String.ToUpperCase.test("ᾭ", turkish, "ὭΙ");
		javaT.lang.String.ToUpperCase.test("iῇ", turkish, "İΗ͂Ι");
		javaT.lang.String.ToUpperCase.test("iῇ", az, "İΗ͂Ι");
		javaT.lang.String.ToUpperCase.test("iῇ", java.util.Locale.US, "IΗ͂Ι");
		javaT.lang.String.ToUpperCase.test("ﬄ", java.util.Locale.US, "FFL");
		javaT.lang.String.ToUpperCase.test("ﬗAbCdEfi", turkish, "ՄԽABCDEFİ");
		javaT.lang.String.ToUpperCase.test("ﬗAbCdEfi", az, "ՄԽABCDEFİ");
		javaT.lang.String.ToUpperCase.test("i̇", lt, "I");
		javaT.lang.String.ToUpperCase.test("̇", lt, "̇");
		javaT.lang.String.ToUpperCase.test("̇i", lt, "̇I");
		javaT.lang.String.ToUpperCase.test("j̇", lt, "J");
		javaT.lang.String.ToUpperCase.test("abci̇def", lt, "ABCIDEF");
		javaT.lang.String.ToUpperCase.test("ȧ", lt, "Ȧ");
		javaT.lang.String.ToUpperCase.test("abċdef", lt, "ABĊDEF");
		javaT.lang.String.ToUpperCase.test("i̇", java.util.Locale.US, "İ");
		javaT.lang.String.ToUpperCase.test("i̇", turkish, "İ̇");
		javaT.lang.String.ToUpperCase.test("𐐨𐐩𐐪", java.util.Locale.US, "𐐀𐐁𐐂");
		javaT.lang.String.ToUpperCase.test("𐐨a𐐩b𐐪c", java.util.Locale.US, "𐐀A𐐁B𐐂C");
		javaT.lang.String.ToUpperCase.test("???a???b", java.util.Locale.US, "???A???B");
	}

	static void test(java.lang.String in, java.util.Locale locale, java.lang.String expected) {
		java.lang.String result = in.toUpperCase(locale);
		if (!result.equals(expected)) {
			java.lang.System.err.println((((((("input: " + in) + ", locale: ") + locale) + ", expected: ") + expected) + ", actual: ") + result);
			throw new java.lang.RuntimeException();
		}
	}
}