public class StreamConstructor {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		java.util.zip.Deflater def = new java.util.zip.Deflater();
		java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(new byte[10]);
		java.util.zip.Inflater inf = new java.util.zip.Inflater();
		java.util.zip.InflaterInputStream infOS;
		java.util.zip.DeflaterOutputStream defOS;
		try {
			defOS = new java.util.zip.DeflaterOutputStream(bos, null);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			defOS = new java.util.zip.DeflaterOutputStream(null, def);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			defOS = new java.util.zip.DeflaterOutputStream(bos, def, -1);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.IllegalArgumentException e) {
		}
		try {
			infOS = new java.util.zip.InflaterInputStream(bis, null);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			infOS = new java.util.zip.InflaterInputStream(null, inf);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.NullPointerException e) {
		}
		try {
			infOS = new java.util.zip.InflaterInputStream(bis, inf, -1);
			throw new java.lang.Exception("didn't catch illegal argument");
		} catch (java.lang.IllegalArgumentException e) {
		}
	}
}