public class FailSafe {
	public static void main(java.lang.String[] args) {
		java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> map = new java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		java.util.Iterator<java.lang.String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			java.lang.System.out.println(map.get(iterator.next()));
			map.put("key4", "value4");
		} 
	}
}