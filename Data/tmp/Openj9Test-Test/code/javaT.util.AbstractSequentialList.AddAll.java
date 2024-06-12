public class AddAll {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List t = new javaT.util.AbstractSequentialList.FooList();
		t.add("b");
		t.add("a");
		t.add("r");
		t.addAll(0, java.util.Arrays.asList(new java.lang.String[]{ "f", "o", "o" }));
		if (!t.equals(java.util.Arrays.asList(new java.lang.String[]{ "f", "o", "o", "b", "a", "r" }))) {
			throw new java.lang.Exception("addAll is broken");
		}
	}
}