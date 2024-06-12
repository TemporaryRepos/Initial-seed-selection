public class Main {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.setProperty("apple.awt.application.name", "Coffee GB");
		new eu.rekawek.coffeegb.gui.Emulator(args, eu.rekawek.coffeegb.gui.Main.loadProperties()).run();
	}

	private static java.util.Properties loadProperties() throws java.io.IOException {
		java.util.Properties props = new java.util.Properties();
		java.io.File propFile = new java.io.File(new java.io.File(java.lang.System.getProperty("user.home")), ".coffeegb.properties");
		if (propFile.exists()) {
			try (final java.io.FileReader reader = new java.io.FileReader(propFile)) {
				props.load(reader);
			}
		}
		return props;
	}
}