public class InsertNullString {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.StringBuffer s = new java.lang.StringBuffer("FOOBAR");
		try {
			java.lang.String nullstr = null;
			s.insert(3, nullstr);
			if (!s.toString().equals("FOOnullBAR")) {
				throw new java.lang.Exception("StringBuffer.insert() did not insert!");
			}
		} catch (java.lang.NullPointerException npe) {
			throw new java.lang.Exception("StringBuffer.insert() of null String reference threw a NullPointerException");
		}
	}
}