public class ChannelTrafficMonitor extends io.netty.handler.traffic.ChannelTrafficShapingHandler {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.class);

	private static java.lang.String[] array = new java.lang.String[]{ "B", "KB", "MB", "GB" };

	private final io.opentelemetry.api.trace.Span streamSpan;

	public ChannelTrafficMonitor(int checkInterval, io.opentelemetry.api.trace.Span streamSpan) {
		super(checkInterval);
		this.streamSpan = streamSpan;
	}

	public long getReadBytes() {
		return this.trafficCounter().cumulativeReadBytes();
	}

	public long getWriteBytes() {
		return this.trafficCounter().cumulativeWrittenBytes();
	}

	@java.lang.Override
	public void channelInactive(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
		super.channelInactive(ctx);
		streamSpan.setAttribute("in", com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(getReadBytes()));
		streamSpan.setAttribute("out", com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(getWriteBytes()));
		streamSpan.end();
	}

	private static java.lang.String format(long bytes) {
		double value = bytes;
		int index = 0;
		for (double i = value; (i >= 1024) && (index < (com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.array.length - 1)); i /= 1024 , index++ , value = i) {
		}
		java.math.BigDecimal bigDecimal = new java.math.BigDecimal(value);
		if (index == (com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.array.length - 1)) {
			bigDecimal = bigDecimal.setScale(2, java.math.RoundingMode.HALF_UP);
		} else {
			bigDecimal = bigDecimal.setScale(0, java.math.RoundingMode.HALF_UP);
		}
		java.lang.String string = bigDecimal.toString();
		if (string.endsWith(".00")) {
			string = string.substring(0, string.length() - 3);
		}
		return string + com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.array[index];
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(1023));
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(1024));
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(1024 * 1024));
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(1064 * 1024));
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format((1064 * 1024) * 1024));
		java.lang.System.out.println(com.arloor.forwardproxy.monitor.ChannelTrafficMonitor.format(((1064L * 1024) * 1024) * 1024));
	}
}