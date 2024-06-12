public class HTMLDecorator implements com.youbenzi.mdtool.export.Decorator {
	private java.lang.StringBuilder content = new java.lang.StringBuilder();

	public void beginWork(java.lang.String outputFilePath) {
	}

	public void decorate(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> list) {
		for (com.youbenzi.mdtool.markdown.bean.Block block : list) {
			try {
				java.lang.String str;
				switch (block.getType()) {
					case CODE :
						str = codeParagraph(block.getValueParts());
						break;
					case HEADLINE :
						str = headerParagraph(block.getValueParts(), block.getLevel());
						break;
					case QUOTE :
						str = quoteParagraph(block.getListData());
						break;
					case TABLE :
						str = tableParagraph(block.getTableData());
						break;
					case LIST :
						str = listParagraph(block.getListData());
						break;
					default :
						str = commonTextParagraph(block.getValueParts(), true);
						break;
				}
				content.append(str).append("\n");
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void afterWork(java.lang.String outputFilePath) {
		java.io.File file = new java.io.File(outputFilePath);
		java.io.FileWriter writer = null;
		try {
			writer = new java.io.FileWriter(file);
			writer.write(content.toString());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
	}

	public java.lang.String outputHtml() {
		return content.toString();
	}

	private java.lang.String codeParagraph(com.youbenzi.mdtool.markdown.bean.ValuePart[] valueParts) {
		java.lang.String value = valueParts[0].getValue();
		java.lang.StringBuilder tmp = new java.lang.StringBuilder("<pre>");
		tmp.append("<code>");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		if (value.endsWith("\n")) {
			value = value.substring(0, value.length() - "\n".length());
		}
		tmp.append(value);
		tmp.append("</code>");
		tmp.append("</pre>\n");
		return tmp.toString();
	}

	private java.lang.String headerParagraph(com.youbenzi.mdtool.markdown.bean.ValuePart[] valueParts, int level) {
		return oneLineHtml(valueParts, "h" + level);
	}

	private java.lang.String listParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		java.lang.StringBuilder tmp = new java.lang.StringBuilder();
		for (com.youbenzi.mdtool.markdown.bean.Block block : listData) {
			tmp.append(listParagraph(block.getType(), block.getListData()));
		}
		return tmp.toString();
	}

	private java.lang.String listParagraph(com.youbenzi.mdtool.markdown.BlockType blockType, java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		java.lang.StringBuilder tmp = new java.lang.StringBuilder();
		switch (blockType) {
			case ORDERED_LIST :
				tmp.append(orderedListParagraph(listData)).append("\n");
				break;
			case UNORDERED_LIST :
				tmp.append(unorderedListParagraph(listData)).append("\n");
				break;
			case QUOTE :
				tmp.append(quoteParagraph(listData)).append("\n");
				break;
			case TODO_LIST :
				tmp.append(todoListParagraph(listData)).append("\n");
				break;
			default :
				break;
		}
		return tmp.toString();
	}

	private java.lang.String formatByType(com.youbenzi.mdtool.markdown.BlockType type, java.lang.String value, com.youbenzi.mdtool.markdown.bean.ValuePart valuePart) {
		switch (type) {
			case BOLD_WORD :
				return ("<strong>" + value) + "</strong>";
			case ITALIC_WORD :
				return ("<em>" + value) + "</em>";
			case STRIKE_WORD :
				return ("<del>" + value) + "</del>";
			case CODE_WORD :
				value = value.replaceAll("<", "&lt;");
				value = value.replaceAll(">", "&gt;");
				return ("<code>" + value) + "</code>";
			case HEADLINE :
				int level = valuePart.getLevel() + 1;
				return ((((("<h" + level) + ">") + value) + "</h") + level) + ">";
			case LINK :
				return ((((("<a href=\"" + valuePart.getUrl()) + "\" title=\"") + com.youbenzi.mdtool.tool.Tools.filterHtml(value)) + "\">") + value) + "</a>";
			case IMG :
				return ((((("<img src=\"" + valuePart.getUrl()) + "\" title=\"") + valuePart.getTitle()) + "\" alt=\"") + valuePart.getTitle()) + "\" />";
			case ROW :
				return "<br/>";
			default :
				return value;
		}
	}

	private java.lang.String tableParagraph(java.util.List<java.util.List<com.youbenzi.mdtool.markdown.bean.Block>> tableData) {
		int nRows = tableData.size();
		int nCols = 0;
		for (java.util.List<com.youbenzi.mdtool.markdown.bean.Block> list : tableData) {
			int s = list.size();
			if (nCols < s) {
				nCols = s;
			}
		}
		java.lang.StringBuilder tmp = new java.lang.StringBuilder("<table>\n");
		for (int i = 0; i < nRows; i++) {
			tmp.append("<tr>\n");
			java.util.List<com.youbenzi.mdtool.markdown.bean.Block> colDatas = tableData.get(i);
			for (int j = 0; j < nCols; j++) {
				com.youbenzi.mdtool.markdown.bean.Block block = colDatas.get(j);
				boolean head = i == 0;
				tmp.append(buildColBegin(head, block.getAlign()));
				try {
					tmp.append(commonTextParagraph(colDatas.get(j).getValueParts(), false));
				} catch (java.lang.Exception e) {
					tmp.append("");
				}
				tmp.append(("</" + (head ? "th" : "td")) + ">\n");
			}
			tmp.append("</tr>\n");
		}
		tmp.append("</table>\n");
		return tmp.toString();
	}

	private java.lang.String buildColBegin(boolean head, com.youbenzi.mdtool.markdown.TableCellAlign align) {
		java.lang.String alignString = "";
		if (align != com.youbenzi.mdtool.markdown.TableCellAlign.NONE) {
			alignString = ("align=\"" + align.value()) + "\"";
		}
		return ((("<" + (head ? "th" : "td")) + " ") + alignString) + ">";
	}

	private java.lang.String abstractListParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData, com.youbenzi.mdtool.export.HTMLDecorator.LineHelper lineHelper) {
		java.lang.StringBuilder tmp = new java.lang.StringBuilder(lineHelper.parentTagBegin() + "\n");
		for (final com.youbenzi.mdtool.markdown.bean.Block block : listData) {
			com.youbenzi.mdtool.markdown.bean.Block lineBlock = block.getLineData();
			java.lang.String content;
			if (lineBlock.getType() == com.youbenzi.mdtool.markdown.BlockType.HEADLINE) {
				content = headerParagraph(lineBlock.getValueParts(), lineBlock.getLevel());
			} else {
				content = commonTextParagraph(lineBlock.getValueParts(), lineHelper.needDefaultChild());
			}
			tmp.append(lineHelper.childTagBegin(block));
			tmp.append(content).append("\n").append(lineHelper.subList(block));
			tmp.append(lineHelper.childTagEnd());
		}
		tmp.append(lineHelper.parentTagEnd() + "\n");
		return tmp.toString();
	}

	private java.lang.String quoteParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		return abstractListParagraph(listData, new com.youbenzi.mdtool.export.HTMLDecorator.DefaultLineHelper("blockquote"));
	}

	private java.lang.String unorderedListParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		return abstractListParagraph(listData, new com.youbenzi.mdtool.export.HTMLDecorator.DefaultLineHelper("ul", "li"));
	}

	private java.lang.String orderedListParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		return abstractListParagraph(listData, new com.youbenzi.mdtool.export.HTMLDecorator.DefaultLineHelper("ol", "li"));
	}

	private java.lang.String todoListParagraph(java.util.List<com.youbenzi.mdtool.markdown.bean.Block> listData) {
		return abstractListParagraph(listData, new com.youbenzi.mdtool.export.HTMLDecorator.DefaultLineHelper("ul", "li") {
			@java.lang.Override
			public java.lang.String decorate(com.youbenzi.mdtool.markdown.bean.Block block, java.lang.String tag) {
				if (block.getMdToken().equals(com.youbenzi.mdtool.markdown.MDToken.TODO_LIST_UNCHECKED)) {
					return ("<" + tag) + "><i class=\"unchecked_icon\"></i>";
				} else {
					return ("<" + tag) + "><i class=\"checked_icon\"></i>";
				}
			}
		});
	}

	private java.lang.String commonTextParagraph(com.youbenzi.mdtool.markdown.bean.ValuePart[] valueParts, boolean needPTag) {
		return oneLineHtml(valueParts, needPTag ? "p" : null);
	}

	private java.lang.String oneLineHtml(com.youbenzi.mdtool.markdown.bean.ValuePart[] valueParts, java.lang.String tagName) {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		if ((tagName != null) && (!tagName.trim().equals(""))) {
			result.append(("<" + tagName) + ">");
		}
		for (com.youbenzi.mdtool.markdown.bean.ValuePart valuePart : valueParts) {
			com.youbenzi.mdtool.markdown.BlockType[] types = valuePart.getTypes();
			java.lang.String value = valuePart.getValue();
			if (hasLink(types)) {
				value = valuePart.getTitle();
			}
			if (types != null) {
				for (com.youbenzi.mdtool.markdown.BlockType type : types) {
					value = formatByType(type, value, valuePart);
				}
			}
			result.append(value);
		}
		if ((tagName != null) && (!tagName.trim().equals(""))) {
			result.append(("</" + tagName) + ">");
		}
		return result.toString();
	}

	private boolean hasLink(com.youbenzi.mdtool.markdown.BlockType[] types) {
		if (types == null) {
			return false;
		}
		for (com.youbenzi.mdtool.markdown.BlockType blockType : types) {
			if (blockType == com.youbenzi.mdtool.markdown.BlockType.LINK) {
				return true;
			}
		}
		return false;
	}

	public abstract class LineHelper {
		public abstract java.lang.String subList(com.youbenzi.mdtool.markdown.bean.Block block);

		public abstract java.lang.String parentTagBegin();

		public abstract java.lang.String parentTagEnd();

		public abstract java.lang.String childTagBegin(com.youbenzi.mdtool.markdown.bean.Block block);

		public abstract java.lang.String childTagEnd();

		public abstract boolean needDefaultChild();

		public java.lang.String decorate(com.youbenzi.mdtool.markdown.bean.Block block, java.lang.String tag) {
			if (tag == null) {
				return "";
			}
			return ("<" + tag) + ">";
		}
	}

	public class DefaultLineHelper extends com.youbenzi.mdtool.export.HTMLDecorator.LineHelper {
		private java.lang.String parentTag;

		private java.lang.String childTag;

		public DefaultLineHelper(java.lang.String parentTag, java.lang.String childTag) {
			this.parentTag = parentTag;
			this.childTag = childTag;
		}

		public DefaultLineHelper(java.lang.String parentTag) {
			this.parentTag = parentTag;
			this.childTag = null;
		}

		public boolean needDefaultChild() {
			return childTag == null;
		}

		public java.lang.String parentTagBegin() {
			return ("<" + parentTag) + ">";
		}

		public java.lang.String parentTagEnd() {
			return ("</" + parentTag) + ">";
		}

		public java.lang.String childTagBegin(com.youbenzi.mdtool.markdown.bean.Block block) {
			return decorate(block, childTag);
		}

		public java.lang.String childTagEnd() {
			if (childTag == null) {
				return "";
			}
			return ("</" + childTag) + ">";
		}

		public java.lang.String subList(com.youbenzi.mdtool.markdown.bean.Block block) {
			if (block.getType() != null) {
				return listParagraph(block.getType(), block.getListData());
			} else {
				return "";
			}
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.String content = "1. 列表1.1\n" + (((("2. 列表1.2\n" + "    * 列表2.1\n") + "    * 列表2.2\n") + "    * 列表2.3\n") + "    * 列表2.4\n");
		java.lang.System.out.println(com.youbenzi.mdtool.tool.MDTool.markdown2Html(content));
	}
}