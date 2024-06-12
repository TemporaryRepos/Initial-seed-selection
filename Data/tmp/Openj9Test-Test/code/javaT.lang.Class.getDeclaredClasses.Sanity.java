public class Sanity {
	static class Toplevel {}

	class Nested {}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		class BlockLocal {}
		new java.lang.Object() {};
		java.lang.Class[] c = javaT.lang.Class.getDeclaredClasses.Sanity.class.getDeclaredClasses();
		if (c.length < 2) {
			throw new java.lang.Exception("Incorrect number of declared classes");
		}
		for (int i = 0; i < c.length; i++) {
			java.lang.String name = c[i].getName();
			java.lang.System.out.println(name);
			if (((c[i] != javaT.lang.Class.getDeclaredClasses.Sanity.Nested.class) && (c[i] != javaT.lang.Class.getDeclaredClasses.Sanity.Toplevel.class)) && (!name.matches("\\D\\w*\\$\\d*"))) {
				throw new java.lang.Exception("Unexpected class: " + name);
			}
		}
	}
}