public class MeaningOfThis {
	public final int value = 4;

	public void doIt() {
		int value = 6;
		java.lang.Runnable r = new java.lang.Runnable() {
			public final int value = 5;

			public void run() {
				int value = 10;
				java.lang.System.out.println(this.value);
			}
		};
		r.run();
	}

	public static void main(java.lang.String... args) {
		lambdasinaction.chap2.MeaningOfThis m = new lambdasinaction.chap2.MeaningOfThis();
		m.doIt();
	}
}