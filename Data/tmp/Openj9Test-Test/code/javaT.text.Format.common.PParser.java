public class PParser {
	protected static final int OPEN_PAIR = 1;

	protected static final int CLOSE_PAIR = 2;

	protected static final int OPEN_ARRAY = 3;

	protected static final int CLOSE_ARRAY = 4;

	protected static final int MORE = 5;

	protected static final int EQUAL = 6;

	protected static final int STRING = 7;

	protected static final int WS = 8;

	protected java.io.Reader reader;

	protected boolean bufferedToken;

	protected java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();

	protected int lastChar;

	protected int lastToken;

	protected int lineNumber;

	protected int column;

	public PParser() {
	}

	public java.util.Hashtable parse(java.io.Reader r) throws java.io.IOException {
		this.reader = r;
		bufferedToken = false;
		lineNumber = 0;
		column = 0;
		if (getToken() != javaT.text.Format.common.PParser.OPEN_PAIR) {
			error("No initial open");
		}
		return parsePair();
	}

	protected java.lang.Object parseValue(int lookAhead) throws java.io.IOException {
		int token;
		if (lookAhead == (-1)) {
			token = getToken();
		} else {
			token = lookAhead;
		}
		switch (token) {
			case javaT.text.Format.common.PParser.STRING :
				return stringBuffer.toString();
			case javaT.text.Format.common.PParser.OPEN_ARRAY :
				return parseArray();
			case javaT.text.Format.common.PParser.OPEN_PAIR :
				return parsePair();
			default :
				error("Expecting value");
		}
		return null;
	}

	protected java.lang.Object parseArray() throws java.io.IOException {
		java.util.Vector array = new java.util.Vector();
		int token;
		while ((token = getToken()) != javaT.text.Format.common.PParser.CLOSE_ARRAY) {
			if (token == javaT.text.Format.common.PParser.MORE) {
				token = getToken();
			}
			if (token != javaT.text.Format.common.PParser.CLOSE_ARRAY) {
				array.addElement(parseValue(token));
			}
		} 
		return array;
	}

	protected java.util.Hashtable parsePair() throws java.io.IOException {
		java.util.Hashtable ht = new java.util.Hashtable(11);
		int token;
		while ((token = getToken()) != javaT.text.Format.common.PParser.CLOSE_PAIR) {
			if (token != javaT.text.Format.common.PParser.STRING) {
				error("Pair expecting string got");
			}
			java.lang.String key = stringBuffer.toString();
			if (getToken() != javaT.text.Format.common.PParser.EQUAL) {
				error("Expecting = ");
			}
			java.lang.Object value = parseValue(-1);
			ht.put(key, value);
		} 
		return ht;
	}

	protected void ungetToken() {
		if (bufferedToken) {
			error("Can not buffer more than one token");
		}
		bufferedToken = true;
	}

	protected int getToken() throws java.io.IOException {
		int token = getToken(false, false);
		return token;
	}

	protected int getToken(boolean wantsWS, boolean inString) throws java.io.IOException {
		if (bufferedToken) {
			bufferedToken = false;
			if ((lastToken != javaT.text.Format.common.PParser.WS) || wantsWS) {
				return lastToken;
			}
		}
		while ((lastChar = reader.read()) != (-1)) {
			if ((column == 0) && (lastChar == '#')) {
				while (((lastChar = reader.read()) != (-1)) && (lastChar != '\n')) {
				} 
				if (lastChar == (-1)) {
					break;
				}
			}
			column++;
			switch (lastChar) {
				case '\n' :
					lineNumber++;
					column = 0;
				case ' ' :
				case '\r' :
				case '\t' :
					if (wantsWS) {
						lastToken = javaT.text.Format.common.PParser.WS;
						return javaT.text.Format.common.PParser.WS;
					}
					break;
				case ',' :
					lastToken = javaT.text.Format.common.PParser.MORE;
					return javaT.text.Format.common.PParser.MORE;
				case '(' :
					lastToken = javaT.text.Format.common.PParser.OPEN_ARRAY;
					return javaT.text.Format.common.PParser.OPEN_ARRAY;
				case ')' :
					lastToken = javaT.text.Format.common.PParser.CLOSE_ARRAY;
					return javaT.text.Format.common.PParser.CLOSE_ARRAY;
				case '{' :
					lastToken = javaT.text.Format.common.PParser.OPEN_PAIR;
					return javaT.text.Format.common.PParser.OPEN_PAIR;
				case '}' :
					lastToken = javaT.text.Format.common.PParser.CLOSE_PAIR;
					return javaT.text.Format.common.PParser.CLOSE_PAIR;
				case '=' :
					lastToken = javaT.text.Format.common.PParser.EQUAL;
					return javaT.text.Format.common.PParser.EQUAL;
				case '"' :
					lastToken = javaT.text.Format.common.PParser.STRING;
					if (!inString) {
						stringBuffer.setLength(0);
						while (true) {
							getToken(true, true);
							if (lastChar == '"') {
								lastToken = javaT.text.Format.common.PParser.STRING;
								return javaT.text.Format.common.PParser.STRING;
							}
							stringBuffer.append(((char) (lastChar)));
						} 
					}
					return javaT.text.Format.common.PParser.STRING;
				default :
					lastToken = javaT.text.Format.common.PParser.STRING;
					if (!inString) {
						stringBuffer.setLength(0);
						stringBuffer.append(((char) (lastChar)));
						while (getToken(true, true) == javaT.text.Format.common.PParser.STRING) {
							if (lastChar == '"') {
								error("Unexpected quote");
							}
							stringBuffer.append(((char) (lastChar)));
						} 
						ungetToken();
					}
					return javaT.text.Format.common.PParser.STRING;
			}
		} 
		return -1;
	}

	protected void error(java.lang.String errorString) {
		throw new java.lang.RuntimeException((((errorString + " at line ") + lineNumber) + " column ") + column);
	}

	public static void dump(java.lang.Object o) {
		if (o instanceof java.lang.String) {
			java.lang.System.out.print(o);
		} else if (o instanceof java.util.Vector) {
			java.util.Enumeration e = ((java.util.Vector) (o)).elements();
			javaT.text.Format.common.PParser.dump(" (");
			while (e.hasMoreElements()) {
				javaT.text.Format.common.PParser.dump(e.nextElement());
				javaT.text.Format.common.PParser.dump(" -- ");
			} 
			javaT.text.Format.common.PParser.dump(" )");
		} else {
			java.util.Hashtable ht = ((java.util.Hashtable) (o));
			java.util.Enumeration e = ht.keys();
			javaT.text.Format.common.PParser.dump(" {");
			while (e.hasMoreElements()) {
				java.lang.Object key = e.nextElement();
				javaT.text.Format.common.PParser.dump(key);
				javaT.text.Format.common.PParser.dump(" = ");
				javaT.text.Format.common.PParser.dump(ht.get(key));
				javaT.text.Format.common.PParser.dump(";");
			} 
			javaT.text.Format.common.PParser.dump(" }");
		}
	}

	public static void main(java.lang.String[] args) {
		if (args.length == 0) {
			java.lang.System.out.println("need filename");
		} else {
			try {
				java.io.FileReader fr = new java.io.FileReader(args[0]);
				javaT.text.Format.common.PParser parser = new javaT.text.Format.common.PParser();
				java.util.Hashtable ht = parser.parse(fr);
				javaT.text.Format.common.PParser.dump(ht);
				java.lang.System.out.println();
			} catch (java.io.IOException ioe) {
				java.lang.System.out.println("Couldn't parse: " + ioe);
			}
		}
	}
}