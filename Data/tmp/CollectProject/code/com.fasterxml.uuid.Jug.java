public class Jug {
	protected static final java.util.HashMap<java.lang.String, java.lang.String> TYPES = new java.util.HashMap<java.lang.String, java.lang.String>();

	static {
		TYPES.put("time-based", "t");
		TYPES.put("random-based", "r");
		TYPES.put("name-based", "n");
		TYPES.put("reordered-time-based", "o");
		TYPES.put("epoch-time-based", "e");
	}

	protected static final java.util.HashMap<java.lang.String, java.lang.String> OPTIONS = new java.util.HashMap<java.lang.String, java.lang.String>();

	static {
		OPTIONS.put("count", "c");
		OPTIONS.put("ethernet-address", "e");
		OPTIONS.put("help", "h");
		OPTIONS.put("namespace", "s");
		OPTIONS.put("name", "n");
		OPTIONS.put("performance", "p");
		OPTIONS.put("verbose", "v");
	}

	protected static void printUsage() {
		java.lang.String clsName = com.fasterxml.uuid.Jug.class.getName();
		java.lang.System.err.println(("Usage: java " + clsName) + " [options] type");
		java.lang.System.err.println("Where options are:");
		java.lang.System.err.println("  --count / -c <number>: will generate <number> UUIDs (default: 1)");
		java.lang.System.err.println("  --ethernet-address / -e <ether-address>: defines the ethernet address");
		java.lang.System.err.println("    (in xx:xx:xx:xx:xx:xx notation, usually obtained using 'ifconfig' etc)");
		java.lang.System.err.println("    to use with time-based UUID generation");
		java.lang.System.err.println("  --help / -h: lists the usage (ie. what you see now)");
		java.lang.System.err.println("  --name / -n: specifies");
		java.lang.System.err.println("     o name for name-based UUID generation");
		java.lang.System.err.println("     o 'information' part of tag-URI for tag-URI UUID generation");
		java.lang.System.err.println("  --namespace / -s: specifies");
		java.lang.System.err.println("    o the namespace (DNS or URL) for name-based UUID generation");
		java.lang.System.err.println("    o 'authority' part of tag-URI for tag-URI UUID generation;");
		java.lang.System.err.println("        (fully-qualified domain name, email address)");
		java.lang.System.err.println("  --performance / -p: measure time it takes to generate UUID(s).");
		java.lang.System.err.println("    [note that UUIDs are not printed out unless 'verbose' is also specified]");
		java.lang.System.err.println("  --verbose / -v: lists additional information about UUID generation\n    (by default only UUIDs are printed out (to make it usable in scripts)");
		java.lang.System.err.println("And type is one of:");
		java.lang.System.err.println("  time-based / t: generate UUID based on current time and optional\n    location information (defined with -e option)");
		java.lang.System.err.println("  random-based / r: generate UUID based on the default secure random number generator");
		java.lang.System.err.println("  name-based / n: generate UUID based on MD5 hash of given String ('name')");
		java.lang.System.err.println("  reordered-time-based / o: generate UUID based on current time and optional\n    location information (defined with -e option)");
		java.lang.System.err.println("  epoch-based / e: generate UUID based on current time (as 'epoch') and random number");
	}

	private static void printMap(java.util.Map<java.lang.String, java.lang.String> m, java.io.PrintStream out, boolean option) {
		int i = 0;
		int len = m.size();
		for (java.util.Map.Entry<java.lang.String, java.lang.String> en : m.entrySet()) {
			if ((++i) > 1) {
				if (i < len) {
					out.print(", ");
				} else {
					out.print(" and ");
				}
			}
			if (option) {
				out.print("--");
			}
			out.print(en.getKey());
			out.print(" (");
			if (option) {
				out.print("-");
			}
			out.print(en.getValue());
			out.print(")");
		}
	}

	public static void main(java.lang.String[] args) {
		if (args.length == 0) {
			com.fasterxml.uuid.Jug.printUsage();
			return;
		}
		int count = args.length;
		java.lang.String type = args[count - 1];
		boolean verbose = false;
		int genCount = 1;
		java.lang.String name = null;
		java.lang.String nameSpace = null;
		com.fasterxml.uuid.EthernetAddress addr = null;
		boolean performance = false;
		--count;
		java.lang.String tmp = ((java.lang.String) (com.fasterxml.uuid.Jug.TYPES.get(type)));
		if (tmp == null) {
			if (!com.fasterxml.uuid.Jug.TYPES.containsValue(type)) {
				java.lang.System.err.println(("Unrecognized UUID generation type '" + type) + "'; currently available ones are:");
				com.fasterxml.uuid.Jug.printMap(com.fasterxml.uuid.Jug.TYPES, java.lang.System.err, false);
				java.lang.System.err.println();
				java.lang.System.exit(1);
			}
		} else {
			type = tmp;
		}
		com.fasterxml.uuid.NoArgGenerator noArgGenerator = null;
		com.fasterxml.uuid.StringArgGenerator nameArgGenerator = null;
		for (int i = 0; i < count; ++i) {
			java.lang.String opt = args[i];
			if ((opt.length() == 0) || (opt.charAt(0) != '-')) {
				java.lang.System.err.println(("Unrecognized option '" + opt) + "' (missing leading hyphen?), exiting.");
				java.lang.System.exit(1);
			}
			char option = ((char) (0));
			if (opt.startsWith("--")) {
				java.lang.String o = ((java.lang.String) (com.fasterxml.uuid.Jug.OPTIONS.get(opt.substring(2))));
				if (o != null) {
					option = o.charAt(0);
				}
			} else if (com.fasterxml.uuid.Jug.OPTIONS.containsValue(opt.substring(1))) {
				option = opt.charAt(1);
			}
			if (option == ((char) (0))) {
				java.lang.System.err.println(("Unrecognized option '" + opt) + "'; exiting.");
				java.lang.System.err.print("[options currently available are: ");
				com.fasterxml.uuid.Jug.printMap(com.fasterxml.uuid.Jug.OPTIONS, java.lang.System.err, true);
				java.lang.System.err.println("]");
				java.lang.System.exit(1);
			}
			try {
				java.lang.String next;
				switch (option) {
					case 'c' :
						next = args[++i];
						try {
							genCount = java.lang.Integer.parseInt(next);
						} catch (java.lang.NumberFormatException nex) {
							java.lang.System.err.println(("Invalid number argument for option '" + opt) + "', exiting.");
							java.lang.System.exit(1);
						}
						if (genCount < 1) {
							java.lang.System.err.println(("Invalid number argument for option '" + opt) + "'; negative numbers not allowed, ignoring (defaults to 1).");
						}
						break;
					case 'e' :
						next = args[++i];
						try {
							addr = com.fasterxml.uuid.EthernetAddress.valueOf(next);
						} catch (java.lang.NumberFormatException nex) {
							java.lang.System.err.println((("Invalid ethernet address for option '" + opt) + "', error: ") + nex.toString());
							java.lang.System.exit(1);
						}
						break;
					case 'h' :
						com.fasterxml.uuid.Jug.printUsage();
						return;
					case 'n' :
						name = args[++i];
						break;
					case 'p' :
						performance = true;
						break;
					case 's' :
						nameSpace = args[++i];
						break;
					case 'v' :
						verbose = true;
						break;
				}
			} catch (java.lang.IndexOutOfBoundsException ie) {
				java.lang.System.err.println(("Missing argument for option '" + opt) + "', exiting.");
				java.lang.System.exit(1);
			}
		}
		char typeC = type.charAt(0);
		java.util.UUID nsUUID = null;
		boolean usesRnd = false;
		switch (typeC) {
			case 't' :
			case 'o' :
				usesRnd = true;
				if (addr == null) {
					if (verbose) {
						java.lang.System.out.print("(no address specified, generating dummy address: ");
					}
					addr = com.fasterxml.uuid.EthernetAddress.constructMulticastAddress(new java.util.Random(java.lang.System.currentTimeMillis()));
					if (verbose) {
						java.lang.System.out.print(addr.toString());
						java.lang.System.out.println(")");
					}
				}
				noArgGenerator = (typeC == 't') ? com.fasterxml.uuid.Generators.timeBasedGenerator(addr) : com.fasterxml.uuid.Generators.timeBasedReorderedGenerator(addr);
				break;
			case 'r' :
				usesRnd = true;
				{
					java.security.SecureRandom r = new java.security.SecureRandom();
					if (verbose) {
						java.lang.System.out.print(("(using secure random generator, info = '" + r.getProvider().getInfo()) + "')");
					}
					noArgGenerator = com.fasterxml.uuid.Generators.randomBasedGenerator(r);
				}
				break;
			case 'e' :
				usesRnd = true;
				{
					java.security.SecureRandom r = new java.security.SecureRandom();
					if (verbose) {
						java.lang.System.out.print(("(using secure random generator, info = '" + r.getProvider().getInfo()) + "')");
					}
					noArgGenerator = com.fasterxml.uuid.Generators.timeBasedEpochGenerator(r);
				}
				break;
			case 'n' :
				if (nameSpace == null) {
					java.lang.System.err.println("--name-space (-s) - argument missing when using method that requires it, exiting.");
					java.lang.System.exit(1);
				}
				if (name == null) {
					java.lang.System.err.println("--name (-n) - argument missing when using method that requires it, exiting.");
					java.lang.System.exit(1);
				}
				if (typeC == 'n') {
					java.lang.String orig = nameSpace;
					nameSpace = nameSpace.toLowerCase();
					if (nameSpace.equals("url")) {
						nsUUID = com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_URL;
					} else if (nameSpace.equals("dns")) {
						nsUUID = com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_DNS;
					} else {
						java.lang.System.err.println(("Unrecognized namespace '" + orig) + "'; only DNS and URL allowed for name-based generation.");
						java.lang.System.exit(1);
					}
				}
				nameArgGenerator = com.fasterxml.uuid.Generators.nameBasedGenerator(nsUUID);
				break;
		}
		if (verbose) {
			java.lang.System.out.println();
		}
		long now = 0L;
		if (performance) {
			if (usesRnd) {
				if (verbose) {
					java.lang.System.out.println("(initializing random number generator before UUID generation so that performance measurements are not skewed due to one-time init costs)");
				}
				noArgGenerator.generate();
				if (verbose) {
					java.lang.System.out.println("(random number generator initialized ok)");
				}
			}
			now = java.lang.System.currentTimeMillis();
		}
		for (int i = 0; i < genCount; ++i) {
			java.util.UUID uuid = (nameArgGenerator == null) ? noArgGenerator.generate() : nameArgGenerator.generate(name);
			if (verbose) {
				java.lang.System.out.print("UUID: ");
			}
			if ((!performance) || verbose) {
				java.lang.System.out.println(uuid.toString());
			}
		}
		if (verbose) {
			java.lang.System.out.println("Done.");
		}
		if (performance) {
			now = java.lang.System.currentTimeMillis() - now;
			long avg = ((now * 10) + (genCount / 2)) / genCount;
			java.lang.System.out.println(((((((("Performance: took " + now) + " milliseconds to generate (and print out) ") + genCount) + " UUIDs; average being ") + (avg / 10)) + ".") + (avg % 10)) + " msec.");
		}
	}
}