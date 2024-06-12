public class Verifier {
	private final java.lang.String classname;

	private org.apache.bcel.verifier.statics.Pass1Verifier p1v;

	private org.apache.bcel.verifier.statics.Pass2Verifier p2v;

	private final java.util.Map<java.lang.String, org.apache.bcel.verifier.statics.Pass3aVerifier> p3avs = new java.util.HashMap<>();

	private final java.util.Map<java.lang.String, org.apache.bcel.verifier.structurals.Pass3bVerifier> p3bvs = new java.util.HashMap<>();

	public org.apache.bcel.verifier.VerificationResult doPass1() {
		if (p1v == null) {
			p1v = new org.apache.bcel.verifier.statics.Pass1Verifier(this);
		}
		return p1v.verify();
	}

	public org.apache.bcel.verifier.VerificationResult doPass2() {
		if (p2v == null) {
			p2v = new org.apache.bcel.verifier.statics.Pass2Verifier(this);
		}
		return p2v.verify();
	}

	public org.apache.bcel.verifier.VerificationResult doPass3a(final int method_no) {
		final java.lang.String key = java.lang.Integer.toString(method_no);
		org.apache.bcel.verifier.statics.Pass3aVerifier p3av;
		p3av = p3avs.get(key);
		if (p3avs.get(key) == null) {
			p3av = new org.apache.bcel.verifier.statics.Pass3aVerifier(this, method_no);
			p3avs.put(key, p3av);
		}
		return p3av.verify();
	}

	public org.apache.bcel.verifier.VerificationResult doPass3b(final int method_no) {
		final java.lang.String key = java.lang.Integer.toString(method_no);
		org.apache.bcel.verifier.structurals.Pass3bVerifier p3bv;
		p3bv = p3bvs.get(key);
		if (p3bvs.get(key) == null) {
			p3bv = new org.apache.bcel.verifier.structurals.Pass3bVerifier(this, method_no);
			p3bvs.put(key, p3bv);
		}
		return p3bv.verify();
	}

	Verifier(final java.lang.String fully_qualified_classname) {
		classname = fully_qualified_classname;
		flush();
	}

	public final java.lang.String getClassName() {
		return classname;
	}

	public void flush() {
		p1v = null;
		p2v = null;
		p3avs.clear();
		p3bvs.clear();
	}

	public java.lang.String[] getMessages() throws java.lang.ClassNotFoundException {
		final java.util.List<java.lang.String> messages = new java.util.ArrayList<>();
		if (p1v != null) {
			final java.lang.String[] p1m = p1v.getMessages();
			for (final java.lang.String element : p1m) {
				messages.add("Pass 1: " + element);
			}
		}
		if (p2v != null) {
			final java.lang.String[] p2m = p2v.getMessages();
			for (final java.lang.String element : p2m) {
				messages.add("Pass 2: " + element);
			}
		}
		for (final org.apache.bcel.verifier.statics.Pass3aVerifier pv : p3avs.values()) {
			final java.lang.String[] p3am = pv.getMessages();
			final int meth = pv.getMethodNo();
			for (final java.lang.String element : p3am) {
				messages.add((((("Pass 3a, method " + meth) + " ('") + org.apache.bcel.Repository.lookupClass(classname).getMethods()[meth]) + "'): ") + element);
			}
		}
		for (final org.apache.bcel.verifier.structurals.Pass3bVerifier pv : p3bvs.values()) {
			final java.lang.String[] p3bm = pv.getMessages();
			final int meth = pv.getMethodNo();
			for (final java.lang.String element : p3bm) {
				messages.add((((("Pass 3b, method " + meth) + " ('") + org.apache.bcel.Repository.lookupClass(classname).getMethods()[meth]) + "'): ") + element);
			}
		}
		return messages.toArray(new java.lang.String[messages.size()]);
	}

	public static void main(final java.lang.String[] args) {
		java.lang.System.out.println("JustIce by Enver Haase, (C) 2001-2002.\n<http://bcel.sourceforge.net>\n<http://commons.apache.org/bcel>\n");
		for (int k = 0; k < args.length; k++) {
			try {
				if (args[k].endsWith(".class")) {
					final int dotclasspos = args[k].lastIndexOf(".class");
					if (dotclasspos != (-1)) {
						args[k] = args[k].substring(0, dotclasspos);
					}
				}
				args[k] = args[k].replace('/', '.');
				java.lang.System.out.println(("Now verifying: " + args[k]) + "\n");
				final org.apache.bcel.verifier.Verifier v = org.apache.bcel.verifier.VerifierFactory.getVerifier(args[k]);
				org.apache.bcel.verifier.VerificationResult vr;
				vr = v.doPass1();
				java.lang.System.out.println("Pass 1:\n" + vr);
				vr = v.doPass2();
				java.lang.System.out.println("Pass 2:\n" + vr);
				if (vr == org.apache.bcel.verifier.VerificationResult.VR_OK) {
					final org.apache.bcel.classfile.JavaClass jc = org.apache.bcel.Repository.lookupClass(args[k]);
					for (int i = 0; i < jc.getMethods().length; i++) {
						vr = v.doPass3a(i);
						java.lang.System.out.println((((("Pass 3a, method number " + i) + " ['") + jc.getMethods()[i]) + "\']:\n") + vr);
						vr = v.doPass3b(i);
						java.lang.System.out.println((((("Pass 3b, method number " + i) + " ['") + jc.getMethods()[i]) + "\']:\n") + vr);
					}
				}
				java.lang.System.out.println("Warnings:");
				final java.lang.String[] warnings = v.getMessages();
				if (warnings.length == 0) {
					java.lang.System.out.println("<none>");
				}
				for (final java.lang.String warning : warnings) {
					java.lang.System.out.println(warning);
				}
				java.lang.System.out.println("\n");
				v.flush();
				org.apache.bcel.Repository.clearCache();
				java.lang.System.gc();
			} catch (final java.lang.ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}