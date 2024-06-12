public class UnexpectedPinnedNodeInOuterLoop {
	public static final int N = 400;

	public static volatile float fFld = 0.488F;

	public static volatile int iFld = 143;

	public static void lMeth(int i2) {
		int i20 = 95;
		int i21 = -163;
		int i22 = -11;
		int[] iArr = new int[UnexpectedPinnedNodeInOuterLoop.N];
		int[] iArr2 = new int[UnexpectedPinnedNodeInOuterLoop.N];
		byte by1 = -97;
		for (i20 = 15; 253 > i20; ++i20) {
			UnexpectedPinnedNodeInOuterLoop.iFld += i21;
			for (i22 = 1; 7 > i22; i22++) {
				iArr[i20 + 1] >>= i20;
			}
			UnexpectedPinnedNodeInOuterLoop.fFld = i2;
			iArr2[i20] -= ((int) (2.302F));
		}
	}

	public static void main(java.lang.String[] strArr) {
		UnexpectedPinnedNodeInOuterLoop.lMeth(0);
	}
}