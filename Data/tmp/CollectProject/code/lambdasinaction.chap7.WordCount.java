public class WordCount {
	public static final java.lang.String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " + ("mi  ritrovai in una  selva oscura" + " che la  dritta via era   smarrita ");

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(("Found " + lambdasinaction.chap7.WordCount.countWordsIteratively(lambdasinaction.chap7.WordCount.SENTENCE)) + " words");
		java.lang.System.out.println(("Found " + lambdasinaction.chap7.WordCount.countWords(lambdasinaction.chap7.WordCount.SENTENCE)) + " words");
	}

	public static int countWordsIteratively(java.lang.String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (java.lang.Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) {
					counter++;
				}
				lastSpace = java.lang.Character.isWhitespace(c);
			}
		}
		return counter;
	}

	public static int countWords(java.lang.String s) {
		java.util.Spliterator<java.lang.Character> spliterator = new lambdasinaction.chap7.WordCount.WordCounterSpliterator(s);
		java.util.stream.Stream<java.lang.Character> stream = java.util.stream.StreamSupport.stream(spliterator, true);
		return lambdasinaction.chap7.WordCount.countWords(stream);
	}

	private static int countWords(java.util.stream.Stream<java.lang.Character> stream) {
		lambdasinaction.chap7.WordCount.WordCounter wordCounter = stream.reduce(new lambdasinaction.chap7.WordCount.WordCounter(0, true), lambdasinaction.chap7.WordCount.WordCounter::accumulate, lambdasinaction.chap7.WordCount.WordCounter::combine);
		return wordCounter.getCounter();
	}

	private static class WordCounter {
		private final int counter;

		private final boolean lastSpace;

		public WordCounter(int counter, boolean lastSpace) {
			this.counter = counter;
			this.lastSpace = lastSpace;
		}

		public lambdasinaction.chap7.WordCount.WordCounter accumulate(java.lang.Character c) {
			if (java.lang.Character.isWhitespace(c)) {
				return lastSpace ? this : new lambdasinaction.chap7.WordCount.WordCounter(counter, true);
			} else {
				return lastSpace ? new lambdasinaction.chap7.WordCount.WordCounter(counter + 1, false) : this;
			}
		}

		public lambdasinaction.chap7.WordCount.WordCounter combine(lambdasinaction.chap7.WordCount.WordCounter wordCounter) {
			return new lambdasinaction.chap7.WordCount.WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
		}

		public int getCounter() {
			return counter;
		}
	}

	private static class WordCounterSpliterator implements java.util.Spliterator<java.lang.Character> {
		private final java.lang.String string;

		private int currentChar = 0;

		private WordCounterSpliterator(java.lang.String string) {
			this.string = string;
		}

		@java.lang.Override
		public boolean tryAdvance(java.util.function.Consumer<? super java.lang.Character> action) {
			action.accept(string.charAt(currentChar++));
			return currentChar < string.length();
		}

		@java.lang.Override
		public java.util.Spliterator<java.lang.Character> trySplit() {
			int currentSize = string.length() - currentChar;
			if (currentSize < 10) {
				return null;
			}
			for (int splitPos = (currentSize / 2) + currentChar; splitPos < string.length(); splitPos++) {
				if (java.lang.Character.isWhitespace(string.charAt(splitPos))) {
					java.util.Spliterator<java.lang.Character> spliterator = new lambdasinaction.chap7.WordCount.WordCounterSpliterator(string.substring(currentChar, splitPos));
					currentChar = splitPos;
					return spliterator;
				}
			}
			return null;
		}

		@java.lang.Override
		public long estimateSize() {
			return string.length() - currentChar;
		}

		@java.lang.Override
		public int characteristics() {
			return (((java.util.Spliterator.ORDERED + java.util.Spliterator.SIZED) + java.util.Spliterator.SUBSIZED) + java.util.Spliterator.NONNULL) + java.util.Spliterator.IMMUTABLE;
		}
	}
}