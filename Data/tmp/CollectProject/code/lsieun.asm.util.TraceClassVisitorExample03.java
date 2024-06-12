@java.lang.SuppressWarnings("Duplicates")
public class TraceClassVisitorExample03 {
	public static void main(java.lang.String[] args) {
		java.io.PrintWriter printWriter = new java.io.PrintWriter(java.lang.System.out);
		org.objectweb.asm.util.TraceClassVisitor cv = new org.objectweb.asm.util.TraceClassVisitor(null, printWriter);
		cv.visit(org.objectweb.asm.Opcodes.V1_7, (org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_ABSTRACT) + org.objectweb.asm.Opcodes.ACC_INTERFACE, "sample/HelloWorld", null, "java/lang/Object", new java.lang.String[]{ "java/io/Serializable" });
		cv.visitField((org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_FINAL) + org.objectweb.asm.Opcodes.ACC_STATIC, "LESS", "I", null, new java.lang.Integer(-1)).visitEnd();
		cv.visitField((org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_FINAL) + org.objectweb.asm.Opcodes.ACC_STATIC, "EQUAL", "I", null, new java.lang.Integer(0)).visitEnd();
		cv.visitField((org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_FINAL) + org.objectweb.asm.Opcodes.ACC_STATIC, "GREATER", "I", null, new java.lang.Integer(1)).visitEnd();
		cv.visitMethod(org.objectweb.asm.Opcodes.ACC_PUBLIC + org.objectweb.asm.Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
		cv.visitEnd();
	}
}