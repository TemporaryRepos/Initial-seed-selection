public class MessageTest extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Format.MessageFormat.MessageTest().run(args);
	}

	public void TestMSGPatternTest() {
		java.lang.Object[] testArgs = new java.lang.Object[]{ new java.lang.Double(1), new java.lang.Double(3456), "Disk", new java.util.Date(10000000000L) };
		java.lang.String[] testCases = new java.lang.String[]{ "Quotes '', '{', 'a' {0} '{0}'", "Quotes '', '{', 'a' {0,number} '{0}'", "'{'1,number,'#',##} {1,number,'#',##}", "There are {1} files on {2} at {3}", "On {2}, there are {1} files, with {0,number,currency}.", "'{1,number,percent}', {1,number,percent}, ", "'{1,date,full}', {1,date,full}, ", "'{3,date,full}', {3,date,full}, ", "'{1,number,#,##}' {1,number,#,##}" };
		for (int i = 0; i < testCases.length; ++i) {
			java.util.Locale save = java.util.Locale.getDefault();
			try {
				java.util.Locale.setDefault(java.util.Locale.US);
				logln("");
				logln((i + " Pat in:  ") + testCases[i]);
				java.text.MessageFormat form = new java.text.MessageFormat(testCases[i]);
				logln((i + " Pat out: ") + form.toPattern());
				java.lang.String result = form.format(testArgs);
				logln((i + " Result:  ") + result);
				java.lang.Object[] values = form.parse(result);
				for (int j = 0; j < testArgs.length; ++j) {
					java.lang.Object testArg = testArgs[j];
					java.lang.Object value = null;
					if (j < values.length) {
						value = values[j];
					}
					if (((testArg == null) && (value != null)) || ((testArg != null) && (!testArg.equals(value)))) {
						logln((((i + " ") + j) + " old: ") + testArg);
						logln((((i + " ") + j) + " new: ") + value);
					}
				}
			} catch (java.text.ParseException pe) {
				throw new java.lang.RuntimeException("Error: MessageFormat.parse throws ParseException");
			} finally {
				java.util.Locale.setDefault(save);
			}
		}
	}
}