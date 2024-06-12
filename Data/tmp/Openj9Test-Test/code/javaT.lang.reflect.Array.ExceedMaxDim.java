public class ExceedMaxDim {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.reflect.Array.ExceedMaxDim.newInstanceOne();
		javaT.lang.reflect.Array.ExceedMaxDim.newInstanceMulti();
		javaT.lang.reflect.Array.ExceedMaxDim.zeroDimension();
	}

	private static void newInstanceOne() throws java.lang.Exception {
		java.lang.Object o = javaT.lang.reflect.Array.ExceedMaxDim.getArrayOf256Dimensions();
		try {
			o = java.lang.reflect.Array.newInstance(o.getClass(), 1);
		} catch (java.lang.IllegalArgumentException iae) {
			java.lang.System.out.println("success: newInstanceOne test");
			return;
		}
		throw new java.lang.Exception("NewArray allowed dimensions > MAXDIM");
	}

	private static void newInstanceMulti() throws java.lang.Exception {
		java.lang.Object o = javaT.lang.reflect.Array.ExceedMaxDim.getArrayOf256Dimensions();
		try {
			o = java.lang.reflect.Array.newInstance(o.getClass(), new int[]{ 1, 1 });
			o = java.lang.reflect.Array.newInstance(o.getClass(), new int[]{ 1 });
		} catch (java.lang.IllegalArgumentException iae) {
			java.lang.System.out.println("success: newInstanceMulti test");
			return;
		}
		throw new java.lang.Exception("MultiNewArray allowed dimensions > MAXDIM");
	}

	private static void zeroDimension() throws java.lang.Exception {
		try {
			java.lang.reflect.Array.newInstance(java.lang.Integer.TYPE, new int[0]);
		} catch (java.lang.IllegalArgumentException iae) {
			java.lang.System.out.println("success: zeroDimension test");
			return;
		}
		throw new java.lang.Exception("MultiNewArray allowed dimension == 0");
	}

	private static java.lang.Object getArrayOf256Dimensions() {
		java.lang.Object o = java.lang.reflect.Array.newInstance(java.lang.Integer.TYPE, 0);
		for (int i = 1; i <= 254; i++) {
			o = java.lang.reflect.Array.newInstance(o.getClass(), 1);
		}
		return o;
	}
}