class AffineCipher {
	static int a = 17;

	static int b = 20;

	static java.lang.String encryptMessage(char[] msg) {
		java.lang.String cipher = "";
		for (int i = 0; i < msg.length; i++) {
			if (msg[i] != ' ') {
				cipher = cipher + ((char) ((((com.thealgorithms.ciphers.AffineCipher.a * (msg[i] - 'A')) + com.thealgorithms.ciphers.AffineCipher.b) % 26) + 'A'));
			} else {
				cipher += msg[i];
			}
		}
		return cipher;
	}

	static java.lang.String decryptCipher(java.lang.String cipher) {
		java.lang.String msg = "";
		int a_inv = 0;
		int flag = 0;
		for (int i = 0; i < 26; i++) {
			flag = (com.thealgorithms.ciphers.AffineCipher.a * i) % 26;
			if (flag == 1) {
				a_inv = i;
			}
		}
		for (int i = 0; i < cipher.length(); i++) {
			if (cipher.charAt(i) != ' ') {
				msg = msg + ((char) (((a_inv * ((cipher.charAt(i) + 'A') - com.thealgorithms.ciphers.AffineCipher.b)) % 26) + 'A'));
			} else {
				msg += cipher.charAt(i);
			}
		}
		return msg;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String msg = "AFFINE CIPHER";
		java.lang.String cipherText = com.thealgorithms.ciphers.AffineCipher.encryptMessage(msg.toCharArray());
		java.lang.System.out.println("Encrypted Message is : " + cipherText);
		java.lang.System.out.println("Decrypted Message is: " + com.thealgorithms.ciphers.AffineCipher.decryptCipher(cipherText));
	}
}