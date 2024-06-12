public class LoadTwits {
	public static final java.lang.String usage = "loadtwits count\n" + ("  help - print this message and exit.\n" + "  count - add count random twits to all TwitBase users.\n");

	private static java.lang.String randTwit(java.util.List<java.lang.String> words) {
		java.lang.String twit = "";
		for (int i = 0; i < 12; i++) {
			twit += utils.LoadUtils.randNth(words) + " ";
		}
		return twit;
	}

	private static org.joda.time.DateTime randDT() {
		int year = 2010 + utils.LoadUtils.randInt(5);
		int month = 1 + utils.LoadUtils.randInt(12);
		int day = 1 + utils.LoadUtils.randInt(28);
		return new org.joda.time.DateTime(year, month, day, 0, 0, 0, 0);
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(HBaseIA.TwitBase.LoadTwits.usage);
			java.lang.System.exit(0);
		}
		org.apache.hadoop.conf.Configuration conf = org.apache.hadoop.hbase.HBaseConfiguration.create();
		org.apache.hadoop.hbase.client.HBaseAdmin admin = new org.apache.hadoop.hbase.client.HBaseAdmin(conf);
		if ((!admin.tableExists(HBaseIA.TwitBase.hbase.UsersDAO.TABLE_NAME)) || (!admin.tableExists(HBaseIA.TwitBase.hbase.TwitsDAO.TABLE_NAME))) {
			java.lang.System.out.println("Please use the InitTables utility to create " + "destination tables first.");
			java.lang.System.exit(0);
		}
		org.apache.hadoop.hbase.client.HTablePool pool = new org.apache.hadoop.hbase.client.HTablePool(conf, java.lang.Integer.MAX_VALUE);
		HBaseIA.TwitBase.hbase.UsersDAO users = new HBaseIA.TwitBase.hbase.UsersDAO(pool);
		HBaseIA.TwitBase.hbase.TwitsDAO twits = new HBaseIA.TwitBase.hbase.TwitsDAO(pool);
		int count = java.lang.Integer.parseInt(args[0]);
		java.util.List<java.lang.String> words = utils.LoadUtils.readResource(utils.LoadUtils.WORDS_PATH);
		for (HBaseIA.TwitBase.model.User u : users.getUsers()) {
			for (int i = 0; i < count; i++) {
				twits.postTwit(u.user, HBaseIA.TwitBase.LoadTwits.randDT(), HBaseIA.TwitBase.LoadTwits.randTwit(words));
			}
		}
		pool.closeTablePool(HBaseIA.TwitBase.hbase.UsersDAO.TABLE_NAME);
	}
}