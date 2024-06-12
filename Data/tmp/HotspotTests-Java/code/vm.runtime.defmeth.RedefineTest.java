public class RedefineTest extends vm.runtime.defmeth.shared.DefMethTest {
	public static void main(java.lang.String[] args) {
		nsk.share.test.TestBase.runTest(new vm.runtime.defmeth.RedefineTest(), args);
	}

	@java.lang.Override
	protected void configure() {
		java.lang.String mode = factory.getExecutionMode();
		if ("REFLECTION".equals(mode) || "INVOKE_WITH_ARGS".equals(mode)) {
			throw new nsk.share.TestFailure("RedefineTest isn't applicable to reflection-based execution scenario " + "(REDEFINE & INVOKE_WITH_ARGS).");
		}
	}

	private void redefineAndRun(vm.runtime.defmeth.shared.builder.TestBuilder b1, vm.runtime.defmeth.shared.builder.TestBuilder b2, vm.runtime.defmeth.shared.data.Clazz... classes) {
		vm.runtime.defmeth.shared.executor.TestExecutor executor = b1.prepare();
		getLog().info("Before");
		java.util.List<nsk.share.Pair<vm.runtime.defmeth.shared.data.Tester, java.lang.Throwable>> errorsBefore = executor.run();
		vm.runtime.defmeth.shared.MemoryClassLoader cl = executor.getLoader();
		java.util.Map<java.lang.String, byte[]> cf = b2.produce();
		java.util.Map<java.lang.String, byte[]> forRedef = new java.util.HashMap<>();
		for (vm.runtime.defmeth.shared.data.Clazz clz : classes) {
			java.lang.String name = clz.name();
			forRedef.put(name, cf.get(name));
		}
		cl.modifyClasses(forRedef, factory.isRetransformClasses());
		getLog().info("After");
		java.util.List<nsk.share.Pair<vm.runtime.defmeth.shared.data.Tester, java.lang.Throwable>> errorsAfter = executor.run();
		if (!errorsBefore.isEmpty()) {
			throw new vm.runtime.defmeth.shared.DefMethTestFailure(errorsBefore);
		}
		if (!errorsAfter.isEmpty()) {
			throw new vm.runtime.defmeth.shared.DefMethTestFailure(errorsAfter);
		}
	}

	@vm.runtime.defmeth.shared.annotation.NotApplicableFor(modes = { vm.runtime.defmeth.shared.ExecutionMode.REFLECTION, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS })
	public void testRedefineConcreteMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder before = factory.getBuilder();
		{
			vm.runtime.defmeth.shared.data.Interface I = before.intf("I").defaultMethod("m", "()I").returns(1).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = before.clazz("C").implement(I).concreteMethod("m", "()I").returns(2).build().build();
			before.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done();
		}
		{
			vm.runtime.defmeth.shared.builder.TestBuilder after = factory.getBuilder();
			vm.runtime.defmeth.shared.data.Interface I = after.intf("I").defaultMethod("m", "()I").returns(1).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = after.clazz("C").implement(I).concreteMethod("m", "()I").returns(3).build().build();
			vm.runtime.defmeth.shared.data.Tester T1 = after.test().callSite(I, C, "m", "()I").returns(3).build();
			vm.runtime.defmeth.shared.data.Tester T2 = after.test().callSite(C, C, "m", "()I").returns(3).build();
			redefineAndRun(before, after, C, T1, T2);
		}
	}

	@vm.runtime.defmeth.shared.annotation.NotApplicableFor(modes = { vm.runtime.defmeth.shared.ExecutionMode.REFLECTION, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS })
	public void testRedefineDefaultMethod() {
		vm.runtime.defmeth.shared.builder.TestBuilder before = factory.getBuilder();
		{
			vm.runtime.defmeth.shared.data.Interface I = before.intf("I").defaultMethod("m", "()I").returns(1).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = before.clazz("C").implement(I).concreteMethod("m", "()I").returns(2).build().build();
			before.test().callSite(I, C, "m", "()I").returns(2).done().test().callSite(C, C, "m", "()I").returns(2).done();
		}
		{
			vm.runtime.defmeth.shared.builder.TestBuilder after = factory.getBuilder();
			vm.runtime.defmeth.shared.data.Interface I = after.intf("I").defaultMethod("m", "()I").returns(3).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = after.clazz("C").implement(I).concreteMethod("m", "()I").returns(2).build().build();
			redefineAndRun(before, after, C);
		}
	}

	@vm.runtime.defmeth.shared.annotation.NotApplicableFor(modes = { vm.runtime.defmeth.shared.ExecutionMode.REFLECTION, vm.runtime.defmeth.shared.ExecutionMode.INVOKE_WITH_ARGS })
	public void testRedefineDefMethInConcreteClass() {
		vm.runtime.defmeth.shared.builder.TestBuilder before = factory.getBuilder();
		{
			vm.runtime.defmeth.shared.data.Interface I = before.intf("I").defaultMethod("m", "()I").returns(1).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = before.clazz("C").implement(I).build();
			before.test().callSite(I, C, "m", "()I").returns(1).done().test().callSite(C, C, "m", "()I").returns(1).done();
		}
		{
			vm.runtime.defmeth.shared.builder.TestBuilder after = factory.getBuilder();
			vm.runtime.defmeth.shared.data.Interface I = after.intf("I").defaultMethod("m", "()I").returns(2).build().build();
			vm.runtime.defmeth.shared.data.ConcreteClass C = after.clazz("C").implement(I).build();
			vm.runtime.defmeth.shared.data.Tester T1 = after.test().callSite(I, C, "m", "()I").returns(2).build();
			vm.runtime.defmeth.shared.data.Tester T2 = after.test().callSite(C, C, "m", "()I").returns(2).build();
			redefineAndRun(before, after, I, T1, T2);
		}
	}
}