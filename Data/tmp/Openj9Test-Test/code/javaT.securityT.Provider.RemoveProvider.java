public class RemoveProvider {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.securityT.testlibrary.ProvidersSnapshot snapshot = javaT.securityT.testlibrary.ProvidersSnapshot.create();
		try {
			javaT.securityT.Provider.RemoveProvider.main0(args);
		} finally {
			snapshot.restore();
		}
	}

	public static void main0(java.lang.String[] args) throws java.lang.Exception {
		java.security.Provider p1 = new javaT.securityT.Provider.MyProvider("name1", 1, "");
		java.security.Security.addProvider(p1);
		java.security.Provider p2 = new javaT.securityT.Provider.MyProvider("name2", 1, "");
		java.security.Security.addProvider(p2);
		java.lang.System.out.println("// List all providers");
		java.security.Provider[] provs = java.security.Security.getProviders();
		for (int i = 0; i < provs.length; i++) {
			java.lang.System.out.println(provs[i].toString());
		}
		java.lang.System.out.println("");
		java.lang.System.out.println("// Remove one provider");
		java.security.Security.removeProvider("name1");
		provs = java.security.Security.getProviders();
		for (int i = 0; i < provs.length; i++) {
			java.lang.System.out.println(provs[i].toString());
		}
		java.lang.System.out.println("");
		java.lang.System.out.println("// Iterate over entrySet");
		java.util.Map.Entry me = null;
		java.util.Set es = p1.entrySet();
		java.util.Iterator i = es.iterator();
		while (i.hasNext()) {
			me = ((java.util.Map.Entry) (i.next()));
			java.lang.System.out.println("Key: " + ((java.lang.String) (me.getKey())));
			java.lang.System.out.println("Value: " + ((java.lang.String) (me.getValue())));
		} 
		try {
			me.setValue("name1.mac");
			throw new java.lang.Exception("Expected exception not thrown");
		} catch (java.lang.UnsupportedOperationException uoe) {
			java.lang.System.out.println("Expected exception caught");
		}
		java.lang.System.out.println("");
		java.lang.System.out.println("// Iterate over keySet");
		java.lang.Object o = null;
		java.util.Set ks = p1.keySet();
		i = ks.iterator();
		while (i.hasNext()) {
			o = i.next();
			java.lang.System.out.println(((java.lang.String) (o)));
		} 
		try {
			ks.remove(o);
			throw new java.lang.Exception("Expected exception not thrown");
		} catch (java.lang.UnsupportedOperationException uoe) {
		}
		java.lang.System.out.println("");
		java.lang.System.out.println("// Iterate over values");
		java.util.Collection c = p1.values();
		i = c.iterator();
		while (i.hasNext()) {
			java.lang.System.out.println(((java.lang.String) (i.next())));
		} 
		java.lang.System.out.println("");
		java.lang.System.out.println("// Add 'Cipher' entry to provider");
		p1.put("Cipher", "name1.des");
		i = es.iterator();
		boolean found = false;
		while (i.hasNext()) {
			me = ((java.util.Map.Entry) (i.next()));
			java.lang.System.out.println("Key: " + ((java.lang.String) (me.getKey())));
			java.lang.System.out.println("Value: " + ((java.lang.String) (me.getValue())));
			if (((java.lang.String) (me.getKey())).equals("Cipher")) {
				found = true;
			}
		} 
		if (!found) {
			throw new java.lang.Exception("EntrySet not live");
		}
		i = ks.iterator();
		while (i.hasNext()) {
			o = i.next();
			java.lang.System.out.println(((java.lang.String) (o)));
		} 
		i = c.iterator();
		while (i.hasNext()) {
			java.lang.System.out.println(((java.lang.String) (i.next())));
		} 
		java.lang.System.out.println("");
		java.lang.System.out.println("// Remove 'Digest' entry from provider");
		p1.remove("Digest");
		i = es.iterator();
		while (i.hasNext()) {
			me = ((java.util.Map.Entry) (i.next()));
			java.lang.System.out.println("Key: " + ((java.lang.String) (me.getKey())));
			java.lang.System.out.println("Value: " + ((java.lang.String) (me.getValue())));
		} 
		i = ks.iterator();
		while (i.hasNext()) {
			o = i.next();
			java.lang.System.out.println(((java.lang.String) (o)));
		} 
		i = c.iterator();
		while (i.hasNext()) {
			java.lang.System.out.println(((java.lang.String) (i.next())));
		} 
		es = p1.entrySet();
		i = es.iterator();
		while (i.hasNext()) {
			me = ((java.util.Map.Entry) (i.next()));
			java.lang.System.out.println("Key: " + ((java.lang.String) (me.getKey())));
			java.lang.System.out.println("Value: " + ((java.lang.String) (me.getValue())));
		} 
		try {
			me.setValue("name1.mac");
			throw new java.lang.Exception("Expected exception not thrown");
		} catch (java.lang.UnsupportedOperationException uoe) {
			java.lang.System.out.println("Expected exception caught");
		}
	}
}