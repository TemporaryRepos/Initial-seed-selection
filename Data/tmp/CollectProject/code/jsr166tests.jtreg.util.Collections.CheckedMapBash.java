public class CheckedMapBash {
	static java.util.Random rnd = new java.util.Random();

	static java.lang.Object nil = new java.lang.Integer(0);

	public static void main(java.lang.String[] args) {
		int numItr = 100;
		int mapSize = 100;
		for (int i = 0; i < numItr; i++) {
			java.util.Map m = jsr166tests.jtreg.util.Collections.CheckedMapBash.newMap();
			java.lang.Object head = jsr166tests.jtreg.util.Collections.CheckedMapBash.nil;
			for (int j = 0; j < mapSize; j++) {
				java.lang.Object newHead;
				do {
					newHead = new java.lang.Integer(jsr166tests.jtreg.util.Collections.CheckedMapBash.rnd.nextInt());
				} while (m.containsKey(newHead) );
				m.put(newHead, head);
				head = newHead;
			}
			if (m.size() != mapSize) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Size not as expected.");
			}
			{
				java.util.HashMap hm = new java.util.HashMap(m);
				if (!(((hm.hashCode() == m.hashCode()) && (hm.entrySet().hashCode() == m.entrySet().hashCode())) && (hm.keySet().hashCode() == m.keySet().hashCode()))) {
					jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Incorrect hashCode computation.");
				}
				if (!(((((hm.equals(m) && hm.entrySet().equals(m.entrySet())) && hm.keySet().equals(m.keySet())) && m.equals(hm)) && m.entrySet().equals(hm.entrySet())) && m.keySet().equals(hm.keySet()))) {
					jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Incorrect equals computation.");
				}
			}
			java.util.Map m2 = jsr166tests.jtreg.util.Collections.CheckedMapBash.newMap();
			m2.putAll(m);
			m2.values().removeAll(m.keySet());
			if ((m2.size() != 1) || (!m2.containsValue(jsr166tests.jtreg.util.Collections.CheckedMapBash.nil))) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Collection views test failed.");
			}
			int j = 0;
			while (head != jsr166tests.jtreg.util.Collections.CheckedMapBash.nil) {
				if (!m.containsKey(head)) {
					jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Linked list doesn't contain a link.");
				}
				java.lang.Object newHead = m.get(head);
				if (newHead == null) {
					jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Could not retrieve a link.");
				}
				m.remove(head);
				head = newHead;
				j++;
			} 
			if (!m.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Map nonempty after removing all links.");
			}
			if (j != mapSize) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Linked list size not as expected.");
			}
		}
		java.util.Map m = jsr166tests.jtreg.util.Collections.CheckedMapBash.newMap();
		for (int i = 0; i < mapSize; i++) {
			if (m.put(new java.lang.Integer(i), new java.lang.Integer(2 * i)) != null) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("put returns a non-null value erroenously.");
			}
		}
		for (int i = 0; i < (2 * mapSize); i++) {
			if (m.containsValue(new java.lang.Integer(i)) != ((i % 2) == 0)) {
				jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("contains value " + i);
			}
		}
		if (m.put(jsr166tests.jtreg.util.Collections.CheckedMapBash.nil, jsr166tests.jtreg.util.Collections.CheckedMapBash.nil) == null) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("put returns a null value erroenously.");
		}
		java.util.Map m2 = jsr166tests.jtreg.util.Collections.CheckedMapBash.newMap();
		m2.putAll(m);
		if (!m.equals(m2)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Clone not equal to original. (1)");
		}
		if (!m2.equals(m)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Clone not equal to original. (2)");
		}
		java.util.Set s = m.entrySet();
		java.util.Set s2 = m2.entrySet();
		if (!s.equals(s2)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Clone not equal to original. (3)");
		}
		if (!s2.equals(s)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Clone not equal to original. (4)");
		}
		if (!s.containsAll(s2)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Original doesn't contain clone!");
		}
		if (!s2.containsAll(s)) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Clone doesn't contain original!");
		}
		s2.removeAll(s);
		if (!m2.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("entrySet().removeAll failed.");
		}
		m2.putAll(m);
		m2.clear();
		if (!m2.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("clear failed.");
		}
		java.util.Iterator i = m.entrySet().iterator();
		while (i.hasNext()) {
			i.next();
			i.remove();
		} 
		if (!m.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("Iterator.remove() failed");
		}
	}

	static java.util.Map newMap() {
		java.util.Map m = java.util.Collections.checkedMap(new java.util.HashMap(), java.lang.Integer.class, java.lang.Integer.class);
		if (!m.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedMapBash.fail("New instance non empty.");
		}
		return m;
	}

	static void fail(java.lang.String s) {
		throw new java.lang.RuntimeException(s);
	}
}