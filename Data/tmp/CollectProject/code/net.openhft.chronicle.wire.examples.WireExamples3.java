public class WireExamples3 {
	interface Printer {
		public abstract void print(java.lang.String message);
	}

	public static void main(java.lang.String[] args) {
		final net.openhft.chronicle.wire.examples.WireExamples3.Printer consolePrinter = java.lang.System.out::println;
		consolePrinter.print("hello world");
	}
}