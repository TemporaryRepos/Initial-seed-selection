public class GeneratorDisplay {
	public void generator() throws java.lang.Exception {
		java.util.List<java.lang.String> warnings = new java.util.ArrayList<java.lang.String>();
		boolean overwrite = true;
		java.io.File configFile = new java.io.File("generatorConfig.xml");
		org.mybatis.generator.config.xml.ConfigurationParser cp = new org.mybatis.generator.config.xml.ConfigurationParser(warnings);
		org.mybatis.generator.config.Configuration config = cp.parseConfiguration(configFile);
		org.mybatis.generator.internal.DefaultShellCallback callback = new org.mybatis.generator.internal.DefaultShellCallback(overwrite);
		org.mybatis.generator.api.MyBatisGenerator myBatisGenerator = new org.mybatis.generator.api.MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			com.imooc.utils.GeneratorDisplay generatorSqlmap = new com.imooc.utils.GeneratorDisplay();
			generatorSqlmap.generator();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}