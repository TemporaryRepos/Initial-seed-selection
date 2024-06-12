public class TestAttributedStringCtor {
	public static void main(java.lang.String[] args) {
		java.util.Hashtable attributes = new java.util.Hashtable();
		attributes.put(java.awt.font.TextAttribute.WEIGHT, java.awt.font.TextAttribute.WEIGHT_BOLD);
		java.text.AttributedString origString = new java.text.AttributedString("Hello world.", attributes);
		java.text.AttributedCharacterIterator iter = origString.getIterator(null, 4, 6);
		java.text.AttributedString newString = new java.text.AttributedString(iter);
		java.lang.System.out.println("DONE");
	}
}