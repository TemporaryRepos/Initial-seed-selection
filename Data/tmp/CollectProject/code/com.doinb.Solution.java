class Solution {
	public static void main(java.lang.String[] args) {
		java.lang.Double sendLimit = 5.0;
		java.lang.Double threshold = 2.0;
		int finalSendLimit = 0;
		int tmp = sendLimit.intValue() % threshold.intValue();
		if (tmp == 0) {
			finalSendLimit = sendLimit.intValue();
		} else {
			int tmpRound = sendLimit.intValue() / threshold.intValue();
			finalSendLimit = threshold.intValue() * (tmpRound + 1);
		}
		java.lang.System.out.println(finalSendLimit);
	}

	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		for (int i = length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int length1 = digits.length;
		int[] temp = new int[length + 1];
		temp[0] = 1;
		return temp;
	}

	public static int singleNumber(int[] nums) {
		int rest = 6 ^ 3;
		java.lang.System.out.println(rest);
		int ret = 0;
		for (int num : nums) {
			java.lang.System.out.println("异或运算ret=" + ret);
			ret = ret ^ num;
		}
		return ret;
	}
}