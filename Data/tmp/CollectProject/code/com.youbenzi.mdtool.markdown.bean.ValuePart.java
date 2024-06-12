public class ValuePart {
	private java.lang.String value;

	private com.youbenzi.mdtool.markdown.BlockType[] types;

	private int level;

	private java.lang.String url;

	private java.lang.String title;

	public ValuePart() {
		super();
	}

	public ValuePart(java.lang.String value) {
		this.value = com.youbenzi.mdtool.tool.Tools.revertValue(value);
	}

	public ValuePart(java.lang.String value, com.youbenzi.mdtool.markdown.BlockType... types) {
		this.value = com.youbenzi.mdtool.tool.Tools.revertValue(value);
		this.types = types;
	}

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = com.youbenzi.mdtool.tool.Tools.revertValue(value);
	}

	public com.youbenzi.mdtool.markdown.BlockType[] getTypes() {
		return types;
	}

	public void setTypes(com.youbenzi.mdtool.markdown.BlockType... types) {
		this.types = types;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public void addType(com.youbenzi.mdtool.markdown.BlockType type) {
		if (types != null) {
			types = java.util.Arrays.copyOf(types, types.length + 1);
		} else {
			types = new com.youbenzi.mdtool.markdown.BlockType[1];
		}
		types[types.length - 1] = type;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return (("value:" + value) + "|types:") + java.util.Arrays.toString(types);
	}

	public static void main(java.lang.String[] args) {
		com.youbenzi.mdtool.markdown.bean.ValuePart part = new com.youbenzi.mdtool.markdown.bean.ValuePart();
		part.setTypes(com.youbenzi.mdtool.markdown.BlockType.BOLD_WORD, com.youbenzi.mdtool.markdown.BlockType.CODE);
		java.lang.System.out.println(java.util.Arrays.toString(part.types));
		part.addType(com.youbenzi.mdtool.markdown.BlockType.HEADLINE);
		java.lang.System.out.println(java.util.Arrays.toString(part.types));
	}
}