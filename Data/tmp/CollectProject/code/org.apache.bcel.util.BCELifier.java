public class BCELifier extends org.apache.bcel.classfile.EmptyVisitor {
	public enum FLAGS {

		UNKNOWN,
		CLASS,
		METHOD;}

	private static final java.lang.String BASE_PACKAGE = org.apache.bcel.Const.class.getPackage().getName();

	private static final java.lang.String CONSTANT_PREFIX = org.apache.bcel.Const.class.getSimpleName() + ".";

	private final org.apache.bcel.classfile.JavaClass _clazz;

	private final java.io.PrintWriter _out;

	private final org.apache.bcel.generic.ConstantPoolGen _cp;

	public BCELifier(final org.apache.bcel.classfile.JavaClass clazz, final java.io.OutputStream out) {
		_clazz = clazz;
		_out = new java.io.PrintWriter(out);
		_cp = new org.apache.bcel.generic.ConstantPoolGen(_clazz.getConstantPool());
	}

	public void start() {
		visitJavaClass(_clazz);
		_out.flush();
	}

	@java.lang.Override
	public void visitJavaClass(final org.apache.bcel.classfile.JavaClass clazz) {
		java.lang.String class_name = clazz.getClassName();
		final java.lang.String super_name = clazz.getSuperclassName();
		final java.lang.String package_name = clazz.getPackageName();
		final java.lang.String inter = org.apache.bcel.classfile.Utility.printArray(clazz.getInterfaceNames(), false, true);
		if (!"".equals(package_name)) {
			class_name = class_name.substring(package_name.length() + 1);
			_out.println(("package " + package_name) + ";");
			_out.println();
		}
		_out.println(("import " + org.apache.bcel.util.BCELifier.BASE_PACKAGE) + ".generic.*;");
		_out.println(("import " + org.apache.bcel.util.BCELifier.BASE_PACKAGE) + ".classfile.*;");
		_out.println(("import " + org.apache.bcel.util.BCELifier.BASE_PACKAGE) + ".*;");
		_out.println("import java.io.*;");
		_out.println();
		_out.println(("public class " + class_name) + "Creator {");
		_out.println("  private InstructionFactory _factory;");
		_out.println("  private ConstantPoolGen    _cp;");
		_out.println("  private ClassGen           _cg;");
		_out.println();
		_out.println(("  public " + class_name) + "Creator() {");
		_out.println(((((((((((("    _cg = new ClassGen(\"" + ("".equals(package_name) ? class_name : (package_name + ".") + class_name)) + "\", \"") + super_name) + "\", ") + "\"") + clazz.getSourceFileName()) + "\", ") + org.apache.bcel.util.BCELifier.printFlags(clazz.getAccessFlags(), org.apache.bcel.util.BCELifier.FLAGS.CLASS)) + ", ") + "new String[] { ") + inter) + " });");
		_out.println();
		_out.println("    _cp = _cg.getConstantPool();");
		_out.println("    _factory = new InstructionFactory(_cg, _cp);");
		_out.println("  }");
		_out.println();
		printCreate();
		final org.apache.bcel.classfile.Field[] fields = clazz.getFields();
		if (fields.length > 0) {
			_out.println("  private void createFields() {");
			_out.println("    FieldGen field;");
			for (final org.apache.bcel.classfile.Field field : fields) {
				field.accept(this);
			}
			_out.println("  }");
			_out.println();
		}
		final org.apache.bcel.classfile.Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			_out.println(("  private void createMethod_" + i) + "() {");
			methods[i].accept(this);
			_out.println("  }");
			_out.println();
		}
		printMain();
		_out.println("}");
	}

	private void printCreate() {
		_out.println("  public void create(OutputStream out) throws IOException {");
		final org.apache.bcel.classfile.Field[] fields = _clazz.getFields();
		if (fields.length > 0) {
			_out.println("    createFields();");
		}
		final org.apache.bcel.classfile.Method[] methods = _clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			_out.println(("    createMethod_" + i) + "();");
		}
		_out.println("    _cg.getJavaClass().dump(out);");
		_out.println("  }");
		_out.println();
	}

	private void printMain() {
		final java.lang.String class_name = _clazz.getClassName();
		_out.println("  public static void main(String[] args) throws Exception {");
		_out.println(((("    " + class_name) + "Creator creator = new ") + class_name) + "Creator();");
		_out.println(("    creator.create(new FileOutputStream(\"" + class_name) + ".class\"));");
		_out.println("  }");
	}

	@java.lang.Override
	public void visitField(final org.apache.bcel.classfile.Field field) {
		_out.println();
		_out.println(((((("    field = new FieldGen(" + org.apache.bcel.util.BCELifier.printFlags(field.getAccessFlags())) + ", ") + org.apache.bcel.util.BCELifier.printType(field.getSignature())) + ", \"") + field.getName()) + "\", _cp);");
		final org.apache.bcel.classfile.ConstantValue cv = field.getConstantValue();
		if (cv != null) {
			final java.lang.String value = cv.toString();
			_out.println(("    field.setInitValue(" + value) + ")");
		}
		_out.println("    _cg.addField(field.getField());");
	}

	@java.lang.Override
	public void visitMethod(final org.apache.bcel.classfile.Method method) {
		final org.apache.bcel.generic.MethodGen mg = new org.apache.bcel.generic.MethodGen(method, _clazz.getClassName(), _cp);
		_out.println("    InstructionList il = new InstructionList();");
		_out.println((((((((((((("    MethodGen method = new MethodGen(" + org.apache.bcel.util.BCELifier.printFlags(method.getAccessFlags(), org.apache.bcel.util.BCELifier.FLAGS.METHOD)) + ", ") + org.apache.bcel.util.BCELifier.printType(mg.getReturnType())) + ", ") + org.apache.bcel.util.BCELifier.printArgumentTypes(mg.getArgumentTypes())) + ", ") + "new String[] { ") + org.apache.bcel.classfile.Utility.printArray(mg.getArgumentNames(), false, true)) + " }, \"") + method.getName()) + "\", \"") + _clazz.getClassName()) + "\", il, _cp);");
		_out.println();
		final org.apache.bcel.util.BCELFactory factory = new org.apache.bcel.util.BCELFactory(mg, _out);
		factory.start();
		_out.println("    method.setMaxStack();");
		_out.println("    method.setMaxLocals();");
		_out.println("    _cg.addMethod(method.getMethod());");
		_out.println("    il.dispose();");
	}

	static java.lang.String printFlags(final int flags) {
		return org.apache.bcel.util.BCELifier.printFlags(flags, org.apache.bcel.util.BCELifier.FLAGS.UNKNOWN);
	}

	public static java.lang.String printFlags(final int flags, final org.apache.bcel.util.BCELifier.FLAGS location) {
		if (flags == 0) {
			return "0";
		}
		final java.lang.StringBuilder buf = new java.lang.StringBuilder();
		for (int i = 0, pow = 1; pow <= org.apache.bcel.Const.MAX_ACC_FLAG; i++) {
			if ((flags & pow) != 0) {
				if ((pow == org.apache.bcel.Const.ACC_SYNCHRONIZED) && (location == org.apache.bcel.util.BCELifier.FLAGS.CLASS)) {
					buf.append(org.apache.bcel.util.BCELifier.CONSTANT_PREFIX + "ACC_SUPER | ");
				} else if ((pow == org.apache.bcel.Const.ACC_VOLATILE) && (location == org.apache.bcel.util.BCELifier.FLAGS.METHOD)) {
					buf.append(org.apache.bcel.util.BCELifier.CONSTANT_PREFIX + "ACC_BRIDGE | ");
				} else if ((pow == org.apache.bcel.Const.ACC_TRANSIENT) && (location == org.apache.bcel.util.BCELifier.FLAGS.METHOD)) {
					buf.append(org.apache.bcel.util.BCELifier.CONSTANT_PREFIX + "ACC_VARARGS | ");
				} else if (i < org.apache.bcel.Const.ACCESS_NAMES_LENGTH) {
					buf.append(org.apache.bcel.util.BCELifier.CONSTANT_PREFIX + "ACC_").append(org.apache.bcel.Const.getAccessName(i).toUpperCase(java.util.Locale.ENGLISH)).append(" | ");
				} else {
					buf.append(java.lang.String.format(org.apache.bcel.util.BCELifier.CONSTANT_PREFIX + "ACC_BIT %x | ", pow));
				}
			}
			pow <<= 1;
		}
		final java.lang.String str = buf.toString();
		return str.substring(0, str.length() - 3);
	}

	static java.lang.String printArgumentTypes(final org.apache.bcel.generic.Type[] arg_types) {
		if (arg_types.length == 0) {
			return "Type.NO_ARGS";
		}
		final java.lang.StringBuilder args = new java.lang.StringBuilder();
		for (int i = 0; i < arg_types.length; i++) {
			args.append(org.apache.bcel.util.BCELifier.printType(arg_types[i]));
			if (i < (arg_types.length - 1)) {
				args.append(", ");
			}
		}
		return ("new Type[] { " + args.toString()) + " }";
	}

	static java.lang.String printType(final org.apache.bcel.generic.Type type) {
		return org.apache.bcel.util.BCELifier.printType(type.getSignature());
	}

	static java.lang.String printType(final java.lang.String signature) {
		final org.apache.bcel.generic.Type type = org.apache.bcel.generic.Type.getType(signature);
		final byte t = type.getType();
		if (t <= org.apache.bcel.Const.T_VOID) {
			return "Type." + org.apache.bcel.Const.getTypeName(t).toUpperCase(java.util.Locale.ENGLISH);
		} else if (type.toString().equals("java.lang.String")) {
			return "Type.STRING";
		} else if (type.toString().equals("java.lang.Object")) {
			return "Type.OBJECT";
		} else if (type.toString().equals("java.lang.StringBuffer")) {
			return "Type.STRINGBUFFER";
		} else if (type instanceof org.apache.bcel.generic.ArrayType) {
			final org.apache.bcel.generic.ArrayType at = ((org.apache.bcel.generic.ArrayType) (type));
			return ((("new ArrayType(" + org.apache.bcel.util.BCELifier.printType(at.getBasicType())) + ", ") + at.getDimensions()) + ")";
		} else {
			return ("new ObjectType(\"" + org.apache.bcel.classfile.Utility.signatureToString(signature, false)) + "\")";
		}
	}

	public static void main(final java.lang.String[] argv) throws java.lang.Exception {
		if (argv.length != 1) {
			java.lang.System.out.println("Usage: BCELifier classname");
			java.lang.System.out.println("\tThe class must exist on the classpath");
			return;
		}
		final org.apache.bcel.classfile.JavaClass java_class = org.apache.bcel.util.BCELifier.getJavaClass(argv[0]);
		final org.apache.bcel.util.BCELifier bcelifier = new org.apache.bcel.util.BCELifier(java_class, java.lang.System.out);
		bcelifier.start();
	}

	static org.apache.bcel.classfile.JavaClass getJavaClass(final java.lang.String name) throws java.lang.ClassNotFoundException, java.io.IOException {
		org.apache.bcel.classfile.JavaClass java_class;
		if ((java_class = org.apache.bcel.Repository.lookupClass(name)) == null) {
			java_class = new org.apache.bcel.classfile.ClassParser(name).parse();
		}
		return java_class;
	}
}