public class CricketScorer {
	private int score;

	public void four() {
		score = score + 4;
	}

	public void six() {
		score = score + 6;
	}

	public int getScore() {
		return score;
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.basics.CricketScorer scorer = new com.in28minutes.java.basics.CricketScorer();
		scorer.six();
		scorer.four();
		java.lang.System.out.println(scorer.getScore());
	}
}