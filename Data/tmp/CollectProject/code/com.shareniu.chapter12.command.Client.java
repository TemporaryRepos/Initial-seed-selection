public class Client {
	public static void main(java.lang.String[] args) {
		com.shareniu.chapter12.command.Client.assemble();
	}

	public static void assemble() {
		com.shareniu.chapter12.command.Receiver receiver = new com.shareniu.chapter12.command.Receiver();
		com.shareniu.chapter12.command.Command command = new com.shareniu.chapter12.command.ConcreteCommand(receiver);
		com.shareniu.chapter12.command.Invoker invoker = new com.shareniu.chapter12.command.Invoker(command);
		invoker.action();
	}
}