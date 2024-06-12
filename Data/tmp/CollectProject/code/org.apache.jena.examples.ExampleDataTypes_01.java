public class ExampleDataTypes_01 {
	private static final java.lang.String BASE = "http://example.org/";

	public static void main(java.lang.String[] args) {
		org.apache.jena.rdf.model.Model model = org.apache.jena.rdf.model.ModelFactory.createDefaultModel();
		org.apache.jena.rdf.model.Resource subject = org.apache.jena.examples.ExampleDataTypes_01.r("s");
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p1"), 10);
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p2"), 0.5);
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p3"), ((float) (0.5)));
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p4"), org.apache.jena.examples.ExampleDataTypes_01.l(20));
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p5"), org.apache.jena.examples.ExampleDataTypes_01.l(0.99));
		model.addLiteral(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p6"), true);
		model.add(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p7"), org.apache.jena.examples.ExampleDataTypes_01.l("2012-03-11", org.apache.jena.datatypes.xsd.XSDDatatype.XSDdate));
		model.add(subject, org.apache.jena.examples.ExampleDataTypes_01.p("p8"), org.apache.jena.examples.ExampleDataTypes_01.l("P2Y", org.apache.jena.datatypes.xsd.XSDDatatype.XSDduration));
		model.setNsPrefix("example", org.apache.jena.examples.ExampleDataTypes_01.BASE);
		model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");
		model.write(java.lang.System.out, "TURTLE");
	}

	private static org.apache.jena.rdf.model.Resource r(java.lang.String localname) {
		return org.apache.jena.rdf.model.ResourceFactory.createResource(org.apache.jena.examples.ExampleDataTypes_01.BASE + localname);
	}

	private static org.apache.jena.rdf.model.Property p(java.lang.String localname) {
		return org.apache.jena.rdf.model.ResourceFactory.createProperty(org.apache.jena.examples.ExampleDataTypes_01.BASE, localname);
	}

	private static org.apache.jena.rdf.model.Literal l(java.lang.Object value) {
		return org.apache.jena.rdf.model.ResourceFactory.createTypedLiteral(value);
	}

	private static org.apache.jena.rdf.model.Literal l(java.lang.String lexicalform, org.apache.jena.datatypes.RDFDatatype datatype) {
		return org.apache.jena.rdf.model.ResourceFactory.createTypedLiteral(lexicalform, datatype);
	}
}