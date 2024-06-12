public class FastJsonPropertyPreFilter implements com.alibaba.fastjson.serializer.PropertyPreFilter {
	public static final java.util.regex.Pattern PROPERTY_SEPARATOR = java.util.regex.Pattern.compile("[,;:]+");

	private final java.util.Set<java.lang.String> includes = new java.util.HashSet<java.lang.String>();

	private final java.util.Set<java.lang.String> excludes = new java.util.HashSet<java.lang.String>();

	private final java.util.List<java.lang.String> fullPaths = new java.util.ArrayList<>();

	public FastJsonPropertyPreFilter(java.lang.Class<?> beanClass, java.util.List<java.lang.String> outputs, java.util.Set<java.lang.String> excluded, act.data.DataPropertyRepository dataPropertyRepository) {
		if (excluded.isEmpty()) {
			if (outputs.isEmpty()) {
				return;
			} else {
				addIncludes(outputs);
				if (act.util.FastJsonPropertyPreFilter.hasPattern(outputs)) {
					setFullPaths(fromPairs(dataPropertyRepository.propertyListOf(beanClass)));
				}
			}
		} else {
			addExcludes(excluded);
			if (act.util.FastJsonPropertyPreFilter.hasPattern(excluded)) {
				setFullPaths(fromPairs(dataPropertyRepository.propertyListOf(beanClass)));
			}
		}
	}

	private java.util.List<java.lang.String> fromPairs(java.util.List<org.osgl.util.S.Pair> pairs) {
		java.util.List<java.lang.String> list = new java.util.ArrayList<>();
		for (org.osgl.util.S.Pair pair : pairs) {
			list.add(pair._1);
		}
		return list;
	}

	public FastJsonPropertyPreFilter(java.lang.String... properties) {
		super();
		addIncludes(properties);
	}

	public void setFullPaths(java.util.List<java.lang.String> ls) {
		fullPaths.clear();
		fullPaths.addAll(ls);
	}

	public void addIncludes(java.lang.String... properties) {
		addTo(includes, properties);
	}

	public void addIncludes(java.util.Collection<java.lang.String> properties) {
		java.lang.String[] sa = new java.lang.String[properties.size()];
		addIncludes(properties.toArray(sa));
	}

	public void addExcludes(java.lang.String... properties) {
		addTo(excludes, properties);
	}

	public void addExcludes(java.util.Set<java.lang.String> properties) {
		java.lang.String[] sa = new java.lang.String[properties.size()];
		addTo(excludes, properties.toArray(sa));
	}

	private void addTo(java.util.Set<java.lang.String> set, java.lang.String... properties) {
		for (java.lang.String s : properties) {
			if (org.osgl.util.S.blank(s)) {
				continue;
			}
			java.lang.String[] sa = act.util.FastJsonPropertyPreFilter.PROPERTY_SEPARATOR.split(s);
			for (java.lang.String s0 : sa) {
				addOneTo(set, s0);
			}
		}
	}

	private void addOneTo(java.util.Set<java.lang.String> set, java.lang.String path) {
		if (path.contains("/")) {
			path = path.replace('/', '.');
		}
		set.add(path);
	}

	@java.lang.Override
	public boolean apply(com.alibaba.fastjson.serializer.JSONSerializer serializer, java.lang.Object source, java.lang.String name) {
		if (source == null) {
			return true;
		}
		java.lang.String path;
		org.osgl.util.FastStr fs = org.osgl.util.FastStr.of(serializer.getContext().toString()).append('.').append(name);
		path = fs.substring(fs.indexOf('.') + 1);
		return matches(path);
	}

	public boolean matches(java.lang.String path) {
		return (!matches(excludes, path, true)) && (includes.isEmpty() || matches(includes, path, false));
	}

	private static final java.util.regex.Pattern SQUARE_BLOCK = java.util.regex.Pattern.compile("\\[.*?\\]");

	private boolean matches(java.util.Set<java.lang.String> paths, java.lang.String path, boolean exclude) {
		if (path.contains("[")) {
			path = act.util.FastJsonPropertyPreFilter.SQUARE_BLOCK.matcher(path).replaceAll("");
		}
		if (paths.contains(path)) {
			return true;
		}
		for (java.lang.String s : paths) {
			if (path.startsWith(org.osgl.util.S.concat(s, "."))) {
				return true;
			}
		}
		if (act.util.FastJsonPropertyPreFilter.hasPattern(paths)) {
			return patternMatches(paths, path, exclude);
		}
		if (exclude) {
			return false;
		}
		path = path + ".";
		for (java.lang.String s : paths) {
			if (s.startsWith(path)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasPattern(java.util.Collection<java.lang.String> paths) {
		return org.osgl.util.S.join("", paths).contains("*");
	}

	private static java.util.Map<java.util.Collection<java.lang.String>, java.util.List<act.data.util.StringOrPattern>> spCache;

	public static void classInit(act.app.App app) {
		act.util.FastJsonPropertyPreFilter.spCache = app.createMap();
	}

	public static void testClassInit() {
		act.util.FastJsonPropertyPreFilter.spCache = new java.util.HashMap<>();
	}

	private boolean patternMatches(java.util.Set<java.lang.String> paths, java.lang.String path, boolean exclude) {
		java.util.List<act.data.util.StringOrPattern> spList = act.util.FastJsonPropertyPreFilter.spList(paths);
		for (act.data.util.StringOrPattern sp : spList) {
			if (sp.matches(path)) {
				return true;
			} else if ((!exclude) && sp.isPattern()) {
				java.util.regex.Pattern p = java.util.regex.Pattern.compile((path + "(\\.)?") + sp.s());
				for (java.lang.String fp : fullPaths) {
					if (p.matcher(fp).matches()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static java.util.List<act.data.util.StringOrPattern> spList(java.util.Collection<java.lang.String> strings) {
		java.util.List<act.data.util.StringOrPattern> ret = act.util.FastJsonPropertyPreFilter.spCache.get(strings);
		if (null == ret) {
			ret = new java.util.ArrayList<>();
			for (java.lang.String s : strings) {
				ret.add(new act.data.util.StringOrPattern(s));
			}
			act.util.FastJsonPropertyPreFilter.spCache.put(strings, ret);
		}
		return ret;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String path = "foo[0].bar[0].name";
		java.lang.System.out.println(path = act.util.FastJsonPropertyPreFilter.SQUARE_BLOCK.matcher(path).replaceAll(""));
	}
}