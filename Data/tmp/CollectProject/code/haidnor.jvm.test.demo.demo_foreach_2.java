public class demo_foreach_2 {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> list = new java.util.ArrayList<>();
		list.add(1);
		list.add(2);
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}
		for (java.lang.Integer integer : list) {
			java.lang.System.out.println(integer);
		}
	}
}