public class InterpreterTest {
	public static void main(java.lang.String[] args) {
		java.lang.String word = "好好学习，天天向上!";
		com.pancm.design.interpreter.Expreeion expreeion = new com.pancm.design.interpreter.BaiduExpreeion();
		com.pancm.design.interpreter.Expreeion expreeion2 = new com.pancm.design.interpreter.YouDaoExpreeion();
		com.pancm.design.interpreter.Expreeion expreeion3 = new com.pancm.design.interpreter.XuWuJingExpreeion();
		expreeion.interpert(word);
		expreeion2.interpert(word);
		expreeion3.interpert(word);
	}
}