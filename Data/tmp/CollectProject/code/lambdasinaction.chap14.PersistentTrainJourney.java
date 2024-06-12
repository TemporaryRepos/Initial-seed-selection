public class PersistentTrainJourney {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney tj1 = new lambdasinaction.chap14.PersistentTrainJourney.TrainJourney(40, new lambdasinaction.chap14.PersistentTrainJourney.TrainJourney(30, null));
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney tj2 = new lambdasinaction.chap14.PersistentTrainJourney.TrainJourney(20, new lambdasinaction.chap14.PersistentTrainJourney.TrainJourney(50, null));
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney appended = lambdasinaction.chap14.PersistentTrainJourney.append(tj1, tj2);
		lambdasinaction.chap14.PersistentTrainJourney.visit(appended, ( tj) -> {
			java.lang.System.out.print(tj.price + " - ");
		});
		java.lang.System.out.println();
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney appended2 = lambdasinaction.chap14.PersistentTrainJourney.append(tj1, tj2);
		lambdasinaction.chap14.PersistentTrainJourney.visit(appended2, ( tj) -> {
			java.lang.System.out.print(tj.price + " - ");
		});
		java.lang.System.out.println();
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney linked = lambdasinaction.chap14.PersistentTrainJourney.link(tj1, tj2);
		lambdasinaction.chap14.PersistentTrainJourney.visit(linked, ( tj) -> {
			java.lang.System.out.print(tj.price + " - ");
		});
		java.lang.System.out.println();
	}

	static class TrainJourney {
		public int price;

		public lambdasinaction.chap14.PersistentTrainJourney.TrainJourney onward;

		public TrainJourney(int p, lambdasinaction.chap14.PersistentTrainJourney.TrainJourney t) {
			price = p;
			onward = t;
		}
	}

	static lambdasinaction.chap14.PersistentTrainJourney.TrainJourney link(lambdasinaction.chap14.PersistentTrainJourney.TrainJourney a, lambdasinaction.chap14.PersistentTrainJourney.TrainJourney b) {
		if (a == null) {
			return b;
		}
		lambdasinaction.chap14.PersistentTrainJourney.TrainJourney t = a;
		while (t.onward != null) {
			t = t.onward;
		} 
		t.onward = b;
		return a;
	}

	static lambdasinaction.chap14.PersistentTrainJourney.TrainJourney append(lambdasinaction.chap14.PersistentTrainJourney.TrainJourney a, lambdasinaction.chap14.PersistentTrainJourney.TrainJourney b) {
		return a == null ? b : new lambdasinaction.chap14.PersistentTrainJourney.TrainJourney(a.price, lambdasinaction.chap14.PersistentTrainJourney.append(a.onward, b));
	}

	static void visit(lambdasinaction.chap14.PersistentTrainJourney.TrainJourney journey, java.util.function.Consumer<lambdasinaction.chap14.PersistentTrainJourney.TrainJourney> c) {
		if (journey != null) {
			c.accept(journey);
			lambdasinaction.chap14.PersistentTrainJourney.visit(journey.onward, c);
		}
	}
}