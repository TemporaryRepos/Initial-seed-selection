public class ToString {
	public static void main(java.lang.String[] args) {
		if (!java.lang.Double.toString(0.001).equals("0.001")) {
			throw new java.lang.RuntimeException("Double.toString(0.001) is not \"0.001\"");
		}
		if (!java.lang.Double.toString(0.002).equals("0.002")) {
			throw new java.lang.RuntimeException("Double.toString(0.001) is not \"0.002\"");
		}
	}
}