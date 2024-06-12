public class ForStaticInnerClass {
	static class Static {}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (!java.lang.reflect.Modifier.isStatic(javaT.lang.Class.getModifiers.ForStaticInnerClass.Static.class.getModifiers())) {
			throw new java.lang.Exception("VM lost static modifier of innerclass.");
		}
	}
}