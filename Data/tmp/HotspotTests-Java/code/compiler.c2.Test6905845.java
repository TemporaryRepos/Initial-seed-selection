public class Test6905845 {
	public static void main(java.lang.String[] args) {
		for (int asdf = 0; asdf < 5; asdf++) {
			{
				java.lang.StringBuilder strBuf1 = new java.lang.StringBuilder(65);
				int count = 0;
				for (int i = java.lang.Integer.MIN_VALUE; i < (java.lang.Integer.MAX_VALUE - 80); i += 79) {
					strBuf1.append(i);
					count++;
					strBuf1.delete(0, 65);
				}
				java.lang.System.out.println(count);
				if (count != 54366674) {
					java.lang.System.out.println(("wrong count: " + count) + ", should be 54366674");
					java.lang.System.exit(97);
				}
			}
			{
				java.lang.StringBuilder strBuf1 = new java.lang.StringBuilder(65);
				int count = 0;
				for (int i = java.lang.Integer.MIN_VALUE; i < (java.lang.Integer.MAX_VALUE - 80); i += 79) {
					strBuf1.append(i);
					count++;
					strBuf1.delete(0, 65);
				}
				java.lang.System.out.println(count);
				if (count != 54366674) {
					java.lang.System.out.println(("wrong count: " + count) + ", should be 54366674");
					java.lang.System.exit(97);
				}
			}
		}
	}
}