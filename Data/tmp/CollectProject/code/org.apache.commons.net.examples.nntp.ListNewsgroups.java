public final class ListNewsgroups {
	public static void main(java.lang.String[] args) {
		if (args.length < 1) {
			java.lang.System.err.println("Usage: newsgroups newsserver [pattern]");
			return;
		}
		org.apache.commons.net.nntp.NNTPClient client = new org.apache.commons.net.nntp.NNTPClient();
		java.lang.String pattern = (args.length >= 2) ? args[1] : "";
		try {
			client.connect(args[0]);
			int j = 0;
			try {
				for (java.lang.String s : client.iterateNewsgroupListing(pattern)) {
					j++;
					java.lang.System.out.println(s);
				}
			} catch (java.io.IOException e1) {
				e1.printStackTrace();
			}
			java.lang.System.out.println(j);
			j = 0;
			for (org.apache.commons.net.nntp.NewsgroupInfo n : client.iterateNewsgroups(pattern)) {
				j++;
				java.lang.System.out.println(n.getNewsgroup());
			}
			java.lang.System.out.println(j);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (client.isConnected()) {
					client.disconnect();
				}
			} catch (java.io.IOException e) {
				java.lang.System.err.println("Error disconnecting from server.");
				e.printStackTrace();
				java.lang.System.exit(1);
			}
		}
	}
}