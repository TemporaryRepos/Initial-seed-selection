public class EventBusTest {
	public static class OrderEvent {
		private java.lang.String message;

		public OrderEvent(java.lang.String message) {
			this.message = message;
		}

		public java.lang.String getMessage() {
			return message;
		}
	}

	public static class OrderEventListener {
		@com.google.common.eventbus.Subscribe
		public void listen(cn.ponfee.commons.event.EventBusTest.OrderEvent event) {
			java.lang.System.out.println("OrderEventListener receive msg: " + event.getMessage());
		}

		@com.google.common.eventbus.Subscribe
		public void listen(java.lang.String event) {
			java.lang.System.out.println("OrderEventListener receive msg: " + event);
		}
	}

	public static void main(java.lang.String[] args) {
		com.google.common.eventbus.EventBus eventBus = new com.google.common.eventbus.EventBus("jackson");
		eventBus.register(new cn.ponfee.commons.event.EventBusTest.OrderEventListener());
		eventBus.post(new cn.ponfee.commons.event.EventBusTest.OrderEvent("order-event-message"));
		eventBus.post("string-event-message");
	}
}