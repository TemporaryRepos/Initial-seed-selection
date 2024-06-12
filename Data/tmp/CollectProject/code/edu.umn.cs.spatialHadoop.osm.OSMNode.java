public class OSMNode extends org.apache.pig.EvalFunc<org.apache.pig.data.Tuple> {
	private javax.xml.parsers.DocumentBuilderFactory dbFactory;

	private javax.xml.parsers.DocumentBuilder dBuilder;

	public OSMNode() throws javax.xml.parsers.ParserConfigurationException {
		dbFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
	}

	@java.lang.Override
	public org.apache.pig.data.Tuple exec(org.apache.pig.data.Tuple input) throws java.io.IOException {
		if ((input == null) || (input.size() == 0)) {
			return null;
		}
		try {
			java.lang.String str = ((java.lang.String) (input.get(0)));
			java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(str.getBytes("UTF8"));
			org.w3c.dom.Document doc = dBuilder.parse(in);
			org.w3c.dom.Element rootElement = doc.getDocumentElement();
			rootElement.normalize();
			if (rootElement.getNodeName() != "node") {
				throw new java.lang.RuntimeException("Passed element must be <node>");
			}
			java.lang.Long id = (rootElement.getAttribute("id").isEmpty()) ? null : java.lang.Long.parseLong(rootElement.getAttribute("id"));
			java.lang.Double lat = (rootElement.getAttribute("lat").isEmpty()) ? null : java.lang.Double.parseDouble(rootElement.getAttribute("lat"));
			java.lang.Double lon = (rootElement.getAttribute("lon").isEmpty()) ? null : java.lang.Double.parseDouble(rootElement.getAttribute("lon"));
			java.lang.String user = rootElement.getAttribute("user");
			java.lang.Long uid = (rootElement.getAttribute("uid").isEmpty()) ? null : java.lang.Long.parseLong(rootElement.getAttribute("uid"));
			java.lang.Boolean visible = (rootElement.getAttribute("true").isEmpty()) ? null : java.lang.Boolean.parseBoolean(rootElement.getAttribute("true"));
			java.lang.Integer version = (rootElement.getAttribute("version").isEmpty()) ? null : java.lang.Integer.parseInt(rootElement.getAttribute("version"));
			java.lang.Integer changeset = (rootElement.getAttribute("changeset").isEmpty()) ? null : java.lang.Integer.parseInt(rootElement.getAttribute("changeset"));
			java.lang.String timestamp = rootElement.getAttribute("timestamp");
			org.w3c.dom.NodeList tags = rootElement.getElementsByTagName("tag");
			java.util.Map<java.lang.String, java.lang.String> tagsMap = new java.util.HashMap<java.lang.String, java.lang.String>();
			for (int i = 0; i < tags.getLength(); i++) {
				org.w3c.dom.Node tag = tags.item(i);
				if (tag.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					java.lang.String key = ((org.w3c.dom.Element) (tag)).getAttribute("k");
					java.lang.String value = ((org.w3c.dom.Element) (tag)).getAttribute("v");
					key = key.replaceAll("[\\s]", " ").replaceAll("[\\\'\\\"#,]", "_");
					value = value.replaceAll("[\\s]", " ").replaceAll("[\\\'\\\"#,]", "_");
					tagsMap.put(key, value);
				}
			}
			org.apache.pig.data.Tuple newTuple = org.apache.pig.data.TupleFactory.getInstance().newTuple(10);
			newTuple.set(0, id);
			newTuple.set(1, lat);
			newTuple.set(2, lon);
			newTuple.set(3, user);
			newTuple.set(4, uid);
			newTuple.set(5, visible);
			newTuple.set(6, version);
			newTuple.set(7, changeset);
			newTuple.set(8, timestamp);
			newTuple.set(9, tagsMap);
			return newTuple;
		} catch (java.lang.Exception e) {
			throw new java.io.IOException("Error parsing: " + input.get(0), e);
		}
	}

	@java.lang.Override
	public org.apache.pig.impl.logicalLayer.schema.Schema outputSchema(org.apache.pig.impl.logicalLayer.schema.Schema input) {
		try {
			org.apache.pig.impl.logicalLayer.schema.Schema nodeSchema = new org.apache.pig.impl.logicalLayer.schema.Schema();
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("id", org.apache.pig.data.DataType.LONG));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("lat", org.apache.pig.data.DataType.DOUBLE));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("lon", org.apache.pig.data.DataType.DOUBLE));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("user", org.apache.pig.data.DataType.CHARARRAY));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("uid", org.apache.pig.data.DataType.LONG));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("visible", org.apache.pig.data.DataType.BOOLEAN));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("version", org.apache.pig.data.DataType.INTEGER));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("changeset", org.apache.pig.data.DataType.INTEGER));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("timestamp", org.apache.pig.data.DataType.CHARARRAY));
			org.apache.pig.impl.logicalLayer.schema.Schema tagSchema = new org.apache.pig.impl.logicalLayer.schema.Schema();
			tagSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("value", org.apache.pig.data.DataType.CHARARRAY));
			org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema temp = new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("tags", tagSchema);
			temp.type = org.apache.pig.data.DataType.MAP;
			nodeSchema.add(temp);
			return new org.apache.pig.impl.logicalLayer.schema.Schema(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema(getSchemaName(this.getClass().getName().toLowerCase(), input), nodeSchema, org.apache.pig.data.DataType.TUPLE));
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public static void main(java.lang.String[] args) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException {
		java.lang.String text = "ahmed\t\nmohamed\'\'\"";
		java.lang.System.out.println(text);
		java.lang.System.out.println(text.replaceAll("[\\s]", " ").replaceAll("[\\\'\\\"]", "_"));
	}
}