public class UniqueNullValue {
	static enum TestEnum {

		e00,
		e01;}

	public static void main(java.lang.String[] args) {
		java.util.Map<javaT.util.EnumMap.UniqueNullValue.TestEnum, java.lang.Integer> map = new java.util.EnumMap<>(javaT.util.EnumMap.UniqueNullValue.TestEnum.class);
		map.put(javaT.util.EnumMap.UniqueNullValue.TestEnum.e00, 0);
		if (false == map.containsValue(0)) {
			throw new java.lang.RuntimeException("EnumMap unexpectedly missing 0 value");
		}
		if (map.containsValue(null)) {
			throw new java.lang.RuntimeException("EnumMap unexpectedly holds null value");
		}
		map.put(javaT.util.EnumMap.UniqueNullValue.TestEnum.e00, null);
		if (map.containsValue(0)) {
			throw new java.lang.RuntimeException("EnumMap unexpectedly holds 0 value");
		}
		if (false == map.containsValue(null)) {
			throw new java.lang.RuntimeException("EnumMap unexpectedly missing null value");
		}
	}
}