public class StringExamples {
	public static void main(java.lang.String[] args) {
		java.lang.String str3 = "value1";
		str3.concat("value2");
		java.lang.System.out.println(str3);
		java.lang.String concat = str3.concat("value2");
		java.lang.System.out.println(concat);
		java.lang.String str1 = "value";
		java.lang.String str2 = new java.lang.String("value");
		java.lang.String str = "abcdefghijk";
		java.lang.System.out.println(str.charAt(2));
		java.lang.System.out.println(str.concat("lmn"));
		java.lang.System.out.println("ABC".equalsIgnoreCase("abc"));
		java.lang.System.out.println("ABCDEFGH".length());
		java.lang.System.out.println("012301230123".replace('0', '4'));
		java.lang.System.out.println("012301230123".replace("01", "45"));
		java.lang.System.out.println("abcdefghij".substring(3));
		java.lang.System.out.println("abcdefghij".substring(3, 7));
		java.lang.System.out.println("ABCDEFGHIJ".toLowerCase());
		java.lang.System.out.println("abcdefghij".toUpperCase());
		java.lang.System.out.println("abcdefghij".toString());
		java.lang.System.out.println(" abcd  ".trim());
	}
}