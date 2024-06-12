public class ConsoleDecompiler implements org.jetbrains.java.decompiler.main.extern.IBytecodeProvider , org.jetbrains.java.decompiler.main.extern.IResultSaver {
	@java.lang.SuppressWarnings("UseOfSystemOutOrSystemErr")
	public static void main(java.lang.String[] args) {
		if (args.length < 2) {
			java.lang.System.out.println("Usage: java -jar fernflower.jar [-<option>=<value>]* [<source>]+ <destination>\n" + "Example: java -jar fernflower.jar -dgs=true c:\\my\\source\\ c:\\my.jar d:\\decompiled\\");
			return;
		}
		java.util.Map<java.lang.String, java.lang.Object> mapOptions = new java.util.HashMap<>();
		java.util.List<java.io.File> sources = new java.util.ArrayList<>();
		java.util.List<java.io.File> libraries = new java.util.ArrayList<>();
		boolean isOption = true;
		for (int i = 0; i < (args.length - 1); ++i) {
			java.lang.String arg = args[i];
			if (((isOption && (arg.length() > 5)) && (arg.charAt(0) == '-')) && (arg.charAt(4) == '=')) {
				java.lang.String value = arg.substring(5);
				if ("true".equalsIgnoreCase(value)) {
					value = "1";
				} else if ("false".equalsIgnoreCase(value)) {
					value = "0";
				}
				mapOptions.put(arg.substring(1, 4), value);
			} else {
				isOption = false;
				if (arg.startsWith("-e=")) {
					org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler.addPath(libraries, arg.substring(3));
				} else {
					org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler.addPath(sources, arg);
				}
			}
		}
		if (sources.isEmpty()) {
			java.lang.System.out.println("error: no sources given");
			return;
		}
		java.io.File destination = new java.io.File(args[args.length - 1]);
		if (!destination.isDirectory()) {
			java.lang.System.out.println(("error: destination '" + destination) + "' is not a directory");
			return;
		}
		org.jetbrains.java.decompiler.main.decompiler.PrintStreamLogger logger = new org.jetbrains.java.decompiler.main.decompiler.PrintStreamLogger(java.lang.System.out);
		org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler decompiler = new org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler(destination, mapOptions, logger);
		for (java.io.File library : libraries) {
			decompiler.addLibrary(library);
		}
		for (java.io.File source : sources) {
			decompiler.addSource(source);
		}
		decompiler.decompileContext();
	}

	@java.lang.SuppressWarnings("UseOfSystemOutOrSystemErr")
	private static void addPath(java.util.List<? super java.io.File> list, java.lang.String path) {
		java.io.File file = new java.io.File(path);
		if (file.exists()) {
			list.add(file);
		} else {
			java.lang.System.out.println(("warn: missing '" + path) + "', ignored");
		}
	}

	private final java.io.File root;

	private final org.jetbrains.java.decompiler.main.Fernflower engine;

	private final java.util.Map<java.lang.String, java.util.zip.ZipOutputStream> mapArchiveStreams = new java.util.HashMap<>();

	private final java.util.Map<java.lang.String, java.util.Set<java.lang.String>> mapArchiveEntries = new java.util.HashMap<>();

	protected ConsoleDecompiler(java.io.File destination, java.util.Map<java.lang.String, java.lang.Object> options, org.jetbrains.java.decompiler.main.extern.IFernflowerLogger logger) {
		root = destination;
		engine = new org.jetbrains.java.decompiler.main.Fernflower(this, this, options, logger);
	}

	public void addSource(java.io.File source) {
		engine.addSource(source);
	}

	public void addLibrary(java.io.File library) {
		engine.addLibrary(library);
	}

	public void decompileContext() {
		try {
			engine.decompileContext();
		} finally {
			engine.clearContext();
		}
	}

	@java.lang.Override
	public byte[] getBytecode(java.lang.String externalPath, java.lang.String internalPath) throws java.io.IOException {
		java.io.File file = new java.io.File(externalPath);
		if (internalPath == null) {
			return org.jetbrains.java.decompiler.util.InterpreterUtil.getBytes(file);
		} else {
			try (final java.util.zip.ZipFile archive = new java.util.zip.ZipFile(file)) {
				java.util.zip.ZipEntry entry = archive.getEntry(internalPath);
				if (entry == null) {
					throw new java.io.IOException("Entry not found: " + internalPath);
				}
				return org.jetbrains.java.decompiler.util.InterpreterUtil.getBytes(archive, entry);
			}
		}
	}

	private java.lang.String getAbsolutePath(java.lang.String path) {
		return new java.io.File(root, path).getAbsolutePath();
	}

	@java.lang.Override
	public void saveFolder(java.lang.String path) {
		java.io.File dir = new java.io.File(getAbsolutePath(path));
		if (!(dir.mkdirs() || dir.isDirectory())) {
			throw new java.lang.RuntimeException("Cannot create directory " + dir);
		}
	}

	@java.lang.Override
	public void copyFile(java.lang.String source, java.lang.String path, java.lang.String entryName) {
		try {
			org.jetbrains.java.decompiler.util.InterpreterUtil.copyFile(new java.io.File(source), new java.io.File(getAbsolutePath(path), entryName));
		} catch (java.io.IOException ex) {
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage((("Cannot copy " + source) + " to ") + entryName, ex);
		}
	}

	@java.lang.Override
	public void saveClassFile(java.lang.String path, java.lang.String qualifiedName, java.lang.String entryName, java.lang.String content, int[] mapping) {
		java.io.File file = new java.io.File(getAbsolutePath(path), entryName);
		try (final java.io.Writer out = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), java.nio.charset.StandardCharsets.UTF_8)) {
			out.write(content);
		} catch (java.io.IOException ex) {
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage("Cannot write class file " + file, ex);
		}
	}

	@java.lang.Override
	public void createArchive(java.lang.String path, java.lang.String archiveName, java.util.jar.Manifest manifest) {
		java.io.File file = new java.io.File(getAbsolutePath(path), archiveName);
		try {
			if (!(file.createNewFile() || file.isFile())) {
				throw new java.io.IOException("Cannot create file " + file);
			}
			java.io.FileOutputStream fileStream = new java.io.FileOutputStream(file);
			java.util.zip.ZipOutputStream zipStream = (manifest != null) ? new java.util.jar.JarOutputStream(fileStream, manifest) : new java.util.zip.ZipOutputStream(fileStream);
			mapArchiveStreams.put(file.getPath(), zipStream);
		} catch (java.io.IOException ex) {
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage("Cannot create archive " + file, ex);
		}
	}

	@java.lang.Override
	public void saveDirEntry(java.lang.String path, java.lang.String archiveName, java.lang.String entryName) {
		saveClassEntry(path, archiveName, null, entryName, null);
	}

	@java.lang.Override
	public void copyEntry(java.lang.String source, java.lang.String path, java.lang.String archiveName, java.lang.String entryName) {
		java.lang.String file = new java.io.File(getAbsolutePath(path), archiveName).getPath();
		if (!checkEntry(entryName, file)) {
			return;
		}
		try (final java.util.zip.ZipFile srcArchive = new java.util.zip.ZipFile(new java.io.File(source))) {
			java.util.zip.ZipEntry entry = srcArchive.getEntry(entryName);
			if (entry != null) {
				try (final java.io.InputStream in = srcArchive.getInputStream(entry)) {
					java.util.zip.ZipOutputStream out = mapArchiveStreams.get(file);
					out.putNextEntry(new java.util.zip.ZipEntry(entryName));
					org.jetbrains.java.decompiler.util.InterpreterUtil.copyStream(in, out);
				}
			}
		} catch (java.io.IOException ex) {
			java.lang.String message = (((("Cannot copy entry " + entryName) + " from ") + source) + " to ") + file;
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage(message, ex);
		}
	}

	@java.lang.Override
	public void saveClassEntry(java.lang.String path, java.lang.String archiveName, java.lang.String qualifiedName, java.lang.String entryName, java.lang.String content) {
		java.lang.String file = new java.io.File(getAbsolutePath(path), archiveName).getPath();
		if (!checkEntry(entryName, file)) {
			return;
		}
		try {
			java.util.zip.ZipOutputStream out = mapArchiveStreams.get(file);
			out.putNextEntry(new java.util.zip.ZipEntry(entryName));
			if (content != null) {
				out.write(content.getBytes(java.nio.charset.StandardCharsets.UTF_8));
			}
		} catch (java.io.IOException ex) {
			java.lang.String message = (("Cannot write entry " + entryName) + " to ") + file;
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage(message, ex);
		}
	}

	private boolean checkEntry(java.lang.String entryName, java.lang.String file) {
		java.util.Set<java.lang.String> set = mapArchiveEntries.computeIfAbsent(file, ( k) -> new java.util.HashSet<>());
		boolean added = set.add(entryName);
		if (!added) {
			java.lang.String message = (("Zip entry " + entryName) + " already exists in ") + file;
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage(message, org.jetbrains.java.decompiler.main.extern.IFernflowerLogger.Severity.WARN);
		}
		return added;
	}

	@java.lang.Override
	public void closeArchive(java.lang.String path, java.lang.String archiveName) {
		java.lang.String file = new java.io.File(getAbsolutePath(path), archiveName).getPath();
		try {
			mapArchiveEntries.remove(file);
			mapArchiveStreams.remove(file).close();
		} catch (java.io.IOException ex) {
			org.jetbrains.java.decompiler.main.DecompilerContext.getLogger().writeMessage("Cannot close " + file, org.jetbrains.java.decompiler.main.extern.IFernflowerLogger.Severity.WARN);
		}
	}
}