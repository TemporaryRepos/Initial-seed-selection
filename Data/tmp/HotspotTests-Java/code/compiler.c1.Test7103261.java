public class Test7103261 {
	static compiler.c1.Test7103261 null_value;

	static compiler.c1.Test7103261 nonnull_value = new compiler.c1.Test7103261();

	static compiler.c1.Test7103261 nonnull_value2 = new compiler.c1.Test7103261();

	long l;

	int i;

	float f;

	double d;

	byte b;

	char c;

	short s;

	boolean z;

	java.lang.Object o;

	public static void main(java.lang.String[] args) {
		compiler.c1.Test7103261.constantStore();
		compiler.c1.Test7103261.valueTest(false);
		compiler.c1.Test7103261.valueTest(true);
	}

	static void constantStore() {
		for (int field = 0; field < 9; field++) {
			try {
				compiler.c1.Test7103261 o = compiler.c1.Test7103261.nonnull_value;
				for (int i = 0; i < 100000; i++) {
					switch (field) {
						case 0 :
							o.l = 0;
							break;
						case 1 :
							o.i = 0;
							break;
						case 2 :
							o.f = 0;
							break;
						case 3 :
							o.d = 0;
							break;
						case 4 :
							o.b = 0;
							break;
						case 5 :
							o.c = 0;
							break;
						case 6 :
							o.s = 0;
							break;
						case 7 :
							o.z = false;
							break;
						case 8 :
							o.o = null;
							break;
						default :
							throw new java.lang.InternalError();
					}
					if (i == 90000) {
						o = compiler.c1.Test7103261.null_value;
					}
				}
			} catch (java.lang.NullPointerException npe) {
			}
		}
	}

	static void valueTest(boolean store) {
		for (int field = 0; field < 9; field++) {
			try {
				compiler.c1.Test7103261 o = compiler.c1.Test7103261.nonnull_value;
				compiler.c1.Test7103261 o2 = compiler.c1.Test7103261.nonnull_value2;
				for (int i = 0; i < 100000; i++) {
					switch (field) {
						case 0 :
							o.l = o2.l;
							break;
						case 1 :
							o.i = o2.i;
							break;
						case 2 :
							o.f = o2.f;
							break;
						case 3 :
							o.d = o2.d;
							break;
						case 4 :
							o.b = o2.b;
							break;
						case 5 :
							o.c = o2.c;
							break;
						case 6 :
							o.s = o2.s;
							break;
						case 7 :
							o.z = o2.z;
							break;
						case 8 :
							o.o = o2.o;
							break;
						default :
							throw new java.lang.InternalError();
					}
					if (i == 90000) {
						if (store) {
							o = compiler.c1.Test7103261.null_value;
						} else {
							o2 = compiler.c1.Test7103261.null_value;
						}
					}
				}
			} catch (java.lang.NullPointerException npe) {
			}
		}
	}
}