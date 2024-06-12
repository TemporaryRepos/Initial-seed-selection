public class IteratorTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.IteratorTest().run(args);
	}

	public void TestPrevious() throws java.text.ParseException {
		backAndForth(en_us.getCollationElementIterator(test1));
		java.text.RuleBasedCollator c1 = new java.text.RuleBasedCollator("< a,A < b,B < c,C, d,D < z,Z < ch,cH,Ch,CH");
		backAndForth(c1.getCollationElementIterator("abchdcba"));
		java.text.RuleBasedCollator c2 = new java.text.RuleBasedCollator("< a < b < c/abd < d");
		backAndForth(c2.getCollationElementIterator("abcd"));
		java.text.RuleBasedCollator c3 = new java.text.RuleBasedCollator("< a < b < c/aba < d < z < ch");
		backAndForth(c3.getCollationElementIterator("abcdbchdc"));
	}

	public void TestOffset() {
		java.text.CollationElementIterator iter = en_us.getCollationElementIterator(test1);
		int[] orders = getOrders(iter);
		int offset = iter.getOffset();
		if (offset != test1.length()) {
			java.lang.System.out.println((("offset at end != length: " + offset) + " vs ") + test1.length());
		}
		iter.setOffset(0);
		assertEqual(iter, en_us.getCollationElementIterator(test1));
	}

	public void TestSetText() {
		java.text.CollationElementIterator iter1 = en_us.getCollationElementIterator(test1);
		java.text.CollationElementIterator iter2 = en_us.getCollationElementIterator(test2);
		int c = iter2.next();
		int i = 0;
		while (((++i) < 10) && (c != java.text.CollationElementIterator.NULLORDER)) {
			c = iter2.next();
		} 
		iter2.setText(test1);
		assertEqual(iter1, iter2);
	}

	public void TestMaxExpansion() throws java.text.ParseException {
		java.lang.String[][] test1 = new java.lang.String[][]{ new java.lang.String[]{ "< a & ae = ä < b < e", "" }, new java.lang.String[]{ "a", "1" }, new java.lang.String[]{ "b", "1" }, new java.lang.String[]{ "e", "2" } };
		verifyExpansion(test1);
		java.lang.String[][] test2 = new java.lang.String[][]{ new java.lang.String[]{ "< a & ae = a1 & aeef = z < b < e < f", "" }, new java.lang.String[]{ "a", "1" }, new java.lang.String[]{ "b", "1" }, new java.lang.String[]{ "e", "2" }, new java.lang.String[]{ "f", "4" } };
		verifyExpansion(test2);
	}

	public void TestClearBuffers() throws java.text.ParseException {
		java.text.RuleBasedCollator c = new java.text.RuleBasedCollator("< a < b < c & ab = d");
		java.text.CollationElementIterator i = c.getCollationElementIterator("abcd");
		int e0 = i.next();
		i.setOffset(3);
		i.next();
		i.setOffset(0);
		int e = i.next();
		if (e != e0) {
			errln((("got " + java.lang.Integer.toString(e, 16)) + ", expected ") + java.lang.Integer.toString(e0, 16));
		}
	}

	private void backAndForth(java.text.CollationElementIterator iter) {
		int[] orders = getOrders(iter);
		int index = orders.length;
		int o;
		while ((o = iter.previous()) != java.text.CollationElementIterator.NULLORDER) {
			if (o != orders[--index]) {
				errln((((("Mismatch at index " + index) + ": ") + orders[index]) + " vs ") + o);
				break;
			}
		} 
		if (index != 0) {
			errln("Didn't get back to beginning - index is " + index);
			iter.reset();
			err("next: ");
			while ((o = iter.next()) != javaT.text.Collator.IteratorTest.NULLORDER) {
				err(java.lang.Integer.toHexString(o) + " ");
			} 
			errln("");
			err("prev: ");
			while ((o = iter.previous()) != javaT.text.Collator.IteratorTest.NULLORDER) {
				err(java.lang.Integer.toHexString(o) + " ");
			} 
			errln("");
		}
	}

	private void verifyExpansion(java.lang.String[][] tests) throws java.text.ParseException {
		java.text.RuleBasedCollator coll = new java.text.RuleBasedCollator(tests[0][0]);
		java.text.CollationElementIterator iter = coll.getCollationElementIterator("");
		for (int i = 1; i < tests.length; i++) {
			iter.setText(tests[i][0]);
			int order = iter.next();
			if ((order == javaT.text.Collator.IteratorTest.NULLORDER) || (iter.next() != javaT.text.Collator.IteratorTest.NULLORDER)) {
				iter.reset();
				errln((("verifyExpansion: '" + tests[i][0]) + "' has multiple orders:") + orderString(iter));
			}
			int expansion = iter.getMaxExpansion(order);
			int expect = new java.lang.Integer(tests[i][1]).intValue();
			if (expansion != expect) {
				errln(((((("expansion for '" + tests[i][0]) + "' is wrong: ") + "expected ") + expect) + ", got ") + expansion);
			}
		}
	}

	private int[] getOrders(java.text.CollationElementIterator iter) {
		int maxSize = 100;
		int size = 0;
		int[] orders = new int[maxSize];
		int order;
		while ((order = iter.next()) != javaT.text.Collator.IteratorTest.NULLORDER) {
			if (size == maxSize) {
				maxSize *= 2;
				int[] temp = new int[maxSize];
				java.lang.System.arraycopy(orders, 0, temp, 0, size);
				orders = temp;
			}
			orders[size++] = order;
		} 
		if (orders.length > size) {
			int[] temp = new int[size];
			java.lang.System.arraycopy(orders, 0, temp, 0, size);
			orders = temp;
		}
		return orders;
	}

	private java.lang.String orderString(java.text.CollationElementIterator iter) {
		java.lang.StringBuffer buf = new java.lang.StringBuffer();
		int order;
		while ((order = iter.next()) != javaT.text.Collator.IteratorTest.NULLORDER) {
			buf.append(java.lang.Integer.toHexString(order) + " ");
		} 
		return buf.toString();
	}

	private static final int NULLORDER = java.text.CollationElementIterator.NULLORDER;

	java.text.RuleBasedCollator en_us = ((java.text.RuleBasedCollator) (java.text.Collator.getInstance(java.util.Locale.US)));

	java.lang.String test1 = "What subset of all possible test cases?";

	java.lang.String test2 = "has the highest probability of detecting";
}