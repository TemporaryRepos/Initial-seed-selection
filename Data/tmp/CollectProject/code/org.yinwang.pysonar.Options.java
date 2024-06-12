public class Options {
	private java.util.Map<java.lang.String, java.lang.Object> optionsMap = new java.util.LinkedHashMap<>();

	private java.util.List<java.lang.String> args = new java.util.ArrayList<>();

	public Options(java.lang.String[] args) {
		for (int i = 0; i < args.length; i++) {
			java.lang.String key = args[i];
			if (key.startsWith("--")) {
				if ((i + 1) >= args.length) {
					org.yinwang.pysonar.$.die("option needs a value: " + key);
				} else {
					key = key.substring(2);
					java.lang.String value = args[i + 1];
					if (!value.startsWith("-")) {
						optionsMap.put(key, value);
						i++;
					}
				}
			} else if (key.startsWith("-")) {
				key = key.substring(1);
				optionsMap.put(key, true);
			} else {
				this.args.add(key);
			}
		}
	}

	public java.lang.Object get(java.lang.String key) {
		return optionsMap.get(key);
	}

	public boolean hasOption(java.lang.String key) {
		java.lang.Object v = optionsMap.get(key);
		if (v instanceof java.lang.Boolean) {
			return ((boolean) (v));
		} else {
			return false;
		}
	}

	public void put(java.lang.String key, java.lang.Object value) {
		optionsMap.put(key, value);
	}

	public java.util.List<java.lang.String> getArgs() {
		return args;
	}

	public java.util.Map<java.lang.String, java.lang.Object> getOptionsMap() {
		return optionsMap;
	}

	public static void main(java.lang.String[] args) {
		org.yinwang.pysonar.Options options = new org.yinwang.pysonar.Options(args);
		for (java.lang.String key : options.optionsMap.keySet()) {
			java.lang.System.out.println((key + " = ") + options.get(key));
		}
	}
}