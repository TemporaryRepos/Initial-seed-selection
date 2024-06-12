public class AdapterTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.adapter.Mp4 mp4 = new com.pancm.design.adapter.VideoPlayer();
		mp4.playMp4();
		com.pancm.design.adapter.Avi avi = new com.pancm.design.adapter.FormatFactory();
		avi.playAvi();
		com.pancm.design.adapter.Rvmb rvmb = new com.pancm.design.adapter.FormatFactory2(new com.pancm.design.adapter.VideoPlayer());
		rvmb.playRvmb();
	}
}