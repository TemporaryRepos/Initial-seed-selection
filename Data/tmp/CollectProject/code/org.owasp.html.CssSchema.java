@org.owasp.html.TCB
public final class CssSchema {
	public static final class Property {
		final int bits;

		final com.google.common.collect.ImmutableSet<java.lang.String> literals;

		final com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> fnKeys;

		public Property(int bits, com.google.common.collect.ImmutableSet<java.lang.String> literals, com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> fnKeys) {
			this.bits = bits;
			this.literals = literals;
			this.fnKeys = fnKeys;
		}

		@java.lang.Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = (prime * result) + bits;
			result = (prime * result) + (fnKeys == null ? 0 : fnKeys.hashCode());
			result = (prime * result) + (literals == null ? 0 : literals.hashCode());
			return result;
		}

		@java.lang.Override
		public boolean equals(java.lang.Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			org.owasp.html.CssSchema.Property other = ((org.owasp.html.CssSchema.Property) (obj));
			if (bits != other.bits) {
				return false;
			}
			if (fnKeys == null) {
				if (other.fnKeys != null) {
					return false;
				}
			} else if (!fnKeys.equals(other.fnKeys)) {
				return false;
			}
			if (literals == null) {
				if (other.literals != null) {
					return false;
				}
			} else if (!literals.equals(other.literals)) {
				return false;
			}
			return true;
		}
	}

	static final int BIT_QUANTITY = 1;

	static final int BIT_HASH_VALUE = 2;

	static final int BIT_NEGATIVE = 4;

	static final int BIT_STRING = 8;

	static final int BIT_URL = 16;

	static final int BIT_UNRESERVED_WORD = 64;

	static final int BIT_UNICODE_RANGE = 128;

	static final org.owasp.html.CssSchema.Property DISALLOWED = new org.owasp.html.CssSchema.Property(0, com.google.common.collect.ImmutableSet.<java.lang.String>of(), com.google.common.collect.ImmutableMap.<java.lang.String, java.lang.String>of());

	private final com.google.common.collect.ImmutableMap<java.lang.String, org.owasp.html.CssSchema.Property> properties;

	private CssSchema(com.google.common.collect.ImmutableMap<java.lang.String, org.owasp.html.CssSchema.Property> properties) {
		if (properties == null) {
			throw new java.lang.NullPointerException();
		}
		this.properties = properties;
	}

	public static org.owasp.html.CssSchema withProperties(java.lang.Iterable<? extends java.lang.String> propertyNames) {
		com.google.common.collect.ImmutableMap.Builder<java.lang.String, org.owasp.html.CssSchema.Property> propertiesBuilder = com.google.common.collect.ImmutableMap.builder();
		for (java.lang.String propertyName : propertyNames) {
			org.owasp.html.CssSchema.Property prop = org.owasp.html.CssSchema.DEFINITIONS.get(propertyName);
			if (prop == null) {
				throw new java.lang.IllegalArgumentException(propertyName);
			}
			propertiesBuilder.put(propertyName, prop);
		}
		return new org.owasp.html.CssSchema(propertiesBuilder.build());
	}

	public static org.owasp.html.CssSchema withProperties(java.util.Map<? extends java.lang.String, ? extends org.owasp.html.CssSchema.Property> properties) {
		com.google.common.collect.ImmutableMap<java.lang.String, org.owasp.html.CssSchema.Property> propertyMap = com.google.common.collect.ImmutableMap.copyOf(properties);
		for (java.util.Map.Entry<java.lang.String, org.owasp.html.CssSchema.Property> e : propertyMap.entrySet()) {
			org.owasp.html.CssSchema.Property property = e.getValue();
			for (java.lang.String fnKey : property.fnKeys.values()) {
				if (!propertyMap.containsKey(fnKey)) {
					throw new java.lang.IllegalArgumentException((("Property map is not self contained.  " + e.getValue()) + " depends on undefined function key ") + fnKey);
				}
			}
		}
		return new org.owasp.html.CssSchema(propertyMap);
	}

	public static org.owasp.html.CssSchema union(org.owasp.html.CssSchema... cssSchemas) {
		if (cssSchemas.length == 1) {
			return cssSchemas[0];
		}
		java.util.Map<java.lang.String, org.owasp.html.CssSchema.Property> properties = com.google.common.collect.Maps.newLinkedHashMap();
		for (org.owasp.html.CssSchema cssSchema : cssSchemas) {
			for (java.util.Map.Entry<java.lang.String, org.owasp.html.CssSchema.Property> e : cssSchema.properties.entrySet()) {
				java.lang.String name = e.getKey();
				org.owasp.html.CssSchema.Property newProp = e.getValue();
				com.google.common.base.Preconditions.checkNotNull(name);
				com.google.common.base.Preconditions.checkNotNull(newProp);
				org.owasp.html.CssSchema.Property oldProp = properties.put(name, newProp);
				if ((oldProp != null) && (!oldProp.equals(newProp))) {
					throw new java.lang.IllegalArgumentException("Duplicate irreconcilable definitions for " + name);
				}
			}
		}
		return new org.owasp.html.CssSchema(com.google.common.collect.ImmutableMap.copyOf(properties));
	}

	public java.util.Set<java.lang.String> allowedProperties() {
		return properties.keySet();
	}

	org.owasp.html.CssSchema.Property forKey(java.lang.String propertyName) {
		java.lang.String propertyNameCanon = org.owasp.html.Strings.toLowerCase(propertyName);
		org.owasp.html.CssSchema.Property property = properties.get(propertyNameCanon);
		if (property != null) {
			return property;
		}
		int n = propertyNameCanon.length();
		if ((n != 0) && (propertyNameCanon.charAt(0) == '-')) {
			java.lang.String barePropertyNameCanon = org.owasp.html.CssSchema.stripVendorPrefix(propertyNameCanon);
			property = properties.get(barePropertyNameCanon);
			if (property != null) {
				return property;
			}
		}
		return org.owasp.html.CssSchema.DISALLOWED;
	}

	@javax.annotation.Nullable
	private static java.lang.String stripVendorPrefix(java.lang.String cssKeyword) {
		int prefixLen = 0;
		if (cssKeyword.length() >= 2) {
			switch (cssKeyword.charAt(1)) {
				case 'm' :
					if (cssKeyword.startsWith("-ms-")) {
						prefixLen = 4;
					} else if (cssKeyword.startsWith("-moz-")) {
						prefixLen = 5;
					}
					break;
				case 'o' :
					if (cssKeyword.startsWith("-o-")) {
						prefixLen = 3;
					}
					break;
				case 'w' :
					if (cssKeyword.startsWith("-webkit-")) {
						prefixLen = 8;
					}
					break;
				default :
					break;
			}
		}
		return prefixLen == 0 ? null : cssKeyword.substring(prefixLen);
	}

	static final com.google.common.collect.ImmutableMap<java.lang.String, org.owasp.html.CssSchema.Property> DEFINITIONS;

	static {
		com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> zeroFns = com.google.common.collect.ImmutableMap.of();
		com.google.common.collect.ImmutableMap.Builder<java.lang.String, org.owasp.html.CssSchema.Property> builder = com.google.common.collect.ImmutableMap.builder();
		com.google.common.collect.ImmutableSet<java.lang.String> mozBorderRadiusLiterals0 = com.google.common.collect.ImmutableSet.of("/");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOpacityLiterals0 = com.google.common.collect.ImmutableSet.of("inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineLiterals0 = com.google.common.collect.ImmutableSet.of("aliceblue", "antiquewhite", "aqua", "aquamarine", "azure", "beige", "bisque", "black", "blanchedalmond", "blue", "blueviolet", "brown", "burlywood", "cadetblue", "chartreuse", "chocolate", "coral", "cornflowerblue", "cornsilk", "crimson", "cyan", "darkblue", "darkcyan", "darkgoldenrod", "darkgray", "darkgreen", "darkkhaki", "darkmagenta", "darkolivegreen", "darkorange", "darkorchid", "darkred", "darksalmon", "darkseagreen", "darkslateblue", "darkslategray", "darkturquoise", "darkviolet", "deeppink", "deepskyblue", "dimgray", "dodgerblue", "firebrick", "floralwhite", "forestgreen", "fuchsia", "gainsboro", "ghostwhite", "gold", "goldenrod", "gray", "green", "greenyellow", "honeydew", "hotpink", "indianred", "indigo", "ivory", "khaki", "lavender", "lavenderblush", "lawngreen", "lemonchiffon", "lightblue", "lightcoral", "lightcyan", "lightgoldenrodyellow", "lightgreen", "lightgrey", "lightpink", "lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightsteelblue", "lightyellow", "lime", "limegreen", "linen", "magenta", "maroon", "mediumaquamarine", "mediumblue", "mediumorchid", "mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise", "mediumvioletred", "midnightblue", "mintcream", "mistyrose", "moccasin", "navajowhite", "navy", "oldlace", "olive", "olivedrab", "orange", "orangered", "orchid", "palegoldenrod", "palegreen", "paleturquoise", "palevioletred", "papayawhip", "peachpuff", "peru", "pink", "plum", "powderblue", "purple", "red", "rosybrown", "royalblue", "saddlebrown", "salmon", "sandybrown", "seagreen", "seashell", "sienna", "silver", "skyblue", "slateblue", "slategray", "snow", "springgreen", "steelblue", "tan", "teal", "thistle", "tomato", "turquoise", "violet", "wheat", "white", "whitesmoke", "yellow", "yellowgreen");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineLiterals1 = com.google.common.collect.ImmutableSet.of("dashed", "dotted", "double", "groove", "outset", "ridge", "solid");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineLiterals2 = com.google.common.collect.ImmutableSet.of("thick", "thin");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineLiterals3 = com.google.common.collect.ImmutableSet.of("hidden", "inherit", "inset", "invert", "medium", "none");
		com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> mozOutlineFunctions = com.google.common.collect.ImmutableMap.<java.lang.String, java.lang.String>of("rgb(", "rgb()", "rgba(", "rgba()", "hsl(", "hsl()", "hsla(", "hsla()");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineColorLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "invert");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineStyleLiterals0 = com.google.common.collect.ImmutableSet.of("hidden", "inherit", "inset", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> mozOutlineWidthLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "medium");
		com.google.common.collect.ImmutableSet<java.lang.String> oTextOverflowLiterals0 = com.google.common.collect.ImmutableSet.of("clip", "ellipsis");
		com.google.common.collect.ImmutableSet<java.lang.String> azimuthLiterals0 = com.google.common.collect.ImmutableSet.of("behind", "center-left", "center-right", "far-left", "far-right", "left-side", "leftwards", "right-side", "rightwards");
		com.google.common.collect.ImmutableSet<java.lang.String> azimuthLiterals1 = com.google.common.collect.ImmutableSet.of("left", "right");
		com.google.common.collect.ImmutableSet<java.lang.String> azimuthLiterals2 = com.google.common.collect.ImmutableSet.of("center", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundLiterals0 = com.google.common.collect.ImmutableSet.of("border-box", "contain", "content-box", "cover", "padding-box");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundLiterals1 = com.google.common.collect.ImmutableSet.of("no-repeat", "repeat-x", "repeat-y", "round", "space");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundLiterals2 = com.google.common.collect.ImmutableSet.of("bottom", "top");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundLiterals3 = com.google.common.collect.ImmutableSet.of(",", "/", "auto", "center", "fixed", "inherit", "local", "none", "repeat", "scroll", "transparent");
		com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> backgroundFunctions = com.google.common.collect.ImmutableMap.<java.lang.String, java.lang.String>builder().put("image(", "image()").put("linear-gradient(", "linear-gradient()").put("radial-gradient(", "radial-gradient()").put("repeating-linear-gradient(", "repeating-linear-gradient()").put("repeating-radial-gradient(", "repeating-radial-gradient()").put("rgb(", "rgb()").put("rgba(", "rgba()").put("hsl(", "hsl()").put("hsla(", "hsla()").build();
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundAttachmentLiterals0 = com.google.common.collect.ImmutableSet.of(",", "fixed", "local", "scroll");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundColorLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "transparent");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundImageLiterals0 = com.google.common.collect.ImmutableSet.of(",", "none");
		com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> backgroundImageFunctions = com.google.common.collect.ImmutableMap.<java.lang.String, java.lang.String>of("image(", "image()", "linear-gradient(", "linear-gradient()", "radial-gradient(", "radial-gradient()", "repeating-linear-gradient(", "repeating-linear-gradient()", "repeating-radial-gradient(", "repeating-radial-gradient()");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundPositionLiterals0 = com.google.common.collect.ImmutableSet.of(",", "center");
		com.google.common.collect.ImmutableSet<java.lang.String> backgroundRepeatLiterals0 = com.google.common.collect.ImmutableSet.of(",", "repeat");
		com.google.common.collect.ImmutableSet<java.lang.String> borderLiterals0 = com.google.common.collect.ImmutableSet.of("hidden", "inherit", "inset", "medium", "none", "transparent");
		com.google.common.collect.ImmutableSet<java.lang.String> borderCollapseLiterals0 = com.google.common.collect.ImmutableSet.of("collapse", "inherit", "separate");
		com.google.common.collect.ImmutableSet<java.lang.String> bottomLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> boxShadowLiterals0 = com.google.common.collect.ImmutableSet.of(",", "inset", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> clearLiterals0 = com.google.common.collect.ImmutableSet.of("both", "inherit", "none");
		com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> clipFunctions = com.google.common.collect.ImmutableMap.<java.lang.String, java.lang.String>of("rect(", "rect()");
		com.google.common.collect.ImmutableSet<java.lang.String> contentLiterals0 = com.google.common.collect.ImmutableSet.of("none", "normal");
		com.google.common.collect.ImmutableSet<java.lang.String> cueLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> cursorLiterals0 = com.google.common.collect.ImmutableSet.of("all-scroll", "col-resize", "crosshair", "default", "e-resize", "hand", "help", "move", "n-resize", "ne-resize", "no-drop", "not-allowed", "nw-resize", "pointer", "progress", "row-resize", "s-resize", "se-resize", "sw-resize", "text", "vertical-text", "w-resize", "wait");
		com.google.common.collect.ImmutableSet<java.lang.String> cursorLiterals1 = com.google.common.collect.ImmutableSet.of(",", "auto", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> directionLiterals0 = com.google.common.collect.ImmutableSet.of("ltr", "rtl");
		com.google.common.collect.ImmutableSet<java.lang.String> displayLiterals0 = com.google.common.collect.ImmutableSet.of("-moz-inline-box", "-moz-inline-stack", "block", "inline", "inline-block", "inline-table", "list-item", "run-in", "table", "table-caption", "table-cell", "table-column", "table-column-group", "table-footer-group", "table-header-group", "table-row", "table-row-group");
		com.google.common.collect.ImmutableSet<java.lang.String> elevationLiterals0 = com.google.common.collect.ImmutableSet.of("above", "below", "higher", "level", "lower");
		com.google.common.collect.ImmutableSet<java.lang.String> emptyCellsLiterals0 = com.google.common.collect.ImmutableSet.of("hide", "show");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals0 = com.google.common.collect.ImmutableSet.of("100", "200", "300", "400", "500", "600", "700", "800", "900", "bold", "bolder", "lighter");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals1 = com.google.common.collect.ImmutableSet.of("large", "larger", "small", "smaller", "x-large", "x-small", "xx-large", "xx-small");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals2 = com.google.common.collect.ImmutableSet.of("caption", "icon", "menu", "message-box", "small-caption", "status-bar");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals3 = com.google.common.collect.ImmutableSet.of("cursive", "fantasy", "monospace", "sans-serif", "serif");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals4 = com.google.common.collect.ImmutableSet.of("italic", "oblique");
		com.google.common.collect.ImmutableSet<java.lang.String> fontLiterals5 = com.google.common.collect.ImmutableSet.of(",", "/", "inherit", "medium", "normal", "small-caps");
		com.google.common.collect.ImmutableSet<java.lang.String> fontFamilyLiterals0 = com.google.common.collect.ImmutableSet.of(",", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> fontStretchLiterals0 = com.google.common.collect.ImmutableSet.of("condensed", "expanded", "extra-condensed", "extra-expanded", "narrower", "semi-condensed", "semi-expanded", "ultra-condensed", "ultra-expanded", "wider");
		com.google.common.collect.ImmutableSet<java.lang.String> fontStretchLiterals1 = com.google.common.collect.ImmutableSet.of("normal");
		com.google.common.collect.ImmutableSet<java.lang.String> fontStyleLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "normal");
		com.google.common.collect.ImmutableSet<java.lang.String> fontVariantLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "normal", "small-caps");
		com.google.common.collect.ImmutableSet<java.lang.String> listStyleLiterals0 = com.google.common.collect.ImmutableSet.of("armenian", "cjk-decimal", "decimal", "decimal-leading-zero", "disc", "disclosure-closed", "disclosure-open", "ethiopic-numeric", "georgian", "hebrew", "hiragana", "hiragana-iroha", "japanese-formal", "japanese-informal", "katakana", "katakana-iroha", "korean-hangul-formal", "korean-hanja-formal", "korean-hanja-informal", "lower-alpha", "lower-greek", "lower-latin", "lower-roman", "simp-chinese-formal", "simp-chinese-informal", "square", "trad-chinese-formal", "trad-chinese-informal", "upper-alpha", "upper-latin", "upper-roman");
		com.google.common.collect.ImmutableSet<java.lang.String> listStyleLiterals1 = com.google.common.collect.ImmutableSet.of("inside", "outside");
		com.google.common.collect.ImmutableSet<java.lang.String> listStyleLiterals2 = com.google.common.collect.ImmutableSet.of("circle", "inherit", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> maxHeightLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "inherit", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> overflowLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "hidden", "inherit", "scroll", "visible");
		com.google.common.collect.ImmutableSet<java.lang.String> overflowXLiterals0 = com.google.common.collect.ImmutableSet.of("no-content", "no-display");
		com.google.common.collect.ImmutableSet<java.lang.String> overflowXLiterals1 = com.google.common.collect.ImmutableSet.of("auto", "hidden", "scroll", "visible");
		com.google.common.collect.ImmutableSet<java.lang.String> pageBreakAfterLiterals0 = com.google.common.collect.ImmutableSet.of("always", "auto", "avoid", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> pageBreakInsideLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "avoid", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> pitchLiterals0 = com.google.common.collect.ImmutableSet.of("high", "low", "x-high", "x-low");
		com.google.common.collect.ImmutableSet<java.lang.String> playDuringLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "inherit", "mix", "none", "repeat");
		com.google.common.collect.ImmutableSet<java.lang.String> positionLiterals0 = com.google.common.collect.ImmutableSet.of("absolute", "relative", "static");
		com.google.common.collect.ImmutableSet<java.lang.String> speakLiterals0 = com.google.common.collect.ImmutableSet.of("inherit", "none", "normal", "spell-out");
		com.google.common.collect.ImmutableSet<java.lang.String> speakHeaderLiterals0 = com.google.common.collect.ImmutableSet.of("always", "inherit", "once");
		com.google.common.collect.ImmutableSet<java.lang.String> speakNumeralLiterals0 = com.google.common.collect.ImmutableSet.of("continuous", "digits");
		com.google.common.collect.ImmutableSet<java.lang.String> speakPunctuationLiterals0 = com.google.common.collect.ImmutableSet.of("code", "inherit", "none");
		com.google.common.collect.ImmutableSet<java.lang.String> speechRateLiterals0 = com.google.common.collect.ImmutableSet.of("fast", "faster", "slow", "slower", "x-fast", "x-slow");
		com.google.common.collect.ImmutableSet<java.lang.String> tableLayoutLiterals0 = com.google.common.collect.ImmutableSet.of("auto", "fixed", "inherit");
		com.google.common.collect.ImmutableSet<java.lang.String> textAlignLiterals0 = com.google.common.collect.ImmutableSet.of("center", "inherit", "justify");
		com.google.common.collect.ImmutableSet<java.lang.String> textDecorationLiterals0 = com.google.common.collect.ImmutableSet.of("blink", "line-through", "overline", "underline");
		com.google.common.collect.ImmutableSet<java.lang.String> textTransformLiterals0 = com.google.common.collect.ImmutableSet.of("capitalize", "lowercase", "uppercase");
		com.google.common.collect.ImmutableSet<java.lang.String> textWrapLiterals0 = com.google.common.collect.ImmutableSet.of("suppress", "unrestricted");
		com.google.common.collect.ImmutableSet<java.lang.String> unicodeBidiLiterals0 = com.google.common.collect.ImmutableSet.of("bidi-override", "embed");
		com.google.common.collect.ImmutableSet<java.lang.String> verticalAlignLiterals0 = com.google.common.collect.ImmutableSet.of("baseline", "middle", "sub", "super", "text-bottom", "text-top");
		com.google.common.collect.ImmutableSet<java.lang.String> visibilityLiterals0 = com.google.common.collect.ImmutableSet.of("collapse", "hidden", "inherit", "visible");
		com.google.common.collect.ImmutableSet<java.lang.String> voiceFamilyLiterals0 = com.google.common.collect.ImmutableSet.of("child", "female", "male");
		com.google.common.collect.ImmutableSet<java.lang.String> volumeLiterals0 = com.google.common.collect.ImmutableSet.of("loud", "silent", "soft", "x-loud", "x-soft");
		com.google.common.collect.ImmutableSet<java.lang.String> whiteSpaceLiterals0 = com.google.common.collect.ImmutableSet.of("-moz-pre-wrap", "-o-pre-wrap", "-pre-wrap", "nowrap", "pre", "pre-line", "pre-wrap");
		com.google.common.collect.ImmutableSet<java.lang.String> wordWrapLiterals0 = com.google.common.collect.ImmutableSet.of("break-word", "normal");
		com.google.common.collect.ImmutableSet<java.lang.String> rgb$FunLiterals0 = com.google.common.collect.ImmutableSet.of(",");
		com.google.common.collect.ImmutableSet<java.lang.String> linearGradient$FunLiterals0 = com.google.common.collect.ImmutableSet.of(",", "to");
		com.google.common.collect.ImmutableSet<java.lang.String> radialGradient$FunLiterals0 = com.google.common.collect.ImmutableSet.of("at", "closest-corner", "closest-side", "ellipse", "farthest-corner", "farthest-side");
		com.google.common.collect.ImmutableSet<java.lang.String> radialGradient$FunLiterals1 = com.google.common.collect.ImmutableSet.of(",", "center", "circle");
		com.google.common.collect.ImmutableSet<java.lang.String> rect$FunLiterals0 = com.google.common.collect.ImmutableSet.of(",", "auto");
		org.owasp.html.CssSchema.Property mozBorderRadius = new org.owasp.html.CssSchema.Property(5, mozBorderRadiusLiterals0, zeroFns);
		builder.put("-moz-border-radius", mozBorderRadius);
		org.owasp.html.CssSchema.Property mozBorderRadiusBottomleft = new org.owasp.html.CssSchema.Property(5, com.google.common.collect.ImmutableSet.<java.lang.String>of(), zeroFns);
		builder.put("-moz-border-radius-bottomleft", mozBorderRadiusBottomleft);
		org.owasp.html.CssSchema.Property mozOpacity = new org.owasp.html.CssSchema.Property(1, mozOpacityLiterals0, zeroFns);
		builder.put("-moz-opacity", mozOpacity);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property mozOutline = new org.owasp.html.CssSchema.Property(7, union(mozOutlineLiterals0, mozOutlineLiterals1, mozOutlineLiterals2, mozOutlineLiterals3), mozOutlineFunctions);
		builder.put("-moz-outline", mozOutline);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property mozOutlineColor = new org.owasp.html.CssSchema.Property(2, union(mozOutlineColorLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("-moz-outline-color", mozOutlineColor);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property mozOutlineStyle = new org.owasp.html.CssSchema.Property(0, union(mozOutlineLiterals1, mozOutlineStyleLiterals0), zeroFns);
		builder.put("-moz-outline-style", mozOutlineStyle);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property mozOutlineWidth = new org.owasp.html.CssSchema.Property(5, union(mozOutlineLiterals2, mozOutlineWidthLiterals0), zeroFns);
		builder.put("-moz-outline-width", mozOutlineWidth);
		org.owasp.html.CssSchema.Property oTextOverflow = new org.owasp.html.CssSchema.Property(0, oTextOverflowLiterals0, zeroFns);
		builder.put("-o-text-overflow", oTextOverflow);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property azimuth = new org.owasp.html.CssSchema.Property(5, union(azimuthLiterals0, azimuthLiterals1, azimuthLiterals2), zeroFns);
		builder.put("azimuth", azimuth);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property background = new org.owasp.html.CssSchema.Property(23, union(azimuthLiterals1, backgroundLiterals0, backgroundLiterals1, backgroundLiterals2, backgroundLiterals3, mozOutlineLiterals0), backgroundFunctions);
		builder.put("background", background);
		builder.put("background-attachment", new org.owasp.html.CssSchema.Property(0, backgroundAttachmentLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property backgroundColor = new org.owasp.html.CssSchema.Property(258, union(backgroundColorLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("background-color", backgroundColor);
		builder.put("background-image", new org.owasp.html.CssSchema.Property(16, backgroundImageLiterals0, backgroundImageFunctions));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property backgroundPosition = new org.owasp.html.CssSchema.Property(5, union(azimuthLiterals1, backgroundLiterals2, backgroundPositionLiterals0), zeroFns);
		builder.put("background-position", backgroundPosition);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property backgroundRepeat = new org.owasp.html.CssSchema.Property(0, union(backgroundLiterals1, backgroundRepeatLiterals0), zeroFns);
		builder.put("background-repeat", backgroundRepeat);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property border = new org.owasp.html.CssSchema.Property(7, union(borderLiterals0, mozOutlineLiterals0, mozOutlineLiterals1, mozOutlineLiterals2), mozOutlineFunctions);
		builder.put("border", border);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property borderBottomColor = new org.owasp.html.CssSchema.Property(2, union(backgroundColorLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("border-bottom-color", borderBottomColor);
		builder.put("border-collapse", new org.owasp.html.CssSchema.Property(0, borderCollapseLiterals0, zeroFns));
		org.owasp.html.CssSchema.Property borderSpacing = new org.owasp.html.CssSchema.Property(5, mozOpacityLiterals0, zeroFns);
		builder.put("border-spacing", borderSpacing);
		org.owasp.html.CssSchema.Property bottom = new org.owasp.html.CssSchema.Property(5, bottomLiterals0, zeroFns);
		builder.put("bottom", bottom);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property boxShadow = new org.owasp.html.CssSchema.Property(7, union(boxShadowLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("box-shadow", boxShadow);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property captionSide = new org.owasp.html.CssSchema.Property(0, union(backgroundLiterals2, mozOpacityLiterals0), zeroFns);
		builder.put("caption-side", captionSide);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property clear = new org.owasp.html.CssSchema.Property(0, union(azimuthLiterals1, clearLiterals0), zeroFns);
		builder.put("clear", clear);
		builder.put("clip", new org.owasp.html.CssSchema.Property(0, bottomLiterals0, clipFunctions));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property color = new org.owasp.html.CssSchema.Property(258, union(mozOpacityLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("color", color);
		builder.put("content", new org.owasp.html.CssSchema.Property(8, contentLiterals0, zeroFns));
		org.owasp.html.CssSchema.Property cue = new org.owasp.html.CssSchema.Property(16, cueLiterals0, zeroFns);
		builder.put("cue", cue);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property cursor = new org.owasp.html.CssSchema.Property(272, union(cursorLiterals0, cursorLiterals1), zeroFns);
		builder.put("cursor", cursor);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property direction = new org.owasp.html.CssSchema.Property(0, union(directionLiterals0, mozOpacityLiterals0), zeroFns);
		builder.put("direction", direction);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property display = new org.owasp.html.CssSchema.Property(0, union(cueLiterals0, displayLiterals0), zeroFns);
		builder.put("display", display);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property elevation = new org.owasp.html.CssSchema.Property(5, union(elevationLiterals0, mozOpacityLiterals0), zeroFns);
		builder.put("elevation", elevation);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property emptyCells = new org.owasp.html.CssSchema.Property(0, union(emptyCellsLiterals0, mozOpacityLiterals0), zeroFns);
		builder.put("empty-cells", emptyCells);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property cssFloat = new org.owasp.html.CssSchema.Property(0, union(azimuthLiterals1, cueLiterals0), zeroFns);
		builder.put("float", cssFloat);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property font = new org.owasp.html.CssSchema.Property(73, union(fontLiterals0, fontLiterals1, fontLiterals2, fontLiterals3, fontLiterals4, fontLiterals5), zeroFns);
		builder.put("font", font);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property fontFamily = new org.owasp.html.CssSchema.Property(72, union(fontFamilyLiterals0, fontLiterals3), zeroFns);
		builder.put("font-family", fontFamily);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property fontSize = new org.owasp.html.CssSchema.Property(1, union(fontLiterals1, mozOutlineWidthLiterals0), zeroFns);
		builder.put("font-size", fontSize);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property fontStretch = new org.owasp.html.CssSchema.Property(0, union(fontStretchLiterals0, fontStretchLiterals1), zeroFns);
		builder.put("font-stretch", fontStretch);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property fontStyle = new org.owasp.html.CssSchema.Property(0, union(fontLiterals4, fontStyleLiterals0), zeroFns);
		builder.put("font-style", fontStyle);
		builder.put("font-variant", new org.owasp.html.CssSchema.Property(0, fontVariantLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property fontWeight = new org.owasp.html.CssSchema.Property(0, union(fontLiterals0, fontStyleLiterals0), zeroFns);
		builder.put("font-weight", fontWeight);
		org.owasp.html.CssSchema.Property height = new org.owasp.html.CssSchema.Property(5, bottomLiterals0, zeroFns);
		builder.put("height", height);
		org.owasp.html.CssSchema.Property letterSpacing = new org.owasp.html.CssSchema.Property(5, fontStyleLiterals0, zeroFns);
		builder.put("letter-spacing", letterSpacing);
		builder.put("line-height", new org.owasp.html.CssSchema.Property(1, fontStyleLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property listStyle = new org.owasp.html.CssSchema.Property(16, union(listStyleLiterals0, listStyleLiterals1, listStyleLiterals2), backgroundImageFunctions);
		builder.put("list-style", listStyle);
		builder.put("list-style-image", new org.owasp.html.CssSchema.Property(16, cueLiterals0, backgroundImageFunctions));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property listStylePosition = new org.owasp.html.CssSchema.Property(0, union(listStyleLiterals1, mozOpacityLiterals0), zeroFns);
		builder.put("list-style-position", listStylePosition);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property listStyleType = new org.owasp.html.CssSchema.Property(0, union(listStyleLiterals0, listStyleLiterals2), zeroFns);
		builder.put("list-style-type", listStyleType);
		org.owasp.html.CssSchema.Property margin = new org.owasp.html.CssSchema.Property(1, bottomLiterals0, zeroFns);
		builder.put("margin", margin);
		org.owasp.html.CssSchema.Property maxHeight = new org.owasp.html.CssSchema.Property(1, maxHeightLiterals0, zeroFns);
		builder.put("max-height", maxHeight);
		org.owasp.html.CssSchema.Property opacity = new org.owasp.html.CssSchema.Property(1, mozOpacityLiterals0, zeroFns);
		builder.put("opacity", opacity);
		builder.put("overflow", new org.owasp.html.CssSchema.Property(0, overflowLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property overflowX = new org.owasp.html.CssSchema.Property(0, union(overflowXLiterals0, overflowXLiterals1), zeroFns);
		builder.put("overflow-x", overflowX);
		org.owasp.html.CssSchema.Property padding = new org.owasp.html.CssSchema.Property(1, mozOpacityLiterals0, zeroFns);
		builder.put("padding", padding);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property pageBreakAfter = new org.owasp.html.CssSchema.Property(0, union(azimuthLiterals1, pageBreakAfterLiterals0), zeroFns);
		builder.put("page-break-after", pageBreakAfter);
		builder.put("page-break-inside", new org.owasp.html.CssSchema.Property(0, pageBreakInsideLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property pitch = new org.owasp.html.CssSchema.Property(5, union(mozOutlineWidthLiterals0, pitchLiterals0), zeroFns);
		builder.put("pitch", pitch);
		builder.put("play-during", new org.owasp.html.CssSchema.Property(16, playDuringLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property position = new org.owasp.html.CssSchema.Property(0, union(mozOpacityLiterals0, positionLiterals0), zeroFns);
		builder.put("position", position);
		builder.put("quotes", new org.owasp.html.CssSchema.Property(8, cueLiterals0, zeroFns));
		builder.put("speak", new org.owasp.html.CssSchema.Property(0, speakLiterals0, zeroFns));
		builder.put("speak-header", new org.owasp.html.CssSchema.Property(0, speakHeaderLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property speakNumeral = new org.owasp.html.CssSchema.Property(0, union(mozOpacityLiterals0, speakNumeralLiterals0), zeroFns);
		builder.put("speak-numeral", speakNumeral);
		builder.put("speak-punctuation", new org.owasp.html.CssSchema.Property(0, speakPunctuationLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property speechRate = new org.owasp.html.CssSchema.Property(5, union(mozOutlineWidthLiterals0, speechRateLiterals0), zeroFns);
		builder.put("speech-rate", speechRate);
		builder.put("table-layout", new org.owasp.html.CssSchema.Property(0, tableLayoutLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property textAlign = new org.owasp.html.CssSchema.Property(0, union(azimuthLiterals1, textAlignLiterals0), zeroFns);
		builder.put("text-align", textAlign);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property textDecoration = new org.owasp.html.CssSchema.Property(0, union(cueLiterals0, textDecorationLiterals0), zeroFns);
		builder.put("text-decoration", textDecoration);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property textTransform = new org.owasp.html.CssSchema.Property(0, union(cueLiterals0, textTransformLiterals0), zeroFns);
		builder.put("text-transform", textTransform);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property textWrap = new org.owasp.html.CssSchema.Property(0, union(contentLiterals0, textWrapLiterals0), zeroFns);
		builder.put("text-wrap", textWrap);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property unicodeBidi = new org.owasp.html.CssSchema.Property(0, union(fontStyleLiterals0, unicodeBidiLiterals0), zeroFns);
		builder.put("unicode-bidi", unicodeBidi);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property verticalAlign = new org.owasp.html.CssSchema.Property(5, union(backgroundLiterals2, mozOpacityLiterals0, verticalAlignLiterals0), zeroFns);
		builder.put("vertical-align", verticalAlign);
		builder.put("visibility", new org.owasp.html.CssSchema.Property(0, visibilityLiterals0, zeroFns));
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property voiceFamily = new org.owasp.html.CssSchema.Property(8, union(fontFamilyLiterals0, voiceFamilyLiterals0), zeroFns);
		builder.put("voice-family", voiceFamily);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property volume = new org.owasp.html.CssSchema.Property(1, union(mozOutlineWidthLiterals0, volumeLiterals0), zeroFns);
		builder.put("volume", volume);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property whiteSpace = new org.owasp.html.CssSchema.Property(0, union(fontStyleLiterals0, whiteSpaceLiterals0), zeroFns);
		builder.put("white-space", whiteSpace);
		builder.put("word-wrap", new org.owasp.html.CssSchema.Property(0, wordWrapLiterals0, zeroFns));
		builder.put("zoom", new org.owasp.html.CssSchema.Property(1, fontStretchLiterals1, zeroFns));
		org.owasp.html.CssSchema.Property rgb$Fun = new org.owasp.html.CssSchema.Property(1, rgb$FunLiterals0, zeroFns);
		builder.put("rgb()", rgb$Fun);
		builder.put("rgba()", rgb$Fun);
		builder.put("hsl()", rgb$Fun);
		builder.put("hsla()", rgb$Fun);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property image$Fun = new org.owasp.html.CssSchema.Property(18, union(mozOutlineLiterals0, rgb$FunLiterals0), mozOutlineFunctions);
		builder.put("image()", image$Fun);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property linearGradient$Fun = new org.owasp.html.CssSchema.Property(7, union(azimuthLiterals1, backgroundLiterals2, linearGradient$FunLiterals0, mozOutlineLiterals0), mozOutlineFunctions);
		builder.put("linear-gradient()", linearGradient$Fun);
		@java.lang.SuppressWarnings("unchecked")
		org.owasp.html.CssSchema.Property radialGradient$Fun = new org.owasp.html.CssSchema.Property(7, union(azimuthLiterals1, backgroundLiterals2, mozOutlineLiterals0, radialGradient$FunLiterals0, radialGradient$FunLiterals1), mozOutlineFunctions);
		builder.put("radial-gradient()", radialGradient$Fun);
		builder.put("rect()", new org.owasp.html.CssSchema.Property(5, rect$FunLiterals0, zeroFns));
		builder.put("-moz-border-radius-bottomright", mozBorderRadiusBottomleft);
		builder.put("-moz-border-radius-topleft", mozBorderRadiusBottomleft);
		builder.put("-moz-border-radius-topright", mozBorderRadiusBottomleft);
		builder.put("-moz-box-shadow", boxShadow);
		builder.put("-webkit-border-bottom-left-radius", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-bottom-right-radius", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-radius", mozBorderRadius);
		builder.put("-webkit-border-radius-bottom-left", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-radius-bottom-right", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-radius-top-left", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-radius-top-right", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-top-left-radius", mozBorderRadiusBottomleft);
		builder.put("-webkit-border-top-right-radius", mozBorderRadiusBottomleft);
		builder.put("-webkit-box-shadow", boxShadow);
		builder.put("border-bottom", border);
		builder.put("border-bottom-left-radius", mozBorderRadiusBottomleft);
		builder.put("border-bottom-right-radius", mozBorderRadiusBottomleft);
		builder.put("border-bottom-style", mozOutlineStyle);
		builder.put("border-bottom-width", mozOutlineWidth);
		builder.put("border-color", borderBottomColor);
		builder.put("border-left", border);
		builder.put("border-left-color", borderBottomColor);
		builder.put("border-left-style", mozOutlineStyle);
		builder.put("border-left-width", mozOutlineWidth);
		builder.put("border-radius", mozBorderRadius);
		builder.put("border-right", border);
		builder.put("border-right-color", borderBottomColor);
		builder.put("border-right-style", mozOutlineStyle);
		builder.put("border-right-width", mozOutlineWidth);
		builder.put("border-style", mozOutlineStyle);
		builder.put("border-top", border);
		builder.put("border-top-color", borderBottomColor);
		builder.put("border-top-left-radius", mozBorderRadiusBottomleft);
		builder.put("border-top-right-radius", mozBorderRadiusBottomleft);
		builder.put("border-top-style", mozOutlineStyle);
		builder.put("border-top-width", mozOutlineWidth);
		builder.put("border-width", mozOutlineWidth);
		builder.put("cue-after", cue);
		builder.put("cue-before", cue);
		builder.put("left", height);
		builder.put("margin-bottom", margin);
		builder.put("margin-left", margin);
		builder.put("margin-right", margin);
		builder.put("margin-top", margin);
		builder.put("max-width", maxHeight);
		builder.put("min-height", margin);
		builder.put("min-width", margin);
		builder.put("outline", mozOutline);
		builder.put("outline-color", mozOutlineColor);
		builder.put("outline-style", mozOutlineStyle);
		builder.put("outline-width", mozOutlineWidth);
		builder.put("overflow-y", overflowX);
		builder.put("padding-bottom", padding);
		builder.put("padding-left", padding);
		builder.put("padding-right", padding);
		builder.put("padding-top", padding);
		builder.put("page-break-before", pageBreakAfter);
		builder.put("pause", borderSpacing);
		builder.put("pause-after", borderSpacing);
		builder.put("pause-before", borderSpacing);
		builder.put("pitch-range", borderSpacing);
		builder.put("richness", borderSpacing);
		builder.put("right", height);
		builder.put("stress", borderSpacing);
		builder.put("text-indent", borderSpacing);
		builder.put("text-overflow", oTextOverflow);
		builder.put("text-shadow", boxShadow);
		builder.put("top", height);
		builder.put("width", margin);
		builder.put("word-spacing", letterSpacing);
		builder.put("z-index", bottom);
		builder.put("repeating-linear-gradient()", linearGradient$Fun);
		builder.put("repeating-radial-gradient()", radialGradient$Fun);
		DEFINITIONS = builder.build();
	}

	private static <T> com.google.common.collect.ImmutableSet<T> union(@java.lang.SuppressWarnings("unchecked")
	com.google.common.collect.ImmutableSet<T>... subsets) {
		com.google.common.collect.ImmutableSet.Builder<T> all = com.google.common.collect.ImmutableSet.builder();
		for (com.google.common.collect.ImmutableSet<T> subset : subsets) {
			all.addAll(subset);
		}
		return all.build();
	}

	static final com.google.common.collect.ImmutableSet<java.lang.String> DEFAULT_WHITELIST = com.google.common.collect.ImmutableSet.of("-moz-border-radius", "-moz-border-radius-bottomleft", "-moz-border-radius-bottomright", "-moz-border-radius-topleft", "-moz-border-radius-topright", "-moz-box-shadow", "-moz-outline", "-moz-outline-color", "-moz-outline-style", "-moz-outline-width", "-o-text-overflow", "-webkit-border-bottom-left-radius", "-webkit-border-bottom-right-radius", "-webkit-border-radius", "-webkit-border-radius-bottom-left", "-webkit-border-radius-bottom-right", "-webkit-border-radius-top-left", "-webkit-border-radius-top-right", "-webkit-border-top-left-radius", "-webkit-border-top-right-radius", "-webkit-box-shadow", "azimuth", "background", "background-attachment", "background-color", "background-image", "background-position", "background-repeat", "border", "border-bottom", "border-bottom-color", "border-bottom-left-radius", "border-bottom-right-radius", "border-bottom-style", "border-bottom-width", "border-collapse", "border-color", "border-left", "border-left-color", "border-left-style", "border-left-width", "border-radius", "border-right", "border-right-color", "border-right-style", "border-right-width", "border-spacing", "border-style", "border-top", "border-top-color", "border-top-left-radius", "border-top-right-radius", "border-top-style", "border-top-width", "border-width", "box-shadow", "caption-side", "color", "cue", "cue-after", "cue-before", "direction", "elevation", "empty-cells", "font", "font-family", "font-size", "font-stretch", "font-style", "font-variant", "font-weight", "height", "image()", "letter-spacing", "line-height", "linear-gradient()", "list-style", "list-style-image", "list-style-position", "list-style-type", "margin", "margin-bottom", "margin-left", "margin-right", "margin-top", "max-height", "max-width", "min-height", "min-width", "outline", "outline-color", "outline-style", "outline-width", "padding", "padding-bottom", "padding-left", "padding-right", "padding-top", "pause", "pause-after", "pause-before", "pitch", "pitch-range", "quotes", "radial-gradient()", "rect()", "repeating-linear-gradient()", "repeating-radial-gradient()", "rgb()", "rgba()", "hsl()", "hsla()", "richness", "speak", "speak-header", "speak-numeral", "speak-punctuation", "speech-rate", "stress", "table-layout", "text-align", "text-decoration", "text-indent", "text-overflow", "text-shadow", "text-transform", "text-wrap", "unicode-bidi", "vertical-align", "voice-family", "volume", "white-space", "width", "word-spacing", "word-wrap");

	public static final org.owasp.html.CssSchema DEFAULT = org.owasp.html.CssSchema.withProperties(org.owasp.html.CssSchema.DEFAULT_WHITELIST);

	public static void main(java.lang.String... argv) {
		java.util.SortedSet<java.lang.String> keys = com.google.common.collect.Sets.newTreeSet();
		java.util.SortedSet<java.lang.String> literals = com.google.common.collect.Sets.newTreeSet();
		for (java.util.Map.Entry<java.lang.String, org.owasp.html.CssSchema.Property> e : org.owasp.html.CssSchema.DEFINITIONS.entrySet()) {
			keys.add(e.getKey());
			literals.addAll(e.getValue().literals);
		}
		java.lang.System.out.println("# Below two blocks of tokens.\n" + ((((("#\n" + "# First are all property names.\n") + "# Those followed by an asterisk (*) are in the default white-list.\n") + "#\n") + "# Second are the literal tokens recognized in any defined property\n") + "# value.\n"));
		for (java.lang.String key : keys) {
			java.lang.System.out.print(key);
			if (org.owasp.html.CssSchema.DEFAULT_WHITELIST.contains(key)) {
				java.lang.System.out.print("*");
			}
			java.lang.System.out.println();
		}
		java.lang.System.out.println();
		for (java.lang.String literal : literals) {
			java.lang.System.out.println(literal);
		}
	}
}