public class Bug4990596 {
	public static void main(java.lang.String[] args) {
		new java.text.DecimalFormat().format(new javaT.text.Format.NumberFormat.Bug4990596.MutableInteger(0));
	}

	public static class MutableInteger extends java.lang.Number {
		public int value;

		public MutableInteger() {
		}

		public MutableInteger(int value) {
			this.value = value;
		}

		public double doubleValue() {
			return this.value;
		}

		public float floatValue() {
			return this.value;
		}

		public int intValue() {
			return this.value;
		}

		public long longValue() {
			return this.value;
		}
	}
}