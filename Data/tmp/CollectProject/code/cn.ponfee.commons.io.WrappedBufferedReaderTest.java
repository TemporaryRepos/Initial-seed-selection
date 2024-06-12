public class WrappedBufferedReaderTest {
	public static void main(java.lang.String[] args) {
		try (final cn.ponfee.commons.io.WrappedBufferedReader reader = new cn.ponfee.commons.io.WrappedBufferedReader(cn.ponfee.commons.util.MavenProjects.getTestJavaFile(cn.ponfee.commons.io.WrappedBufferedReaderTest.class))) {
			for (java.lang.String str = reader.readLine(); str != null; str = reader.readLine()) {
				java.lang.System.out.println(str);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}