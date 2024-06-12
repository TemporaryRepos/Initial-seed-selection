public class JugglerSequence {
	public static void jugglerSequence(int inputNumber) {
		int n = inputNumber;
		java.util.List<java.lang.String> seq = new java.util.ArrayList<>();
		seq.add(n + "");
		while (n != 1) {
			int temp;
			if ((n % 2) == 0) {
				temp = ((int) (java.lang.Math.floor(java.lang.Math.sqrt(n))));
			} else {
				temp = ((int) (java.lang.Math.floor((java.lang.Math.sqrt(n) * java.lang.Math.sqrt(n)) * java.lang.Math.sqrt(n))));
			}
			n = temp;
			seq.add(n + "");
		} 
		java.lang.String res = java.lang.String.join(",", seq);
		java.lang.System.out.println(res);
	}

	public static void main(java.lang.String[] args) {
		com.thealgorithms.maths.JugglerSequence.jugglerSequence(3);
	}
}