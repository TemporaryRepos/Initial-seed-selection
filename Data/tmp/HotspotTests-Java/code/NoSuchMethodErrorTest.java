public class NoSuchMethodErrorTest extends selectionresolution.SelectionResolutionTest {
	private static final selectionresolution.SelectionResolutionTestCase.Builder initBuilder = new selectionresolution.SelectionResolutionTestCase.Builder();

	static {
		initBuilder.setResult(selectionresolution.Result.NSME);
	}

	private static final selectionresolution.MethodData concreteMethod = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);

	private static final selectionresolution.MethodData staticMethod = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);

	private static final selectionresolution.MethodData privateMethod = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);

	private static final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.SAME, NoSuchMethodErrorTest.concreteMethod);

	private static final selectionresolution.ClassData withStaticDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.SAME, NoSuchMethodErrorTest.staticMethod);

	private static final selectionresolution.ClassData withPrivateDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.SAME, NoSuchMethodErrorTest.staticMethod);

	private static final selectionresolution.Template NoMethodResolutionTemplateClassBottom = new selectionresolution.Template("NoMethodResolutionTemplate", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C, I);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(NoSuchMethodErrorTest.withStaticDef);
		builder.hier.addInherit(C, I);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(NoSuchMethodErrorTest.withPrivateDef);
		builder.hier.addInherit(C, I);
		builder.methodref = C;
	});

	private static final selectionresolution.Template NoMethodResolutionTemplateIfaceBottom = new selectionresolution.Template("NoMethodResolutionTemplate", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.methodref = I;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(I1, I2);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.methodref = I;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I2 = builder.addInterface(NoSuchMethodErrorTest.withStaticDef);
		builder.hier.addInherit(I1, I2);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I2 = builder.addInterface(NoSuchMethodErrorTest.withPrivateDef);
		builder.hier.addInherit(I1, I2);
		builder.methodref = I1;
	});

	private static final selectionresolution.Template NoMethodSelectionTemplateClassMethodref = new selectionresolution.Template("NoMethodSelectionTemplate", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		builder.objectref = builder.methodref;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.methodref;
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.objectref = builder.methodref;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.methodref;
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		builder.addInterface(NoSuchMethodErrorTest.withDef);
		builder.objectref = builder.methodref;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.methodref;
		final int I0 = builder.addInterface(NoSuchMethodErrorTest.withStaticDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I0);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int C2 = builder.methodref;
		final int I0 = builder.addInterface(NoSuchMethodErrorTest.withPrivateDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I0);
		builder.objectref = C1;
	});

	private static final selectionresolution.Template NoMethodSelectionTemplateIfaceMethodref = new selectionresolution.Template("NoMethodSelectionTemplate", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.methodref;
		builder.hier.addInherit(C, I);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I1 = builder.methodref;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.methodref;
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int I1 = builder.methodref;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.addClass(NoSuchMethodErrorTest.withDef);
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.methodref;
		final int I0 = builder.addInterface(NoSuchMethodErrorTest.withStaticDef);
		builder.hier.addInherit(C, I);
		builder.hier.addInherit(C, I0);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.methodref;
		final int I0 = builder.addInterface(NoSuchMethodErrorTest.withPrivateDef);
		builder.hier.addInherit(C, I);
		builder.hier.addInherit(C, I0);
		builder.objectref = C;
	});

	private static final java.util.Collection<selectionresolution.SelectionResolutionTest.TestGroup> testgroups = java.util.Arrays.asList(new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKESTATIC), NoSuchMethodErrorTest.NoMethodResolutionTemplateClassBottom, selectionresolution.Template.AllCallsiteCases, selectionresolution.Template.TrivialObjectref), new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKESTATIC), NoSuchMethodErrorTest.NoMethodResolutionTemplateIfaceBottom, selectionresolution.Template.CallsiteNotEqualsMethodref, selectionresolution.Template.TrivialObjectref), new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKEVIRTUAL), NoSuchMethodErrorTest.NoMethodResolutionTemplateClassBottom, selectionresolution.Template.AllCallsiteCases, NoSuchMethodErrorTest.NoMethodSelectionTemplateClassMethodref), new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKEINTERFACE), NoSuchMethodErrorTest.NoMethodResolutionTemplateIfaceBottom, selectionresolution.Template.CallsiteNotEqualsMethodref, NoSuchMethodErrorTest.NoMethodSelectionTemplateIfaceMethodref), new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKEVIRTUAL), selectionresolution.Template.ResultCombo(java.util.EnumSet.of(selectionresolution.Template.Kind.INTERFACE), java.util.EnumSet.of(selectionresolution.MethodData.Access.PRIVATE), java.util.EnumSet.of(selectionresolution.MethodData.Context.INSTANCE, selectionresolution.MethodData.Context.ABSTRACT), java.util.EnumSet.of(selectionresolution.ClassData.Package.SAME, selectionresolution.ClassData.Package.DIFFERENT)), selectionresolution.Template.MethodrefNotEqualsExpectedIface, selectionresolution.Template.AllCallsiteCases, selectionresolution.Template.TrivialObjectref), new selectionresolution.SelectionResolutionTest.TestGroup.Simple(NoSuchMethodErrorTest.initBuilder, selectionresolution.Template.SetInvoke(selectionresolution.SelectionResolutionTestCase.InvokeInstruction.INVOKEINTERFACE), selectionresolution.Template.ResultCombo(java.util.EnumSet.of(selectionresolution.Template.Kind.INTERFACE), java.util.EnumSet.of(selectionresolution.MethodData.Access.PRIVATE), java.util.EnumSet.of(selectionresolution.MethodData.Context.INSTANCE, selectionresolution.MethodData.Context.ABSTRACT), java.util.EnumSet.of(selectionresolution.ClassData.Package.SAME, selectionresolution.ClassData.Package.DIFFERENT)), selectionresolution.Template.IfaceMethodrefNotEqualsExpected, selectionresolution.Template.AllCallsiteCases, selectionresolution.Template.TrivialObjectrefNotEqualMethodref));

	private NoSuchMethodErrorTest() {
		super(NoSuchMethodErrorTest.testgroups);
	}

	public static void main(final java.lang.String... args) {
		new NoSuchMethodErrorTest().run();
	}
}