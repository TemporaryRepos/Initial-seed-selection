public class ExampleAPI_03 {
	public static void main(java.lang.String[] args) {
		org.apache.jena.rdf.model.Model model = org.apache.jena.rdf.model.ModelFactory.createDefaultModel();
		org.apache.jena.rdf.model.Resource alice = org.apache.jena.rdf.model.ResourceFactory.createResource("http://example.org/alice");
		org.apache.jena.rdf.model.Resource bob = org.apache.jena.rdf.model.ResourceFactory.createResource("http://example.org/bob");
		model.add(alice, org.apache.jena.vocabulary.RDF.type, org.apache.jena.sparql.vocabulary.FOAF.Person);
		model.add(alice, org.apache.jena.sparql.vocabulary.FOAF.name, "Alice");
		model.add(alice, org.apache.jena.sparql.vocabulary.FOAF.mbox, org.apache.jena.rdf.model.ResourceFactory.createResource("mailto:alice@example.org"));
		model.add(alice, org.apache.jena.sparql.vocabulary.FOAF.knows, bob);
		model.write(java.lang.System.out, "TURTLE");
	}
}