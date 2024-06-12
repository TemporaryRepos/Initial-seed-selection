public class version {
	public static void main(java.lang.String[] args) {
		java.lang.String version = org.zeromq.ZMQ.getVersionString();
		int fullVersion = org.zeromq.ZMQ.getFullVersion();
		java.lang.System.out.printf("Version string: %s, Version int: %d%n", version, fullVersion);
	}
}