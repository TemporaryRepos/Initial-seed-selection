class t041 {
	public static void main(java.lang.String[] argv) {
		java.lang.String j = "Now now";
		j += ", Brown Cow?";
		if (!j.equals("Now now, Brown Cow?")) {
			throw new nsk.share.TestFailure("Test failed");
		}
	}
}