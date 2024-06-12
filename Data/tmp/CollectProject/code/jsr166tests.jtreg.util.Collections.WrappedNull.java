public class WrappedNull {
	public static void main(java.lang.String[] argv) throws java.lang.Exception {
		boolean testSucceeded = false;
		try {
			java.util.List l = java.util.Arrays.asList(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("Arrays.asList");
		}
		testSucceeded = false;
		try {
			java.util.Collection c = java.util.Collections.unmodifiableCollection(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableCollection");
		}
		testSucceeded = false;
		try {
			java.util.Set c = java.util.Collections.unmodifiableSet(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableSet");
		}
		testSucceeded = false;
		try {
			java.util.List c = java.util.Collections.unmodifiableList(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableList");
		}
		testSucceeded = false;
		try {
			java.util.Map c = java.util.Collections.unmodifiableMap(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableMap");
		}
		testSucceeded = false;
		try {
			java.util.SortedSet c = java.util.Collections.unmodifiableSortedSet(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableSortedSet");
		}
		testSucceeded = false;
		try {
			java.util.SortedMap c = java.util.Collections.unmodifiableSortedMap(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("unmodifiableSortedMap");
		}
		testSucceeded = false;
		try {
			java.util.Collection c = java.util.Collections.synchronizedCollection(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedCollection");
		}
		testSucceeded = false;
		try {
			java.util.Set c = java.util.Collections.synchronizedSet(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedSet");
		}
		testSucceeded = false;
		try {
			java.util.List c = java.util.Collections.synchronizedList(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedList");
		}
		testSucceeded = false;
		try {
			java.util.Map c = java.util.Collections.synchronizedMap(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedMap");
		}
		testSucceeded = false;
		try {
			java.util.SortedSet c = java.util.Collections.synchronizedSortedSet(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedSortedSet");
		}
		testSucceeded = false;
		try {
			java.util.SortedMap c = java.util.Collections.synchronizedSortedMap(null);
		} catch (java.lang.NullPointerException e) {
			testSucceeded = true;
		}
		if (!testSucceeded) {
			throw new java.lang.Exception("synchronizedSortedMap");
		}
		java.util.List l = java.util.Arrays.asList(new java.lang.Object[0]);
		java.util.Collection c = java.util.Collections.unmodifiableCollection(java.util.Collections.EMPTY_SET);
		java.util.Set s = java.util.Collections.unmodifiableSet(java.util.Collections.EMPTY_SET);
		l = java.util.Collections.unmodifiableList(java.util.Collections.EMPTY_LIST);
		java.util.Map m = java.util.Collections.unmodifiableMap(java.util.Collections.EMPTY_MAP);
		java.util.SortedSet ss = java.util.Collections.unmodifiableSortedSet(new java.util.TreeSet());
		java.util.SortedMap sm = java.util.Collections.unmodifiableSortedMap(new java.util.TreeMap());
		c = java.util.Collections.synchronizedCollection(java.util.Collections.EMPTY_SET);
		s = java.util.Collections.synchronizedSet(java.util.Collections.EMPTY_SET);
		l = java.util.Collections.synchronizedList(java.util.Collections.EMPTY_LIST);
		m = java.util.Collections.synchronizedMap(java.util.Collections.EMPTY_MAP);
		ss = java.util.Collections.synchronizedSortedSet(new java.util.TreeSet());
		sm = java.util.Collections.synchronizedSortedMap(new java.util.TreeMap());
	}
}