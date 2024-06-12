public class Bug8001209 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		boolean err = false;
		double[] limits = new double[]{ 1, 2, 3, 4, 5, 6, 7 };
		java.lang.String[] dayOfWeekNames = new java.lang.String[]{ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		java.text.ChoiceFormat form = new java.text.ChoiceFormat(limits, dayOfWeekNames);
		java.text.ParsePosition status = new java.text.ParsePosition(0);
		java.lang.StringBuilder before = new java.lang.StringBuilder();
		for (double i = 1.0; i <= 7.0; ++i) {
			status.setIndex(0);
			java.lang.String s = form.format(i);
			before.append(" ");
			before.append(s);
			before.append(form.parse(form.format(i), status));
		}
		java.lang.String original = before.toString();
		double[] newLimits = form.getLimits();
		java.lang.String[] newFormats = ((java.lang.String[]) (form.getFormats()));
		newFormats[6] = "Doyoubi";
		java.lang.StringBuilder after = new java.lang.StringBuilder();
		for (double i = 1.0; i <= 7.0; ++i) {
			status.setIndex(0);
			java.lang.String s = form.format(i);
			after.append(" ");
			after.append(s);
			after.append(form.parse(form.format(i), status));
		}
		if (!original.equals(after.toString())) {
			err = true;
			java.lang.System.err.println((("  Expected:" + before) + "\n  Got:     ") + after);
		}
		dayOfWeekNames[6] = "Saturday";
		after = new java.lang.StringBuilder();
		for (double i = 1.0; i <= 7.0; ++i) {
			status.setIndex(0);
			java.lang.String s = form.format(i);
			after.append(" ");
			after.append(s);
			after.append(form.parse(form.format(i), status));
		}
		if (!original.equals(after.toString())) {
			err = true;
			java.lang.System.err.println((("  Expected:" + before) + "\n  Got:     ") + after);
		}
		if (err) {
			throw new java.lang.RuntimeException("Failed.");
		} else {
			java.lang.System.out.println("Passed.");
		}
	}
}