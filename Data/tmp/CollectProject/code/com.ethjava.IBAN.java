public class IBAN {
	public static void main(java.lang.String[] args) {
		com.ethjava.IBAN.getIBAN();
	}

	public static void getIBAN() {
		java.lang.String address = "0xaaae432f77a74a33c5e5b47612dabef44a905de6".toLowerCase();
		java.lang.System.out.println(address);
		address = address.substring(2);
		java.math.BigInteger value = new java.math.BigInteger(address, 16);
		java.lang.StringBuilder bban = new java.lang.StringBuilder(value.toString(36).toUpperCase());
		while (bban.length() < (15 * 2)) {
			bban.insert(0, '0');
		} 
		java.lang.System.out.println("bban " + bban);
		java.lang.String iban = "XE00" + bban;
		iban = iban.substring(4) + iban.substring(0, 4);
		java.lang.StringBuilder code = new java.lang.StringBuilder();
		for (int i = 0; i < iban.length(); i++) {
			char chr = iban.charAt(i);
			if ((chr >= 'A') && (chr <= 'Z')) {
				int temp = (chr - 'A') + 10;
				code.append(java.lang.String.valueOf(temp));
			} else {
				code.append(java.lang.String.valueOf(chr - '0'));
			}
		}
		java.lang.String remainder = code.toString();
		java.lang.String block;
		while (remainder.length() > 2) {
			int endPoint = (remainder.length() >= 9) ? 9 : remainder.length();
			block = remainder.substring(0, endPoint);
			remainder = (java.lang.Integer.parseInt(block, 10) % 97) + remainder.substring(block.length());
		} 
		int checkNum = java.lang.Integer.parseInt(remainder, 10) % 97;
		java.lang.String checkDigit = "0" + (98 - checkNum);
		checkDigit = checkDigit.substring(checkDigit.length() - 2);
		java.lang.String IBAN = ("XE" + checkDigit) + bban;
		java.lang.String qrCodeString = ("iban:" + IBAN) + "?token=ETH&amount=5";
		java.lang.System.out.println("IBAN " + IBAN);
		java.lang.System.out.println("验证 " + com.ethjava.IBAN.validateIBAN(IBAN));
		java.lang.System.out.println("qrcode " + qrCodeString);
		com.ethjava.IBAN.decodeQRString(qrCodeString);
	}

	private static boolean validateIBAN(java.lang.String iban) {
		int len = iban.length();
		if ((len < 4) || (!iban.matches("[0-9A-Z]+"))) {
			return false;
		}
		iban = iban.substring(4) + iban.substring(0, 4);
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(java.lang.Character.digit(iban.charAt(i), 36));
		}
		java.math.BigInteger bigInt = new java.math.BigInteger(sb.toString());
		return bigInt.mod(java.math.BigInteger.valueOf(97)).intValue() == 1;
	}

	private static void decodeQRString(java.lang.String result) {
		int ibanEndpoint = result.indexOf("?");
		java.lang.String iban = result.substring(5, ibanEndpoint < 0 ? result.length() : ibanEndpoint);
		java.lang.String address = com.ethjava.IBAN.IBAN2Address(iban);
		java.lang.String query = result.substring(ibanEndpoint + 1, result.length());
		java.lang.String[] params = query.split("&");
		java.lang.String token = null;
		java.lang.String amount = null;
		for (java.lang.String param : params) {
			if (param.startsWith("token=")) {
				token = param.substring(6);
				continue;
			}
			if (param.startsWith("amount=")) {
				amount = param.substring(7);
			}
		}
		java.lang.System.out.println("decodeQRString");
		java.lang.System.out.println("address " + address);
		java.lang.System.out.println("token " + token);
		java.lang.System.out.println("amount " + address);
	}

	private static java.lang.String IBAN2Address(java.lang.String iban) {
		java.lang.String base36 = iban.substring(4);
		java.lang.StringBuilder base16 = new java.lang.StringBuilder(new java.math.BigInteger(base36, 36).toString(16));
		while (base16.length() < 40) {
			base16.insert(0, "0");
		} 
		return "0x" + base16.toString().toLowerCase();
	}
}