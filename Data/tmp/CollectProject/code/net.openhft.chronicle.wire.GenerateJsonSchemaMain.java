public class GenerateJsonSchemaMain {
	final java.util.Map<java.lang.Class<?>, java.lang.String> aliases = new java.util.LinkedHashMap<>();

	final java.util.Map<java.lang.Class<?>, java.lang.String> definitions = new java.util.LinkedHashMap<>();

	final java.util.Map<java.lang.String, java.lang.String> events = new java.util.TreeMap<>();

	final java.util.Set<java.lang.Class<?>> eventClasses = new java.util.LinkedHashSet<>();

	public GenerateJsonSchemaMain() {
		aliases.put(void.class, "null");
		aliases.put(java.lang.Void.class, "null");
		aliases.put(java.lang.String.class, "string");
		aliases.put(byte.class, "integer");
		aliases.put(short.class, "integer");
		aliases.put(int.class, "integer");
		aliases.put(long.class, "integer");
		aliases.put(float.class, "number");
		aliases.put(double.class, "number");
		aliases.put(boolean.class, "boolean");
	}

	public static void main(java.lang.String... args) throws java.lang.ClassNotFoundException {
		final java.lang.String json = net.openhft.chronicle.wire.GenerateJsonSchemaMain.main0(args);
		java.lang.System.out.println(json);
	}

	static java.lang.String main0(java.lang.String... args) throws java.lang.ClassNotFoundException {
		java.util.Set<java.lang.Class<?>> interfaces = new java.util.LinkedHashSet<>();
		for (java.lang.String arg : args) {
			interfaces.add(java.lang.Class.forName(arg));
		}
		net.openhft.chronicle.wire.GenerateJsonSchemaMain g = new net.openhft.chronicle.wire.GenerateJsonSchemaMain();
		for (java.lang.Class<?> aClass : interfaces) {
			g.generateEventSchemaFor(aClass);
		}
		final java.lang.String json = g.asJson();
		return json;
	}

	java.lang.String asJson() {
		net.openhft.chronicle.wire.utils.SourceCodeFormatter sb = new net.openhft.chronicle.wire.utils.JsonSourceCodeFormatter();
		java.lang.String str = "{\n" + ((("\"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" + "\"$id\": \"http://json-schema.org/draft-07/schema#\",\n") + "\"title\": \"Core schema meta-schema\",\n") + "\"definitions\": {\n");
		sb.append(str);
		java.lang.String sep = "";
		for (java.util.Map.Entry<java.lang.Class<?>, java.lang.String> entry : definitions.entrySet()) {
			sb.append(sep);
			sb.append(("\"" + entry.getKey().getSimpleName()) + "\": {\n");
			sb.append(entry.getValue());
			sb.append("}");
			sep = ",\n";
		}
		sb.append("\n");
		sb.append("},\n" + "\"properties\": {\n");
		for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : events.entrySet()) {
			sb.append(("\"" + entry.getKey()) + "\": {\n");
			sb.append(entry.getValue());
			sb.append("},\n");
		}
		sb.append("}\n" + "}\n");
		return sb.toString();
	}

	void generateEventSchemaFor(java.lang.Class<?> type) {
		if (type.isArray()) {
			return;
		}
		if (!eventClasses.add(type)) {
			return;
		}
		for (java.lang.reflect.Method method : type.getMethods()) {
			generateEventSchemaFor(method.getReturnType());
			java.util.stream.Stream.of(method.getParameterTypes()).forEach(this::generateObjectSchemaFor);
			java.lang.StringBuilder desc = new java.lang.StringBuilder();
			java.lang.Class<?>[] pTypes = method.getParameterTypes();
			java.lang.annotation.Annotation[][] pAnnotations = method.getParameterAnnotations();
			switch (pTypes.length) {
				case 0 :
					desc.append("\"type\": \"constant\",\n" + "\"value\": \"\"");
					break;
				case 1 :
					generateMethodDesc(desc, pTypes[0], pAnnotations[0]);
					break;
				default :
					net.openhft.chronicle.core.Jvm.debug().on(getClass(), "Method ignored as more than 1 argument " + method);
					break;
			}
			events.put(method.getName(), desc.toString());
		}
	}

	private void addProperties(java.util.Map<java.lang.String, java.lang.String> properties, java.lang.StringBuilder sb) {
		sb.append("\"properties\": {");
		java.lang.String sep = "\n";
		for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : properties.entrySet()) {
			sb.append(sep);
			sb.append(("\"" + entry.getKey()) + "\": {\n");
			sb.append(entry.getValue());
			sb.append("}");
			sep = ",\n";
		}
		sb.append("\n" + "}\n");
	}

	void generateObjectSchemaFor(java.lang.Class<?> type) {
		if (type.isArray()) {
			return;
		}
		if (aliases.containsKey(type)) {
			return;
		}
		aliases.put(type, "#/definitions/" + type.getSimpleName());
		java.util.Set<java.lang.String> required = new java.util.LinkedHashSet<>();
		java.util.Map<java.lang.String, java.lang.String> properties = new java.util.LinkedHashMap<>();
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		java.util.Map<java.lang.String, java.lang.reflect.Field> fieldMap = new java.util.LinkedHashMap<>();
		net.openhft.chronicle.wire.WireMarshaller.getAllField(type, fieldMap);
		for (java.util.Map.Entry<java.lang.String, java.lang.reflect.Field> entry : fieldMap.entrySet()) {
			java.lang.String name = entry.getKey();
			java.lang.StringBuilder desc = new java.lang.StringBuilder();
			java.lang.reflect.Field field = entry.getValue();
			java.lang.Class<?> fType = field.getType();
			java.lang.annotation.Annotation[] annotations = field.getAnnotations();
			addTypeForFieldOrParam(desc, fType, annotations);
			if (fType.isPrimitive() || hasNotNull(annotations)) {
				required.add(name);
			}
			properties.put(name, desc.toString());
		}
		sb.append("\"type\": \"object\",\n");
		if (!required.isEmpty()) {
			sb.append("\"required\": [\n");
			sb.append(required.stream().map(( s) -> ('"' + s) + '"').collect(java.util.stream.Collectors.joining(",\n")));
			sb.append("\n" + "],\n");
		}
		net.openhft.chronicle.wire.Comment comment = net.openhft.chronicle.core.Jvm.findAnnotation(type, net.openhft.chronicle.wire.Comment.class);
		if (comment != null) {
			sb.append(("\"description\": \"" + comment.value()) + "\",\n");
		}
		addProperties(properties, sb);
		definitions.put(type, sb.toString());
	}

	private boolean hasNotNull(java.lang.annotation.Annotation[] annotations) {
		for (java.lang.annotation.Annotation annotation : annotations) {
			if (annotation.annotationType().getName().endsWith(".NotNull")) {
				return true;
			}
		}
		return false;
	}

	private void generateMethodDesc(java.lang.StringBuilder desc, java.lang.Class<?> pType, java.lang.annotation.Annotation[] annotations) {
		addTypeForFieldOrParam(desc, pType, annotations);
	}

	private void addTypeForFieldOrParam(java.lang.StringBuilder desc, java.lang.Class<?> pType, java.lang.annotation.Annotation[] annotations) {
		net.openhft.chronicle.wire.LongConversion lc = find(annotations, net.openhft.chronicle.wire.LongConversion.class);
		if (lc != null) {
			java.lang.Class value = lc.value();
			if (value.getName().contains("Timestamp")) {
				desc.append("\"type\": \"string\",\n" + "\"format\": \"date-time\"");
			} else {
				desc.append("\"type\": \"string\"\n");
			}
		} else if (java.util.Collection.class.isAssignableFrom(pType)) {
			desc.append("\"type\": \"array\"\n");
		} else if (java.util.Map.class.isAssignableFrom(pType)) {
			desc.append("\"type\": \"object\"\n");
		} else {
			generateObjectSchemaFor(pType);
			java.lang.String alias = aliases.get(pType);
			java.lang.String key = (alias.startsWith("#")) ? "$ref" : "type";
			desc.append(((("\"" + key) + "\": \"") + alias) + "\"\n");
		}
	}

	private <T extends java.lang.annotation.Annotation> T find(java.lang.annotation.Annotation[] annotations, java.lang.Class<T> aClass) {
		for (java.lang.annotation.Annotation annotation : annotations) {
			if (aClass.isAssignableFrom(annotation.annotationType())) {
				return ((T) (annotation));
			}
		}
		return null;
	}
}