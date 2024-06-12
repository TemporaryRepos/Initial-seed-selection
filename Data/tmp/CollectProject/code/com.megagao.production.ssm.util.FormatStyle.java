public class FormatStyle {
	public static void main(java.lang.String[] args) {
		com.megagao.production.ssm.util.FormatStyle formatStyle = new com.megagao.production.ssm.util.FormatStyle();
		java.lang.System.out.println(formatStyle.fileSize("10737418240"));
	}

	public java.lang.String fileSize(java.lang.String s1) {
		int iPos = 0;
		java.lang.String s = "";
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		try {
			if (s1.trim().compareTo("") == 0) {
				return "";
			}
			long g = java.lang.Long.parseLong("1099511627776");
			double i = java.lang.Double.parseDouble(s1);
			if (i <= 0) {
				sBuf.append("");
			} else if (i < 1024) {
				sBuf.append(i).append(" B");
				iPos = sBuf.lastIndexOf(".00 B");
				if (iPos > 0) {
					sBuf.delete(iPos, sBuf.length() - 2);
				}
			} else if (i < (1024 * 1024)) {
				sBuf.append(new java.text.DecimalFormat(".00").format(i / 1024)).append(" KB");
				iPos = sBuf.lastIndexOf(".00 KB");
				if (iPos > 0) {
					sBuf.delete(iPos, sBuf.length() - 3);
				}
			} else if (i < ((1024 * 1024) * 1024)) {
				sBuf.append(new java.text.DecimalFormat(".00").format(i / (1024 * 1024))).append(" M");
				iPos = sBuf.lastIndexOf(".00 M");
				if (iPos > 0) {
					sBuf.delete(iPos, sBuf.length() - 2);
				}
			} else {
				sBuf.append(new java.text.DecimalFormat(".00").format(i / ((1024 * 1024) * 1024))).append(" G");
				iPos = sBuf.lastIndexOf(".00 G");
				if (iPos > 0) {
					sBuf.delete(iPos, sBuf.length() - 2);
				}
			}
		} catch (java.lang.Exception e) {
			return "";
		}
		return sBuf.toString();
	}
}