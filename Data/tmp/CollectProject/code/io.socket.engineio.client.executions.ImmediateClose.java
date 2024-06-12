public class ImmediateClose {
	public static void main(java.lang.String[] args) throws java.net.URISyntaxException {
		final okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
		io.socket.engineio.client.Socket.Options opts = new io.socket.engineio.client.Socket.Options();
		opts.webSocketFactory = client;
		opts.callFactory = client;
		final io.socket.engineio.client.Socket socket = new io.socket.engineio.client.Socket("http://localhost:" + java.lang.System.getenv("PORT"), opts);
		socket.on(Socket.EVENT_OPEN, new io.socket.emitter.Emitter.Listener() {
			@java.lang.Override
			public void call(java.lang.Object... args) {
				java.lang.System.out.println("open");
			}
		}).on(Socket.EVENT_CLOSE, new io.socket.emitter.Emitter.Listener() {
			@java.lang.Override
			public void call(java.lang.Object... args) {
				java.lang.System.out.println("close");
				client.dispatcher().executorService().shutdown();
			}
		});
		socket.open();
		socket.close();
	}
}