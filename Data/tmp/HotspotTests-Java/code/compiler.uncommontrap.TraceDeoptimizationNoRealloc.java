public class TraceDeoptimizationNoRealloc {
	static void m(boolean some_condition) {
		if (some_condition) {
			return;
		}
	}

	public static void main(java.lang.String[] args) {
		for (int i = 0; i < 20000; i++) {
			compiler.uncommontrap.TraceDeoptimizationNoRealloc.m(false);
		}
		compiler.uncommontrap.TraceDeoptimizationNoRealloc.m(true);
	}
}