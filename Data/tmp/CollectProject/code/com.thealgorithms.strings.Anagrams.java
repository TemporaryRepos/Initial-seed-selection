public class Anagrams {
	public static void main(java.lang.String[] args) {
		java.lang.String first = "deal";
		java.lang.String second = "lead";
		com.thealgorithms.strings.Anagrams nm = new com.thealgorithms.strings.Anagrams();
		java.lang.System.out.println(nm.approach2(first, second));
		java.lang.System.out.println(nm.approach1(first, second));
		java.lang.System.out.println(nm.approach3(first, second));
		java.lang.System.out.println(nm.approach4(first, second));
	}

	boolean approach1(java.lang.String s, java.lang.String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			char[] c = s.toCharArray();
			char[] d = t.toCharArray();
			java.util.Arrays.sort(c);
			java.util.Arrays.sort(d);
			return java.util.Arrays.equals(c, d);
		}
	}

	boolean approach2(java.lang.String a, java.lang.String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			int[] m = new int[26];
			int[] n = new int[26];
			for (char c : a.toCharArray()) {
				m[c - 'a']++;
			}
			for (char c : b.toCharArray()) {
				n[c - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (m[i] != n[i]) {
					return false;
				}
			}
			return true;
		}
	}

	boolean approach3(java.lang.String s, java.lang.String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			int[] a = new int[26];
			int[] b = new int[26];
			int k = s.length();
			for (int i = 0; i < k; i++) {
				a[s.charAt(i) - 'a']++;
				b[t.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
			return true;
		}
	}

	boolean approach4(java.lang.String s, java.lang.String t) {
		if (s.length() != t.length()) {
			return false;
		} else {
			java.util.HashMap<java.lang.Character, java.lang.Integer> nm = new java.util.HashMap<>();
			java.util.HashMap<java.lang.Character, java.lang.Integer> kk = new java.util.HashMap<>();
			for (char c : s.toCharArray()) {
				nm.put(c, nm.getOrDefault(c, 0) + 1);
			}
			for (char c : t.toCharArray()) {
				kk.put(c, kk.getOrDefault(c, 0) + 1);
			}
			return nm.equals(kk);
		}
	}

	boolean approach5(java.lang.String s, java.lang.String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int pos1 = s.charAt(i) - 'a';
			int pos2 = s.charAt(i) - 'a';
			freq[pos1]++;
			freq[pos2]--;
		}
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}
}