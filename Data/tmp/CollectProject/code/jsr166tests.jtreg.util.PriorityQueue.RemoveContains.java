public class RemoveContains {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.passed++;
		} else {
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.fail(msg);
		}
	}

	static void check(boolean condition) {
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(condition, "Assertion failure");
	}

	public static void main(java.lang.String[] args) {
		final java.util.Comparator<java.lang.String> firstChar = new java.util.Comparator<java.lang.String>() {
			public int compare(java.lang.String x, java.lang.String y) {
				return x.charAt(0) - y.charAt(0);
			}
		};
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.PriorityQueue<java.lang.String>(10, firstChar));
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.PriorityBlockingQueue<java.lang.String>(10, firstChar));
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.ArrayBlockingQueue<java.lang.String>(10));
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.LinkedBlockingQueue<java.lang.String>(10));
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.LinkedBlockingDeque<java.lang.String>(10));
		jsr166tests.jtreg.util.PriorityQueue.RemoveContains.test(new java.util.ArrayDeque<java.lang.String>(10));
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", jsr166tests.jtreg.util.PriorityQueue.RemoveContains.passed, jsr166tests.jtreg.util.PriorityQueue.RemoveContains.failed);
		if (jsr166tests.jtreg.util.PriorityQueue.RemoveContains.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}

	private static void test(java.util.Queue<java.lang.String> q) {
		try {
			java.util.List<java.lang.String> words = java.util.Arrays.asList("foo", "fee", "fi", "fo", "fum", "Englishman");
			q.addAll(words);
			for (java.lang.String word : words) {
				jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(q.contains(word));
			}
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(!q.contains("flurble"));
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(q.remove("fi"));
			for (java.lang.String word : words) {
				jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(q.contains(word) ^ word.equals("fi"));
			}
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(!q.remove("fi"));
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.check(!q.remove("flurble"));
		} catch (java.lang.Throwable t) {
			jsr166tests.jtreg.util.PriorityQueue.RemoveContains.unexpected(t);
		}
	}
}