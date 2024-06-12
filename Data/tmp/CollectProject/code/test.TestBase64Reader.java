public class TestBase64Reader implements javax.xml.stream.XMLStreamConstants {
	static final java.lang.String CARNAL = "TWFuIGlzIGRpc3Rpbmd1" + (((((("aXNoZWQsIG5vdCBvbmx5" + "IGJ5IGhpcyByZWFzb24s") + "IGJ1dCBieSB0aGlz\n") + "IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg\n") + "dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu\n") + "dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo\n") + "ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=");

	public void test() throws javax.xml.stream.XMLStreamException {
		java.lang.System.setProperty("javax.xml.stream.XMLInputFactory", com.fasterxml.aalto.stax.InputFactoryImpl.class.getName());
		javax.xml.stream.XMLInputFactory f = javax.xml.stream.XMLInputFactory.newInstance();
		java.lang.String xml = ((("<root>" + test.TestBase64Reader.CARNAL) + "\r\n") + test.TestBase64Reader.CARNAL) + "</root>";
		final int CHUNK_LEN = 19;
		byte[] buffer = new byte[CHUNK_LEN];
		org.codehaus.stax2.typed.TypedXMLStreamReader sr = ((org.codehaus.stax2.typed.TypedXMLStreamReader) (f.createXMLStreamReader(new java.io.StringReader(xml))));
		sr.next();
		int offset = 0;
		while (true) {
			int count = sr.readElementAsBinary(buffer, 0, buffer.length, org.codehaus.stax2.typed.Base64Variants.MIME);
			java.lang.System.out.print(((("Result(" + offset) + "+") + count) + "): ");
			if (count < 0) {
				break;
			}
			java.lang.System.out.print('"');
			for (int i = 0; i < count; ++i) {
				java.lang.System.out.print(((char) (buffer[i])));
			}
			java.lang.System.out.print('"');
			offset += count;
			java.lang.System.out.println();
		} 
		java.lang.System.out.println("DONE!");
		sr.close();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new test.TestBase64Reader().test();
	}

	static final class TestAdapter extends org.codehaus.stax2.ri.Stax2ReaderAdapter {
		public TestAdapter(javax.xml.stream.XMLStreamReader sr) {
			super(sr);
		}
	}
}