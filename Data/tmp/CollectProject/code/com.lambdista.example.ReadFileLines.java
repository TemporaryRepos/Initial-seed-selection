public class ReadFileLines {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> lines = com.lambdista.example.ReadFileLines.readFileWithoutTry("test.txt");
		java.lang.System.out.println("File read using the try-catch block");
		lines.forEach(java.lang.System.out::println);
		lines = com.lambdista.example.ReadFileLines.readFileWithTry("test.txt");
		java.lang.System.out.println("File read using the Try-Success-Failure API");
		lines.forEach(java.lang.System.out::println);
	}

	public static java.util.List<java.lang.String> readFileWithoutTry(java.lang.String file) {
		java.util.List<java.lang.String> lines;
		try {
			lines = java.nio.file.Files.readAllLines(new java.io.File(file).toPath());
		} catch (java.io.IOException e) {
			lines = java.util.Arrays.asList("Could not read the file: " + file);
		}
		return lines;
	}

	public static java.util.List<java.lang.String> readFileWithTry(java.lang.String file) {
		return com.lambdista.util.Try.apply(() -> java.nio.file.Files.readAllLines(new java.io.File(file).toPath())).getOrElse(java.util.Arrays.asList("Could not read the file: " + file));
	}
}