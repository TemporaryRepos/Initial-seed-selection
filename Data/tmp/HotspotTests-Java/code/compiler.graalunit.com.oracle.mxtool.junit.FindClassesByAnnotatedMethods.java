public class FindClassesByAnnotatedMethods {
	public static void main(java.lang.String... args) throws java.lang.Throwable {
		java.util.Set<java.lang.String> qualifiedAnnotations = new java.util.HashSet<>();
		java.util.Set<java.lang.String> unqualifiedAnnotations = new java.util.HashSet<>();
		for (java.lang.String arg : args) {
			if (compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.isAnnotationArg(arg)) {
				java.lang.String annotation = arg.substring(1);
				int lastDot = annotation.lastIndexOf('.');
				if (lastDot != (-1)) {
					qualifiedAnnotations.add(annotation);
				} else {
					java.lang.String unqualifed = annotation.substring(lastDot + 1);
					unqualifiedAnnotations.add(unqualifed);
				}
			}
		}
		for (java.lang.String jarFilePath : args) {
			if (compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.isSnippetArg(jarFilePath) || compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.isAnnotationArg(jarFilePath)) {
				continue;
			}
			java.util.jar.JarFile jarFile = new java.util.jar.JarFile(jarFilePath);
			java.util.Enumeration<java.util.jar.JarEntry> e = jarFile.entries();
			int unsupportedClasses = 0;
			java.lang.System.out.print(jarFilePath);
			while (e.hasMoreElements()) {
				java.util.jar.JarEntry je = e.nextElement();
				if (je.isDirectory() || (!je.getName().endsWith(".class"))) {
					continue;
				}
				java.util.Set<java.lang.String> methodAnnotationTypes = new java.util.HashSet<>();
				java.io.DataInputStream stream = new java.io.DataInputStream(new java.io.BufferedInputStream(jarFile.getInputStream(je), ((int) (je.getSize()))));
				boolean isSupported = true;
				try {
					compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readClassfile(stream, methodAnnotationTypes);
				} catch (java.lang.UnsupportedClassVersionError ucve) {
					isSupported = false;
					unsupportedClasses++;
				}
				java.lang.String className = je.getName().substring(0, je.getName().length() - ".class".length()).replaceAll("/", ".");
				if (!isSupported) {
					java.lang.System.out.print(" !" + className);
				}
				for (java.lang.String annotationType : methodAnnotationTypes) {
					if (!qualifiedAnnotations.isEmpty()) {
						if (qualifiedAnnotations.contains(annotationType)) {
							java.lang.System.out.print(" " + className);
						}
					}
					if (!unqualifiedAnnotations.isEmpty()) {
						final int lastDot = annotationType.lastIndexOf('.');
						if (lastDot != (-1)) {
							java.lang.String simpleName = annotationType.substring(lastDot + 1);
							int lastDollar = simpleName.lastIndexOf('$');
							if (lastDollar != (-1)) {
								simpleName = simpleName.substring(lastDollar + 1);
							}
							if (unqualifiedAnnotations.contains(simpleName)) {
								java.lang.System.out.print(" " + className);
							}
						}
					}
				}
			} 
			if (unsupportedClasses != 0) {
				java.lang.System.err.printf("Warning: %d classes in %s skipped as their class file version is not supported by %s%n", unsupportedClasses, jarFilePath, compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.class.getSimpleName());
			}
			java.lang.System.out.println();
		}
	}

	private static boolean isAnnotationArg(java.lang.String arg) {
		return arg.charAt(0) == '@';
	}

	private static boolean isSnippetArg(java.lang.String arg) {
		return arg.startsWith("snippetsPattern:");
	}

	private static final int MAJOR_VERSION_JAVA7 = 51;

	private static final int MAJOR_VERSION_OFFSET = 44;

	private static final byte CONSTANT_Utf8 = 1;

	private static final byte CONSTANT_Integer = 3;

	private static final byte CONSTANT_Float = 4;

	private static final byte CONSTANT_Long = 5;

	private static final byte CONSTANT_Double = 6;

	private static final byte CONSTANT_Class = 7;

	private static final byte CONSTANT_Fieldref = 9;

	private static final byte CONSTANT_String = 8;

	private static final byte CONSTANT_Methodref = 10;

	private static final byte CONSTANT_InterfaceMethodref = 11;

	private static final byte CONSTANT_NameAndType = 12;

	private static final byte CONSTANT_MethodHandle = 15;

	private static final byte CONSTANT_MethodType = 16;

	private static final byte CONSTANT_Dynamic = 17;

	private static final byte CONSTANT_InvokeDynamic = 18;

	private static void readClassfile(java.io.DataInputStream stream, java.util.Collection<java.lang.String> methodAnnotationTypes) throws java.io.IOException {
		int magic = stream.readInt();
		assert magic == 0xcafebabe;
		int minor = stream.readUnsignedShort();
		int major = stream.readUnsignedShort();
		if (major < compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.MAJOR_VERSION_JAVA7) {
			throw new java.lang.UnsupportedClassVersionError((("Unsupported class file version: " + major) + ".") + minor);
		}
		java.lang.String javaVersion = java.lang.System.getProperties().get("java.specification.version").toString();
		int majorJavaVersion;
		if (javaVersion.startsWith("1.")) {
			javaVersion = javaVersion.substring(2);
			majorJavaVersion = java.lang.Integer.parseInt(javaVersion);
		} else {
			majorJavaVersion = java.lang.Integer.parseInt(javaVersion);
		}
		if (major > (compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.MAJOR_VERSION_OFFSET + majorJavaVersion)) {
			throw new java.lang.UnsupportedClassVersionError((("Unsupported class file version: " + major) + ".") + minor);
		}
		java.lang.String[] cp = compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readConstantPool(stream, major, minor);
		stream.skipBytes(6);
		stream.skipBytes(stream.readUnsignedShort() * 2);
		compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFields(stream);
		compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readMethods(stream, cp, methodAnnotationTypes);
	}

	private static void skipFully(java.io.DataInputStream stream, int n) throws java.io.IOException {
		long skipped = 0;
		do {
			long s = stream.skip(n - skipped);
			skipped += s;
			if ((s == 0) && (skipped != n)) {
				if (stream.read() == (-1)) {
					throw new java.io.IOException("truncated stream");
				}
				skipped++;
			}
		} while (skipped != n );
	}

	private static java.lang.String[] readConstantPool(java.io.DataInputStream stream, int major, int minor) throws java.io.IOException {
		int count = stream.readUnsignedShort();
		java.lang.String[] cp = new java.lang.String[count];
		int i = 1;
		while (i < count) {
			byte tag = stream.readByte();
			switch (tag) {
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Class :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_String :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_MethodType :
					{
						compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 2);
						break;
					}
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_InterfaceMethodref :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Methodref :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Fieldref :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_NameAndType :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Float :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Integer :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Dynamic :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_InvokeDynamic :
					{
						compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 4);
						break;
					}
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Long :
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Double :
					{
						compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 8);
						break;
					}
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Utf8 :
					{
						cp[i] = stream.readUTF();
						break;
					}
				case compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_MethodHandle :
					{
						compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 3);
						break;
					}
				default :
					{
						throw new java.lang.InternalError(java.lang.String.format(("Invalid constant pool tag: " + tag) + ". Maybe %s needs updating for changes introduced by class file version %d.%d?", compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.class, major, minor));
					}
			}
			if ((tag == compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Double) || (tag == compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.CONSTANT_Long)) {
				i += 2;
			} else {
				i += 1;
			}
		} 
		return cp;
	}

	private static void skipAttributes(java.io.DataInputStream stream) throws java.io.IOException {
		int attributesCount;
		attributesCount = stream.readUnsignedShort();
		for (int i = 0; i < attributesCount; i++) {
			stream.skipBytes(2);
			int attributeLength = stream.readInt();
			compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, attributeLength);
		}
	}

	private static void readMethodAttributes(java.io.DataInputStream stream, java.lang.String[] cp, java.util.Collection<java.lang.String> methodAnnotationTypes) throws java.io.IOException {
		int attributesCount;
		attributesCount = stream.readUnsignedShort();
		for (int i = 0; i < attributesCount; i++) {
			java.lang.String attributeName = cp[stream.readUnsignedShort()];
			int attributeLength = stream.readInt();
			if (attributeName.equals("RuntimeVisibleAnnotations")) {
				int numAnnotations = stream.readUnsignedShort();
				for (int a = 0; a != numAnnotations; a++) {
					compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readAnnotation(stream, cp, methodAnnotationTypes);
				}
			} else {
				compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, attributeLength);
			}
		}
	}

	private static void readAnnotation(java.io.DataInputStream stream, java.lang.String[] cp, java.util.Collection<java.lang.String> methodAnnotationTypes) throws java.io.IOException {
		int typeIndex = stream.readUnsignedShort();
		int pairs = stream.readUnsignedShort();
		java.lang.String type = cp[typeIndex];
		java.lang.String className = type.substring(1, type.length() - 1).replace('/', '.');
		methodAnnotationTypes.add(className);
		compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readAnnotationElements(stream, cp, pairs, true, methodAnnotationTypes);
	}

	private static void readAnnotationElements(java.io.DataInputStream stream, java.lang.String[] cp, int pairs, boolean withElementName, java.util.Collection<java.lang.String> methodAnnotationTypes) throws java.io.IOException {
		for (int p = 0; p < pairs; p++) {
			if (withElementName) {
				compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 2);
			}
			int tag = stream.readByte();
			switch (tag) {
				case 'B' :
				case 'C' :
				case 'D' :
				case 'F' :
				case 'I' :
				case 'J' :
				case 'S' :
				case 'Z' :
				case 's' :
				case 'c' :
					compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 2);
					break;
				case 'e' :
					compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 4);
					break;
				case '@' :
					compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readAnnotation(stream, cp, methodAnnotationTypes);
					break;
				case '[' :
					{
						int numValues = stream.readUnsignedShort();
						compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readAnnotationElements(stream, cp, numValues, false, methodAnnotationTypes);
						break;
					}
			}
		}
	}

	private static void skipFields(java.io.DataInputStream stream) throws java.io.IOException {
		int count = stream.readUnsignedShort();
		for (int i = 0; i < count; i++) {
			stream.skipBytes(6);
			compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipAttributes(stream);
		}
	}

	private static void readMethods(java.io.DataInputStream stream, java.lang.String[] cp, java.util.Collection<java.lang.String> methodAnnotationTypes) throws java.io.IOException {
		int count = stream.readUnsignedShort();
		for (int i = 0; i < count; i++) {
			compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.skipFully(stream, 6);
			compiler.graalunit.com.oracle.mxtool.junit.FindClassesByAnnotatedMethods.readMethodAttributes(stream, cp, methodAnnotationTypes);
		}
	}
}