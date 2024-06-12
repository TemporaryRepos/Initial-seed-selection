public class ThreadTest6 {
	public static void main(java.lang.String[] args) {
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<java.lang.String, java.lang.Object>();
		java.util.List<java.lang.Integer> l = new java.util.ArrayList<>();
		com.pancm.thread.test.Thread99 t9 = new com.pancm.thread.test.Thread99();
		java.lang.Thread t = new java.lang.Thread(t9);
	}
}