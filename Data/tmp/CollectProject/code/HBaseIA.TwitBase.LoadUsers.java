public class LoadUsers {
	public static final java.lang.String usage = "loadusers count\n" + ("  help - print this message and exit.\n" + "  count - add count random TwitBase users.\n");

	private static java.lang.String randName(java.util.List<java.lang.String> names) {
		java.lang.String name = utils.LoadUtils.randNth(names) + " ";
		name += utils.LoadUtils.randNth(names);
		return name;
	}

	private static java.lang.String randUser(java.lang.String name) {
		return java.lang.String.format("%s%2d", name.substring(5), utils.LoadUtils.randInt(100));
	}

	private static java.lang.String randEmail(java.lang.String user, java.util.List<java.lang.String> words) {
		return java.lang.String.format("%s@%s.com", user, utils.LoadUtils.randNth(words));
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(HBaseIA.TwitBase.LoadUsers.usage);
			java.lang.System.exit(0);
		}
		org.apache.hadoop.hbase.client.HTablePool pool = new org.apache.hadoop.hbase.client.HTablePool();
		HBaseIA.TwitBase.hbase.UsersDAO dao = new HBaseIA.TwitBase.hbase.UsersDAO(pool);
		int count = java.lang.Integer.parseInt(args[0]);
		java.util.List<java.lang.String> names = utils.LoadUtils.readResource(utils.LoadUtils.NAMES_PATH);
		java.util.List<java.lang.String> words = utils.LoadUtils.readResource(utils.LoadUtils.WORDS_PATH);
		for (int i = 0; i < count; i++) {
			java.lang.String name = HBaseIA.TwitBase.LoadUsers.randName(names);
			java.lang.String user = HBaseIA.TwitBase.LoadUsers.randUser(name);
			java.lang.String email = HBaseIA.TwitBase.LoadUsers.randEmail(user, words);
			dao.addUser(user, name, email, "abc123");
		}
		pool.closeTablePool(HBaseIA.TwitBase.hbase.UsersDAO.TABLE_NAME);
	}
}