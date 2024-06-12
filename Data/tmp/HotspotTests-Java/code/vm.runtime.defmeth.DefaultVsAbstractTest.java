public class DefaultVsAbstractTest extends vm.runtime.defmeth.shared.DefMethTest {
	public static void main(java.lang.String[] args) {
		nsk.share.test.TestBase.runTest(new vm.runtime.defmeth.DefaultVsAbstractTest(), args);
	}

	public void test0() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).abstractMethod("m", "()I").build().build();
		b.test().callSite(I, C, "m", "()I").throws_(java.lang.InstantiationError.class).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void test1() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(C).build();
		b.test().callSite(I, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(C, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(D, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void test2() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(C).implement(I).build();
		b.test().callSite(I, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(C, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(D, D, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
	}

	public void test3() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(C).implement(I).concreteMethod("m", "()I").returns(2).build().build();
		b.test().callSite(I, D, "m", "()I").returns(2).done().test().callSite(C, D, "m", "()I").returns(2).done().test().callSite(D, D, "m", "()I").returns(2).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void test4() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass E = b.clazz("E").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(E).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(D).implement(I).build();
		b.test().callSite(I, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(E, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(D, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
	}

	public void test5() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass E = b.clazz("E").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(E).concreteMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(D).implement(I).build();
		b.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(I, C, "m", "()I").returns(2).done().run();
	}

	public void test6() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass E = b.clazz("E").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(E).concreteMethod("m", "()I").returns(3).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(D).implement(I, J).build();
		b.test().callSite(I, C, "m", "()I").returns(3).done().test().callSite(J, C, "m", "()I").returns(3).done().test().callSite(E, C, "m", "()I").returns(3).done().test().callSite(D, C, "m", "()I").returns(3).done().test().callSite(J, C, "m", "()I").returns(3).done().run();
	}

	public void testInvokeInterfaceClassDefaultMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").extend(A).implement(J).build();
		java.lang.String exeMode = factory.getExecutionMode();
		if (exeMode.equals("REFLECTION") || exeMode.equals("INVOKE_WITH_ARGS")) {
			b.test().interfaceCallSite(A, B, "m", "()I").returns(1).done().run();
		} else {
			b.test().interfaceCallSite(A, B, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().run();
		}
	}

	public void testInvokeInterfaceClassAbstractMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").extend(A).implement(J).build();
		java.lang.String exeMode = factory.getExecutionMode();
		java.lang.Class expectedError = java.lang.IncompatibleClassChangeError.class;
		b.test().interfaceCallSite(A, B, "m", "()I").throws_(expectedError).done().run();
	}

	public void testInvokeInterfaceMultipleDefinedClassDefaultMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").extend(A).implement(J).build();
		java.lang.String exeMode = factory.getExecutionMode();
		java.lang.Class expectedError = java.lang.IncompatibleClassChangeError.class;
		b.test().interfaceCallSite(A, B, "m", "()I").throws_(expectedError).done().run();
	}
}