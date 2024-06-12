public class StateTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.state.Headset hs = new com.pancm.design.state.Headset(new com.pancm.design.state.PlayState());
		hs.press();
		hs.press();
		hs.press();
	}
}