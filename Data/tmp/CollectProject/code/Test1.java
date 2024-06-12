public class Test1 {
	public static void main(java.lang.String[] args) {
		java.lang.String str = "a\n\rb\n\rc\n\r";
		java.lang.System.out.println(str.indexOf("b"));
		str = "sdfsfsteerwfwfdsvsdfggefdf";
		java.lang.System.out.println(str.indexOf("sssssssssss"));
		java.lang.String header = "bbb: sdsdsd:sdsdsdsd";
		java.lang.System.out.println(header.substring(0, header.indexOf(":")));
		java.lang.System.out.println(utils.Util.trimStart(header.substring(header.indexOf(":") + 1, header.length())));
	}
}