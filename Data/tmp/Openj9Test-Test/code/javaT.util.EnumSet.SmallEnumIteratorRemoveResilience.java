public class SmallEnumIteratorRemoveResilience {
	private static enum SmallEnum {

		e0,
		e1,
		e2;}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		final java.util.Set<javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum> set = java.util.EnumSet.noneOf(javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum.class);
		set.add(javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum.e0);
		set.add(javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum.e1);
		final java.util.Iterator<javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum> iterator = set.iterator();
		int size = set.size();
		javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum element = iterator.next();
		iterator.remove();
		javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.checkSetAfterRemoval(set, size, element);
		size = set.size();
		element = iterator.next();
		set.remove(element);
		javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.checkSetAfterRemoval(set, size, element);
		iterator.remove();
		javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.checkSetAfterRemoval(set, size, element);
	}

	private static void checkSetAfterRemoval(final java.util.Set<javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum> set, final int origSize, final javaT.util.EnumSet.SmallEnumIteratorRemoveResilience.SmallEnum removedElement) throws java.lang.Exception {
		if (set.size() != (origSize - 1)) {
			throw new java.lang.Exception(((("Test FAILED: Unexpected set size after removal; expected '" + (origSize - 1)) + "' but found '") + set.size()) + "'");
		}
		if (set.contains(removedElement)) {
			throw new java.lang.Exception("Test FAILED: Element returned from iterator unexpectedly still in set after removal.");
		}
	}
}