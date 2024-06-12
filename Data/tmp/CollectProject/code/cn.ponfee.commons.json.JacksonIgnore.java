public class JacksonIgnore {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter fieldFilter = com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter.serializeAllExcept("code", "b", "c");
		com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider filterProvider = new com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider().addFilter("fieldFilter", fieldFilter);
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		mapper.setFilterProvider(filterProvider).addMixIn(java.util.Map.class, cn.ponfee.commons.json.JacksonIgnore.FieldFilterMixIn.class);
		java.lang.System.out.println(mapper.writeValueAsString(cn.ponfee.commons.model.Result.success()));
	}

	@com.fasterxml.jackson.annotation.JsonFilter("fieldFilter")
	interface FieldFilterMixIn {}
}