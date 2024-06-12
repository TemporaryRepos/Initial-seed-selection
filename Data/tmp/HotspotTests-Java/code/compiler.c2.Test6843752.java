public class Test6843752 {
	compiler.c2.Test6843752.Item list;

	static class Item {
		public compiler.c2.Test6843752.Item next;

		public compiler.c2.Test6843752.Item prev;

		public boolean remove;

		Item(boolean r) {
			remove = r;
		}
	}

	private void linkIn(compiler.c2.Test6843752.Item item) {
		compiler.c2.Test6843752.Item head = list;
		if (head == null) {
			item.next = item;
			item.prev = item;
			list = item;
		} else {
			item.next = head;
			item.prev = head.prev;
			head.prev.next = item;
			head.prev = item;
		}
	}

	private void linkOut(compiler.c2.Test6843752.Item item) {
		compiler.c2.Test6843752.Item head = list;
		if (item.next == item) {
			list = null;
		} else {
			item.prev.next = item.next;
			item.next.prev = item.prev;
			if (head == item) {
				list = item.next;
			}
		}
		item.next = null;
		item.prev = null;
	}

	private void removeItems(int numItems) {
		compiler.c2.Test6843752.Item item = list;
		if (item == null) {
			return;
		}
		compiler.c2.Test6843752.Item last = item.prev;
		boolean done = false;
		while ((!done) && (numItems > 1)) {
			done = item.next == last.next;
			item = item.next;
			if (item.prev.remove) {
				linkOut(item.prev);
			}
		} 
	}

	public void perform(int numItems) {
		for (int i = 0; i < numItems; i++) {
			linkIn(new compiler.c2.Test6843752.Item(i == 0));
		}
		removeItems(numItems);
		list = null;
	}

	public static void main(java.lang.String[] args) {
		int caseCnt = 0;
		compiler.c2.Test6843752 bj = new compiler.c2.Test6843752();
		try {
			for (; caseCnt < 500000;) {
				int numItems = (++caseCnt) % 2;
				if ((caseCnt % 64) == 0) {
					numItems = 5;
				}
				bj.perform(numItems);
				if ((caseCnt % 100000) == 0) {
					java.lang.System.out.println(("successfully performed " + caseCnt) + " cases");
				}
			}
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("ERROR: crashed during case " + caseCnt);
			e.printStackTrace(java.lang.System.out);
			java.lang.System.exit(97);
		}
	}
}