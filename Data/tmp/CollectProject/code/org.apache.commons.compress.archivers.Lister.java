public final class Lister {
	private static final org.apache.commons.compress.archivers.ArchiveStreamFactory factory = new org.apache.commons.compress.archivers.ArchiveStreamFactory();

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length == 0) {
			org.apache.commons.compress.archivers.Lister.usage();
			return;
		}
		java.lang.System.out.println("Analysing " + args[0]);
		java.io.File f = new java.io.File(args[0]);
		if (!f.isFile()) {
			java.lang.System.err.println(f + " doesn't exist or is a directory");
		}
		java.io.InputStream fis = new java.io.BufferedInputStream(new java.io.FileInputStream(f));
		org.apache.commons.compress.archivers.ArchiveInputStream ais;
		if (args.length > 1) {
			ais = org.apache.commons.compress.archivers.Lister.factory.createArchiveInputStream(args[1], fis);
		} else {
			ais = org.apache.commons.compress.archivers.Lister.factory.createArchiveInputStream(fis);
		}
		java.lang.System.out.println("Created " + ais.toString());
		org.apache.commons.compress.archivers.ArchiveEntry ae;
		while ((ae = ais.getNextEntry()) != null) {
			java.lang.System.out.println(ae.getName());
		} 
		ais.close();
		fis.close();
	}

	private static void usage() {
		java.lang.System.out.println("Parameters: archive-name [archive-type]");
	}
}