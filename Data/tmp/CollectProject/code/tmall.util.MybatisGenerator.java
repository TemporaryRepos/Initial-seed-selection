public class MybatisGenerator {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Boolean run = true;
		if (run) {
			return;
		}
		java.util.List<java.lang.String> warnings = new java.util.ArrayList<java.lang.String>();
		java.io.InputStream is = tmall.util.MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
		org.mybatis.generator.config.xml.ConfigurationParser cp = new org.mybatis.generator.config.xml.ConfigurationParser(warnings);
		org.mybatis.generator.config.Configuration config = cp.parseConfiguration(is);
		is.close();
		org.mybatis.generator.internal.DefaultShellCallback callback = new org.mybatis.generator.internal.DefaultShellCallback(true);
		org.mybatis.generator.api.MyBatisGenerator myBatisGenerator = new org.mybatis.generator.api.MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		java.lang.System.out.println("生成代码成功");
	}
}