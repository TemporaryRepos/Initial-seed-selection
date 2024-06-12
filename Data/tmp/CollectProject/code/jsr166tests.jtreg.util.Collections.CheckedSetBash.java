public class CheckedSetBash {
	static java.util.Random rnd = new java.util.Random();

	public static void main(java.lang.String[] args) {
		int numItr = 100;
		int setSize = 100;
		for (int i = 0; i < numItr; i++) {
			java.util.Set s1 = jsr166tests.jtreg.util.Collections.CheckedSetBash.newSet();
			jsr166tests.jtreg.util.Collections.CheckedSetBash.AddRandoms(s1, setSize);
			java.util.Set s2 = jsr166tests.jtreg.util.Collections.CheckedSetBash.newSet();
			jsr166tests.jtreg.util.Collections.CheckedSetBash.AddRandoms(s2, setSize);
			java.util.Set intersection = jsr166tests.jtreg.util.Collections.CheckedSetBash.clone(s1);
			intersection.retainAll(s2);
			java.util.Set diff1 = jsr166tests.jtreg.util.Collections.CheckedSetBash.clone(s1);
			diff1.removeAll(s2);
			java.util.Set diff2 = jsr166tests.jtreg.util.Collections.CheckedSetBash.clone(s2);
			diff2.removeAll(s1);
			java.util.Set union = jsr166tests.jtreg.util.Collections.CheckedSetBash.clone(s1);
			union.addAll(s2);
			if (diff1.removeAll(diff2)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 2 failed");
			}
			if (diff1.removeAll(intersection)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 3 failed");
			}
			if (diff2.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 4 failed");
			}
			if (diff2.removeAll(intersection)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 5 failed");
			}
			if (intersection.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 6 failed");
			}
			if (intersection.removeAll(diff1)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 7 failed");
			}
			intersection.addAll(diff1);
			intersection.addAll(diff2);
			if (!intersection.equals(union)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set algebra identity 1 failed");
			}
			if (new java.util.HashSet(union).hashCode() != union.hashCode()) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Incorrect hashCode computation.");
			}
			java.util.Iterator e = union.iterator();
			while (e.hasNext()) {
				if (!intersection.remove(e.next())) {
					jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Couldn't remove element from copy.");
				}
			} 
			if (!intersection.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Copy nonempty after deleting all elements.");
			}
			e = union.iterator();
			while (e.hasNext()) {
				java.lang.Object o = e.next();
				if (!union.contains(o)) {
					jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set doesn't contain one of its elements.");
				}
				e.remove();
				if (union.contains(o)) {
					jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set contains element after deletion.");
				}
			} 
			if (!union.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set nonempty after deleting all elements.");
			}
			s1.clear();
			if (!s1.isEmpty()) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set nonempty after clear.");
			}
		}
	}

	static java.util.Set clone(java.util.Set s) {
		java.util.Set clone = jsr166tests.jtreg.util.Collections.CheckedSetBash.newSet();
		java.util.List arrayList = java.util.Arrays.asList(s.toArray());
		clone.addAll(arrayList);
		if (!s.equals(clone)) {
			jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set not equal to copy.");
		}
		if (!s.containsAll(clone)) {
			jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Set does not contain copy.");
		}
		if (!clone.containsAll(s)) {
			jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Copy does not contain set.");
		}
		return clone;
	}

	static java.util.Set newSet() {
		java.util.Set s = java.util.Collections.checkedSet(new java.util.HashSet(), java.lang.Integer.class);
		if (!s.isEmpty()) {
			jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("New instance non empty.");
		}
		return s;
	}

	static void AddRandoms(java.util.Set s, int n) {
		for (int i = 0; i < n; i++) {
			int r = jsr166tests.jtreg.util.Collections.CheckedSetBash.rnd.nextInt() % n;
			java.lang.Integer e = new java.lang.Integer(r < 0 ? -r : r);
			int preSize = s.size();
			boolean prePresent = s.contains(e);
			boolean added = s.add(e);
			if (!s.contains(e)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Element not present after addition.");
			}
			if (added == prePresent) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("added == alreadyPresent");
			}
			int postSize = s.size();
			if (added && (preSize == postSize)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Add returned true, but size didn't change.");
			}
			if ((!added) && (preSize != postSize)) {
				jsr166tests.jtreg.util.Collections.CheckedSetBash.fail("Add returned false, but size changed.");
			}
		}
	}

	static void fail(java.lang.String s) {
		throw new java.lang.RuntimeException(s);
	}
}