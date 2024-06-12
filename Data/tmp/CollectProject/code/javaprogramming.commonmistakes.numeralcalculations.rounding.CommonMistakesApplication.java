@org.springframework.boot.autoconfigure.SpringBootApplication
public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("wrong1");
		javaprogramming.commonmistakes.numeralcalculations.rounding.CommonMistakesApplication.wrong1();
		java.lang.System.out.println("wrong2");
		javaprogramming.commonmistakes.numeralcalculations.rounding.CommonMistakesApplication.wrong2();
		java.lang.System.out.println("right");
		javaprogramming.commonmistakes.numeralcalculations.rounding.CommonMistakesApplication.right();
	}

	private static void wrong1() {
		double num1 = 3.35;
		float num2 = 3.35F;
		java.lang.System.out.println(java.lang.String.format("%.1f", num1));
		java.lang.System.out.println(java.lang.String.format("%.1f", num2));
	}

	private static void wrong2() {
		double num1 = 3.35;
		float num2 = 3.35F;
		java.text.DecimalFormat format = new java.text.DecimalFormat("#.##");
		format.setRoundingMode(java.math.RoundingMode.DOWN);
		java.lang.System.out.println(format.format(num1));
		format.setRoundingMode(java.math.RoundingMode.DOWN);
		java.lang.System.out.println(format.format(num2));
	}

	private static void right() {
		java.math.BigDecimal num1 = new java.math.BigDecimal("3.35");
		java.math.BigDecimal num2 = num1.setScale(1, java.math.BigDecimal.ROUND_DOWN);
		java.lang.System.out.println(num2);
		java.math.BigDecimal num3 = num1.setScale(1, java.math.BigDecimal.ROUND_HALF_UP);
		java.lang.System.out.println(num3);
	}
}