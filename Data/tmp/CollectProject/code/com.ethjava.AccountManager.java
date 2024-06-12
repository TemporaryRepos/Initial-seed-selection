public class AccountManager {
	private static org.web3j.protocol.admin.Admin admin;

	public static void main(java.lang.String[] args) {
		com.ethjava.AccountManager.admin = org.web3j.protocol.admin.Admin.build(new org.web3j.protocol.http.HttpService(com.ethjava.utils.Environment.RPC_URL));
		com.ethjava.AccountManager.createNewAccount();
		com.ethjava.AccountManager.getAccountList();
		com.ethjava.AccountManager.unlockAccount();
	}

	private static void createNewAccount() {
		java.lang.String password = "123456789";
		try {
			org.web3j.protocol.admin.methods.response.NewAccountIdentifier newAccountIdentifier = com.ethjava.AccountManager.admin.personalNewAccount(password).send();
			java.lang.String address = newAccountIdentifier.getAccountId();
			java.lang.System.out.println("new account address " + address);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private static void getAccountList() {
		try {
			org.web3j.protocol.admin.methods.response.PersonalListAccounts personalListAccounts = com.ethjava.AccountManager.admin.personalListAccounts().send();
			java.util.List<java.lang.String> addressList;
			addressList = personalListAccounts.getAccountIds();
			java.lang.System.out.println("account size " + addressList.size());
			for (java.lang.String address : addressList) {
				java.lang.System.out.println(address);
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private static void unlockAccount() {
		java.lang.String address = "0x05f50cd5a97d9b3fec35df3d0c6c8234e6793bdf";
		java.lang.String password = "123456789";
		java.math.BigInteger unlockDuration = java.math.BigInteger.valueOf(60L);
		try {
			org.web3j.protocol.admin.methods.response.PersonalUnlockAccount personalUnlockAccount = com.ethjava.AccountManager.admin.personalUnlockAccount(address, password, unlockDuration).send();
			java.lang.Boolean isUnlocked = personalUnlockAccount.accountUnlocked();
			java.lang.System.out.println("account unlock " + isUnlocked);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}