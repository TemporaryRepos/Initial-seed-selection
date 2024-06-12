public class TestEliminatedCastPPAtPhi {
	static compiler.controldependency.TestEliminatedCastPPAtPhi saved;

	static compiler.controldependency.TestEliminatedCastPPAtPhi saved_not_null;

	int f;

	static int test(compiler.controldependency.TestEliminatedCastPPAtPhi obj, int[] array, boolean flag) {
		int ret = array[0] + array[20];
		compiler.controldependency.TestEliminatedCastPPAtPhi.saved = obj;
		if (obj == null) {
			return ret;
		}
		compiler.controldependency.TestEliminatedCastPPAtPhi.saved_not_null = obj;
		int i = 0;
		for (; i < 10; i++);
		ret += array[i];
		compiler.controldependency.TestEliminatedCastPPAtPhi res;
		if (flag) {
			res = compiler.controldependency.TestEliminatedCastPPAtPhi.saved;
		} else {
			res = compiler.controldependency.TestEliminatedCastPPAtPhi.saved_not_null;
		}
		return ret + res.f;
	}

	public static void main(java.lang.String[] args) {
		int[] array = new int[100];
		compiler.controldependency.TestEliminatedCastPPAtPhi obj = new compiler.controldependency.TestEliminatedCastPPAtPhi();
		for (int i = 0; i < 20000; i++) {
			compiler.controldependency.TestEliminatedCastPPAtPhi.test(obj, array, (i % 2) == 0);
		}
		compiler.controldependency.TestEliminatedCastPPAtPhi.test(null, array, true);
	}
}