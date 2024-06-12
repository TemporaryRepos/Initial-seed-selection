public class CompareTwoJarFile {
	public static void main(java.lang.String[] args) {
		java.lang.String jarPath1 = "D:/git-repo/learn-java-asm/first.jar";
		java.lang.String jarPath2 = "D:/git-repo/learn-java-asm/second.jar";
		java.util.List<java.lang.String> list1 = lsieun.utils.JarUtils.getAllEntries(jarPath1);
		java.util.List<java.lang.String> list2 = lsieun.utils.JarUtils.getAllEntries(jarPath2);
		java.util.Set<java.lang.String> set = new java.util.HashSet<>();
		set.addAll(list1);
		set.addAll(list2);
		java.lang.String message = java.lang.String.format("total: %s, list1=%s, list2=%s", set.size(), list1.size(), list2.size());
		java.lang.System.out.println(message);
		java.util.Map<java.lang.String, java.io.ByteArrayOutputStream> map1 = lsieun.utils.JarUtils.getAllEntryMap(jarPath1, list1);
		java.util.Map<java.lang.String, java.io.ByteArrayOutputStream> map2 = lsieun.utils.JarUtils.getAllEntryMap(jarPath2, list2);
		for (java.lang.String item : set) {
			if (item.endsWith("/")) {
				continue;
			}
			byte[] bytes1 = null;
			byte[] bytes2 = null;
			java.io.ByteArrayOutputStream bao1 = map1.get(item);
			java.io.ByteArrayOutputStream bao2 = map2.get(item);
			if (bao1 != null) {
				bytes1 = bao1.toByteArray();
			}
			if (bao2 != null) {
				bytes2 = bao2.toByteArray();
			}
			boolean equals = java.util.Arrays.equals(bytes1, bytes2);
			if (equals) {
				continue;
			}
			if (!item.endsWith(".class")) {
				run.jar.CompareTwoJarFile.generateOtherFile(bytes1, item, "a");
				run.jar.CompareTwoJarFile.generateOtherFile(bytes2, item, "b");
			} else {
				run.jar.CompareTwoJarFile.generateClassText(bytes1, "a");
				run.jar.CompareTwoJarFile.generateClassText(bytes2, "b");
			}
		}
	}

	public static void generateOtherFile(byte[] bytes, java.lang.String item, java.lang.String middle) {
		if ((bytes == null) || (bytes.length == 0)) {
			return;
		}
		int lastIndex = item.lastIndexOf(".");
		java.lang.String prefix;
		java.lang.String suffix;
		if (lastIndex != (-1)) {
			prefix = item.substring(0, lastIndex);
			suffix = item.substring(lastIndex);
		} else {
			prefix = item;
			suffix = "";
		}
		java.lang.String newItem = (prefix + middle) + suffix;
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(newItem);
		lsieun.utils.FileUtils.writeBytes(filepath, bytes);
	}

	public static void generateClassText(byte[] bytes, java.lang.String suffix) {
		if ((bytes == null) || (bytes.length == 0)) {
			return;
		}
		org.objectweb.asm.ClassReader cr = new org.objectweb.asm.ClassReader(bytes);
		java.lang.String className = cr.getClassName();
		java.lang.String filepath = lsieun.utils.FileUtils.getFilePath(((className + "-") + suffix) + ".txt");
		java.io.ByteArrayOutputStream bao = new java.io.ByteArrayOutputStream();
		org.objectweb.asm.util.Printer printer = new org.objectweb.asm.util.Textifier();
		java.io.PrintWriter printWriter = new java.io.PrintWriter(bao, true);
		org.objectweb.asm.ClassVisitor cv = new org.objectweb.asm.util.TraceClassVisitor(null, printer, printWriter);
		int parsingOptions = org.objectweb.asm.ClassReader.SKIP_DEBUG | org.objectweb.asm.ClassReader.SKIP_FRAMES;
		cr.accept(cv, parsingOptions);
		lsieun.utils.FileUtils.writeBytes(filepath, bao.toByteArray());
	}
}