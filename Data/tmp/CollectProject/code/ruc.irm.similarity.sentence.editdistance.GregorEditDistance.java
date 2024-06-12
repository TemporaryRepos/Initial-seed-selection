public class GregorEditDistance extends ruc.irm.similarity.sentence.editdistance.EditDistance {
	public static double swapCost = 0.5;

	private ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> S;

	private ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> T;

	private double[][][][] QArray;

	public double getEditDistance(ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> S, ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> T) {
		this.S = S;
		this.T = T;
		QArray = new double[S.length()][S.length()][T.length()][T.length()];
		for (int i = 0; i < S.length(); i++) {
			for (int i2 = 0; i2 < S.length(); i2++) {
				for (int j = 0; j < T.length(); j++) {
					for (int j2 = 0; j2 < T.length(); j2++) {
						QArray[i][i2][j][j2] = java.lang.Double.MAX_VALUE;
					}
				}
			}
		}
		return Q(0, S.length() - 1, 0, T.length() - 1);
	}

	private double Q(int i0, int i1, int j0, int j1) {
		double cost = 0;
		if (i1 < i0) {
			for (int j = j0; j <= j1; j++) {
				cost += T.elementAt(j).getInsertionCost();
			}
			return cost;
		} else if (j1 < j0) {
			for (int i = i0; i <= i1; i++) {
				cost += S.elementAt(i).getDeletionCost();
			}
			return cost;
		} else if ((i1 == i0) && (j1 == j0)) {
			cost = S.elementAt(i0).getSubstitutionCost(T.elementAt(j0));
			QArray[i0][i1][j0][j1] = cost;
			return cost;
		} else if (i1 == i0) {
			double minSubstituteValue = 1.0;
			int minPosJ = j0;
			for (int j = j0; j <= j1; j++) {
				double subsitituteValue = S.elementAt(i0).getSubstitutionCost(T.elementAt(j));
				if (minSubstituteValue > subsitituteValue) {
					minSubstituteValue = subsitituteValue;
					minPosJ = j;
				}
			}
			for (int j = j0; j <= j1; j++) {
				if (j == minPosJ) {
					cost += minSubstituteValue;
				} else {
					cost += T.elementAt(j).getInsertionCost();
				}
			}
		} else if (j1 == j0) {
			double minSubstituteValue = 1.0;
			int minPosI = i0;
			for (int i = i0; i <= i1; i++) {
				double subsitituteValue = S.elementAt(i).getSubstitutionCost(T.elementAt(j0));
				if (minSubstituteValue > subsitituteValue) {
					minSubstituteValue = subsitituteValue;
					minPosI = i;
				}
			}
			for (int i = i0; i <= i1; i++) {
				if (i == minPosI) {
					cost += minSubstituteValue;
				} else {
					cost += S.elementAt(i).getDeletionCost();
				}
			}
		} else {
			if (QArray[i0][i1][j0][j1] < java.lang.Double.MAX_VALUE) {
				return QArray[i0][i1][j0][j1];
			}
			for (int i = i0; i < i1; i++) {
				for (int j = j0; j < j1; j++) {
					double c = java.lang.Math.min(Q(i0, i, j0, j) + Q(i + 1, i1, j + 1, j1), (Q(i0, i, j + 1, j1) + Q(i + 1, i1, j0, j)) + ruc.irm.similarity.sentence.editdistance.GregorEditDistance.swapCost);
					if (c < QArray[i0][i1][j0][j1]) {
						QArray[i0][i1][j0][j1] = c;
					}
				}
			}
			return QArray[i0][i1][j0][j1];
		}
		QArray[i0][i1][j0][j1] = cost;
		return cost;
	}

	public static void main(java.lang.String[] argv) {
		java.lang.String s1 = "abcxdef";
		java.lang.String s2 = "defxabc";
		ruc.irm.similarity.sentence.editdistance.GregorEditDistance ed = new ruc.irm.similarity.sentence.editdistance.GregorEditDistance();
		java.lang.System.out.println(ed.getEditDistance(ruc.irm.similarity.sentence.editdistance.SuperString.createCharSuperString(s1), ruc.irm.similarity.sentence.editdistance.SuperString.createCharSuperString(s2)));
	}
}