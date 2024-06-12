public class StockName implements java.util.Formattable {
	private java.lang.String symbol;

	private java.lang.String companyName;

	private java.lang.String frenchCompanyName;

	public StockName(java.lang.String symbol, java.lang.String companyName, java.lang.String frenchCompanyName) {
		this.symbol = symbol;
		this.companyName = companyName;
		this.frenchCompanyName = frenchCompanyName;
	}

	public void formatTo(java.util.Formatter fmt, int f, int width, int precision) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		java.lang.String name = companyName;
		if (fmt.locale().equals(java.util.Locale.FRANCE)) {
			name = frenchCompanyName;
		}
		boolean alternate = (f & java.util.FormattableFlags.ALTERNATE) == java.util.FormattableFlags.ALTERNATE;
		boolean usesymbol = alternate || ((precision != (-1)) && (precision < 10));
		java.lang.String out = (usesymbol) ? symbol : name;
		if ((precision == (-1)) || (out.length() < precision)) {
			sb.append(out);
		} else {
			sb.append(out.substring(0, precision - 1)).append('*');
		}
		int len = sb.length();
		if (len < width) {
			for (int i = 0; i < (width - len); i++) {
				if ((f & java.util.FormattableFlags.LEFT_JUSTIFY) == java.util.FormattableFlags.LEFT_JUSTIFY) {
					sb.append(' ');
				} else {
					sb.insert(0, ' ');
				}
			}
		}
		fmt.format(sb.toString());
	}

	public java.lang.String toString() {
		return java.lang.String.format("%s - %s", symbol, companyName);
	}

	public static void main(java.lang.String[] args) {
		javaT.util.Formattable.StockName sn = new javaT.util.Formattable.StockName("HUGE", "Huge Fruit, Inc.", "Fruit Titanesque, Inc.");
		java.nio.CharBuffer cb = java.nio.CharBuffer.allocate(128);
		java.util.Formatter fmt = new java.util.Formatter(cb);
		fmt.format("%s", sn);
		javaT.util.Formattable.StockName.test(cb, "Huge Fruit, Inc.");
		fmt.format("%s", sn.toString());
		javaT.util.Formattable.StockName.test(cb, "HUGE - Huge Fruit, Inc.");
		fmt.format("%#s", sn);
		javaT.util.Formattable.StockName.test(cb, "HUGE");
		fmt.format("%-10.8s", sn);
		javaT.util.Formattable.StockName.test(cb, "HUGE      ");
		fmt.format("%.12s", sn);
		javaT.util.Formattable.StockName.test(cb, "Huge Fruit,*");
		fmt.format(java.util.Locale.FRANCE, "%25s", sn);
		javaT.util.Formattable.StockName.test(cb, "   Fruit Titanesque, Inc.");
	}

	private static void test(java.nio.CharBuffer cb, java.lang.String exp) {
		cb.limit(cb.position());
		cb.rewind();
		if (!cb.toString().equals(exp)) {
			throw new java.lang.RuntimeException(((("expect: '" + exp) + "'; got: '") + cb.toString()) + "'");
		}
		cb.clear();
	}
}