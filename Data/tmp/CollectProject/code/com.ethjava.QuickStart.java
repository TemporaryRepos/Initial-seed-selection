public class QuickStart {
	private static org.web3j.protocol.Web3j web3j;

	public static void main(java.lang.String[] args) {
		com.ethjava.QuickStart.web3j = org.web3j.protocol.Web3j.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		org.web3j.protocol.core.methods.response.Web3ClientVersion web3ClientVersion = null;
		try {
			web3ClientVersion = com.ethjava.QuickStart.web3j.web3ClientVersion().send();
			java.lang.String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			java.lang.System.out.println("clientVersion " + clientVersion);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}