public class ReadObject extends java.util.Hashtable {
	class ValueWrapper implements java.io.Serializable {
		private java.lang.Object mValue;

		ValueWrapper(java.lang.Object value) {
			mValue = value;
		}

		java.lang.Object getValue() {
			return mValue;
		}
	}

	public java.lang.Object get(java.lang.Object key) {
		jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper valueWrapper = ((jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper) (super.get(key)));
		java.lang.Object value = valueWrapper.getValue();
		if (value instanceof jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper) {
			throw new java.lang.RuntimeException("Hashtable.get bug");
		}
		return value;
	}

	public java.lang.Object put(java.lang.Object key, java.lang.Object value) {
		if (value instanceof jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper) {
			throw new java.lang.RuntimeException("Hashtable.put bug: value is already wrapped");
		}
		jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper valueWrapper = new jsr166tests.jtreg.util.Hashtable.ReadObject.ValueWrapper(value);
		super.put(key, valueWrapper);
		return value;
	}

	private static java.lang.Object copyObject(java.lang.Object oldObj) {
		java.lang.Object newObj = null;
		try {
			java.io.ByteArrayOutputStream ostream = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream p = new java.io.ObjectOutputStream(ostream);
			p.writeObject(oldObj);
			byte[] byteArray = ostream.toByteArray();
			java.io.ByteArrayInputStream istream = new java.io.ByteArrayInputStream(byteArray);
			java.io.ObjectInputStream q = new java.io.ObjectInputStream(istream);
			newObj = q.readObject();
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
		return newObj;
	}

	public static void main(java.lang.String[] args) {
		jsr166tests.jtreg.util.Hashtable.ReadObject myHashtable = new jsr166tests.jtreg.util.Hashtable.ReadObject();
		myHashtable.put("key", "value");
		jsr166tests.jtreg.util.Hashtable.ReadObject myHashtableCopy = ((jsr166tests.jtreg.util.Hashtable.ReadObject) (jsr166tests.jtreg.util.Hashtable.ReadObject.copyObject(myHashtable)));
		java.lang.String value = ((java.lang.String) (myHashtableCopy.get("key")));
	}
}