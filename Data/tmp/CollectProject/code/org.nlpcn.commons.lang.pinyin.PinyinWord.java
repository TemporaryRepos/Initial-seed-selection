public class PinyinWord {
	public java.lang.String py;

	public int tone;

	PinyinWord(java.lang.String pinyinStr) {
		this.py = pinyinStr.substring(0, pinyinStr.length() - 1);
		char c = pinyinStr.charAt(pinyinStr.length() - 1);
		if ((c >= '0') && (c <= '9')) {
			this.tone = java.lang.Integer.parseInt(java.lang.String.valueOf(c));
		} else {
			this.py = pinyinStr;
		}
	}

	public PinyinWord(char c) {
		this.py = java.lang.String.valueOf(c);
	}

	@java.lang.Override
	public java.lang.String toString() {
		if (tone > 0) {
			return this.py + tone;
		} else {
			return this.py;
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(new org.nlpcn.commons.lang.pinyin.PinyinWord("bei3"));
	}
}