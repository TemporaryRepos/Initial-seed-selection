public class GenerateModels {
	protected java.io.PrintStream out = java.lang.System.out;

	public static void main(java.lang.String... args) {
		com.iciql.util.GenerateModels tool = new com.iciql.util.GenerateModels();
		try {
			tool.runTool(args);
		} catch (java.sql.SQLException e) {
			tool.out.print("Error: ");
			tool.out.println(e.getMessage());
			tool.out.println();
			tool.showUsage();
		}
	}

	public void runTool(java.lang.String... args) throws java.sql.SQLException {
		java.lang.String url = null;
		java.lang.String user = "sa";
		java.lang.String password = "";
		java.lang.String schema = null;
		java.lang.String table = null;
		java.lang.String packageName = "";
		java.lang.String folder = null;
		boolean annotateSchema = true;
		boolean trimStrings = false;
		for (int i = 0; (args != null) && (i < args.length); i++) {
			java.lang.String arg = args[i];
			if (arg.equals("-url")) {
				url = args[++i];
			} else if (arg.equals("-user")) {
				user = args[++i];
			} else if (arg.equals("-password")) {
				password = args[++i];
			} else if (arg.equals("-schema")) {
				schema = args[++i];
			} else if (arg.equals("-table")) {
				table = args[++i];
			} else if (arg.equals("-package")) {
				packageName = args[++i];
			} else if (arg.equals("-folder")) {
				folder = args[++i];
			} else if (arg.equals("-annotateSchema")) {
				try {
					annotateSchema = java.lang.Boolean.parseBoolean(args[++i]);
				} catch (java.lang.Throwable t) {
					throw new java.sql.SQLException("Can not parse -annotateSchema value");
				}
			} else if (arg.equals("-trimStrings")) {
				try {
					trimStrings = java.lang.Boolean.parseBoolean(args[++i]);
				} catch (java.lang.Throwable t) {
					throw new java.sql.SQLException("Can not parse -trimStrings value");
				}
			} else {
				throwUnsupportedOption(arg);
			}
		}
		if (url == null) {
			throw new java.sql.SQLException("URL not set");
		}
		com.iciql.util.GenerateModels.execute(url, user, password, schema, table, packageName, folder, annotateSchema, trimStrings);
	}

	public static void execute(java.lang.String url, java.lang.String user, java.lang.String password, java.lang.String schema, java.lang.String table, java.lang.String packageName, java.lang.String folder, boolean annotateSchema, boolean trimStrings) throws java.sql.SQLException {
		try {
			com.iciql.Db db;
			if (password == null) {
				db = com.iciql.Db.open(url, user, ((java.lang.String) (null)));
			} else {
				db = com.iciql.Db.open(url, user, password);
			}
			com.iciql.DbInspector inspector = new com.iciql.DbInspector(db);
			java.util.List<java.lang.String> models = inspector.generateModel(schema, table, packageName, annotateSchema, trimStrings);
			java.io.File parentFile;
			if (com.iciql.util.StringUtils.isNullOrEmpty(folder)) {
				parentFile = new java.io.File(java.lang.System.getProperty("user.dir"));
			} else {
				parentFile = new java.io.File(folder);
			}
			parentFile.mkdirs();
			java.util.regex.Pattern p = java.util.regex.Pattern.compile("class ([a-zA-Z0-9]+)");
			for (java.lang.String model : models) {
				java.util.regex.Matcher m = p.matcher(model);
				if (m.find()) {
					java.lang.String className = m.group().substring("class".length()).trim();
					java.io.File classFile = new java.io.File(parentFile, className + ".java");
					java.io.Writer o = new java.io.FileWriter(classFile, false);
					java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedWriter(o));
					writer.write(model);
					writer.close();
					java.lang.System.out.println("Generated " + classFile.getAbsolutePath());
				}
			}
		} catch (java.io.IOException io) {
			throw new java.sql.SQLException("could not generate model", io);
		}
	}

	protected java.sql.SQLException throwUnsupportedOption(java.lang.String option) throws java.sql.SQLException {
		showUsage();
		throw new java.sql.SQLException("Unsupported option: " + option);
	}

	protected void showUsage() {
		out.println("GenerateModels");
		out.println("Usage:");
		out.println();
		out.println("(*) -url jdbc:h2:~test");
		out.println("    -user <string>");
		out.println("    -password <string>");
		out.println("    -schema <string>");
		out.println("    -table <string>");
		out.println("    -package <string>");
		out.println("    -folder <string>");
		out.println("    -annotateSchema <boolean>");
		out.println("    -trimStrings <boolean>");
	}
}