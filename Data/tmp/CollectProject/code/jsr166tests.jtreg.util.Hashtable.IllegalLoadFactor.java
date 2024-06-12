public class IllegalLoadFactor {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		boolean testSucceeded = false;
		try {
			java.util.Hashtable bad1 = new java.util.Hashtable(100, -3);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("Hashtable, negative load factor");
		}
		testSucceeded = false;
		try {
			java.util.Hashtable bad1 = new java.util.Hashtable(100, java.lang.Float.NaN);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("Hashtable, NaN load factor");
		}
		testSucceeded = false;
		try {
			java.util.HashMap bad1 = new java.util.HashMap(100, -3);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("HashMap, negative load factor");
		}
		testSucceeded = false;
		try {
			java.util.HashMap bad1 = new java.util.HashMap(100, java.lang.Float.NaN);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("HashMap, NaN load factor");
		}
		testSucceeded = false;
		try {
			java.util.HashSet bad1 = new java.util.HashSet(100, -3);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("HashSet, negative load factor");
		}
		testSucceeded = false;
		try {
			java.util.HashSet bad1 = new java.util.HashSet(100, java.lang.Float.NaN);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("HashSet, NaN load factor");
		}
		testSucceeded = false;
		try {
			java.util.WeakHashMap bad1 = new java.util.WeakHashMap(100, -3);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("WeakHashMap, negative load factor");
		}
		testSucceeded = false;
		try {
			java.util.WeakHashMap bad1 = new java.util.WeakHashMap(100, java.lang.Float.NaN);
		} catch (java.lang.IllegalArgumentException e1) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("WeakHashMap, NaN load factor");
		}
		java.util.Map goodMap = new java.util.Hashtable(100, 0.69F);
		goodMap = new java.util.HashMap(100, 0.69F);
		java.util.Set goodSet = new java.util.HashSet(100, 0.69F);
		goodMap = new java.util.WeakHashMap(100, 0.69F);
	}
}