public class ExampleJRuby_01 {
	public static void main(java.lang.String[] args) {
		javax.script.ScriptEngineManager sem = new javax.script.ScriptEngineManager();
		javax.script.ScriptEngine ruby = sem.getEngineByExtension("rb");
		try {
			ruby.eval("puts 'Hello World!'");
		} catch (javax.script.ScriptException ex) {
			ex.printStackTrace();
		}
	}
}