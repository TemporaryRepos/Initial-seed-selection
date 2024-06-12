public class Bug4533872 extends javaT.text.testlib.IntlTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.BreakIterator.Bug4533872().run(args);
	}

	static final java.lang.String[] given = new java.lang.String[]{ "XYZ12345 ABCDE  abcde", "123𐀀345 ABC｡XYZ  abc", "123𐀀345 ABC𐄀XYZ  abc", "ABCabc?xyz?ABC𐀀XYZ" };

	static final java.lang.String[][] expected = new java.lang.String[][]{ new java.lang.String[]{ "XYZ12345", " ", "ABCDE", "  ", "abcde" }, new java.lang.String[]{ "123𐀀345", " ", "ABC", "｡", "XYZ", "  ", "abc" }, new java.lang.String[]{ "123𐀀345", " ", "ABC", "𐄀", "XYZ", "  ", "abc" }, new java.lang.String[]{ "ABCabc", "?", "xyz", "?", "ABC𐀀XYZ" } };

	java.text.BreakIterator iter;

	int start;

	int end;

	int current;

	void TestNext() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			start = iter.first();
			int j = javaT.text.BreakIterator.Bug4533872.expected[i].length - 1;
			start = iter.next(j);
			end = iter.next();
			if (!javaT.text.BreakIterator.Bug4533872.expected[i][j].equals(javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end))) {
				errln((((((("Word break failure: printEachForward() expected:<" + javaT.text.BreakIterator.Bug4533872.expected[i][j]) + ">, got:<") + javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end)) + "> start=") + start) + "  end=") + end);
			}
		}
	}

	void TestIsBoundary() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			start = iter.first();
			end = iter.next();
			while (end < javaT.text.BreakIterator.Bug4533872.given[i].length()) {
				if (!iter.isBoundary(end)) {
					errln((("Word break failure: isBoundary() This should be a boundary. Index=" + end) + " for ") + javaT.text.BreakIterator.Bug4533872.given[i]);
				}
				end = iter.next();
			} 
		}
	}

	void TestPrintEachForward() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			start = iter.first();
			current = iter.current();
			if (start != current) {
				errln((("Word break failure: printEachForward() Unexpected current value: current()=" + current) + ", expected(=first())=") + start);
			}
			int j = 0;
			for (end = iter.next(); end != java.text.BreakIterator.DONE; start = end , end = iter.next() , j++) {
				current = iter.current();
				if (end != current) {
					errln((("Word break failure: printEachForward() Unexpected current value: current()=" + current) + ", expected(=next())=") + end);
				}
				if (!javaT.text.BreakIterator.Bug4533872.expected[i][j].equals(javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end))) {
					errln((((((("Word break failure: printEachForward() expected:<" + javaT.text.BreakIterator.Bug4533872.expected[i][j]) + ">, got:<") + javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end)) + "> start=") + start) + "  end=") + end);
				}
			}
		}
	}

	void TestPrintEachBackward() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			end = iter.last();
			current = iter.current();
			if (end != current) {
				errln((("Word break failure: printEachBackward() Unexpected current value: current()=" + current) + ", expected(=last())=") + end);
			}
			int j;
			for (start = iter.previous(), j = javaT.text.BreakIterator.Bug4533872.expected[i].length - 1; start != java.text.BreakIterator.DONE; end = start , start = iter.previous() , j--) {
				current = iter.current();
				if (start != current) {
					errln((("Word break failure: printEachBackward() Unexpected current value: current()=" + current) + ", expected(=previous())=") + start);
				}
				if (!javaT.text.BreakIterator.Bug4533872.expected[i][j].equals(javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end))) {
					errln((((((("Word break failure: printEachBackward() expected:<" + javaT.text.BreakIterator.Bug4533872.expected[i][j]) + ">, got:<") + javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end)) + "> start=") + start) + "  end=") + end);
				}
			}
		}
	}

	void TestPrintAt_1() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		int[][] index = new int[][]{ new int[]{ 2, 8, 10, 15, 17 }, new int[]{ 1, 8, 10, 12, 15, 17, 20 }, new int[]{ 3, 8, 10, 13, 16, 18, 20 }, new int[]{ 4, 6, 9, 10, 16 } };
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			for (int j = index[i].length - 1; j >= 0; j--) {
				end = iter.following(index[i][j]);
				start = iter.previous();
				if (!javaT.text.BreakIterator.Bug4533872.expected[i][j].equals(javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end))) {
					errln((((((("Word break failure: printAt_1() expected:<" + javaT.text.BreakIterator.Bug4533872.expected[i][j]) + ">, got:<") + javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end)) + "> start=") + start) + "  end=") + end);
				}
			}
		}
	}

	void TestPrintAt_2() {
		iter = java.text.BreakIterator.getWordInstance(java.util.Locale.US);
		int[][] index = new int[][]{ new int[]{ 2, 9, 10, 15, 17 }, new int[]{ 1, 9, 10, 13, 16, 18, 20 }, new int[]{ 4, 9, 10, 13, 16, 18, 20 }, new int[]{ 6, 7, 10, 11, 15 } };
		for (int i = 0; i < javaT.text.BreakIterator.Bug4533872.given.length; i++) {
			iter.setText(javaT.text.BreakIterator.Bug4533872.given[i]);
			if (iter.preceding(0) != java.text.BreakIterator.DONE) {
				errln("Word break failure: printAt_2() expected:-1(BreakIterator.DONE), got:" + iter.preceding(0));
			}
			for (int j = 0; j < index[i].length; j++) {
				start = iter.preceding(index[i][j]);
				end = iter.next();
				if (!javaT.text.BreakIterator.Bug4533872.expected[i][j].equals(javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end))) {
					errln((((((("Word break failure: printAt_2() expected:<" + javaT.text.BreakIterator.Bug4533872.expected[i][j]) + ">, got:<") + javaT.text.BreakIterator.Bug4533872.given[i].substring(start, end)) + "> start=") + start) + "  end=") + end);
				}
			}
			end = iter.last();
			start = iter.next();
			if (start != java.text.BreakIterator.DONE) {
				errln("Word break failure: printAt_2() expected:-1(BreakIterator.DONE), got:" + start);
			}
		}
	}
}