public class CommentsUtil {
	public static final java.lang.String[] EMPTY = new java.lang.String[0];

	public static void main(java.lang.String[] args) {
		com.github.abel533.echarts.util.CommentsUtil.commentsFile(new java.io.File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\EventRiver.java"));
		com.github.abel533.echarts.util.CommentsUtil.commentsFile(new java.io.File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Detail.java"));
		com.github.abel533.echarts.util.CommentsUtil.commentsFile(new java.io.File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Event.java"));
		com.github.abel533.echarts.util.CommentsUtil.commentsFile(new java.io.File("E:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\series\\event\\Evolution.java"));
	}

	public static void commentsFile(java.io.File file) {
		java.io.BufferedReader reader = null;
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		try {
			reader = new java.io.BufferedReader(new java.io.FileReader(file));
			java.lang.String line = null;
			java.lang.String className = file.getName();
			className = className.substring(0, className.lastIndexOf("."));
			java.lang.String prevLine = null;
			while ((line = reader.readLine()) != null) {
				java.lang.String tempLline = line;
				if ((tempLline.contains("private") || tempLline.contains("public")) || tempLline.contains("protected")) {
					if ((prevLine == null) || (!prevLine.contains("*"))) {
						if (tempLline.contains("(") && tempLline.contains(")")) {
							tempLline = tempLline.trim();
							java.lang.String[] ps = com.github.abel533.echarts.util.CommentsUtil.getParameter(tempLline);
							if (ps == com.github.abel533.echarts.util.CommentsUtil.EMPTY) {
								if (com.github.abel533.echarts.util.CommentsUtil.isConstructor(tempLline)) {
									sb.append("\t/**\n\t * 构造函数 \n");
								} else {
									sb.append(("\t/**\n\t * 获取" + com.github.abel533.echarts.util.CommentsUtil.getMethodFieldName(tempLline)) + "值 \n");
								}
							} else {
								java.lang.String v = "";
								for (java.lang.String p : ps) {
									if (!v.equals("")) {
										v += ",";
									}
									v += p;
								}
								if (com.github.abel533.echarts.util.CommentsUtil.isConstructor(tempLline)) {
									sb.append(("\t/**\n\t * 构造函数,参数:" + v) + " \n\t * \n");
								} else {
									sb.append(("\t/**\n\t * 设置" + v) + "值 \n\t * \n");
								}
								for (java.lang.String s : ps) {
									sb.append(("\t * @param " + s) + "\n");
								}
							}
							sb.append("\t */\n");
							tempLline = "\t" + tempLline;
						}
					}
				}
				sb.append(tempLline + "\n");
				prevLine = tempLline;
			} 
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}
		}
		java.io.BufferedWriter writer = null;
		try {
			writer = new java.io.BufferedWriter(new java.io.FileWriter(file));
			writer.write(sb.toString());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean isConstructor(java.lang.String line) {
		line = line.substring(0, line.indexOf("(")).trim();
		if (line.split(" ").length == 2) {
			return true;
		}
		return false;
	}

	public static java.lang.String getMethodFieldName(java.lang.String line) {
		int end = line.lastIndexOf("(");
		int start = line.lastIndexOf(" ", end);
		java.lang.String name = line.substring(start + 1, end);
		if (name.startsWith("get")) {
			name = name.substring(3);
			name = name.substring(0, 1).toLowerCase() + name.substring(1);
		}
		return name;
	}

	public static java.lang.String[] getParameter(java.lang.String line) {
		if (line.contains("(") && line.contains(")")) {
			java.lang.String all = line.substring(line.indexOf("(") + 1, line.lastIndexOf(")"));
			if (all.equals("")) {
				return com.github.abel533.echarts.util.CommentsUtil.EMPTY;
			}
			while (all.contains("<")) {
				int start = all.indexOf("<");
				int end = all.indexOf(">", start);
				all = all.substring(0, start) + all.substring(end + 1);
			} 
			java.lang.String[] alls = all.split(",");
			java.lang.String[] parameters = new java.lang.String[alls.length];
			java.lang.System.out.println("All:" + all);
			for (int i = 0; i < alls.length; i++) {
				java.lang.System.out.println("\t" + alls[i]);
				parameters[i] = alls[i].trim().split(" ")[1].trim();
			}
			return parameters;
		}
		return com.github.abel533.echarts.util.CommentsUtil.EMPTY;
	}
}