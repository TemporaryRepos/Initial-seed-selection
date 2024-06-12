public class YamlTest {
	public static void main(java.lang.String[] args) {
		me.n1ar4.jar.analyzer.config.ConfigFile configFile = new me.n1ar4.jar.analyzer.config.ConfigFile();
		configFile.setDbPath("1");
		configFile.setDbSize("1");
		configFile.setJarPath("1");
		configFile.setTempPath("1");
		configFile.setTotalClass("1");
		configFile.setTotalJar("1");
		configFile.setTotalMethod("1");
		me.n1ar4.jar.analyzer.config.ConfigEngine.saveConfig(configFile);
		me.n1ar4.jar.analyzer.config.ConfigFile c = me.n1ar4.jar.analyzer.config.ConfigEngine.parseConfig();
		java.lang.System.out.println(c);
	}
}