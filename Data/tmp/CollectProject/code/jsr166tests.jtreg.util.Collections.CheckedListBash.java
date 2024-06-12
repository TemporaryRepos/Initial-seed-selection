public class CheckedListBash {
	static java.util.Random rnd = new java.util.Random();

	public static void main(java.lang.String[] args) {
		int numItr = 100;
		int listSize = 100;
		for (int i = 0; i < numItr; i++) {
			java.util.List s1 = jsr166tests.jtreg.util.Collections.CheckedListBash.newList();
			jsr166tests.jtreg.util.Collections.CheckedListBash.AddRandoms(s1, listSize);
			java.util.List s2 = jsr166tests.jtreg.util.Collections.CheckedListBash.newList();
			jsr166tests.jtreg.util.Collections.CheckedListBash.AddRandoms(s2, listSize);
			java.util.List intersection = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s1);
			intersection.retainAll(s2);
			java.util.List diff1 = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s1);
			diff1.removeAll(s2);
			java.util.List diff2 = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s2);
			diff2.removeAll(s1);
			java.util.List union = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s1);
			union.addAll(s2);
			if (diff1.removeAll(diff2)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 2 failed");
			}
			if (diff1.removeAll(intersection)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 3 failed");
			}
			if (diff2.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 4 failed");
			}
			if (diff2.removeAll(intersection)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 5 failed");
			}
			if (intersection.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 6 failed");
			}
			if (intersection.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 7 failed");
			}
			intersection.addAll(diff1);
			intersection.addAll(diff2);
			if (!(intersection.containsAll(union) && union.containsAll(intersection))) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List algebra identity 1 failed");
			}
			java.util.Iterator e = union.iterator();
			while (e.hasNext()) {
				intersection.remove(e.next());
			} 
			if (!intersection.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Copy nonempty after deleting all elements.");
			}
			e = union.iterator();
			while (e.hasNext()) {
				java.lang.Object o = e.next();
				if (!union.contains(o)) {
					jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List doesn't contain one of its elements.");
				}
				e.remove();
			} 
			if (!union.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List nonempty after deleting all elements.");
			}
			s1.clear();
			if (s1.size() != 0) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Clear didn't reduce size to zero.");
			}
			s1.addAll(0, s2);
			if (!(s1.equals(s2) && s2.equals(s1))) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("addAll(int, Collection) doesn't work.");
			}
			for (int j = 0, n = s1.size(); j < n; j++) {
				s1.set(j, s1.set((n - j) - 1, s1.get(j)));
			}
			for (int j = 0, n = s1.size(); j < n; j++) {
				s1.set(j, s1.set((n - j) - 1, s1.get(j)));
			}
			if (!(s1.equals(s2) && s2.equals(s1))) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("set(int, Object) doesn't work");
			}
		}
		java.util.List s = jsr166tests.jtreg.util.Collections.CheckedListBash.newList();
		for (int i = 0; i < listSize; i++) {
			s.add(new java.lang.Integer(i));
		}
		if (s.size() != listSize) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Size of [0..n-1] != n");
		}
		java.util.List even = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s);
		java.util.Iterator it = even.iterator();
		while (it.hasNext()) {
			if ((((java.lang.Integer) (it.next())).intValue() % 2) == 1) {
				it.remove();
			}
		} 
		it = even.iterator();
		while (it.hasNext()) {
			if ((((java.lang.Integer) (it.next())).intValue() % 2) == 1) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Failed to remove all odd nubmers.");
			}
		} 
		java.util.List odd = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(s);
		for (int i = 0; i < (listSize / 2); i++) {
			odd.remove(i);
		}
		for (int i = 0; i < (listSize / 2); i++) {
			if ((((java.lang.Integer) (odd.get(i))).intValue() % 2) != 1) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Failed to remove all even nubmers.");
			}
		}
		java.util.List all = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(odd);
		for (int i = 0; i < (listSize / 2); i++) {
			all.add(2 * i, even.get(i));
		}
		if (!all.equals(s)) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Failed to reconstruct ints from odds and evens.");
		}
		all = jsr166tests.jtreg.util.Collections.CheckedListBash.clone(odd);
		java.util.ListIterator itAll = all.listIterator(all.size());
		java.util.ListIterator itEven = even.listIterator(even.size());
		while (itEven.hasPrevious()) {
			itAll.previous();
			itAll.add(itEven.previous());
			itAll.previous();
		} 
		itAll = all.listIterator();
		while (itAll.hasNext()) {
			java.lang.Integer i = ((java.lang.Integer) (itAll.next()));
			itAll.set(new java.lang.Integer(i.intValue()));
		} 
		itAll = all.listIterator();
		it = s.iterator();
		while (it.hasNext()) {
			if (it.next() == itAll.next()) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Iterator.set failed to change value.");
			}
		} 
		if (!all.equals(s)) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Failed to reconstruct ints with ListIterator.");
		}
		it = all.listIterator();
		int i = 0;
		while (it.hasNext()) {
			java.lang.Object o = it.next();
			if (all.indexOf(o) != all.lastIndexOf(o)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Apparent duplicate detected.");
			}
			if ((all.subList(i, all.size()).indexOf(o) != 0) || (all.subList(i + 1, all.size()).indexOf(o) != (-1))) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("subList/indexOf is screwy.");
			}
			if (all.subList(0, i + 1).lastIndexOf(o) != i) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("subList/lastIndexOf is screwy.");
			}
			i++;
		} 
		java.util.List l = jsr166tests.jtreg.util.Collections.CheckedListBash.newList();
		jsr166tests.jtreg.util.Collections.CheckedListBash.AddRandoms(l, listSize);
		java.lang.Integer[] ia = ((java.lang.Integer[]) (l.toArray(new java.lang.Integer[0])));
		if (!l.equals(java.util.Arrays.asList(ia))) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("toArray(Object[]) is hosed (1)");
		}
		ia = new java.lang.Integer[listSize];
		java.lang.Integer[] ib = ((java.lang.Integer[]) (l.toArray(ia)));
		if ((ia != ib) || (!l.equals(java.util.Arrays.asList(ia)))) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("toArray(Object[]) is hosed (2)");
		}
		ia = new java.lang.Integer[listSize + 1];
		ia[listSize] = new java.lang.Integer(69);
		ib = ((java.lang.Integer[]) (l.toArray(ia)));
		if (((ia != ib) || (ia[listSize] != null)) || (!l.equals(java.util.Arrays.asList(ia).subList(0, listSize)))) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("toArray(Object[]) is hosed (3)");
		}
	}

	static java.util.List clone(java.util.List s) {
		java.util.List a = java.util.Arrays.asList(s.toArray());
		if (s.hashCode() != a.hashCode()) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Incorrect hashCode computation.");
		}
		java.util.List clone = jsr166tests.jtreg.util.Collections.CheckedListBash.newList();
		clone.addAll(a);
		if (!s.equals(clone)) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List not equal to copy.");
		}
		if (!s.containsAll(clone)) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("List does not contain copy.");
		}
		if (!clone.containsAll(s)) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Copy does not contain list.");
		}
		return clone;
	}

	static java.util.List newList() {
		java.util.List s = java.util.Collections.checkedList(new java.util.ArrayList(), java.lang.Integer.class);
		if (!s.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedListBash.fail("New instance non empty.");
		}
		return s;
	}

	static void AddRandoms(java.util.List s, int n) {
		for (int i = 0; i < n; i++) {
			int r = jsr166tests.jtreg.util.Collections.CheckedListBash.rnd.nextInt() % n;
			java.lang.Integer e = new java.lang.Integer(r < 0 ? -r : r);
			int preSize = s.size();
			if (!s.add(e)) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Add failed.");
			}
			int postSize = s.size();
			if ((postSize - preSize) != 1) {
				jsr166tests.jtreg.util.Collections.CheckedListBash.fail("Add didn't increase size by 1.");
			}
		}
	}

	static void fail(java.lang.String s) {
		throw new java.lang.RuntimeException(s);
	}
}