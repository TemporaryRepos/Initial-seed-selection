public class EthInfo {
	private static org.web3j.protocol.Web3j web3j;

	public static void main(java.lang.String[] args) {
		com.ethjava.EthInfo.web3j = org.web3j.protocol.Web3j.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		com.ethjava.EthInfo.getEthInfo();
	}

	private static void getEthInfo() {
		org.web3j.protocol.core.methods.response.Web3ClientVersion web3ClientVersion = null;
		try {
			web3ClientVersion = com.ethjava.EthInfo.web3j.web3ClientVersion().send();
			java.lang.String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			java.lang.System.out.println("clientVersion " + clientVersion);
			org.web3j.protocol.core.methods.response.EthBlockNumber ethBlockNumber = com.ethjava.EthInfo.web3j.ethBlockNumber().send();
			java.math.BigInteger blockNumber = ethBlockNumber.getBlockNumber();
			java.lang.System.out.println(blockNumber);
			org.web3j.protocol.core.methods.response.EthCoinbase ethCoinbase = com.ethjava.EthInfo.web3j.ethCoinbase().send();
			java.lang.String coinbaseAddress = ethCoinbase.getAddress();
			java.lang.System.out.println(coinbaseAddress);
			org.web3j.protocol.core.methods.response.EthSyncing ethSyncing = com.ethjava.EthInfo.web3j.ethSyncing().send();
			boolean isSyncing = ethSyncing.isSyncing();
			java.lang.System.out.println(isSyncing);
			org.web3j.protocol.core.methods.response.EthMining ethMining = com.ethjava.EthInfo.web3j.ethMining().send();
			boolean isMining = ethMining.isMining();
			java.lang.System.out.println(isMining);
			org.web3j.protocol.core.methods.response.EthGasPrice ethGasPrice = com.ethjava.EthInfo.web3j.ethGasPrice().send();
			java.math.BigInteger gasPrice = ethGasPrice.getGasPrice();
			java.lang.System.out.println(gasPrice);
			org.web3j.protocol.core.methods.response.EthHashrate ethHashrate = com.ethjava.EthInfo.web3j.ethHashrate().send();
			java.math.BigInteger hashRate = ethHashrate.getHashrate();
			java.lang.System.out.println(hashRate);
			org.web3j.protocol.core.methods.response.EthProtocolVersion ethProtocolVersion = com.ethjava.EthInfo.web3j.ethProtocolVersion().send();
			java.lang.String protocolVersion = ethProtocolVersion.getProtocolVersion();
			java.lang.System.out.println(protocolVersion);
			org.web3j.protocol.core.methods.response.NetPeerCount netPeerCount = com.ethjava.EthInfo.web3j.netPeerCount().send();
			java.math.BigInteger peerCount = netPeerCount.getQuantity();
			java.lang.System.out.println(peerCount);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}