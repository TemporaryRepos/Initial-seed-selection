public class MediatorTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.mediator.JavaQQqun jq = new com.pancm.design.mediator.JavaQQqun();
		com.pancm.design.mediator.ZhangSan zs = new com.pancm.design.mediator.ZhangSan("张三", jq);
		com.pancm.design.mediator.XuWuJing xwj = new com.pancm.design.mediator.XuWuJing("xuwujing", jq);
		jq.setZs(zs);
		jq.setXwj(xwj);
		zs.exchange("大家好！我是张三!");
		xwj.exchange("欢迎你！张三！");
	}
}