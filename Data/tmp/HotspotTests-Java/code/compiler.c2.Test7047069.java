public class Test7047069 {
	static boolean verbose;

	static final int GROW_SIZE = 24;

	float squareflat;

	int limit;

	float[] hold = new float[14];

	int holdEnd;

	int holdIndex;

	int[] levels;

	int levelIndex;

	public static void subdivide(float[] src, int srcoff, float[] left, int leftoff, float[] right, int rightoff) {
		float x1 = src[srcoff + 0];
		float y1 = src[srcoff + 1];
		float ctrlx = src[srcoff + 2];
		float ctrly = src[srcoff + 3];
		float x2 = src[srcoff + 4];
		float y2 = src[srcoff + 5];
		if (left != null) {
			left[leftoff + 0] = x1;
			left[leftoff + 1] = y1;
		}
		if (right != null) {
			right[rightoff + 4] = x2;
			right[rightoff + 5] = y2;
		}
		x1 = (x1 + ctrlx) / 2.0F;
		y1 = (y1 + ctrly) / 2.0F;
		x2 = (x2 + ctrlx) / 2.0F;
		y2 = (y2 + ctrly) / 2.0F;
		ctrlx = (x1 + x2) / 2.0F;
		ctrly = (y1 + y2) / 2.0F;
		if (left != null) {
			left[leftoff + 2] = x1;
			left[leftoff + 3] = y1;
			left[leftoff + 4] = ctrlx;
			left[leftoff + 5] = ctrly;
		}
		if (right != null) {
			right[rightoff + 0] = ctrlx;
			right[rightoff + 1] = ctrly;
			right[rightoff + 2] = x2;
			right[rightoff + 3] = y2;
		}
	}

	public static double getFlatnessSq(float[] coords, int offset) {
		return java.awt.geom.Line2D.ptSegDistSq(coords[offset + 0], coords[offset + 1], coords[offset + 4], coords[offset + 5], coords[offset + 2], coords[offset + 3]);
	}

	public Test7047069() {
		this.squareflat = 1.0E-4F * 1.0E-4F;
		holdIndex = hold.length - 6;
		holdEnd = hold.length - 2;
		hold[holdIndex + 0] = ((float) (0.1 * 100));
		hold[holdIndex + 1] = ((float) (0.2 * 100));
		hold[holdIndex + 2] = ((float) (0.3 * 100));
		hold[holdIndex + 3] = ((float) (0.4 * 100));
		hold[holdIndex + 4] = ((float) (0.5 * 100));
		hold[holdIndex + 5] = ((float) (0.6 * 100));
		levelIndex = 0;
		this.limit = 10;
		this.levels = new int[limit + 1];
	}

	void ensureHoldCapacity(int want) {
		if ((holdIndex - want) < 0) {
			int have = hold.length - holdIndex;
			int newsize = hold.length + compiler.c2.Test7047069.GROW_SIZE;
			float[] newhold = new float[newsize];
			java.lang.System.arraycopy(hold, holdIndex, newhold, holdIndex + compiler.c2.Test7047069.GROW_SIZE, have);
			if (compiler.c2.Test7047069.verbose) {
				java.lang.System.err.println(((("old hold = " + hold) + "[") + hold.length) + "]");
			}
			if (compiler.c2.Test7047069.verbose) {
				java.lang.System.err.println(((("replacement hold = " + newhold) + "[") + newhold.length) + "]");
			}
			hold = newhold;
			if (compiler.c2.Test7047069.verbose) {
				java.lang.System.err.println(((("new hold = " + hold) + "[") + hold.length) + "]");
			}
			if (compiler.c2.Test7047069.verbose) {
				java.lang.System.err.println(((("replacement hold still = " + newhold) + "[") + newhold.length) + "]");
			}
			holdIndex += compiler.c2.Test7047069.GROW_SIZE;
			holdEnd += compiler.c2.Test7047069.GROW_SIZE;
		}
	}

	private boolean next() {
		if (holdIndex >= holdEnd) {
			return false;
		}
		int level = levels[levelIndex];
		while (level < limit) {
			if (compiler.c2.Test7047069.getFlatnessSq(hold, holdIndex) < squareflat) {
				break;
			}
			ensureHoldCapacity(4);
			compiler.c2.Test7047069.subdivide(hold, holdIndex, hold, holdIndex - 4, hold, holdIndex);
			holdIndex -= 4;
			level++;
			levels[levelIndex] = level;
			levelIndex++;
			levels[levelIndex] = level;
		} 
		holdIndex += 4;
		levelIndex--;
		return true;
	}

	public static void main(java.lang.String[] argv) {
		compiler.c2.Test7047069.verbose = argv.length > 0;
		for (int i = 0; i < 100000; i++) {
			compiler.c2.Test7047069 st = new compiler.c2.Test7047069();
			while (st.next()) {
			} 
		}
	}
}