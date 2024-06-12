public class DoubleKeys {
	public static void main(java.lang.String[] args) {
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("adler", "1");
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("adler", "1");
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("hello", "1");
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("adler", "2");
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("hello", "1");
		pers.adlered.picuang.tool.double_keys.main.DoubleKeys.c("adler", "2");
	}

	public static void c(java.lang.String key1, java.lang.String key2) {
		java.lang.System.out.println(pers.adlered.picuang.tool.double_keys.main.DoubleKeys.check(key1, key2));
	}

	public static boolean check(java.lang.String key1, java.lang.String key2) {
		java.util.List<java.lang.String> tempList = new java.util.ArrayList<>();
		if (pers.adlered.picuang.tool.double_keys.storage.DoubleKeysStorage.keyMap.containsKey(key1)) {
			tempList = pers.adlered.picuang.tool.double_keys.storage.DoubleKeysStorage.keyMap.get(key1);
			if (tempList.contains(key2)) {
				return false;
			} else {
				tempList.add(key2);
				pers.adlered.picuang.tool.double_keys.storage.DoubleKeysStorage.keyMap.put(key1, tempList);
				return true;
			}
		} else {
			tempList.add(key2);
			pers.adlered.picuang.tool.double_keys.storage.DoubleKeysStorage.keyMap.put(key1, tempList);
			return true;
		}
	}
}