public class WireExamples4 {
	interface Printer {
		public abstract void print(java.lang.String message);
	}

	public static void main(java.lang.String[] args) {
		net.openhft.chronicle.wire.Wire wire = new net.openhft.chronicle.wire.JSONWire();
		final net.openhft.chronicle.wire.examples.WireExamples4.Printer printer = wire.methodWriter(net.openhft.chronicle.wire.examples.WireExamples4.Printer.class);
		printer.print("hello world");
		java.lang.System.out.println(wire.bytes());
		wire.methodReader(((net.openhft.chronicle.wire.examples.WireExamples4.Printer) (java.lang.System.out::println))).readOne();
	}
}