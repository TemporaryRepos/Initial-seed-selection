public class TriggerResize extends java.lang.ClassLoader {
	private static int[] DATA = new int[]{ -54, -2, -70, -66, 0, 0, 0, 52, 0, 13, 10, 0, 3, 0, 10, 7, 0, 11, 7, 0, 12, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 3, 40, 41, 86, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 18, 84, 101, 115, 116, 67, 97, 115, 101, 48, 48, 48, 48, 48, 46, 106, 97, 118, 97, 12, 0, 4, 0, 5, 1, 0, 13, 84, 101, 115, 116, 67, 97, 115, 101, 48, 48, 48, 48, 48, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 0, 32, 0, 2, 0, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 4, 0, 5, 0, 1, 0, 6, 0, 0, 0, 29, 0, 1, 0, 1, 0, 0, 0, 5, 42, -73, 0, 1, -79, 0, 0, 0, 1, 0, 7, 0, 0, 0, 6, 0, 1, 0, 0, 0, 1, 0, 1, 0, 8, 0, 0, 0, 2, 0, 9 };

	private static int INDEX1 = 85;

	private static int INDEX2 = 111;

	private static int BASE = 48;

	public TriggerResize() {
		super();
	}

	public void load(int index) {
		byte[] bytes = new byte[TriggerResize.DATA.length];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = ((byte) (TriggerResize.DATA[i]));
		}
		{
			int byte1 = index % 10;
			int byte2 = (index / 10) % 10;
			int byte3 = (index / 100) % 10;
			int byte4 = (index / 1000) % 10;
			int byte5 = (index / 10000) % 10;
			bytes[TriggerResize.INDEX1 + 0] = bytes[TriggerResize.INDEX2 + 0] = ((byte) (TriggerResize.BASE + byte5));
			bytes[TriggerResize.INDEX1 + 1] = bytes[TriggerResize.INDEX2 + 1] = ((byte) (TriggerResize.BASE + byte4));
			bytes[TriggerResize.INDEX1 + 2] = bytes[TriggerResize.INDEX2 + 2] = ((byte) (TriggerResize.BASE + byte3));
			bytes[TriggerResize.INDEX1 + 3] = bytes[TriggerResize.INDEX2 + 3] = ((byte) (TriggerResize.BASE + byte2));
			bytes[TriggerResize.INDEX1 + 4] = bytes[TriggerResize.INDEX2 + 4] = ((byte) (TriggerResize.BASE + byte1));
		}
		java.lang.Class generatedClass = defineClass(bytes, 0, bytes.length);
		resolveClass(generatedClass);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int count = 0;
		if (args.length >= 1) {
			java.lang.Integer i = new java.lang.Integer(args[0]);
			count = i.intValue();
		}
		TriggerResize test = new TriggerResize();
		for (int i = 0; i <= count; i++) {
			test.load(i);
		}
		java.lang.System.gc();
	}
}