public class AddAll {
	public static void main(java.lang.String[] args) {
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			new java.util.ArrayList().addAll(m.keySet());
		}
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			new java.util.LinkedList().addAll(m.keySet());
		}
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			new java.util.Vector().addAll(m.keySet());
		}
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			java.util.List list = new java.util.ArrayList();
			list.add("inka");
			list.add("dinka");
			list.add("doo");
			list.addAll(1, m.keySet());
		}
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			java.util.List list = new java.util.LinkedList();
			list.add("inka");
			list.add("dinka");
			list.add("doo");
			list.addAll(1, m.keySet());
		}
		for (int j = 0; j < 1; j++) {
			java.util.Map m = new java.util.WeakHashMap(100000);
			for (int i = 0; i < 100000; i++) {
				m.put(new java.lang.Object(), java.lang.Boolean.TRUE);
			}
			java.util.List list = new java.util.ArrayList();
			list.add("inka");
			list.add("dinka");
			list.add("doo");
			list.addAll(1, m.keySet());
		}
	}
}