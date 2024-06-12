public class Substring {
	public static void main(java.lang.String[] args) {
		java.lang.StringBuffer buffer = new java.lang.StringBuffer();
		buffer.append("Guten Morgen!");
		if (buffer.substring(0).length() != 13) {
			throw new java.lang.RuntimeException();
		}
	}
}