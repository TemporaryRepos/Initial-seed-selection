public class XiatianEditDistance extends ruc.irm.similarity.sentence.editdistance.EditDistance {
	public static double swapCost = 0.5;

	private ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> S;

	private ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> T;

	private double[][][][] QArray;

	public double getEditDistance(ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> S, ruc.irm.similarity.sentence.editdistance.SuperString<? extends ruc.irm.similarity.sentence.editdistance.EditUnit> T) {
		this.S = S;
		this.T = T;
		QArray = new double[S.length() + 1][S.length() + 1][T.length() + 1][T.length() + 1];
		for (int i = 0; i <= S.length(); i++) {
			for (int i2 = 0; i2 <= S.length(); i2++) {
				for (int j = 0; j <= T.length(); j++) {
					for (int j2 = 0; j2 <= T.length(); j2++) {
						QArray[i][i2][j][j2] = java.lang.Double.MAX_VALUE;
					}
				}
			}
		}
		return Q(0, S.length() - 1, 0, T.length() - 1);
	}

	private double Q(int i1, int im, int j1, int jn) {
		if (QArray[i1][im][j1][jn] < java.lang.Double.MAX_VALUE) {
			return QArray[i1][im][j1][jn];
		}
		double cost = 0;
		if (im < i1) {
			for (int j = j1; j <= jn; j++) {
				cost += T.elementAt(j).getInsertionCost();
			}
		} else if (jn < j1) {
			for (int i = i1; i <= im; i++) {
				cost += S.elementAt(i).getDeletionCost();
			}
		} else if ((im == i1) && (jn == j1)) {
			cost = S.elementAt(i1).getSubstitutionCost(T.elementAt(j1));
		} else if (i1 == im) {
			double minSubValue = S.elementAt(i1).getSubstitutionCost(T.elementAt(j1));
			int minPosJ = j1;
			for (int j = j1 + 1; j <= jn; j++) {
				double subValue = S.elementAt(i1).getSubstitutionCost(T.elementAt(j));
				if (minSubValue > subValue) {
					minSubValue = subValue;
					minPosJ = j;
				}
			}
			for (int j = j1; j <= jn; j++) {
				if (j == minPosJ) {
					cost += minSubValue;
				} else {
					cost += T.elementAt(j).getInsertionCost();
				}
			}
		} else if (j1 == jn) {
			int minPosI = i1;
			double minSubValue = S.elementAt(i1).getSubstitutionCost(T.elementAt(j1));
			for (int i = i1 + 1; i <= im; i++) {
				double subValue = S.elementAt(i).getSubstitutionCost(T.elementAt(j1));
				if (minSubValue > subValue) {
					minSubValue = subValue;
					minPosI = i;
				}
			}
			for (int i = i1; i <= im; i++) {
				if (i == minPosI) {
					cost += minSubValue;
				} else {
					cost += S.elementAt(i).getDeletionCost();
				}
			}
		} else {
			cost = QArray[i1][im][j1][jn];
			loop : for (int i = i1; i < im; i++) {
				for (int LX = 0; LX <= (im - i); LX++) {
					for (int j = j1; j < jn; j++) {
						for (int LY = 0; LY <= (jn - j); LY++) {
							double cost1 = (Q(i1, i, j1, j) + Q(i + 1, i + LX, j + 1, j + LY)) + Q((i + LX) + 1, im, (j + LY) + 1, jn);
							double cost2 = ((Q(i1, i, (j + LY) + 1, jn) + Q(i + 1, i + LX, j + 1, j + LY)) + Q((i + LX) + 1, im, j1, j)) + ruc.irm.similarity.sentence.editdistance.XiatianEditDistance.swapCost;
							cost = java.lang.Math.min(java.lang.Math.min(cost1, cost2), cost);
							if (cost == 0) {
								break loop;
							}
						}
					}
				}
			}
		}
		QArray[i1][im][j1][jn] = cost;
		return cost;
	}

	public static void main(java.lang.String[] argv) {
		ruc.irm.similarity.sentence.editdistance.EditDistance ed = new ruc.irm.similarity.sentence.editdistance.XiatianEditDistance();
		java.lang.String s1 = "abcxdef";
		java.lang.String s2 = "def";
		java.lang.System.out.println(ed.getEditDistance(ruc.irm.similarity.sentence.editdistance.SuperString.createCharSuperString(s1), ruc.irm.similarity.sentence.editdistance.SuperString.createCharSuperString(s2)));
	}
}