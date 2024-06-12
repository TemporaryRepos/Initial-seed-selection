public class ObserverMain {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap8.ObserverMain.Feed f = new lambdasinaction.chap8.ObserverMain.Feed();
		f.registerObserver(new lambdasinaction.chap8.ObserverMain.NYTimes());
		f.registerObserver(new lambdasinaction.chap8.ObserverMain.Guardian());
		f.registerObserver(new lambdasinaction.chap8.ObserverMain.LeMonde());
		f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
		lambdasinaction.chap8.ObserverMain.Feed feedLambda = new lambdasinaction.chap8.ObserverMain.Feed();
		feedLambda.registerObserver((java.lang.String tweet) -> {
			if ((tweet != null) && tweet.contains("money")) {
				java.lang.System.out.println("Breaking news in NY! " + tweet);
			}
		});
		feedLambda.registerObserver((java.lang.String tweet) -> {
			if ((tweet != null) && tweet.contains("queen")) {
				java.lang.System.out.println("Yet another news in London... " + tweet);
			}
		});
		feedLambda.notifyObservers("Money money money, give me money!");
	}

	interface Observer {
		public abstract void inform(java.lang.String tweet);
	}

	interface Subject {
		public abstract void registerObserver(lambdasinaction.chap8.ObserverMain.Observer o);

		public abstract void notifyObservers(java.lang.String tweet);
	}

	private static class NYTimes implements lambdasinaction.chap8.ObserverMain.Observer {
		@java.lang.Override
		public void inform(java.lang.String tweet) {
			if ((tweet != null) && tweet.contains("money")) {
				java.lang.System.out.println("Breaking news in NY!" + tweet);
			}
		}
	}

	private static class Guardian implements lambdasinaction.chap8.ObserverMain.Observer {
		@java.lang.Override
		public void inform(java.lang.String tweet) {
			if ((tweet != null) && tweet.contains("queen")) {
				java.lang.System.out.println("Yet another news in London... " + tweet);
			}
		}
	}

	private static class LeMonde implements lambdasinaction.chap8.ObserverMain.Observer {
		@java.lang.Override
		public void inform(java.lang.String tweet) {
			if ((tweet != null) && tweet.contains("wine")) {
				java.lang.System.out.println("Today cheese, wine and news! " + tweet);
			}
		}
	}

	private static class Feed implements lambdasinaction.chap8.ObserverMain.Subject {
		private final java.util.List<lambdasinaction.chap8.ObserverMain.Observer> observers = new java.util.ArrayList<>();

		public void registerObserver(lambdasinaction.chap8.ObserverMain.Observer o) {
			this.observers.add(o);
		}

		public void notifyObservers(java.lang.String tweet) {
			observers.forEach(( o) -> o.inform(tweet));
		}
	}
}