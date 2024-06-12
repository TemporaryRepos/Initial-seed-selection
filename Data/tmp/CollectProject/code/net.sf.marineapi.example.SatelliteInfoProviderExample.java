public class SatelliteInfoProviderExample implements net.sf.marineapi.provider.event.SatelliteInfoListener {
	net.sf.marineapi.nmea.io.SentenceReader reader;

	net.sf.marineapi.provider.SatelliteInfoProvider provider;

	public SatelliteInfoProviderExample(java.io.File file) throws java.io.IOException {
		java.io.InputStream stream = new java.io.FileInputStream(file);
		reader = new net.sf.marineapi.nmea.io.SentenceReader(stream);
		provider = new net.sf.marineapi.provider.SatelliteInfoProvider(reader);
		provider.addListener(this);
		reader.start();
	}

	public void providerUpdate(net.sf.marineapi.provider.event.SatelliteInfoEvent event) {
		java.lang.System.out.println("-- GSV report --");
		for (net.sf.marineapi.nmea.util.SatelliteInfo si : event.getSatelliteInfo()) {
			java.lang.String ptrn = "%s: %d, %d";
			java.lang.String msg = java.lang.String.format(ptrn, si.getId(), si.getAzimuth(), si.getElevation());
			java.lang.System.out.println(msg);
		}
		java.lang.System.out.println("-----");
	}

	public static void main(java.lang.String[] args) {
		if (args.length != 1) {
			java.lang.String msg = "Example usage:\njava SatelliteInfoProviderExample nmea.log";
			java.lang.System.out.println(msg);
			java.lang.System.exit(0);
		}
		try {
			new net.sf.marineapi.example.SatelliteInfoProviderExample(new java.io.File(args[0]));
			java.lang.System.out.println("Running, press CTRL-C to stop..");
		} catch (java.io.IOException e) {
			e.printStackTrace();
			java.lang.System.exit(1);
		}
	}
}