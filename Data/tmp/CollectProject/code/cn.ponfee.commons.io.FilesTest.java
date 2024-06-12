public class FilesTest {
	@org.junit.Test
	public void testx() {
		java.lang.System.out.println(org.openjdk.jol.info.ClassLayout.parseInstance(new java.lang.Object()).toPrintable());
		java.lang.System.out.println("\n-----------------------");
		java.lang.System.out.println(org.openjdk.jol.info.ClassLayout.parseInstance(new java.lang.Object[10]).toPrintable());
		java.lang.System.out.println("\n-----------------------");
		java.lang.System.out.println(org.openjdk.jol.info.ClassLayout.parseInstance(new long[10]).toPrintable());
		java.lang.System.out.println("\n-----------------------");
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect(cn.ponfee.commons.util.MavenProjects.getMainJavaFile(cn.ponfee.commons.tree.TreeNode.class)));
	}

	@org.junit.Test
	public void test1() throws java.net.MalformedURLException {
		java.lang.System.out.println("GBK.properties -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/GBK.properties"));
		java.lang.System.out.println("UTF8.txt -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF8.txt"));
		java.lang.System.out.println("UTF8-WITH-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF8-WITH-BOM.xml"));
		java.lang.System.out.println("UTF8-WITHOUT-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF8-WITHOUT-BOM.xml"));
		java.lang.System.out.println("UTF16-BIG-ENDIAN-WITH-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF16-BIG-ENDIAN-WITH-BOM.xml"));
		java.lang.System.out.println("UTF16-BIG-ENDIAN-WITHOUT-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF16-BIG-ENDIAN-WITHOUT-BOM.xml"));
		java.lang.System.out.println("UTF16-WITH-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF16-WITH-BOM.xml"));
		java.lang.System.out.println("UTF16-WITHOUT-BOM.xml -> " + cn.ponfee.commons.io.CharsetDetector.detect("D:/temp/UTF16-WITHOUT-BOM.xml"));
	}

	@org.junit.Test
	public void test0() throws java.io.IOException {
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-gbk-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-utf8-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-utf16le-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-utf16be-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-unicode-ascii-escaped-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.has("D:\\temp\\withbom\\csv-ansi-ascii-bom.csv"));
	}

	@org.junit.Test
	public void test2() throws java.io.IOException {
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.add(java.nio.charset.StandardCharsets.UTF_8, "D:\\temp\\withoutbom\\test-utf8-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.add(java.nio.charset.StandardCharsets.UTF_16LE, "D:\\temp\\withoutbom\\test-utf16le-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.add(java.nio.charset.StandardCharsets.UTF_16BE, "D:\\temp\\withoutbom\\test-utf16be-bom.csv"));
	}

	@org.junit.Test
	public void test3() throws java.io.IOException {
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-gbk-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-utf8-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-utf16le-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-utf16be-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-unicode-ascii-escaped-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.ByteOrderMarks.remove("D:\\temp\\withbom\\csv-ansi-ascii-bom.csv"));
	}

	@org.junit.Test
	public void test4() throws java.io.IOException {
		java.lang.String[] files = new java.lang.String[]{ "D:\\temp\\withoutbom\\csv-gbk.csv", "D:\\temp\\withbom\\csv-gbk-bom.csv", "D:\\temp\\withoutbom\\csv-utf8.csv", "D:\\temp\\withbom\\csv-utf8-bom.csv", "D:\\temp\\withoutbom\\csv-utf16le.csv", "D:\\temp\\withbom\\csv-utf16le-bom.csv", "D:\\temp\\withoutbom\\csv-utf16be.csv", "D:\\temp\\withbom\\csv-utf16be-bom.csv", "D:\\temp\\withoutbom\\csv-unicode-ascii-escaped.csv", "D:\\temp\\withbom\\csv-unicode-ascii-escaped-bom.csv", "D:\\temp\\withoutbom\\csv-ansi-ascii.csv", "D:\\temp\\withbom\\csv-ansi-ascii-bom.csv" };
		for (java.lang.String file : files) {
			java.nio.charset.Charset charset = cn.ponfee.commons.io.CharsetDetector.detect(file);
			java.lang.System.out.println(((((("\n=============================" + file) + " -> ") + ", ") + charset) + "   ") + cn.ponfee.commons.io.Files.toString(new java.io.File(file)).replaceAll("\r\n|\n", ";"));
			cn.ponfee.commons.extract.DataExtractorBuilder builder = cn.ponfee.commons.extract.DataExtractorBuilder.newBuilder(file);
			builder.build().extract(100).stream().forEach(( row) -> System.out.println(cn.ponfee.commons.json.Jsons.toJson(row)));
		}
	}

	@org.junit.Test
	public void test5() throws java.io.IOException {
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\c24aafd4f3f24c2a86734b20f9a0edd3.Adobe_Fireworks_CS6_XiaZaiBa.exe"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-gbk.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-gbk-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-utf8.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-utf8-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-utf16.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\csv-utf16-bom.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\2.png"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\IMG_2485.JPG"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\ca.pfx"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\signers.xml"));
	}

	@org.junit.Test
	public void test6() throws java.io.IOException {
		java.lang.System.out.println(java.nio.charset.Charset.forName("utf-8") == java.nio.charset.StandardCharsets.UTF_8);
		java.lang.System.out.println(java.nio.charset.Charset.forName("utf8") == java.nio.charset.StandardCharsets.UTF_8);
		java.lang.System.out.println(java.nio.charset.Charset.forName("utf-16") == java.nio.charset.StandardCharsets.UTF_16);
	}

	@org.junit.Test
	public void test7() throws java.io.IOException {
		java.lang.String[] files = new java.lang.String[]{ "D:\\temp\\withoutbom\\test-utf8-bom.csv", "D:\\temp\\withoutbom\\test-utf16le-bom.csv", "D:\\temp\\withoutbom\\test-utf16be-bom.csv" };
		org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.withDelimiter(',').withQuote('"');
		for (java.lang.String file : files) {
			java.nio.charset.Charset charset = cn.ponfee.commons.io.CharsetDetector.detect(file);
			java.lang.System.out.println(((((("\n=============================" + file) + " -> ") + ", ") + charset) + "   ") + cn.ponfee.commons.io.Files.toString(new java.io.File(file)).substring(1, 1000).replaceAll("\r\n|\n", ";"));
			cn.ponfee.commons.extract.DataExtractorBuilder builder = cn.ponfee.commons.extract.DataExtractorBuilder.newBuilder(file).csvFormat(format).startRow(1);
			builder.build().extract(2).stream().forEach(( row) -> System.out.println(cn.ponfee.commons.json.Jsons.toJson(row)));
		}
	}

	@org.junit.Test
	public void test() throws java.io.IOException {
		java.lang.String file;
		cn.ponfee.commons.extract.DataExtractorBuilder builder;
		org.apache.commons.csv.CSVFormat format = org.apache.commons.csv.CSVFormat.DEFAULT.withDelimiter(',').withQuote('"');
		file = "D:\\temp\\withoutbom\\test-utf16be.csv";
		builder = cn.ponfee.commons.extract.DataExtractorBuilder.newBuilder(file).csvFormat(format).charset(java.nio.charset.StandardCharsets.UTF_16BE);
		builder.build().extract(100).stream().forEach(( row) -> System.out.println(cn.ponfee.commons.json.Jsons.toJson(row)));
	}

	@org.junit.Test
	public void test8() throws java.io.IOException {
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\withoutbom\\test-utf8.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\withoutbom\\test-utf16le.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\withoutbom\\test-utf16be.csv"));
		java.lang.System.out.println(cn.ponfee.commons.io.CharsetDetector.detect("D:\\temp\\withoutbom\\gbk.txt"));
	}

	@org.junit.Test
	public void testDetect() throws java.io.IOException {
		java.io.File filePath = cn.ponfee.commons.util.MavenProjects.getMainJavaFile(cn.ponfee.commons.spring.SpringContextHolder.class);
		java.lang.System.out.println("CharsetDetector.detect -->  " + cn.ponfee.commons.io.CharsetDetector.detect(new java.io.FileInputStream(filePath)));
		java.lang.System.out.println("EncodingDetector.detect -->  " + cn.ponfee.commons.io.charset.BytesDetector.detect(cn.ponfee.commons.io.Files.readByteArray(new java.io.FileInputStream(filePath), 12000)));
	}

	@org.junit.Test
	public void testDetectFile() {
		cn.ponfee.commons.io.FilesTest.detectFile(cn.ponfee.commons.util.MavenProjects.getTestJavaPath("cn.ponfee.commons.io.file"));
	}

	private static void detectFile(java.lang.String filePath) {
		cn.ponfee.commons.io.Files.listFiles(filePath).traverse(( tree) -> {
			if (org.apache.commons.collections4.CollectionUtils.isEmpty(tree.getChildren())) {
				try {
					java.io.File f = tree.getAttach();
					System.out.println((((f.getName() + ": CharsetDetector=") + cn.ponfee.commons.io.CharsetDetector.detect(new java.io.FileInputStream(f))) + ", EncodingDetector=") + cn.ponfee.commons.io.charset.BytesDetector.detect(cn.ponfee.commons.io.Files.readByteArray(new java.io.FileInputStream(f), 1200)));
				} catch (java.io.IOException e) {
					cn.ponfee.commons.io.e.printStackTrace();
				}
			}
		});
	}

	@org.junit.Test
	public void testFormat() {
		java.lang.String text = "JPFreq[3][74] = 600;\n" + (((((((("            JPFreq[3][45] = 599;\n" + "            JPFreq[3][3] = 598;\n") + "            JPFreq[3][24] = 597;\n") + "            JPFreq[3][30] = 596;\n") + "            JPFreq[4][76] = 485;\n") + "            JPFreq[22][65] = 3;\n") + "            JPFreq[42][29] = 2;\n") + "            JPFreq[27][66] = 1;\n") + "            JPFreq[26][89] = 0;");
		java.util.List<java.lang.String> collect = java.util.Arrays.stream(text.split(";")).map(java.lang.String::trim).collect(java.util.stream.Collectors.toList());
		int maxLeft = collect.stream().mapToInt(( s) -> s.split("=")[0].trim().length()).max().orElse(0);
		int maxRight = collect.stream().mapToInt(( s) -> s.split("=")[1].trim().length()).max().orElse(0);
		for (java.util.List<java.lang.String> line : com.google.common.collect.Lists.partition(collect, 5)) {
			java.lang.String s = line.stream().map(( e) -> {
				java.lang.String[] array = e.split("=");
				return ((org.apache.commons.lang3.StringUtils.rightPad(array[0].trim(), maxLeft, " ") + " = ") + org.apache.commons.lang3.StringUtils.leftPad(array[1].trim(), maxRight, " ")) + "; ";
			}).collect(java.util.stream.Collectors.joining());
			java.lang.System.out.println(s);
		}
	}

	public static void main(java.lang.String[] args) {
		int[][] GBFreq = new int[94][94];
		java.util.Arrays.stream(GBFreq).forEach(( e) -> java.lang.System.out.println(java.util.Arrays.toString(e)));
	}
}