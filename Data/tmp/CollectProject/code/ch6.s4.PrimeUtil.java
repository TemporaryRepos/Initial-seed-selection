public class PrimeUtil {
	public static boolean isPrime(int number) {
		int tmp = number;
		if (tmp < 2) {
			return false;
		}
		for (int i = 2; java.lang.Math.sqrt(tmp) >= i; i++) {
			if ((tmp % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(java.lang.String[] args) {
		long sum = java.util.stream.IntStream.range(1, 1000000).filter(ch6.s4.PrimeUtil::isPrime).count();
		java.lang.System.out.println(sum);
		sum = java.util.stream.IntStream.range(1, 1000000).parallel().filter(ch6.s4.PrimeUtil::isPrime).count();
		java.lang.System.out.println(sum);
	}
}