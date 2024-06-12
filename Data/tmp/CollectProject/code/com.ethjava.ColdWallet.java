public class ColdWallet {
	private static org.web3j.protocol.Web3j web3j;

	private static java.lang.String d = "/Users/yangzhengwei/Documents/eth/coldwallet";

	private static java.lang.String address = "0xa530d89646db11abfa701e148e87324355fc6ea7";

	private static java.lang.String keystore = "{\"address\":\"a530d89646db11abfa701e148e87324355fc6ea7\",\"id\":\"246e7d1d-8f31-4a3e-951d-41722213a44f\",\"version\":3,\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"26d10977bc199f6b678e89d3b7c3874bab3cddda18b92c014890d80657d7cc6a\",\"cipherparams\":{\"iv\":\"beaa9a404f793e86460a1fc71a0372a8\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"f06eb3d208db1643671c6e0210789f05e6de1746252fe5b83a38618e2bd18f1e\"},\"mac\":\"0aa4f85dfecaf8203ad0ee22c47ff6fb35b8f47d8f56ddb890ef2d513a06a801\"}}\n";

	private static java.lang.String privateKey = "f4529331f460fa88cc14eb981baf90201e7fc709386bf2f5b9ec687639f70086";

	public static void main(java.lang.String[] args) {
		com.ethjava.ColdWallet.web3j = org.web3j.protocol.Web3j.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		try {
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void testTransaction() {
		java.math.BigInteger nonce;
		org.web3j.protocol.core.methods.response.EthGetTransactionCount ethGetTransactionCount = null;
		try {
			ethGetTransactionCount = com.ethjava.ColdWallet.web3j.ethGetTransactionCount(com.ethjava.ColdWallet.address, org.web3j.protocol.core.DefaultBlockParameterName.PENDING).send();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		if (ethGetTransactionCount == null) {
			return;
		}
		nonce = ethGetTransactionCount.getTransactionCount();
		java.math.BigInteger gasPrice = org.web3j.utils.Convert.toWei(java.math.BigDecimal.valueOf(3), org.web3j.utils.Convert.Unit.GWEI).toBigInteger();
		java.math.BigInteger gasLimit = java.math.BigInteger.valueOf(30000);
		java.lang.String to = "0x6c0f49aF552F2326DD851b68832730CB7b6C0DaF".toLowerCase();
		java.math.BigInteger value = org.web3j.utils.Convert.toWei(java.math.BigDecimal.valueOf(0.5), org.web3j.utils.Convert.Unit.ETHER).toBigInteger();
		java.lang.String data = "";
		byte chainId = org.web3j.tx.ChainId.ROPSTEN;
		java.lang.String privateKey = com.ethjava.ColdWallet.privateKey;
		java.lang.String signedData;
		try {
			signedData = com.ethjava.ColdWallet.signTransaction(nonce, gasPrice, gasLimit, to, value, data, chainId, privateKey);
			if (signedData != null) {
				org.web3j.protocol.core.methods.response.EthSendTransaction ethSendTransaction = com.ethjava.ColdWallet.web3j.ethSendRawTransaction(signedData).send();
				java.lang.System.out.println(ethSendTransaction.getTransactionHash());
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private static void testTokenTransaction(org.web3j.protocol.Web3j web3j, java.lang.String fromAddress, java.lang.String privateKey, java.lang.String contractAddress, java.lang.String toAddress, double amount, int decimals) {
		java.math.BigInteger nonce;
		org.web3j.protocol.core.methods.response.EthGetTransactionCount ethGetTransactionCount = null;
		try {
			ethGetTransactionCount = web3j.ethGetTransactionCount(fromAddress, org.web3j.protocol.core.DefaultBlockParameterName.PENDING).send();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		if (ethGetTransactionCount == null) {
			return;
		}
		nonce = ethGetTransactionCount.getTransactionCount();
		java.lang.System.out.println("nonce " + nonce);
		java.math.BigInteger gasPrice = org.web3j.utils.Convert.toWei(java.math.BigDecimal.valueOf(3), org.web3j.utils.Convert.Unit.GWEI).toBigInteger();
		java.math.BigInteger gasLimit = java.math.BigInteger.valueOf(60000);
		java.math.BigInteger value = java.math.BigInteger.ZERO;
		java.lang.String methodName = "transfer";
		java.util.List<org.web3j.abi.datatypes.Type> inputParameters = new java.util.ArrayList<>();
		java.util.List<org.web3j.abi.TypeReference<?>> outputParameters = new java.util.ArrayList<>();
		org.web3j.abi.datatypes.Address tAddress = new org.web3j.abi.datatypes.Address(toAddress);
		org.web3j.abi.datatypes.generated.Uint256 tokenValue = new org.web3j.abi.datatypes.generated.Uint256(java.math.BigDecimal.valueOf(amount).multiply(java.math.BigDecimal.TEN.pow(decimals)).toBigInteger());
		inputParameters.add(tAddress);
		inputParameters.add(tokenValue);
		org.web3j.abi.TypeReference<org.web3j.abi.datatypes.Bool> typeReference = new org.web3j.abi.TypeReference<org.web3j.abi.datatypes.Bool>() {};
		outputParameters.add(typeReference);
		org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(methodName, inputParameters, outputParameters);
		java.lang.String data = org.web3j.abi.FunctionEncoder.encode(function);
		byte chainId = org.web3j.tx.ChainId.NONE;
		java.lang.String signedData;
		try {
			signedData = com.ethjava.ColdWallet.signTransaction(nonce, gasPrice, gasLimit, contractAddress, value, data, chainId, privateKey);
			if (signedData != null) {
				org.web3j.protocol.core.methods.response.EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(signedData).send();
				java.lang.System.out.println(ethSendTransaction.getTransactionHash());
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public static void createWallet(java.lang.String password) throws java.security.InvalidAlgorithmParameterException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, org.web3j.crypto.CipherException, com.fasterxml.jackson.core.JsonProcessingException {
		org.web3j.crypto.WalletFile walletFile;
		org.web3j.crypto.ECKeyPair ecKeyPair = org.web3j.crypto.Keys.createEcKeyPair();
		walletFile = org.web3j.crypto.Wallet.createStandard(password, ecKeyPair);
		java.lang.System.out.println("address " + walletFile.getAddress());
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = org.web3j.protocol.ObjectMapperFactory.getObjectMapper();
		java.lang.String jsonStr = objectMapper.writeValueAsString(walletFile);
		java.lang.System.out.println("keystore json file " + jsonStr);
	}

	public static java.lang.String decryptWallet(java.lang.String keystore, java.lang.String password) {
		java.lang.String privateKey = null;
		com.fasterxml.jackson.databind.ObjectMapper objectMapper = org.web3j.protocol.ObjectMapperFactory.getObjectMapper();
		try {
			org.web3j.crypto.WalletFile walletFile = objectMapper.readValue(keystore, org.web3j.crypto.WalletFile.class);
			org.web3j.crypto.ECKeyPair ecKeyPair = null;
			ecKeyPair = org.web3j.crypto.Wallet.decrypt(password, walletFile);
			privateKey = ecKeyPair.getPrivateKey().toString(16);
			java.lang.System.out.println(privateKey);
		} catch (org.web3j.crypto.CipherException e) {
			if ("Invalid password provided".equals(e.getMessage())) {
				java.lang.System.out.println("密码错误");
			}
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	public static java.lang.String signTransaction(java.math.BigInteger nonce, java.math.BigInteger gasPrice, java.math.BigInteger gasLimit, java.lang.String to, java.math.BigInteger value, java.lang.String data, byte chainId, java.lang.String privateKey) throws java.io.IOException {
		byte[] signedMessage;
		org.web3j.crypto.RawTransaction rawTransaction = org.web3j.crypto.RawTransaction.createTransaction(nonce, gasPrice, gasLimit, to, value, data);
		if (privateKey.startsWith("0x")) {
			privateKey = privateKey.substring(2);
		}
		org.web3j.crypto.ECKeyPair ecKeyPair = org.web3j.crypto.ECKeyPair.create(new java.math.BigInteger(privateKey, 16));
		org.web3j.crypto.Credentials credentials = org.web3j.crypto.Credentials.create(ecKeyPair);
		if (chainId > org.web3j.tx.ChainId.NONE) {
			signedMessage = org.web3j.crypto.TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
		} else {
			signedMessage = org.web3j.crypto.TransactionEncoder.signMessage(rawTransaction, credentials);
		}
		java.lang.String hexValue = org.web3j.utils.Numeric.toHexString(signedMessage);
		return hexValue;
	}
}