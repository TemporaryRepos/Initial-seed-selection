public class Class2HTML implements org.apache.bcel.Constants {
	private final org.apache.bcel.classfile.JavaClass java_class;

	private final java.lang.String dir;

	private static java.lang.String class_package;

	private static java.lang.String class_name;

	private static org.apache.bcel.classfile.ConstantPool constant_pool;

	private static final java.util.Set<java.lang.String> basic_types = new java.util.HashSet<>();

	static {
		basic_types.add("int");
		basic_types.add("short");
		basic_types.add("boolean");
		basic_types.add("void");
		basic_types.add("char");
		basic_types.add("byte");
		basic_types.add("long");
		basic_types.add("double");
		basic_types.add("float");
	}

	public Class2HTML(final org.apache.bcel.classfile.JavaClass java_class, final java.lang.String dir) throws java.io.IOException {
		final org.apache.bcel.classfile.Method[] methods = java_class.getMethods();
		this.java_class = java_class;
		this.dir = dir;
		org.apache.bcel.util.Class2HTML.class_name = java_class.getClassName();
		org.apache.bcel.util.Class2HTML.constant_pool = java_class.getConstantPool();
		final int index = org.apache.bcel.util.Class2HTML.class_name.lastIndexOf('.');
		if (index > (-1)) {
			org.apache.bcel.util.Class2HTML.class_package = org.apache.bcel.util.Class2HTML.class_name.substring(0, index);
		} else {
			org.apache.bcel.util.Class2HTML.class_package = "";
		}
		final org.apache.bcel.util.ConstantHTML constant_html = new org.apache.bcel.util.ConstantHTML(dir, org.apache.bcel.util.Class2HTML.class_name, org.apache.bcel.util.Class2HTML.class_package, methods, org.apache.bcel.util.Class2HTML.constant_pool);
		final org.apache.bcel.util.AttributeHTML attribute_html = new org.apache.bcel.util.AttributeHTML(dir, org.apache.bcel.util.Class2HTML.class_name, org.apache.bcel.util.Class2HTML.constant_pool, constant_html);
		new org.apache.bcel.util.MethodHTML(dir, org.apache.bcel.util.Class2HTML.class_name, methods, java_class.getFields(), constant_html, attribute_html);
		writeMainHTML(attribute_html);
		new org.apache.bcel.util.CodeHTML(dir, org.apache.bcel.util.Class2HTML.class_name, methods, org.apache.bcel.util.Class2HTML.constant_pool, constant_html);
		attribute_html.close();
	}

	public static void main(final java.lang.String[] argv) throws java.io.IOException {
		final java.lang.String[] file_name = new java.lang.String[argv.length];
		int files = 0;
		org.apache.bcel.classfile.ClassParser parser = null;
		org.apache.bcel.classfile.JavaClass java_class = null;
		java.lang.String zip_file = null;
		final char sep = java.io.File.separatorChar;
		java.lang.String dir = "." + sep;
		for (int i = 0; i < argv.length; i++) {
			if (argv[i].charAt(0) == '-') {
				if (argv[i].equals("-d")) {
					dir = argv[++i];
					if (!dir.endsWith("" + sep)) {
						dir = dir + sep;
					}
					final java.io.File store = new java.io.File(dir);
					if (!store.isDirectory()) {
						final boolean created = store.mkdirs();
						if (!created) {
							if (!store.isDirectory()) {
								java.lang.System.out.println(("Tried to create the directory " + dir) + " but failed");
							}
						}
					}
				} else if (argv[i].equals("-zip")) {
					zip_file = argv[++i];
				} else {
					java.lang.System.out.println("Unknown option " + argv[i]);
				}
			} else {
				file_name[files++] = argv[i];
			}
		}
		if (files == 0) {
			java.lang.System.err.println("Class2HTML: No input files specified.");
		} else {
			for (int i = 0; i < files; i++) {
				java.lang.System.out.print(("Processing " + file_name[i]) + "...");
				if (zip_file == null) {
					parser = new org.apache.bcel.classfile.ClassParser(file_name[i]);
				} else {
					parser = new org.apache.bcel.classfile.ClassParser(zip_file, file_name[i]);
				}
				java_class = parser.parse();
				new org.apache.bcel.util.Class2HTML(java_class, dir);
				java.lang.System.out.println("Done.");
			}
		}
	}

	static java.lang.String referenceClass(final int index) {
		java.lang.String str = org.apache.bcel.util.Class2HTML.constant_pool.getConstantString(index, org.apache.bcel.Const.CONSTANT_Class);
		str = org.apache.bcel.classfile.Utility.compactClassName(str);
		str = org.apache.bcel.classfile.Utility.compactClassName(str, org.apache.bcel.util.Class2HTML.class_package + ".", true);
		return ((((("<A HREF=\"" + org.apache.bcel.util.Class2HTML.class_name) + "_cp.html#cp") + index) + "\" TARGET=ConstantPool>") + str) + "</A>";
	}

	static java.lang.String referenceType(final java.lang.String type) {
		java.lang.String short_type = org.apache.bcel.classfile.Utility.compactClassName(type);
		short_type = org.apache.bcel.classfile.Utility.compactClassName(short_type, org.apache.bcel.util.Class2HTML.class_package + ".", true);
		final int index = type.indexOf('[');
		java.lang.String base_type = type;
		if (index > (-1)) {
			base_type = type.substring(0, index);
		}
		if (org.apache.bcel.util.Class2HTML.basic_types.contains(base_type)) {
			return ("<FONT COLOR=\"#00FF00\">" + type) + "</FONT>";
		}
		return ((("<A HREF=\"" + base_type) + ".html\" TARGET=_top>") + short_type) + "</A>";
	}

	static java.lang.String toHTML(final java.lang.String str) {
		final java.lang.StringBuilder buf = new java.lang.StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch;
			switch (ch = str.charAt(i)) {
				case '<' :
					buf.append("&lt;");
					break;
				case '>' :
					buf.append("&gt;");
					break;
				case '\n' :
					buf.append("\\n");
					break;
				case '\r' :
					buf.append("\\r");
					break;
				default :
					buf.append(ch);
			}
		}
		return buf.toString();
	}

	private void writeMainHTML(final org.apache.bcel.util.AttributeHTML attribute_html) throws java.io.IOException {
		try (final java.io.PrintWriter file = new java.io.PrintWriter(new java.io.FileOutputStream((dir + org.apache.bcel.util.Class2HTML.class_name) + ".html"))) {
			file.println((((((((((((((((((((((((((("<HTML>\n" + "<HEAD><TITLE>Documentation for ") + org.apache.bcel.util.Class2HTML.class_name) + "</TITLE>") + "</HEAD>\n") + "<FRAMESET BORDER=1 cols=\"30%,*\">\n") + "<FRAMESET BORDER=1 rows=\"80%,*\">\n") + "<FRAME NAME=\"ConstantPool\" SRC=\"") + org.apache.bcel.util.Class2HTML.class_name) + "_cp.html") + "\"\n MARGINWIDTH=\"0\" ") + "MARGINHEIGHT=\"0\" FRAMEBORDER=\"1\" SCROLLING=\"AUTO\">\n") + "<FRAME NAME=\"Attributes\" SRC=\"") + org.apache.bcel.util.Class2HTML.class_name) + "_attributes.html") + "\"\n MARGINWIDTH=\"0\" ") + "MARGINHEIGHT=\"0\" FRAMEBORDER=\"1\" SCROLLING=\"AUTO\">\n") + "</FRAMESET>\n") + "<FRAMESET BORDER=1 rows=\"80%,*\">\n") + "<FRAME NAME=\"Code\" SRC=\"") + org.apache.bcel.util.Class2HTML.class_name) + "_code.html\"\n MARGINWIDTH=0 ") + "MARGINHEIGHT=0 FRAMEBORDER=1 SCROLLING=\"AUTO\">\n") + "<FRAME NAME=\"Methods\" SRC=\"") + org.apache.bcel.util.Class2HTML.class_name) + "_methods.html\"\n MARGINWIDTH=0 ") + "MARGINHEIGHT=0 FRAMEBORDER=1 SCROLLING=\"AUTO\">\n") + "</FRAMESET></FRAMESET></HTML>");
		}
		final org.apache.bcel.classfile.Attribute[] attributes = java_class.getAttributes();
		for (int i = 0; i < attributes.length; i++) {
			attribute_html.writeAttribute(attributes[i], "class" + i);
		}
	}
}