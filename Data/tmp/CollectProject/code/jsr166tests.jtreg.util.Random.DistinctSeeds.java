public class DistinctSeeds {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if ((new java.util.Random().nextLong() == new java.util.Random().nextLong()) || (new java.util.Random().nextLong() == new java.util.Random().nextLong())) {
			throw new java.lang.RuntimeException("Random() seeds not unique.");
		}
	}
}