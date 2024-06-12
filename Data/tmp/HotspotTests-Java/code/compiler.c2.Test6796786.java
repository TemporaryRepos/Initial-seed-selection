public class Test6796786 {
	static volatile float d1;

	static volatile float d2;

	public static void main(java.lang.String[] args) {
		int total = 0;
		for (int i = 0; i < 100000; i++) {
			if (java.lang.Float.floatToRawIntBits(-(compiler.c2.Test6796786.d1 - compiler.c2.Test6796786.d2)) == java.lang.Float.floatToRawIntBits(-0.0F)) {
				total++;
			}
		}
		if (total != 100000) {
			throw new java.lang.InternalError();
		}
	}
}