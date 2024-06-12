public class Factory {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.lang.Boolean.valueOf(true) != java.lang.Boolean.TRUE) {
			throw new java.lang.Exception("Truth failure");
		}
		if (java.lang.Boolean.valueOf(false) != java.lang.Boolean.FALSE) {
			throw new java.lang.Exception("Major fallacy");
		}
	}
}