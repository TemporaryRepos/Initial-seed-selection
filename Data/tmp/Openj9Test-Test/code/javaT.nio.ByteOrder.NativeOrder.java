public class NativeOrder {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.nio.ByteOrder bo = java.nio.ByteOrder.nativeOrder();
		java.lang.System.err.println(bo);
		java.lang.String arch = java.lang.System.getProperty("os.arch");
		if ((arch.equals("i386") && (bo != java.nio.ByteOrder.LITTLE_ENDIAN)) || (arch.equals("sparc") && (bo != java.nio.ByteOrder.BIG_ENDIAN))) {
			throw new java.lang.Exception("Wrong byte order");
		}
	}
}