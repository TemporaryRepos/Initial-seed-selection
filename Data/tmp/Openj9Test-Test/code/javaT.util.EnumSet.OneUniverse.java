public class OneUniverse {
	private static final java.lang.reflect.Field universeField;

	static {
		try {
			universeField = java.util.EnumSet.class.getDeclaredField("universe");
		} catch (java.lang.NoSuchFieldException e) {
			throw new java.lang.AssertionError(e);
		}
		universeField.setAccessible(true);
	}

	public static void main(java.lang.String... args) {
		java.util.EnumSet<java.math.RoundingMode> noneSet = java.util.EnumSet.noneOf(java.math.RoundingMode.class);
		java.util.EnumSet<java.math.RoundingMode> allSet = java.util.EnumSet.allOf(java.math.RoundingMode.class);
		if (javaT.util.EnumSet.OneUniverse.getUniverse(noneSet) != javaT.util.EnumSet.OneUniverse.getUniverse(allSet)) {
			throw new java.lang.AssertionError("Multiple universes detected.  Inform the bridge!");
		}
	}

	private static <E extends java.lang.Enum<E>> java.lang.Enum<E>[] getUniverse(java.util.EnumSet<E> set) {
		try {
			return ((java.lang.Enum<E>[]) (javaT.util.EnumSet.OneUniverse.universeField.get(set)));
		} catch (java.lang.IllegalAccessException e) {
			throw new java.lang.AssertionError(e);
		}
	}
}