public class MyFingerprint implements java.lang.Comparable<org.nlpcn.commons.lang.finger.pojo.MyFingerprint> {
	private java.lang.String name;

	private double score = 0;

	private double weight = 0;

	public MyFingerprint(java.lang.String name, double freq, double factory) {
		this.name = name;
		this.weight = -java.lang.Math.log(10000 / (freq + 1));
		this.score = weight * factory;
	}

	public void updateScore(double factor) {
		this.score += factor * weight;
	}

	public java.lang.String getName() {
		return name;
	}

	public double getScore() {
		return score;
	}

	@java.lang.Override
	public int compareTo(org.nlpcn.commons.lang.finger.pojo.MyFingerprint myTag) {
		if (this.score < myTag.score) {
			return -1;
		}
		return 1;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return ((this.name + ":") + ":") + score;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("aaa".length() == "aaa".getBytes().length);
	}
}