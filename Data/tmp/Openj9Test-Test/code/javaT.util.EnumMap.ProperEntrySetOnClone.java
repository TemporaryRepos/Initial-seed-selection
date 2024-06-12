public class ProperEntrySetOnClone {
	public enum Test {

		ONE,
		TWO;}

	public static void main(java.lang.String[] args) {
		java.util.EnumMap<javaT.util.EnumMap.ProperEntrySetOnClone.Test, java.lang.String> map1 = new java.util.EnumMap<javaT.util.EnumMap.ProperEntrySetOnClone.Test, java.lang.String>(javaT.util.EnumMap.ProperEntrySetOnClone.Test.class);
		map1.put(javaT.util.EnumMap.ProperEntrySetOnClone.Test.ONE, "1");
		map1.put(javaT.util.EnumMap.ProperEntrySetOnClone.Test.TWO, "2");
		int size = map1.entrySet().size();
		if (size != 2) {
			throw new java.lang.RuntimeException("Invalid size in original map. Expected: 2 was: " + size);
		}
		java.util.EnumMap<javaT.util.EnumMap.ProperEntrySetOnClone.Test, java.lang.String> map2 = map1.clone();
		map2.remove(javaT.util.EnumMap.ProperEntrySetOnClone.Test.ONE);
		size = map2.entrySet().size();
		if (size != 1) {
			throw new java.lang.RuntimeException("Invalid size in cloned instance. Expected: 1 was: " + size);
		}
	}
}