public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("wrong");
		javaprogramming.commonmistakes.numeralcalculations.overflowissue.CommonMistakesApplication.wrong();
		java.lang.System.out.println("right1");
		javaprogramming.commonmistakes.numeralcalculations.overflowissue.CommonMistakesApplication.right1();
		java.lang.System.out.println("right2");
		javaprogramming.commonmistakes.numeralcalculations.overflowissue.CommonMistakesApplication.right2();
	}

	private static void wrong() {
		long l = java.lang.Long.MAX_VALUE;
		java.lang.System.out.println(l + 1);
		java.lang.System.out.println((l + 1) == java.lang.Long.MIN_VALUE);
	}

	private static void right2() {
		try {
			long l = java.lang.Long.MAX_VALUE;
			java.lang.System.out.println(java.lang.Math.addExact(l, 1));
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void right1() {
		java.math.BigInteger i = new java.math.BigInteger(java.lang.String.valueOf(java.lang.Long.MAX_VALUE));
		java.lang.System.out.println(i.add(java.math.BigInteger.ONE).toString());
		try {
			long l = i.add(java.math.BigInteger.ONE).longValueExact();
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
}