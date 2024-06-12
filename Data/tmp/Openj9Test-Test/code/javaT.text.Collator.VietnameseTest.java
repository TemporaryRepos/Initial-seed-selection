public class VietnameseTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.VietnameseTest().run(args);
	}

	private static final java.lang.String[] testPS = new java.lang.String[]{ "a", "a", "Â", "Cz", "d", "e", "e", "ệ", "gz", "i", "kz", "nz", "nh", "o", "o", "Ơ", "pz", "tz", "tr", "u", "u", "y" };

	private static final java.lang.String[] testPT = new java.lang.String[]{ "à", "Ă", "Ă", "Ch", "Đ", "đ", "ẹ", "ẹ", "gi", "Ĩ", "kh", "ng", "ng", "ò", "ô", "ô", "ph", "th", "th", "ụ", "ư", "Ỵ" };

	private static final int[] testPR = new int[]{ 0, -1, 1, 1, -1, 1, 0, 1, 1, 0, 1, 1, 1, 0, -1, 1, 1, 1, 1, 0, -1, 0 };

	private static final java.lang.String[] testT = new java.lang.String[]{ "a", "A", "à", "À", "ả", "Ả", "ã", "Ã", "á", "Á", "ạ", "Ạ", "ă", "Ă", "ằ", "Ằ", "ẳ", "Ẳ", "ẵ", "Ẵ", "ắ", "Ắ", "ặ", "Ặ", "â", "Â", "ầ", "Ầ", "ẩ", "Ẩ", "ẫ", "Ẫ", "ấ", "Ấ", "ậ", "Ậ", "b", "B", "c", "C", "ch", "Ch", "CH", "d", "D", "đ", "Đ", "e", "E", "è", "È", "ẻ", "Ẻ", "ẽ", "Ẽ", "é", "É", "ẹ", "Ẹ", "ê", "Ê", "ề", "Ề", "ể", "Ể", "ễ", "Ễ", "ế", "Ế", "ệ", "Ệ", "f", "F", "g", "G", "gi", "Gi", "GI", "gz", "h", "H", "i", "I", "ì", "Ì", "ỉ", "Ỉ", "ĩ", "Ĩ", "í", "Í", "ị", "Ị", "j", "J", "k", "K", "kh", "Kh", "KH", "kz", "l", "L", "m", "M", "n", "N", "ng", "Ng", "NG", "ngz", "nh", "Nh", "NH", "nz", "o", "O", "ò", "Ò", "ỏ", "Ỏ", "õ", "Õ", "ó", "Ó", "ọ", "Ọ", "ô", "Ô", "ồ", "Ồ", "ổ", "Ổ", "ỗ", "Ỗ", "ố", "Ố", "ộ", "Ộ", "ơ", "Ơ", "ờ", "Ờ", "ở", "Ở", "ỡ", "Ỡ", "ớ", "Ớ", "ợ", "Ợ", "p", "P", "ph", "Ph", "PH", "pz", "q", "Q", "r", "R", "s", "S", "t", "T", "th", "Th", "TH", "thz", "tr", "Tr", "TR", "tz", "u", "U", "ù", "Ù", "ủ", "Ủ", "ũ", "Ũ", "ú", "Ú", "ụ", "Ụ", "ư", "Ư", "ừ", "Ừ", "ử", "Ử", "ữ", "Ữ", "ứ", "Ứ", "ự", "Ự", "v", "V", "w", "W", "x", "X", "y", "Y", "ỳ", "Ỳ", "ỷ", "Ỷ", "ỹ", "Ỹ", "ý", "Ý", "ỵ", "Ỵ", "z", "Z" };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.VietnameseTest.testPS, javaT.text.Collator.VietnameseTest.testPT, javaT.text.Collator.VietnameseTest.testPR);
	}

	public void TestTertiary() {
		int testLength = javaT.text.Collator.VietnameseTest.testT.length;
		myCollation.setStrength(java.text.Collator.TERTIARY);
		for (int i = 0; i < (testLength - 1); i++) {
			for (int j = i + 1; j < testLength; j++) {
				doTest(myCollation, javaT.text.Collator.VietnameseTest.testT[i], javaT.text.Collator.VietnameseTest.testT[j], -1);
			}
		}
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("vi", "VN"));
}