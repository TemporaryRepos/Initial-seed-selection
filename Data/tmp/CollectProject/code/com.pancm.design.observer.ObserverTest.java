public class ObserverTest {
	public static void main(java.lang.String[] args) {
		java.lang.String name1 = "张三";
		java.lang.String name2 = "xuwujing";
		java.lang.String bingguo = "冰菓";
		java.lang.String fate = "fate/zero";
		com.pancm.design.observer.BangumiSubject bs1 = new com.pancm.design.observer.Bangumi(bingguo);
		com.pancm.design.observer.BangumiSubject bs2 = new com.pancm.design.observer.Bangumi(fate);
		com.pancm.design.observer.UserObserver uo1 = new com.pancm.design.observer.User(name1);
		com.pancm.design.observer.UserObserver uo2 = new com.pancm.design.observer.User(name2);
		bs1.toThem(uo1);
		bs1.toThem(uo2);
		bs2.toThem(uo1);
		bs2.toThem(uo2);
		bs1.notifyUser();
		bs2.notifyUser();
		bs1.callOff(uo1);
		bs2.callOff(uo2);
		bs1.notifyUser();
		bs2.notifyUser();
	}
}