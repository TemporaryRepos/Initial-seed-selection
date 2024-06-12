public class ExceptionTest {
	private static final java.lang.String text = "An ordered collection (also known as a sequence). " + ((("The user of this interface has precise control over " + "where in the list each element is inserted. ") + "The user can access elements by their integer index (position in the list), ") + "and search for elements in the list.");

	public static void main(java.lang.String[] args) {
		java.text.BreakIterator bi = java.text.BreakIterator.getWordInstance();
		bi.setText(javaT.text.BreakIterator.ExceptionTest.text);
		javaT.text.BreakIterator.MirroredBreakIterator mirror = new javaT.text.BreakIterator.MirroredBreakIterator(bi);
		final int first = bi.first();
		if (first != 0) {
			throw new java.lang.RuntimeException("first != 0: " + first);
		}
		final int last = bi.last();
		bi = java.text.BreakIterator.getWordInstance();
		bi.setText(javaT.text.BreakIterator.ExceptionTest.text);
		int length = javaT.text.BreakIterator.ExceptionTest.text.length();
		for (int i = 0; i <= length; i++) {
			if (i == length) {
				javaT.text.BreakIterator.ExceptionTest.check(bi.following(i), java.text.BreakIterator.DONE);
			}
			javaT.text.BreakIterator.ExceptionTest.check(bi.following(i), mirror.following(i));
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = -length; i < 0; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkFollowingException(bi, i);
			javaT.text.BreakIterator.ExceptionTest.checkFollowingException(mirror, i);
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = 1; i < length; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkFollowingException(bi, length + i);
			javaT.text.BreakIterator.ExceptionTest.checkFollowingException(mirror, length + i);
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = length; i >= 0; i--) {
			if (i == 0) {
				javaT.text.BreakIterator.ExceptionTest.check(bi.preceding(i), java.text.BreakIterator.DONE);
			}
			javaT.text.BreakIterator.ExceptionTest.check(bi.preceding(i), mirror.preceding(i));
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = -length; i < 0; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkPrecedingException(bi, i);
			javaT.text.BreakIterator.ExceptionTest.checkPrecedingException(mirror, i);
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = 1; i < length; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkPrecedingException(bi, length + i);
			javaT.text.BreakIterator.ExceptionTest.checkPrecedingException(mirror, length + i);
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = 0; i <= length; i++) {
			javaT.text.BreakIterator.ExceptionTest.check(bi.isBoundary(i), mirror.isBoundary(i));
			javaT.text.BreakIterator.ExceptionTest.check(bi.current(), mirror.current());
		}
		for (int i = -length; i < 0; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkIsBoundaryException(bi, i);
			javaT.text.BreakIterator.ExceptionTest.checkIsBoundaryException(mirror, i);
		}
		for (int i = 1; i < length; i++) {
			javaT.text.BreakIterator.ExceptionTest.checkIsBoundaryException(bi, length + i);
			javaT.text.BreakIterator.ExceptionTest.checkIsBoundaryException(mirror, length + i);
		}
	}

	private static void check(int i1, int i2) {
		if (i1 != i2) {
			throw new java.lang.RuntimeException((i1 + " != ") + i2);
		}
	}

	private static void check(boolean b1, boolean b2) {
		if (b1 != b2) {
			throw new java.lang.RuntimeException((b1 + " != ") + b2);
		}
	}

	private static void checkFollowingException(java.text.BreakIterator bi, int offset) {
		try {
			bi.following(offset);
		} catch (java.lang.IllegalArgumentException e) {
			return;
		}
		throw new java.lang.RuntimeException((bi + ": following() doesn't throw an IAE with offset ") + offset);
	}

	private static void checkPrecedingException(java.text.BreakIterator bi, int offset) {
		try {
			bi.preceding(offset);
		} catch (java.lang.IllegalArgumentException e) {
			return;
		}
		throw new java.lang.RuntimeException((bi + ": preceding() doesn't throw an IAE with offset ") + offset);
	}

	private static void checkIsBoundaryException(java.text.BreakIterator bi, int offset) {
		try {
			bi.isBoundary(offset);
		} catch (java.lang.IllegalArgumentException e) {
			return;
		}
		throw new java.lang.RuntimeException((bi + ": isBoundary() doesn't throw an IAE with offset ") + offset);
	}
}