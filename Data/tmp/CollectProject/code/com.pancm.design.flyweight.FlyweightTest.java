public class FlyweightTest {
	public static void main(java.lang.String[] args) {
		java.lang.String[] names = new java.lang.String[]{ "张三", "李四", "王五", "虚无境" };
		for (int i = 0; i < 8; i++) {
			com.pancm.design.flyweight.Penil penil = com.pancm.design.flyweight.PenFactory.get(names[i > 3 ? i - 4 : i]);
			penil.setSomething("画了一条鱼");
			penil.write();
		}
	}
}