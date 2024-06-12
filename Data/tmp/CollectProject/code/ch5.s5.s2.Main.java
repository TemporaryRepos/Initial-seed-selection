public class Main {
	public static void main(java.lang.String[] args) {
		ch5.s5.s2.Client client = new ch5.s5.s2.Client();
		ch5.s5.s2.Data data = client.request("name");
		java.lang.System.out.println("请求完毕");
		try {
			java.lang.Thread.sleep(2000);
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		java.lang.System.out.println("数据 = " + data.getResult());
	}
}