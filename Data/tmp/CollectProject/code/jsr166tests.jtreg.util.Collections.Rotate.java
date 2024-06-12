public class Rotate {
	static final int SIZE = 120;

	static java.util.Random rnd = new java.util.Random();

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.List[] a = new java.util.List[]{ new java.util.ArrayList(), new java.util.LinkedList(), new java.util.Vector() };
		for (int i = 0; i < a.length; i++) {
			java.util.List lst = a[i];
			for (int j = 0; j < jsr166tests.jtreg.util.Collections.Rotate.SIZE; j++) {
				lst.add(new java.lang.Integer(j));
			}
			int totalDist = 0;
			for (int j = 0; j < 10000; j++) {
				int dist = jsr166tests.jtreg.util.Collections.Rotate.rnd.nextInt(200) - 100;
				java.util.Collections.rotate(lst, dist);
				totalDist = (totalDist + dist) % jsr166tests.jtreg.util.Collections.Rotate.SIZE;
				if (totalDist < 0) {
					totalDist += jsr166tests.jtreg.util.Collections.Rotate.SIZE;
				}
				int index = 0;
				for (int k = totalDist; k < jsr166tests.jtreg.util.Collections.Rotate.SIZE; k++ , index++) {
					if (((java.lang.Integer) (lst.get(k))).intValue() != index) {
						throw new java.lang.Exception((((((("j: " + j) + ", lst[") + k) + "]=") + lst.get(k)) + ", should be ") + index);
					}
				}
				for (int k = 0; k < totalDist; k++ , index++) {
					if (((java.lang.Integer) (lst.get(k))).intValue() != index) {
						throw new java.lang.Exception((((((("j: " + j) + ", lst[") + k) + "]=") + lst.get(k)) + ", should be ") + index);
					}
				}
			}
		}
	}
}