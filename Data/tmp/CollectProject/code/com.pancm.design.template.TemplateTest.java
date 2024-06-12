public class TemplateTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.template.Game game = new com.pancm.design.template.ContraGame();
		game.play();
		java.lang.System.out.println();
		game = new com.pancm.design.template.TMNTGame();
		game.play();
	}
}