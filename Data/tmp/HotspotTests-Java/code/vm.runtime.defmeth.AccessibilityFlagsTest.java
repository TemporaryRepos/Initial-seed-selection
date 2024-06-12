public class AccessibilityFlagsTest extends vm.runtime.defmeth.shared.DefMethTest {
	public static void main(java.lang.String[] args) {
		nsk.share.test.TestBase.runTest(new vm.runtime.defmeth.AccessibilityFlagsTest(), args);
	}

	public void testProtectedMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testProtectedMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PROTECTED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testFinalMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testNativeMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testSynchronizedMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testSynchronizedMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testPrivateMethodDefault() {
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testPublicMethodAbstract() {
		loadClass(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
	}

	public void testPublicMethodDefault() {
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
	}

	public void testPrivatePublicMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testPrivatePublicMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testStaticMethodDefault() {
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testStrictFPMethodDefault() {
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STRICT | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		loadClass(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STRICT | jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testFinalMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodClass(jdk.internal.org.objectweb.asm.Opcodes.ACC_FINAL));
	}

	public void testNativeMethodAbstract() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE));
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodClass(jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE));
	}

	public void testPrivateMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
		expectClassFormatError(createAbstractMethodClass(jdk.internal.org.objectweb.asm.Opcodes.ACC_PRIVATE));
	}

	public void testStaticMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodClass(jdk.internal.org.objectweb.asm.Opcodes.ACC_STATIC));
	}

	public void testStrictFPMethodAbstract() {
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STRICT));
		expectClassFormatError(createAbstractMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_STRICT | jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC));
		expectClassFormatError(createAbstractMethodClass(jdk.internal.org.objectweb.asm.Opcodes.ACC_STRICT));
	}

	public void testAbstractMethodDefault() {
		expectClassFormatError(createDefaultMethodInterface(jdk.internal.org.objectweb.asm.Opcodes.ACC_ABSTRACT));
	}

	private vm.runtime.defmeth.shared.data.Interface createAbstractMethodInterface(int acc) {
		return factory.getBuilder().intf("I").abstractMethod("m", "()V").flags(acc).build().build();
	}

	private vm.runtime.defmeth.shared.data.Clazz createAbstractMethodClass(int acc) {
		return factory.getBuilder().clazz("I").abstractMethod("m", "()V").flags(acc).build().build();
	}

	private vm.runtime.defmeth.shared.data.Interface createDefaultMethodInterface(int acc) {
		return factory.getBuilder().intf("I").defaultMethod("m", "()V").flags(acc).body(new vm.runtime.defmeth.shared.data.method.body.EmptyBody()).build().build();
	}

	private void expectException(vm.runtime.defmeth.shared.data.Clazz clz, java.lang.Class<? extends java.lang.Throwable> exc) {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder().register(clz);
		b.test().loadClass(clz).throws_(exc).done().run();
	}

	private void loadClass(vm.runtime.defmeth.shared.data.Clazz clz) {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder().register(clz);
		b.test().loadClass(clz).ignoreResult().done().run();
	}

	private void expectClassFormatError(vm.runtime.defmeth.shared.data.Clazz clz) {
		expectException(clz, java.lang.ClassFormatError.class);
	}
}