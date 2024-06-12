public class BridgeTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.bridge.Paper paper = new com.pancm.design.bridge.ExaminationPaper();
		paper.setPen(new com.pancm.design.bridge.RedPen());
		paper.writing();
		com.pancm.design.bridge.Paper paper2 = new com.pancm.design.bridge.NewsPaper();
		paper2.setPen(new com.pancm.design.bridge.BlackPen());
		paper2.writing();
	}
}