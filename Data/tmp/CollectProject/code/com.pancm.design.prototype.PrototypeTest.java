public class PrototypeTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.prototype.Mail mail = new com.pancm.design.prototype.Mail();
		mail.setMsg("生日快乐!");
		com.pancm.design.prototype.Mail mail2 = ((com.pancm.design.prototype.Mail) (mail.clone()));
		java.lang.System.out.println("小明:" + mail.getMsg());
		java.lang.System.out.println("小红:" + mail2.getMsg());
	}
}