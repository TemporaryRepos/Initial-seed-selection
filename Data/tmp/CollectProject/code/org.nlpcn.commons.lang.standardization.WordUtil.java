public class WordUtil {
	private java.lang.Character num2Value;

	private java.lang.Character en2Value;

	public WordUtil(java.lang.Character num2Value, java.lang.Character enValue) {
		this.num2Value = num2Value;
		this.en2Value = enValue;
	}

	public java.util.List<org.nlpcn.commons.lang.standardization.Element> str2Elements(java.lang.String str) {
		if ((str == null) || (str.trim().length() == 0)) {
			return java.util.Collections.emptyList();
		}
		char[] chars = org.nlpcn.commons.lang.util.WordAlert.alertStr(str);
		int maxLen = chars.length - 1;
		java.util.List<org.nlpcn.commons.lang.standardization.Element> list = new java.util.ArrayList<org.nlpcn.commons.lang.standardization.Element>();
		org.nlpcn.commons.lang.standardization.Element element = null;
		out : for (int i = 0; i < chars.length; i++) {
			if (((num2Value != null) && (chars[i] >= '0')) && (chars[i] <= '9')) {
				element = new org.nlpcn.commons.lang.standardization.Element(num2Value);
				list.add(element);
				if (i == maxLen) {
					break out;
				}
				char c = chars[++i];
				while (((c == '.') || (c == '%')) || ((c >= '0') && (c <= '9'))) {
					if (i == maxLen) {
						break out;
					}
					c = chars[++i];
					element.len();
				} 
				i--;
			} else if (((en2Value != null) && (chars[i] >= 'a')) && (chars[i] <= 'z')) {
				element = new org.nlpcn.commons.lang.standardization.Element(en2Value);
				list.add(element);
				if (i == maxLen) {
					break out;
				}
				char c = chars[++i];
				while ((c >= 'a') && (c <= 'z')) {
					if (i == maxLen) {
						break out;
					}
					c = chars[++i];
					element.len();
				} 
				i--;
			} else {
				list.add(new org.nlpcn.commons.lang.standardization.Element(chars[i]));
			}
		}
		return list;
	}

	public java.lang.String str2Str(java.lang.String str) {
		return new java.lang.String(str2Chars(str));
	}

	public char[] str2Chars(java.lang.String str) {
		java.util.List<org.nlpcn.commons.lang.standardization.Element> elements = str2Elements(str);
		char[] chars = new char[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			chars[i] = elements.get(i).name;
		}
		return chars;
	}

	public static void main(java.lang.String[] args) {
		org.nlpcn.commons.lang.standardization.WordUtil wordUtil = new org.nlpcn.commons.lang.standardization.WordUtil('1', 'A');
		java.lang.System.out.println(wordUtil.str2Elements("123中国CHINA456你好!"));
		java.lang.System.out.println(java.util.Arrays.toString(wordUtil.str2Chars("123中国CHINA456你好!")));
		java.lang.System.out.println(wordUtil.str2Str("123中国CHINA456你好!"));
	}
}