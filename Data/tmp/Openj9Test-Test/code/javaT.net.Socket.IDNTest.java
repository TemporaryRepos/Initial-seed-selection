public class IDNTest {
	public static void main(java.lang.String[] args) {
		try {
			java.net.Socket s = new java.net.Socket("柴田芳樹", 8000);
		} catch (java.net.UnknownHostException e) {
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(e);
		}
		try {
			java.net.Socket s = new java.net.Socket("ho st", 8000);
		} catch (java.net.UnknownHostException e) {
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(e);
		}
	}
}