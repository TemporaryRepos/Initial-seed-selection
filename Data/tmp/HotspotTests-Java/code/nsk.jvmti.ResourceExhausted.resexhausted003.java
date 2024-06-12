public class resexhausted003 {
	static final long MAX_ITERATIONS = java.lang.Long.MAX_VALUE;

	static class MyClassLoader extends java.lang.ClassLoader {
		java.lang.Class<?> loadUm(java.lang.String name, byte[] bytes, java.security.ProtectionDomain pd) throws java.lang.ClassFormatError {
			java.lang.Class k = defineClass(name, bytes, 0, bytes.length, pd);
			resolveClass(k);
			return k;
		}

		java.lang.Class loadClass(java.lang.String name, byte[] bytes) {
			try {
				java.lang.Class k = loadUm(name, bytes, getClass().getProtectionDomain());
				k.newInstance();
				return k;
			} catch (java.lang.Exception exc) {
				throw new java.lang.RuntimeException("Exception in loadClass: " + name, exc);
			}
		}
	}

	static class Node {
		nsk.jvmti.ResourceExhausted.resexhausted003.MyClassLoader loader = new nsk.jvmti.ResourceExhausted.resexhausted003.MyClassLoader();

		nsk.jvmti.ResourceExhausted.resexhausted003.Node next;
	}

	static byte[] fileBytes(java.lang.String fileName) {
		try {
			java.io.File f = new java.io.File(fileName);
			java.io.FileInputStream fi = new java.io.FileInputStream(f);
			byte[] bytes;
			try {
				bytes = new byte[((int) (f.length()))];
				fi.read(bytes);
			} finally {
				fi.close();
			}
			return bytes;
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException(("Exception when reading file '" + fileName) + "'", e);
		}
	}

	public static int run(java.lang.String[] args, java.io.PrintStream out) {
		if ((args == null) || (args.length < 1)) {
			java.lang.System.err.println("TEST BUG: Classes directory should be the first argument. Check .cfg file.");
			return nsk.share.Consts.TEST_FAILED;
		}
		java.lang.String classesDir = args[0];
		nsk.share.test.Stresser stress = new nsk.share.test.Stresser(args);
		java.lang.String className = nsk.jvmti.ResourceExhausted.Helper.class.getName();
		byte[] bloatBytes = nsk.jvmti.ResourceExhausted.resexhausted003.fileBytes(((classesDir + java.io.File.separator) + className.replace('.', '/')) + ".class");
		int count = 0;
		nsk.jvmti.ResourceExhausted.Helper.resetExhaustedEvent();
		out.println("Loading classes...");
		stress.start(nsk.jvmti.ResourceExhausted.resexhausted003.MAX_ITERATIONS);
		try {
			nsk.jvmti.ResourceExhausted.resexhausted003.Node list = null;
			while (stress.iteration()) {
				nsk.jvmti.ResourceExhausted.resexhausted003.Node n = new nsk.jvmti.ResourceExhausted.resexhausted003.Node();
				n.next = list;
				list = n;
				n.loader.loadClass(className, bloatBytes);
				++count;
			} 
			java.lang.System.out.println("Can't reproduce OOME due to a limit on iterations/execution time. Test was useless.");
			return nsk.share.Consts.TEST_PASSED;
		} catch (java.lang.OutOfMemoryError e) {
		} finally {
			stress.finish();
		}
		java.lang.System.gc();
		if (!nsk.jvmti.ResourceExhausted.Helper.checkResult(((("loading " + count) + " classes of ") + bloatBytes.length) + " bytes")) {
			return nsk.share.Consts.TEST_FAILED;
		}
		return nsk.share.Consts.TEST_PASSED;
	}

	public static void main(java.lang.String[] args) {
		args = nsk.share.jvmti.JVMTITest.commonInit(args);
		int result = nsk.jvmti.ResourceExhausted.resexhausted003.run(args, java.lang.System.out);
		java.lang.System.out.println(result == nsk.share.Consts.TEST_PASSED ? "TEST PASSED" : "TEST FAILED");
		java.lang.System.exit(result + nsk.share.Consts.JCK_STATUS_BASE);
	}
}