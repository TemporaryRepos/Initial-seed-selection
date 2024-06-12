public class StackMapFrameTest {
	public static void foo() {
		java.lang.Object o = new java.lang.Object();
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 25000; i++) {
			StackMapFrameTest.foo();
		}
	}
}