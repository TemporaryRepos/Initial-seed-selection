public class ProjectFileUtilsTester {
	@org.junit.Test
	public void testGetMainJavaFile() {
		java.io.File file = cn.ponfee.commons.util.MavenProjects.getMainJavaFile(cn.ponfee.commons.util.MavenProjects.class);
		printFile(file);
	}

	@org.junit.Test
	public void testGetTestJavaFile() {
		java.io.File file = cn.ponfee.commons.util.MavenProjects.getTestJavaFile(test.utils.ProjectFileUtilsTester.class);
		printFile(file);
	}

	@org.junit.Test
	public void testGetMainJavaPath() {
		java.lang.String Path = cn.ponfee.commons.util.MavenProjects.getMainJavaPath("test", "TestUtils.java");
		printFile(Path);
	}

	@org.junit.Test
	public void testGetMainResourcesPath() {
		java.lang.String Path = cn.ponfee.commons.util.MavenProjects.getMainResourcesPath("log4j.properties");
		printFile(Path);
	}

	@org.junit.Test
	public void testGetTestResourcesPath() {
		java.lang.String Path = cn.ponfee.commons.util.MavenProjects.getTestResourcesPath("redis-script-node.lua");
		printFile(Path);
	}

	private void printFile(java.lang.String filepath) {
		printFile(new java.io.File(filepath));
	}

	private void printFile(java.io.File file) {
		try {
			java.util.Scanner scanner = new java.util.Scanner(file);
			while (scanner.hasNextLine()) {
				java.lang.System.out.println(scanner.nextLine());
			} 
			scanner.close();
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.String filename = "D:\\github\\jedis-clients\\src\\main\\java\\test\\TestUtils.java";
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getBaseName(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getExtension(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getFullPath(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getFullPathNoEndSeparator(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getName(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getPath(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getPathNoEndSeparator(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getPrefix(filename));
		java.lang.System.out.println(org.apache.commons.io.FilenameUtils.getPrefixLength(filename));
	}

	public static byte[] toByteArray(java.io.InputStream in) throws java.io.IOException {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		byte[] buff = new byte[4096];
		int n;
		while ((-1) != (n = in.read(buff))) {
			out.write(buff, 0, n);
		} 
		return out.toByteArray();
	}
}