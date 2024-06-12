public class Generator {
	public static void main(java.lang.String[] args) {
		java.lang.String _lines = "private TextStyle textStyle;";
		java.lang.String _type = "DataZoom";
		com.github.abel533.echarts.Generator.simpleNew(_type, _lines);
	}

	public static void simple(java.lang.String _type, java.lang.String _lines) {
		java.lang.String _this = "\treturn this;";
		if (_type.equals("T")) {
			_this = "\treturn (T) this;";
		}
		java.lang.String[] lines = com.github.abel533.echarts.Generator.lines(_lines);
		for (java.lang.String line : lines) {
			java.lang.String[] ls = line.split(" ");
			java.lang.System.out.println(((("public " + ls[1]) + " ") + ls[2]) + "(){");
			java.lang.System.out.println(("\treturn this." + ls[2]) + ";");
			java.lang.System.out.println("}\n");
			java.lang.System.out.println(((((((("public " + _type) + " ") + ls[2]) + "(") + ls[1]) + " ") + ls[2]) + "){");
			java.lang.System.out.println(((("\tthis." + ls[2]) + " = ") + ls[2]) + ";");
			java.lang.System.out.println(_this);
			java.lang.System.out.println("}\n");
		}
	}

	public static void simpleNew(java.lang.String _type, java.lang.String _lines) {
		java.lang.String _this = "\treturn this;";
		if (_type.equals("T")) {
			_this = "\treturn (T) this;";
		}
		java.lang.String[] lines = com.github.abel533.echarts.Generator.lines(_lines);
		for (java.lang.String line : lines) {
			java.lang.String[] ls = line.split(" ");
			java.lang.System.out.println(((("public " + ls[1]) + " ") + ls[2]) + "(){");
			java.lang.System.out.println(("\tif(this." + ls[2]) + " == null){");
			java.lang.System.out.println(((("\t\tthis." + ls[2]) + "= new ") + ls[1]) + "();");
			java.lang.System.out.println("\t}");
			java.lang.System.out.println(("\treturn this." + ls[2]) + ";");
			java.lang.System.out.println("}\n");
			java.lang.System.out.println(((((((("public " + _type) + " ") + ls[2]) + "(") + ls[1]) + " ") + ls[2]) + "){");
			java.lang.System.out.println(((("\tthis." + ls[2]) + " = ") + ls[2]) + ";");
			java.lang.System.out.println(_this);
			java.lang.System.out.println("}\n");
		}
	}

	public static java.lang.String[] lines(java.lang.String _lines) {
		java.util.List<java.lang.String> lineList = new java.util.ArrayList<java.lang.String>();
		java.lang.String[] lines = _lines.split("\n");
		for (java.lang.String line : lines) {
			line = line.trim();
			if (line.length() == 0) {
				continue;
			}
			if (line.endsWith(";")) {
				line = line.substring(0, line.length() - 1);
			}
			lineList.add(line);
		}
		return lineList.toArray(new java.lang.String[]{  });
	}
}