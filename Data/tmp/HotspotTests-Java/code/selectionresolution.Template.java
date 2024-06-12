public class Template {
	public enum Kind {

		CLASS,
		INTERFACE;}

	public final java.util.Collection<java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>> cases;

	public final java.lang.String name;

	public Template(final java.lang.String name, final java.util.Collection<java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>> cases) {
		this.cases = cases;
		this.name = name;
	}

	public Template(final java.lang.String name, final java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>... cases) {
		this(name, java.util.Arrays.asList(cases));
	}

	public Template(final java.lang.String name, final selectionresolution.Template include, final java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>... cases) {
		this(name, new java.util.LinkedList(include.cases));
		this.cases.addAll(java.util.Arrays.asList(cases));
	}

	public Template(final java.lang.String name, final selectionresolution.Template... others) {
		this(name, new java.util.LinkedList());
		for (final selectionresolution.Template template : others) {
			cases.addAll(template.cases);
		}
	}

	public void runCases(final java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder> next, final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		for (final java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder> thiscase : cases) {
			final selectionresolution.SelectionResolutionTestCase.Builder localbuilder = builder.copy();
			thiscase.accept(localbuilder);
			next.accept(localbuilder);
		}
	}

	public void printCases(final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		int i = 1;
		java.lang.System.err.println(("Template " + name) + ":\n");
		for (final java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder> thiscase : cases) {
			final selectionresolution.SelectionResolutionTestCase.Builder localbuilder = builder.copy();
			thiscase.accept(localbuilder);
			java.lang.System.err.println("Case " + (i++));
			java.lang.System.err.println(localbuilder);
		}
	}

	public static final selectionresolution.ClassData emptyClass(final selectionresolution.ClassData.Package pck) {
		return new selectionresolution.ClassData(pck, null);
	}

	public static void callsiteIsMethodref(final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		builder.callsite = builder.methodref;
	}

	public static void callsiteSubclassMethodref(final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		final int callsite = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(callsite, builder.methodref);
		builder.callsite = callsite;
	}

	public static void callsiteUnrelatedMethodref(final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		final int callsite = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.callsite = callsite;
	}

	public static void methodrefIsExpected(final selectionresolution.SelectionResolutionTestCase.Builder builder) {
		builder.methodref = builder.expected;
	}

	public static final selectionresolution.Template MethodrefEqualsExpected = new selectionresolution.Template("MethodrefEqualsExpected", selectionresolution.Template::methodrefIsExpected);

	public static final selectionresolution.Template SetInvoke(final selectionresolution.SelectionResolutionTestCase.InvokeInstruction invoke) {
		return new selectionresolution.Template(("SetInvoke(" + invoke) + ")", java.util.Collections.singleton(( builder) -> {
			builder.invoke = invoke;
		}));
	}

	public static selectionresolution.Template ResultCombo(final java.util.EnumSet<selectionresolution.Template.Kind> kinds, final java.util.EnumSet<selectionresolution.MethodData.Access> accesses, final java.util.EnumSet<selectionresolution.MethodData.Context> contexts, final java.util.EnumSet<selectionresolution.ClassData.Package> packages) {
		final java.util.LinkedList<java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>> cases = new java.util.LinkedList<>();
		for (final selectionresolution.Template.Kind kind : kinds) {
			for (final selectionresolution.MethodData.Access acc : accesses) {
				for (final selectionresolution.MethodData.Context ctx : contexts) {
					if (!((acc == selectionresolution.MethodData.Access.PRIVATE) && (ctx == selectionresolution.MethodData.Context.ABSTRACT))) {
						for (final selectionresolution.ClassData.Package pck : packages) {
							cases.add(( builder) -> {
								final selectionresolution.MethodData meth = new selectionresolution.MethodData(acc, ctx);
								final selectionresolution.ClassData cls = new selectionresolution.ClassData(pck, meth);
								switch (kind) {
									case CLASS :
										builder.expected = builder.addClass(cls);
										break;
									case INTERFACE :
										builder.expected = builder.addInterface(cls);
										break;
								}
							});
						}
					}
				}
			}
		}
		return new selectionresolution.Template("ResultCombo", cases);
	}

	public static selectionresolution.Template ResolutionOverride(final java.util.EnumSet<selectionresolution.Template.Kind> kinds, final java.util.EnumSet<selectionresolution.MethodData.Access> accesses, final java.util.EnumSet<selectionresolution.MethodData.Context> contexts, final java.util.EnumSet<selectionresolution.ClassData.Package> packages) {
		final java.util.LinkedList<java.util.function.Consumer<selectionresolution.SelectionResolutionTestCase.Builder>> cases = new java.util.LinkedList<>();
		for (final selectionresolution.Template.Kind kind : kinds) {
			for (final selectionresolution.MethodData.Access acc : accesses) {
				for (final selectionresolution.MethodData.Context ctx : contexts) {
					if (!((acc == selectionresolution.MethodData.Access.PRIVATE) && (ctx == selectionresolution.MethodData.Context.ABSTRACT))) {
						for (final selectionresolution.ClassData.Package pck : packages) {
							cases.add(( builder) -> {
								final selectionresolution.MethodData meth = new selectionresolution.MethodData(acc, ctx);
								final selectionresolution.ClassData cls = new selectionresolution.ClassData(pck, meth);
								int override = -1;
								switch (kind) {
									case CLASS :
										override = builder.addClass(cls);
										break;
									case INTERFACE :
										override = builder.addInterface(cls);
										break;
								}
								builder.hier.addInherit(override, builder.expected);
							});
						}
					}
				}
			}
		}
		return new selectionresolution.Template("ResultCombo", cases);
	}

	private static selectionresolution.MethodData getMethodData(final selectionresolution.MethodData.Access acc, final selectionresolution.MethodData.Context ctx) {
		if ((!((acc == selectionresolution.MethodData.Access.PUBLIC) || (acc == selectionresolution.MethodData.Access.PLACEHOLDER))) && (ctx != selectionresolution.MethodData.Context.STATIC)) {
			return null;
		} else {
			return new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, ctx);
		}
	}

	public static final selectionresolution.Template MethodrefNotEqualsExpectedClass = new selectionresolution.Template("MethodrefNotEqualsExpectedClass", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final int C2 = builder.expected;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.expected;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C3 = builder.expected;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(selectionresolution.ClassData.Package.SAME));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.methodref = C1;
	});

	public static final selectionresolution.Template IfaceMethodrefNotEqualsExpected = new selectionresolution.Template("IfaceMethodrefNotEqualsExpected", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I4 = builder.expected;
		final int I3 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I4 = builder.expected;
		final int I3 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I4 = builder.expected;
		final int I3 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I4 = builder.addInterface(withDef);
		final int I3 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I4 = builder.addInterface(withDef);
		final int I3 = builder.addInterface(withPrivDef);
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I4 = builder.addInterface(withDef);
		final int I3 = builder.addInterface(withStatDef);
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I4);
		builder.hier.addInherit(I3, I4);
		builder.methodref = I1;
	});

	public static final selectionresolution.Template MethodrefNotEqualsExpectedIface = new selectionresolution.Template("MethodrefNotEqualsExpectedIface", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I = builder.expected;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(withPrivDef);
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(withStatDef);
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.expected;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.expected;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.expected;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.methodref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I2 = builder.addInterface(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.expected;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I = builder.expected;
		final int C2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(withPrivDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(withStatDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.expected;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.expected;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.addInterface(withDef);
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.expected;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C3 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C3, I2);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I2 = builder.addInterface(withDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.expected;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C3, I2);
		builder.hier.addInherit(C1, C2);
		builder.methodref = C1;
	});

	public static final selectionresolution.Template IfaceMethodrefAmbiguous = new selectionresolution.Template("IfaceMethodrefAmbiguous", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final int I3 = builder.addInterface(expected);
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I1, I3);
		builder.methodref = I1;
	});

	public static final selectionresolution.Template MethodrefAmbiguous = new selectionresolution.Template("MethodrefAmbiguous", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final int I1 = builder.addInterface(expected);
		final int I2 = builder.expected;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(C, I1);
		builder.methodref = C;
	});

	public static final selectionresolution.Template AllCallsiteCases = new selectionresolution.Template("AllCallsiteCases", selectionresolution.Template::callsiteIsMethodref, selectionresolution.Template::callsiteSubclassMethodref, selectionresolution.Template::callsiteUnrelatedMethodref);

	public static final selectionresolution.Template InvokespecialCallsiteCases = new selectionresolution.Template("InvokespecialCallsiteCases", selectionresolution.Template::callsiteIsMethodref, selectionresolution.Template::callsiteSubclassMethodref);

	public static final selectionresolution.Template CallsiteEqualsMethodref = new selectionresolution.Template("CallsiteEqualsMethodref", selectionresolution.Template::callsiteIsMethodref);

	public static final selectionresolution.Template CallsiteSubclassMethodref = new selectionresolution.Template("CallsiteSubclassMethodref", selectionresolution.Template::callsiteSubclassMethodref);

	public static final selectionresolution.Template CallsiteUnrelatedToMethodref = new selectionresolution.Template("CallsiteUnrelatedToMethodref", selectionresolution.Template::callsiteUnrelatedMethodref);

	public static final selectionresolution.Template CallsiteNotEqualsMethodref = new selectionresolution.Template("CallsiteNotEqualsMethodref", selectionresolution.Template::callsiteSubclassMethodref, selectionresolution.Template::callsiteUnrelatedMethodref);

	public static final selectionresolution.Template ReabstractExpectedIface = new selectionresolution.Template("ReabstractExpectedIface", ( builder) -> {
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = expected.packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.addInterface(withDef);
		final int C1 = builder.expected;
		builder.hier.addInherit(C1, C2);
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = expected.packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.addInterface(withDef);
		final int C1 = builder.expected;
		builder.hier.addInherit(C1, C2);
	});

	public static final selectionresolution.Template ReabstractExpectedClass = new selectionresolution.Template("ReabstractExpectedClass", selectionresolution.Template.ReabstractExpectedIface, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = expected.packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.expected;
		builder.hier.addInherit(C1, C2);
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = expected.packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.expected;
		builder.hier.addInherit(C1, C2);
	});

	public static final selectionresolution.Template ReabstractMethodrefResolvedClass = new selectionresolution.Template("ReabstractMethodrefResolvedClass", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	});

	public static final selectionresolution.Template ReabstractMethodrefResolvedIface = new selectionresolution.Template("ReabstractMethodrefResolvedIface", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withPrivDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
		builder.expected = C2;
	});

	public static final selectionresolution.Template ReabstractIfaceMethodrefResolved = new selectionresolution.Template("ReabstractIfaceMethodrefResolved", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I = builder.methodref;
		final int C = builder.addClass(withDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
		builder.expected = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(withStatDef);
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withPrivDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, new selectionresolution.MethodData(acc, selectionresolution.MethodData.Context.ABSTRACT));
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withStatDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
		builder.expected = I2;
	});

	public static final selectionresolution.Template OverrideAbstractExpectedIface = selectionresolution.Template.ResolutionOverride(java.util.EnumSet.of(selectionresolution.Template.Kind.INTERFACE), java.util.EnumSet.of(selectionresolution.MethodData.Access.PUBLIC), java.util.EnumSet.allOf(selectionresolution.MethodData.Context.class), java.util.EnumSet.of(selectionresolution.ClassData.Package.SAME));

	public static final selectionresolution.Template OverrideAbstractExpectedClass = selectionresolution.Template.ResolutionOverride(java.util.EnumSet.allOf(selectionresolution.Template.Kind.class), java.util.EnumSet.of(selectionresolution.MethodData.Access.PUBLIC), java.util.EnumSet.allOf(selectionresolution.MethodData.Context.class), java.util.EnumSet.of(selectionresolution.ClassData.Package.SAME));

	public static final selectionresolution.Template SelectionOverrideAbstract = new selectionresolution.Template("SelectionOverrideAbstract", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData expected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData olddef = expected.methoddata;
		if (selectionresolution.MethodData.Context.ABSTRACT == olddef.context) {
			final selectionresolution.ClassData.Package pck = expected.packageId;
			final selectionresolution.MethodData.Access acc = olddef.access;
			final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
			final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
			final int C2 = builder.objectref;
			final int C1 = builder.addClass(withDef);
			builder.hier.addInherit(C1, C2);
			builder.objectref = C1;
			builder.expected = C1;
		}
	});

	public static final selectionresolution.Template IgnoredAbstract = new selectionresolution.Template("IgnoredAbstract", ( builder) -> {
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData methodref = builder.classdata.get(builder.methodref);
		final selectionresolution.ClassData.Package pck = methodref.packageId;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.ABSTRACT);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.addInterface(withDef);
		final int C1 = builder.methodref;
		builder.hier.addInherit(C1, C2);
	});

	public static final selectionresolution.Template TrivialObjectref = new selectionresolution.Template("TrivialObjectref", java.util.Collections.singleton(( builder) -> {
		builder.objectref = builder.methodref;
	}));

	public static final selectionresolution.Template TrivialObjectrefNotEqualMethodref = new selectionresolution.Template("TrivialObjectrefNotEqualMethodref", java.util.Collections.singleton((final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = oldexpected.packageId;
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}));

	public static final selectionresolution.Template MethodrefSelectionResolvedIsClassNoOverride = new selectionresolution.Template("MethodrefSelectionResolvedIsClassNoOverride", ( builder) -> {
		builder.objectref = builder.methodref;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = oldexpected.packageId;
		final selectionresolution.MethodData.Context ctx = builder.classdata.get(builder.expected).methoddata.context;
		final selectionresolution.MethodData.Access acc = builder.classdata.get(builder.expected).methoddata.access;
		final selectionresolution.MethodData mdata = selectionresolution.Template.getMethodData(acc, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template MethodrefSelectionResolvedIsClassOverride = new selectionresolution.Template("MethodrefSelectionResolvedIsClassOverride", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	});

	public static final selectionresolution.Template MethodrefSelectionResolvedIsClass = new selectionresolution.Template("MethodrefSelectionResolvedIsClass", selectionresolution.Template.MethodrefSelectionResolvedIsClassNoOverride, selectionresolution.Template.MethodrefSelectionResolvedIsClassOverride);

	public static final selectionresolution.Template MethodrefSelectionPackageSkipNoOverride = new selectionresolution.Template("MethodrefSelectionPackageSkipNoOverride", selectionresolution.Template.MethodrefSelectionResolvedIsClass, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withPrivDef);
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withPrivDef);
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withPrivDef);
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, meth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withPrivDef);
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template MethodrefSelectionPackageSkip = new selectionresolution.Template("MethodrefSelectionPackageSkip", selectionresolution.Template.MethodrefSelectionPackageSkipNoOverride, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.MethodData packmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPubDef = new selectionresolution.ClassData(pck, meth);
		final selectionresolution.ClassData withPackDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, packmeth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withPubDef);
		final int C1 = builder.addClass(withPackDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.MethodData packmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPubDef = new selectionresolution.ClassData(pck, meth);
		final selectionresolution.ClassData withPackDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, packmeth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C4 = builder.methodref;
		final int C3 = builder.addClass(withPubDef);
		final int C2 = builder.addClass(withPrivDef);
		final int C1 = builder.addClass(withPackDef);
		builder.hier.addInherit(C3, C4);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.MethodData packmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPubDef = new selectionresolution.ClassData(pck, meth);
		final selectionresolution.ClassData withPackDef = new selectionresolution.ClassData(selectionresolution.ClassData.Package.OTHER, packmeth);
		final selectionresolution.MethodData privmeth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, privmeth);
		final int C4 = builder.methodref;
		final int C3 = builder.addClass(withPubDef);
		final int C2 = builder.addClass(withPackDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C3, C4);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C2;
		builder.expected = C2;
	});

	public static final selectionresolution.Template MethodrefSelectionResolvedIsIfaceNoOverride = new selectionresolution.Template("MethodrefSelectionResolvedIsIfaceNoOverride", ( builder) -> {
		builder.objectref = builder.methodref;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C2 = builder.methodref;
		final int I = builder.expected;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withPrivDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.expected;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withPrivDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I1 = builder.addInterface(withPrivDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C2 = builder.methodref;
		final int I1 = builder.addInterface(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template MethodrefSelectionResolvedIsIface = new selectionresolution.Template("MethodrefSelectionResolvedIsIface", selectionresolution.Template.MethodrefSelectionResolvedIsIfaceNoOverride, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(withDef);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C2 = builder.methodref;
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.expected;
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(I1, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withPrivDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(withStatDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withPrivDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int C3 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int I3 = builder.expected;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C1;
		builder.expected = C2;
	});

	public static final selectionresolution.Template IfaceMethodrefSelectionNoOverride = new selectionresolution.Template("IfaceMethodrefSelectionNoOverride", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final int I = builder.methodref;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C = builder.addClass(withStatDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.objectref = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withPrivDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withPrivDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I = builder.methodref;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C2 = builder.addClass(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C3, I2);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withPrivDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withStatDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I1 = builder.methodref;
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I2);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withPrivDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withStatDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template IfaceMethodrefSelection = new selectionresolution.Template("IfaceMethodrefSelection", selectionresolution.Template.IfaceMethodrefSelectionNoOverride, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I = builder.methodref;
		final int C = builder.addClass(withDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
		builder.expected = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.objectref = C;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.expected = C2;
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I3 = builder.methodref;
		final int I2 = builder.addInterface(withDef);
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(I1, I3);
		builder.hier.addInherit(I2, I3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = I2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I1 = builder.methodref;
		final int C3 = builder.addClass(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C3;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C3 = builder.addClass(withDef);
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I1);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I2);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C3;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
		builder.expected = I1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PRIVATE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withPrivDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withPrivDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I3 = builder.expected;
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(withStatDef);
		final int C3 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, I2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C3, I3);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C1, I1);
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, oldexpected.methoddata);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, selectionresolution.MethodData.Context.STATIC);
		final selectionresolution.ClassData withStatDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C3 = builder.addClass(withDef);
		final int C2 = builder.addClass(withStatDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C2, I);
		builder.expected = C3;
		builder.objectref = C1;
	});

	public static final selectionresolution.Template IfaceMethodrefSelectionOverrideNonPublic = new selectionresolution.Template("IfaceMethodrefSelection", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C = builder.addClass(withDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
		builder.expected = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.methodref).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C = builder.addClass(withDef);
		builder.hier.addInherit(C, I);
		builder.objectref = C;
		builder.expected = C;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.methodref;
		final int I1 = builder.addInterface(selectionresolution.Template.emptyClass(pck));
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(I1, I2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I2 = builder.expected;
		final int I1 = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I1);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I2);
		builder.objectref = C1;
		builder.expected = C2;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PROTECTED, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.expected = C2;
		builder.objectref = C1;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.expected).packageId;
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.MethodData meth = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PACKAGE, selectionresolution.MethodData.Context.INSTANCE);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, meth);
		final int I = builder.methodref;
		final int C2 = builder.addClass(withDef);
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, I);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C2, I);
		builder.expected = C2;
		builder.objectref = C1;
	});

	public static final selectionresolution.Template MethodrefAmbiguousResolvedIsIface = new selectionresolution.Template("MethodrefAmbiguousResolvedIsIface", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = oldexpected.packageId;
		final selectionresolution.MethodData.Context ctx = oldexpected.methoddata.context;
		final selectionresolution.MethodData mdata = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.methodref;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template IfaceMethodrefAmbiguousResolvedIsIface = new selectionresolution.Template("IfaceMethodrefAmbiguousResolvedIsIface", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = oldexpected.packageId;
		final selectionresolution.MethodData.Context ctx = oldexpected.methoddata.context;
		final selectionresolution.MethodData mdata = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int I1 = builder.methodref;
		final int C = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I2 = builder.addInterface(withDef);
		builder.hier.addInherit(C, I1);
		builder.hier.addInherit(C, I2);
		builder.objectref = C;
	});

	public static final selectionresolution.Template InvokespecialAmbiguousResolvedIsIface = new selectionresolution.Template("InvokespecialAmbiguousResolvedIsIface", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData oldexpected = builder.classdata.get(builder.expected);
		final selectionresolution.ClassData.Package pck = oldexpected.packageId;
		final selectionresolution.MethodData.Context ctx = oldexpected.methoddata.context;
		final selectionresolution.MethodData mdata = new selectionresolution.MethodData(selectionresolution.MethodData.Access.PUBLIC, ctx);
		final selectionresolution.ClassData withDef = new selectionresolution.ClassData(pck, mdata);
		final int C2 = builder.callsite;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int I = builder.addInterface(withDef);
		builder.hier.addInherit(C1, C2);
		builder.hier.addInherit(C1, I);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template ObjectrefAssignableToCallsite = new selectionresolution.Template("ObjectrefAssignableToCallsite", ( builder) -> {
		builder.objectref = builder.callsite;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.callsite).packageId;
		final int C2 = builder.callsite;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template ObjectrefExactSubclassOfCallsite = new selectionresolution.Template("ObjectrefSubclassOfCallsite", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.callsite).packageId;
		final int C2 = builder.callsite;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template ObjectrefEqualsOrExactSubclassOfCallsite = new selectionresolution.Template("ObjectrefEqualsOrExactSubclassOfCallsite", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		builder.objectref = builder.callsite;
	}, (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.callsite).packageId;
		final int C2 = builder.callsite;
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	public static final selectionresolution.Template ObjectrefEqualsCallsite = new selectionresolution.Template("TrivialObjectref", java.util.Collections.singleton(( builder) -> {
		builder.objectref = builder.callsite;
	}));

	public static final selectionresolution.Template ObjectrefSubclassOfSubclassOfCallsite = new selectionresolution.Template("ObjectrefSubclassOfCallsite", (final selectionresolution.SelectionResolutionTestCase.Builder builder) -> {
		final selectionresolution.ClassData.Package pck = builder.classdata.get(builder.callsite).packageId;
		final int C3 = builder.callsite;
		final int C2 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		final int C1 = builder.addClass(selectionresolution.Template.emptyClass(pck));
		builder.hier.addInherit(C2, C3);
		builder.hier.addInherit(C1, C2);
		builder.objectref = C1;
	});

	private static class Placeholder extends selectionresolution.ClassData {
		private final java.lang.String placeholder;

		private Placeholder(final java.lang.String placeholder, final selectionresolution.MethodData methoddata) {
			super(selectionresolution.ClassData.Package.PLACEHOLDER, methoddata);
			this.placeholder = placeholder;
		}

		private Placeholder(final java.lang.String placeholder) {
			this(placeholder, null);
		}

		public java.lang.String toString() {
			return (" = <Placeholder for " + placeholder) + ">\n\n";
		}

		public static final selectionresolution.Template.Placeholder objectref = new selectionresolution.Template.Placeholder("objectref");

		public static final selectionresolution.Template.Placeholder methodref = new selectionresolution.Template.Placeholder("methodref");

		public static final selectionresolution.Template.Placeholder callsite = new selectionresolution.Template.Placeholder("callsite");

		public static final selectionresolution.Template.Placeholder expected = new selectionresolution.Template.Placeholder("expected", new selectionresolution.MethodData(selectionresolution.MethodData.Access.PLACEHOLDER, selectionresolution.MethodData.Context.PLACEHOLDER));
	}

	public static void main(java.lang.String... args) {
		java.lang.System.err.println("*** Resolution Templates ***\n");
		final selectionresolution.SelectionResolutionTestCase.Builder withExpectedIface = new selectionresolution.SelectionResolutionTestCase.Builder();
		withExpectedIface.expected = withExpectedIface.addInterface(selectionresolution.Template.Placeholder.expected);
		final selectionresolution.SelectionResolutionTestCase.Builder withExpectedClass = new selectionresolution.SelectionResolutionTestCase.Builder();
		withExpectedClass.expected = withExpectedClass.addClass(selectionresolution.Template.Placeholder.expected);
		selectionresolution.Template.MethodrefNotEqualsExpectedClass.printCases(withExpectedClass);
		selectionresolution.Template.MethodrefNotEqualsExpectedIface.printCases(withExpectedIface);
		selectionresolution.Template.IfaceMethodrefNotEqualsExpected.printCases(withExpectedIface);
		selectionresolution.Template.MethodrefAmbiguous.printCases(withExpectedIface);
		selectionresolution.Template.IfaceMethodrefAmbiguous.printCases(withExpectedIface);
		selectionresolution.Template.ReabstractExpectedIface.printCases(withExpectedIface);
		selectionresolution.Template.ReabstractExpectedClass.printCases(withExpectedClass);
		final selectionresolution.SelectionResolutionTestCase.Builder methodrefExpectedIface = withExpectedIface.copy();
		methodrefExpectedIface.methodref = methodrefExpectedIface.addClass(selectionresolution.Template.Placeholder.methodref);
		final selectionresolution.SelectionResolutionTestCase.Builder methodrefExpectedClass = withExpectedClass.copy();
		methodrefExpectedClass.methodref = methodrefExpectedClass.addClass(selectionresolution.Template.Placeholder.methodref);
		final selectionresolution.SelectionResolutionTestCase.Builder ifaceMethodref = withExpectedIface.copy();
		ifaceMethodref.methodref = ifaceMethodref.addInterface(selectionresolution.Template.Placeholder.methodref);
		selectionresolution.Template.IgnoredAbstract.printCases(methodrefExpectedIface);
		selectionresolution.Template.MethodrefSelectionResolvedIsClass.printCases(methodrefExpectedClass);
		selectionresolution.Template.MethodrefSelectionResolvedIsIface.printCases(methodrefExpectedIface);
		selectionresolution.Template.IfaceMethodrefSelection.printCases(ifaceMethodref);
		selectionresolution.Template.IfaceMethodrefSelectionOverrideNonPublic.printCases(ifaceMethodref);
	}
}