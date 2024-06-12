public class ScatterAllocate {
	public static void main(java.lang.String[] args) {
		for (int p = 13; p < 14; p++) {
			for (int root = 0; root < p; root++) {
				java.lang.System.out.println((("root=" + root) + "-->") + com.fenbi.mp4j.utils.ScatterAllocate.allocate(p, root));
				java.lang.System.out.println("recvnum>>>" + com.fenbi.mp4j.utils.ScatterAllocate.recvNum(com.fenbi.mp4j.utils.ScatterAllocate.allocate(p, root)));
				if ((p % 100) == 0) {
					java.lang.System.out.println("p=" + p);
				}
				java.util.Map<java.lang.Integer, java.lang.Integer> recvNumMap = com.fenbi.mp4j.utils.ScatterAllocate.recvNum(com.fenbi.mp4j.utils.ScatterAllocate.allocate(p, root));
				for (int i = 0; i < p; i++) {
					int num = recvNumMap.getOrDefault(i, 0);
					if (num >= 2) {
						java.lang.System.out.println("error");
						java.lang.System.exit(1);
					}
				}
			}
		}
	}

	public static java.util.Map<java.lang.Integer, java.util.List<java.util.List<java.lang.Integer>>> allocate(int p, int root) {
		java.util.List<java.lang.Integer> splitList = new java.util.ArrayList<>();
		int mid = p / 2;
		if (root != 0) {
			splitList.add(root);
			splitList.add(0);
			splitList.add(0);
			splitList.add(mid - 1);
		}
		if (root != mid) {
			splitList.add(root);
			splitList.add(mid);
			splitList.add(mid);
			splitList.add(p - 1);
		}
		com.fenbi.mp4j.utils.ScatterAllocate.split(0, mid - 1, splitList);
		com.fenbi.mp4j.utils.ScatterAllocate.split(mid, p - 1, splitList);
		java.util.Map<java.lang.Integer, java.util.List<java.util.List<java.lang.Integer>>> allocateMap = new java.util.HashMap<>(p);
		for (int i = 0; i < splitList.size(); i += 4) {
			java.util.List<java.lang.Integer> list = new java.util.ArrayList<>(4);
			list.add(splitList.get(i));
			list.add(splitList.get(i + 1));
			list.add(splitList.get(i + 2));
			list.add(splitList.get(i + 3));
			int src = splitList.get(i);
			java.util.List<java.util.List<java.lang.Integer>> listList = allocateMap.get(src);
			if (listList == null) {
				listList = new java.util.ArrayList<>();
			}
			listList.add(list);
			allocateMap.put(src, listList);
		}
		return allocateMap;
	}

	public static void split(int start, int end, java.util.List<java.lang.Integer> retList) {
		if (start == end) {
			return;
		}
		int size = (end - start) + 1;
		int half = size / 2;
		retList.add(start);
		retList.add(start + half);
		retList.add(start + half);
		retList.add(end);
		com.fenbi.mp4j.utils.ScatterAllocate.split(start, (start + half) - 1, retList);
		com.fenbi.mp4j.utils.ScatterAllocate.split(start + half, end, retList);
	}

	public static java.util.Map<java.lang.Integer, java.lang.Integer> recvNum(java.util.Map<java.lang.Integer, java.util.List<java.util.List<java.lang.Integer>>> allocateMap) {
		java.util.Map<java.lang.Integer, java.lang.Integer> recvNumMap = new java.util.HashMap<>();
		for (java.util.Map.Entry<java.lang.Integer, java.util.List<java.util.List<java.lang.Integer>>> entry : allocateMap.entrySet()) {
			java.util.List<java.util.List<java.lang.Integer>> info = entry.getValue();
			for (java.util.List<java.lang.Integer> list : info) {
				int recvrank = list.get(1);
				java.lang.Integer cnt = recvNumMap.get(recvrank);
				if (cnt == null) {
					cnt = new java.lang.Integer(1);
					recvNumMap.put(recvrank, cnt);
				} else {
					recvNumMap.put(recvrank, cnt + 1);
				}
			}
		}
		return recvNumMap;
	}
}