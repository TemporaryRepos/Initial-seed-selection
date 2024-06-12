public class ConceptTest {
	public static void main(java.lang.String[] args) {
		com.google.common.collect.Multimap<java.lang.String, ruc.irm.similarity.word.hownet2.concept.Concept> CONCEPTS = com.google.common.collect.HashMultimap.create();
		CONCEPTS.put("打", new ruc.irm.similarity.word.hownet2.concept.Concept("打", "V", "TakeOutOfWater|捞起"));
		CONCEPTS.put("打", new ruc.irm.similarity.word.hownet2.concept.Concept("打", "V", "TakeOutOfWater|捞起"));
		CONCEPTS.put("打", new ruc.irm.similarity.word.hownet2.concept.Concept("打", "V", "TakeOutOfWater|捞起"));
		CONCEPTS.put("打", new ruc.irm.similarity.word.hownet2.concept.Concept("打", "V", "TakeOutOfWater|捞起"));
		java.util.Collection<ruc.irm.similarity.word.hownet2.concept.Concept> collection = CONCEPTS.get("打");
		for (ruc.irm.similarity.word.hownet2.concept.Concept c : collection) {
			java.lang.System.out.println(c);
		}
		com.google.common.collect.Multimap<java.lang.String, java.lang.Integer> map = com.google.common.collect.HashMultimap.create();
		map.put("打", 1);
		map.put("打", 1);
		map.put("打", 1);
		map.put("打", 2);
		java.util.Collection<java.lang.Integer> cc = map.get("打");
		for (java.lang.Integer i : cc) {
			java.lang.System.out.println(i);
		}
	}
}