public class Test8007722 {
	int i;

	static java.util.concurrent.atomic.AtomicReference<compiler.c2.Test8007722> ref;

	static int test(compiler.c2.Test8007722 new_obj) {
		compiler.c2.Test8007722 o = compiler.c2.Test8007722.ref.getAndSet(new_obj);
		int ret = o.i;
		o.i = 5;
		return ret;
	}

	public static void main(java.lang.String[] args) {
		compiler.c2.Test8007722 obj = new compiler.c2.Test8007722();
		compiler.c2.Test8007722.ref = new java.util.concurrent.atomic.AtomicReference<compiler.c2.Test8007722>(obj);
		for (int i = 0; i < 20000; i++) {
			compiler.c2.Test8007722.test(obj);
		}
		java.lang.System.out.println("PASSED");
	}
}