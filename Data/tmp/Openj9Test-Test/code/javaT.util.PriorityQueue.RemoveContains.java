public class RemoveContains {
	static volatile int passed = 0;

	static volatile int failed = 0;

	static void fail(java.lang.String msg) {
		javaT.util.PriorityQueue.RemoveContains.failed++;
		new java.lang.AssertionError(msg).printStackTrace();
	}

	static void pass() {
		javaT.util.PriorityQueue.RemoveContains.passed++;
	}

	static void unexpected(java.lang.Throwable t) {
		javaT.util.PriorityQueue.RemoveContains.failed++;
		t.printStackTrace();
	}

	static void check(boolean condition, java.lang.String msg) {
		if (condition) {
			javaT.util.PriorityQueue.RemoveContains.passed++;
		} else {
			javaT.util.PriorityQueue.RemoveContains.fail(msg);
		}
	}

	static void check(boolean condition) {
		javaT.util.PriorityQueue.RemoveContains.check(condition, "Assertion failure");
	}

	public static void main(java.lang.String[] args) {
		final java.util.Comparator<java.lang.String> firstChar = new java.util.Comparator<java.lang.String>() {
			public int compare(java.lang.String x, java.lang.String y) {
				return x.charAt(0) - y.charAt(0);
			}
		};
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.PriorityQueue<java.lang.String>(firstChar));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.PriorityQueue<java.lang.String>(10, firstChar));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.PriorityBlockingQueue<java.lang.String>(10, firstChar));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.ArrayBlockingQueue<java.lang.String>(10));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.LinkedBlockingQueue<java.lang.String>(10));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.LinkedBlockingDeque<java.lang.String>(10));
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.concurrent.LinkedTransferQueue<java.lang.String>());
		javaT.util.PriorityQueue.RemoveContains.test(new java.util.ArrayDeque<java.lang.String>(10));
		java.lang.System.out.printf("%nPassed = %d, failed = %d%n%n", javaT.util.PriorityQueue.RemoveContains.passed, javaT.util.PriorityQueue.RemoveContains.failed);
		if (javaT.util.PriorityQueue.RemoveContains.failed > 0) {
			throw new java.lang.Error("Some tests failed");
		}
	}

	private static void test(java.util.Queue<java.lang.String> q) {
		try {
			java.util.List<java.lang.String> words = java.util.Arrays.asList("foo", "fee", "fi", "fo", "fum", "Englishman");
			q.addAll(words);
			for (java.lang.String word : words) {
				javaT.util.PriorityQueue.RemoveContains.check(q.contains(word));
			}
			javaT.util.PriorityQueue.RemoveContains.check(!q.contains("flurble"));
			javaT.util.PriorityQueue.RemoveContains.check(q.remove("fi"));
			for (java.lang.String word : words) {
				javaT.util.PriorityQueue.RemoveContains.check(q.contains(word) ^ word.equals("fi"));
			}
			javaT.util.PriorityQueue.RemoveContains.check(!q.remove("fi"));
			javaT.util.PriorityQueue.RemoveContains.check(!q.remove("flurble"));
		} catch (java.lang.Throwable t) {
			javaT.util.PriorityQueue.RemoveContains.unexpected(t);
		}
	}
}