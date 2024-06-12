public class CopyOfClientMain {
	public static void main(java.lang.String[] args) {
		java.net.Socket socket = null;
		java.io.DataOutputStream os = null;
		java.io.DataInputStream is = null;
		try {
			socket = new java.net.Socket("localhost", 5005);
			while (true) {
				java.lang.Thread.sleep(1000);
				is = new java.io.DataInputStream(socket.getInputStream());
				java.lang.System.out.println(is.readUTF());
			} 
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
			} catch (java.lang.Exception ex) {
			}
			try {
				os.close();
			} catch (java.lang.Exception ex) {
			}
			try {
				socket.close();
			} catch (java.lang.Exception ex) {
			}
		}
	}
}