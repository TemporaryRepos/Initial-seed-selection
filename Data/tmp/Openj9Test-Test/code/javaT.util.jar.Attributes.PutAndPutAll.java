public class PutAndPutAll {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.jar.Attributes at = new java.util.jar.Attributes();
		try {
			at.put("this is not an Attributes.Name", "value");
			throw new java.lang.Exception("put should check for non Attributes.Name names");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			at.put(new java.util.jar.Attributes.Name("name"), new java.lang.Integer(0));
			throw new java.lang.Exception("put should check for non String values");
		} catch (java.lang.ClassCastException e) {
		}
		try {
			at.putAll(new java.util.HashMap());
			throw new java.lang.Exception("putAll should check for non Attributes maps");
		} catch (java.lang.ClassCastException e) {
		}
	}
}