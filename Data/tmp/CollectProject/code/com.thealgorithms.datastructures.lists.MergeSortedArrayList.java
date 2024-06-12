public class MergeSortedArrayList {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.Integer> listA = new java.util.ArrayList<>();
		java.util.List<java.lang.Integer> listB = new java.util.ArrayList<>();
		java.util.List<java.lang.Integer> listC = new java.util.ArrayList<>();
		for (int i = 1; i <= 10; i += 2) {
			listA.add(i);
			listB.add(i + 1);
		}
		com.thealgorithms.datastructures.lists.MergeSortedArrayList.merge(listA, listB, listC);
		java.lang.System.out.println("listA: " + listA);
		java.lang.System.out.println("listB: " + listB);
		java.lang.System.out.println("listC: " + listC);
	}

	public static void merge(java.util.List<java.lang.Integer> listA, java.util.List<java.lang.Integer> listB, java.util.List<java.lang.Integer> listC) {
		int pa = 0;
		int pb = 0;
		while ((pa < listA.size()) && (pb < listB.size())) {
			if (listA.get(pa) <= listB.get(pb)) {
				listC.add(listA.get(pa++));
			} else {
				listC.add(listB.get(pb++));
			}
		} 
		while (pa < listA.size()) {
			listC.add(listA.get(pa++));
		} 
		while (pb < listB.size()) {
			listC.add(listB.get(pb++));
		} 
	}
}