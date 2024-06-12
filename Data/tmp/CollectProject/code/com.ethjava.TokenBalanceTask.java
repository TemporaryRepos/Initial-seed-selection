public class TokenBalanceTask {
	public class Token {
		public java.lang.String contractAddress;

		public int decimals;

		public java.lang.String name;

		public Token(java.lang.String contractAddress) {
			this.contractAddress = contractAddress;
			this.decimals = 0;
		}

		public Token(java.lang.String contractAddress, int decimals) {
			this.contractAddress = contractAddress;
			this.decimals = decimals;
		}
	}

	private static org.web3j.protocol.Web3j web3j;

	private static java.util.List<com.ethjava.TokenBalanceTask.Token> tokenList;

	private static java.util.List<java.lang.String> addressList;

	public static void main(java.lang.String[] args) {
		com.ethjava.TokenBalanceTask.web3j = org.web3j.protocol.Web3j.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		com.ethjava.TokenBalanceTask.loadData();
		com.ethjava.TokenBalanceTask.requestDecimals();
		com.ethjava.TokenBalanceTask.requestName();
		com.ethjava.TokenBalanceTask.processTask();
	}

	private static void loadData() {
		com.ethjava.TokenBalanceTask.tokenList = new java.util.ArrayList<>();
		com.ethjava.TokenBalanceTask.addressList = new java.util.ArrayList<>();
	}

	private static void requestDecimals() {
		for (com.ethjava.TokenBalanceTask.Token token : com.ethjava.TokenBalanceTask.tokenList) {
			token.decimals = com.ethjava.TokenClient.getTokenDecimals(com.ethjava.TokenBalanceTask.web3j, token.contractAddress);
		}
	}

	private static void requestName() {
		for (com.ethjava.TokenBalanceTask.Token token : com.ethjava.TokenBalanceTask.tokenList) {
			token.name = com.ethjava.TokenClient.getTokenName(com.ethjava.TokenBalanceTask.web3j, token.contractAddress);
		}
	}

	private static void processTask() {
		for (java.lang.String address : com.ethjava.TokenBalanceTask.addressList) {
			for (com.ethjava.TokenBalanceTask.Token token : com.ethjava.TokenBalanceTask.tokenList) {
				java.math.BigDecimal balance = new java.math.BigDecimal(com.ethjava.TokenClient.getTokenBalance(com.ethjava.TokenBalanceTask.web3j, address, token.contractAddress));
				balance.divide(java.math.BigDecimal.TEN.pow(token.decimals));
				java.lang.System.out.println((((("address " + address) + " name ") + token.name) + " balance ") + balance);
			}
		}
	}
}