public class PriorityQueueSort {
	static class MyComparator implements java.util.Comparator<java.lang.Integer> {
		public int compare(java.lang.Integer x, java.lang.Integer y) {
			int i = x.intValue();
			int j = y.intValue();
			if (i < j) {
				return -1;
			}
			if (i > j) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(java.lang.String[] args) {
		int n = 10000;
		if (args.length > 0) {
			n = java.lang.Integer.parseInt(args[0]);
		}
		java.util.List<java.lang.Integer> sorted = new java.util.ArrayList<java.lang.Integer>(n);
		for (int i = 0; i < n; i++) {
			sorted.add(new java.lang.Integer(i));
		}
		java.util.List<java.lang.Integer> shuffled = new java.util.ArrayList<java.lang.Integer>(sorted);
		java.util.Collections.shuffle(shuffled);
		java.util.Queue<java.lang.Integer> pq = new java.util.PriorityQueue<java.lang.Integer>(n, new jsr166tests.jtreg.util.PriorityQueue.PriorityQueueSort.MyComparator());
		for (java.util.Iterator<java.lang.Integer> i = shuffled.iterator(); i.hasNext();) {
			pq.add(i.next());
		}
		java.util.List<java.lang.Integer> recons = new java.util.ArrayList<java.lang.Integer>();
		while (!pq.isEmpty()) {
			recons.add(pq.remove());
		} 
		if (!recons.equals(sorted)) {
			throw new java.lang.RuntimeException("Sort test failed");
		}
		recons.clear();
		pq = new java.util.PriorityQueue<java.lang.Integer>(shuffled);
		while (!pq.isEmpty()) {
			recons.add(pq.remove());
		} 
		if (!recons.equals(sorted)) {
			throw new java.lang.RuntimeException("Sort test failed");
		}
		pq = new java.util.PriorityQueue<java.lang.Integer>(shuffled);
		for (java.util.Iterator<java.lang.Integer> i = pq.iterator(); i.hasNext();) {
			if ((i.next().intValue() & 1) == 1) {
				i.remove();
			}
		}
		recons.clear();
		while (!pq.isEmpty()) {
			recons.add(pq.remove());
		} 
		for (java.util.Iterator<java.lang.Integer> i = sorted.iterator(); i.hasNext();) {
			if ((i.next().intValue() & 1) == 1) {
				i.remove();
			}
		}
		if (!recons.equals(sorted)) {
			throw new java.lang.RuntimeException("Iterator remove test failed.");
		}
	}
}