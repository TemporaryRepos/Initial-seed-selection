public class HeadingProviderExample implements net.sf.marineapi.provider.event.HeadingListener {
	private net.sf.marineapi.nmea.io.SentenceReader reader;

	private net.sf.marineapi.provider.HeadingProvider provider;

	public HeadingProviderExample(java.io.File file) throws java.io.IOException {
		java.io.InputStream stream = new java.io.FileInputStream(file);
		reader = new net.sf.marineapi.nmea.io.SentenceReader(stream);
		provider = new net.sf.marineapi.provider.HeadingProvider(reader);
		provider.addListener(this);
		reader.start();
	}

	public void providerUpdate(net.sf.marineapi.provider.event.HeadingEvent evt) {
		java.lang.System.out.println(evt.toString());
	}

	public static void main(java.lang.String[] args) {
		if (args.length != 1) {
			java.lang.String msg = "Example usage:\njava HeadingProviderExample nmea.log";
			java.lang.System.out.println(msg);
			java.lang.System.exit(0);
		}
		try {
			new net.sf.marineapi.example.HeadingProviderExample(new java.io.File(args[0]));
			java.lang.System.out.println("Running, press CTRL-C to stop..");
		} catch (java.io.IOException e) {
			e.printStackTrace();
			java.lang.System.exit(1);
		}
	}
}