public class RunStreamWriter {
	private RunStreamWriter() {
	}

	protected javax.xml.stream.XMLOutputFactory getFactory() throws java.lang.Exception {
		return ((javax.xml.stream.XMLOutputFactory) (java.lang.Class.forName("com.fasterxml.aalto.stax.OutputFactoryImpl").newInstance()));
	}

	final java.lang.String ENCODING = "ISO-8859-1";

	protected void test() throws java.lang.Exception {
		javax.xml.stream.XMLOutputFactory f = getFactory();
		f.setProperty(javax.xml.stream.XMLOutputFactory.IS_REPAIRING_NAMESPACES, java.lang.Boolean.TRUE);
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		org.codehaus.stax2.XMLStreamWriter2 sw = ((org.codehaus.stax2.XMLStreamWriter2) (f.createXMLStreamWriter(bos, ENCODING)));
		sw.writeStartDocument();
		sw.writeSpace("\n");
		writeContents(sw);
		sw.writeEndDocument();
		sw.flush();
		sw.close();
		java.lang.System.err.println(("DOC -> '" + new java.lang.String(bos.toByteArray(), ENCODING)) + "'");
	}

	protected void writeContents(javax.xml.stream.XMLStreamWriter sw) throws javax.xml.stream.XMLStreamException {
		final java.lang.String URL_P1 = "http://p1.org";
		sw.writeStartElement("", "test", URL_P1);
		sw.writeStartElement("", "leaf", URL_P1);
		sw.writeEndElement();
		sw.writeEndElement();
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new test.RunStreamWriter().test();
	}
}