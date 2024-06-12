public class NullKeyAtResize {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List<java.lang.Object> old_order = new java.util.ArrayList<>();
		java.util.Map<java.lang.Object, java.lang.Object> m = new java.util.HashMap<>(16);
		int number = 0;
		while (number < 100000) {
			m.put(null, null);
			m.remove(null);
			java.lang.Integer adding = number += 100;
			m.put(adding, null);
			java.util.List<java.lang.Object> new_order = new java.util.ArrayList<>();
			new_order.addAll(m.keySet());
			new_order.remove(adding);
			if (!old_order.equals(new_order)) {
				java.lang.System.out.println(("Encountered resize after " + (number / 100)) + " iterations");
				break;
			}
			old_order.clear();
			old_order.addAll(m.keySet());
		} 
		if (number == 100000) {
			throw new java.lang.Error("Resize never occurred");
		}
	}
}