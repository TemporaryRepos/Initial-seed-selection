public class FactoryTest {
	private static final java.lang.String LOL = "LOL";

	private static final java.lang.String DNF = "DNF";

	public static void main(java.lang.String[] args) {
		com.pancm.design.factory.Game game = com.pancm.design.factory.ComputerFactory.playGame(com.pancm.design.factory.FactoryTest.LOL);
		com.pancm.design.factory.Game game2 = com.pancm.design.factory.ComputerFactory.playGame(com.pancm.design.factory.FactoryTest.DNF);
		game.play();
		game2.play();
		com.pancm.design.factory.Game game3 = new com.pancm.design.factory.LOLFactory().playGame();
		com.pancm.design.factory.Game game4 = new com.pancm.design.factory.DNFFactory().playGame();
		com.pancm.design.factory.Game game5 = new com.pancm.design.factory.WOWFactory().playGame();
		game3.play();
		game4.play();
		game5.play();
		com.pancm.design.factory.ComputerFactory3 cf3 = new com.pancm.design.factory.PVPFactory();
		cf3.playGame().play();
		cf3.playGame2().play();
		com.pancm.design.factory.ComputerFactory3 cf4 = new com.pancm.design.factory.PVEFactory();
		cf4.playGame().play();
		cf4.playGame2().play();
	}
}