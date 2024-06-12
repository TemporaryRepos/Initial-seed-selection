public class getRunStartLimitTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String text = "Hello world";
		java.text.AttributedString as = new java.text.AttributedString(text);
		as.addAttribute(java.awt.font.TextAttribute.WEIGHT, java.awt.font.TextAttribute.WEIGHT_LIGHT, 0, 3);
		as.addAttribute(java.awt.font.TextAttribute.WEIGHT, java.awt.font.TextAttribute.WEIGHT_BOLD, 3, 5);
		as.addAttribute(java.awt.font.TextAttribute.WEIGHT, java.awt.font.TextAttribute.WEIGHT_EXTRABOLD, 5, text.length());
		as.addAttribute(java.awt.font.TextAttribute.WIDTH, new java.text.Annotation(java.awt.font.TextAttribute.WIDTH_EXTENDED), 0, 3);
		as.addAttribute(java.awt.font.TextAttribute.WIDTH, new java.text.Annotation(java.awt.font.TextAttribute.WIDTH_CONDENSED), 3, 4);
		java.text.AttributedCharacterIterator aci = as.getIterator(null, 2, 4);
		aci.first();
		int runStart = aci.getRunStart();
		if (runStart != 2) {
			throw new java.lang.Exception(("1st run start is wrong. (" + runStart) + " should be 2.)");
		}
		int runLimit = aci.getRunLimit();
		if (runLimit != 3) {
			throw new java.lang.Exception(("1st run limit is wrong. (" + runLimit) + " should be 3.)");
		}
		java.lang.Object value = aci.getAttribute(java.awt.font.TextAttribute.WEIGHT);
		if (value != java.awt.font.TextAttribute.WEIGHT_LIGHT) {
			throw new java.lang.Exception(((("1st run attribute is wrong. (" + value) + " should be ") + java.awt.font.TextAttribute.WEIGHT_LIGHT) + ".)");
		}
		value = aci.getAttribute(java.awt.font.TextAttribute.WIDTH);
		if (value != null) {
			throw new java.lang.Exception(("1st run annotation is wrong. (" + value) + " should be null.)");
		}
		aci.setIndex(runLimit);
		runStart = aci.getRunStart();
		if (runStart != 3) {
			throw new java.lang.Exception(("2nd run start is wrong. (" + runStart) + " should be 3.)");
		}
		runLimit = aci.getRunLimit();
		if (runLimit != 4) {
			throw new java.lang.Exception(("2nd run limit is wrong. (" + runLimit) + " should be 4.)");
		}
		value = aci.getAttribute(java.awt.font.TextAttribute.WEIGHT);
		if (value != java.awt.font.TextAttribute.WEIGHT_BOLD) {
			throw new java.lang.Exception(((("2nd run attribute is wrong. (" + value) + " should be ") + java.awt.font.TextAttribute.WEIGHT_BOLD) + ".)");
		}
		value = aci.getAttribute(java.awt.font.TextAttribute.WIDTH);
		if ((!(value instanceof java.text.Annotation)) || (((java.text.Annotation) (value)).getValue() != java.awt.font.TextAttribute.WIDTH_CONDENSED)) {
			throw new java.lang.Exception(((("2nd run annotation is wrong. (" + value) + " should be ") + new java.text.Annotation(java.awt.font.TextAttribute.WIDTH_CONDENSED)) + ".)");
		}
	}
}