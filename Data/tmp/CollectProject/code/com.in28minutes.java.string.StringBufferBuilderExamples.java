public class StringBufferBuilderExamples {
	public static void main(java.lang.String[] args) {
		java.lang.StringBuffer stringbuffer = new java.lang.StringBuffer("12345");
		stringbuffer.append("6789");
		java.lang.System.out.println(stringbuffer);
		java.lang.StringBuilder sb = new java.lang.StringBuilder("0123456789");
		java.lang.System.out.println(sb.delete(3, 7));
		java.lang.StringBuilder sb1 = new java.lang.StringBuilder("abcdefgh");
		java.lang.System.out.println(sb1.insert(3, "ABCD"));
		java.lang.StringBuilder sb2 = new java.lang.StringBuilder("abcdefgh");
		java.lang.System.out.println(sb2.reverse());
		java.lang.StringBuilder sb3 = new java.lang.StringBuilder("abcdefgh");
		java.lang.System.out.println(sb3.reverse().delete(5, 6).insert(3, "---"));
	}
}