public class Calculate {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.ethjava.Calculate.calculateContractAddress("0x6c0f49aF552F2326DD851b68832730CB7b6C0DaF".toLowerCase(), 294));
		java.lang.String signedData = "0xf8ac8201518506fc23ac00830493e094fda023cea60a9f421d74ac49f9a015880a77dd7280b844a9059cbb000000000000000000000000b5dbd2e4093a501f1d1e645f04cef5815a1581d7000000000000000000000000000000000000000000000004c53ecdc18a6000001ca03d710f3c5aabde2733938c44c0b1448f96e760c030205562f59889557397faa4a007110abbcfa343381a2f713d6339d3fa751200f82cc2f06a4d1967b4eaf61d50";
		java.lang.System.out.println(com.ethjava.Calculate.caculateTransactionHash(signedData));
	}

	private static java.lang.String calculateContractAddress(java.lang.String address, long nonce) {
		byte[] addressAsBytes = org.web3j.utils.Numeric.hexStringToByteArray(address);
		byte[] calculatedAddressAsBytes = org.web3j.crypto.Hash.sha3(org.web3j.rlp.RlpEncoder.encode(new org.web3j.rlp.RlpList(org.web3j.rlp.RlpString.create(addressAsBytes), org.web3j.rlp.RlpString.create(nonce))));
		calculatedAddressAsBytes = java.util.Arrays.copyOfRange(calculatedAddressAsBytes, 12, calculatedAddressAsBytes.length);
		java.lang.String calculatedAddressAsHex = org.web3j.utils.Numeric.toHexString(calculatedAddressAsBytes);
		return calculatedAddressAsHex;
	}

	private static java.lang.String caculateTransactionHash(java.lang.String signedData) {
		java.lang.String txHash = org.web3j.crypto.Hash.sha3(signedData);
		return txHash;
	}
}