public class OverrideIsEmpty {
	public static class NotEmptyHashMap<K, V> extends java.util.HashMap<K, V> {
		private K alwaysExistingKey;

		private V alwaysExistingValue;

		@java.lang.Override
		public V get(java.lang.Object key) {
			if (key == alwaysExistingKey) {
				return alwaysExistingValue;
			}
			return super.get(key);
		}

		@java.lang.Override
		public int size() {
			return super.size() + 1;
		}

		@java.lang.Override
		public boolean isEmpty() {
			return size() == 0;
		}
	}

	public static void main(java.lang.String[] args) {
		javaT.util.HashMap.OverrideIsEmpty.NotEmptyHashMap<java.lang.Object, java.lang.Object> map = new javaT.util.HashMap.OverrideIsEmpty.NotEmptyHashMap<>();
		java.lang.Object key = new java.lang.Object();
		java.lang.Object value = new java.lang.Object();
		map.get(key);
		map.remove(key);
		map.replace(key, value, null);
		map.replace(key, value);
		map.computeIfPresent(key, new java.util.function.BiFunction<java.lang.Object, java.lang.Object, java.lang.Object>() {
			public java.lang.Object apply(java.lang.Object key, java.lang.Object oldValue) {
				return oldValue;
			}
		});
	}
}