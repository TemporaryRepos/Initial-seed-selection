@java.lang.SuppressWarnings("all")
public class AnsjArrays {
	private static final int INSERTIONSORT_THRESHOLD = 7;

	public static <T extends org.nlpcn.commons.lang.tire.domain.SmartForest<T>> int binarySearch(T[] branches, char c) {
		int high = branches.length - 1;
		if (branches.length < 1) {
			return high;
		}
		int low = 0;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int cmp = branches[mid].compareTo(c);
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		} 
		return -(low + 1);
	}

	public static void main(java.lang.String[] args) {
		int[] chars = new int[]{ 1, 2, 3, 4, 5, 6, 8, 7 };
		chars = java.util.Arrays.copyOf(chars, 100);
		java.lang.System.out.println(chars.length);
		for (int i = 0; i < chars.length; i++) {
			java.lang.System.out.println(chars[i]);
		}
	}

	public static void sort(org.nlpcn.commons.lang.tire.domain.SmartForest[] a) {
		org.nlpcn.commons.lang.tire.domain.SmartForest[] aux = a.clone();
		org.nlpcn.commons.lang.util.AnsjArrays.mergeSort(aux, a, 0, a.length, 0);
	}

	public static void sort(org.nlpcn.commons.lang.tire.domain.SmartForest[] a, int fromIndex, int toIndex) {
		org.nlpcn.commons.lang.util.AnsjArrays.rangeCheck(a.length, fromIndex, toIndex);
		org.nlpcn.commons.lang.tire.domain.SmartForest[] aux = org.nlpcn.commons.lang.util.AnsjArrays.copyOfRange(a, fromIndex, toIndex);
		org.nlpcn.commons.lang.util.AnsjArrays.mergeSort(aux, a, fromIndex, toIndex, -fromIndex);
	}

	private static void rangeCheck(int arrayLen, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new java.lang.IllegalArgumentException(((("fromIndex(" + fromIndex) + ") > toIndex(") + toIndex) + ")");
		}
		if (fromIndex < 0) {
			throw new java.lang.ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > arrayLen) {
			throw new java.lang.ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	private static void mergeSort(org.nlpcn.commons.lang.tire.domain.SmartForest[] src, org.nlpcn.commons.lang.tire.domain.SmartForest[] dest, int low, int high, int off) {
		int length = high - low;
		if (length < org.nlpcn.commons.lang.util.AnsjArrays.INSERTIONSORT_THRESHOLD) {
			for (int i = low; i < high; i++) {
				for (int j = i; (j > low) && (dest[j - 1].compareTo(dest[j].getC()) > 0); j--) {
					org.nlpcn.commons.lang.util.AnsjArrays.swap(dest, j, j - 1);
				}
			}
			return;
		}
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		org.nlpcn.commons.lang.util.AnsjArrays.mergeSort(dest, src, low, mid, -off);
		org.nlpcn.commons.lang.util.AnsjArrays.mergeSort(dest, src, mid, high, -off);
		if (src[mid - 1].compareTo(src[mid].getC()) <= 0) {
			java.lang.System.arraycopy(src, low, dest, destLow, length);
			return;
		}
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if ((q >= high) || ((p < mid) && (src[p].compareTo(src[q].getC()) <= 0))) {
				dest[i] = src[p++];
			} else {
				dest[i] = src[q++];
			}
		}
	}

	private static void swap(org.nlpcn.commons.lang.tire.domain.SmartForest[] x, int a, int b) {
		org.nlpcn.commons.lang.tire.domain.SmartForest t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	@java.lang.SuppressWarnings("unchecked")
	public static <T> T[] copyOfRange(T[] original, int from, int to) {
		return org.nlpcn.commons.lang.util.AnsjArrays.copyOfRange(original, from, to, ((java.lang.Class<T[]>) (original.getClass())));
	}

	public static <T, U> T[] copyOfRange(U[] original, int from, int to, java.lang.Class<? extends T[]> newType) {
		int newLength = to - from;
		if (newLength < 0) {
			throw new java.lang.IllegalArgumentException((from + " > ") + to);
		}
		@java.lang.SuppressWarnings("unchecked")
		T[] copy = (((java.lang.Object) (newType)) == ((java.lang.Object) (java.lang.Object[].class))) ? ((T[]) (new java.lang.Object[newLength])) : ((T[]) (java.lang.reflect.Array.newInstance(newType.getComponentType(), newLength)));
		java.lang.System.arraycopy(original, from, copy, 0, java.lang.Math.min(original.length - from, newLength));
		return copy;
	}
}