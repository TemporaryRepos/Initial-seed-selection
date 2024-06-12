class Matrix_3d {
	public static void main(java.lang.String[] args) {
		int N = 50;
		double Error = 0.001;
		double r1;
		double r2;
		double r3;
		double r4;
		double r5;
		double r6;
		double[][][] xxx;
		double[][][] yyy;
		double[][][] zzz;
		xxx = new double[N][N][N];
		yyy = new double[N][N][N];
		zzz = new double[N][N][N];
		jit.FloatingPoint.gen_math.Matrix_3d.Matrix_3d mm;
		mm = new jit.FloatingPoint.gen_math.Matrix_3d.Matrix_3d();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					r1 = i;
					r2 = java.lang.Math.sin(r1);
					r3 = j;
					r4 = java.lang.Math.cos(r3);
					r5 = k;
					r6 = java.lang.Math.sqrt(r5);
					xxx[i][j][k] = r6 * ((r2 * r2) + (r4 * r4));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					yyy[i][j][k] = xxx[k][j][i];
					zzz[i][j][k] = xxx[k][i][j];
				}
			}
		}
		double trace_xxx = mm.trace_matrix(N, xxx);
		double trace_yyy = mm.trace_matrix(N, yyy);
		double trace_zzz = mm.trace_matrix(N, zzz);
		double trace_3d = (trace_xxx + trace_yyy) + trace_zzz;
		double er = java.lang.Math.abs(105 - trace_3d);
		if (er < Error) {
			java.lang.System.out.println("test PASS");
		} else {
			throw new nsk.share.TestFailure("test FAIL");
		}
	}

	public double trace_matrix(int nn, double[][][] www) {
		double trace = 0;
		for (int i = 0; i < nn; i++) {
			trace = trace + (www[i][i][i] * www[i][i][i]);
		}
		return java.lang.Math.sqrt(trace);
	}
}