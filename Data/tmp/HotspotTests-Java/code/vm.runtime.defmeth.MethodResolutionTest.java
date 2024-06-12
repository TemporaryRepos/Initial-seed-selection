public class MethodResolutionTest extends vm.runtime.defmeth.shared.DefMethTest {
	public static void main(java.lang.String[] args) {
		nsk.share.test.TestBase.runTest(new vm.runtime.defmeth.MethodResolutionTest(), args);
	}

	public void testBasic() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("m", "()I").returns(1).build().build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	public void testBasicDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testFarDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).build();
		vm.runtime.defmeth.shared.data.Interface K = b.intf("K").extend(J).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(K).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(1).done().test().callSite(K, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testOverrideAbstract() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface K = b.intf("K").extend(J).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(K).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(1).done().test().callSite(K, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	public void testDefaultVsConcrete() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("m", "()I").returns(2).build().build();
		b.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
	}

	public void testInheritedDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(B, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	public void testExistingInherited() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").concreteMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).implement(I).build();
		b.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(B, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
	}

	public void testExistingInheritedOverride() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").implement(I).concreteMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).concreteMethod("m", "()I").returns(3).build().build();
		b.test().callSite(I, C, "m", "()I").returns(3).done().test().callSite(B, C, "m", "()I").returns(3).done().test().callSite(C, C, "m", "()I").returns(3).done().run();
	}

	public void testExistingInheritedPlusDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(11).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").returns(12).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("m", "()I").returns(21).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass D = b.clazz("D").extend(C).concreteMethod("m", "()I").returns(22).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass E = b.clazz("E").extend(D).implement(J).build();
		b.test().callSite(I, E, "m", "()I").returns(22).done().test().callSite(J, E, "m", "()I").returns(22).done().test().callSite(C, E, "m", "()I").returns(22).done().test().callSite(D, E, "m", "()I").returns(22).done().test().callSite(E, E, "m", "()I").returns(22).done().run();
	}

	public void testInheritedWithConcrete() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).concreteMethod("m", "()I").returns(2).build().build();
		b.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(B, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
	}

	public void testInheritedWithConcreteAndImpl() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).concreteMethod("m", "()I").returns(2).build().build();
		b.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(B, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testDiamond() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).build();
		vm.runtime.defmeth.shared.data.Interface K = b.intf("K").extend(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J, K).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(1).done().test().callSite(K, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testExpandedDiamond() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).build();
		vm.runtime.defmeth.shared.data.Interface K = b.intf("K").extend(I).build();
		vm.runtime.defmeth.shared.data.Interface L = b.intf("L").extend(I).build();
		vm.runtime.defmeth.shared.data.Interface M = b.intf("M").extend(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J, K, L, M).build();
		b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(1).done().test().callSite(K, C, "m", "()I").returns(1).done().test().callSite(L, C, "m", "()I").returns(1).done().test().callSite(M, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
	}

	public void testSelfFillWithExplicitBridge() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").sig("<T:Ljava/lang/Object;>Ljava/lang/Object;").defaultMethod("m", "(Ljava/lang/Object;)I").sig("(TT;)I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).sig("Ljava/lang/Object;LI<LC;>;").concreteMethod("m", "(LC;)I").returns(2).build().concreteMethod("m", "(Ljava/lang/Object;)I").flags((jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC | jdk.internal.org.objectweb.asm.Opcodes.ACC_BRIDGE) | jdk.internal.org.objectweb.asm.Opcodes.ACC_SYNTHETIC).returns(2).build().build();
		b.test().callSite(I, C, "m", "(Ljava/lang/Object;)I").params(new vm.runtime.defmeth.shared.data.method.param.NullParam()).returns(2).done().test().callSite(C, C, "m", "(Ljava/lang/Object;)I").params(new vm.runtime.defmeth.shared.data.method.param.NullParam()).returns(2).done().test().callSite(C, C, "m", "(LC;)I").params(new vm.runtime.defmeth.shared.data.method.param.NullParam()).returns(2).done().run();
	}

	public void testMixedArity() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("m", "(I)I").returns(2).build().build();
		b.test().callSite(I, C, "m", "()I").returns(1).build();
		b.test().callSite(C, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).returns(2).build();
		b.run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testConflictingDefaultMixedArity1() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "(I)I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I, J).build();
		b.test().callSite(I, C, "m", "()I").returns(1).build();
		b.test().callSite(I, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).throws_(java.lang.NoSuchMethodError.class).build();
		b.test().callSite(J, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).build();
		b.test().callSite(J, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).returns(2).build();
		b.test().callSite(C, C, "m", "()I").returns(1).build();
		b.test().callSite(C, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).returns(2).build();
		b.run();
	}

	@vm.runtime.defmeth.shared.annotation.KnownFailure(modes = { vm.runtime.defmeth.shared.ExecutionMode.INVOKE_EXACT, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_GENERIC, vm.runtime.defmeth.shared.ExecutionMode.INDY })
	public void testConflictingDefaultMixedArity2() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I, J).concreteMethod("m", "(I)I").returns(3).build().build();
		b.test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).build();
		b.test().callSite(I, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).throws_(java.lang.NoSuchMethodError.class).build();
		b.test().callSite(J, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).build();
		b.test().callSite(J, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).throws_(java.lang.NoSuchMethodError.class).build();
		b.test().callSite(C, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).build();
		b.test().callSite(C, C, "m", "(I)I").params(jdk.internal.org.objectweb.asm.Opcodes.ICONST_0).returns(3).build();
		b.run();
	}

	public void testMethodResolvedInDifferentPackage() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("p1.I").flags((~jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC) & jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC).defaultMethod("m", "()I").returns(10).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("p1.J").extend(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass myA = b.clazz("p2.A").implement(J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(myA, myA, "m", "()I").returns(10).done().run();
		} else {
			b.test().callSite(myA, myA, "m", "()I").throws_(java.lang.IllegalAccessException.class).done().run();
		}
		vm.runtime.defmeth.shared.data.ConcreteClass myB = b.clazz("p2.B").build();
	}

	public void testMethodResolvedInLocalFirst() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("p1.I").defaultMethod("m", "()I").returns(12).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass myA = b.clazz("p1.A").implement(I).build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("p2.J").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass myB = b.clazz("p2.B").extend(myA).implement(J).concreteMethod("m", "()I").returns(13).build().build();
		b.test().callSite(myB, myB, "m", "()I").returns(13).done().run();
	}
}