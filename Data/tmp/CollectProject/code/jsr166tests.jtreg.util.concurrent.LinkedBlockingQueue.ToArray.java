public class ToArray {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		java.util.Collection<java.lang.Integer> c = new java.util.concurrent.LinkedBlockingQueue<java.lang.Integer>();
		if (c.toArray(new java.lang.Integer[]{ 42 })[0] != null) {
			throw new java.lang.Error("should be null");
		}
	}
}