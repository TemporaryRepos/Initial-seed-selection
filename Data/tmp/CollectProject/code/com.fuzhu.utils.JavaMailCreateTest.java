public class JavaMailCreateTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Properties props = new java.util.Properties();
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);
		javax.mail.internet.MimeMessage message = new javax.mail.internet.MimeMessage(session);
		message.setFrom(new javax.mail.internet.InternetAddress("751197996@qq.com", "USER_AA", "UTF-8"));
		message.addRecipient(javax.mail.internet.MimeMessage.RecipientType.TO, new javax.mail.internet.InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
		message.setSubject("TEST邮件主题", "UTF-8");
		message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");
		message.setSentDate(new java.util.Date());
		message.saveChanges();
		java.io.OutputStream out = new java.io.FileOutputStream("MyEmail.eml");
		message.writeTo(out);
		out.flush();
		out.close();
	}
}