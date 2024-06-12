public class Basic {
	static java.util.Random rnd = new java.util.Random(666);

	static java.lang.Object nil = new java.lang.Integer(0);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int numItr = 500;
		int mapSize = 500;
		for (int i = 0; i < numItr; i++) {
			java.util.Map m = new java.util.LinkedHashMap();
			java.lang.Object head = jsr166tests.jtreg.util.LinkedHashMap.Basic.nil;
			for (int j = 0; j < mapSize; j++) {
				java.lang.Object newHead;
				do {
					newHead = new java.lang.Integer(jsr166tests.jtreg.util.LinkedHashMap.Basic.rnd.nextInt());
				} while (m.containsKey(newHead) );
				m.put(newHead, head);
				head = newHead;
			}
			if (m.size() != mapSize) {
				throw new java.lang.Exception("Size not as expected.");
			}
			if (new java.util.HashMap(m).hashCode() != m.hashCode()) {
				throw new java.lang.Exception("Incorrect hashCode computation.");
			}
			java.util.Map m2 = new java.util.LinkedHashMap();
			m2.putAll(m);
			m2.values().removeAll(m.keySet());
			if ((m2.size() != 1) || (!m2.containsValue(jsr166tests.jtreg.util.LinkedHashMap.Basic.nil))) {
				throw new java.lang.Exception("Collection views test failed.");
			}
			int j = 0;
			while (head != jsr166tests.jtreg.util.LinkedHashMap.Basic.nil) {
				if (!m.containsKey(head)) {
					throw new java.lang.Exception("Linked list doesn't contain a link.");
				}
				java.lang.Object newHead = m.get(head);
				if (newHead == null) {
					throw new java.lang.Exception("Could not retrieve a link.");
				}
				m.remove(head);
				head = newHead;
				j++;
			} 
			if (!m.isEmpty()) {
				throw new java.lang.Exception("Map nonempty after removing all links.");
			}
			if (j != mapSize) {
				throw new java.lang.Exception("Linked list size not as expected.");
			}
		}
		java.util.Map m = new java.util.LinkedHashMap();
		for (int i = 0; i < mapSize; i++) {
			if (m.put(new java.lang.Integer(i), new java.lang.Integer(2 * i)) != null) {
				throw new java.lang.Exception("put returns non-null value erroenously.");
			}
		}
		for (int i = 0; i < (2 * mapSize); i++) {
			if (m.containsValue(new java.lang.Integer(i)) != ((i % 2) == 0)) {
				throw new java.lang.Exception("contains value " + i);
			}
		}
		if (m.put(jsr166tests.jtreg.util.LinkedHashMap.Basic.nil, jsr166tests.jtreg.util.LinkedHashMap.Basic.nil) == null) {
			throw new java.lang.Exception("put returns a null value erroenously.");
		}
		java.util.Map m2 = new java.util.LinkedHashMap();
		m2.putAll(m);
		if (!m.equals(m2)) {
			throw new java.lang.Exception("Clone not equal to original. (1)");
		}
		if (!m2.equals(m)) {
			throw new java.lang.Exception("Clone not equal to original. (2)");
		}
		java.util.Set s = m.entrySet();
		java.util.Set s2 = m2.entrySet();
		if (!s.equals(s2)) {
			throw new java.lang.Exception("Clone not equal to original. (3)");
		}
		if (!s2.equals(s)) {
			throw new java.lang.Exception("Clone not equal to original. (4)");
		}
		if (!s.containsAll(s2)) {
			throw new java.lang.Exception("Original doesn't contain clone!");
		}
		if (!s2.containsAll(s)) {
			throw new java.lang.Exception("Clone doesn't contain original!");
		}
		m2 = jsr166tests.jtreg.util.LinkedHashMap.Basic.serClone(m);
		if (!m.equals(m2)) {
			throw new java.lang.Exception("Serialize Clone not equal to original. (1)");
		}
		if (!m2.equals(m)) {
			throw new java.lang.Exception("Serialize Clone not equal to original. (2)");
		}
		s = m.entrySet();
		s2 = m2.entrySet();
		if (!s.equals(s2)) {
			throw new java.lang.Exception("Serialize Clone not equal to original. (3)");
		}
		if (!s2.equals(s)) {
			throw new java.lang.Exception("Serialize Clone not equal to original. (4)");
		}
		if (!s.containsAll(s2)) {
			throw new java.lang.Exception("Original doesn't contain Serialize clone!");
		}
		if (!s2.containsAll(s)) {
			throw new java.lang.Exception("Serialize Clone doesn't contain original!");
		}
		s2.removeAll(s);
		if (!m2.isEmpty()) {
			throw new java.lang.Exception("entrySet().removeAll failed.");
		}
		m2.putAll(m);
		m2.clear();
		if (!m2.isEmpty()) {
			throw new java.lang.Exception("clear failed.");
		}
		java.util.Iterator it = m.entrySet().iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		} 
		if (!m.isEmpty()) {
			throw new java.lang.Exception("Iterator.remove() failed");
		}
		m = new java.util.LinkedHashMap();
		java.util.List l = new java.util.ArrayList(mapSize);
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = new java.lang.Integer(i);
			m.put(x, x);
			l.add(x);
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l)) {
			throw new java.lang.Exception("Insertion order not preserved.");
		}
		for (int i = mapSize - 1; i >= 0; i--) {
			java.lang.Integer x = ((java.lang.Integer) (l.get(i)));
			if (!m.get(x).equals(x)) {
				throw new java.lang.Exception((((("Wrong value: " + i) + ", ") + m.get(x)) + ", ") + x);
			}
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l)) {
			throw new java.lang.Exception("Insertion order not preserved after read.");
		}
		for (int i = mapSize - 1; i >= 0; i--) {
			java.lang.Integer x = ((java.lang.Integer) (l.get(i)));
			m.put(x, x);
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l)) {
			throw new java.lang.Exception("Insert order not preserved after reinsert.");
		}
		m2 = ((java.util.Map) (((java.util.LinkedHashMap) (m)).clone()));
		if (!m.equals(m2)) {
			throw new java.lang.Exception("Insert-order Map != clone.");
		}
		java.util.List l2 = new java.util.ArrayList(l);
		java.util.Collections.shuffle(l2);
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = ((java.lang.Integer) (l2.get(i)));
			if (!m2.get(x).equals(x)) {
				throw new java.lang.Exception((((("Clone: Wrong val: " + i) + ", ") + m.get(x)) + ", ") + x);
			}
		}
		if (!new java.util.ArrayList(m2.keySet()).equals(l)) {
			throw new java.lang.Exception("Clone: altered by read.");
		}
		m = new java.util.LinkedHashMap(1000, 0.75F, true);
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = new java.lang.Integer(i);
			m.put(x, x);
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l)) {
			throw new java.lang.Exception("Insertion order not properly preserved.");
		}
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = ((java.lang.Integer) (l2.get(i)));
			if (!m.get(x).equals(x)) {
				throw new java.lang.Exception((((("Wrong value: " + i) + ", ") + m.get(x)) + ", ") + x);
			}
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l2)) {
			throw new java.lang.Exception("Insert order not properly altered by read.");
		}
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = new java.lang.Integer(i);
			m.put(x, x);
		}
		if (!new java.util.ArrayList(m.keySet()).equals(l)) {
			throw new java.lang.Exception("Insertion order not altered by reinsert.");
		}
		m2 = ((java.util.Map) (((java.util.LinkedHashMap) (m)).clone()));
		if (!m.equals(m2)) {
			throw new java.lang.Exception("Access-order Map != clone.");
		}
		for (int i = 0; i < mapSize; i++) {
			java.lang.Integer x = ((java.lang.Integer) (l.get(i)));
			if (!m2.get(x).equals(x)) {
				throw new java.lang.Exception((((("Clone: Wrong val: " + i) + ", ") + m.get(x)) + ", ") + x);
			}
		}
		if (!new java.util.ArrayList(m2.keySet()).equals(l)) {
			throw new java.lang.Exception("Clone: order not properly altered by read.");
		}
		java.lang.System.err.println("Success.");
	}

	private static java.util.Map serClone(java.util.Map m) {
		java.util.Map result = null;
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			out.writeObject(m);
			out.flush();
			java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(bos.toByteArray());
			out.close();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(bis);
			result = ((java.util.Map) (in.readObject()));
			in.close();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}