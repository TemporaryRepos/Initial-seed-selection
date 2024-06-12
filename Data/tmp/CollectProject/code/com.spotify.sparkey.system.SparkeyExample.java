public class SparkeyExample {
	private static final int NUM_RANDOM_READS = 1000;

	private static final int N = 2000;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		final java.io.File indexFile = new java.io.File("test.spi");
		com.spotify.sparkey.system.SparkeyExample.create(indexFile);
		final java.util.Random random = new java.util.Random(11234);
		final SparkeyReader reader = Sparkey.open(indexFile);
		com.spotify.sparkey.system.SparkeyExample.randomReads(random, reader);
		com.spotify.sparkey.system.SparkeyExample.rawIteration(new SparkeyLogIterator(Sparkey.getLogFile(indexFile)));
		com.spotify.sparkey.system.SparkeyExample.iteration(reader);
		reader.close();
	}

	private static void randomReads(java.util.Random random, SparkeyReader reader) throws java.io.IOException {
		for (int i = 0; i < com.spotify.sparkey.system.SparkeyExample.NUM_RANDOM_READS; i++) {
			int k = random.nextInt(com.spotify.sparkey.system.SparkeyExample.N);
			java.lang.String key = "Key" + k;
			java.lang.String entry = reader.getAsString(key);
			if (!("Value" + k).equals(entry)) {
				throw new java.lang.RuntimeException(((("Expected " + "Value") + k) + " but got ") + entry);
			}
		}
	}

	private static void create(java.io.File indexFile) throws java.io.IOException {
		final SparkeyWriter writer = Sparkey.createNew(indexFile, CompressionType.SNAPPY, 512);
		for (int i = 0; i < com.spotify.sparkey.system.SparkeyExample.N; i++) {
			writer.put("Key" + i, "Value" + i);
		}
		writer.flush();
		writer.writeHash();
		writer.close();
	}

	private static void iteration(final SparkeyReader reader) throws java.io.IOException {
		int i = 0;
		for (SparkeyReader.Entry entry : reader) {
			java.lang.String key = entry.getKeyAsString();
			java.lang.String value = entry.getValueAsString();
			java.lang.String expectedKey = "Key" + i;
			java.lang.String expectedValue = "Value" + i;
			if (!key.equals(expectedKey)) {
				throw new java.lang.RuntimeException((("Expected " + expectedKey) + " but got ") + key);
			}
			if (!value.equals(expectedValue)) {
				throw new java.lang.RuntimeException(((((("Expected '" + expectedValue) + "' but got '") + value) + "' for key '") + key) + "'");
			}
			i++;
		}
		if (i != com.spotify.sparkey.system.SparkeyExample.N) {
			throw new java.lang.RuntimeException((("Only got " + i) + " entries, expected ") + com.spotify.sparkey.system.SparkeyExample.N);
		}
	}

	private static void rawIteration(final SparkeyLogIterator logIterator) throws java.io.IOException {
		int i = 0;
		for (SparkeyReader.Entry entry : logIterator) {
			if (entry.getType() == SparkeyReader.Type.PUT) {
				java.lang.String key = entry.getKeyAsString();
				java.lang.String value = entry.getValueAsString();
				java.lang.String expectedKey = "Key" + (i % com.spotify.sparkey.system.SparkeyExample.N);
				java.lang.String expectedValue = "Value" + i;
				if (!key.equals(expectedKey)) {
					throw new java.lang.RuntimeException((("Expected " + expectedKey) + " but got ") + key);
				}
				if (!value.equals(expectedValue)) {
					throw new java.lang.RuntimeException((("Expected " + expectedValue) + " but got ") + value);
				}
				i++;
			}
		}
		if (i != com.spotify.sparkey.system.SparkeyExample.N) {
			throw new java.lang.RuntimeException((("Only got " + i) + " entries, expected ") + (2 * com.spotify.sparkey.system.SparkeyExample.N));
		}
	}

	@org.junit.Test
	public void dummy() {
	}
}