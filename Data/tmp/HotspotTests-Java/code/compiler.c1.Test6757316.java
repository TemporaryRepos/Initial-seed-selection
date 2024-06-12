public class Test6757316 {
	public static void main(java.lang.String[] args) {
		long[] arr = new long[]{ 0x11111111aaaaaaaaL, 0xaaaaaaaa11111111L, 0x11111111aaaaaaaaL, 0xaaaaaaaa11111111L };
		if (arr[0] == arr[1]) {
			throw new java.lang.InternalError();
		}
	}
}