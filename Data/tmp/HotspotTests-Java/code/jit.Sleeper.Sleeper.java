class Sleeper {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("1");
		try {
			java.lang.Thread.sleep(1000);
		} catch (java.lang.InterruptedException e) {
		}
		java.lang.System.out.println("2");
		try {
			java.lang.Thread.sleep(1000);
		} catch (java.lang.InterruptedException e) {
		}
		java.lang.System.out.println("3");
		try {
			java.lang.Thread.sleep(1000);
		} catch (java.lang.InterruptedException e) {
		}
		java.lang.System.out.println("4");
	}
}