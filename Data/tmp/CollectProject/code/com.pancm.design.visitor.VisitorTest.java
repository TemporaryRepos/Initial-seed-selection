public class VisitorTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.visitor.ObjectStructure os = new com.pancm.design.visitor.ObjectStructure();
		os.add(new com.pancm.design.visitor.Games());
		os.add(new com.pancm.design.visitor.Photos());
		com.pancm.design.visitor.Visitor visitor = new com.pancm.design.visitor.ZhangSan();
		os.action(visitor);
	}
}