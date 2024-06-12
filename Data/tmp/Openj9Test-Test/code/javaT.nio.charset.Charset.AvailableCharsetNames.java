public class AvailableCharsetNames {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Iterator charsetIterator = java.nio.charset.Charset.availableCharsets().keySet().iterator();
		while (charsetIterator.hasNext()) {
			java.lang.String charsetName = ((java.lang.String) (charsetIterator.next()));
			java.nio.charset.Charset charset = java.nio.charset.Charset.forName(charsetName);
			if (!charset.name().equals(charsetName)) {
				throw new java.lang.Exception((("Error: Charset name mismatch - expected " + charsetName) + ", got ") + charset.name());
			}
		} 
	}
}