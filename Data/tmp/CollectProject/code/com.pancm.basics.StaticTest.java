public class StaticTest {
	public static com.pancm.basics.StaticTest t1 = new com.pancm.basics.StaticTest();

	public static com.pancm.basics.StaticTest t2 = new com.pancm.basics.StaticTest();

	{
		java.lang.System.out.println("构造块");
	}

	static {
		java.lang.System.out.println("静态块");
	}

	public static void main(java.lang.String[] args) {
		com.pancm.basics.StaticTest t = new com.pancm.basics.StaticTest();
		new com.pancm.basics.HelloB();
	}
}