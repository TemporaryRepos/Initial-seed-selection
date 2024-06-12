public class WeakVsHashMap {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String a = new java.lang.String("a");
		java.lang.String b = new java.lang.String("b");
		java.util.Map weakmap = new java.util.WeakHashMap();
		java.util.Map map = new java.util.HashMap();
		map.put(a, "aaa");
		map.put(b, "bbb");
		weakmap.put(a, "aaa");
		weakmap.put(b, "bbb");
		map.remove(a);
		a = null;
		b = null;
		java.lang.System.gc();
		java.util.Iterator i = map.entrySet().iterator();
		while (i.hasNext()) {
			java.util.Map.Entry en = ((java.util.Map.Entry) (i.next()));
			java.lang.System.out.println((("map:" + en.getKey()) + ":") + en.getValue());
		} 
		java.util.Iterator j = weakmap.entrySet().iterator();
		while (j.hasNext()) {
			java.util.Map.Entry en = ((java.util.Map.Entry) (j.next()));
			java.lang.System.out.println((("weakmap:" + en.getKey()) + ":") + en.getValue());
		} 
	}
}