public class ConstrMethodRef {
	public static class User {
		private int id;

		private java.lang.String name;

		public User(int id, java.lang.String name) {
			this.id = id;
			this.name = name;
		}

		public java.lang.String getName() {
			return name;
		}
	}

	@java.lang.FunctionalInterface
	interface UserFactory<U extends ch6.s2.ConstrMethodRef.User> {
		public abstract U create(int id, java.lang.String name);
	}

	static ch6.s2.ConstrMethodRef.UserFactory<ch6.s2.ConstrMethodRef.User> uf = ch6.s2.ConstrMethodRef.User::new;

	public static void main(java.lang.String[] args) {
		java.util.List<ch6.s2.ConstrMethodRef.User> users = new java.util.ArrayList<ch6.s2.ConstrMethodRef.User>();
		for (int i = 0; i < 10; i++) {
			users.add(ch6.s2.ConstrMethodRef.uf.create(i, "billy" + java.lang.Integer.toString(i)));
		}
		users.stream().map(ch6.s2.ConstrMethodRef.User::getName).forEach(java.lang.System.out::println);
	}
}