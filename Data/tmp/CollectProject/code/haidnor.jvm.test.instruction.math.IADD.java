public class IADD {
	public static void main(java.lang.String[] args) {
		int c = haidnor.jvm.test.instruction.math.IADD.add(1, 2);
		java.lang.System.out.println(c);
	}

	public static int add(int a, int b) {
		int c = a + b;
		return c;
	}
}