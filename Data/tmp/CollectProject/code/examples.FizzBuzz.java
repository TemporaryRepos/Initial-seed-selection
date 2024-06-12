public class FizzBuzz {
	public static void main(final java.lang.String[] args) {
		final joinery.DataFrame<java.lang.Integer> input = new joinery.DataFrame<java.lang.Integer>().add("number");
		for (int i = 1; i <= 100; i++) {
			input.append(java.util.Arrays.asList(i));
		}
		final joinery.DataFrame<java.lang.Object> df = input.add("value").transform(new joinery.DataFrame.RowFunction<java.lang.Integer, java.lang.Object>() {
			public List<List<java.lang.Object>> apply(final List<java.lang.Integer> row) {
				final int value = row.get(0);
				return java.util.Arrays.asList(java.util.Arrays.<java.lang.Object>asList(value, (value % 15) == 0 ? "FizzBuzz" : (value % 3) == 0 ? "Fizz" : (value % 5) == 0 ? "Buzz" : java.lang.String.valueOf(value)));
			}
		});
		java.lang.System.out.println(df.groupBy("value").count().sortBy("-number").head(3).resetIndex());
	}
}