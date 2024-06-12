public class MatrixUtil {
	public static boolean isValid(final java.math.BigDecimal[][] matrix) {
		return ((matrix != null) && (matrix.length > 0)) && (matrix[0].length > 0);
	}

	public static boolean hasEqualSizes(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2) {
		return ((com.thealgorithms.maths.MatrixUtil.isValid(matrix1) && com.thealgorithms.maths.MatrixUtil.isValid(matrix2)) && (matrix1.length == matrix2.length)) && (matrix1[0].length == matrix2[0].length);
	}

	public static boolean canMultiply(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2) {
		return (com.thealgorithms.maths.MatrixUtil.isValid(matrix1) && com.thealgorithms.maths.MatrixUtil.isValid(matrix2)) && (matrix1[0].length == matrix2.length);
	}

	public static java.util.Optional<java.math.BigDecimal[][]> operate(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2, final java.util.function.BiFunction<java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal> operation) {
		if (!com.thealgorithms.maths.MatrixUtil.hasEqualSizes(matrix1, matrix2)) {
			return java.util.Optional.empty();
		}
		final int rowSize = matrix1.length;
		final int columnSize = matrix1[0].length;
		final java.math.BigDecimal[][] result = new java.math.BigDecimal[rowSize][columnSize];
		java.util.stream.IntStream.range(0, rowSize).forEach(( rowIndex) -> java.util.stream.IntStream.range(0, columnSize).forEach(( columnIndex) -> {
			final java.math.BigDecimal value1 = matrix1[rowIndex][columnIndex];
			final java.math.BigDecimal value2 = matrix2[rowIndex][columnIndex];
			result[rowIndex][columnIndex] = operation.apply(value1, value2);
		}));
		return java.util.Optional.of(result);
	}

	public static java.util.Optional<java.math.BigDecimal[][]> add(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2) {
		return com.thealgorithms.maths.MatrixUtil.operate(matrix1, matrix2, java.math.BigDecimal::add);
	}

	public static java.util.Optional<java.math.BigDecimal[][]> subtract(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2) {
		return com.thealgorithms.maths.MatrixUtil.operate(matrix1, matrix2, java.math.BigDecimal::subtract);
	}

	public static java.util.Optional<java.math.BigDecimal[][]> multiply(final java.math.BigDecimal[][] matrix1, final java.math.BigDecimal[][] matrix2) {
		if (!com.thealgorithms.maths.MatrixUtil.canMultiply(matrix1, matrix2)) {
			return java.util.Optional.empty();
		}
		final int size = matrix1[0].length;
		final int matrix1RowSize = matrix1.length;
		final int matrix2ColumnSize = matrix2[0].length;
		final java.math.BigDecimal[][] result = new java.math.BigDecimal[matrix1RowSize][matrix2ColumnSize];
		java.util.stream.IntStream.range(0, matrix1RowSize).forEach(( rowIndex) -> java.util.stream.IntStream.range(0, matrix2ColumnSize).forEach(( columnIndex) -> result[rowIndex][columnIndex] = java.util.stream.IntStream.range(0, size).mapToObj(( index) -> {
			final java.math.BigDecimal value1 = matrix1[rowIndex][index];
			final java.math.BigDecimal value2 = matrix2[index][columnIndex];
			return value1.multiply(value2);
		}).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add)));
		return java.util.Optional.of(result);
	}

	public static void assertThat(final java.math.BigDecimal[][] actual, final java.math.BigDecimal[][] expected) {
		if (!java.util.Objects.deepEquals(actual, expected)) {
			throw new java.lang.AssertionError(java.lang.String.format("expected=%s but was actual=%s", java.util.Arrays.deepToString(expected), java.util.Arrays.deepToString(actual)));
		}
	}

	public static void main(final java.lang.String[] args) {
		{
			final java.math.BigDecimal[][] matrix1 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(3), new java.math.BigDecimal(2) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(0), new java.math.BigDecimal(1) } };
			final java.math.BigDecimal[][] matrix2 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(1), new java.math.BigDecimal(3) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(2), new java.math.BigDecimal(0) } };
			final java.math.BigDecimal[][] actual = com.thealgorithms.maths.MatrixUtil.add(matrix1, matrix2).orElseThrow(() -> new java.lang.AssertionError("Could not compute matrix!"));
			final java.math.BigDecimal[][] expected = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(4), new java.math.BigDecimal(5) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(2), new java.math.BigDecimal(1) } };
			com.thealgorithms.maths.MatrixUtil.assertThat(actual, expected);
		}
		{
			final java.math.BigDecimal[][] matrix1 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(1), new java.math.BigDecimal(4) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(5), new java.math.BigDecimal(6) } };
			final java.math.BigDecimal[][] matrix2 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(2), new java.math.BigDecimal(0) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(-2), new java.math.BigDecimal(-3) } };
			final java.math.BigDecimal[][] actual = com.thealgorithms.maths.MatrixUtil.subtract(matrix1, matrix2).orElseThrow(() -> new java.lang.AssertionError("Could not compute matrix!"));
			final java.math.BigDecimal[][] expected = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(-1), new java.math.BigDecimal(4) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(7), new java.math.BigDecimal(9) } };
			com.thealgorithms.maths.MatrixUtil.assertThat(actual, expected);
		}
		{
			final java.math.BigDecimal[][] matrix1 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(1), new java.math.BigDecimal(2), new java.math.BigDecimal(3) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(4), new java.math.BigDecimal(5), new java.math.BigDecimal(6) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(7), new java.math.BigDecimal(8), new java.math.BigDecimal(9) } };
			final java.math.BigDecimal[][] matrix2 = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(1), new java.math.BigDecimal(2) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(3), new java.math.BigDecimal(4) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(5), new java.math.BigDecimal(6) } };
			final java.math.BigDecimal[][] actual = com.thealgorithms.maths.MatrixUtil.multiply(matrix1, matrix2).orElseThrow(() -> new java.lang.AssertionError("Could not compute matrix!"));
			final java.math.BigDecimal[][] expected = new java.math.BigDecimal[][]{ new java.math.BigDecimal[]{ new java.math.BigDecimal(22), new java.math.BigDecimal(28) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(49), new java.math.BigDecimal(64) }, new java.math.BigDecimal[]{ new java.math.BigDecimal(76), new java.math.BigDecimal(100) } };
			com.thealgorithms.maths.MatrixUtil.assertThat(actual, expected);
		}
	}
}