public class MyHashMap {
	com.doinb.collections.Node[] table;

	int size;

	public MyHashMap() {
		this.table = new com.doinb.collections.Node[16];
	}

	public void put(java.lang.Object key, java.lang.Object value) {
		com.doinb.collections.Node newNode = new com.doinb.collections.Node();
		newNode.hash = com.doinb.collections.MyHashMap.myHash(key.hashCode(), table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		com.doinb.collections.Node tmp = table[newNode.hash];
		com.doinb.collections.Node iterLast = null;
		boolean keyRepeat = false;
		if (tmp == null) {
			table[newNode.hash] = newNode;
		} else {
			while (tmp != null) {
				if (tmp.key.equals(key)) {
					java.lang.System.out.println("key重复");
					keyRepeat = true;
					tmp.value = value;
					break;
				} else {
					iterLast = tmp;
					tmp = tmp.next;
				}
			} 
			if (!keyRepeat) {
				iterLast.next = newNode;
			}
		}
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> doc = new java.util.ArrayList<>();
		doc.add("google");
		doc.add("rinoob");
		java.lang.String string = com.alibaba.fastjson.JSON.toJSONString(doc);
		java.lang.System.out.println("string" + string);
		java.lang.String sign = org.apache.commons.codec.digest.DigestUtils.md5Hex(string).toUpperCase();
		java.lang.System.out.println(sign);
		java.lang.System.out.println("加密长度" + sign.length());
		java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<>();
		java.util.Hashtable<java.lang.String, java.lang.String> hashTable = new java.util.Hashtable<>();
		hashTable.put("google", "google.com");
		map.put("google", "google.com");
		map.put("rinoob", "runoob.com");
		java.util.ArrayList<java.lang.String> sites = new java.util.ArrayList<>();
		sites.add("Runoob");
		sites.add("Google");
		sites.add("Wiki");
		sites.add("Taobao");
		java.lang.System.out.println("网站列表: " + sites);
		java.lang.String list = sites.toString();
		java.lang.System.out.println("String: " + list);
		sites.removeIf(( e) -> {
			return e.contains("Taobao");
		});
		java.util.ArrayList clone = ((java.util.ArrayList) (sites.clone()));
		clone.forEach(( e) -> {
			java.lang.System.out.println(e + " clone ");
		});
		sites.forEach(( e) -> {
			java.lang.System.out.println(e + " ");
		});
	}

	public static int myHash(int v, int length) {
		java.lang.System.out.println("hash in myHash:\t" + (v & (length - 1)));
		java.lang.System.out.println("hash in myHash:\t" + (v % (length - 1)));
		return v & (length - 1);
	}
}