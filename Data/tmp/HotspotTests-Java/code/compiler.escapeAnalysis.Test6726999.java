public class Test6726999 {
	static class Point {
		int x;

		int y;
	}

	void dummy() {
	}

	int test0_0_0(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p.x = x;
		p.y = (3 * x) + y;
		return p.x * p.y;
	}

	int test0_0_1(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p = null;
		dummy();
		p = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p.x = x;
		p.y = (3 * x) + y;
		return p.x * p.y;
	}

	int test0_0_2(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p.x = x;
		p.y = (3 * x) + y;
		return p.x * p.y;
	}

	int test0_0_3(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_0_4(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_0_5(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = null;
		dummy();
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_0_6(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_1_3(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = p1;
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_1_4(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = p1;
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_1_5(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = null;
		dummy();
		p[0] = p1;
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test0_1_6(int y) {
		int x = 3;
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p2 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = p1;
		dummy();
		p[0] = p2;
		dummy();
		p[0].x = x;
		p[0].y = (3 * x) + y;
		return p[0].x * p[0].y;
	}

	int test1_0_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		if ((y & 1) == 1) {
			p = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_0_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = null;
		if ((y & 1) == 1) {
			p = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_0_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_0_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = null;
		if ((y & 1) == 1) {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_0_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		if ((y & 1) == 1) {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_0_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		} else {
			p[0] = null;
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_0_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		} else {
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_1_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		if ((y & 1) == 1) {
			dummy();
			p = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_1_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = null;
		if ((y & 1) == 1) {
			dummy();
			p = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_1_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_1_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = null;
		if ((y & 1) == 1) {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_1_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = new compiler.escapeAnalysis.Test6726999.Point();
		if ((y & 1) == 1) {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_1_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		} else {
			dummy();
			p[0] = null;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_1_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		} else {
			dummy();
			p[0] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_2_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		if ((y & 1) == 1) {
			dummy();
			p = p1;
			dummy();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_2_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p = null;
		if ((y & 1) == 1) {
			dummy();
			p = p1;
			dummy();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test1_2_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = p1;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_2_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = null;
		if ((y & 1) == 1) {
			dummy();
			p[0] = p1;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_2_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p2 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		dummy();
		p[0] = p1;
		if ((y & 1) == 1) {
			dummy();
			p[0] = p2;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_2_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = p1;
			dummy();
		} else {
			dummy();
			p[0] = null;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test1_2_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p2 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[1];
		if ((y & 1) == 1) {
			dummy();
			p[0] = p1;
			dummy();
		} else {
			dummy();
			p[0] = p2;
			dummy();
		}
		int x = 3;
		if (p[0] == null) {
			return ((3 * x) + y) * x;
		}
		p[0].x = x;
		p[0].y = (3 * x) + y;
		dummy();
		return p[0].x * p[0].y;
	}

	int test2_0_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_0_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_0_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_0_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int j = y & 1;
		p[j] = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_0_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int j = y & 1;
		p[j] = new compiler.escapeAnalysis.Test6726999.Point();
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_0_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		for (int i = 0; i < lim; i++) {
			p[i] = null;
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_0_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		for (int i = 0; i < lim; i++) {
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_1_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_1_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_1_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_1_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		dummy();
		int j = y & 1;
		p[j] = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_1_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		dummy();
		int j = y & 1;
		p[j] = new compiler.escapeAnalysis.Test6726999.Point();
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_1_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = null;
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_1_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = new compiler.escapeAnalysis.Test6726999.Point();
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_2_0(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p = p1;
			dummy();
		}
		int x = 3;
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_2_1(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p = p1;
			dummy();
		}
		int x = 3;
		if (p == null) {
			return ((3 * x) + y) * x;
		}
		p.x = x;
		p.y = (3 * x) + y;
		dummy();
		return p.x * p.y;
	}

	int test2_2_2(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p1;
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_2_3(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		dummy();
		int j = y & 1;
		p[j] = null;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p1;
			dummy();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_2_4(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p2 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		dummy();
		int j = y & 1;
		p[j] = p1;
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p2;
			dummy();
		}
		int x = 3;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_2_5(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p1;
			dummy();
		}
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = null;
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	int test2_2_6(int y) {
		compiler.escapeAnalysis.Test6726999.Point p1 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point p2 = new compiler.escapeAnalysis.Test6726999.Point();
		dummy();
		compiler.escapeAnalysis.Test6726999.Point[] p = new compiler.escapeAnalysis.Test6726999.Point[3];
		int lim = y & 3;
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p1;
			dummy();
		}
		for (int i = 0; i < lim; i++) {
			dummy();
			p[i] = p2;
			dummy();
		}
		int x = 3;
		int j = y & 1;
		if (p[j] == null) {
			return ((3 * x) + y) * x;
		}
		p[j].x = x;
		p[j].y = (3 * x) + y;
		dummy();
		return p[j].x * p[0].y;
	}

	public static void main(java.lang.String[] args) {
		compiler.escapeAnalysis.Test6726999 tsr = new compiler.escapeAnalysis.Test6726999();
		compiler.escapeAnalysis.Test6726999.Point p = new compiler.escapeAnalysis.Test6726999.Point();
		compiler.escapeAnalysis.Test6726999.Point ptmp = p;
		java.lang.Class cls = compiler.escapeAnalysis.Test6726999.Point.class;
		int y = 0;
		for (int i = 0; i < 10000; i++) {
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_6(y);
			y = tsr.test0_1_6(y);
			y = tsr.test1_0_0(y & (~1));
			y = tsr.test1_0_1(y & (~1));
			y = tsr.test1_0_2(y & (~1));
			y = tsr.test1_0_3(y & (~1));
			y = tsr.test1_0_4(y & (~1));
			y = tsr.test1_0_5(y & (~1));
			y = tsr.test1_0_6(y & (~1));
			y = tsr.test1_0_0((y & (~1)) + 1);
			y = tsr.test1_0_1((y & (~1)) + 1);
			y = tsr.test1_0_2((y & (~1)) + 1);
			y = tsr.test1_0_3((y & (~1)) + 1);
			y = tsr.test1_0_4((y & (~1)) + 1);
			y = tsr.test1_0_5((y & (~1)) + 1);
			y = tsr.test1_0_6((y & (~1)) + 1);
			y = tsr.test1_1_0(y & (~1));
			y = tsr.test1_1_1(y & (~1));
			y = tsr.test1_1_2(y & (~1));
			y = tsr.test1_1_3(y & (~1));
			y = tsr.test1_1_4(y & (~1));
			y = tsr.test1_1_5(y & (~1));
			y = tsr.test1_1_6(y & (~1));
			y = tsr.test1_1_0((y & (~1)) + 1);
			y = tsr.test1_1_1((y & (~1)) + 1);
			y = tsr.test1_1_2((y & (~1)) + 1);
			y = tsr.test1_1_3((y & (~1)) + 1);
			y = tsr.test1_1_4((y & (~1)) + 1);
			y = tsr.test1_1_5((y & (~1)) + 1);
			y = tsr.test1_1_6((y & (~1)) + 1);
			y = tsr.test1_2_0(y & (~1));
			y = tsr.test1_2_1(y & (~1));
			y = tsr.test1_2_2(y & (~1));
			y = tsr.test1_2_3(y & (~1));
			y = tsr.test1_2_4(y & (~1));
			y = tsr.test1_2_5(y & (~1));
			y = tsr.test1_2_6(y & (~1));
			y = tsr.test1_2_0((y & (~1)) + 1);
			y = tsr.test1_2_1((y & (~1)) + 1);
			y = tsr.test1_2_2((y & (~1)) + 1);
			y = tsr.test1_2_3((y & (~1)) + 1);
			y = tsr.test1_2_4((y & (~1)) + 1);
			y = tsr.test1_2_5((y & (~1)) + 1);
			y = tsr.test1_2_6((y & (~1)) + 1);
			y = tsr.test2_0_0(y & (~3));
			y = tsr.test2_0_1(y & (~3));
			y = tsr.test2_0_2(y & (~3));
			y = tsr.test2_0_3(y & (~3));
			y = tsr.test2_0_4(y & (~3));
			y = tsr.test2_0_5(y & (~3));
			y = tsr.test2_0_6(y & (~3));
			y = tsr.test2_0_0((y & (~3)) + 3);
			y = tsr.test2_0_1((y & (~3)) + 3);
			y = tsr.test2_0_2((y & (~3)) + 3);
			y = tsr.test2_0_3((y & (~3)) + 3);
			y = tsr.test2_0_4((y & (~3)) + 3);
			y = tsr.test2_0_5((y & (~3)) + 3);
			y = tsr.test2_0_6((y & (~3)) + 3);
			y = tsr.test2_1_0(y & (~3));
			y = tsr.test2_1_1(y & (~3));
			y = tsr.test2_1_2(y & (~3));
			y = tsr.test2_1_3(y & (~3));
			y = tsr.test2_1_4(y & (~3));
			y = tsr.test2_1_5(y & (~3));
			y = tsr.test2_1_6(y & (~3));
			y = tsr.test2_1_0((y & (~3)) + 3);
			y = tsr.test2_1_1((y & (~3)) + 3);
			y = tsr.test2_1_2((y & (~3)) + 3);
			y = tsr.test2_1_3((y & (~3)) + 3);
			y = tsr.test2_1_4((y & (~3)) + 3);
			y = tsr.test2_1_5((y & (~3)) + 3);
			y = tsr.test2_1_6((y & (~3)) + 3);
			y = tsr.test2_2_0(y & (~3));
			y = tsr.test2_2_1(y & (~3));
			y = tsr.test2_2_2(y & (~3));
			y = tsr.test2_2_3(y & (~3));
			y = tsr.test2_2_4(y & (~3));
			y = tsr.test2_2_5(y & (~3));
			y = tsr.test2_2_6(y & (~3));
			y = tsr.test2_2_0((y & (~3)) + 3);
			y = tsr.test2_2_1((y & (~3)) + 3);
			y = tsr.test2_2_2((y & (~3)) + 3);
			y = tsr.test2_2_3((y & (~3)) + 3);
			y = tsr.test2_2_4((y & (~3)) + 3);
			y = tsr.test2_2_5((y & (~3)) + 3);
			y = tsr.test2_2_6((y & (~3)) + 3);
		}
		for (int i = 0; i < 10000; i++) {
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_6(y);
			y = tsr.test0_1_6(y);
			y = tsr.test1_0_0(y & (~1));
			y = tsr.test1_0_1(y & (~1));
			y = tsr.test1_0_2(y & (~1));
			y = tsr.test1_0_3(y & (~1));
			y = tsr.test1_0_4(y & (~1));
			y = tsr.test1_0_5(y & (~1));
			y = tsr.test1_0_6(y & (~1));
			y = tsr.test1_0_0((y & (~1)) + 1);
			y = tsr.test1_0_1((y & (~1)) + 1);
			y = tsr.test1_0_2((y & (~1)) + 1);
			y = tsr.test1_0_3((y & (~1)) + 1);
			y = tsr.test1_0_4((y & (~1)) + 1);
			y = tsr.test1_0_5((y & (~1)) + 1);
			y = tsr.test1_0_6((y & (~1)) + 1);
			y = tsr.test1_1_0(y & (~1));
			y = tsr.test1_1_1(y & (~1));
			y = tsr.test1_1_2(y & (~1));
			y = tsr.test1_1_3(y & (~1));
			y = tsr.test1_1_4(y & (~1));
			y = tsr.test1_1_5(y & (~1));
			y = tsr.test1_1_6(y & (~1));
			y = tsr.test1_1_0((y & (~1)) + 1);
			y = tsr.test1_1_1((y & (~1)) + 1);
			y = tsr.test1_1_2((y & (~1)) + 1);
			y = tsr.test1_1_3((y & (~1)) + 1);
			y = tsr.test1_1_4((y & (~1)) + 1);
			y = tsr.test1_1_5((y & (~1)) + 1);
			y = tsr.test1_1_6((y & (~1)) + 1);
			y = tsr.test1_2_0(y & (~1));
			y = tsr.test1_2_1(y & (~1));
			y = tsr.test1_2_2(y & (~1));
			y = tsr.test1_2_3(y & (~1));
			y = tsr.test1_2_4(y & (~1));
			y = tsr.test1_2_5(y & (~1));
			y = tsr.test1_2_6(y & (~1));
			y = tsr.test1_2_0((y & (~1)) + 1);
			y = tsr.test1_2_1((y & (~1)) + 1);
			y = tsr.test1_2_2((y & (~1)) + 1);
			y = tsr.test1_2_3((y & (~1)) + 1);
			y = tsr.test1_2_4((y & (~1)) + 1);
			y = tsr.test1_2_5((y & (~1)) + 1);
			y = tsr.test1_2_6((y & (~1)) + 1);
			y = tsr.test2_0_0(y & (~3));
			y = tsr.test2_0_1(y & (~3));
			y = tsr.test2_0_2(y & (~3));
			y = tsr.test2_0_3(y & (~3));
			y = tsr.test2_0_4(y & (~3));
			y = tsr.test2_0_5(y & (~3));
			y = tsr.test2_0_6(y & (~3));
			y = tsr.test2_0_0((y & (~3)) + 3);
			y = tsr.test2_0_1((y & (~3)) + 3);
			y = tsr.test2_0_2((y & (~3)) + 3);
			y = tsr.test2_0_3((y & (~3)) + 3);
			y = tsr.test2_0_4((y & (~3)) + 3);
			y = tsr.test2_0_5((y & (~3)) + 3);
			y = tsr.test2_0_6((y & (~3)) + 3);
			y = tsr.test2_1_0(y & (~3));
			y = tsr.test2_1_1(y & (~3));
			y = tsr.test2_1_2(y & (~3));
			y = tsr.test2_1_3(y & (~3));
			y = tsr.test2_1_4(y & (~3));
			y = tsr.test2_1_5(y & (~3));
			y = tsr.test2_1_6(y & (~3));
			y = tsr.test2_1_0((y & (~3)) + 3);
			y = tsr.test2_1_1((y & (~3)) + 3);
			y = tsr.test2_1_2((y & (~3)) + 3);
			y = tsr.test2_1_3((y & (~3)) + 3);
			y = tsr.test2_1_4((y & (~3)) + 3);
			y = tsr.test2_1_5((y & (~3)) + 3);
			y = tsr.test2_1_6((y & (~3)) + 3);
			y = tsr.test2_2_0(y & (~3));
			y = tsr.test2_2_1(y & (~3));
			y = tsr.test2_2_2(y & (~3));
			y = tsr.test2_2_3(y & (~3));
			y = tsr.test2_2_4(y & (~3));
			y = tsr.test2_2_5(y & (~3));
			y = tsr.test2_2_6(y & (~3));
			y = tsr.test2_2_0((y & (~3)) + 3);
			y = tsr.test2_2_1((y & (~3)) + 3);
			y = tsr.test2_2_2((y & (~3)) + 3);
			y = tsr.test2_2_3((y & (~3)) + 3);
			y = tsr.test2_2_4((y & (~3)) + 3);
			y = tsr.test2_2_5((y & (~3)) + 3);
			y = tsr.test2_2_6((y & (~3)) + 3);
		}
		for (int i = 0; i < 10000; i++) {
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_0(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_1(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_2(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_3(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_4(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_5(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_0_6(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_3(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_4(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_5(y);
			y = tsr.test0_1_6(y);
			y = tsr.test0_1_6(y);
			y = tsr.test1_0_0(y & (~1));
			y = tsr.test1_0_1(y & (~1));
			y = tsr.test1_0_2(y & (~1));
			y = tsr.test1_0_3(y & (~1));
			y = tsr.test1_0_4(y & (~1));
			y = tsr.test1_0_5(y & (~1));
			y = tsr.test1_0_6(y & (~1));
			y = tsr.test1_0_0((y & (~1)) + 1);
			y = tsr.test1_0_1((y & (~1)) + 1);
			y = tsr.test1_0_2((y & (~1)) + 1);
			y = tsr.test1_0_3((y & (~1)) + 1);
			y = tsr.test1_0_4((y & (~1)) + 1);
			y = tsr.test1_0_5((y & (~1)) + 1);
			y = tsr.test1_0_6((y & (~1)) + 1);
			y = tsr.test1_1_0(y & (~1));
			y = tsr.test1_1_1(y & (~1));
			y = tsr.test1_1_2(y & (~1));
			y = tsr.test1_1_3(y & (~1));
			y = tsr.test1_1_4(y & (~1));
			y = tsr.test1_1_5(y & (~1));
			y = tsr.test1_1_6(y & (~1));
			y = tsr.test1_1_0((y & (~1)) + 1);
			y = tsr.test1_1_1((y & (~1)) + 1);
			y = tsr.test1_1_2((y & (~1)) + 1);
			y = tsr.test1_1_3((y & (~1)) + 1);
			y = tsr.test1_1_4((y & (~1)) + 1);
			y = tsr.test1_1_5((y & (~1)) + 1);
			y = tsr.test1_1_6((y & (~1)) + 1);
			y = tsr.test1_2_0(y & (~1));
			y = tsr.test1_2_1(y & (~1));
			y = tsr.test1_2_2(y & (~1));
			y = tsr.test1_2_3(y & (~1));
			y = tsr.test1_2_4(y & (~1));
			y = tsr.test1_2_5(y & (~1));
			y = tsr.test1_2_6(y & (~1));
			y = tsr.test1_2_0((y & (~1)) + 1);
			y = tsr.test1_2_1((y & (~1)) + 1);
			y = tsr.test1_2_2((y & (~1)) + 1);
			y = tsr.test1_2_3((y & (~1)) + 1);
			y = tsr.test1_2_4((y & (~1)) + 1);
			y = tsr.test1_2_5((y & (~1)) + 1);
			y = tsr.test1_2_6((y & (~1)) + 1);
			y = tsr.test2_0_0(y & (~3));
			y = tsr.test2_0_1(y & (~3));
			y = tsr.test2_0_2(y & (~3));
			y = tsr.test2_0_3(y & (~3));
			y = tsr.test2_0_4(y & (~3));
			y = tsr.test2_0_5(y & (~3));
			y = tsr.test2_0_6(y & (~3));
			y = tsr.test2_0_0((y & (~3)) + 3);
			y = tsr.test2_0_1((y & (~3)) + 3);
			y = tsr.test2_0_2((y & (~3)) + 3);
			y = tsr.test2_0_3((y & (~3)) + 3);
			y = tsr.test2_0_4((y & (~3)) + 3);
			y = tsr.test2_0_5((y & (~3)) + 3);
			y = tsr.test2_0_6((y & (~3)) + 3);
			y = tsr.test2_1_0(y & (~3));
			y = tsr.test2_1_1(y & (~3));
			y = tsr.test2_1_2(y & (~3));
			y = tsr.test2_1_3(y & (~3));
			y = tsr.test2_1_4(y & (~3));
			y = tsr.test2_1_5(y & (~3));
			y = tsr.test2_1_6(y & (~3));
			y = tsr.test2_1_0((y & (~3)) + 3);
			y = tsr.test2_1_1((y & (~3)) + 3);
			y = tsr.test2_1_2((y & (~3)) + 3);
			y = tsr.test2_1_3((y & (~3)) + 3);
			y = tsr.test2_1_4((y & (~3)) + 3);
			y = tsr.test2_1_5((y & (~3)) + 3);
			y = tsr.test2_1_6((y & (~3)) + 3);
			y = tsr.test2_2_0(y & (~3));
			y = tsr.test2_2_1(y & (~3));
			y = tsr.test2_2_2(y & (~3));
			y = tsr.test2_2_3(y & (~3));
			y = tsr.test2_2_4(y & (~3));
			y = tsr.test2_2_5(y & (~3));
			y = tsr.test2_2_6(y & (~3));
			y = tsr.test2_2_0((y & (~3)) + 3);
			y = tsr.test2_2_1((y & (~3)) + 3);
			y = tsr.test2_2_2((y & (~3)) + 3);
			y = tsr.test2_2_3((y & (~3)) + 3);
			y = tsr.test2_2_4((y & (~3)) + 3);
			y = tsr.test2_2_5((y & (~3)) + 3);
			y = tsr.test2_2_6((y & (~3)) + 3);
		}
		int z = 0;
		y = tsr.test0_0_0(0);
		java.lang.System.out.println("After 'test0_0_0' y=" + y);
		y = tsr.test0_0_1(0);
		java.lang.System.out.println("After 'test0_0_1' y=" + y);
		y = tsr.test0_0_2(0);
		java.lang.System.out.println("After 'test0_0_2' y=" + y);
		y = tsr.test0_0_3(0);
		java.lang.System.out.println("After 'test0_0_3' y=" + y);
		y = tsr.test0_0_4(0);
		java.lang.System.out.println("After 'test0_0_4' y=" + y);
		y = tsr.test0_0_5(0);
		java.lang.System.out.println("After 'test0_0_5' y=" + y);
		y = tsr.test0_0_6(0);
		java.lang.System.out.println("After 'test0_0_6' y=" + y);
		y = tsr.test0_1_3(0);
		java.lang.System.out.println("After 'test0_1_3' y=" + y);
		y = tsr.test0_1_4(0);
		java.lang.System.out.println("After 'test0_1_4' y=" + y);
		y = tsr.test0_1_5(0);
		java.lang.System.out.println("After 'test0_1_5' y=" + y);
		y = tsr.test0_1_6(0);
		java.lang.System.out.println("After 'test0_1_6' y=" + y);
		y = tsr.test1_0_0(0);
		java.lang.System.out.println("After 'test1_0_0' y=" + y);
		y = tsr.test1_0_1(0);
		java.lang.System.out.println("After 'test1_0_1' y=" + y);
		y = tsr.test1_0_2(0);
		java.lang.System.out.println("After 'test1_0_2' y=" + y);
		y = tsr.test1_0_3(0);
		java.lang.System.out.println("After 'test1_0_3' y=" + y);
		y = tsr.test1_0_4(0);
		java.lang.System.out.println("After 'test1_0_4' y=" + y);
		y = tsr.test1_0_5(0);
		java.lang.System.out.println("After 'test1_0_5' y=" + y);
		y = tsr.test1_0_6(0);
		java.lang.System.out.println("After 'test1_0_6' y=" + y);
		y = tsr.test1_1_0(0);
		java.lang.System.out.println("After 'test1_1_0' y=" + y);
		y = tsr.test1_1_1(0);
		java.lang.System.out.println("After 'test1_1_1' y=" + y);
		y = tsr.test1_1_2(0);
		java.lang.System.out.println("After 'test1_1_2' y=" + y);
		y = tsr.test1_1_3(0);
		java.lang.System.out.println("After 'test1_1_3' y=" + y);
		y = tsr.test1_1_4(0);
		java.lang.System.out.println("After 'test1_1_4' y=" + y);
		y = tsr.test1_1_5(0);
		java.lang.System.out.println("After 'test1_1_5' y=" + y);
		y = tsr.test1_1_6(0);
		java.lang.System.out.println("After 'test1_1_6' y=" + y);
		y = tsr.test1_2_0(0);
		java.lang.System.out.println("After 'test1_2_0' y=" + y);
		y = tsr.test1_2_1(0);
		java.lang.System.out.println("After 'test1_2_1' y=" + y);
		y = tsr.test1_2_2(0);
		java.lang.System.out.println("After 'test1_2_2' y=" + y);
		y = tsr.test1_2_3(0);
		java.lang.System.out.println("After 'test1_2_3' y=" + y);
		y = tsr.test1_2_4(0);
		java.lang.System.out.println("After 'test1_2_4' y=" + y);
		y = tsr.test1_2_5(0);
		java.lang.System.out.println("After 'test1_2_5' y=" + y);
		y = tsr.test1_2_6(0);
		java.lang.System.out.println("After 'test1_2_6' y=" + y);
		y = tsr.test2_0_0(0);
		java.lang.System.out.println("After 'test2_0_0' y=" + y);
		y = tsr.test2_0_1(0);
		java.lang.System.out.println("After 'test2_0_1' y=" + y);
		y = tsr.test2_0_2(0);
		java.lang.System.out.println("After 'test2_0_2' y=" + y);
		y = tsr.test2_0_3(0);
		java.lang.System.out.println("After 'test2_0_3' y=" + y);
		y = tsr.test2_0_4(0);
		java.lang.System.out.println("After 'test2_0_4' y=" + y);
		y = tsr.test2_0_5(0);
		java.lang.System.out.println("After 'test2_0_5' y=" + y);
		y = tsr.test2_0_6(0);
		java.lang.System.out.println("After 'test2_0_6' y=" + y);
		y = tsr.test2_1_0(0);
		java.lang.System.out.println("After 'test2_1_0' y=" + y);
		y = tsr.test2_1_1(0);
		java.lang.System.out.println("After 'test2_1_1' y=" + y);
		y = tsr.test2_1_2(0);
		java.lang.System.out.println("After 'test2_1_2' y=" + y);
		y = tsr.test2_1_3(0);
		java.lang.System.out.println("After 'test2_1_3' y=" + y);
		y = tsr.test2_1_4(0);
		java.lang.System.out.println("After 'test2_1_4' y=" + y);
		y = tsr.test2_1_5(0);
		java.lang.System.out.println("After 'test2_1_5' y=" + y);
		y = tsr.test2_1_6(0);
		java.lang.System.out.println("After 'test2_1_6' y=" + y);
		y = tsr.test2_2_0(0);
		java.lang.System.out.println("After 'test2_2_0' y=" + y);
		y = tsr.test2_2_1(0);
		java.lang.System.out.println("After 'test2_2_1' y=" + y);
		y = tsr.test2_2_2(0);
		java.lang.System.out.println("After 'test2_2_2' y=" + y);
		y = tsr.test2_2_3(0);
		java.lang.System.out.println("After 'test2_2_3' y=" + y);
		y = tsr.test2_2_4(0);
		java.lang.System.out.println("After 'test2_2_4' y=" + y);
		y = tsr.test2_2_5(0);
		java.lang.System.out.println("After 'test2_2_5' y=" + y);
		y = tsr.test2_2_6(0);
		java.lang.System.out.println("After 'test2_2_6' y=" + y);
	}
}