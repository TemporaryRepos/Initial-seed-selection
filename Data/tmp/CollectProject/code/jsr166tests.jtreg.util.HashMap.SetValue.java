public class SetValue {
	static final java.lang.String key = "key";

	static final java.lang.String oldValue = "old";

	static final java.lang.String newValue = "new";

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map m = new java.util.HashMap();
		m.put(jsr166tests.jtreg.util.HashMap.SetValue.key, jsr166tests.jtreg.util.HashMap.SetValue.oldValue);
		java.util.Map.Entry e = ((java.util.Map.Entry) (m.entrySet().iterator().next()));
		java.lang.Object returnVal = e.setValue(jsr166tests.jtreg.util.HashMap.SetValue.newValue);
		if (!returnVal.equals(jsr166tests.jtreg.util.HashMap.SetValue.oldValue)) {
			throw new java.lang.RuntimeException("Return value: " + returnVal);
		}
	}
}