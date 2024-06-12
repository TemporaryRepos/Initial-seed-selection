public class TestMethodNames {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javax.script.ScriptEngineManager m = new javax.script.ScriptEngineManager();
		javax.script.ScriptEngine e = m.getEngineByName("nashorn");
		e.eval("({get \"\u0000\"(){}})[\"\u0000\"]");
		e.eval("({get \"\\x80\"(){}})[\"\\x80\"]");
		e.eval("({get \"\\xff\"(){}})[\"\\xff\"]");
	}
}