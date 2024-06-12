public class UsersTool {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HBaseIA.TwitBase.UsersTool.class);

	public static final java.lang.String usage = "usertool action ...\n" + ((("  help - print this message and exit.\n" + "  add user name email password - add a new user.\n") + "  get user - retrieve a specific user.\n") + "  list - list all installed users.\n");

	public static void main(java.lang.String[] args) throws java.io.IOException {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(HBaseIA.TwitBase.UsersTool.usage);
			java.lang.System.exit(0);
		}
		org.apache.hadoop.hbase.client.HTablePool pool = new org.apache.hadoop.hbase.client.HTablePool();
		HBaseIA.TwitBase.hbase.UsersDAO dao = new HBaseIA.TwitBase.hbase.UsersDAO(pool);
		if ("get".equals(args[0])) {
			HBaseIA.TwitBase.UsersTool.log.debug(java.lang.String.format("Getting user %s", args[1]));
			HBaseIA.TwitBase.model.User u = dao.getUser(args[1]);
			java.lang.System.out.println(u);
		}
		if ("add".equals(args[0])) {
			HBaseIA.TwitBase.UsersTool.log.debug("Adding user...");
			dao.addUser(args[1], args[2], args[3], args[4]);
			HBaseIA.TwitBase.model.User u = dao.getUser(args[1]);
			java.lang.System.out.println("Successfully added user " + u);
		}
		if ("list".equals(args[0])) {
			java.util.List<HBaseIA.TwitBase.model.User> users = dao.getUsers();
			HBaseIA.TwitBase.UsersTool.log.info(java.lang.String.format("Found %s users.", users.size()));
			for (HBaseIA.TwitBase.model.User u : users) {
				java.lang.System.out.println(u);
			}
		}
		pool.closeTablePool(HBaseIA.TwitBase.hbase.UsersDAO.TABLE_NAME);
	}
}