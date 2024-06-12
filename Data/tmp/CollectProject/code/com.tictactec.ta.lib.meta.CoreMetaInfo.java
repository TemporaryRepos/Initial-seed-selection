public class CoreMetaInfo {
	static final java.lang.Class coreClass = com.tictactec.ta.lib.Core.class;

	static final java.lang.String LOOKBACK_SUFFIX = "_Lookback";

	static final java.lang.String INT_PREFIX = "INT_";

	java.util.Map<com.tictactec.ta.lib.meta.TaFuncSignature, com.tictactec.ta.lib.meta.TaFuncMetaInfo> taFuncMap;

	public CoreMetaInfo() {
		this.taFuncMap = getTaFuncMetaInfoMap();
	}

	protected java.util.Map<java.lang.String, java.lang.reflect.Method> getLookbackMethodMap() {
		java.util.Map<java.lang.String, java.lang.reflect.Method> map = new java.util.HashMap<java.lang.String, java.lang.reflect.Method>();
		java.lang.reflect.Method[] ms = com.tictactec.ta.lib.meta.CoreMetaInfo.coreClass.getDeclaredMethods();
		for (java.lang.reflect.Method m : ms) {
			if (m.getName().endsWith(com.tictactec.ta.lib.meta.CoreMetaInfo.LOOKBACK_SUFFIX)) {
				map.put(m.getName(), m);
			}
		}
		return map;
	}

	@java.lang.SuppressWarnings("unchecked")
	protected java.util.Map<com.tictactec.ta.lib.meta.TaFuncSignature, com.tictactec.ta.lib.meta.TaFuncMetaInfo> getTaFuncMetaInfoMap() {
		java.util.Map<com.tictactec.ta.lib.meta.TaFuncSignature, com.tictactec.ta.lib.meta.TaFuncMetaInfo> result = new java.util.TreeMap<com.tictactec.ta.lib.meta.TaFuncSignature, com.tictactec.ta.lib.meta.TaFuncMetaInfo>();
		java.lang.reflect.Method[] ms = com.tictactec.ta.lib.meta.CoreMetaInfo.coreClass.getDeclaredMethods();
		java.util.Map<java.lang.String, java.lang.reflect.Method> lookbackMap = getLookbackMethodMap();
		for (java.lang.reflect.Method taMethod : ms) {
			java.lang.String fn = taMethod.getName();
			if (taMethod.getReturnType().equals(com.tictactec.ta.lib.RetCode.class) && (!fn.startsWith(com.tictactec.ta.lib.meta.CoreMetaInfo.INT_PREFIX))) {
				java.lang.String lookbackName = fn + com.tictactec.ta.lib.meta.CoreMetaInfo.LOOKBACK_SUFFIX;
				java.lang.reflect.Method lookbackMethod = lookbackMap.get(lookbackName);
				if (lookbackMethod != null) {
					com.tictactec.ta.lib.meta.TaFuncMetaInfo mi = new com.tictactec.ta.lib.meta.TaFuncMetaInfo(fn, taMethod, lookbackMethod);
					result.put(mi, mi);
				}
			}
		}
		return result;
	}

	public java.util.Collection<com.tictactec.ta.lib.meta.TaFuncMetaInfo> getAllFuncs() {
		return taFuncMap.values();
	}

	public com.tictactec.ta.lib.meta.TaFuncMetaInfo get(java.lang.String taName, java.lang.Class[] inVarTypes) {
		return taFuncMap.get(new com.tictactec.ta.lib.meta.TaFuncSignature(taName, inVarTypes));
	}

	public void forEach(com.tictactec.ta.lib.meta.TaFuncClosure closure) throws java.lang.Exception {
		for (com.tictactec.ta.lib.meta.TaFuncMetaInfo mi : getAllFuncs()) {
			closure.execute(mi);
		}
	}

	public static void main(java.lang.String[] args) {
		com.tictactec.ta.lib.meta.CoreMetaInfo mi = new com.tictactec.ta.lib.meta.CoreMetaInfo();
		java.util.Collection<com.tictactec.ta.lib.meta.TaFuncMetaInfo> fs = mi.getAllFuncs();
		int i = 0;
		for (com.tictactec.ta.lib.meta.TaFuncMetaInfo f : fs) {
			java.lang.System.out.println(((" " + (i++)) + " ") + f);
		}
	}
}