public class Slf4jMain {
	public static void main(java.lang.String... args) {
		final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(org.codehaus.mojo.exec.Slf4jMain.class);
		java.lang.System.out.println(logger.getClass().getName());
		logger.info("hello" + java.util.Arrays.asList(args));
	}
}