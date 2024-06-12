public class Pair<TYPE1, TYPE2> implements java.lang.Comparable {
	private static final org.apache.log4j.Logger THE_LOGGER = org.apache.log4j.Logger.getLogger(org.dataalgorithms.util.Pair.class);

	private TYPE1 t1 = null;

	private TYPE2 t2 = null;

	public Pair(TYPE1 t1, TYPE2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public TYPE1 getLeft() {
		return this.t1;
	}

	public TYPE2 getRight() {
		return this.t2;
	}

	public void setLeft(TYPE1 t1) {
		this.t1 = t1;
	}

	public void setRight(TYPE2 t2) {
		this.t2 = t2;
	}

	@java.lang.Override
	public int hashCode() {
		int code = 0;
		if (t1 != null) {
			code = t1.hashCode();
		}
		if (t2 != null) {
			code = (code / 2) + (t2.hashCode() / 2);
		}
		return code;
	}

	public static boolean same(java.lang.Object t1, java.lang.Object t2) {
		return t1 == null ? t2 == null : t1.equals(t2);
	}

	@java.lang.Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof org.dataalgorithms.util.Pair)) {
			return false;
		}
		org.dataalgorithms.util.Pair p = ((org.dataalgorithms.util.Pair) (obj));
		return org.dataalgorithms.util.Pair.same(p.t1, this.t1) && org.dataalgorithms.util.Pair.same(p.t2, this.t2);
	}

	public int compareTo(java.lang.Object obj) {
		if (!(obj instanceof org.dataalgorithms.util.Pair)) {
			return +1;
		}
		org.dataalgorithms.util.Pair p = ((org.dataalgorithms.util.Pair) (obj));
		if (org.dataalgorithms.util.Pair.same(p.t1, this.t1) && org.dataalgorithms.util.Pair.same(p.t2, this.t2)) {
			return 0;
		}
		return -1;
	}

	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder builder = new java.lang.StringBuilder();
		builder.append("Pair{");
		builder.append(t1);
		builder.append(", ");
		builder.append(t2);
		builder.append("}");
		return builder.toString();
	}

	public static java.lang.String join(org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> pair, java.lang.String delimiter) {
		if (pair == null) {
			return null;
		}
		return (pair.getLeft() + delimiter) + pair.getRight();
	}

	public static org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> getPairOfString(java.lang.String line, java.lang.String delimiter) throws java.lang.Exception {
		java.util.Scanner scanner = null;
		org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> pair = null;
		try {
			scanner = new java.util.Scanner(line);
			scanner.useDelimiter(delimiter);
			java.lang.String str1 = scanner.next();
			org.dataalgorithms.util.Pair.THE_LOGGER.info("getPairOfString(): str1=" + str1);
			java.lang.String str2 = scanner.next();
			org.dataalgorithms.util.Pair.THE_LOGGER.info("getPairOfString(): str2=" + str2);
			pair = new org.dataalgorithms.util.Pair<java.lang.String, java.lang.String>(str1, str2);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return pair;
	}

	public static void main(java.lang.String[] args) {
		org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> p1 = new org.dataalgorithms.util.Pair<java.lang.String, java.lang.String>("a1", "b1");
		org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> p2 = new org.dataalgorithms.util.Pair<java.lang.String, java.lang.String>("a1", null);
		org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> p3 = new org.dataalgorithms.util.Pair<java.lang.String, java.lang.String>("a1", "b1");
		org.dataalgorithms.util.Pair<java.lang.String, java.lang.String> p4 = new org.dataalgorithms.util.Pair<java.lang.String, java.lang.String>(null, null);
		org.dataalgorithms.util.Pair.THE_LOGGER.info("p1=" + p1);
		org.dataalgorithms.util.Pair.THE_LOGGER.info("p2=" + p2);
		org.dataalgorithms.util.Pair.THE_LOGGER.info("p3=" + p3);
		org.dataalgorithms.util.Pair.THE_LOGGER.info("p4=" + p4);
		org.dataalgorithms.util.Pair.THE_LOGGER.info(p1.equals(new org.dataalgorithms.util.Pair<java.lang.Integer, java.lang.Integer>(1, 2)) + " should be false");
		org.dataalgorithms.util.Pair.THE_LOGGER.info(p4.equals(p2) + " should be false");
		org.dataalgorithms.util.Pair.THE_LOGGER.info(p2.equals(p4) + " should be false");
		org.dataalgorithms.util.Pair.THE_LOGGER.info(p1.equals(p3) + " should be true");
		org.dataalgorithms.util.Pair.THE_LOGGER.info(p4.equals(p4) + " should be true");
	}
}