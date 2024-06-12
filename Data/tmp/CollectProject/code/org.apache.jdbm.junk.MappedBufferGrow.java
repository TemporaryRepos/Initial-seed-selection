public class MappedBufferGrow {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.io.File f = new java.io.File("test");
		f.deleteOnExit();
		java.io.RandomAccessFile raf = new java.io.RandomAccessFile(f, "rw");
		raf.setLength(((long) (1000000.0)));
		java.lang.System.out.println("length is " + raf.length());
		raf.seek(((long) (2000000.0)));
		raf.write(1);
		java.lang.System.out.println("length is " + raf.length());
		java.nio.MappedByteBuffer b = raf.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0, ((long) (3000000.0)));
		java.lang.System.out.println("length after mapping is " + raf.length());
		b.position(((int) (3000000.0 - 10)));
		b.put(((byte) (1)));
		b.force();
		java.lang.System.out.println("length after writting to MappedByteBuffer is " + raf.length());
	}
}