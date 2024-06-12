public class ExampleAPI_02 {
	public static void main(java.lang.String[] args) {
		org.apache.jena.rdf.model.Model model = org.apache.jena.rdf.model.ModelFactory.createDefaultModel();
		model.createResource("http://example.org/alice", org.apache.jena.sparql.vocabulary.FOAF.Person).addProperty(org.apache.jena.sparql.vocabulary.FOAF.name, "Alice").addProperty(org.apache.jena.sparql.vocabulary.FOAF.mbox, model.createResource("mailto:alice@example.org")).addProperty(org.apache.jena.sparql.vocabulary.FOAF.knows, model.createResource("http://example.org/bob"));
		model.write(java.lang.System.out, "TURTLE");
	}
}