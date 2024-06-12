public class ForInnerClass {
	private class Inner {}

	protected class Protected {}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int m = 0;
		m = javaT.lang.Class.getModifiers.ForInnerClass.Inner.class.getModifiers() & (~java.lang.reflect.Modifier.SYNCHRONIZED);
		if (m != java.lang.reflect.Modifier.PRIVATE) {
			throw new java.lang.Exception("Access bits for innerclass not from " + "InnerClasses attribute");
		}
		m = javaT.lang.Class.getModifiers.ForInnerClass.Protected.class.getModifiers() & (~java.lang.reflect.Modifier.SYNCHRONIZED);
		if (m != java.lang.reflect.Modifier.PROTECTED) {
			throw new java.lang.Exception("Protected inner class wronged modifiers");
		}
	}
}