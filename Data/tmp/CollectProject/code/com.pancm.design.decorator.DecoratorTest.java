public class DecoratorTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.decorator.Model gundam = new com.pancm.design.decorator.GUNDAM();
		com.pancm.design.decorator.Model mrgu = new com.pancm.design.decorator.MrGu();
		gundam.assemble();
		mrgu.assemble();
		com.pancm.design.decorator.Model gModel = new com.pancm.design.decorator.LightSaber(new com.pancm.design.decorator.GUNDAM());
		gModel.assemble();
		com.pancm.design.decorator.Model mModel = new com.pancm.design.decorator.RocketLauncher(new com.pancm.design.decorator.MrGu());
		mModel.assemble();
	}
}