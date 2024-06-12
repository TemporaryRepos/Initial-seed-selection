public class CompressTest {
	public static void main(java.lang.String[] args) {
		com.pancm.commons.apache.CompressTest.test();
	}

	private static void test() {
		org.apache.commons.compress.archivers.zip.ZipArchiveEntry entry = new org.apache.commons.compress.archivers.zip.ZipArchiveEntry("CompressTest");
		java.io.File f = new java.io.File("d:\\user.txt");
		java.io.FileInputStream fis;
		try {
			fis = new java.io.FileInputStream(f);
			org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipOutput = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(new java.io.File("d:\\user.zip"));
			zipOutput.putArchiveEntry(entry);
			int i = 0;
			int j;
			while ((j = fis.read()) != (-1)) {
				zipOutput.write(j);
				i++;
			} 
			java.lang.System.out.println(("压缩成功!遍历了:" + i) + "次");
			zipOutput.closeArchiveEntry();
			zipOutput.close();
			fis.close();
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}