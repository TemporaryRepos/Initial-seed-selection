public class FunctionalInterfaceExample {
	public static void main(java.lang.String[] args) {
		com.flink.tutorials.java.chapter2_basics.lambda.AddInterface<java.lang.Integer> addInt = (java.lang.Integer a,java.lang.Integer b) -> a + b;
		com.flink.tutorials.java.chapter2_basics.lambda.AddInterface<java.lang.Double> addDouble = (java.lang.Double a,java.lang.Double b) -> a + b;
		int intResult;
		double doubleResult;
		intResult = addInt.add(1, 2);
		java.lang.System.out.println("Lambda int add = " + intResult);
		doubleResult = addDouble.add(1.1, 2.2);
		java.lang.System.out.println("Lambda double  add = " + doubleResult);
		doubleResult = new com.flink.tutorials.java.chapter2_basics.lambda.FunctionalInterfaceExample.MyAdd().add(1.1, 2.2);
		java.lang.System.out.println("Class implementation add = " + doubleResult);
		doubleResult = new com.flink.tutorials.java.chapter2_basics.lambda.AddInterface<java.lang.Double>() {
			@java.lang.Override
			public java.lang.Double add(java.lang.Double a, java.lang.Double b) {
				return a + b;
			}
		}.add(1.0, 2.0);
		java.lang.System.out.println("Anonymous function add = " + doubleResult);
	}

	public static class MyAdd implements com.flink.tutorials.java.chapter2_basics.lambda.AddInterface<java.lang.Double> {
		@java.lang.Override
		public java.lang.Double add(java.lang.Double a, java.lang.Double b) {
			return a + b;
		}
	}
}