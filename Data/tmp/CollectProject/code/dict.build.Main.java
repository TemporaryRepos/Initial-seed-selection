public class Main {
	public static void main(java.lang.String[] args) {
		if (args.length == 0) {
			java.lang.System.out.println("rawpath");
			return;
		}
		java.lang.String rawpath = null;
		if (args.length > 0) {
			rawpath = args[0];
		}
		java.lang.String left = null;
		java.lang.String right = null;
		java.lang.String entropyfile = null;
		dict.build.FastBuilder builder = new dict.build.FastBuilder();
		if (null == right) {
			right = builder.genFreqRight(rawpath, 6, 10 * 1024);
		}
		if (null == left) {
			left = builder.genLeft(rawpath, 6, 10 * 1024);
		}
		if (null == entropyfile) {
			entropyfile = builder.mergeEntropy(right, left);
		}
		builder.extractWords(right, entropyfile);
	}
}