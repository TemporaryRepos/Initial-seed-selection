@org.junit.Ignore
public class DictSlimTest {
	@org.junit.Test
	@org.junit.Ignore
	public void formatTest() {
		final java.lang.String sourceFile = "D:\\github\\sensitive-word\\src\\main\\resources\\dict.txt";
		final java.lang.String targetFile = "D:\\github\\sensitive-word\\src\\main\\resources\\dict.txt";
		java.util.List<java.lang.String> words = com.github.houbb.heaven.util.io.FileUtil.readAllLines(sourceFile);
		java.util.List<java.lang.String> formats = com.github.houbb.heaven.util.util.CollectionUtil.toList(words, new com.github.houbb.heaven.support.handler.IHandler<java.lang.String, java.lang.String>() {
			@java.lang.Override
			public java.lang.String handle(java.lang.String string) {
				java.lang.String lower = string.toLowerCase();
				java.lang.String half = com.github.houbb.heaven.util.lang.StringUtil.toHalfWidth(lower);
				java.lang.String trim = com.github.houbb.heaven.util.lang.StringUtil.trimAnyBlank(half);
				java.lang.String punc = com.github.houbb.heaven.util.lang.StringUtil.trimAnyPunctionAndSymbol(trim);
				return com.github.houbb.opencc4j.core.impl.ZhConvertBootstrap.newInstance(new com.github.houbb.opencc4j.support.segment.impl.CharSegment()).toSimple(punc);
			}
		});
		java.util.List<java.lang.String> resultList = com.github.houbb.sensitive.word.data.DataUtil.disctinctAndSort(formats);
		com.github.houbb.heaven.util.io.FileUtil.write(targetFile, resultList);
	}

	@org.junit.Test
	@org.junit.Ignore
	public void removeTest() {
		final java.lang.String sourceFile = "D:\\github\\sensitive-word\\src\\main\\resources\\dict.txt";
		final java.lang.String targetFile = "D:\\github\\sensitive-word\\src\\main\\resources\\dict.txt";
		java.util.List<java.lang.String> words = com.github.houbb.heaven.util.io.FileUtil.readAllLines(sourceFile);
		java.util.List<java.lang.String> formats = com.github.houbb.heaven.util.util.CollectionUtil.filterList(words, new com.github.houbb.heaven.support.filter.IFilter<java.lang.String>() {
			@java.lang.Override
			public boolean filter(java.lang.String string) {
				return ((com.github.houbb.heaven.util.lang.StringUtil.isDigitOrLetter(string) || string.contains("�")) || string.contains("删掉")) || com.github.houbb.sensitive.word.data.DictSlimTest.isUrl(string);
			}
		});
		java.util.List<java.lang.String> resultList = com.github.houbb.sensitive.word.data.DataUtil.disctinctAndSort(formats);
		com.github.houbb.heaven.util.io.FileUtil.write(targetFile, resultList);
	}

	@org.junit.Test
	public void removeNumberMappingTest() {
		final java.lang.String sourceFile = "D:\\_github\\sensitive-word\\src\\main\\resources\\dict.txt";
		final java.lang.String targetFile = "D:\\_github\\sensitive-word\\src\\main\\resources\\dict.txt";
		java.util.List<java.lang.String> words = com.github.houbb.heaven.util.io.FileUtil.readAllLines(sourceFile);
		java.util.List<java.lang.String> formats = com.github.houbb.heaven.util.util.CollectionUtil.toList(words, new com.github.houbb.heaven.support.handler.IHandler<java.lang.String, java.lang.String>() {
			@java.lang.Override
			public java.lang.String handle(java.lang.String s) {
				return s.replaceAll(" ", "");
			}
		});
		java.util.List<java.lang.String> filters = com.github.houbb.heaven.util.util.CollectionUtil.filterList(formats, new com.github.houbb.heaven.support.filter.IFilter<java.lang.String>() {
			@java.lang.Override
			public boolean filter(java.lang.String string) {
				return com.github.houbb.sensitive.word.data.DictSlimTest.isNumber(string);
			}
		});
		java.util.List<java.lang.String> resultList = com.github.houbb.sensitive.word.data.DataUtil.disctinctAndSort(filters);
		com.github.houbb.heaven.util.io.FileUtil.write(targetFile, resultList);
	}

	private static boolean isNumber(final java.lang.String string) {
		if (string.length() <= 4) {
			return false;
		}
		java.lang.String trim = string.replaceAll("加|否|与|和", "");
		java.lang.String mapString = com.github.houbb.sensitive.word.utils.InnerWordNumUtils.getMappingString(trim);
		boolean result = com.github.houbb.heaven.util.lang.StringUtil.isDigit(mapString);
		if (result) {
			java.lang.System.out.println(string);
		}
		return result;
	}

	private static boolean isUrl(final java.lang.String string) {
		return (string.endsWith(".com") || string.endsWith(".cn")) || string.endsWith(".org");
	}

	public static void main(java.lang.String[] args) {
		java.lang.String trim = "1和2".replaceAll("加|否|与|和", "");
		java.lang.System.out.println(trim);
	}
}