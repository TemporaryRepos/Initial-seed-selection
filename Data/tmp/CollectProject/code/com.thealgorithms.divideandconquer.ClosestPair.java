public final class ClosestPair {
	int numberPoints;

	private com.thealgorithms.divideandconquer.ClosestPair.Location[] array;

	com.thealgorithms.divideandconquer.ClosestPair.Location point1 = null;

	com.thealgorithms.divideandconquer.ClosestPair.Location point2 = null;

	private static double minNum = java.lang.Double.MAX_VALUE;

	public static void setMinNum(double minNum) {
		com.thealgorithms.divideandconquer.ClosestPair.minNum = minNum;
	}

	public static void setSecondCount(int secondCount) {
		com.thealgorithms.divideandconquer.ClosestPair.secondCount = secondCount;
	}

	private static int secondCount = 0;

	ClosestPair(int points) {
		numberPoints = points;
		array = new com.thealgorithms.divideandconquer.ClosestPair.Location[numberPoints];
	}

	public static class Location {
		double x;

		double y;

		Location(final double xpar, final double ypar) {
			this.x = xpar;
			this.y = ypar;
		}
	}

	public com.thealgorithms.divideandconquer.ClosestPair.Location[] createLocation(int numberValues) {
		return new com.thealgorithms.divideandconquer.ClosestPair.Location[numberValues];
	}

	public com.thealgorithms.divideandconquer.ClosestPair.Location buildLocation(double x, double y) {
		return new com.thealgorithms.divideandconquer.ClosestPair.Location(x, y);
	}

	public int xPartition(final com.thealgorithms.divideandconquer.ClosestPair.Location[] a, final int first, final int last) {
		com.thealgorithms.divideandconquer.ClosestPair.Location pivot = a[last];
		int i = first - 1;
		com.thealgorithms.divideandconquer.ClosestPair.Location temp;
		for (int j = first; j <= (last - 1); j++) {
			if (a[j].x <= pivot.x) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		i++;
		temp = a[i];
		a[i] = a[last];
		a[last] = temp;
		return i;
	}

	public int yPartition(final com.thealgorithms.divideandconquer.ClosestPair.Location[] a, final int first, final int last) {
		com.thealgorithms.divideandconquer.ClosestPair.Location pivot = a[last];
		int i = first - 1;
		com.thealgorithms.divideandconquer.ClosestPair.Location temp;
		for (int j = first; j <= (last - 1); j++) {
			if (a[j].y <= pivot.y) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		i++;
		temp = a[i];
		a[i] = a[last];
		a[last] = temp;
		return i;
	}

	public void xQuickSort(final com.thealgorithms.divideandconquer.ClosestPair.Location[] a, final int first, final int last) {
		if (first < last) {
			int q = xPartition(a, first, last);
			xQuickSort(a, first, q - 1);
			xQuickSort(a, q + 1, last);
		}
	}

	public void yQuickSort(final com.thealgorithms.divideandconquer.ClosestPair.Location[] a, final int first, final int last) {
		if (first < last) {
			int q = yPartition(a, first, last);
			yQuickSort(a, first, q - 1);
			yQuickSort(a, q + 1, last);
		}
	}

	public double closestPair(final com.thealgorithms.divideandconquer.ClosestPair.Location[] a, final int indexNum) {
		com.thealgorithms.divideandconquer.ClosestPair.Location[] divideArray = new com.thealgorithms.divideandconquer.ClosestPair.Location[indexNum];
		java.lang.System.arraycopy(a, 0, divideArray, 0, indexNum);
		int divideX = indexNum / 2;
		com.thealgorithms.divideandconquer.ClosestPair.Location[] leftArray = new com.thealgorithms.divideandconquer.ClosestPair.Location[divideX];
		com.thealgorithms.divideandconquer.ClosestPair.Location[] rightArray = new com.thealgorithms.divideandconquer.ClosestPair.Location[indexNum - divideX];
		if (indexNum <= 3) {
			return bruteForce(divideArray);
		}
		java.lang.System.arraycopy(divideArray, 0, leftArray, 0, divideX);
		java.lang.System.arraycopy(divideArray, divideX, rightArray, 0, indexNum - divideX);
		double minLeftArea;
		double minRightArea;
		double minValue;
		minLeftArea = closestPair(leftArray, divideX);
		minRightArea = closestPair(rightArray, indexNum - divideX);
		minValue = java.lang.Math.min(minLeftArea, minRightArea);
		for (int i = 0; i < indexNum; i++) {
			double xGap = java.lang.Math.abs(divideArray[divideX].x - divideArray[i].x);
			if (xGap < minValue) {
				com.thealgorithms.divideandconquer.ClosestPair.setSecondCount(com.thealgorithms.divideandconquer.ClosestPair.secondCount + 1);
			} else if (divideArray[i].x > divideArray[divideX].x) {
				break;
			}
		}
		com.thealgorithms.divideandconquer.ClosestPair.Location[] firstWindow = new com.thealgorithms.divideandconquer.ClosestPair.Location[com.thealgorithms.divideandconquer.ClosestPair.secondCount];
		int k = 0;
		for (int i = 0; i < indexNum; i++) {
			double xGap = java.lang.Math.abs(divideArray[divideX].x - divideArray[i].x);
			if (xGap < minValue) {
				firstWindow[k] = divideArray[i];
				k++;
			} else if (divideArray[i].x > divideArray[divideX].x) {
				break;
			}
		}
		yQuickSort(firstWindow, 0, com.thealgorithms.divideandconquer.ClosestPair.secondCount - 1);
		double length;
		for (int i = 0; i < (com.thealgorithms.divideandconquer.ClosestPair.secondCount - 1); i++) {
			for (int j = i + 1; j < com.thealgorithms.divideandconquer.ClosestPair.secondCount; j++) {
				double xGap = java.lang.Math.abs(firstWindow[i].x - firstWindow[j].x);
				double yGap = java.lang.Math.abs(firstWindow[i].y - firstWindow[j].y);
				if (yGap < minValue) {
					length = java.lang.Math.sqrt(java.lang.Math.pow(xGap, 2) + java.lang.Math.pow(yGap, 2));
					if (length < minValue) {
						minValue = length;
						if (length < com.thealgorithms.divideandconquer.ClosestPair.minNum) {
							com.thealgorithms.divideandconquer.ClosestPair.setMinNum(length);
							point1 = firstWindow[i];
							point2 = firstWindow[j];
						}
					}
				} else {
					break;
				}
			}
		}
		com.thealgorithms.divideandconquer.ClosestPair.setSecondCount(0);
		return minValue;
	}

	public double bruteForce(final com.thealgorithms.divideandconquer.ClosestPair.Location[] arrayParam) {
		double minValue = java.lang.Double.MAX_VALUE;
		double length;
		double xGap;
		double yGap;
		double result = 0;
		if (arrayParam.length == 2) {
			xGap = arrayParam[0].x - arrayParam[1].x;
			yGap = arrayParam[0].y - arrayParam[1].y;
			length = java.lang.Math.sqrt(java.lang.Math.pow(xGap, 2) + java.lang.Math.pow(yGap, 2));
			if (length < com.thealgorithms.divideandconquer.ClosestPair.minNum) {
				com.thealgorithms.divideandconquer.ClosestPair.setMinNum(length);
			}
			point1 = arrayParam[0];
			point2 = arrayParam[1];
			result = length;
		}
		if (arrayParam.length == 3) {
			for (int i = 0; i < (arrayParam.length - 1); i++) {
				for (int j = i + 1; j < arrayParam.length; j++) {
					xGap = arrayParam[i].x - arrayParam[j].x;
					yGap = arrayParam[i].y - arrayParam[j].y;
					length = java.lang.Math.sqrt(java.lang.Math.pow(xGap, 2) + java.lang.Math.pow(yGap, 2));
					if (length < minValue) {
						minValue = length;
						if (length < com.thealgorithms.divideandconquer.ClosestPair.minNum) {
							com.thealgorithms.divideandconquer.ClosestPair.setMinNum(length);
							point1 = arrayParam[i];
							point2 = arrayParam[j];
						}
					}
				}
			}
			result = minValue;
		}
		return result;
	}

	public static void main(final java.lang.String[] args) {
		com.thealgorithms.divideandconquer.ClosestPair cp = new com.thealgorithms.divideandconquer.ClosestPair(12);
		cp.array[0] = cp.buildLocation(2, 3);
		cp.array[1] = cp.buildLocation(2, 16);
		cp.array[2] = cp.buildLocation(3, 9);
		cp.array[3] = cp.buildLocation(6, 3);
		cp.array[4] = cp.buildLocation(7, 7);
		cp.array[5] = cp.buildLocation(19, 4);
		cp.array[6] = cp.buildLocation(10, 11);
		cp.array[7] = cp.buildLocation(15, 2);
		cp.array[8] = cp.buildLocation(15, 19);
		cp.array[9] = cp.buildLocation(16, 11);
		cp.array[10] = cp.buildLocation(17, 13);
		cp.array[11] = cp.buildLocation(9, 12);
		java.lang.System.out.println("Input data");
		java.lang.System.out.println("Number of points: " + cp.array.length);
		for (int i = 0; i < cp.array.length; i++) {
			java.lang.System.out.println((("x: " + cp.array[i].x) + ", y: ") + cp.array[i].y);
		}
		cp.xQuickSort(cp.array, 0, cp.array.length - 1);
		double result;
		result = cp.closestPair(cp.array, cp.array.length);
		java.lang.System.out.println("Output Data");
		java.lang.System.out.println(((("(" + cp.point1.x) + ", ") + cp.point1.y) + ")");
		java.lang.System.out.println(((("(" + cp.point2.x) + ", ") + cp.point2.y) + ")");
		java.lang.System.out.println("Minimum Distance : " + result);
	}
}