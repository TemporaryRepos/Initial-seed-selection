public class TestMeetExactConstantArrays {
	public abstract static class NumbersHolder {
		public java.lang.Number[] getNumbers() {
			return null;
		}
	}

	public static class IntegersHolder extends compiler.types.TestMeetExactConstantArrays.NumbersHolder {
		private static final java.lang.Integer[] integers = new java.lang.Integer[]{ new java.lang.Integer(1) };

		public java.lang.Number[] getNumbers() {
			return compiler.types.TestMeetExactConstantArrays.IntegersHolder.integers;
		}
	}

	public static class LongsHolder extends compiler.types.TestMeetExactConstantArrays.NumbersHolder {
		private static final java.lang.Long[] longs = new java.lang.Long[]{ new java.lang.Long(1) };

		public java.lang.Number[] getNumbers() {
			return compiler.types.TestMeetExactConstantArrays.LongsHolder.longs;
		}
	}

	public static final void loopNumbers(compiler.types.TestMeetExactConstantArrays.NumbersHolder numbersHolder) {
		java.lang.Number[] numbers = numbersHolder.getNumbers();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i].longValue();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = 0; i < 10000; i++) {
			compiler.types.TestMeetExactConstantArrays.IntegersHolder integersHolder = new compiler.types.TestMeetExactConstantArrays.IntegersHolder();
			compiler.types.TestMeetExactConstantArrays.LongsHolder longsHolder = new compiler.types.TestMeetExactConstantArrays.LongsHolder();
			compiler.types.TestMeetExactConstantArrays.loopNumbers(integersHolder);
			compiler.types.TestMeetExactConstantArrays.loopNumbers(longsHolder);
		}
	}
}