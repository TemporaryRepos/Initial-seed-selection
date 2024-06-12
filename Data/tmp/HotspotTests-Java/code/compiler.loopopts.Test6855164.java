public class Test6855164 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.StringBuffer builder = new java.lang.StringBuffer();
		for (int i = 0; i < 100; i++) {
			builder.append("I am the very model of a modern major general\n");
		}
		for (int j = 0; j < builder.length(); j++) {
			compiler.loopopts.Test6855164.previousSpaceIndex(builder, j);
		}
	}

	private static final int previousSpaceIndex(java.lang.CharSequence sb, int seek) {
		seek--;
		while (seek > 0) {
			if (sb.charAt(seek) == ' ') {
				while ((seek > 0) && (sb.charAt(seek - 1) == ' ')) {
					seek--;
				} 
				return seek;
			}
			seek--;
		} 
		return 0;
	}
}