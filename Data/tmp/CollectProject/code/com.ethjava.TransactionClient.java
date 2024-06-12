public class TransactionClient {
	private static org.web3j.protocol.Web3j web3j;

	private static org.web3j.protocol.admin.Admin admin;

	private static java.lang.String fromAddress = "0x7b1cc408fcb2de1d510c1bf46a329e9027db4112";

	private static java.lang.String toAddress = "0x05f50cd5a97d9b3fec35df3d0c6c8234e6793bdf";

	private static java.math.BigDecimal defaultGasPrice = java.math.BigDecimal.valueOf(5);

	public static void main(java.lang.String[] args) {
		com.ethjava.TransactionClient.web3j = org.web3j.protocol.Web3j.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		com.ethjava.TransactionClient.admin = org.web3j.protocol.admin.Admin.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		com.ethjava.TransactionClient.getBalance(com.ethjava.TransactionClient.fromAddress);
		com.ethjava.TransactionClient.sendTransaction();
	}

	private static java.math.BigInteger getBalance(java.lang.String address) {
		java.math.BigInteger balance = null;
		try {
			org.web3j.protocol.core.methods.response.EthGetBalance ethGetBalance = com.ethjava.TransactionClient.web3j.ethGetBalance(address, org.web3j.protocol.core.DefaultBlockParameterName.LATEST).send();
			balance = ethGetBalance.getBalance();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		java.lang.System.out.println(((("address " + address) + " balance ") + balance) + "wei");
		return balance;
	}

	private static org.web3j.protocol.core.methods.request.Transaction makeTransaction(java.lang.String fromAddress, java.lang.String toAddress, java.math.BigInteger nonce, java.math.BigInteger gasPrice, java.math.BigInteger gasLimit, java.math.BigInteger value) {
		org.web3j.protocol.core.methods.request.Transaction transaction;
		transaction = org.web3j.protocol.core.methods.request.Transaction.createEtherTransaction(fromAddress, nonce, gasPrice, gasLimit, toAddress, value);
		return transaction;
	}

	private static java.math.BigInteger getTransactionGasLimit(org.web3j.protocol.core.methods.request.Transaction transaction) {
		java.math.BigInteger gasLimit = java.math.BigInteger.ZERO;
		try {
			org.web3j.protocol.core.methods.response.EthEstimateGas ethEstimateGas = com.ethjava.TransactionClient.web3j.ethEstimateGas(transaction).send();
			gasLimit = ethEstimateGas.getAmountUsed();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return gasLimit;
	}

	private static java.math.BigInteger getTransactionNonce(java.lang.String address) {
		java.math.BigInteger nonce = java.math.BigInteger.ZERO;
		try {
			org.web3j.protocol.core.methods.response.EthGetTransactionCount ethGetTransactionCount = com.ethjava.TransactionClient.web3j.ethGetTransactionCount(address, org.web3j.protocol.core.DefaultBlockParameterName.PENDING).send();
			nonce = ethGetTransactionCount.getTransactionCount();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return nonce;
	}

	private static java.lang.String sendTransaction() {
		java.lang.String password = "yzw";
		java.math.BigInteger unlockDuration = java.math.BigInteger.valueOf(60L);
		java.math.BigDecimal amount = new java.math.BigDecimal("0.01");
		java.lang.String txHash = null;
		try {
			org.web3j.protocol.admin.methods.response.PersonalUnlockAccount personalUnlockAccount = com.ethjava.TransactionClient.admin.personalUnlockAccount(com.ethjava.TransactionClient.fromAddress, password, unlockDuration).send();
			if (personalUnlockAccount.accountUnlocked()) {
				java.math.BigInteger value = org.web3j.utils.Convert.toWei(amount, org.web3j.utils.Convert.Unit.ETHER).toBigInteger();
				org.web3j.protocol.core.methods.request.Transaction transaction = com.ethjava.TransactionClient.makeTransaction(com.ethjava.TransactionClient.fromAddress, com.ethjava.TransactionClient.toAddress, null, null, null, value);
				java.math.BigInteger gasLimit = com.ethjava.TransactionClient.getTransactionGasLimit(transaction);
				java.math.BigInteger nonce = com.ethjava.TransactionClient.getTransactionNonce(com.ethjava.TransactionClient.fromAddress);
				java.math.BigInteger gasPrice = org.web3j.utils.Convert.toWei(com.ethjava.TransactionClient.defaultGasPrice, org.web3j.utils.Convert.Unit.GWEI).toBigInteger();
				transaction = com.ethjava.TransactionClient.makeTransaction(com.ethjava.TransactionClient.fromAddress, com.ethjava.TransactionClient.toAddress, nonce, gasPrice, gasLimit, value);
				org.web3j.protocol.core.methods.response.EthSendTransaction ethSendTransaction = com.ethjava.TransactionClient.web3j.ethSendTransaction(transaction).send();
				txHash = ethSendTransaction.getTransactionHash();
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		java.lang.System.out.println("tx hash " + txHash);
		return txHash;
	}
}