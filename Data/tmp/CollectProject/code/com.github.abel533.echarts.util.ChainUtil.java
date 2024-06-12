public class ChainUtil {
	public static void main(java.lang.String[] args) {
		com.github.abel533.echarts.util.ChainUtil.chainFile(new java.io.File("G:\\Git\\OpenSource\\ECharts\\src\\main\\java\\com\\github\\abel533\\echarts\\RoamController.java"));
	}

	public static void chainFile(java.io.File file) {
		java.io.BufferedReader reader = null;
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		try {
			reader = new java.io.BufferedReader(new java.io.FileReader(file));
			java.lang.String line = null;
			java.lang.String className = file.getName();
			className = className.substring(0, className.lastIndexOf("."));
			while ((line = reader.readLine()) != null) {
				java.lang.String tempLline = line.trim();
				if (tempLline.startsWith("public") && tempLline.endsWith(";")) {
					tempLline = tempLline.substring(0, tempLline.length() - 1);
					java.lang.String[] strs = tempLline.split(" ");
					if (strs.length != 3) {
						sb.append(line).append("\n");
						continue;
					}
					sb.append(((("\tprivate " + strs[1]) + " ") + strs[2]) + ";\n\n");
					sb.append(((("\tpublic " + strs[1]) + " ") + strs[2]) + "(){\n");
					sb.append(("\t\treturn this." + strs[2]) + ";\n\t}\n\n");
					sb.append(((((((("\tpublic " + className) + " ") + strs[2]) + "(") + strs[1]) + " ") + strs[2]) + "){\n");
					sb.append(((("\t\tthis." + strs[2]) + " = ") + strs[2]) + ";\n");
					sb.append("\t\treturn this;\n\t}\n");
				} else {
					sb.append(line).append("\n");
				}
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

	public static java.util.List<java.io.File> allFiles(java.io.File file) {
		java.util.List<java.io.File> result = new java.util.ArrayList<java.io.File>();
		if (file.isFile()) {
			result.add(file);
		} else if (file.isDirectory()) {
			java.io.File[] files = file.listFiles(new java.io.FilenameFilter() {
				@java.lang.Override
				public boolean accept(java.io.File dir, java.lang.String name) {
					if (dir.isDirectory()) {
						return true;
					} else if (name.toUpperCase().endsWith(".JAVA")) {
						return true;
					}
					return false;
				}
			});
			for (java.io.File f : files) {
				result.addAll(com.github.abel533.echarts.util.ChainUtil.allFiles(f));
			}
		}
		return result;
	}

	public static java.lang.String getSrcPath() {
		java.lang.String basePath = com.github.abel533.echarts.util.ChainUtil.getBasePath();
		return basePath + "src/main/java";
	}

	public static java.lang.String getBasePath() {
		java.lang.String path = com.github.abel533.echarts.util.ChainUtil.class.getResource("/").getPath();
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		if (path.indexOf("target1") > 0) {
			path = path.substring(0, path.indexOf("target"));
		} else if (path.indexOf("ECharts") > 0) {
			path = path.substring(0, path.indexOf("ECharts")) + "Echarts/";
		}
		return path;
	}
}