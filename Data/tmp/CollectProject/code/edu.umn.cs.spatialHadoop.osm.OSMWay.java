public class OSMWay extends org.apache.pig.EvalFunc<org.apache.pig.data.Tuple> {
	private javax.xml.parsers.DocumentBuilderFactory dbFactory;

	private javax.xml.parsers.DocumentBuilder dBuilder;

	public OSMWay() throws javax.xml.parsers.ParserConfigurationException {
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
			if (rootElement.getNodeName() != "way") {
				throw new java.lang.RuntimeException("Passed element must be <way>");
			}
			java.lang.Long id = (rootElement.getAttribute("id").isEmpty()) ? null : java.lang.Long.parseLong(rootElement.getAttribute("id"));
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
			org.w3c.dom.NodeList nodes = rootElement.getElementsByTagName("nd");
			org.apache.pig.data.DataBag nodesBag = org.apache.pig.data.BagFactory.getInstance().newDefaultBag();
			for (int i = 0; i < nodes.getLength(); i++) {
				org.w3c.dom.Node node = nodes.item(i);
				if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					int node_pos = ((int) (nodesBag.size() + 1));
					long node_id = java.lang.Long.parseLong(((org.w3c.dom.Element) (node)).getAttribute("ref"));
					org.apache.pig.data.Tuple nodeTuple = org.apache.pig.data.TupleFactory.getInstance().newTuple(2);
					nodeTuple.set(0, node_pos);
					nodeTuple.set(1, node_id);
					nodesBag.add(nodeTuple);
				}
			}
			org.apache.pig.data.Tuple newTuple = org.apache.pig.data.TupleFactory.getInstance().newTuple(10);
			newTuple.set(0, id);
			newTuple.set(1, user);
			newTuple.set(2, uid);
			newTuple.set(3, visible);
			newTuple.set(4, version);
			newTuple.set(5, changeset);
			newTuple.set(6, timestamp);
			newTuple.set(7, tagsMap);
			newTuple.set(8, nodesBag);
			return newTuple;
		} catch (java.lang.Exception e) {
			throw new java.io.IOException("Error parsing: " + input.get(0), e);
		}
	}

	@java.lang.Override
	public org.apache.pig.impl.logicalLayer.schema.Schema outputSchema(org.apache.pig.impl.logicalLayer.schema.Schema input) {
		try {
			org.apache.pig.impl.logicalLayer.schema.Schema waySchema = new org.apache.pig.impl.logicalLayer.schema.Schema();
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("id", org.apache.pig.data.DataType.LONG));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("user", org.apache.pig.data.DataType.CHARARRAY));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("uid", org.apache.pig.data.DataType.LONG));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("visible", org.apache.pig.data.DataType.BOOLEAN));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("version", org.apache.pig.data.DataType.INTEGER));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("changeset", org.apache.pig.data.DataType.INTEGER));
			waySchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("timestamp", org.apache.pig.data.DataType.CHARARRAY));
			org.apache.pig.impl.logicalLayer.schema.Schema tagSchema = new org.apache.pig.impl.logicalLayer.schema.Schema();
			tagSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("value", org.apache.pig.data.DataType.CHARARRAY));
			org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema temp = new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("tags", tagSchema);
			temp.type = org.apache.pig.data.DataType.MAP;
			waySchema.add(temp);
			org.apache.pig.impl.logicalLayer.schema.Schema nodeSchema = new org.apache.pig.impl.logicalLayer.schema.Schema();
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("pos", org.apache.pig.data.DataType.INTEGER));
			nodeSchema.add(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("node_id", org.apache.pig.data.DataType.LONG));
			temp = new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema("nodes", nodeSchema);
			temp.type = org.apache.pig.data.DataType.BAG;
			waySchema.add(temp);
			return new org.apache.pig.impl.logicalLayer.schema.Schema(new org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema(getSchemaName(this.getClass().getName().toLowerCase(), input), waySchema, org.apache.pig.data.DataType.TUPLE));
		} catch (java.lang.Exception e) {
			return null;
		}
	}

	public static void main(java.lang.String[] args) throws java.io.IOException, javax.xml.parsers.ParserConfigurationException {
		java.lang.String xml = "<way id='157358729' user='Mulad' uid='502142' visible='true' version='1' changeset='11134075' timestamp='2012-03-29T06:39:53Z'>" + (((("<nd ref='1695772908'/>" + "<nd ref='1695772884'/>") + "<nd ref='1695772853'/>") + "<tag k='highway' v='footway'/>") + "</way>");
		org.apache.pig.data.Tuple tuple = org.apache.pig.data.TupleFactory.getInstance().newTuple(xml);
		java.lang.System.out.println(new edu.umn.cs.spatialHadoop.osm.OSMWay().exec(tuple));
	}
}