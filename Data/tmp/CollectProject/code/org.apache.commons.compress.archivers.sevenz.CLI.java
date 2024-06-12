public class CLI {
	private static final byte[] BUF = new byte[8192];

	private static enum Mode {

		LIST("Analysing") {
			@java.lang.Override
			public void takeAction(org.apache.commons.compress.archivers.sevenz.SevenZFile archive, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry entry) {
				java.lang.System.out.print(entry.getName());
				if (entry.isDirectory()) {
					java.lang.System.out.print(" dir");
				} else {
					java.lang.System.out.print(((" " + entry.getCompressedSize()) + "/") + entry.getSize());
				}
				if (entry.getHasLastModifiedDate()) {
					java.lang.System.out.print(" " + entry.getLastModifiedDate());
				} else {
					java.lang.System.out.print(" no last modified date");
				}
				if (!entry.isDirectory()) {
					java.lang.System.out.println(" " + getContentMethods(entry));
				} else {
					java.lang.System.out.println("");
				}
			}

			private java.lang.String getContentMethods(org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry entry) {
				java.lang.StringBuilder sb = new java.lang.StringBuilder();
				boolean first = true;
				for (org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration m : entry.getContentMethods()) {
					if (!first) {
						sb.append(", ");
					}
					first = false;
					sb.append(m.getMethod());
					if (m.getOptions() != null) {
						sb.append("(").append(m.getOptions()).append(")");
					}
				}
				return sb.toString();
			}
		},
		EXTRACT("Extracting") {
			@java.lang.Override
			public void takeAction(org.apache.commons.compress.archivers.sevenz.SevenZFile archive, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry entry) throws java.io.IOException {
				java.io.File outFile = new java.io.File(entry.getName());
				if (entry.isDirectory()) {
					if ((!outFile.isDirectory()) && (!outFile.mkdirs())) {
						throw new java.io.IOException("Cannot create directory " + outFile);
					}
					java.lang.System.out.println("created directory " + outFile);
					return;
				}
				java.lang.System.out.println("extracting to " + outFile);
				java.io.File parent = outFile.getParentFile();
				if (((parent != null) && (!parent.exists())) && (!parent.mkdirs())) {
					throw new java.io.IOException("Cannot create " + parent);
				}
				java.io.FileOutputStream fos = new java.io.FileOutputStream(outFile);
				try {
					final long total = entry.getSize();
					long off = 0;
					while (off < total) {
						int toRead = ((int) (java.lang.Math.min(total - off, org.apache.commons.compress.archivers.sevenz.CLI.BUF.length)));
						int bytesRead = archive.read(org.apache.commons.compress.archivers.sevenz.CLI.BUF, 0, toRead);
						if (bytesRead < 1) {
							throw new java.io.IOException((((("reached end of entry " + entry.getName()) + " after ") + off) + " bytes, expected ") + total);
						}
						off += bytesRead;
						fos.write(org.apache.commons.compress.archivers.sevenz.CLI.BUF, 0, bytesRead);
					} 
				} finally {
					fos.close();
				}
			}
		};
		private final java.lang.String message;

		private Mode(java.lang.String message) {
			this.message = message;
		}

		public java.lang.String getMessage() {
			return message;
		}

		public abstract void takeAction(org.apache.commons.compress.archivers.sevenz.SevenZFile archive, org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry entry) throws java.io.IOException;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length == 0) {
			org.apache.commons.compress.archivers.sevenz.CLI.usage();
			return;
		}
		org.apache.commons.compress.archivers.sevenz.CLI.Mode mode = org.apache.commons.compress.archivers.sevenz.CLI.grabMode(args);
		java.lang.System.out.println((mode.getMessage() + " ") + args[0]);
		java.io.File f = new java.io.File(args[0]);
		if (!f.isFile()) {
			java.lang.System.err.println(f + " doesn't exist or is a directory");
		}
		org.apache.commons.compress.archivers.sevenz.SevenZFile archive = new org.apache.commons.compress.archivers.sevenz.SevenZFile(f);
		try {
			org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry ae;
			while ((ae = archive.getNextEntry()) != null) {
				mode.takeAction(archive, ae);
			} 
		} finally {
			archive.close();
		}
	}

	private static void usage() {
		java.lang.System.out.println("Parameters: archive-name [list|extract]");
	}

	private static org.apache.commons.compress.archivers.sevenz.CLI.Mode grabMode(java.lang.String[] args) {
		if (args.length < 2) {
			return org.apache.commons.compress.archivers.sevenz.CLI.Mode.LIST;
		}
		return java.lang.Enum.valueOf(org.apache.commons.compress.archivers.sevenz.CLI.Mode.class, args[1].toUpperCase());
	}
}