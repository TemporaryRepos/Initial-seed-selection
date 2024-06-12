public class Test extends vm.mlvm.share.MlvmTest {
	static final int CLASSES_COUNT = 1000;

	public static void main(java.lang.String[] args) {
		vm.mlvm.share.MlvmTest.launch(args);
	}

	@java.lang.Override
	public boolean run() throws java.lang.Throwable {
		java.util.List<java.lang.Class> classes = new java.util.ArrayList<java.lang.Class>();
		for (int i = 0; i < vm.mlvm.mixed.func.regression.b7127687.Test.CLASSES_COUNT; i++) {
			classes.add(vm.mlvm.mixed.func.regression.b7127687.Test.generateClass("Class" + i));
		}
		for (java.lang.Class a : classes) {
			for (java.lang.Class b : classes) {
				vm.mlvm.share.Env.traceNormal(((("Perform call MethodType.methodType(" + a) + ", ") + b) + ")");
				java.lang.invoke.MethodType.methodType(a, b);
			}
		}
		return true;
	}

	private static java.lang.Class generateClass(java.lang.String name) throws java.lang.ClassNotFoundException {
		jdk.internal.org.objectweb.asm.ClassWriter cw = new jdk.internal.org.objectweb.asm.ClassWriter(0);
		cw.visit(jdk.internal.org.objectweb.asm.Opcodes.V1_1, jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC, name, null, "java/lang/Object", null);
		return vm.mlvm.share.CustomClassLoaders.makeClassBytesLoader(cw.toByteArray(), name).loadClass(name);
	}
}