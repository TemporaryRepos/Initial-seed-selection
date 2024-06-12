public class Game {
	public static void main(java.lang.String... args) {
		java.util.List<lambdasinaction.chap9.Resizable> resizableShapes = java.util.Arrays.asList(new lambdasinaction.chap9.Square(), new lambdasinaction.chap9.Triangle(), new lambdasinaction.chap9.Ellipse());
		lambdasinaction.chap9.Utils.paint(resizableShapes);
	}
}