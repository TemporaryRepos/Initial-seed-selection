public class InstanceMethodRef {
	static class User {
		private int num;

		private java.lang.String name;

		public User(int num, java.lang.String name) {
			this.num = num;
			this.name = name;
		}

		public java.lang.String getName() {
			return name;
		}
	}

	public static void main(java.lang.String[] args) {
		java.util.List<ch6.s2.InstanceMethodRef.User> users = new java.util.ArrayList<ch6.s2.InstanceMethodRef.User>();
		for (int i = 1; i < 10; i++) {
			users.add(new ch6.s2.InstanceMethodRef.User(i, "billy" + java.lang.Integer.toString(i)));
		}
		users.stream().map(ch6.s2.InstanceMethodRef.User::getName).forEach(java.lang.System.out::println);
	}
}