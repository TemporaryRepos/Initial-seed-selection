public class DummyMain {
	public static void main(java.lang.String... args) {
		java.lang.StringBuilder buffer = new java.lang.StringBuilder("Hello");
		for (java.lang.String arg : args) {
			buffer.append(java.lang.System.getProperty("line.separator")).append(arg);
		}
		java.lang.System.out.println(buffer.toString());
	}
}