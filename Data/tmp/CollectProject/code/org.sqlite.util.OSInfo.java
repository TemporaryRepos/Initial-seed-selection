public class OSInfo {
	protected static org.sqlite.util.ProcessRunner processRunner = new org.sqlite.util.ProcessRunner();

	private static final java.util.HashMap<java.lang.String, java.lang.String> archMapping = new java.util.HashMap<>();

	public static final java.lang.String X86 = "x86";

	public static final java.lang.String X86_64 = "x86_64";

	public static final java.lang.String IA64_32 = "ia64_32";

	public static final java.lang.String IA64 = "ia64";

	public static final java.lang.String PPC = "ppc";

	public static final java.lang.String PPC64 = "ppc64";

	static {
		archMapping.put(X86, X86);
		archMapping.put("i386", X86);
		archMapping.put("i486", X86);
		archMapping.put("i586", X86);
		archMapping.put("i686", X86);
		archMapping.put("pentium", X86);
		archMapping.put(X86_64, X86_64);
		archMapping.put("amd64", X86_64);
		archMapping.put("em64t", X86_64);
		archMapping.put("universal", X86_64);
		archMapping.put(IA64, IA64);
		archMapping.put("ia64w", IA64);
		archMapping.put(IA64_32, IA64_32);
		archMapping.put("ia64n", IA64_32);
		archMapping.put(PPC, PPC);
		archMapping.put("power", PPC);
		archMapping.put("powerpc", PPC);
		archMapping.put("power_pc", PPC);
		archMapping.put("power_rs", PPC);
		archMapping.put(PPC64, PPC64);
		archMapping.put("power64", PPC64);
		archMapping.put("powerpc64", PPC64);
		archMapping.put("power_pc64", PPC64);
		archMapping.put("power_rs64", PPC64);
		archMapping.put("ppc64el", PPC64);
		archMapping.put("ppc64le", PPC64);
	}

	public static void main(java.lang.String[] args) {
		if (args.length >= 1) {
			if ("--os".equals(args[0])) {
				java.lang.System.out.print(org.sqlite.util.OSInfo.getOSName());
				return;
			} else if ("--arch".equals(args[0])) {
				java.lang.System.out.print(org.sqlite.util.OSInfo.getArchName());
				return;
			}
		}
		java.lang.System.out.print(org.sqlite.util.OSInfo.getNativeLibFolderPathForCurrentOS());
	}

	public static java.lang.String getNativeLibFolderPathForCurrentOS() {
		return (org.sqlite.util.OSInfo.getOSName() + "/") + org.sqlite.util.OSInfo.getArchName();
	}

	public static java.lang.String getOSName() {
		return org.sqlite.util.OSInfo.translateOSNameToFolderName(java.lang.System.getProperty("os.name"));
	}

	public static boolean isAndroid() {
		return org.sqlite.util.OSInfo.isAndroidRuntime() || org.sqlite.util.OSInfo.isAndroidTermux();
	}

	public static boolean isAndroidRuntime() {
		return java.lang.System.getProperty("java.runtime.name", "").toLowerCase().contains("android");
	}

	public static boolean isAndroidTermux() {
		try {
			return org.sqlite.util.OSInfo.processRunner.runAndWaitFor("uname -o").toLowerCase().contains("android");
		} catch (java.lang.Exception ignored) {
			return false;
		}
	}

	public static boolean isMusl() {
		java.nio.file.Path mapFilesDir = java.nio.file.Paths.get("/proc/self/map_files");
		try (final java.util.stream.Stream<java.nio.file.Path> dirStream = java.nio.file.Files.list(mapFilesDir)) {
			return dirStream.map(( path) -> {
				try {
					return path.toRealPath().toString();
				} catch (java.io.IOException e) {
					return "";
				}
			}).anyMatch(( s) -> s.toLowerCase().contains("musl"));
		} catch (java.lang.Exception ignored) {
			return org.sqlite.util.OSInfo.isAlpineLinux();
		}
	}

	private static boolean isAlpineLinux() {
		try (final java.util.stream.Stream<java.lang.String> osLines = java.nio.file.Files.lines(java.nio.file.Paths.get("/etc/os-release"))) {
			return osLines.anyMatch(( l) -> l.startsWith("ID") && l.contains("alpine"));
		} catch (java.lang.Exception ignored2) {
		}
		return false;
	}

	static java.lang.String getHardwareName() {
		try {
			return org.sqlite.util.OSInfo.processRunner.runAndWaitFor("uname -m");
		} catch (java.lang.Throwable e) {
			org.sqlite.util.OSInfo.LogHolder.logger.error("Error while running uname -m", e);
			return "unknown";
		}
	}

	static java.lang.String resolveArmArchType() {
		if (java.lang.System.getProperty("os.name").contains("Linux")) {
			java.lang.String armType = org.sqlite.util.OSInfo.getHardwareName();
			if (org.sqlite.util.OSInfo.isAndroid()) {
				if (armType.startsWith("aarch64")) {
					return "aarch64";
				} else {
					return "arm";
				}
			}
			if (armType.startsWith("armv6")) {
				return "armv6";
			} else if (armType.startsWith("armv7")) {
				return "armv7";
			} else if (armType.startsWith("armv5")) {
				return "arm";
			} else if (armType.startsWith("aarch64")) {
				return "aarch64";
			}
			java.lang.String abi = java.lang.System.getProperty("sun.arch.abi");
			if ((abi != null) && abi.startsWith("gnueabihf")) {
				return "armv7";
			}
			java.lang.String javaHome = java.lang.System.getProperty("java.home");
			try {
				int exitCode = java.lang.Runtime.getRuntime().exec("which readelf").waitFor();
				if (exitCode == 0) {
					java.lang.String[] cmdarray = new java.lang.String[]{ "/bin/sh", "-c", (("find '" + javaHome) + "' -name 'libjvm.so' | head -1 | xargs readelf -A | ") + "grep 'Tag_ABI_VFP_args: VFP registers'" };
					exitCode = java.lang.Runtime.getRuntime().exec(cmdarray).waitFor();
					if (exitCode == 0) {
						return "armv7";
					}
				} else {
					org.sqlite.util.OSInfo.LogHolder.logger.warn("readelf not found. Cannot check if running on an armhf system, armel architecture will be presumed");
				}
			} catch (java.io.IOException | java.lang.InterruptedException e) {
			}
		}
		return "arm";
	}

	public static java.lang.String getArchName() {
		java.lang.String override = java.lang.System.getProperty("org.sqlite.osinfo.architecture");
		if (override != null) {
			return override;
		}
		java.lang.String osArch = java.lang.System.getProperty("os.arch");
		if (osArch.startsWith("arm")) {
			osArch = org.sqlite.util.OSInfo.resolveArmArchType();
		} else {
			java.lang.String lc = osArch.toLowerCase(java.util.Locale.US);
			if (org.sqlite.util.OSInfo.archMapping.containsKey(lc)) {
				return org.sqlite.util.OSInfo.archMapping.get(lc);
			}
		}
		return org.sqlite.util.OSInfo.translateArchNameToFolderName(osArch);
	}

	static java.lang.String translateOSNameToFolderName(java.lang.String osName) {
		if (osName.contains("Windows")) {
			return "Windows";
		} else if (osName.contains("Mac") || osName.contains("Darwin")) {
			return "Mac";
		} else if (osName.contains("AIX")) {
			return "AIX";
		} else if (org.sqlite.util.OSInfo.isMusl()) {
			return "Linux-Musl";
		} else if (org.sqlite.util.OSInfo.isAndroid()) {
			return "Linux-Android";
		} else if (osName.contains("Linux")) {
			return "Linux";
		} else {
			return osName.replaceAll("\\W", "");
		}
	}

	static java.lang.String translateArchNameToFolderName(java.lang.String archName) {
		return archName.replaceAll("\\W", "");
	}

	private static class LogHolder {
		private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(org.sqlite.util.OSInfo.class);
	}
}