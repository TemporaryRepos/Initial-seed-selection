public class TestShortArraycopy {
	static short[] a1 = new short[8];

	static short[] a2 = new short[8];

	static short[] a3 = new short[8];

	static volatile boolean keepRunning = true;

	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		for (int i = 0; i < TestShortArraycopy.a1.length; i++) {
			TestShortArraycopy.a1[i] = ((short) (0xffff));
			TestShortArraycopy.a2[i] = ((short) (0xffff));
			TestShortArraycopy.a3[i] = ((short) (0x0));
		}
		java.lang.Thread reader = new java.lang.Thread() {
			public void run() {
				while (TestShortArraycopy.keepRunning) {
					for (int j = 0; j < TestShortArraycopy.a1.length; j++) {
						short s = TestShortArraycopy.a1[j];
						if ((s != ((short) (0xffff))) && (s != ((short) (0x0)))) {
							java.lang.System.out.println("Error: s = " + s);
							throw new java.lang.RuntimeException("wrong result");
						}
					}
				} 
			}
		};
		java.lang.Thread writer = new java.lang.Thread() {
			public void run() {
				for (int i = 0; i < 1000000; i++) {
					java.lang.System.arraycopy(TestShortArraycopy.a2, 5, TestShortArraycopy.a1, 3, 3);
					java.lang.System.arraycopy(TestShortArraycopy.a3, 5, TestShortArraycopy.a1, 3, 3);
				}
			}
		};
		TestShortArraycopy.keepRunning = true;
		reader.start();
		writer.start();
		writer.join();
		TestShortArraycopy.keepRunning = false;
		reader.join();
	}
}