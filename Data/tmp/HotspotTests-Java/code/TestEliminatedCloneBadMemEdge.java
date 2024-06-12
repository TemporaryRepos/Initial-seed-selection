public class TestEliminatedCloneBadMemEdge implements java.lang.Cloneable {
	int f1;

	int f2;

	int f3;

	int f4;

	int f5;

	int f6;

	int f7;

	int f8;

	int f9;

	static void not_inlined() {
	}

	static void test(TestEliminatedCloneBadMemEdge o1) throws java.lang.CloneNotSupportedException {
		TestEliminatedCloneBadMemEdge o2 = ((TestEliminatedCloneBadMemEdge) (o1.clone()));
		TestEliminatedCloneBadMemEdge.not_inlined();
		o2.f1 = 0x42;
	}

	public static void main(java.lang.String[] args) throws java.lang.CloneNotSupportedException {
		TestEliminatedCloneBadMemEdge o1 = new TestEliminatedCloneBadMemEdge();
		for (int i = 0; i < 20000; i++) {
			TestEliminatedCloneBadMemEdge.test(o1);
		}
	}
}