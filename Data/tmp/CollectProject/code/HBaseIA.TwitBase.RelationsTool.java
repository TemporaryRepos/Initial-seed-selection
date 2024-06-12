public class RelationsTool {
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HBaseIA.TwitBase.UsersTool.class);

	public static final java.lang.String usage = "relationstool action ...\n" + ((((("  help - print this message and exit.\n" + "  follows fromId toId - add a new relationship where from follows to.\n") + "  list follows userId - list everyone userId follows.\n") + "  list followedBy userId - list everyone who follows userId.\n") + "  followedByScan userId - count users' followers using a client-side scanner") + "  followedByCoproc userId - count users' followers using the Endpoint coprocessor");

	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(HBaseIA.TwitBase.RelationsTool.usage);
			java.lang.System.exit(0);
		}
		org.apache.hadoop.hbase.client.HTablePool pool = new org.apache.hadoop.hbase.client.HTablePool();
		HBaseIA.TwitBase.hbase.RelationsDAO dao = new HBaseIA.TwitBase.hbase.RelationsDAO(pool);
		if ("follows".equals(args[0])) {
			HBaseIA.TwitBase.RelationsTool.log.debug(java.lang.String.format("Adding follower %s -> %s", args[1], args[2]));
			dao.addFollows(args[1], args[2]);
			java.lang.System.out.println("Successfully added relationship");
		}
		if ("list".equals(args[0])) {
			java.util.List<HBaseIA.TwitBase.model.Relation> results = new java.util.ArrayList<HBaseIA.TwitBase.model.Relation>();
			if (args[1].equals("follows")) {
				results.addAll(dao.listFollows(args[2]));
			} else if (args[1].equals("followedBy")) {
				results.addAll(dao.listFollowedBy(args[2]));
			}
			if (results.isEmpty()) {
				java.lang.System.out.println("No relations found.");
			}
			for (HBaseIA.TwitBase.model.Relation r : results) {
				java.lang.System.out.println(r);
			}
		}
		if ("followedByScan".equals(args[0])) {
			long count = dao.followedByCountScan(args[1]);
			java.lang.System.out.println(java.lang.String.format("%s has %s followers.", args[1], count));
		}
		if ("followedByCoproc".equals(args[0])) {
			long count = dao.followedByCount(args[1]);
			java.lang.System.out.println(java.lang.String.format("%s has %s followers.", args[1], count));
		}
		pool.closeTablePool(HBaseIA.TwitBase.hbase.RelationsDAO.FOLLOWS_TABLE_NAME);
		pool.closeTablePool(HBaseIA.TwitBase.hbase.RelationsDAO.FOLLOWED_TABLE_NAME);
	}
}