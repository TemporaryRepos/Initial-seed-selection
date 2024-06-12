@java.lang.Deprecated
public class TernaryTree {
	private static final java.lang.String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");

	private dict.build.TernaryNode root;

	public TernaryTree() {
	}

	public void insert(final java.lang.String word, final int value) {
		if (word != null) {
			this.root = insertNode(this.root, word, 0, value);
		}
	}

	public int search(final java.lang.String word) {
		return this.searchNode(this.root, word, 0);
	}

	public java.lang.String[] partialSearch(final java.lang.String word) {
		java.lang.String[] results = null;
		final java.util.List<java.lang.String> matches = this.partialSearchNode(this.root, new java.util.ArrayList<java.lang.String>(), "", word, 0);
		if (matches == null) {
			results = new java.lang.String[]{  };
		} else {
			results = matches.toArray(new java.lang.String[matches.size()]);
		}
		return results;
	}

	public java.lang.String[] nearSearch(final java.lang.String word, final int distance) {
		java.lang.String[] results = null;
		final java.util.List<java.lang.String> matches = this.nearSearchNode(this.root, distance, new java.util.ArrayList<java.lang.String>(), "", word, 0);
		if (matches == null) {
			results = new java.lang.String[]{  };
		} else {
			results = matches.toArray(new java.lang.String[matches.size()]);
		}
		return results;
	}

	public java.util.List<java.lang.String> getWords() {
		final java.util.List<java.lang.String> words = this.traverseNode(this.root, "", new java.util.ArrayList<java.lang.String>());
		return java.util.Collections.unmodifiableList(words);
	}

	public void print(final java.io.Writer out) throws java.io.IOException {
		out.write(printNode(this.root, "", 0));
	}

	private dict.build.TernaryNode insertNode(dict.build.TernaryNode node, final java.lang.String word, final int index, final int value) {
		if (index < word.length()) {
			final char c = word.charAt(index);
			if (node == null) {
				node = new dict.build.TernaryNode(c);
			}
			final char split = node.getSplitChar();
			if (c < split) {
				node.setLokid(insertNode(node.getLokid(), word, index, value));
			} else if (c == split) {
				if (index == (word.length() - 1)) {
					node.setEndOfWord(value);
				}
				node.setEqkid(insertNode(node.getEqkid(), word, index + 1, value));
			} else {
				node.setHikid(insertNode(node.getHikid(), word, index, value));
			}
		}
		return node;
	}

	private int searchNode(final dict.build.TernaryNode node, final java.lang.String word, final int index) {
		if ((node != null) && (index < word.length())) {
			final char c = word.charAt(index);
			final char split = node.getSplitChar();
			if (c < split) {
				return searchNode(node.getLokid(), word, index);
			} else if (c > split) {
				return searchNode(node.getHikid(), word, index);
			} else if (index == (word.length() - 1)) {
				if (node.isEndOfWord()) {
					return node.getValue();
				}
			} else {
				return searchNode(node.getEqkid(), word, index + 1);
			}
		}
		return -1;
	}

	private java.util.List<java.lang.String> partialSearchNode(final dict.build.TernaryNode node, java.util.List<java.lang.String> matches, final java.lang.String match, final java.lang.String word, final int index) {
		if ((node != null) && (index < word.length())) {
			final char c = word.charAt(index);
			final char split = node.getSplitChar();
			if ((c == '.') || (c < split)) {
				matches = partialSearchNode(node.getLokid(), matches, match, word, index);
			}
			if ((c == '.') || (c == split)) {
				if (index == (word.length() - 1)) {
					if (node.isEndOfWord()) {
						matches.add(match + split);
					}
				} else {
					matches = partialSearchNode(node.getEqkid(), matches, match + split, word, index + 1);
				}
			}
			if ((c == '.') || (c > split)) {
				matches = partialSearchNode(node.getHikid(), matches, match, word, index);
			}
		}
		return matches;
	}

	private java.util.List<java.lang.String> nearSearchNode(final dict.build.TernaryNode node, final int distance, java.util.List<java.lang.String> matches, final java.lang.String match, final java.lang.String word, final int index) {
		if ((node != null) && (distance >= 0)) {
			final char c;
			if (index < word.length()) {
				c = word.charAt(index);
			} else {
				c = ((char) (-1));
			}
			final char split = node.getSplitChar();
			if ((distance > 0) || (c < split)) {
				matches = nearSearchNode(node.getLokid(), distance, matches, match, word, index);
			}
			final java.lang.String newMatch = match + split;
			if (c == split) {
				if ((node.isEndOfWord() && (distance >= 0)) && ((newMatch.length() + distance) >= word.length())) {
					matches.add(newMatch);
				}
				matches = nearSearchNode(node.getEqkid(), distance, matches, newMatch, word, index + 1);
			} else {
				if ((node.isEndOfWord() && ((distance - 1) >= 0)) && (((newMatch.length() + distance) - 1) >= word.length())) {
					matches.add(newMatch);
				}
				matches = nearSearchNode(node.getEqkid(), distance - 1, matches, newMatch, word, index + 1);
			}
			if ((distance > 0) || (c > split)) {
				matches = nearSearchNode(node.getHikid(), distance, matches, match, word, index);
			}
		}
		return matches;
	}

	private java.util.List<java.lang.String> traverseNode(final dict.build.TernaryNode node, final java.lang.String s, java.util.List<java.lang.String> words) {
		if (node != null) {
			words = this.traverseNode(node.getLokid(), s, words);
			final java.lang.String c = java.lang.String.valueOf(node.getSplitChar());
			if (node.getEqkid() != null) {
				words = this.traverseNode(node.getEqkid(), s + c, words);
			}
			if (node.isEndOfWord()) {
				words.add(s + c);
			}
			words = this.traverseNode(node.getHikid(), s, words);
		}
		return words;
	}

	private java.lang.String printNode(final dict.build.TernaryNode node, final java.lang.String s, final int depth) {
		final java.lang.StringBuffer buffer = new java.lang.StringBuffer();
		if (node != null) {
			buffer.append(this.printNode(node.getLokid(), " <-", depth + 1));
			final java.lang.String c = java.lang.String.valueOf(node.getSplitChar());
			final java.lang.StringBuffer eq = new java.lang.StringBuffer();
			if (node.getEqkid() != null) {
				eq.append(this.printNode(node.getEqkid(), (s + c) + "--", depth + 1));
			} else {
				int count = new java.util.StringTokenizer(s, "--").countTokens();
				if (count > 0) {
					count--;
				}
				for (int i = 1; i < ((depth - count) - 1); i++) {
					eq.append("   ");
				}
				eq.append(s).append(c).append(dict.build.TernaryTree.LINE_SEPARATOR);
			}
			buffer.append(eq);
			buffer.append(this.printNode(node.getHikid(), " >-", depth + 1));
		}
		return buffer.toString();
	}

	public static void main(java.lang.String[] args) {
		dict.build.TernaryTree tt = new dict.build.TernaryTree();
		tt.insert("a", 1);
		tt.insert("aa", 2);
		tt.insert("aaa", 3);
		tt.insert("aaaa", 4);
		java.lang.System.out.println(tt.search("aaa"));
	}
}