public class Contains {
	static void ck(java.nio.charset.Charset cs1, java.nio.charset.Charset cs2, boolean cont) throws java.lang.Exception {
		if (cs1.contains(cs2) != cont) {
			throw new java.lang.Exception((("Wrong answer: " + cs1.name()) + " contains ") + cs2.name());
		}
		java.lang.System.err.println((cs1.name() + (cont ? " contains " : " does not contain ")) + cs2.name());
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.charset.Charset us_ascii = java.nio.charset.Charset.forName("US-ASCII");
		java.nio.charset.Charset iso_8859_1 = java.nio.charset.Charset.forName("ISO-8859-1");
		java.nio.charset.Charset iso_8859_15 = java.nio.charset.Charset.forName("ISO-8859-15");
		java.nio.charset.Charset utf_8 = java.nio.charset.Charset.forName("UTF-8");
		java.nio.charset.Charset utf_16be = java.nio.charset.Charset.forName("UTF-16BE");
		java.nio.charset.Charset cp1252 = java.nio.charset.Charset.forName("CP1252");
		javaT.nio.charset.Charset.Contains.ck(us_ascii, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(us_ascii, iso_8859_1, false);
		javaT.nio.charset.Charset.Contains.ck(us_ascii, iso_8859_15, false);
		javaT.nio.charset.Charset.Contains.ck(us_ascii, utf_8, false);
		javaT.nio.charset.Charset.Contains.ck(us_ascii, utf_16be, false);
		javaT.nio.charset.Charset.Contains.ck(us_ascii, cp1252, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, iso_8859_1, true);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, iso_8859_15, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, utf_8, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, utf_16be, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_1, cp1252, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, iso_8859_1, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, iso_8859_15, true);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, utf_8, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, utf_16be, false);
		javaT.nio.charset.Charset.Contains.ck(iso_8859_15, cp1252, false);
		javaT.nio.charset.Charset.Contains.ck(utf_8, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(utf_8, iso_8859_1, true);
		javaT.nio.charset.Charset.Contains.ck(utf_8, iso_8859_15, true);
		javaT.nio.charset.Charset.Contains.ck(utf_8, utf_8, true);
		javaT.nio.charset.Charset.Contains.ck(utf_8, utf_16be, true);
		javaT.nio.charset.Charset.Contains.ck(utf_8, cp1252, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, iso_8859_1, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, iso_8859_15, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, utf_8, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, utf_16be, true);
		javaT.nio.charset.Charset.Contains.ck(utf_16be, cp1252, true);
		javaT.nio.charset.Charset.Contains.ck(cp1252, us_ascii, true);
		javaT.nio.charset.Charset.Contains.ck(cp1252, iso_8859_1, false);
		javaT.nio.charset.Charset.Contains.ck(cp1252, iso_8859_15, false);
		javaT.nio.charset.Charset.Contains.ck(cp1252, utf_8, false);
		javaT.nio.charset.Charset.Contains.ck(cp1252, utf_16be, false);
		javaT.nio.charset.Charset.Contains.ck(cp1252, cp1252, true);
		javaT.nio.charset.Charset.Contains.checkUTF();
	}

	static void checkUTF() throws java.lang.Exception {
		for (java.lang.String utfName : javaT.nio.charset.Charset.Contains.utfNames) {
			for (java.lang.String csName : javaT.nio.charset.Charset.Contains.charsetNames) {
				javaT.nio.charset.Charset.Contains.ck(java.nio.charset.Charset.forName(utfName), java.nio.charset.Charset.forName(csName), true);
			}
		}
	}

	static java.lang.String[] utfNames = new java.lang.String[]{ "utf-16", "utf-8", "utf-16le", "utf-16be", "x-utf-16le-bom" };

	static java.lang.String[] charsetNames = new java.lang.String[]{ "US-ASCII", "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE", "x-UTF-16LE-BOM", "GBK", "GB18030", "ISO-8859-1", "ISO-8859-15", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-13", "JIS_X0201", "x-JIS0208", "JIS_X0212-1990", "GB2312", "EUC-KR", "x-EUC-TW", "EUC-JP", "x-euc-jp-linux", "KOI8-R", "TIS-620", "x-ISCII91", "windows-1251", "windows-1252", "windows-1253", "windows-1254", "windows-1255", "windows-1256", "windows-1257", "windows-1258", "windows-932", "x-mswin-936", "x-windows-949", "x-windows-950", "windows-31j", "Big5", "Big5-HKSCS", "x-MS950-HKSCS", "ISO-2022-JP", "ISO-2022-KR", "x-ISO-2022-CN-CNS", "x-ISO-2022-CN-GB", "Big5-HKSCS", "x-Johab", "Shift_JIS" };
}