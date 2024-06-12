public class FinalTest {
	public static final java.lang.String name = "xuwujing";

	public static void main(java.lang.String[] args) {
	}

	final class Test2 {}

	class Test4 {
		final java.util.Date getTime() {
			return new java.util.Date();
		}
	}

	class Test5 extends com.pancm.basics.FinalTest.Test4 {}
}