public class CalculateTest {
	public static void main(java.lang.String[] args) {
		com.pancm.basics.CalculateTest.test1();
		com.pancm.basics.CalculateTest.test2();
		com.pancm.basics.CalculateTest.test3();
		com.pancm.basics.CalculateTest.test4();
	}

	private static void test4() {
		int a = 4;
		a *= 5;
		int b = 6;
		b %= 3;
		int c = 9;
		c |= a;
		int d = 8;
		d <<= 2;
		int e = 17;
		e &= 9;
		int f = 16;
		f ^= 2;
		java.lang.System.out.println("赋值运算符测试开始");
		java.lang.System.out.println(a);
		java.lang.System.out.println(b);
		java.lang.System.out.println(c);
		java.lang.System.out.println(d);
		java.lang.System.out.println(e);
		java.lang.System.out.println(f);
		java.lang.System.out.println("赋值运算符测试结束");
	}

	private static void test3() {
		int a = 64 >>> 2;
		int b = 2 << 2;
		int c = a & b;
		int d = b | c;
		int e = ~a;
		int f = 60 ^ 13;
		java.lang.System.out.println("位运算符测试开始");
		java.lang.System.out.println(a);
		java.lang.System.out.println(b);
		java.lang.System.out.println(c);
		java.lang.System.out.println(d);
		java.lang.System.out.println(e);
		java.lang.System.out.println(f);
		java.lang.System.out.println("位运算符测试结束");
	}

	private static void test2() {
		int a = (2 + ((3 * 4) / 2)) + ((5 + 4) * 2);
		int b = 2 >> ((3 + (4 / 2)) - 1);
		int c = ((a++) * 3) - (b--);
		int d = ((a > c ? 4 : 5) + (4 % 2)) << 3;
		java.lang.System.out.println("运算符优先级测试开始");
		java.lang.System.out.println(a);
		java.lang.System.out.println(b);
		java.lang.System.out.println(c);
		java.lang.System.out.println(d);
		java.lang.System.out.println("运算符优先级测试结束");
	}

	private static void test1() {
		int a = 1;
		int z = 1;
		int b = a++;
		int c = ++a;
		int x = 2 * (++a);
		int y = 2 * (b++);
		java.lang.System.out.println("自增运算符测试开始");
		java.lang.System.out.println(a);
		java.lang.System.out.println(b);
		java.lang.System.out.println(c);
		java.lang.System.out.println(z++);
		java.lang.System.out.println(++z);
		java.lang.System.out.println(x);
		java.lang.System.out.println(y);
		java.lang.System.out.println("自增加运算符测试结束");
	}

	private static void test10() {
		int i = 16;
		int j = 10000;
		int k = 1000;
		int m = 100;
		int n = 100000;
		java.lang.System.out.println("--" + (j & i));
		java.lang.System.out.println("--" + (k & i));
		java.lang.System.out.println("--" + (m & i));
		java.lang.System.out.println("--" + (n & i));
		java.lang.System.out.println("--" + com.pancm.basics.CalculateTest.decimal2Binary(i));
		java.lang.System.out.println("--" + com.pancm.basics.CalculateTest.biannary2Decimal(n));
		java.lang.System.out.println("--" + java.lang.Integer.toBinaryString(i));
		java.lang.System.out.println("--" + new java.math.BigInteger(java.lang.String.valueOf(i)).toString(2));
		java.lang.System.out.println("--" + new java.math.BigInteger(java.lang.String.valueOf(j), 2).toString());
	}

	public static java.lang.String decimal2Binary(int de) {
		java.lang.String numstr = "";
		while (de > 0) {
			int res = de % 2;
			numstr = res + numstr;
			de = de / 2;
		} 
		return numstr;
	}

	public static java.lang.Integer biannary2Decimal(int bi) {
		java.lang.String binStr = bi + "";
		java.lang.Integer sum = 0;
		int len = binStr.length();
		for (int i = 1; i <= len; i++) {
			int dt = java.lang.Integer.parseInt(binStr.substring(i - 1, i));
			sum += ((int) (java.lang.Math.pow(2, len - i))) * dt;
		}
		return sum;
	}
}