public class Idle extends java.lang.Thread {
	class IdleConfiguration {
		public long runTimeMs = 10000;

		public boolean verbose = false;

		public boolean useIdleReader = true;

		public void parseArgs(java.lang.String[] args) {
			try {
				for (int i = 0; i < args.length; ++i) {
					if (args[i].equals("-v")) {
						config.verbose = true;
					} else if (args[i].equals("-n")) {
						config.useIdleReader = false;
					} else if (args[i].equals("-t")) {
						runTimeMs = java.lang.Long.parseLong(args[++i]);
					} else {
						throw new java.lang.Exception("Invalid args");
					}
				}
			} catch (java.lang.Exception e) {
				java.lang.System.err.println("Usage: java Idle [-v] [-n] [-t runTimeMs]");
				java.lang.System.exit(1);
			}
		}
	}

	org.jhiccup.Idle.IdleConfiguration config = new org.jhiccup.Idle.IdleConfiguration();

	class IdleReader extends java.lang.Thread {
		IdleReader() {
			this.setDaemon(true);
			this.setName("IdleReader");
			this.start();
		}

		public void run() {
			try {
				while (java.lang.System.in.read() >= 0) {
				} 
				java.lang.System.exit(1);
			} catch (java.lang.Exception e) {
				java.lang.System.exit(1);
			}
		}
	}

	public Idle() throws java.io.FileNotFoundException {
	}

	public Idle(java.lang.String[] args) throws java.io.FileNotFoundException {
		config.parseArgs(args);
	}

	public void terminate() {
		this.interrupt();
	}

	public void run() {
		if (config.useIdleReader) {
			new org.jhiccup.Idle.IdleReader();
		}
		try {
			if (config.verbose) {
				java.lang.System.out.println(("Idling for " + config.runTimeMs) + "msec...");
			}
			long startTime = java.lang.System.currentTimeMillis();
			while ((config.runTimeMs == 0) || (config.runTimeMs > (java.lang.System.currentTimeMillis() - startTime))) {
				java.lang.Thread.sleep(100);
			} 
		} catch (java.lang.InterruptedException e) {
			if (config.verbose) {
				java.lang.System.out.println("Idle terminating...");
			}
		}
	}

	public static void main(java.lang.String[] args) {
		try {
			org.jhiccup.Idle idler = new org.jhiccup.Idle(args);
			if (idler.config.verbose) {
				java.lang.System.out.print("Executing: idler");
				for (java.lang.String arg : args) {
					java.lang.System.out.print(" " + arg);
				}
				java.lang.System.out.println("");
			}
			idler.start();
			try {
				idler.join();
			} catch (java.lang.InterruptedException e) {
				if (idler.config.verbose) {
					java.lang.System.out.println("idler main() interrupted");
				}
			}
		} catch (java.io.FileNotFoundException e) {
			java.lang.System.err.println("Failed to open log file.");
		}
	}
}