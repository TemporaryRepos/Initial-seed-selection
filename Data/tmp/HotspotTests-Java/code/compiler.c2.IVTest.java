public class IVTest {
	static int paddedSize;

	static void padV15(byte[] padded) {
		int psSize = padded.length;
		int k = 0;
		while ((psSize--) > 0) {
			padded[k++] = ((byte) (0xff));
		} 
	}

	static void padV15_2(int paddedSize) {
		byte[] padded = new byte[paddedSize];
		int psSize = padded.length;
		int k = 0;
		while ((psSize--) > 0) {
			padded[k++] = ((byte) (0xff));
		} 
	}

	static void padV15_3() {
		byte[] padded = new byte[compiler.c2.IVTest.paddedSize];
		int psSize = padded.length;
		int k = 0;
		while ((psSize--) > 0) {
			padded[k++] = ((byte) (0xff));
		} 
	}

	static void padV15_4() {
		byte[] padded = new byte[compiler.c2.IVTest.paddedSize];
		int psSize = padded.length;
		for (int k = 0; psSize > 0; psSize--) {
			int i = padded.length - psSize;
			padded[i] = ((byte) (0xff));
		}
	}

	static void padV15_5() {
		byte[] padded = new byte[compiler.c2.IVTest.paddedSize];
		int psSize = padded.length;
		int k = psSize - 1;
		for (int i = 0; i < psSize; i++) {
			padded[k--] = ((byte) (0xff));
		}
	}

	public static void main(java.lang.String[] argv) {
		int bounds = 1024;
		int lim = 500000;
		for (int j = 0; j < lim; j++) {
			compiler.c2.IVTest.paddedSize = j % bounds;
			compiler.c2.IVTest.padV15(new byte[compiler.c2.IVTest.paddedSize]);
		}
		for (int j = 0; j < lim; j++) {
			compiler.c2.IVTest.paddedSize = j % bounds;
			compiler.c2.IVTest.padV15_2(compiler.c2.IVTest.paddedSize);
		}
		for (int j = 0; j < lim; j++) {
			compiler.c2.IVTest.paddedSize = j % bounds;
			compiler.c2.IVTest.padV15_3();
		}
		for (int j = 0; j < lim; j++) {
			compiler.c2.IVTest.paddedSize = j % bounds;
			compiler.c2.IVTest.padV15_4();
		}
		for (int j = 0; j < lim; j++) {
			compiler.c2.IVTest.paddedSize = j % bounds;
			compiler.c2.IVTest.padV15_5();
		}
	}
}