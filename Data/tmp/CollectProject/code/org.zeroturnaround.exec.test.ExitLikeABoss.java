public class ExitLikeABoss {
	public static void main(java.lang.String[] args) {
		int exitCode = 0;
		if (args.length > 0) {
			try {
				exitCode = java.lang.Integer.parseInt(args[0]);
			} catch (java.lang.NumberFormatException e) {
				java.lang.System.out.println("Please provide valid exit code as parameter");
			}
		}
		java.lang.System.exit(exitCode);
	}
}