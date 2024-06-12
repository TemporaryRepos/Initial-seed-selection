public class ReactorStudy {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Main thread:" + java.lang.Thread.currentThread());
		rx.Scheduler scheduler = rx.schedulers.Schedulers.trampoline();
		try {
			for (int i = 0; i < 10; i++) {
				java.lang.Thread.sleep(100);
			}
		} catch (java.lang.InterruptedException e) {
			e.printStackTrace();
		}
		rx.Observable<java.lang.String> test = rx.Observable.from(new java.lang.String[]{ "this", "is", "a", "test", "one", "two", "three" }).subscribeOn(scheduler);
		rx.Observable<java.lang.String> gettys = rx.Observable.from(new java.lang.String[]{ "four", "score", "and", "seven", "years", "ago" }).subscribeOn(scheduler);
		{
			java.lang.System.out.println("1111111111111publish");
			rx.observables.ConnectableObservable<java.lang.String> testPublish = test.publish();
			rx.observables.ConnectableObservable<java.lang.String> gettysPublish = gettys.publish();
			testPublish.subscribe(( x1) -> java.lang.System.out.println((x1 + " ... ") + java.lang.Thread.currentThread()));
			gettysPublish.subscribe(( x1) -> java.lang.System.out.println((x1 + " ... ") + java.lang.Thread.currentThread()));
			testPublish.zipWith(gettysPublish, ( x, y) -> (x + "-") + y).subscribe(( x1) -> {
				java.lang.System.out.println((x1 + "...") + java.lang.Thread.currentThread());
			});
			testPublish.connect();
			gettysPublish.connect();
		}
		{
			java.lang.System.out.println("22222222222222222 non publish");
			test.subscribe(( x1) -> java.lang.System.out.println((x1 + " ... ") + java.lang.Thread.currentThread()));
			gettys.subscribe(( x1) -> java.lang.System.out.println((x1 + " ... ") + java.lang.Thread.currentThread()));
			test.zipWith(gettys, ( x, y) -> (x + "-") + y).subscribe(( x1) -> {
				java.lang.System.out.println((x1 + "...") + java.lang.Thread.currentThread());
			});
		}
	}
}