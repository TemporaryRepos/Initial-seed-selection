public class UtilFuns {
	public static java.lang.String newLine() {
		return java.lang.System.getProperty("line.separator");
	}

	public static boolean arrayValid(java.lang.Object[] objects) {
		if ((objects != null) && (objects.length > 0)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean listValid(java.util.List list) {
		if ((list != null) && (list.size() > 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int age(java.lang.String dateStart, java.lang.String dateEnd) throws java.lang.Exception {
		int yearStart = java.lang.Integer.parseInt(dateStart.substring(0, 4));
		int yearEnd = java.lang.Integer.parseInt(dateEnd.substring(0, 4));
		return yearEnd - yearStart;
	}

	public boolean isOdd(int i) {
		if ((i % 2) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public java.lang.String cutStr(java.lang.String str, int len) {
		try {
			str = str.substring(0, len);
		} catch (java.lang.Exception e) {
			return str;
		}
		return str;
	}

	public java.lang.String fixSpaceStr(java.lang.String str, int len) {
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		try {
			if (str.length() > len) {
				return str;
			} else {
				sBuf.append(str);
				for (int i = 0; i < (len - str.length()); i++) {
					sBuf.append(" ");
				}
				return sBuf.toString();
			}
		} catch (java.lang.Exception e) {
			return str;
		}
	}

	public java.lang.String fixSpaceStr(int number, int len) {
		return fixSpaceStr(java.lang.String.valueOf(number), len);
	}

	public java.lang.String prefixSpaceStr(java.lang.String str, int len) {
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		try {
			if (str.length() > len) {
				return str;
			} else {
				for (int i = 0; i < (len - str.length()); i++) {
					sBuf.append(" ");
				}
				sBuf.append(str);
				return sBuf.toString();
			}
		} catch (java.lang.Exception e) {
			return str;
		}
	}

	public java.lang.String suspensionStr(java.lang.String str, int len) {
		try {
			str = str.substring(0, len) + "...";
		} catch (java.lang.Exception e) {
			return str;
		}
		return str;
	}

	public static java.lang.String joinUrlParameter(java.util.List<java.lang.String> sList) {
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		for (java.util.Iterator it = sList.iterator(); it.hasNext();) {
			sBuf.append("&").append(it.next()).append("=").append(it.next());
		}
		return sBuf.substring(1, sBuf.length());
	}

	public static java.lang.String[] splitStr(java.lang.String str, java.lang.String SplitFlag) {
		int i = 0;
		try {
			java.util.StringTokenizer st = new java.util.StringTokenizer(str, SplitFlag);
			java.lang.String[] tokens = new java.lang.String[st.countTokens()];
			while (st.hasMoreElements()) {
				tokens[i] = st.nextToken();
				i++;
			} 
			return tokens;
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public java.lang.String[] splitFindStr(java.lang.String str) {
		if (str == null) {
			return null;
		}
		java.lang.String[] aStr = null;
		str = str.replaceAll(",", " ");
		str = str.replaceAll("，", " ");
		aStr = this.splitStr(str, " ");
		return aStr;
	}

	public static java.lang.String[] splitStair(java.lang.String str, java.lang.String SplitFlag) {
		try {
			java.lang.String[] _temp = com.megagao.production.ssm.util.UtilFuns.splitStr(str, SplitFlag);
			for (int i = 1; i < _temp.length; i++) {
				_temp[i] = (_temp[i - 1] + SplitFlag) + _temp[i];
			}
			return _temp;
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public static java.lang.String joinStr(java.lang.String[] aStr, java.lang.String SplitFlag) {
		java.lang.StringBuffer sBuffer = new java.lang.StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(aStr[i]).append(SplitFlag);
			}
			sBuffer.delete(sBuffer.length() - 1, sBuffer.length());
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	public static java.lang.String joinStr(java.lang.String[] aStr) {
		java.lang.StringBuffer sBuffer = new java.lang.StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(aStr[i]);
			}
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	public static java.lang.String joinStr(java.lang.String[] aStr, java.lang.String sPrefix, java.lang.String sSuffix, java.lang.String SplitFlag) {
		java.lang.StringBuffer sBuffer = new java.lang.StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix).append(SplitFlag);
			}
			sBuffer.delete(sBuffer.length() - SplitFlag.length(), sBuffer.length());
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	public static java.lang.String joinInStr(java.lang.String[] aStr) {
		java.lang.StringBuffer sBuffer = new java.lang.StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append("'").append(aStr[i]).append("'").append(",");
			}
			sBuffer.delete(sBuffer.length() - 1, sBuffer.length());
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	public static java.lang.String joinStr(java.lang.String[] aStr, java.lang.String sPrefix, java.lang.String sSuffix) {
		java.lang.StringBuffer sBuffer = new java.lang.StringBuffer();
		if (aStr != null) {
			for (int i = 0; i < aStr.length; i++) {
				sBuffer.append(sPrefix).append(aStr[i]).append(sSuffix);
			}
		} else {
			sBuffer = sBuffer.append("");
		}
		return sBuffer.toString();
	}

	public static java.lang.String joinStr(java.lang.String s, java.lang.String symbol) {
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			sBuf.append(symbol);
		}
		return sBuf.toString();
	}

	public static java.lang.String joinStr(int len, java.lang.String symbol) {
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		for (int i = 0; i < len; i++) {
			sBuf.append(symbol);
		}
		return sBuf.toString();
	}

	public static java.lang.String SysTime(java.lang.String strStyle) {
		java.lang.String s = "";
		if (strStyle.compareTo("") == 0) {
			strStyle = "yyyy-MM-dd HH:mm:ss";
		}
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat(strStyle);
		s = dformat.format(date);
		return s;
	}

	public static java.lang.String sysTime() {
		java.lang.String s = "";
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		s = dformat.format(date);
		return s;
	}

	public static java.lang.String sysDate() {
		java.lang.String s = "";
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd");
		s = dformat.format(date);
		return s;
	}

	public static boolean isNull(java.lang.Object obj) {
		try {
			if (obj == null) {
				return true;
			}
			return false;
		} catch (java.lang.Exception e) {
			return false;
		}
	}

	public static boolean isNotNull(java.lang.Object obj) {
		try {
			if (obj == null) {
				return false;
			}
			return true;
		} catch (java.lang.Exception e) {
			return true;
		}
	}

	public static boolean isEmpty(java.lang.String str) {
		try {
			if (((str == null) || str.equals("null")) || str.equals("")) {
				return true;
			}
			return false;
		} catch (java.lang.Exception e) {
			return false;
		}
	}

	public static boolean isEmpty(java.lang.String[] strs) {
		try {
			if ((strs == null) || (strs.length <= 0)) {
				return true;
			}
			return false;
		} catch (java.lang.Exception e) {
			return false;
		}
	}

	public static boolean isNotEmpty(java.lang.String str) {
		try {
			if (((str == null) || str.equals("null")) || str.equals("")) {
				return false;
			}
			return true;
		} catch (java.lang.Exception e) {
			return true;
		}
	}

	public static boolean isNotEmpty(java.lang.Object obj) {
		try {
			if (((obj == null) || obj.toString().equals("null")) || obj.toString().equals("")) {
				return false;
			}
			return true;
		} catch (java.lang.Exception e) {
			return true;
		}
	}

	public static boolean isNotEmpty(java.util.List obj) {
		try {
			if ((obj == null) || (obj.size() <= 0)) {
				return false;
			}
			return true;
		} catch (java.lang.Exception e) {
			return true;
		}
	}

	public static java.lang.String convertNull(java.lang.String strvalue) {
		try {
			if (strvalue.equals("null") || (strvalue.length() == 0)) {
				return "";
			} else {
				return strvalue.trim();
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String[] convertNull(java.lang.String[] aContent) {
		try {
			for (int i = 0; i < aContent.length; i++) {
				if (aContent[i].toLowerCase().compareTo("null") == 0) {
					aContent[i] = "";
				}
			}
			return aContent;
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public static java.lang.String convertNull(java.lang.Object o) {
		try {
			java.lang.String strvalue = java.lang.String.valueOf(o);
			if ((strvalue.equals(null) || strvalue.equals("null")) || (strvalue.length() == 0)) {
				return "";
			} else {
				return strvalue.trim();
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static int ConvertZero(java.lang.Object o) {
		try {
			java.lang.String s = com.megagao.production.ssm.util.UtilFuns.convertNull(o);
			if (s == "") {
				return 0;
			} else {
				return java.lang.Integer.parseInt(s);
			}
		} catch (java.lang.Exception e) {
			return 0;
		}
	}

	public static int cvtPecrent(java.lang.Object o) {
		try {
			java.lang.String s = com.megagao.production.ssm.util.UtilFuns.convertNull(o);
			if (s == "") {
				return 0;
			} else {
				return java.lang.Integer.parseInt(s);
			}
		} catch (java.lang.Exception e) {
			return 0;
		}
	}

	public static java.lang.String FormatZero(java.lang.Object o) {
		try {
			java.lang.String s = com.megagao.production.ssm.util.UtilFuns.convertNull(o);
			if (s.compareTo("") == 0) {
				return "";
			} else {
				return java.lang.String.valueOf(s);
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String FormatZero(java.lang.String s) {
		try {
			if (s.compareTo("0") == 0) {
				return "";
			} else {
				return s;
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String FormatNumber(java.lang.Object o, java.lang.String patter) {
		double d = 0;
		try {
			d = java.lang.Double.parseDouble(java.lang.String.valueOf(o));
			java.text.DecimalFormat df = new java.text.DecimalFormat(patter);
			return df.format(d);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e.getMessage());
			return "";
		}
	}

	public static java.lang.String FormatNumber(java.lang.String s) {
		double d = 0;
		try {
			d = java.lang.Double.parseDouble(s);
			java.text.DecimalFormat df = new java.text.DecimalFormat(",###.00");
			return df.format(d);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e.getMessage());
			return "";
		}
	}

	public static java.lang.String ConvertTD(java.lang.String strvalue) {
		try {
			strvalue = strvalue.trim();
			if (strvalue.equals("null") || (strvalue.length() == 0)) {
				return "&nbsp;";
			} else {
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			return "&nbsp;";
		}
	}

	public static java.lang.String ConvertSpaceTD(java.lang.Object o) {
		try {
			java.lang.String strvalue = java.lang.String.valueOf(o);
			strvalue = strvalue.trim();
			if (strvalue.equals("null") || (strvalue.length() == 0)) {
				return "&nbsp;";
			} else {
				return " " + strvalue.trim();
			}
		} catch (java.lang.Exception e) {
			return "&nbsp;";
		}
	}

	public static java.lang.String ConvertCH(java.lang.String strvalue) {
		java.lang.System.out.println("ConvertCH:" + strvalue);
		try {
			if (strvalue == null) {
				return "null";
			} else if (strvalue.length() == 0) {
				return "";
			} else {
				strvalue = new java.lang.String(strvalue.getBytes("ISO8859_1"), "GB2312");
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String ConvertCStr(java.lang.String strvalue) {
		try {
			strvalue = com.megagao.production.ssm.util.UtilFuns.convertNull(strvalue);
			if (strvalue.equals("")) {
				return "";
			} else {
				strvalue = new java.lang.String(strvalue.getBytes("ISO8859_1"), "GB2312");
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String ConvertCStr(java.lang.Object o) {
		java.lang.String strvalue = "";
		try {
			strvalue = java.lang.String.valueOf(o);
			strvalue = com.megagao.production.ssm.util.UtilFuns.convertNull(strvalue);
			if (strvalue.equals("")) {
				return "";
			} else {
				strvalue = new java.lang.String(strvalue.getBytes("ISO8859_1"), "GB2312");
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("ConvertCStr:" + e.toString());
			return "";
		}
	}

	public java.lang.String UrlEncoder(java.lang.String s) {
		java.lang.String s1 = "";
		if (s == null) {
			return "";
		}
		try {
			s1 = java.net.URLEncoder.encode(s);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("URL Encoder :" + e.toString());
			s1 = "";
		}
		return s1;
	}

	public java.lang.String UrlDecoder(java.lang.String s) {
		java.lang.String s1 = "";
		if (s == null) {
			return "";
		}
		try {
			s1 = java.net.URLDecoder.decode(s);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("URL Encoder :" + e.toString());
			s1 = "";
		}
		return s1;
	}

	public static java.lang.String format_Aaa(java.lang.String source) {
		if (source == null) {
			return null;
		}
		if (source.equals("")) {
			return "";
		}
		java.lang.String a;
		a = source.substring(0, 1);
		a = a.toUpperCase();
		return a + source.substring(1);
	}

	public static long parseLong(java.lang.String param) {
		long l = 0;
		try {
			l = java.lang.Long.parseLong(param);
		} catch (java.lang.Exception e) {
		}
		return l;
	}

	public static float parseFloat(java.lang.String param) {
		float l = 0;
		try {
			l = java.lang.Float.parseFloat(param);
		} catch (java.lang.Exception e) {
		}
		return l;
	}

	public static int parseInt(java.lang.String param) {
		int l = 0;
		try {
			l = java.lang.Integer.parseInt(param);
		} catch (java.lang.Exception e) {
		}
		return l;
	}

	public static java.util.Date parseDate(java.lang.String currDate, java.lang.String format) {
		java.text.SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new java.text.SimpleDateFormat(format);
			return dtFormatdB.parse(currDate);
		} catch (java.lang.Exception e) {
			dtFormatdB = new java.text.SimpleDateFormat("yyyy-MM-dd");
			try {
				return dtFormatdB.parse(currDate);
			} catch (java.lang.Exception ex) {
			}
		}
		return null;
	}

	public static java.util.Date parseDate(java.lang.String currDate) {
		java.text.SimpleDateFormat dtFormatdB = null;
		dtFormatdB = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try {
			return dtFormatdB.parse(currDate);
		} catch (java.lang.Exception e) {
			try {
				return dtFormatdB.parse(currDate);
			} catch (java.lang.Exception ex) {
			}
		}
		return null;
	}

	public static java.util.Date parseTime(java.lang.String currDate, java.lang.String format) {
		java.text.SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new java.text.SimpleDateFormat(format);
			return dtFormatdB.parse(currDate);
		} catch (java.lang.Exception e) {
			dtFormatdB = new java.text.SimpleDateFormat("HH:mm:ss");
			try {
				return dtFormatdB.parse(currDate);
			} catch (java.lang.Exception ex) {
			}
		}
		return null;
	}

	public static java.util.Date parseDateTime(java.lang.String currDate, java.lang.String format) {
		java.text.SimpleDateFormat dtFormatdB = null;
		try {
			dtFormatdB = new java.text.SimpleDateFormat(format);
			return dtFormatdB.parse(currDate);
		} catch (java.lang.Exception e) {
			dtFormatdB = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return dtFormatdB.parse(currDate);
			} catch (java.lang.Exception ex) {
			}
		}
		return null;
	}

	public static double parseDouble(java.lang.String param) {
		double l = 0;
		try {
			l = java.lang.Double.parseDouble(param);
		} catch (java.lang.Exception e) {
		}
		return l;
	}

	public static int existElements(java.lang.String s, java.util.ArrayList aList) {
		try {
			for (int i = 0; i < aList.size(); i++) {
				if (s.equals(aList.get(i))) {
					return i;
				}
			}
		} catch (java.lang.Exception e) {
		}
		return -1;
	}

	public static int existElements(java.lang.String s, java.lang.String[] a) {
		try {
			for (int i = 0; i < a.length; i++) {
				if (s.compareTo(a[i].trim()) == 0) {
					return i;
				}
			}
		} catch (java.lang.Exception e) {
		}
		return -1;
	}

	public static boolean existElements(java.lang.Object o, java.util.Set set) {
		boolean isExists = false;
		java.util.Iterator it = set.iterator();
		while (it.hasNext()) {
			java.lang.Object obj = it.next();
			if (o.equals(obj)) {
				isExists = true;
				break;
			}
		} 
		return isExists;
	}

	public static int IsIndexOfElements(java.lang.String s, java.util.ArrayList aList) {
		try {
			java.lang.String s1 = "";
			for (int i = 0; i < aList.size(); i++) {
				s1 = java.lang.String.valueOf(aList.get(i));
				if (s1.indexOf(s) != (-1)) {
					return i;
				}
			}
		} catch (java.lang.Exception e) {
		}
		return -1;
	}

	public java.lang.String[] ArrayListToString(java.util.ArrayList aList) {
		java.lang.String[] s = new java.lang.String[aList.size()];
		for (int i = 0; i < aList.size(); i++) {
			s[i] = this.convertNull(aList.get(i));
		}
		return s;
	}

	public static void formatArrayList(java.util.ArrayList al) {
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) == null) {
				al.set(i, "");
			}
		}
	}

	public java.lang.String ComboList(java.lang.String CurrentValue, java.lang.String[] content) {
		int i = 0;
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		java.lang.String selected = " selected";
		try {
			sBuf.append("<option value='' selected>--请选择--</option>");
			for (i = 0; i < content.length; i++) {
				sBuf.append("\n<option value=\'").append(i).append("'");
				if (CurrentValue.compareTo(java.lang.String.valueOf(i)) == 0) {
					sBuf.append(selected);
				}
				sBuf.append(">").append(content[i]).append("</option>");
			}
			return sBuf.toString();
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public java.lang.String ComboListMust(java.lang.String CurrentValue, java.lang.String[] content) {
		int i = 0;
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		java.lang.String selected = " selected";
		try {
			for (i = 0; i < content.length; i++) {
				sBuf.append("\n<option value=\'").append(i).append("'");
				if (CurrentValue.compareTo(java.lang.String.valueOf(i)) == 0) {
					sBuf.append(selected);
				}
				sBuf.append(">").append(content[i]).append("</option>");
			}
			return sBuf.toString();
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public java.lang.String ComboList(java.lang.String CurrentValue, java.lang.String[] values, java.lang.String[] content) {
		int i = 0;
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		java.lang.String selected = " selected";
		try {
			if (CurrentValue == null) {
				CurrentValue = "";
			}
			sBuf.append("<option value='' selected>--请选择--</option>");
			for (i = 0; i < content.length; i++) {
				sBuf.append("<option value='").append(values[i]).append("'");
				if (CurrentValue.compareTo(values[i]) == 0) {
					sBuf.append(selected);
				}
				sBuf.append(">").append(content[i]).append("</option>");
			}
			return sBuf.toString();
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public java.lang.String ComboListMust(java.lang.String CurrentValue, java.lang.String[] values, java.lang.String[] content) {
		int i = 0;
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		java.lang.String selected = " selected";
		try {
			for (i = 0; i < content.length; i++) {
				sBuf.append("<option value='").append(values[i]).append("'");
				if (CurrentValue.compareTo(values[i]) == 0) {
					sBuf.append(selected);
				}
				sBuf.append(">").append(content[i]).append("</option>");
			}
			return sBuf.toString();
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.sql.Timestamp StrToTimestamp(java.lang.String timestampStr, java.lang.String pattern) throws java.text.ParseException {
		java.util.Date date = null;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(pattern);
		try {
			date = format.parse(timestampStr);
		} catch (java.text.ParseException ex) {
			throw ex;
		}
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

	public static java.lang.String StrToDateTimeFormat(java.lang.String timestampStr, java.lang.String pattern) throws java.text.ParseException {
		java.lang.String s = "";
		try {
			s = java.lang.String.valueOf(com.megagao.production.ssm.util.UtilFuns.StrToTimestamp(timestampStr, pattern));
			s = s.substring(0, pattern.length());
		} catch (java.lang.Exception e) {
		}
		return s;
	}

	public static java.lang.String dateTimeFormat(java.util.Date date, java.lang.String pattern) throws java.text.ParseException {
		java.lang.String s = "";
		try {
			java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			s = dformat.format(date);
			s = java.lang.String.valueOf(com.megagao.production.ssm.util.UtilFuns.StrToTimestamp(s, pattern));
			s = s.substring(0, pattern.length());
		} catch (java.lang.Exception e) {
		}
		return s;
	}

	public static java.lang.String dateTimeFormat(java.util.Date date) throws java.text.ParseException {
		java.lang.String s = "";
		try {
			java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd");
			s = dformat.format(date);
			s = java.lang.String.valueOf(com.megagao.production.ssm.util.UtilFuns.StrToTimestamp(s, "yyyy-MM-dd"));
			s = s.substring(0, "yyyy-MM-dd".length());
		} catch (java.lang.Exception e) {
		}
		return s;
	}

	public static java.lang.String formatDateTimeCN(java.lang.String date) throws java.text.ParseException {
		java.lang.String s = "";
		try {
			if (com.megagao.production.ssm.util.UtilFuns.isEmpty(date)) {
				return "";
			}
			if (date.indexOf(".") > (-1)) {
				date = date.substring(0, date.indexOf("."));
			}
			if (date.length() == 4) {
				s = date + "年";
			} else if (date.length() == 7) {
				s = date.replaceAll("-0", "-").replaceFirst("-", "年") + "月";
			} else if (date.length() == 10) {
				s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月") + "日";
			} else if (date.length() == 2) {
				s = date + "时";
			} else if (date.length() == 5) {
				s = date.replaceAll(":0", ":").replaceFirst(":", "时") + "分";
			} else if (date.length() == 8) {
				s = date.replaceAll(":0", ":").replaceFirst(":", "时").replaceFirst(":", "分") + "秒";
			} else if (date.length() == 13) {
				s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日") + "时";
			} else if (date.length() == 16) {
				s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日").replaceAll(":0", ":").replaceFirst(":", "时") + "分";
			} else if (date.length() == 19) {
				s = date.replaceAll("-0", "-").replaceFirst("-", "年").replaceFirst("-", "月").replaceAll(" 0", " ").replaceFirst(" ", "日").replaceAll(":0", ":").replaceFirst(":", "时").replaceFirst(":", "分") + "秒";
			}
			s = s.replaceAll("0[时分秒]", "");
		} catch (java.lang.Exception e) {
		}
		return s;
	}

	public static java.lang.String formatDateEN(java.lang.String date) throws java.text.ParseException {
		java.lang.String s = "";
		int whichMonth = 1;
		try {
			if (com.megagao.production.ssm.util.UtilFuns.isEmpty(date)) {
				return "";
			}
			java.lang.String[] aString = date.replaceAll("-0", "-").split("-");
			whichMonth = java.lang.Integer.parseInt(aString[1]);
			if (whichMonth == 1) {
				s = "Jan";
			} else if (whichMonth == 2) {
				s = "Feb";
			} else if (whichMonth == 3) {
				s = "Mar";
			} else if (whichMonth == 4) {
				s = "Apr";
			} else if (whichMonth == 5) {
				s = "May";
			} else if (whichMonth == 6) {
				s = "Jun";
			} else if (whichMonth == 7) {
				s = "Jul";
			} else if (whichMonth == 8) {
				s = "Aug";
			} else if (whichMonth == 9) {
				s = "Sept";
			} else if (whichMonth == 10) {
				s = "Oct";
			} else if (whichMonth == 11) {
				s = "Nov";
			} else if (whichMonth == 12) {
				s = "Dec";
			}
			s = (((s + ".") + aString[2]) + ",") + aString[0];
		} catch (java.lang.Exception e) {
		}
		return s;
	}

	public java.lang.String formatShortMonth(java.lang.String strDate) {
		return strDate.substring(0, 7).replaceAll("-0", "-");
	}

	public java.lang.String formatMonth(java.lang.String strDate) {
		return strDate.substring(0, 7);
	}

	public static java.lang.String delLastChar(java.lang.String s) {
		try {
			if (s.length() > 0) {
				s = s.substring(0, s.length() - 1);
			}
		} catch (java.lang.Exception e) {
			return "";
		}
		return s;
	}

	public static java.lang.String delLastChars(java.lang.String s, int len) {
		try {
			if (s.length() > 0) {
				s = s.substring(0, s.length() - len);
			}
		} catch (java.lang.Exception e) {
			return "";
		}
		return s;
	}

	public java.lang.String htmlReplaceAll(java.lang.String s) {
		try {
			java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
			sBuf.append(s.replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\n", "<br\\>"));
			return sBuf.toString();
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String htmlNewline(java.lang.String s) {
		try {
			return s.replaceAll(" ", "&nbsp;").replaceAll("\n", "<br\\>");
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public static java.lang.String getPassString(java.lang.String strvalue, int Flag) {
		try {
			if (strvalue.equals("null") || (strvalue.compareTo("") == 0)) {
				return "";
			} else {
				int intStrvalue = strvalue.length();
				if (intStrvalue > Flag) {
					strvalue = strvalue.substring(0, intStrvalue - Flag);
				}
				for (int i = 0; i < Flag; i++) {
					strvalue = strvalue + "*";
				}
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			return strvalue;
		}
	}

	public static java.lang.String getPassString(java.lang.String strvalue, int Flag, int sFlag, int iPassLen) {
		try {
			if (strvalue.equals("null")) {
				return "";
			} else {
				java.lang.String strvalue1 = "";
				java.lang.String strvalue2 = "";
				int intStrvalue = strvalue.length();
				if (sFlag >= Flag) {
					if (intStrvalue > Flag) {
						strvalue1 = strvalue.substring(0, Flag);
						strvalue2 = strvalue.substring(sFlag, intStrvalue);
					} else {
						strvalue1 = "";
						strvalue2 = "";
					}
					for (int i = 0; i < iPassLen; i++) {
						strvalue1 = strvalue1 + "*";
					}
					strvalue = strvalue1 + strvalue2;
				}
				return strvalue;
			}
		} catch (java.lang.Exception e) {
			return strvalue;
		}
	}

	public static java.lang.String getPatternString(java.lang.String s, int iStartPos, int iEndPos, java.lang.String sPattern, int iPatternLen) {
		try {
			if (iEndPos == 0) {
				iEndPos = s.length();
			}
			java.lang.String sStartStr = "";
			java.lang.String sCenterStr = "";
			java.lang.String sEndStr = "";
			if (s.equals("null")) {
				return "";
			} else {
				int ints = s.length();
				if (ints > iStartPos) {
					sStartStr = s.substring(0, iStartPos);
				} else {
					return s;
				}
				if (ints > iEndPos) {
					sEndStr = s.substring(iEndPos, ints);
				}
				for (int i = 0; i < iPatternLen; i++) {
					sCenterStr = sCenterStr + sPattern;
				}
				return (sStartStr + sCenterStr) + sEndStr;
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println(e);
			return s;
		}
	}

	public static java.lang.String getPatternString(java.lang.String s, int iStartPos, java.lang.String sPattern, int iPatternLen) {
		return com.megagao.production.ssm.util.UtilFuns.getPatternString(s, iStartPos, 0, sPattern, iPatternLen);
	}

	public static java.lang.String getPatternString(java.lang.String s, int iStartPos, java.lang.String sPattern) {
		return com.megagao.production.ssm.util.UtilFuns.getPatternString(s, iStartPos, 0, sPattern, 3);
	}

	public static java.lang.String getQQString(java.lang.String strvalue) {
		try {
			java.lang.String QQ = "";
			if (strvalue.equals("")) {
				return "";
			} else {
				QQ = ((((((("<img src=\"http://wpa.qq.com/pa?p=1:" + strvalue) + ":4\">") + " <SPAN title=\"有事叫我!\" style=\"CURSOR: hand\"") + " onclick=\"window.open(\'http://wpa.qq.com/msgrd?V=1&amp;Uin=") + strvalue) + "&amp;Site=21pan&amp;Menu=yes\')\">") + strvalue) + "</SPAN>";
			}
			strvalue = QQ;
			return strvalue;
		} catch (java.lang.Exception e) {
			return strvalue;
		}
	}

	public java.lang.String getNoExistString(java.lang.String allString, java.lang.String existString) {
		return this.getNoExistString(this.splitStr(allString, ","), existString);
	}

	public java.lang.String getNoExistString(java.lang.String[] allString, java.lang.String existString) {
		existString = existString + ",";
		if ((allString == null) && (allString.length == 0)) {
			return "";
		}
		java.lang.StringBuffer sBuf = new java.lang.StringBuffer();
		for (int i = 0; i < allString.length; i++) {
			if (existString.indexOf(allString[i]) == (-1)) {
				sBuf.append(allString[i]).append(",");
			}
		}
		if (sBuf.length() > 1) {
			sBuf.delete(sBuf.length() - 1, sBuf.length());
		}
		return sBuf.toString();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.System.out.println("finish!");
	}

	public java.lang.String replaceLast(java.lang.String string, java.lang.String toReplace, java.lang.String replacement) {
		int pos = string.lastIndexOf(toReplace);
		if (pos > (-1)) {
			return (string.substring(0, pos) + replacement) + string.substring(pos + toReplace.length(), string.length());
		} else {
			return string;
		}
	}

	public static java.lang.String getROOTPath() {
		com.megagao.production.ssm.util.UtilFuns uf = new com.megagao.production.ssm.util.UtilFuns();
		return uf.getClass().getResource("/").getPath().replace("/WEB-INF/classes/", "/").substring(1);
	}

	public java.lang.String getClassRootPath() {
		return this.getClass().getResource("/").getPath();
	}
}