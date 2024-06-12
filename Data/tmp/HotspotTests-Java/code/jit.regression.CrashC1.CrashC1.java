public class CrashC1 {
	public long alignUp(long size, long alignment) {
		return ((size + alignment) - 1) & (~(alignment - 1));
	}

	public static void main(java.lang.String[] args) {
		new jit.regression.CrashC1.CrashC1().alignUp(8, 8);
	}
}