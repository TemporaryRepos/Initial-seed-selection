public class Basic {
	static java.util.Random rnd = new java.util.Random(666);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		int numItr = 500;
		int setSize = 500;
		for (int i = 0; i < numItr; i++) {
			java.util.Set s1 = new java.util.LinkedHashSet();
			jsr166tests.jtreg.util.LinkedHashSet.Basic.AddRandoms(s1, setSize);
			java.util.Set s2 = new java.util.LinkedHashSet();
			jsr166tests.jtreg.util.LinkedHashSet.Basic.AddRandoms(s2, setSize);
			java.util.Set intersection = jsr166tests.jtreg.util.LinkedHashSet.Basic.clone(s1);
			intersection.retainAll(s2);
			java.util.Set diff1 = jsr166tests.jtreg.util.LinkedHashSet.Basic.clone(s1);
			diff1.removeAll(s2);
			java.util.Set diff2 = jsr166tests.jtreg.util.LinkedHashSet.Basic.clone(s2);
			diff2.removeAll(s1);
			java.util.Set union = jsr166tests.jtreg.util.LinkedHashSet.Basic.clone(s1);
			union.addAll(s2);
			if (diff1.removeAll(diff2)) {
				throw new java.lang.Exception("Set algebra identity 2 failed");
			}
			if (diff1.removeAll(intersection)) {
				throw new java.lang.Exception("Set algebra identity 3 failed");
			}
			if (diff2.removeAll(diff1)) {
				throw new java.lang.Exception("Set algebra identity 4 failed");
			}
			if (diff2.removeAll(intersection)) {
				throw new java.lang.Exception("Set algebra identity 5 failed");
			}
			if (intersection.removeAll(diff1)) {
				throw new java.lang.Exception("Set algebra identity 6 failed");
			}
			if (intersection.removeAll(diff1)) {
				throw new java.lang.Exception("Set algebra identity 7 failed");
			}
			intersection.addAll(diff1);
			intersection.addAll(diff2);
			if (!intersection.equals(union)) {
				throw new java.lang.Exception("Set algebra identity 1 failed");
			}
			if (new java.util.LinkedHashSet(union).hashCode() != union.hashCode()) {
				throw new java.lang.Exception("Incorrect hashCode computation.");
			}
			java.util.Iterator e = union.iterator();
			while (e.hasNext()) {
				if (!intersection.remove(e.next())) {
					throw new java.lang.Exception("Couldn't remove element from copy.");
				}
			} 
			if (!intersection.isEmpty()) {
				throw new java.lang.Exception("Copy nonempty after deleting all elements.");
			}
			e = union.iterator();
			while (e.hasNext()) {
				java.lang.Object o = e.next();
				if (!union.contains(o)) {
					throw new java.lang.Exception("Set doesn't contain one of its elements.");
				}
				e.remove();
				if (union.contains(o)) {
					throw new java.lang.Exception("Set contains element after deletion.");
				}
			} 
			if (!union.isEmpty()) {
				throw new java.lang.Exception("Set nonempty after deleting all elements.");
			}
			s1.clear();
			if (!s1.isEmpty()) {
				throw new java.lang.Exception("Set nonempty after clear.");
			}
		}
		java.lang.System.err.println("Success.");
	}

	static java.util.Set clone(java.util.Set s) throws java.lang.Exception {
		java.util.Set clone;
		int method = jsr166tests.jtreg.util.LinkedHashSet.Basic.rnd.nextInt(3);
		clone = (method == 0) ? ((java.util.Set) (((java.util.LinkedHashSet) (s)).clone())) : method == 1 ? new java.util.LinkedHashSet(java.util.Arrays.asList(s.toArray())) : jsr166tests.jtreg.util.LinkedHashSet.Basic.serClone(s);
		if (!s.equals(clone)) {
			throw new java.lang.Exception("Set not equal to copy: " + method);
		}
		if (!s.containsAll(clone)) {
			throw new java.lang.Exception("Set does not contain copy.");
		}
		if (!clone.containsAll(s)) {
			throw new java.lang.Exception("Copy does not contain set.");
		}
		return clone;
	}

	private static java.util.Set serClone(java.util.Set m) {
		java.util.Set result = null;
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			out.writeObject(m);
			out.flush();
			java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(bos.toByteArray());
			out.close();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(bis);
			result = ((java.util.Set) (in.readObject()));
			in.close();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	static void AddRandoms(java.util.Set s, int n) throws java.lang.Exception {
		for (int i = 0; i < n; i++) {
			int r = jsr166tests.jtreg.util.LinkedHashSet.Basic.rnd.nextInt() % n;
			java.lang.Integer e = new java.lang.Integer(r < 0 ? -r : r);
			int preSize = s.size();
			boolean prePresent = s.contains(e);
			boolean added = s.add(e);
			if (!s.contains(e)) {
				throw new java.lang.Exception("Element not present after addition.");
			}
			if (added == prePresent) {
				throw new java.lang.Exception("added == alreadyPresent");
			}
			int postSize = s.size();
			if (added && (preSize == postSize)) {
				throw new java.lang.Exception("Add returned true, but size didn't change.");
			}
			if ((!added) && (preSize != postSize)) {
				throw new java.lang.Exception("Add returned false, but size changed.");
			}
		}
	}
}