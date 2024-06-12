public class MessageThreading {
	public MessageThreading() {
	}

	public static void main(java.lang.String[] args) throws java.net.SocketException, java.io.IOException {
		if ((args.length != 2) && (args.length != 4)) {
			java.lang.System.out.println("Usage: MessageThreading <hostname> <groupname> [<user> <password>]");
			return;
		}
		java.lang.String hostname = args[0];
		java.lang.String newsgroup = args[1];
		org.apache.commons.net.nntp.NNTPClient client = new org.apache.commons.net.nntp.NNTPClient();
		client.addProtocolCommandListener(new org.apache.commons.net.PrintCommandListener(new java.io.PrintWriter(java.lang.System.out), true));
		client.connect(hostname);
		if (args.length == 4) {
			java.lang.String user = args[2];
			java.lang.String password = args[3];
			if (!client.authenticate(user, password)) {
				java.lang.System.out.println(("Authentication failed for user " + user) + "!");
				java.lang.System.exit(1);
			}
		}
		java.lang.String[] fmt = client.listOverviewFmt();
		if (fmt != null) {
			java.lang.System.out.println("LIST OVERVIEW.FMT:");
			for (java.lang.String s : fmt) {
				java.lang.System.out.println(s);
			}
		} else {
			java.lang.System.out.println("Failed to get OVERVIEW.FMT");
		}
		org.apache.commons.net.nntp.NewsgroupInfo group = new org.apache.commons.net.nntp.NewsgroupInfo();
		client.selectNewsgroup(newsgroup, group);
		long lowArticleNumber = group.getFirstArticleLong();
		long highArticleNumber = lowArticleNumber + 5000;
		java.lang.System.out.println(((("Retrieving articles between [" + lowArticleNumber) + "] and [") + highArticleNumber) + "]");
		java.lang.Iterable<org.apache.commons.net.nntp.Article> articles = client.iterateArticleInfo(lowArticleNumber, highArticleNumber);
		java.lang.System.out.println("Building message thread tree...");
		org.apache.commons.net.nntp.Threader threader = new org.apache.commons.net.nntp.Threader();
		org.apache.commons.net.nntp.Article root = ((org.apache.commons.net.nntp.Article) (threader.thread(articles)));
		org.apache.commons.net.nntp.Article.printThread(root, 0);
	}
}