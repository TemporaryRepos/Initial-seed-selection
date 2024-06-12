public class IsomorphicTest {
	@org.junit.jupiter.api.Test
	public static void main(java.lang.String[] args) {
		java.lang.String str1 = "abbbbaac";
		java.lang.String str2 = "kffffkkd";
		java.lang.String str3 = "xyxyxy";
		java.lang.String str4 = "bnbnbn";
		java.lang.String str5 = "ghjknnmm";
		java.lang.String str6 = "wertpopo";
		java.lang.String str7 = "aaammmnnn";
		java.lang.String str8 = "ggghhhbbj";
		org.junit.jupiter.api.Assertions.assertTrue(Isomorphic.checkStrings(str1, str2));
		org.junit.jupiter.api.Assertions.assertTrue(Isomorphic.checkStrings(str3, str4));
		org.junit.jupiter.api.Assertions.assertFalse(Isomorphic.checkStrings(str5, str6));
		org.junit.jupiter.api.Assertions.assertFalse(Isomorphic.checkStrings(str7, str8));
	}
}