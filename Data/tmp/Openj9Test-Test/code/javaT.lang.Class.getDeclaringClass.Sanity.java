public class Sanity {
	class Nested {}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (javaT.lang.Class.getDeclaringClass.Sanity.Nested.class.getDeclaringClass() != javaT.lang.Class.getDeclaringClass.Sanity.class) {
			throw new java.lang.Exception("Not finding declaring class");
		}
		class BlockLocal {}
		if (BlockLocal.class.getDeclaringClass() != null) {
			throw new java.lang.Exception("Finding declaring class for block local");
		}
	}
}