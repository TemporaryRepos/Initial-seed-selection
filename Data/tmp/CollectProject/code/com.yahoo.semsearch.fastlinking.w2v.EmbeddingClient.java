public class EmbeddingClient {
	private static final java.lang.String server_url = "http://localhost:8999/";

	public static void main(java.lang.String[] args) {
		try {
			helma.xmlrpc.XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			helma.xmlrpc.XmlRpcClient server = new helma.xmlrpc.XmlRpcClient(com.yahoo.semsearch.fastlinking.w2v.EmbeddingClient.server_url);
			java.util.Vector params = new java.util.Vector();
			params.addElement(new java.lang.Integer(5));
			params.addElement(new java.lang.Integer(3));
			java.util.Hashtable result = ((java.util.Hashtable) (server.execute("sample.sumAndDifference", params)));
			int sum = ((java.lang.Integer) (result.get("sum"))).intValue();
			int difference = ((java.lang.Integer) (result.get("difference"))).intValue();
			java.lang.System.out.println((("Sum: " + java.lang.Integer.toString(sum)) + ", Difference: ") + java.lang.Integer.toString(difference));
			java.lang.String[] phrases = new java.lang.String[]{ "the life of brian", "this is a test phrase" };
			java.lang.String[] entities = new java.lang.String[]{ "_WIKI_Monty_Python", "_WIKI_John_Cleese", "_WIKI_Brad_Pitt" };
			params.clear();
			params = new java.util.Vector();
			params.addElement(entities[0]);
			params.addElement(entities[1]);
			result = ((java.util.Hashtable) (server.execute("sample.entity2EntitySimilarity", params)));
			java.lang.System.out.println(((java.lang.Double) (result.get("similarity"))).doubleValue());
			params.clear();
			params.addElement(entities[0]);
			result = ((java.util.Hashtable) (server.execute("sample.getVector", params)));
		} catch (helma.xmlrpc.XmlRpcException exception) {
			java.lang.System.err.println((("JavaClient: XML-RPC Fault #" + java.lang.Integer.toString(exception.code)) + ": ") + exception.toString());
		} catch (java.lang.Exception exception) {
			java.lang.System.err.println("JavaClient: " + exception.toString());
		}
	}
}