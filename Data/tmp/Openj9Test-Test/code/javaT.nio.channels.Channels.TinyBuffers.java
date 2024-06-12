public class TinyBuffers {
	private static java.nio.charset.Charset cs = java.nio.charset.Charset.forName("UTF-16");

	private static void test(int sz) throws java.lang.Exception {
		java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(new byte[100]);
		java.nio.channels.ReadableByteChannel ch = java.nio.channels.Channels.newChannel(bis);
		java.io.Reader r = java.nio.channels.Channels.newReader(ch, javaT.nio.channels.Channels.TinyBuffers.cs.newDecoder(), sz);
		char[] arr = new char[100];
		java.lang.System.out.println(r.read(arr, 0, arr.length));
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		for (int i = -2; i < 10; i++) {
			javaT.nio.channels.Channels.TinyBuffers.test(i);
		}
	}
}