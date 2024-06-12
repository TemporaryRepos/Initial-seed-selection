public class TestKATForGCM {
	private static byte[] HexToBytes(java.lang.String hexVal) {
		if (hexVal == null) {
			return new byte[0];
		}
		byte[] result = new byte[hexVal.length() / 2];
		for (int i = 0; i < result.length; i++) {
			java.lang.String byteVal = hexVal.substring(2 * i, (2 * i) + 2);
			result[i] = java.lang.Integer.valueOf(byteVal, 16).byteValue();
		}
		return result;
	}

	private static class TestVector {
		javax.crypto.SecretKey key;

		byte[] plainText;

		byte[] aad;

		byte[] cipherText;

		byte[] tag;

		javax.crypto.spec.GCMParameterSpec spec;

		java.lang.String info;

		TestVector(java.lang.String key, java.lang.String iv, java.lang.String pt, java.lang.String aad, java.lang.String ct, java.lang.String tag) {
			this.key = new javax.crypto.spec.SecretKeySpec(com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(key), "AES");
			this.plainText = com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(pt);
			this.aad = com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(aad);
			this.cipherText = com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(ct);
			this.tag = com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(tag);
			this.spec = new javax.crypto.spec.GCMParameterSpec(this.tag.length * 8, com.sun.crypto.provider.Cipher.AES.TestKATForGCM.HexToBytes(iv));
			this.info = (((((((((("key=" + key) + ", iv=") + iv) + ", pt=") + pt) + ",aad=") + aad) + ", ct=") + ct) + ", tag=") + tag;
		}

		public java.lang.String toString() {
			return info;
		}
	}

	private static com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector[] testValues = new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector[]{ new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("11754cd72aec309bf52f7687212e8957", "3c819d9a9bed087615030b65", null, null, null, "250327c674aaf477aef2675748cf6971"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("272f16edb81a7abbea887357a58c1917", "794ec588176c703d3d2a7a07", null, null, null, "b6e6f197168f5049aeda32dafbdaeb"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("81b6844aab6a568c4556a2eb7eae752f", "ce600f59618315a6829bef4d", null, null, null, "89b43e9dbc1b4f597dbbc7655bb5"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("cde2f9a9b1a004165ef9dc981f18651b", "29512c29566c7322e1e33e8e", null, null, null, "2e58ce7dabd107c82759c66a75"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("b01e45cc3088aaba9fa43d81d481823f", "5a2c4a66468713456a4bd5e1", null, null, null, "014280f944f53c681164b2ff"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("77be63708971c4e240d1cb79e8d77feb", "e0e00f19fed7ba0136a797f3", null, "7a43ec1d9c0a5a78a0b16533a6213cab", null, "209fcc8d3675ed938e9c7166709dd946"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("da0b615656135194ba6d3c851099bc48", "d39d4b4d3cc927885090e6c3", null, "e7e5e6f8dac913036cb2ff29e8625e0e", null, "ab967711a5770461724460b07237e2"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("7e0986937a88eef894235aba4a2f43b2", "92c4a631695907166b422d60", null, "85c185f8518f9f2cd597a8f9208fc76b", null, "3bb916b728df94fe9d1916736be1"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("c3db570d7f0c21e86b028f11465d1dc9", "f86970f58ceef89fc7cb679e", null, "c095240708c0f57c288d86090ae34ee1", null, "e043c52160d652e82c7262fcf4"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("bea48ae4980d27f357611014d4486625", "32bddb5c3aa998a08556454c", null, "8a50b0b8c7654bced884f7f3afda2ead", null, "8e0f6d8bf05ffebe6f500eb1"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("2fb45e5b8f993a2bfebc4b15b533e0b4", "5b05755f984d2b90f94b8027", null, "e85491b2202caf1d7dce03b97e09331c32473941", null, "c75b7832b2a2d9bd827412b6ef5769db"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("9bf406339fcef9675bbcf156aa1a0661", "8be4a9543d40f542abacac95", null, "7167cbf56971793186333a6685bbd58d47d379b3", null, "5e7968d7bbd5ba58cfcc750e2ef8f1"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("a2e962fff70fd0f4d63be728b80556fc", "1fa7103483de43d09bc23db4", null, "2a58edf1d53f46e4e7ee5e77ee7aeb60fc360658", null, "fa37f2dbbefab1451eae1d0d74ca"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("6bf4fdce82926dcdfc52616ed5f23695", "cc0f5899a10615567e1193ed", null, "3340655592374c1da2f05aac3ee111014986107f", null, "8ad3385cce3b5e7c985908192c"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("4df7a13e43c3d7b66b1a72fac5ba398e", "97179a3a2d417908dcf0fb28", null, "cbb7fc0010c255661e23b07dbd804b1e06ae70ac", null, "37791edae6c137ea946cfb40"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("fe9bb47deb3a61e423c2231841cfd1fb", "4d328eb776f500a2f7fb47aa", "f1cc3818e421876bb6b8bbd6c9", null, "b88c5c1977b35b517b0aeae967", "43fd4727fe5cdb4b5b42818dea7ef8c9"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("7fddb57453c241d03efbed3ac44e371c", "ee283a3fc75575e33efd4887", "d5de42b461646c255c87bd2962d3b9a2", null, "2ccda4a5415cb91e135c2a0f78c9b2fd", "b36d1df9b9d5e596f83e8b7f52971cb3"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("9971071059abc009e4f2bd69869db338", "07a9a95ea3821e9c13c63251", "f54bc3501fed4f6f6dfb5ea80106df0bd836e6826225b75c0222f6e859b35983", null, "0556c159f84ef36cb1602b4526b12009c775611bffb64dc0d9ca9297cd2c6a01", "7870d9117f54811a346970f1de090c41"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("594157ec4693202b030f33798b07176d", "49b12054082660803a1df3df", "3feef98a976a1bd634f364ac428bb59cd51fb159ec1789946918dbd50ea6c9d594a3a31a5269b0da6936c29d063a5fa2cc8a1c", null, "c1b7a46a335f23d65b8db4008a49796906e225474f4fe7d39e55bf2efd97fd82d4167de082ae30fa01e465a601235d8d68bc69", "ba92d3661ce8b04687e8788d55417dc2"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("c939cc13397c1d37de6ae0e1cb7c423c", "b3d8cc017cbb89b39e0f67e2", "c3b3c41f113a31b73d9a5cd432103069", "24825602bd12a984e0092d3e448eda5f", "93fe7d9e9bfd10348a5606e5cafa7354", "0032a1dc85f1c9786925a2e71d8272dd"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("d4a22488f8dd1d5c6c19a7d6ca17964c", "f3d5837f22ac1a0425e0d1d5", "7b43016a16896497fb457be6d2a54122", "f1c5d424b83f96c6ad8cb28ca0d20e475e023b5a", "c2bd67eef5e95cac27e3b06e3031d0a8", "f23eacf9d1cdf8737726c58648826e9c"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("89850dd398e1f1e28443a33d40162664", "e462c58482fe8264aeeb7231", "2805cdefb3ef6cc35cd1f169f98da81a", "d74e99d1bdaa712864eec422ac507bddbe2b0d4633cd3dff29ce5059b49fe868526c59a2a3a604457bc2afea866e7606", "ba80e244b7fc9025cd031d0f63677e06", "d84a8c3eac57d1bb0e890a8f461d1065"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("bd7c5c63b7542b56a00ebe71336a1588", "87721f23ba9c3c8ea5571abc", "de15ddbb1e202161e8a79af6a55ac6f3", "a6ec8075a0d3370eb7598918f3b93e48444751624997b899a87fa6a9939f844e008aa8b70e9f4c3b1a19d3286bf543e7127bfecba1ad17a5ec53fccc26faecacc4c75369498eaa7d706aef634d0009279b11e4ba6c993e5e9ed9", "41eb28c0fee4d762de972361c863bc80", "9cb567220d0b252eb97bff46e4b00ff8"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("1672c3537afa82004c6b8a46f6f0d026", "05", null, null, null, "8e2ad721f9455f74d8b53d3141f27e8e"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("d0f1f4defa1e8c08b4b26d576392027c", "42b4f01eb9f5a1ea5b1eb73b0fb0baed54f387ecaa0393c7d7dffc6af50146ecc021abf7eb9038d4303d91f8d741a11743166c0860208bcc02c6258fd9511a2fa626f96d60b72fcff773af4e88e7a923506e4916ecbd814651e9f445adef4ad6a6b6c7290cc13b956130eef5b837c939fcac0cbbcc9656cd75b13823ee5acdac", null, null, null, "7ab49b57ddf5f62c427950111c5c4f0d"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("9f79239f0904eace50784b863e723f6b", "d9", "bdb0bb10c87965acd34d146171", "44db436089327726c5f01139e1f339735c9e85514ccc2f167bad728010fb34a9072a9794c8a5e7361b1d0dbcdc9ac4091e354bb2896561f0486645252e9c78c86beece91bfa4f7cc4a8794ce1f305b1b735efdbf1ed1563c0be0", "7e5a7c8dadb3f0c7335b4d9d8d", "6b6ef1f53723a89f3bb7c6d043840717"), new com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector("141f1ce91989b07e7eb6ae1dbd81ea5e", "49451da24bd6074509d3cebc2c0394c972e6934b45a1d91f3ce1d3ca69e194aa1958a7c21b6f21d530ce6d2cc5256a3f846b6f9d2f38df0102c4791e57df038f6e69085646007df999751e248e06c47245f4cd3b8004585a7470dee1690e9d2d63169a58d243c0b57b3e5b4a481a3e4e8c60007094ef3adea2e8f05dd3a1396f", "d384305af2388699aa302f510913fed0f2cb63ba42efa8c5c9de2922a2ec2fe87719dadf1eb0aef212b51e74c9c5b934104a43", "630cf18a91cc5a6481ac9eefd65c24b1a3c93396bd7294d6b8ba323951727666c947a21894a079ef061ee159c05beeb4", "f4c34e5fbe74c0297313268296cd561d59ccc95bbfcdfcdc71b0097dbd83240446b28dc088abd42b0fc687f208190ff24c0548", "dbb93bbb56d0439cd09f620a57687f5d") };

	public boolean execute(com.sun.crypto.provider.Cipher.AES.TestKATForGCM.TestVector[] testValues) throws java.lang.Exception {
		boolean testFailed = false;
		javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding", "SunJCE");
		for (int i = 0; i < testValues.length; i++) {
			try {
				c.init(javax.crypto.Cipher.ENCRYPT_MODE, testValues[i].key, testValues[i].spec);
				c.updateAAD(testValues[i].aad);
				byte[] ctPlusTag = c.doFinal(testValues[i].plainText);
				c.init(javax.crypto.Cipher.DECRYPT_MODE, testValues[i].key, testValues[i].spec);
				c.updateAAD(testValues[i].aad);
				byte[] pt = c.doFinal(ctPlusTag);
				if (!java.util.Arrays.equals(testValues[i].plainText, pt)) {
					java.lang.System.out.println("PlainText diff failed for test# " + i);
					testFailed = true;
				}
				int ctLen = testValues[i].cipherText.length;
				if (!java.util.Arrays.equals(testValues[i].cipherText, java.util.Arrays.copyOf(ctPlusTag, ctLen))) {
					java.lang.System.out.println("CipherText diff failed for test# " + i);
					testFailed = true;
				}
				int tagLen = testValues[i].tag.length;
				if (!java.util.Arrays.equals(testValues[i].tag, java.util.Arrays.copyOfRange(ctPlusTag, ctLen, ctLen + tagLen))) {
					java.lang.System.out.println("Tag diff failed for test# " + i);
					testFailed = true;
				}
			} catch (java.lang.Exception ex) {
				java.lang.System.out.println("Failed Test Vector: " + testValues[i]);
				ex.printStackTrace();
				testFailed = true;
				continue;
			}
		}
		if (testFailed) {
			throw new java.lang.Exception("Test Failed");
		}
		return true;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.crypto.provider.Cipher.AES.TestKATForGCM test = new com.sun.crypto.provider.Cipher.AES.TestKATForGCM();
		if (test.execute(com.sun.crypto.provider.Cipher.AES.TestKATForGCM.testValues)) {
			java.lang.System.out.println("Test Passed!");
		}
	}
}