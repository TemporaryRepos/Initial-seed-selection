public class PrimitiveClasses {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Class[] primClasses = new java.lang.Class[]{ boolean.class, byte.class, char.class, short.class, int.class, long.class, float.class, double.class };
		for (int i = 0; i < primClasses.length; i++) {
			java.lang.Class pc = primClasses[i];
			if (new java.rmi.MarshalledObject(pc).get() != pc) {
				throw new java.lang.Error();
			}
		}
	}
}