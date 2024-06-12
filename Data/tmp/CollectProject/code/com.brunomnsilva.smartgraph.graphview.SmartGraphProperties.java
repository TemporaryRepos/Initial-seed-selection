public class SmartGraphProperties {
	private static final boolean DEFAULT_VERTEX_ALLOW_USER_MOVE = true;

	private static final java.lang.String PROPERTY_VERTEX_ALLOW_USER_MOVE = "vertex.allow-user-move";

	private static final double DEFAULT_VERTEX_RADIUS = 15;

	private static final java.lang.String PROPERTY_VERTEX_RADIUS = "vertex.radius";

	private static final boolean DEFAULT_VERTEX_USE_TOOLTIP = true;

	private static final java.lang.String PROPERTY_VERTEX_USE_TOOLTIP = "vertex.tooltip";

	private static final boolean DEFAULT_VERTEX_USE_LABEL = true;

	private static final java.lang.String PROPERTY_VERTEX_USE_LABEL = "vertex.label";

	private static final boolean DEFAULT_EDGE_USE_TOOLTIP = true;

	private static final java.lang.String PROPERTY_EDGE_USE_TOOLTIP = "edge.tooltip";

	private static final boolean DEFAULT_EDGE_USE_LABEL = true;

	private static final java.lang.String PROPERTY_EDGE_USE_LABEL = "edge.label";

	private static final boolean DEFAULT_EDGE_USE_ARROW = true;

	private static final java.lang.String PROPERTY_EDGE_USE_ARROW = "edge.arrow";

	private static final int DEFAULT_ARROW_SIZE = 5;

	private static final java.lang.String PROPERTY_ARROW_SIZE = "edge.arrowsize";

	private static final double DEFAULT_REPULSION_FORCE = 25000;

	private static final java.lang.String PROPERTY_REPULSION_FORCE = "layout.repulsive-force";

	private static final double DEFAULT_ATTRACTION_FORCE = 30;

	private static final java.lang.String PROPERTY_ATTRACTION_FORCE = "layout.attraction-force";

	private static final double DEFAULT_ATTRACTION_SCALE = 10;

	private static final java.lang.String PROPERTY_ATTRACTION_SCALE = "layout.attraction-scale";

	private static final java.lang.String DEFAULT_FILE = "smartgraph.properties";

	private final java.util.Properties properties;

	public SmartGraphProperties() {
		properties = new java.util.Properties();
		try {
			properties.load(new java.io.FileInputStream(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_FILE));
		} catch (java.io.IOException ex) {
			java.lang.String msg = java.lang.String.format("The default %s was not found. Using default values.", com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_FILE);
			java.util.logging.Logger.getLogger(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.class.getName()).log(java.util.logging.Level.WARNING, msg);
		}
	}

	public SmartGraphProperties(java.io.InputStream inputStream) {
		properties = new java.util.Properties();
		try {
			properties.load(inputStream);
		} catch (java.io.IOException ex) {
			java.lang.String msg = "The file provided by the input stream does not exist. Using default values.";
			java.util.logging.Logger.getLogger(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.class.getName()).log(java.util.logging.Level.WARNING, msg);
		}
	}

	public SmartGraphProperties(java.lang.String content) {
		properties = new java.util.Properties();
		try {
			java.io.InputStream targetStream = new java.io.ByteArrayInputStream(content.getBytes());
			properties.load(targetStream);
		} catch (java.io.IOException ex) {
			java.lang.String msg = "The string contents could not be loaded. Using default values.";
			java.util.logging.Logger.getLogger(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.class.getName()).log(java.util.logging.Level.WARNING, msg);
		}
	}

	public boolean getVertexAllowUserMove() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_VERTEX_ALLOW_USER_MOVE, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_VERTEX_ALLOW_USER_MOVE);
	}

	public double getVertexRadius() {
		return getDoubleProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_VERTEX_RADIUS, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_VERTEX_RADIUS);
	}

	public double getRepulsionForce() {
		return getDoubleProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_REPULSION_FORCE, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_REPULSION_FORCE);
	}

	public double getAttractionForce() {
		return getDoubleProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_ATTRACTION_FORCE, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_ATTRACTION_FORCE);
	}

	public double getAttractionScale() {
		return getDoubleProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_ATTRACTION_SCALE, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_ATTRACTION_SCALE);
	}

	public boolean getUseVertexTooltip() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_VERTEX_USE_TOOLTIP, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_VERTEX_USE_TOOLTIP);
	}

	public boolean getUseVertexLabel() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_VERTEX_USE_LABEL, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_VERTEX_USE_LABEL);
	}

	public boolean getUseEdgeTooltip() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_EDGE_USE_TOOLTIP, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_EDGE_USE_TOOLTIP);
	}

	public boolean getUseEdgeLabel() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_EDGE_USE_LABEL, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_EDGE_USE_LABEL);
	}

	public boolean getUseEdgeArrow() {
		return getBooleanProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_EDGE_USE_ARROW, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_EDGE_USE_ARROW);
	}

	public double getEdgeArrowSize() {
		return getDoubleProperty(com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.PROPERTY_ARROW_SIZE, com.brunomnsilva.smartgraph.graphview.SmartGraphProperties.DEFAULT_ARROW_SIZE);
	}

	private double getDoubleProperty(java.lang.String propertyName, double defaultValue) {
		java.lang.String p = properties.getProperty(propertyName, java.lang.Double.toString(defaultValue));
		try {
			return java.lang.Double.parseDouble(p);
		} catch (java.lang.NumberFormatException e) {
			java.lang.System.err.printf("Error in reading property %s: %s", propertyName, e.getMessage());
			return defaultValue;
		}
	}

	private boolean getBooleanProperty(java.lang.String propertyName, boolean defaultValue) {
		java.lang.String p = properties.getProperty(propertyName, java.lang.Boolean.toString(defaultValue));
		try {
			return java.lang.Boolean.parseBoolean(p);
		} catch (java.lang.NumberFormatException e) {
			java.lang.System.err.printf("Error in reading property %s: %s", propertyName, e.getMessage());
			return defaultValue;
		}
	}

	public static void main(java.lang.String[] args) {
		com.brunomnsilva.smartgraph.graphview.SmartGraphProperties props = new com.brunomnsilva.smartgraph.graphview.SmartGraphProperties();
		java.lang.System.out.println("Prop vertex radius: " + props.getVertexRadius());
		java.lang.System.out.println("Prop vertex use label: " + props.getUseVertexLabel());
	}
}