@lombok.extern.slf4j.Slf4j
public class CommonMistakesApplication {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaprogramming.commonmistakes.io.deleteonshutdown.CommonMistakesApplication.file2();
	}

	private static void file() throws java.lang.Exception {
		java.io.File file = new java.io.File("test.txt");
		file.createNewFile();
		file.deleteOnExit();
		java.lang.System.out.println(file.exists());
		java.util.concurrent.TimeUnit.SECONDS.sleep(5);
	}

	private static void file2() throws java.lang.Exception {
		java.nio.file.Path path = java.nio.file.Paths.get("test2.txt");
		java.lang.System.out.println(java.nio.file.Files.exists(path));
		try {
			java.nio.file.Files.createFile(path);
			java.lang.System.out.println(java.nio.file.Files.exists(path));
			try (final java.io.BufferedReader in = java.nio.file.Files.newBufferedReader(path, java.nio.charset.Charset.defaultCharset())) {
				try (final java.io.BufferedWriter out = java.nio.file.Files.newBufferedWriter(path, java.nio.charset.Charset.defaultCharset(), java.nio.file.StandardOpenOption.DELETE_ON_CLOSE)) {
					out.append("Hello, World!");
					out.flush();
					java.lang.String line;
					while ((line = in.readLine()) != null) {
						java.lang.System.out.println(line);
					} 
				}
				java.lang.System.out.println(java.nio.file.Files.exists(path));
			}
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void file3() throws java.lang.Exception {
		java.nio.file.Path path = java.nio.file.Paths.get("test3.txt");
		java.io.OutputStream outputStream = java.nio.file.Files.newOutputStream(path, java.nio.file.StandardOpenOption.CREATE);
		outputStream.write("test".getBytes());
		outputStream.close();
		javaprogramming.commonmistakes.io.deleteonshutdown.FilesUtil.deleteOnExit(path);
		java.util.concurrent.TimeUnit.SECONDS.sleep(5);
	}
}