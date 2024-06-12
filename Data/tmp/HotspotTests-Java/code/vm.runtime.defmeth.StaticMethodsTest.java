public class StaticMethodsTest extends vm.runtime.defmeth.shared.DefMethTest {
	public static void main(java.lang.String[] args) {
		nsk.share.test.TestBase.runTest(new vm.runtime.defmeth.StaticMethodsTest(), args);
	}

	public void testStaticMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().staticCallSite(I, "m", "()I").returns(1).done().run();
	}

	public void testInvokeVirtual() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("staticM", "()I").static_().public_().returns(1).build().defaultMethod("m", "()I").invoke(vm.runtime.defmeth.shared.data.method.body.CallMethod.Invoke.VIRTUAL, b.intfByName("I"), null, "staticM", "()I", vm.runtime.defmeth.shared.data.method.body.CallMethod.IndexbyteOp.METHODREF).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().staticCallSite(I, "staticM", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().run();
	}

	public void testInvokeIntf() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("staticM", "()I").static_().public_().returns(1).build().defaultMethod("m", "()I").invoke(vm.runtime.defmeth.shared.data.method.body.CallMethod.Invoke.INTERFACE, b.intfByName("I"), null, "staticM", "()I", vm.runtime.defmeth.shared.data.method.body.CallMethod.IndexbyteOp.CALLSITE).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().staticCallSite(I, "staticM", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().run();
	}

	public void testInvokeSpecial() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("staticM", "()I").static_().public_().returns(1).build().defaultMethod("m", "()I").invoke(vm.runtime.defmeth.shared.data.method.body.CallMethod.Invoke.SPECIAL, b.intfByName("I"), null, "staticM", "()I", vm.runtime.defmeth.shared.data.method.body.CallMethod.IndexbyteOp.CALLSITE).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().staticCallSite(I, "staticM", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().run();
	}

	public void testStaticVsDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().defaultMethod("m", "()I").public_().returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		b.test().staticCallSite(I, "m", "()I").throws_(java.lang.ClassFormatError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.ClassFormatError.class).done().run();
	}

	public void testInvokeFromDefaultMethod() throws java.lang.Exception {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("staticPublicM", "()I").static_().public_().returns(1).build().defaultMethod("invokePublic", "()I").invokeStatic(b.intfByName("I"), "staticPublicM", "()I").build().defaultMethod("staticPrivateM", "()I").static_().private_().returns(1).build().defaultMethod("invokePrivate", "()I").invokeStatic(b.intfByName("I"), "staticPrivateM", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		java.lang.Class expectedClass;
		if (factory.getExecutionMode().equals("REFLECTION")) {
			expectedClass = java.lang.NoSuchMethodException.class;
		} else {
			expectedClass = java.lang.IllegalAccessError.class;
		}
		b.test().staticCallSite(I, "staticPublicM", "()I").returns(1).done().test().staticCallSite(I, "staticPrivateM", "()I").throws_(expectedClass).done().test().callSite(I, C, "invokePublic", "()I").returns(1).done().test().callSite(C, C, "invokePublic", "()I").returns(1).done().test().callSite(I, C, "invokePrivate", "()I").returns(1).done().test().callSite(C, C, "invokePrivate", "()I").returns(1).done().run();
	}

	@vm.runtime.defmeth.shared.annotation.NotApplicableFor(modes = { vm.runtime.defmeth.shared.ExecutionMode.REDEFINITION })
	public void testInvokeFromSubclass() throws java.lang.Exception {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("staticPublicM", "()I").static_().public_().returns(1).build().defaultMethod("staticPrivateM", "()I").static_().private_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("invokePublic", "()I").invokeStatic(b.intfByName("I"), "staticPublicM", "()I").build().concreteMethod("invokePrivate", "()I").invokeStatic(b.intfByName("I"), "staticPrivateM", "()I").build().build();
		java.lang.Class expectedError1;
		if (factory.getExecutionMode().equals("REFLECTION")) {
			expectedError1 = java.lang.NoSuchMethodException.class;
		} else {
			expectedError1 = java.lang.IllegalAccessError.class;
		}
		if (factory.getVer() >= 52) {
			b.test().staticCallSite(I, "staticPublicM", "()I").returns(1).done().test().staticCallSite(I, "staticPrivateM", "()I").throws_(expectedError1).done().test().callSite(C, C, "invokePublic", "()I").returns(1).done().test().callSite(C, C, "invokePrivate", "()I").throws_(java.lang.IllegalAccessError.class).done().run();
		} else {
			b.test().staticCallSite(I, "staticPublicM", "()I").returns(1).done().test().staticCallSite(I, "staticPrivateM", "()I").throws_(expectedError1).done().test().callSite(C, C, "invokePublic", "()I").throws_(java.lang.VerifyError.class).done().test().callSite(C, C, "invokePrivate", "()I").throws_(java.lang.VerifyError.class).done().run();
		}
	}

	public void testNotInherited() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().run();
		} else {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().run();
		}
	}

	public void testDefaultVsConcrete() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I).concreteMethod("m", "()I").returns(2).build().build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		}
	}

	public void testOverrideStatic() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).defaultMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(J, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		} else {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		}
	}

	public void testOverrideDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).defaultMethod("m", "()I").static_().public_().returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(1).done().run();
		}
	}

	public void testReabstract() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(J, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
		}
	}

	public void testOverrideAbstract() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").abstractMethod("m", "()I").build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").extend(I).defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(J, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().test().callSite(J, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").throws_(java.lang.AbstractMethodError.class).done().run();
		}
	}

	public void testInheritedDefault() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").implement(I).build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(B, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(B, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().test().callSite(C, C, "m", "()I").throws_(java.lang.NoSuchMethodError.class).done().run();
		}
	}

	public void testDefaultVsConcreteInherited() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass B = b.clazz("B").concreteMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(B).implement(I).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(B, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		} else {
			b.test().staticCallSite(I, "m", "()I").returns(1).done().test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(B, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		}
	}

	public void testDefaultVsStaticConflict() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").static_().public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").implement(I, J).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(I, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(J, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		} else {
			b.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(J, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done().run();
		}
	}

	public void testStaticSuperClassVsDefaultSuperInterface() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").concreteMethod("m", "()I").static_().public_().returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(A).implement(I).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(C, C, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(I, C, "m", "()I").returns(1).done().run();
		} else {
			b.test().callSite(C, C, "m", "()I").returns(2).done().test().callSite(I, C, "m", "()I").returns(1).done().run();
		}
	}

	public void testStaticLocalVsDefaultSuperInterface() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").implement(I).concreteMethod("m", "()I").static_().public_().returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(A).implement(I).build();
		if (!factory.getExecutionMode().equals("REFLECTION")) {
			b.test().callSite(A, A, "m", "()I").throws_(java.lang.IncompatibleClassChangeError.class).done().test().callSite(I, A, "m", "()I").returns(1).done().run();
		} else {
			b.test().callSite(A, A, "m", "()I").returns(2).done().test().callSite(I, A, "m", "()I").returns(1).done().run();
		}
	}

	public void testConflictingDefaultsandStaticMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder b = factory.getBuilder();
		vm.runtime.defmeth.shared.data.Interface I = b.intf("I").defaultMethod("m", "()I").public_().returns(1).build().build();
		vm.runtime.defmeth.shared.data.Interface J = b.intf("J").defaultMethod("m", "()I").public_().returns(2).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass A = b.clazz("A").implement(I, J).concreteMethod("m", "()I").static_().public_().returns(3).build().build();
		vm.runtime.defmeth.shared.data.ConcreteClass C = b.clazz("C").extend(A).build();
		b.test().staticCallSite(C, "m", "()I").returns(3).done().run();
	}
}