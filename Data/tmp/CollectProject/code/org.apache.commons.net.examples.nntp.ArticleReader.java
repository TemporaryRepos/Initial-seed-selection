public class ArticleReader {
	public static void main(java.lang.String[] args) throws java.net.SocketException, java.io.IOException {
		if (((args.length != 2) && (args.length != 3)) && (args.length != 5)) {
			java.lang.System.out.println("Usage: MessageThreading <hostname> <groupname> [<article specifier> [<user> <password>]]");
			return;
		}
		java.lang.String hostname = args[0];
		java.lang.String newsgroup = args[1];
		java.lang.String articleSpec = (args.length >= 3) ? args[2] : null;
		org.apache.commons.net.nntp.NNTPClient client = new org.apache.commons.net.nntp.NNTPClient();
		client.addProtocolCommandListener(new org.apache.commons.net.PrintCommandListener(new java.io.PrintWriter(java.lang.System.out), true));
		client.connect(hostname);
		if (args.length == 5) {
			java.lang.String user = args[3];
			java.lang.String password = args[4];
			if (!client.authenticate(user, password)) {
				java.lang.System.out.println(("Authentication failed for user " + user) + "!");
				java.lang.System.exit(1);
			}
		}
		org.apache.commons.net.nntp.NewsgroupInfo group = new org.apache.commons.net.nntp.NewsgroupInfo();
		client.selectNewsgroup(newsgroup, group);
		java.io.BufferedReader brHdr;
		java.lang.String line;
		if (articleSpec != null) {
			brHdr = ((java.io.BufferedReader) (client.retrieveArticleHeader(articleSpec)));
		} else {
			long articleNum = group.getLastArticleLong();
			brHdr = client.retrieveArticleHeader(articleNum);
		}
		if (brHdr != null) {
			while ((line = brHdr.readLine()) != null) {
				java.lang.System.out.println(line);
			} 
			brHdr.close();
		}
		java.io.BufferedReader brBody;
		if (articleSpec != null) {
			brBody = ((java.io.BufferedReader) (client.retrieveArticleBody(articleSpec)));
		} else {
			long articleNum = group.getLastArticleLong();
			brBody = client.retrieveArticleBody(articleNum);
		}
		if (brBody != null) {
			while ((line = brBody.readLine()) != null) {
				java.lang.System.out.println(line);
			} 
			brBody.close();
		}
	}
}