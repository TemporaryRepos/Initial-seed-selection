@lombok.extern.slf4j.Slf4j
public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) {
		org.junit.Assert.assertThrows(java.lang.ArithmeticException.class, () -> {
			int result = 12 / 0;
		});
		float result1 = 12.0F / 0;
		java.lang.System.out.println("result1:" + result1);
		java.lang.System.out.println("result1==Float.POSITIVE_INFINITY:" + (result1 == java.lang.Float.POSITIVE_INFINITY));
		float result2 = (-12.0F) / 0;
		java.lang.System.out.println("result2:" + result2);
		java.lang.System.out.println("result2==Float.NEGATIVE_INFINITY:" + (result2 == java.lang.Float.NEGATIVE_INFINITY));
		float result3 = 0.0F / 0;
		java.lang.System.out.println("result3:" + result3);
		java.lang.System.out.println("result3==Float.NaN:" + (result3 == java.lang.Float.NaN));
		java.lang.System.out.println("Float.compare(result3, Float.NaN)==0:" + (java.lang.Float.compare(result3, java.lang.Float.NaN) == 0));
		java.lang.System.out.println("Float.isNaN(result3)):" + java.lang.Float.isNaN(result3));
	}
}