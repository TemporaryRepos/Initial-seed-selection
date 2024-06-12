public class TwitsTool {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HBaseIA.TwitBase.TwitsTool.class);

	public static final java.lang.String usage = "twitstool action ...\n" + (("  help - print this message and exit.\n" + "  post user text - post a new twit on user\'s behalf.\n") + "  list user - list all twits for the specified user.\n");

	public static void main(java.lang.String[] args) throws java.io.IOException {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(HBaseIA.TwitBase.TwitsTool.usage);
			java.lang.System.exit(0);
		}
		org.apache.hadoop.hbase.client.HTablePool pool = new org.apache.hadoop.hbase.client.HTablePool();
		HBaseIA.TwitBase.hbase.TwitsDAO twitsDao = new HBaseIA.TwitBase.hbase.TwitsDAO(pool);
		HBaseIA.TwitBase.hbase.UsersDAO usersDao = new HBaseIA.TwitBase.hbase.UsersDAO(pool);
		if ("post".equals(args[0])) {
			org.joda.time.DateTime now = new org.joda.time.DateTime();
			HBaseIA.TwitBase.TwitsTool.log.debug(java.lang.String.format("Posting twit at ...", now));
			twitsDao.postTwit(args[1], now, args[2]);
			HBaseIA.TwitBase.model.Twit t = twitsDao.getTwit(args[1], now);
			usersDao.incTweetCount(args[1]);
			java.lang.System.out.println("Successfully posted " + t);
		}
		if ("list".equals(args[0])) {
			java.util.List<HBaseIA.TwitBase.model.Twit> twits = twitsDao.list(args[1]);
			HBaseIA.TwitBase.TwitsTool.log.info(java.lang.String.format("Found %s twits.", twits.size()));
			for (HBaseIA.TwitBase.model.Twit t : twits) {
				java.lang.System.out.println(t);
			}
		}
		pool.closeTablePool(HBaseIA.TwitBase.hbase.TwitsDAO.TABLE_NAME);
	}
}