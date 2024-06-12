public class Test {
	public void getCommonName() {
		java.lang.String cert = "";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("CommonName: ([\\w|\\.]+)\n\n");
		java.util.regex.Matcher matcher = pattern.matcher(cert);
		if (matcher.find()) {
			java.lang.System.out.println(matcher.group(1));
		}
	}

	public void getSerialNumber() {
		java.lang.String cert = "";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("Serial Number: (\\d+)\n");
		java.util.regex.Matcher matcher = pattern.matcher(cert);
		if (matcher.find()) {
			java.lang.System.out.println(matcher.group(1));
		}
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
	}
}