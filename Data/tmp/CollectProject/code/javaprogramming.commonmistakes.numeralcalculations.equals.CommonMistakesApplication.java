public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) {
		javaprogramming.commonmistakes.numeralcalculations.equals.CommonMistakesApplication.wrong();
		javaprogramming.commonmistakes.numeralcalculations.equals.CommonMistakesApplication.right();
		javaprogramming.commonmistakes.numeralcalculations.equals.CommonMistakesApplication.set();
	}

	private static void wrong() {
		java.lang.System.out.println(new java.math.BigDecimal("1.0").equals(new java.math.BigDecimal("1")));
	}

	private static void right() {
		java.lang.System.out.println(new java.math.BigDecimal("1.0").compareTo(new java.math.BigDecimal("1")) == 0);
	}

	private static void set() {
		java.util.Set<java.math.BigDecimal> hashSet1 = new java.util.HashSet<>();
		hashSet1.add(new java.math.BigDecimal("1.0"));
		java.lang.System.out.println(hashSet1.contains(new java.math.BigDecimal("1")));
		java.util.Set<java.math.BigDecimal> hashSet2 = new java.util.HashSet<>();
		hashSet2.add(new java.math.BigDecimal("1.0").stripTrailingZeros());
		java.lang.System.out.println(hashSet2.contains(new java.math.BigDecimal("1.000").stripTrailingZeros()));
		java.util.Set<java.math.BigDecimal> treeSet = new java.util.TreeSet<>();
		treeSet.add(new java.math.BigDecimal("1.0"));
		java.lang.System.out.println(treeSet.contains(new java.math.BigDecimal("1")));
	}
}