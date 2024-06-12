public class Tools {
	private static final java.lang.String regxpForHtml = "<([^>]*)>";

	public static java.util.List<java.lang.String> read2List(java.lang.String target) {
		java.util.List<java.lang.String> lines = new java.util.ArrayList<java.lang.String>();
		try (final java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.StringReader(target))) {
			java.lang.String tmp = reader.readLine();
			while (tmp != null) {
				lines.add(tmp);
				tmp = reader.readLine();
			} 
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public static java.lang.String filterHtml(java.lang.String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(com.youbenzi.mdtool.tool.Tools.regxpForHtml);
		java.util.regex.Matcher matcher = pattern.matcher(str);
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		boolean result = matcher.find();
		while (result) {
			matcher.appendReplacement(sb, "");
			result = matcher.find();
		} 
		matcher.appendTail(sb);
		return sb.toString();
	}

	public static java.lang.String revertValue(java.lang.String value) {
		for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : com.youbenzi.mdtool.markdown.MDToken.PLACEHOLDER_MAP.entrySet()) {
			java.lang.String tmpValue = entry.getKey().substring(1);
			value = value.replace(entry.getValue(), tmpValue);
		}
		return value;
	}

	public static java.lang.String convertValue(java.lang.String value) {
		for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : com.youbenzi.mdtool.markdown.MDToken.PLACEHOLDER_MAP.entrySet()) {
			value = value.replace(entry.getKey(), entry.getValue());
		}
		return value;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String t = "1. 123\n" + (((("2. 123123\n" + "\t3. 12312\n") + "\t4. 123123\n") + "\t5. 12312\n") + "1. 13123");
		java.lang.System.out.println(t.indexOf("\t"));
		java.lang.System.out.println(t.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;"));
	}
}