public class UnitTest {
	private static final java.lang.Class[] X = new java.lang.Class[0];

	private static final java.lang.Class[] Y = new java.lang.Class[]{ int.class };

	static int numTests = 0;

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.lang.annotation.UnitTest.checkScalarTypes(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesOverrideDefaultMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesAcceptDefaultMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkArrayTypes0(javaT.lang.annotation.UnitTest.class.getMethod("emptyArrayTypesMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkArrayTypes1(javaT.lang.annotation.UnitTest.class.getMethod("singleElementArrayTypesMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkArrayTypes2(javaT.lang.annotation.UnitTest.class.getMethod("twoElementArrayTypesMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getMethod("arrayTypesAcceptDefaultMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getMethod("arrayTypesOverrideDefaultMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkMarker(javaT.lang.annotation.UnitTest.class.getMethod("markerMethod", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByte", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShort", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberInt", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLong", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberChar", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloat", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDouble", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBoolean", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberString(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberString", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClass", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnum", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrEmpty", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrOne", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrTwo", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrOvrdDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrAcceptDef", javaT.lang.annotation.UnitTest.X));
		javaT.lang.annotation.UnitTest.checkScalarTypes(javaT.lang.annotation.UnitTest.class.getField("scalarTypesField"));
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getField("scalarTypesAcceptDefaultField"));
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getField("scalarTypesOverrideDefaultField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes0(javaT.lang.annotation.UnitTest.class.getField("emptyArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes1(javaT.lang.annotation.UnitTest.class.getField("singleElementArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes2(javaT.lang.annotation.UnitTest.class.getField("twoElementArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getField("arrayTypesAcceptDefaultField"));
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getField("arrayTypesOverrideDefaultField"));
		javaT.lang.annotation.UnitTest.checkMarker(javaT.lang.annotation.UnitTest.class.getField("markerField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberString(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrEmptyField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOneField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrTwoField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOvrdDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrAcceptDefField"));
		javaT.lang.annotation.UnitTest.checkScalarTypes(javaT.lang.annotation.UnitTest.TestType.class.getField("scalarTypesField"));
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(javaT.lang.annotation.UnitTest.TestType.class.getField("scalarTypesAcceptDefaultField"));
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(javaT.lang.annotation.UnitTest.TestType.class.getField("scalarTypesOverrideDefaultField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes0(javaT.lang.annotation.UnitTest.TestType.class.getField("emptyArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes1(javaT.lang.annotation.UnitTest.TestType.class.getField("singleElementArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypes2(javaT.lang.annotation.UnitTest.TestType.class.getField("twoElementArrayTypesField"));
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(javaT.lang.annotation.UnitTest.TestType.class.getField("arrayTypesAcceptDefaultField"));
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(javaT.lang.annotation.UnitTest.TestType.class.getField("arrayTypesOverrideDefaultField"));
		javaT.lang.annotation.UnitTest.checkMarker(javaT.lang.annotation.UnitTest.TestType.class.getField("marker"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByte"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShort"));
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberInt"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLong"));
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberChar"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloat"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDouble"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBoolean"));
		javaT.lang.annotation.UnitTest.checkSingleMemberString(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberString"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClass"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnum"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumArrEmpty"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumArrOne"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumArrTwo"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumArrOvrdDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberByteArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberShortArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberIntArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberLongArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberCharArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberFloatArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberDoubleArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberBooleanArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberStringArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberClassArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.UnitTest.TestType.class.getField("SingleMemberEnumArrAcceptDef"));
		javaT.lang.annotation.UnitTest.checkScalarTypes(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.Iterator.class }));
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkArrayTypes0(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkArrayTypes1(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkArrayTypes2(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.SortedSet.class }));
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.SortedMap.class }));
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.util.RandomAccess.class }));
		javaT.lang.annotation.UnitTest.checkMarker(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{  }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberString(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum.class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum.class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum[].class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum[].class, java.util.Set.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum[].class, java.util.Map.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum[].class, java.util.List.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ byte[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ short[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ int[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ long[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ char[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ float[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ double[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ boolean[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.String[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Class[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.UnitTest.class.getConstructor(new java.lang.Class[]{ java.lang.Enum[].class, java.util.Collection.class }));
		javaT.lang.annotation.UnitTest.checkScalarTypesParam(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefaultParam(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesOverrideDefaultParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefaultParam(javaT.lang.annotation.UnitTest.class.getMethod("scalarTypesAcceptDefaultParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkArrayTypes0Param(javaT.lang.annotation.UnitTest.class.getMethod("emptyArrayTypesParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkArrayTypes1Param(javaT.lang.annotation.UnitTest.class.getMethod("singleElementArrayTypesParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkArrayTypes2Param(javaT.lang.annotation.UnitTest.class.getMethod("twoElementArrayTypesParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefaultParam(javaT.lang.annotation.UnitTest.class.getMethod("arrayTypesAcceptDefaultParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefaultParam(javaT.lang.annotation.UnitTest.class.getMethod("arrayTypesOverrideDefaultParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkMarkerParam(javaT.lang.annotation.UnitTest.class.getMethod("markerParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmptyParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrEmptyParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOneParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrOneParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwoParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrTwoParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrOvrdDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberByteArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberShortArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberIntArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberLongArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberCharArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberFloatArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberDoubleArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberBooleanArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberStringArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberClassArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDefParam(javaT.lang.annotation.UnitTest.class.getMethod("SingleMemberEnumArrAcceptDefParam", javaT.lang.annotation.UnitTest.Y));
		javaT.lang.annotation.UnitTest.checkScalarTypes(javaT.lang.annotation.scalarTypesClass.class);
		javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(javaT.lang.annotation.scalarTypesOverrideDefaultClass.class);
		javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(javaT.lang.annotation.scalarTypesAcceptDefaultClass.class);
		javaT.lang.annotation.UnitTest.checkArrayTypes0(javaT.lang.annotation.emptyArrayTypesClass.class);
		javaT.lang.annotation.UnitTest.checkArrayTypes1(javaT.lang.annotation.singleElementArrayTypesClass.class);
		javaT.lang.annotation.UnitTest.checkArrayTypes2(javaT.lang.annotation.twoElementArrayTypesClass.class);
		javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(javaT.lang.annotation.arrayTypesOverrideDefaultClass.class);
		javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(javaT.lang.annotation.arrayTypesAcceptDefaultClass.class);
		javaT.lang.annotation.UnitTest.checkMarker(javaT.lang.annotation.markerClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(javaT.lang.annotation.SingleMemberByteClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(javaT.lang.annotation.SingleMemberShortClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(javaT.lang.annotation.SingleMemberIntClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(javaT.lang.annotation.SingleMemberLongClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(javaT.lang.annotation.SingleMemberCharClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(javaT.lang.annotation.SingleMemberFloatClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(javaT.lang.annotation.SingleMemberDoubleClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(javaT.lang.annotation.SingleMemberBooleanClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberString(javaT.lang.annotation.SingleMemberStringClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(javaT.lang.annotation.SingleMemberClassClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(javaT.lang.annotation.SingleMemberEnumClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(javaT.lang.annotation.SingleMemberByteOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(javaT.lang.annotation.SingleMemberShortOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(javaT.lang.annotation.SingleMemberIntOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(javaT.lang.annotation.SingleMemberLongOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(javaT.lang.annotation.SingleMemberCharOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(javaT.lang.annotation.SingleMemberFloatOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.SingleMemberDoubleOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.SingleMemberBooleanOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(javaT.lang.annotation.SingleMemberStringOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(javaT.lang.annotation.SingleMemberClassOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(javaT.lang.annotation.SingleMemberEnumOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(javaT.lang.annotation.SingleMemberByteAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(javaT.lang.annotation.SingleMemberShortAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(javaT.lang.annotation.SingleMemberIntAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(javaT.lang.annotation.SingleMemberLongAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(javaT.lang.annotation.SingleMemberCharAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(javaT.lang.annotation.SingleMemberFloatAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.SingleMemberDoubleAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.SingleMemberBooleanAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(javaT.lang.annotation.SingleMemberStringAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(javaT.lang.annotation.SingleMemberClassAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(javaT.lang.annotation.SingleMemberEnumAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(javaT.lang.annotation.SingleMemberByteArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(javaT.lang.annotation.SingleMemberShortArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(javaT.lang.annotation.SingleMemberIntArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(javaT.lang.annotation.SingleMemberLongArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(javaT.lang.annotation.SingleMemberCharArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(javaT.lang.annotation.SingleMemberFloatArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.SingleMemberDoubleArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.SingleMemberBooleanArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(javaT.lang.annotation.SingleMemberStringArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(javaT.lang.annotation.SingleMemberClassArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(javaT.lang.annotation.SingleMemberEnumArrEmptyClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(javaT.lang.annotation.SingleMemberByteArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(javaT.lang.annotation.SingleMemberShortArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(javaT.lang.annotation.SingleMemberIntArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(javaT.lang.annotation.SingleMemberLongArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(javaT.lang.annotation.SingleMemberCharArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(javaT.lang.annotation.SingleMemberFloatArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(javaT.lang.annotation.SingleMemberDoubleArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(javaT.lang.annotation.SingleMemberBooleanArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(javaT.lang.annotation.SingleMemberStringArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(javaT.lang.annotation.SingleMemberClassArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(javaT.lang.annotation.SingleMemberEnumArrOneClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(javaT.lang.annotation.SingleMemberByteArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(javaT.lang.annotation.SingleMemberShortArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(javaT.lang.annotation.SingleMemberIntArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(javaT.lang.annotation.SingleMemberLongArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(javaT.lang.annotation.SingleMemberCharArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(javaT.lang.annotation.SingleMemberFloatArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(javaT.lang.annotation.SingleMemberDoubleArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(javaT.lang.annotation.SingleMemberBooleanArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(javaT.lang.annotation.SingleMemberStringArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(javaT.lang.annotation.SingleMemberClassArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(javaT.lang.annotation.SingleMemberEnumArrTwoClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.SingleMemberByteArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.SingleMemberShortArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.SingleMemberIntArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.SingleMemberLongArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.SingleMemberCharArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.SingleMemberFloatArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.SingleMemberDoubleArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.SingleMemberBooleanArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.SingleMemberStringArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.SingleMemberClassArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.SingleMemberEnumArrOvrdDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.SingleMemberByteArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.SingleMemberShortArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.SingleMemberIntArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.SingleMemberLongArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.SingleMemberCharArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.SingleMemberFloatArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.SingleMemberDoubleArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.SingleMemberBooleanArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.SingleMemberStringArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.SingleMemberClassArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.SingleMemberEnumArrAcceptDefClass.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.scalarTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("scalarTypesField"), javaT.lang.annotation.ScalarTypes.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.scalarTypesOverrideDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("scalarTypesOverrideDefaultField"), javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.scalarTypesAcceptDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("scalarTypesAcceptDefaultField"), javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.emptyArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("emptyArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.singleElementArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("singleElementArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.twoElementArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("twoElementArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.arrayTypesOverrideDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("arrayTypesOverrideDefaultField"), javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.arrayTypesAcceptDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("arrayTypesAcceptDefaultField"), javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.markerClass.class, javaT.lang.annotation.UnitTest.class.getField("markerField"), javaT.lang.annotation.Marker.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteField"), javaT.lang.annotation.SingleMemberByte.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortField"), javaT.lang.annotation.SingleMemberShort.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntField"), javaT.lang.annotation.SingleMemberInt.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongField"), javaT.lang.annotation.SingleMemberLong.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharField"), javaT.lang.annotation.SingleMemberChar.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatField"), javaT.lang.annotation.SingleMemberFloat.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleField"), javaT.lang.annotation.SingleMemberDouble.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanField"), javaT.lang.annotation.SingleMemberBoolean.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringField"), javaT.lang.annotation.SingleMemberString.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassField"), javaT.lang.annotation.SingleMemberClass.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumField"), javaT.lang.annotation.SingleMemberEnum.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteOvrdDefField"), javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortOvrdDefField"), javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntOvrdDefField"), javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongOvrdDefField"), javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharOvrdDefField"), javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatOvrdDefField"), javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleOvrdDefField"), javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanOvrdDefField"), javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringOvrdDefField"), javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassOvrdDefField"), javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumOvrdDefField"), javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteAcceptDefField"), javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortAcceptDefField"), javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntAcceptDefField"), javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongAcceptDefField"), javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharAcceptDefField"), javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatAcceptDefField"), javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleAcceptDefField"), javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanAcceptDefField"), javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringAcceptDefField"), javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassAcceptDefField"), javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumAcceptDefField"), javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrEmptyField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrEmptyField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrEmptyField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrEmptyField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrEmptyField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrEmptyField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrEmptyField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrEmptyField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrEmptyField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrEmptyField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrEmptyField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOneField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOneField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOneField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOneField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOneField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOneField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOneField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOneField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOneField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOneField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOneField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrTwoField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrTwoField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrTwoField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrTwoField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrTwoField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrTwoField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrTwoField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrTwoField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrTwoField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrTwoField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrTwoField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOvrdDefField"), javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOvrdDefField"), javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOvrdDefField"), javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOvrdDefField"), javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOvrdDefField"), javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOvrdDefField"), javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOvrdDefField"), javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOvrdDefField"), javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOvrdDefField"), javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOvrdDefField"), javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOvrdDefField"), javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberByteArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrAcceptDefField"), javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberShortArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrAcceptDefField"), javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberIntArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrAcceptDefField"), javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberLongArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrAcceptDefField"), javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberCharArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrAcceptDefField"), javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberFloatArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrAcceptDefField"), javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberDoubleArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrAcceptDefField"), javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberBooleanArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrAcceptDefField"), javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberStringArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrAcceptDefField"), javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberClassArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrAcceptDefField"), javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkEquals(javaT.lang.annotation.SingleMemberEnumArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrAcceptDefField"), javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.scalarTypesOverrideDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("scalarTypesAcceptDefaultField"), javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.scalarTypesAcceptDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("scalarTypesOverrideDefaultField"), javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.emptyArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("singleElementArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.singleElementArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("twoElementArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.twoElementArrayTypesClass.class, javaT.lang.annotation.UnitTest.class.getField("singleElementArrayTypesField"), javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.arrayTypesOverrideDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("arrayTypesAcceptDefaultField"), javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.arrayTypesAcceptDefaultClass.class, javaT.lang.annotation.UnitTest.class.getField("arrayTypesOverrideDefaultField"), javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteAcceptDefField"), javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortAcceptDefField"), javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntAcceptDefField"), javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongAcceptDefField"), javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharAcceptDefField"), javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatAcceptDefField"), javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleAcceptDefField"), javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanAcceptDefField"), javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringAcceptDefField"), javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassAcceptDefField"), javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumAcceptDefField"), javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteOvrdDefField"), javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortOvrdDefField"), javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntOvrdDefField"), javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongOvrdDefField"), javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharOvrdDefField"), javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatOvrdDefField"), javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleOvrdDefField"), javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanOvrdDefField"), javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringOvrdDefField"), javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassOvrdDefField"), javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumOvrdDefField"), javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOneField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOneField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOneField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOneField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOneField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOneField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOneField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOneField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOneField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOneField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumArrEmptyClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOneField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrTwoField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrTwoField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrTwoField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrTwoField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrTwoField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrTwoField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrTwoField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrTwoField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrTwoField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrTwoField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumArrOneClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrTwoField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOneField"), javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOneField"), javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOneField"), javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOneField"), javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOneField"), javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOneField"), javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOneField"), javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOneField"), javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOneField"), javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOneField"), javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumArrTwoClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOneField"), javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrAcceptDefField"), javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrAcceptDefField"), javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrAcceptDefField"), javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrAcceptDefField"), javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrAcceptDefField"), javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrAcceptDefField"), javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrAcceptDefField"), javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrAcceptDefField"), javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrAcceptDefField"), javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrAcceptDefField"), javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumArrOvrdDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrAcceptDefField"), javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberByteArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberByteArrOvrdDefField"), javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberShortArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberShortArrOvrdDefField"), javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberIntArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberIntArrOvrdDefField"), javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberLongArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberLongArrOvrdDefField"), javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberCharArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberCharArrOvrdDefField"), javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberFloatArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberFloatArrOvrdDefField"), javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberDoubleArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberDoubleArrOvrdDefField"), javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberBooleanArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberBooleanArrOvrdDefField"), javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberStringArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberStringArrOvrdDefField"), javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberClassArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberClassArrOvrdDefField"), javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkUnequals(javaT.lang.annotation.SingleMemberEnumArrAcceptDefClass.class, javaT.lang.annotation.UnitTest.class.getField("SingleMemberEnumArrOvrdDefField"), javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.scalarTypesClass.class, javaT.lang.annotation.ScalarTypes.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.scalarTypesOverrideDefaultClass.class, javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.scalarTypesAcceptDefaultClass.class, javaT.lang.annotation.ScalarTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.emptyArrayTypesClass.class, javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.singleElementArrayTypesClass.class, javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.twoElementArrayTypesClass.class, javaT.lang.annotation.ArrayTypes.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.arrayTypesOverrideDefaultClass.class, javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.arrayTypesAcceptDefaultClass.class, javaT.lang.annotation.ArrayTypesWithDefault.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.markerClass.class, javaT.lang.annotation.Marker.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteClass.class, javaT.lang.annotation.SingleMemberByte.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortClass.class, javaT.lang.annotation.SingleMemberShort.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntClass.class, javaT.lang.annotation.SingleMemberInt.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongClass.class, javaT.lang.annotation.SingleMemberLong.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharClass.class, javaT.lang.annotation.SingleMemberChar.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatClass.class, javaT.lang.annotation.SingleMemberFloat.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleClass.class, javaT.lang.annotation.SingleMemberDouble.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanClass.class, javaT.lang.annotation.SingleMemberBoolean.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringClass.class, javaT.lang.annotation.SingleMemberString.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassClass.class, javaT.lang.annotation.SingleMemberClass.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumClass.class, javaT.lang.annotation.SingleMemberEnum.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteOvrdDefClass.class, javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortOvrdDefClass.class, javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntOvrdDefClass.class, javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongOvrdDefClass.class, javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharOvrdDefClass.class, javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatOvrdDefClass.class, javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleOvrdDefClass.class, javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanOvrdDefClass.class, javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringOvrdDefClass.class, javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassOvrdDefClass.class, javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumOvrdDefClass.class, javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteAcceptDefClass.class, javaT.lang.annotation.SingleMemberByteWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortAcceptDefClass.class, javaT.lang.annotation.SingleMemberShortWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntAcceptDefClass.class, javaT.lang.annotation.SingleMemberIntWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongAcceptDefClass.class, javaT.lang.annotation.SingleMemberLongWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharAcceptDefClass.class, javaT.lang.annotation.SingleMemberCharWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatAcceptDefClass.class, javaT.lang.annotation.SingleMemberFloatWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleAcceptDefClass.class, javaT.lang.annotation.SingleMemberDoubleWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanAcceptDefClass.class, javaT.lang.annotation.SingleMemberBooleanWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringAcceptDefClass.class, javaT.lang.annotation.SingleMemberStringWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassAcceptDefClass.class, javaT.lang.annotation.SingleMemberClassWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumAcceptDefClass.class, javaT.lang.annotation.SingleMemberEnumWithDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteArrEmptyClass.class, javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortArrEmptyClass.class, javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntArrEmptyClass.class, javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongArrEmptyClass.class, javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharArrEmptyClass.class, javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatArrEmptyClass.class, javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleArrEmptyClass.class, javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanArrEmptyClass.class, javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringArrEmptyClass.class, javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassArrEmptyClass.class, javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumArrEmptyClass.class, javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteArrOneClass.class, javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortArrOneClass.class, javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntArrOneClass.class, javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongArrOneClass.class, javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharArrOneClass.class, javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatArrOneClass.class, javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleArrOneClass.class, javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanArrOneClass.class, javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringArrOneClass.class, javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassArrOneClass.class, javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumArrOneClass.class, javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteArrTwoClass.class, javaT.lang.annotation.SingleMemberByteArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortArrTwoClass.class, javaT.lang.annotation.SingleMemberShortArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntArrTwoClass.class, javaT.lang.annotation.SingleMemberIntArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongArrTwoClass.class, javaT.lang.annotation.SingleMemberLongArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharArrTwoClass.class, javaT.lang.annotation.SingleMemberCharArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatArrTwoClass.class, javaT.lang.annotation.SingleMemberFloatArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleArrTwoClass.class, javaT.lang.annotation.SingleMemberDoubleArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanArrTwoClass.class, javaT.lang.annotation.SingleMemberBooleanArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringArrTwoClass.class, javaT.lang.annotation.SingleMemberStringArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassArrTwoClass.class, javaT.lang.annotation.SingleMemberClassArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumArrTwoClass.class, javaT.lang.annotation.SingleMemberEnumArray.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumArrOvrdDefClass.class, javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberByteArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberByteArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberShortArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberShortArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberIntArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberIntArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberLongArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberLongArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberCharArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberCharArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberFloatArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberFloatArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberDoubleArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberDoubleArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberBooleanArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberBooleanArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberStringArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberStringArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberClassArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberClassArrayDef.class);
		javaT.lang.annotation.UnitTest.checkSerialization(javaT.lang.annotation.SingleMemberEnumArrAcceptDefClass.class, javaT.lang.annotation.SingleMemberEnumArrayDef.class);
		javaT.lang.annotation.UnitTest.checkInheritence(javaT.lang.annotation.Grandpa.class, true, true);
		javaT.lang.annotation.UnitTest.checkInheritence(javaT.lang.annotation.Dad.class, true, false);
		javaT.lang.annotation.UnitTest.checkInheritence(javaT.lang.annotation.Son.class, true, true);
		javaT.lang.annotation.UnitTest.checkDeclaredAnnotations(javaT.lang.annotation.Grandpa.class, true, true);
		javaT.lang.annotation.UnitTest.checkDeclaredAnnotations(javaT.lang.annotation.Dad.class, false, false);
		javaT.lang.annotation.UnitTest.checkDeclaredAnnotations(javaT.lang.annotation.Son.class, false, true);
		java.lang.System.out.println(("\n" + javaT.lang.annotation.UnitTest.numTests) + " tests completed");
		if (javaT.lang.annotation.UnitTest.failCount != 0) {
			throw new java.lang.Exception("Failure count: " + javaT.lang.annotation.UnitTest.failCount);
		} else {
			java.lang.System.out.println("Success.");
		}
	}

	static int failCount = 0;

	private static void fail(java.lang.String test) {
		java.lang.System.out.println("Failure: " + test);
		javaT.lang.annotation.UnitTest.failCount++;
	}

	static void checkScalarTypes(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypes(e.getAnnotation(javaT.lang.annotation.ScalarTypes.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypes " + e) + ": ") + t);
			t.printStackTrace();
		}
	}

	static void checkScalarTypes(javaT.lang.annotation.ScalarTypes st, java.lang.reflect.AnnotatedElement e) throws java.lang.Exception {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((((st.b() == 1) && (st.s() == 2)) && (st.i() == 3)) && (st.l() == 4L)) && (st.c() == '5')) && (st.f() == 6.0F)) && (st.d() == 7.0)) && (st.bool() == true)) && st.str().equals("custom")) && (st.cls() == java.util.Map.class)) && (st.e() == javaT.lang.annotation.Stooge.MOE)) && (st.a().x() == 1)) && (st.a().y() == 2))) {
			javaT.lang.annotation.UnitTest.fail("ScalarTypes" + e);
		}
	}

	static void checkScalarTypesOverrideDefault(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(e.getAnnotation(javaT.lang.annotation.ScalarTypesWithDefault.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypesOverrideDefaults" + e) + ": ") + t);
		}
	}

	static void checkScalarTypesOverrideDefault(javaT.lang.annotation.ScalarTypesWithDefault st, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((st.b() == 1) && (st.s() == 2)) && (st.i() == 3)) && (st.l() == 4L)) && (st.c() == '5')) && (st.f() == 6.0F)) && (st.d() == 7.0)) && (st.bool() == true)) && st.str().equals("custom")) && (st.cls() == java.util.Map.class)) && (st.e() == javaT.lang.annotation.Stooge.MOE))) {
			javaT.lang.annotation.UnitTest.fail("ScalarTypesOverrideDefaults" + e);
		}
	}

	static void checkScalarTypesAcceptDefault(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(e.getAnnotation(javaT.lang.annotation.ScalarTypesWithDefault.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypesAcceptDefaults" + e) + ": ") + t);
		}
	}

	static void checkScalarTypesAcceptDefault(javaT.lang.annotation.ScalarTypesWithDefault st, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((((st.b() == 11) && (st.s() == 12)) && (st.i() == 13)) && (st.l() == 14L)) && (st.c() == 'V')) && (st.f() == 16.0F)) && (st.d() == 17.0)) && (st.bool() == false)) && st.str().equals("default")) && (st.cls() == java.lang.Class.class)) && (st.e() == javaT.lang.annotation.Stooge.LARRY)) && (st.a().x() == 11)) && (st.a().y() == 12))) {
			javaT.lang.annotation.UnitTest.fail("ScalarTypesAcceptDefaults" + e);
		}
	}

	static void checkArrayTypes0(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes0(e.getAnnotation(javaT.lang.annotation.ArrayTypes.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(Empty)" + e) + ": ") + t);
		}
	}

	static void checkArrayTypes0(javaT.lang.annotation.ArrayTypes at, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!((((((((((((at.b().length == 0) && (at.s().length == 0)) && (at.i().length == 0)) && (at.l().length == 0)) && (at.c().length == 0)) && (at.f().length == 0)) && (at.d().length == 0)) && (at.bool().length == 0)) && (at.str().length == 0)) && (at.cls().length == 0)) && (at.e().length == 0)) && (at.a().length == 0))) {
			javaT.lang.annotation.UnitTest.fail("ArrayTypes(Empty)" + e);
		}
	}

	static void checkArrayTypes1(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes1(e.getAnnotation(javaT.lang.annotation.ArrayTypes.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(One element)" + e) + ": ") + t);
		}
	}

	static void checkArrayTypes1(javaT.lang.annotation.ArrayTypes at, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!((((((((((((((((((((((((at.b()[0] == 1) && (at.s()[0] == 2)) && (at.i()[0] == 3)) && (at.l()[0] == 4L)) && (at.c()[0] == '5')) && (at.f()[0] == 6.0F)) && (at.d()[0] == 7.0)) && (at.bool()[0] == true)) && at.str()[0].equals("custom")) && (at.cls()[0] == java.util.Map.class)) && (at.e()[0] == javaT.lang.annotation.Stooge.MOE)) && (at.a()[0].x() == 1)) && (at.a()[0].y() == 2)) && (at.b().length == 1)) && (at.s().length == 1)) && (at.i().length == 1)) && (at.l().length == 1)) && (at.c().length == 1)) && (at.d().length == 1)) && (at.bool().length == 1)) && (at.str().length == 1)) && (at.cls().length == 1)) && (at.cls().length == 1)) && (at.a().length == 1))) {
			javaT.lang.annotation.UnitTest.fail("ArrayTypes(One element)" + e);
		}
	}

	static void checkArrayTypes2(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes2(e.getAnnotation(javaT.lang.annotation.ArrayTypes.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(Two element)" + e) + ": ") + t);
		}
	}

	static void checkArrayTypes2(javaT.lang.annotation.ArrayTypes at, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((((((((((((((((((((((((((((at.b()[0] == 1) && (at.b()[1] == 2)) && (at.s()[0] == 2)) && (at.s()[1] == 3)) && (at.i()[0] == 3)) && (at.i()[1] == 4)) && (at.l()[0] == 4L)) && (at.l()[1] == 5L)) && (at.c()[0] == '5')) && (at.c()[1] == '6')) && (at.f()[0] == 6.0F)) && (at.f()[1] == 7.0F)) && (at.d()[0] == 7.0)) && (at.d()[1] == 8.0)) && (at.bool()[0] == true)) && (at.bool()[1] == false)) && at.str()[0].equals("custom")) && at.str()[1].equals("paint")) && (at.cls()[0] == java.util.Map.class)) && (at.cls()[1] == java.util.Set.class)) && (at.e()[0] == javaT.lang.annotation.Stooge.MOE)) && (at.e()[1] == javaT.lang.annotation.Stooge.CURLY)) && (at.a()[0].x() == 1)) && (at.a()[0].y() == 2)) && (at.a()[1].x() == 3)) && (at.a()[1].y() == 4)) && (at.b().length == 2)) && (at.s().length == 2)) && (at.i().length == 2)) && (at.l().length == 2)) && (at.c().length == 2)) && (at.d().length == 2)) && (at.bool().length == 2)) && (at.str().length == 2)) && (at.cls().length == 2)) && (at.cls().length == 2)) && (at.a().length == 2))) {
			javaT.lang.annotation.UnitTest.fail("ArrayTypes(Two element)" + e);
		}
	}

	static void checkArrayTypesOverrideDefault(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(e.getAnnotation(javaT.lang.annotation.ArrayTypesWithDefault.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypesOverrideDefault" + e) + ": ") + t);
		}
	}

	static void checkArrayTypesOverrideDefault(javaT.lang.annotation.ArrayTypesWithDefault at, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((((((((((((((at.b()[0] == 1) && (at.s()[0] == 2)) && (at.i()[0] == 3)) && (at.l()[0] == 4L)) && (at.c()[0] == '5')) && (at.f()[0] == 6.0F)) && (at.d()[0] == 7.0)) && (at.bool()[0] == true)) && at.str()[0].equals("custom")) && (at.cls()[0] == java.util.Map.class)) && (at.e()[0] == javaT.lang.annotation.Stooge.MOE)) && (at.a()[0].x() == 1)) && (at.a()[0].y() == 2)) && (at.b().length == 1)) && (at.s().length == 1)) && (at.i().length == 1)) && (at.l().length == 1)) && (at.c().length == 1)) && (at.d().length == 1)) && (at.bool().length == 1)) && (at.str().length == 1)) && (at.cls().length == 1)) && (at.cls().length == 1))) {
			javaT.lang.annotation.UnitTest.fail("ArrayTypesOverrideDefault" + e);
		}
	}

	static void checkArrayTypesAcceptDefault(java.lang.reflect.AnnotatedElement e) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(e.getAnnotation(javaT.lang.annotation.ArrayTypesWithDefault.class), e);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypesAcceptDefault" + e) + ": ") + t);
		}
	}

	static void checkArrayTypesAcceptDefault(javaT.lang.annotation.ArrayTypesWithDefault at, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		if (!(((((((((((((((((((((((at.b()[0] == 11) && (at.s()[0] == 12)) && (at.i()[0] == 13)) && (at.l()[0] == 14L)) && (at.c()[0] == 'V')) && (at.f()[0] == 16.0F)) && (at.d()[0] == 17.0)) && (at.bool()[0] == false)) && at.str()[0].equals("default")) && (at.cls()[0] == java.lang.Class.class)) && (at.e()[0] == javaT.lang.annotation.Stooge.LARRY)) && (at.a()[0].x() == 11)) && (at.a()[0].y() == 12)) && (at.b().length == 1)) && (at.s().length == 1)) && (at.i().length == 1)) && (at.l().length == 1)) && (at.c().length == 1)) && (at.d().length == 1)) && (at.bool().length == 1)) && (at.str().length == 1)) && (at.cls().length == 1)) && (at.cls().length == 1))) {
			javaT.lang.annotation.UnitTest.fail("ArrayTypesAcceptDefault" + e);
		}
	}

	static void checkScalarTypesParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypes(((javaT.lang.annotation.ScalarTypes) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypes" + m) + ": ") + t);
		}
	}

	static void checkScalarTypesOverrideDefaultParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypesOverrideDefault(((javaT.lang.annotation.ScalarTypesWithDefault) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypesOverrideDefaults" + m) + ": ") + t);
		}
	}

	static void checkScalarTypesAcceptDefaultParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkScalarTypesAcceptDefault(((javaT.lang.annotation.ScalarTypesWithDefault) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ScalarTypesAcceptDefaults" + m) + ": ") + t);
		}
	}

	static void checkArrayTypes0Param(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes0(((javaT.lang.annotation.ArrayTypes) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(Empty)" + m) + ": ") + t);
		}
	}

	static void checkArrayTypes1Param(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes1(((javaT.lang.annotation.ArrayTypes) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(One Element)" + m) + ": ") + t);
		}
	}

	static void checkArrayTypes2Param(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypes2(((javaT.lang.annotation.ArrayTypes) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypes(Two Elements)" + m) + ": ") + t);
		}
	}

	static void checkArrayTypesOverrideDefaultParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypesOverrideDefault(((javaT.lang.annotation.ArrayTypesWithDefault) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypesOverrideDefault" + m) + ": ") + t);
		}
	}

	static void checkArrayTypesAcceptDefaultParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkArrayTypesAcceptDefault(((javaT.lang.annotation.ArrayTypesWithDefault) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("ArrayTypesAcceptDefault" + m) + ": ") + t);
		}
	}

	static void checkMarkerParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkMarker(((javaT.lang.annotation.Marker) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("Marker" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByte(((javaT.lang.annotation.SingleMemberByte) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByte" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShort(((javaT.lang.annotation.SingleMemberShort) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShort" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberInt(((javaT.lang.annotation.SingleMemberInt) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberInt" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLong(((javaT.lang.annotation.SingleMemberLong) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLong" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberChar(((javaT.lang.annotation.SingleMemberChar) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberChar" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloat(((javaT.lang.annotation.SingleMemberFloat) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloat" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDouble(((javaT.lang.annotation.SingleMemberDouble) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDouble" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(((javaT.lang.annotation.SingleMemberBoolean) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBoolean" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberString(((javaT.lang.annotation.SingleMemberString) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberString" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClass(((javaT.lang.annotation.SingleMemberClass) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClass" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnum(((javaT.lang.annotation.SingleMemberEnum) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnum" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(((javaT.lang.annotation.SingleMemberByteWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(((javaT.lang.annotation.SingleMemberShortWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(((javaT.lang.annotation.SingleMemberIntWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(((javaT.lang.annotation.SingleMemberLongWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(((javaT.lang.annotation.SingleMemberCharWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(((javaT.lang.annotation.SingleMemberFloatWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(((javaT.lang.annotation.SingleMemberDoubleWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(((javaT.lang.annotation.SingleMemberBooleanWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(((javaT.lang.annotation.SingleMemberStringWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(((javaT.lang.annotation.SingleMemberClassWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(((javaT.lang.annotation.SingleMemberEnumWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(((javaT.lang.annotation.SingleMemberByteWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(((javaT.lang.annotation.SingleMemberShortWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(((javaT.lang.annotation.SingleMemberIntWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(((javaT.lang.annotation.SingleMemberLongWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(((javaT.lang.annotation.SingleMemberCharWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(((javaT.lang.annotation.SingleMemberFloatWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(((javaT.lang.annotation.SingleMemberDoubleWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(((javaT.lang.annotation.SingleMemberBooleanWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(((javaT.lang.annotation.SingleMemberStringWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(((javaT.lang.annotation.SingleMemberClassWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(((javaT.lang.annotation.SingleMemberEnumWithDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(((javaT.lang.annotation.SingleMemberByteArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(((javaT.lang.annotation.SingleMemberShortArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(((javaT.lang.annotation.SingleMemberIntArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(((javaT.lang.annotation.SingleMemberLongArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(((javaT.lang.annotation.SingleMemberCharArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(((javaT.lang.annotation.SingleMemberFloatArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(((javaT.lang.annotation.SingleMemberDoubleArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(((javaT.lang.annotation.SingleMemberBooleanArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(((javaT.lang.annotation.SingleMemberStringArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(((javaT.lang.annotation.SingleMemberClassArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrEmptyParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(((javaT.lang.annotation.SingleMemberEnumArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrEmpty" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(((javaT.lang.annotation.SingleMemberByteArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(((javaT.lang.annotation.SingleMemberShortArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(((javaT.lang.annotation.SingleMemberIntArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(((javaT.lang.annotation.SingleMemberLongArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(((javaT.lang.annotation.SingleMemberCharArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(((javaT.lang.annotation.SingleMemberFloatArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(((javaT.lang.annotation.SingleMemberDoubleArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(((javaT.lang.annotation.SingleMemberBooleanArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(((javaT.lang.annotation.SingleMemberStringArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(((javaT.lang.annotation.SingleMemberClassArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrOneParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(((javaT.lang.annotation.SingleMemberEnumArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOne" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(((javaT.lang.annotation.SingleMemberByteArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(((javaT.lang.annotation.SingleMemberShortArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(((javaT.lang.annotation.SingleMemberIntArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(((javaT.lang.annotation.SingleMemberLongArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(((javaT.lang.annotation.SingleMemberCharArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(((javaT.lang.annotation.SingleMemberFloatArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(((javaT.lang.annotation.SingleMemberDoubleArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(((javaT.lang.annotation.SingleMemberBooleanArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(((javaT.lang.annotation.SingleMemberStringArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(((javaT.lang.annotation.SingleMemberClassArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrTwoParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(((javaT.lang.annotation.SingleMemberEnumArray) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrTwo" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(((javaT.lang.annotation.SingleMemberByteArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(((javaT.lang.annotation.SingleMemberShortArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(((javaT.lang.annotation.SingleMemberIntArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(((javaT.lang.annotation.SingleMemberLongArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(((javaT.lang.annotation.SingleMemberCharArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(((javaT.lang.annotation.SingleMemberFloatArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(((javaT.lang.annotation.SingleMemberDoubleArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(((javaT.lang.annotation.SingleMemberBooleanArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(((javaT.lang.annotation.SingleMemberStringArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(((javaT.lang.annotation.SingleMemberClassArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrOvrdDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(((javaT.lang.annotation.SingleMemberEnumArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOvrdDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(((javaT.lang.annotation.SingleMemberByteArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(((javaT.lang.annotation.SingleMemberShortArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(((javaT.lang.annotation.SingleMemberIntArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(((javaT.lang.annotation.SingleMemberLongArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(((javaT.lang.annotation.SingleMemberCharArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(((javaT.lang.annotation.SingleMemberFloatArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(((javaT.lang.annotation.SingleMemberDoubleArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(((javaT.lang.annotation.SingleMemberBooleanArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(((javaT.lang.annotation.SingleMemberStringArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(((javaT.lang.annotation.SingleMemberClassArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrAcceptDefParam(java.lang.reflect.Method m) {
		try {
			javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(((javaT.lang.annotation.SingleMemberEnumArrayDef) (m.getParameterAnnotations()[0][0])), m);
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrAcceptDef" + m) + ": ") + t);
		}
	}

	static void checkMarker(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkMarker(e.getAnnotation(javaT.lang.annotation.Marker.class), e);
	}

	static void checkMarker(javaT.lang.annotation.Marker m, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (m == null) {
				javaT.lang.annotation.UnitTest.fail("Marker " + e);
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("Marker " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByte(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByte(e.getAnnotation(javaT.lang.annotation.SingleMemberByte.class), e);
	}

	static void checkSingleMemberByte(javaT.lang.annotation.SingleMemberByte a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 1) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByte " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByte " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShort(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShort(e.getAnnotation(javaT.lang.annotation.SingleMemberShort.class), e);
	}

	static void checkSingleMemberShort(javaT.lang.annotation.SingleMemberShort a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 2) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShort " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShort " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberInt(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberInt(e.getAnnotation(javaT.lang.annotation.SingleMemberInt.class), e);
	}

	static void checkSingleMemberInt(javaT.lang.annotation.SingleMemberInt a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 3) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberInt " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberInt " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLong(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLong(e.getAnnotation(javaT.lang.annotation.SingleMemberLong.class), e);
	}

	static void checkSingleMemberLong(javaT.lang.annotation.SingleMemberLong a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 4L) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLong " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLong " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberChar(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberChar(e.getAnnotation(javaT.lang.annotation.SingleMemberChar.class), e);
	}

	static void checkSingleMemberChar(javaT.lang.annotation.SingleMemberChar a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != '5') {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberChar " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberChar " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloat(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloat(e.getAnnotation(javaT.lang.annotation.SingleMemberFloat.class), e);
	}

	static void checkSingleMemberFloat(javaT.lang.annotation.SingleMemberFloat a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 6.0F) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloat " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloat " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDouble(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDouble(e.getAnnotation(javaT.lang.annotation.SingleMemberDouble.class), e);
	}

	static void checkSingleMemberDouble(javaT.lang.annotation.SingleMemberDouble a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 7.0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDouble " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDouble " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBoolean(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBoolean(e.getAnnotation(javaT.lang.annotation.SingleMemberBoolean.class), e);
	}

	static void checkSingleMemberBoolean(javaT.lang.annotation.SingleMemberBoolean a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (!a.value()) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBoolean " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBoolean " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberString(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberString(e.getAnnotation(javaT.lang.annotation.SingleMemberString.class), e);
	}

	static void checkSingleMemberString(javaT.lang.annotation.SingleMemberString a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (!a.value().equals("custom")) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberString " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberString " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClass(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClass(e.getAnnotation(javaT.lang.annotation.SingleMemberClass.class), e);
	}

	static void checkSingleMemberClass(javaT.lang.annotation.SingleMemberClass a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != java.util.Map.class) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClass " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClass " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnum(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnum(e.getAnnotation(javaT.lang.annotation.SingleMemberEnum.class), e);
	}

	static void checkSingleMemberEnum(javaT.lang.annotation.SingleMemberEnum a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != javaT.lang.annotation.Stooge.MOE) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnum " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnum " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberByteWithDef.class), e);
	}

	static void checkSingleMemberByteOvrdDef(javaT.lang.annotation.SingleMemberByteWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 1) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberShortWithDef.class), e);
	}

	static void checkSingleMemberShortOvrdDef(javaT.lang.annotation.SingleMemberShortWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 2) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberIntWithDef.class), e);
	}

	static void checkSingleMemberIntOvrdDef(javaT.lang.annotation.SingleMemberIntWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 3) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberLongWithDef.class), e);
	}

	static void checkSingleMemberLongOvrdDef(javaT.lang.annotation.SingleMemberLongWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 4L) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberCharWithDef.class), e);
	}

	static void checkSingleMemberCharOvrdDef(javaT.lang.annotation.SingleMemberCharWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != '5') {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatWithDef.class), e);
	}

	static void checkSingleMemberFloatOvrdDef(javaT.lang.annotation.SingleMemberFloatWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 6.0F) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleWithDef.class), e);
	}

	static void checkSingleMemberDoubleOvrdDef(javaT.lang.annotation.SingleMemberDoubleWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 7.0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanWithDef.class), e);
	}

	static void checkSingleMemberBooleanOvrdDef(javaT.lang.annotation.SingleMemberBooleanWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (!a.value()) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberStringWithDef.class), e);
	}

	static void checkSingleMemberStringOvrdDef(javaT.lang.annotation.SingleMemberStringWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (!a.value().equals("custom")) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberClassWithDef.class), e);
	}

	static void checkSingleMemberClassOvrdDef(javaT.lang.annotation.SingleMemberClassWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != java.util.Map.class) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumWithDef.class), e);
	}

	static void checkSingleMemberEnumOvrdDef(javaT.lang.annotation.SingleMemberEnumWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != javaT.lang.annotation.Stooge.MOE) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberByteWithDef.class), e);
	}

	static void checkSingleMemberByteAcceptDef(javaT.lang.annotation.SingleMemberByteWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 11) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberShortWithDef.class), e);
	}

	static void checkSingleMemberShortAcceptDef(javaT.lang.annotation.SingleMemberShortWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 12) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberIntWithDef.class), e);
	}

	static void checkSingleMemberIntAcceptDef(javaT.lang.annotation.SingleMemberIntWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 13) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberLongWithDef.class), e);
	}

	static void checkSingleMemberLongAcceptDef(javaT.lang.annotation.SingleMemberLongWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 14L) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberCharWithDef.class), e);
	}

	static void checkSingleMemberCharAcceptDef(javaT.lang.annotation.SingleMemberCharWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 'V') {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatWithDef.class), e);
	}

	static void checkSingleMemberFloatAcceptDef(javaT.lang.annotation.SingleMemberFloatWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 16.0F) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleWithDef.class), e);
	}

	static void checkSingleMemberDoubleAcceptDef(javaT.lang.annotation.SingleMemberDoubleWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != 17.0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanWithDef.class), e);
	}

	static void checkSingleMemberBooleanAcceptDef(javaT.lang.annotation.SingleMemberBooleanWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value()) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberStringWithDef.class), e);
	}

	static void checkSingleMemberStringAcceptDef(javaT.lang.annotation.SingleMemberStringWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (!a.value().equals("default")) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberClassWithDef.class), e);
	}

	static void checkSingleMemberClassAcceptDef(javaT.lang.annotation.SingleMemberClassWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != java.lang.Class.class) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumWithDef.class), e);
	}

	static void checkSingleMemberEnumAcceptDef(javaT.lang.annotation.SingleMemberEnumWithDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value() != javaT.lang.annotation.Stooge.LARRY) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberByteArray.class), e);
	}

	static void checkSingleMemberByteArrEmpty(javaT.lang.annotation.SingleMemberByteArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberShortArray.class), e);
	}

	static void checkSingleMemberShortArrEmpty(javaT.lang.annotation.SingleMemberShortArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberIntArray.class), e);
	}

	static void checkSingleMemberIntArrEmpty(javaT.lang.annotation.SingleMemberIntArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberLongArray.class), e);
	}

	static void checkSingleMemberLongArrEmpty(javaT.lang.annotation.SingleMemberLongArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberCharArray.class), e);
	}

	static void checkSingleMemberCharArrEmpty(javaT.lang.annotation.SingleMemberCharArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatArray.class), e);
	}

	static void checkSingleMemberFloatArrEmpty(javaT.lang.annotation.SingleMemberFloatArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleArray.class), e);
	}

	static void checkSingleMemberDoubleArrEmpty(javaT.lang.annotation.SingleMemberDoubleArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanArray.class), e);
	}

	static void checkSingleMemberBooleanArrEmpty(javaT.lang.annotation.SingleMemberBooleanArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberStringArray.class), e);
	}

	static void checkSingleMemberStringArrEmpty(javaT.lang.annotation.SingleMemberStringArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberClassArray.class), e);
	}

	static void checkSingleMemberClassArrEmpty(javaT.lang.annotation.SingleMemberClassArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrEmpty(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrEmpty(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumArray.class), e);
	}

	static void checkSingleMemberEnumArrEmpty(javaT.lang.annotation.SingleMemberEnumArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (a.value().length != 0) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrEmpty " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrEmpty " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberByteArray.class), e);
	}

	static void checkSingleMemberByteArrOne(javaT.lang.annotation.SingleMemberByteArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((byte) (1)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberShortArray.class), e);
	}

	static void checkSingleMemberShortArrOne(javaT.lang.annotation.SingleMemberShortArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((short) (2)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberIntArray.class), e);
	}

	static void checkSingleMemberIntArrOne(javaT.lang.annotation.SingleMemberIntArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 3)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberLongArray.class), e);
	}

	static void checkSingleMemberLongArrOne(javaT.lang.annotation.SingleMemberLongArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 4L)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberCharArray.class), e);
	}

	static void checkSingleMemberCharArrOne(javaT.lang.annotation.SingleMemberCharArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != '5')) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatArray.class), e);
	}

	static void checkSingleMemberFloatArrOne(javaT.lang.annotation.SingleMemberFloatArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 6.0F)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleArray.class), e);
	}

	static void checkSingleMemberDoubleArrOne(javaT.lang.annotation.SingleMemberDoubleArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 7.0)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanArray.class), e);
	}

	static void checkSingleMemberBooleanArrOne(javaT.lang.annotation.SingleMemberBooleanArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (!a.value()[0])) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberStringArray.class), e);
	}

	static void checkSingleMemberStringArrOne(javaT.lang.annotation.SingleMemberStringArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (!a.value()[0].equals("custom"))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberClassArray.class), e);
	}

	static void checkSingleMemberClassArrOne(javaT.lang.annotation.SingleMemberClassArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != java.util.Map.class)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrOne(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOne(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumArray.class), e);
	}

	static void checkSingleMemberEnumArrOne(javaT.lang.annotation.SingleMemberEnumArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != javaT.lang.annotation.Stooge.MOE)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOne " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOne " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberByteArray.class), e);
	}

	static void checkSingleMemberByteArrTwo(javaT.lang.annotation.SingleMemberByteArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != ((byte) (1)))) || (a.value()[1] != ((byte) (2)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberShortArray.class), e);
	}

	static void checkSingleMemberShortArrTwo(javaT.lang.annotation.SingleMemberShortArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != ((short) (2)))) || (a.value()[1] != ((short) (3)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberIntArray.class), e);
	}

	static void checkSingleMemberIntArrTwo(javaT.lang.annotation.SingleMemberIntArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != 3)) || (a.value()[1] != 4)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberLongArray.class), e);
	}

	static void checkSingleMemberLongArrTwo(javaT.lang.annotation.SingleMemberLongArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != 4L)) || (a.value()[1] != 5L)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberCharArray.class), e);
	}

	static void checkSingleMemberCharArrTwo(javaT.lang.annotation.SingleMemberCharArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != '5')) || (a.value()[1] != '6')) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatArray.class), e);
	}

	static void checkSingleMemberFloatArrTwo(javaT.lang.annotation.SingleMemberFloatArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != 6.0F)) || (a.value()[1] != 7.0F)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleArray.class), e);
	}

	static void checkSingleMemberDoubleArrTwo(javaT.lang.annotation.SingleMemberDoubleArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != 7.0)) || (a.value()[1] != 8.0)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanArray.class), e);
	}

	static void checkSingleMemberBooleanArrTwo(javaT.lang.annotation.SingleMemberBooleanArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (!a.value()[0])) || a.value()[1]) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberStringArray.class), e);
	}

	static void checkSingleMemberStringArrTwo(javaT.lang.annotation.SingleMemberStringArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (!a.value()[0].equals("custom"))) || (!a.value()[1].equals("paint"))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberClassArray.class), e);
	}

	static void checkSingleMemberClassArrTwo(javaT.lang.annotation.SingleMemberClassArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != java.util.Map.class)) || (a.value()[1] != java.util.Set.class)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrTwo(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrTwo(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumArray.class), e);
	}

	static void checkSingleMemberEnumArrTwo(javaT.lang.annotation.SingleMemberEnumArray a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if (((a.value().length != 2) || (a.value()[0] != javaT.lang.annotation.Stooge.MOE)) || (a.value()[1] != javaT.lang.annotation.Stooge.CURLY)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrTwo " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrTwo " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberByteArrayDef.class), e);
	}

	static void checkSingleMemberByteArrOvrdDef(javaT.lang.annotation.SingleMemberByteArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((byte) (1)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberShortArrayDef.class), e);
	}

	static void checkSingleMemberShortArrOvrdDef(javaT.lang.annotation.SingleMemberShortArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((short) (2)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberIntArrayDef.class), e);
	}

	static void checkSingleMemberIntArrOvrdDef(javaT.lang.annotation.SingleMemberIntArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 3)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberLongArrayDef.class), e);
	}

	static void checkSingleMemberLongArrOvrdDef(javaT.lang.annotation.SingleMemberLongArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 4L)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberCharArrayDef.class), e);
	}

	static void checkSingleMemberCharArrOvrdDef(javaT.lang.annotation.SingleMemberCharArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != '5')) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatArrayDef.class), e);
	}

	static void checkSingleMemberFloatArrOvrdDef(javaT.lang.annotation.SingleMemberFloatArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 6.0F)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleArrayDef.class), e);
	}

	static void checkSingleMemberDoubleArrOvrdDef(javaT.lang.annotation.SingleMemberDoubleArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 7.0)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanArrayDef.class), e);
	}

	static void checkSingleMemberBooleanArrOvrdDef(javaT.lang.annotation.SingleMemberBooleanArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (!a.value()[0])) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberStringArrayDef.class), e);
	}

	static void checkSingleMemberStringArrOvrdDef(javaT.lang.annotation.SingleMemberStringArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (!a.value()[0].equals("custom"))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberClassArrayDef.class), e);
	}

	static void checkSingleMemberClassArrOvrdDef(javaT.lang.annotation.SingleMemberClassArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != java.util.Map.class)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrOvrdDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrOvrdDef(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumArrayDef.class), e);
	}

	static void checkSingleMemberEnumArrOvrdDef(javaT.lang.annotation.SingleMemberEnumArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != javaT.lang.annotation.Stooge.MOE)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOvrdDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrOvrdDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberByteArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberByteArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberByteArrayDef.class), e);
	}

	static void checkSingleMemberByteArrAcceptDef(javaT.lang.annotation.SingleMemberByteArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((byte) (11)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberByteArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberShortArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberShortArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberShortArrayDef.class), e);
	}

	static void checkSingleMemberShortArrAcceptDef(javaT.lang.annotation.SingleMemberShortArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != ((short) (12)))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberShortArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberIntArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberIntArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberIntArrayDef.class), e);
	}

	static void checkSingleMemberIntArrAcceptDef(javaT.lang.annotation.SingleMemberIntArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 13)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberIntArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberLongArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberLongArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberLongArrayDef.class), e);
	}

	static void checkSingleMemberLongArrAcceptDef(javaT.lang.annotation.SingleMemberLongArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 14L)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberLongArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberCharArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberCharArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberCharArrayDef.class), e);
	}

	static void checkSingleMemberCharArrAcceptDef(javaT.lang.annotation.SingleMemberCharArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 'V')) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberCharArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberFloatArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberFloatArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberFloatArrayDef.class), e);
	}

	static void checkSingleMemberFloatArrAcceptDef(javaT.lang.annotation.SingleMemberFloatArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 16.0F)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberFloatArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberDoubleArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberDoubleArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberDoubleArrayDef.class), e);
	}

	static void checkSingleMemberDoubleArrAcceptDef(javaT.lang.annotation.SingleMemberDoubleArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != 17.0)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberDoubleArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberBooleanArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberBooleanArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberBooleanArrayDef.class), e);
	}

	static void checkSingleMemberBooleanArrAcceptDef(javaT.lang.annotation.SingleMemberBooleanArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || a.value()[0]) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberBooleanArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberStringArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberStringArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberStringArrayDef.class), e);
	}

	static void checkSingleMemberStringArrAcceptDef(javaT.lang.annotation.SingleMemberStringArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (!a.value()[0].equals("default"))) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberStringArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberClassArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberClassArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberClassArrayDef.class), e);
	}

	static void checkSingleMemberClassArrAcceptDef(javaT.lang.annotation.SingleMemberClassArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != java.lang.Class.class)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberClassArrAcceptDef " + e) + ": ") + t);
		}
	}

	static void checkSingleMemberEnumArrAcceptDef(java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.checkSingleMemberEnumArrAcceptDef(e.getAnnotation(javaT.lang.annotation.SingleMemberEnumArrayDef.class), e);
	}

	static void checkSingleMemberEnumArrAcceptDef(javaT.lang.annotation.SingleMemberEnumArrayDef a, java.lang.reflect.AnnotatedElement e) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			if ((a.value().length != 1) || (a.value()[0] != javaT.lang.annotation.Stooge.LARRY)) {
				javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrAcceptDef " + e) + " = ") + a.value());
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("SingleMemberEnumArrAcceptDef " + e) + ": ") + t);
		}
	}

	static <T extends java.lang.annotation.Annotation> void checkEquals(java.lang.reflect.AnnotatedElement e1, java.lang.reflect.AnnotatedElement e2, java.lang.Class<T> annoType) {
		javaT.lang.annotation.UnitTest.numTests++;
		T a1 = e1.getAnnotation(annoType);
		T a2 = e2.getAnnotation(annoType);
		try {
			if (!a1.equals(a2)) {
				javaT.lang.annotation.UnitTest.fail((a1 + " != ") + a2);
			}
			if (a1.hashCode() != a2.hashCode()) {
				javaT.lang.annotation.UnitTest.fail(((((((a1 + ".hashCode() [") + a1.hashCode()) + "] != ") + a2) + " .hashCode()[") + a2.hashCode()) + "]");
			}
			if (!a1.toString().equals(a2.toString())) {
				javaT.lang.annotation.UnitTest.fail(((a1 + ".toString() != ") + a2) + ".toString()");
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((((a1 + " == ") + a2) + ": ") + t);
		}
	}

	static <T extends java.lang.annotation.Annotation> void checkUnequals(java.lang.reflect.AnnotatedElement e1, java.lang.reflect.AnnotatedElement e2, java.lang.Class<T> annoType) {
		javaT.lang.annotation.UnitTest.numTests++;
		T a1 = e1.getAnnotation(annoType);
		T a2 = e2.getAnnotation(annoType);
		try {
			if (a1.equals(a2)) {
				javaT.lang.annotation.UnitTest.fail((a1 + " == ") + a2);
			}
			if (a1.hashCode() == a2.hashCode()) {
				javaT.lang.annotation.UnitTest.fail(((((((a1 + ".hashCode() [") + a1.hashCode()) + "] == ") + a2) + " .hashCode()[") + a2.hashCode()) + "]");
			}
			if (a1.toString().equals(a2.toString())) {
				javaT.lang.annotation.UnitTest.fail(((a1 + ".toString() == ") + a2) + ".toString()");
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((((a1 + " != ") + a2) + ": ") + t);
		}
	}

	static <T extends java.lang.annotation.Annotation> void checkSerialization(java.lang.reflect.AnnotatedElement e, java.lang.Class<T> annoType) {
		javaT.lang.annotation.UnitTest.numTests++;
		T a1 = e.getAnnotation(annoType);
		java.lang.Object a2 = javaT.lang.annotation.UnitTest.deepCopy(a1);
		try {
			if (!a1.equals(a2)) {
				javaT.lang.annotation.UnitTest.fail((("Serialization: " + a1) + " != ") + a2);
			}
			if (a1.hashCode() != a2.hashCode()) {
				javaT.lang.annotation.UnitTest.fail(((((((("Serialization: " + a1) + ".hashCode() [") + a1.hashCode()) + "] != ") + a2) + " .hashCode()[") + a2.hashCode()) + "]");
			}
			if (!a1.toString().equals(a2.toString())) {
				javaT.lang.annotation.UnitTest.fail(((("Serialization: " + a1) + ".toString() != ") + a2) + ".toString()");
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((((("Serialization: " + a1) + " == ") + a2) + ": ") + t);
		}
	}

	private static java.lang.Object deepCopy(java.lang.Object original) {
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);
			oos.writeObject(original);
			oos.flush();
			java.io.ByteArrayInputStream bin = new java.io.ByteArrayInputStream(bos.toByteArray());
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bin);
			return ois.readObject();
		} catch (java.lang.Exception e) {
			throw new java.lang.IllegalArgumentException(e);
		}
	}

	static void checkInheritence(java.lang.reflect.AnnotatedElement e, boolean shouldHaveFoo, boolean shouldHaveBar) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			boolean hasFoo = e.isAnnotationPresent(javaT.lang.annotation.Foo.class);
			boolean hasBar = e.isAnnotationPresent(javaT.lang.annotation.Bar.class);
			if ((hasFoo != shouldHaveFoo) || (hasBar != shouldHaveBar)) {
				javaT.lang.annotation.UnitTest.fail((((("Inheritance(1): " + e) + " - Foo: ") + hasFoo) + ", Bar: ") + hasBar);
			}
			hasFoo = hasBar = false;
			java.lang.annotation.Annotation[] allAnnotations = e.getAnnotations();
			for (java.lang.annotation.Annotation a : allAnnotations) {
				if (a instanceof javaT.lang.annotation.Foo) {
					hasFoo = true;
				} else if (a instanceof javaT.lang.annotation.Bar) {
					hasBar = true;
				}
			}
			if ((hasFoo != shouldHaveFoo) || (hasBar != shouldHaveBar)) {
				javaT.lang.annotation.UnitTest.fail((((("Inheritance(2): " + e) + " - Foo: ") + hasFoo) + ", Bar: ") + hasBar);
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("Inheritance: " + e) + ": ") + t);
		}
	}

	static void checkDeclaredAnnotations(java.lang.reflect.AnnotatedElement e, boolean shouldHaveFoo, boolean shouldHaveBar) {
		javaT.lang.annotation.UnitTest.numTests++;
		try {
			boolean hasFoo = false;
			boolean hasBar = false;
			java.lang.annotation.Annotation[] declaredAnnotations = e.getDeclaredAnnotations();
			for (java.lang.annotation.Annotation a : declaredAnnotations) {
				if (a instanceof javaT.lang.annotation.Foo) {
					hasFoo = true;
				} else if (a instanceof javaT.lang.annotation.Bar) {
					hasBar = true;
				}
			}
			if ((hasFoo != shouldHaveFoo) || (hasBar != shouldHaveBar)) {
				javaT.lang.annotation.UnitTest.fail((((("Declared annotations: " + e) + " - Foo: ") + hasFoo) + ", Bar: ") + hasBar);
			}
		} catch (java.lang.Throwable t) {
			javaT.lang.annotation.UnitTest.fail((("Declared annotations: " + e) + ": ") + t);
		}
	}

	@javaT.lang.annotation.ScalarTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	public void scalarTypesMethod() {
	}

	@javaT.lang.annotation.ScalarTypesWithDefault
	public void scalarTypesAcceptDefaultMethod() {
	}

	@javaT.lang.annotation.ScalarTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE)
	public void scalarTypesOverrideDefaultMethod() {
	}

	@javaT.lang.annotation.ArrayTypes(b = {  }, s = {  }, i = {  }, l = {  }, c = {  }, f = {  }, d = {  }, bool = {  }, str = {  }, cls = {  }, e = {  }, a = {  })
	public void emptyArrayTypesMethod() {
	}

	@javaT.lang.annotation.ArrayTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	public void singleElementArrayTypesMethod() {
	}

	@javaT.lang.annotation.ArrayTypes(b = { 1, 2 }, s = { 2, 3 }, i = { 3, 4 }, l = { 4L, 5L }, c = { '5', '6' }, f = { 6.0F, 7.0F }, d = { 7.0, 8.0 }, bool = { true, false }, str = { "custom", "paint" }, cls = { java.util.Map.class, java.util.Set.class }, e = { javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY }, a = { @javaT.lang.annotation.Point(x = 1, y = 2), @javaT.lang.annotation.Point(x = 3, y = 4) })
	public void twoElementArrayTypesMethod() {
	}

	@javaT.lang.annotation.ArrayTypesWithDefault
	public void arrayTypesAcceptDefaultMethod() {
	}

	@javaT.lang.annotation.ArrayTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	public void arrayTypesOverrideDefaultMethod() {
	}

	@javaT.lang.annotation.Marker
	public void markerMethod() {
	}

	@javaT.lang.annotation.SingleMemberByte(1)
	public void SingleMemberByte() {
	}

	@javaT.lang.annotation.SingleMemberShort(2)
	public void SingleMemberShort() {
	}

	@javaT.lang.annotation.SingleMemberInt(3)
	public void SingleMemberInt() {
	}

	@javaT.lang.annotation.SingleMemberLong(4L)
	public void SingleMemberLong() {
	}

	@javaT.lang.annotation.SingleMemberChar('5')
	public void SingleMemberChar() {
	}

	@javaT.lang.annotation.SingleMemberFloat(6.0F)
	public void SingleMemberFloat() {
	}

	@javaT.lang.annotation.SingleMemberDouble(7.0)
	public void SingleMemberDouble() {
	}

	@javaT.lang.annotation.SingleMemberBoolean(true)
	public void SingleMemberBoolean() {
	}

	@javaT.lang.annotation.SingleMemberString("custom")
	public void SingleMemberString() {
	}

	@javaT.lang.annotation.SingleMemberClass(java.util.Map.class)
	public void SingleMemberClass() {
	}

	@javaT.lang.annotation.SingleMemberEnum(javaT.lang.annotation.Stooge.MOE)
	public void SingleMemberEnum() {
	}

	@javaT.lang.annotation.SingleMemberByteWithDef(1)
	public void SingleMemberByteOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberShortWithDef(2)
	public void SingleMemberShortOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberIntWithDef(3)
	public void SingleMemberIntOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberLongWithDef(4L)
	public void SingleMemberLongOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberCharWithDef('5')
	public void SingleMemberCharOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberFloatWithDef(6.0F)
	public void SingleMemberFloatOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberDoubleWithDef(7.0)
	public void SingleMemberDoubleOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberBooleanWithDef(true)
	public void SingleMemberBooleanOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberStringWithDef("custom")
	public void SingleMemberStringOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberClassWithDef(java.util.Map.class)
	public void SingleMemberClassOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberEnumWithDef(javaT.lang.annotation.Stooge.MOE)
	public void SingleMemberEnumOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberByteWithDef
	public void SingleMemberByteAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberShortWithDef
	public void SingleMemberShortAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberIntWithDef
	public void SingleMemberIntAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberLongWithDef
	public void SingleMemberLongAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberCharWithDef
	public void SingleMemberCharAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberFloatWithDef
	public void SingleMemberFloatAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberDoubleWithDef
	public void SingleMemberDoubleAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberBooleanWithDef
	public void SingleMemberBooleanAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberStringWithDef
	public void SingleMemberStringAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberClassWithDef
	public void SingleMemberClassAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberEnumWithDef
	public void SingleMemberEnumAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberByteArray({  })
	public void SingleMemberByteArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberShortArray({  })
	public void SingleMemberShortArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberIntArray({  })
	public void SingleMemberIntArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberLongArray({  })
	public void SingleMemberLongArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberCharArray({  })
	public void SingleMemberCharArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberFloatArray({  })
	public void SingleMemberFloatArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray({  })
	public void SingleMemberDoubleArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberStringArray({  })
	public void SingleMemberStringArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberClassArray({  })
	public void SingleMemberClassArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberEnumArray({  })
	public void SingleMemberEnumArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberByteArray(1)
	public void SingleMemberByteArrOne() {
	}

	@javaT.lang.annotation.SingleMemberShortArray(2)
	public void SingleMemberShortArrOne() {
	}

	@javaT.lang.annotation.SingleMemberIntArray(3)
	public void SingleMemberIntArrOne() {
	}

	@javaT.lang.annotation.SingleMemberLongArray(4L)
	public void SingleMemberLongArrOne() {
	}

	@javaT.lang.annotation.SingleMemberCharArray('5')
	public void SingleMemberCharArrOne() {
	}

	@javaT.lang.annotation.SingleMemberFloatArray(6.0F)
	public void SingleMemberFloatArrOne() {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray(7.0)
	public void SingleMemberDoubleArrOne() {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray(true)
	public void SingleMemberBooleanArrOne() {
	}

	@javaT.lang.annotation.SingleMemberStringArray("custom")
	public void SingleMemberStringArrOne() {
	}

	@javaT.lang.annotation.SingleMemberClassArray(java.util.Map.class)
	public void SingleMemberClassArrOne() {
	}

	@javaT.lang.annotation.SingleMemberEnumArray(javaT.lang.annotation.Stooge.MOE)
	public void SingleMemberEnumArrOne() {
	}

	@javaT.lang.annotation.SingleMemberByteArray({ 1, 2 })
	public void SingleMemberByteArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberShortArray({ 2, 3 })
	public void SingleMemberShortArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberIntArray({ 3, 4 })
	public void SingleMemberIntArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberLongArray({ 4L, 5L })
	public void SingleMemberLongArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberCharArray({ '5', '6' })
	public void SingleMemberCharArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberFloatArray({ 6.0F, 7.0F })
	public void SingleMemberFloatArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray({ 7.0, 8.0 })
	public void SingleMemberDoubleArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray({ true, false })
	public void SingleMemberBooleanArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberStringArray({ "custom", "paint" })
	public void SingleMemberStringArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberClassArray({ java.util.Map.class, java.util.Set.class })
	public void SingleMemberClassArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberEnumArray({ javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY })
	public void SingleMemberEnumArrTwo() {
	}

	@javaT.lang.annotation.SingleMemberByteArrayDef(1)
	public void SingleMemberByteArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberShortArrayDef(2)
	public void SingleMemberShortArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberIntArrayDef(3)
	public void SingleMemberIntArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberLongArrayDef(4L)
	public void SingleMemberLongArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberCharArrayDef('5')
	public void SingleMemberCharArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberFloatArrayDef(6.0F)
	public void SingleMemberFloatArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberDoubleArrayDef(7.0)
	public void SingleMemberDoubleArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberBooleanArrayDef(true)
	public void SingleMemberBooleanArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberStringArrayDef("custom")
	public void SingleMemberStringArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberClassArrayDef(java.util.Map.class)
	public void SingleMemberClassArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberEnumArrayDef(javaT.lang.annotation.Stooge.MOE)
	public void SingleMemberEnumArrOvrdDef() {
	}

	@javaT.lang.annotation.SingleMemberByteArrayDef
	public void SingleMemberByteArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberShortArrayDef
	public void SingleMemberShortArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberIntArrayDef
	public void SingleMemberIntArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberLongArrayDef
	public void SingleMemberLongArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberCharArrayDef
	public void SingleMemberCharArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberFloatArrayDef
	public void SingleMemberFloatArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberDoubleArrayDef
	public void SingleMemberDoubleArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberBooleanArrayDef
	public void SingleMemberBooleanArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberStringArrayDef
	public void SingleMemberStringArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberClassArrayDef
	public void SingleMemberClassArrAcceptDef() {
	}

	@javaT.lang.annotation.SingleMemberEnumArrayDef
	public void SingleMemberEnumArrAcceptDef() {
	}

	@javaT.lang.annotation.ScalarTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	public int scalarTypesField;

	@javaT.lang.annotation.ScalarTypesWithDefault
	public int scalarTypesAcceptDefaultField;

	@javaT.lang.annotation.ScalarTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE)
	public int scalarTypesOverrideDefaultField;

	@javaT.lang.annotation.ArrayTypes(b = {  }, s = {  }, i = {  }, l = {  }, c = {  }, f = {  }, d = {  }, bool = {  }, str = {  }, cls = {  }, e = {  }, a = {  })
	public int emptyArrayTypesField;

	@javaT.lang.annotation.ArrayTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	public int singleElementArrayTypesField;

	@javaT.lang.annotation.ArrayTypes(b = { 1, 2 }, s = { 2, 3 }, i = { 3, 4 }, l = { 4L, 5L }, c = { '5', '6' }, f = { 6.0F, 7.0F }, d = { 7.0, 8.0 }, bool = { true, false }, str = { "custom", "paint" }, cls = { java.util.Map.class, java.util.Set.class }, e = { javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY }, a = { @javaT.lang.annotation.Point(x = 1, y = 2), @javaT.lang.annotation.Point(x = 3, y = 4) })
	public int twoElementArrayTypesField;

	@javaT.lang.annotation.ArrayTypesWithDefault
	public int arrayTypesAcceptDefaultField;

	@javaT.lang.annotation.ArrayTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	public int arrayTypesOverrideDefaultField;

	@javaT.lang.annotation.Marker
	public int markerField;

	@javaT.lang.annotation.SingleMemberByte(1)
	public int SingleMemberByteField;

	@javaT.lang.annotation.SingleMemberShort(2)
	public int SingleMemberShortField;

	@javaT.lang.annotation.SingleMemberInt(3)
	public int SingleMemberIntField;

	@javaT.lang.annotation.SingleMemberLong(4L)
	public int SingleMemberLongField;

	@javaT.lang.annotation.SingleMemberChar('5')
	public int SingleMemberCharField;

	@javaT.lang.annotation.SingleMemberFloat(6.0F)
	public int SingleMemberFloatField;

	@javaT.lang.annotation.SingleMemberDouble(7.0)
	public int SingleMemberDoubleField;

	@javaT.lang.annotation.SingleMemberBoolean(true)
	public int SingleMemberBooleanField;

	@javaT.lang.annotation.SingleMemberString("custom")
	public int SingleMemberStringField;

	@javaT.lang.annotation.SingleMemberClass(java.util.Map.class)
	public int SingleMemberClassField;

	@javaT.lang.annotation.SingleMemberEnum(javaT.lang.annotation.Stooge.MOE)
	public int SingleMemberEnumField;

	@javaT.lang.annotation.SingleMemberByteWithDef(1)
	public int SingleMemberByteOvrdDefField;

	@javaT.lang.annotation.SingleMemberShortWithDef(2)
	public int SingleMemberShortOvrdDefField;

	@javaT.lang.annotation.SingleMemberIntWithDef(3)
	public int SingleMemberIntOvrdDefField;

	@javaT.lang.annotation.SingleMemberLongWithDef(4L)
	public int SingleMemberLongOvrdDefField;

	@javaT.lang.annotation.SingleMemberCharWithDef('5')
	public int SingleMemberCharOvrdDefField;

	@javaT.lang.annotation.SingleMemberFloatWithDef(6.0F)
	public int SingleMemberFloatOvrdDefField;

	@javaT.lang.annotation.SingleMemberDoubleWithDef(7.0)
	public int SingleMemberDoubleOvrdDefField;

	@javaT.lang.annotation.SingleMemberBooleanWithDef(true)
	public int SingleMemberBooleanOvrdDefField;

	@javaT.lang.annotation.SingleMemberStringWithDef("custom")
	public int SingleMemberStringOvrdDefField;

	@javaT.lang.annotation.SingleMemberClassWithDef(java.util.Map.class)
	public int SingleMemberClassOvrdDefField;

	@javaT.lang.annotation.SingleMemberEnumWithDef(javaT.lang.annotation.Stooge.MOE)
	public int SingleMemberEnumOvrdDefField;

	@javaT.lang.annotation.SingleMemberByteWithDef
	public int SingleMemberByteAcceptDefField;

	@javaT.lang.annotation.SingleMemberShortWithDef
	public int SingleMemberShortAcceptDefField;

	@javaT.lang.annotation.SingleMemberIntWithDef
	public int SingleMemberIntAcceptDefField;

	@javaT.lang.annotation.SingleMemberLongWithDef
	public int SingleMemberLongAcceptDefField;

	@javaT.lang.annotation.SingleMemberCharWithDef
	public int SingleMemberCharAcceptDefField;

	@javaT.lang.annotation.SingleMemberFloatWithDef
	public int SingleMemberFloatAcceptDefField;

	@javaT.lang.annotation.SingleMemberDoubleWithDef
	public int SingleMemberDoubleAcceptDefField;

	@javaT.lang.annotation.SingleMemberBooleanWithDef
	public int SingleMemberBooleanAcceptDefField;

	@javaT.lang.annotation.SingleMemberStringWithDef
	public int SingleMemberStringAcceptDefField;

	@javaT.lang.annotation.SingleMemberClassWithDef
	public int SingleMemberClassAcceptDefField;

	@javaT.lang.annotation.SingleMemberEnumWithDef
	public int SingleMemberEnumAcceptDefField;

	@javaT.lang.annotation.SingleMemberByteArray({  })
	public int SingleMemberByteArrEmptyField;

	@javaT.lang.annotation.SingleMemberShortArray({  })
	public int SingleMemberShortArrEmptyField;

	@javaT.lang.annotation.SingleMemberIntArray({  })
	public int SingleMemberIntArrEmptyField;

	@javaT.lang.annotation.SingleMemberLongArray({  })
	public int SingleMemberLongArrEmptyField;

	@javaT.lang.annotation.SingleMemberCharArray({  })
	public int SingleMemberCharArrEmptyField;

	@javaT.lang.annotation.SingleMemberFloatArray({  })
	public int SingleMemberFloatArrEmptyField;

	@javaT.lang.annotation.SingleMemberDoubleArray({  })
	public int SingleMemberDoubleArrEmptyField;

	@javaT.lang.annotation.SingleMemberStringArray({  })
	public int SingleMemberStringArrEmptyField;

	@javaT.lang.annotation.SingleMemberClassArray({  })
	public int SingleMemberClassArrEmptyField;

	@javaT.lang.annotation.SingleMemberEnumArray({  })
	public int SingleMemberEnumArrEmptyField;

	@javaT.lang.annotation.SingleMemberByteArray(1)
	public int SingleMemberByteArrOneField;

	@javaT.lang.annotation.SingleMemberShortArray(2)
	public int SingleMemberShortArrOneField;

	@javaT.lang.annotation.SingleMemberIntArray(3)
	public int SingleMemberIntArrOneField;

	@javaT.lang.annotation.SingleMemberLongArray(4L)
	public int SingleMemberLongArrOneField;

	@javaT.lang.annotation.SingleMemberCharArray('5')
	public int SingleMemberCharArrOneField;

	@javaT.lang.annotation.SingleMemberFloatArray(6.0F)
	public int SingleMemberFloatArrOneField;

	@javaT.lang.annotation.SingleMemberDoubleArray(7.0)
	public int SingleMemberDoubleArrOneField;

	@javaT.lang.annotation.SingleMemberBooleanArray(true)
	public int SingleMemberBooleanArrOneField;

	@javaT.lang.annotation.SingleMemberStringArray("custom")
	public int SingleMemberStringArrOneField;

	@javaT.lang.annotation.SingleMemberClassArray(java.util.Map.class)
	public int SingleMemberClassArrOneField;

	@javaT.lang.annotation.SingleMemberEnumArray(javaT.lang.annotation.Stooge.MOE)
	public int SingleMemberEnumArrOneField;

	@javaT.lang.annotation.SingleMemberByteArray({ 1, 2 })
	public int SingleMemberByteArrTwoField;

	@javaT.lang.annotation.SingleMemberShortArray({ 2, 3 })
	public int SingleMemberShortArrTwoField;

	@javaT.lang.annotation.SingleMemberIntArray({ 3, 4 })
	public int SingleMemberIntArrTwoField;

	@javaT.lang.annotation.SingleMemberLongArray({ 4L, 5L })
	public int SingleMemberLongArrTwoField;

	@javaT.lang.annotation.SingleMemberCharArray({ '5', '6' })
	public int SingleMemberCharArrTwoField;

	@javaT.lang.annotation.SingleMemberFloatArray({ 6.0F, 7.0F })
	public int SingleMemberFloatArrTwoField;

	@javaT.lang.annotation.SingleMemberDoubleArray({ 7.0, 8.0 })
	public int SingleMemberDoubleArrTwoField;

	@javaT.lang.annotation.SingleMemberBooleanArray({ true, false })
	public int SingleMemberBooleanArrTwoField;

	@javaT.lang.annotation.SingleMemberStringArray({ "custom", "paint" })
	public int SingleMemberStringArrTwoField;

	@javaT.lang.annotation.SingleMemberClassArray({ java.util.Map.class, java.util.Set.class })
	public int SingleMemberClassArrTwoField;

	@javaT.lang.annotation.SingleMemberEnumArray({ javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY })
	public int SingleMemberEnumArrTwoField;

	@javaT.lang.annotation.SingleMemberByteArrayDef(1)
	public int SingleMemberByteArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberShortArrayDef(2)
	public int SingleMemberShortArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberIntArrayDef(3)
	public int SingleMemberIntArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberLongArrayDef(4L)
	public int SingleMemberLongArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberCharArrayDef('5')
	public int SingleMemberCharArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberFloatArrayDef(6.0F)
	public int SingleMemberFloatArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberDoubleArrayDef(7.0)
	public int SingleMemberDoubleArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberBooleanArrayDef(true)
	public int SingleMemberBooleanArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberStringArrayDef("custom")
	public int SingleMemberStringArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberClassArrayDef(java.util.Map.class)
	public int SingleMemberClassArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberEnumArrayDef(javaT.lang.annotation.Stooge.MOE)
	public int SingleMemberEnumArrOvrdDefField;

	@javaT.lang.annotation.SingleMemberByteArrayDef
	public int SingleMemberByteArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberShortArrayDef
	public int SingleMemberShortArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberIntArrayDef
	public int SingleMemberIntArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberLongArrayDef
	public int SingleMemberLongArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberCharArrayDef
	public int SingleMemberCharArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberFloatArrayDef
	public int SingleMemberFloatArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberDoubleArrayDef
	public int SingleMemberDoubleArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberBooleanArrayDef
	public int SingleMemberBooleanArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberStringArrayDef
	public int SingleMemberStringArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberClassArrayDef
	public int SingleMemberClassArrAcceptDefField;

	@javaT.lang.annotation.SingleMemberEnumArrayDef
	public int SingleMemberEnumArrAcceptDefField;

	enum TestType {

		@javaT.lang.annotation.ScalarTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
		scalarTypesField,
		@javaT.lang.annotation.ScalarTypesWithDefault
		scalarTypesAcceptDefaultField,
		@javaT.lang.annotation.ScalarTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE)
		scalarTypesOverrideDefaultField,
		@javaT.lang.annotation.ArrayTypes(b = {  }, s = {  }, i = {  }, l = {  }, c = {  }, f = {  }, d = {  }, bool = {  }, str = {  }, cls = {  }, e = {  }, a = {  })
		emptyArrayTypesField,
		@javaT.lang.annotation.ArrayTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
		singleElementArrayTypesField,
		@javaT.lang.annotation.ArrayTypes(b = { 1, 2 }, s = { 2, 3 }, i = { 3, 4 }, l = { 4L, 5L }, c = { '5', '6' }, f = { 6.0F, 7.0F }, d = { 7.0, 8.0 }, bool = { true, false }, str = { "custom", "paint" }, cls = { java.util.Map.class, java.util.Set.class }, e = { javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY }, a = { @javaT.lang.annotation.Point(x = 1, y = 2), @javaT.lang.annotation.Point(x = 3, y = 4) })
		twoElementArrayTypesField,
		@javaT.lang.annotation.ArrayTypesWithDefault
		arrayTypesAcceptDefaultField,
		@javaT.lang.annotation.ArrayTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
		arrayTypesOverrideDefaultField,
		@javaT.lang.annotation.Marker
		marker,
		@javaT.lang.annotation.SingleMemberByte(1)
		SingleMemberByte,
		@javaT.lang.annotation.SingleMemberShort(2)
		SingleMemberShort,
		@javaT.lang.annotation.SingleMemberInt(3)
		SingleMemberInt,
		@javaT.lang.annotation.SingleMemberLong(4L)
		SingleMemberLong,
		@javaT.lang.annotation.SingleMemberChar('5')
		SingleMemberChar,
		@javaT.lang.annotation.SingleMemberFloat(6.0F)
		SingleMemberFloat,
		@javaT.lang.annotation.SingleMemberDouble(7.0)
		SingleMemberDouble,
		@javaT.lang.annotation.SingleMemberBoolean(true)
		SingleMemberBoolean,
		@javaT.lang.annotation.SingleMemberString("custom")
		SingleMemberString,
		@javaT.lang.annotation.SingleMemberClass(java.util.Map.class)
		SingleMemberClass,
		@javaT.lang.annotation.SingleMemberEnum(javaT.lang.annotation.Stooge.MOE)
		SingleMemberEnum,
		@javaT.lang.annotation.SingleMemberByteWithDef(1)
		SingleMemberByteOvrdDef,
		@javaT.lang.annotation.SingleMemberShortWithDef(2)
		SingleMemberShortOvrdDef,
		@javaT.lang.annotation.SingleMemberIntWithDef(3)
		SingleMemberIntOvrdDef,
		@javaT.lang.annotation.SingleMemberLongWithDef(4L)
		SingleMemberLongOvrdDef,
		@javaT.lang.annotation.SingleMemberCharWithDef('5')
		SingleMemberCharOvrdDef,
		@javaT.lang.annotation.SingleMemberFloatWithDef(6.0F)
		SingleMemberFloatOvrdDef,
		@javaT.lang.annotation.SingleMemberDoubleWithDef(7.0)
		SingleMemberDoubleOvrdDef,
		@javaT.lang.annotation.SingleMemberBooleanWithDef(true)
		SingleMemberBooleanOvrdDef,
		@javaT.lang.annotation.SingleMemberStringWithDef("custom")
		SingleMemberStringOvrdDef,
		@javaT.lang.annotation.SingleMemberClassWithDef(java.util.Map.class)
		SingleMemberClassOvrdDef,
		@javaT.lang.annotation.SingleMemberEnumWithDef(javaT.lang.annotation.Stooge.MOE)
		SingleMemberEnumOvrdDef,
		@javaT.lang.annotation.SingleMemberByteWithDef
		SingleMemberByteAcceptDef,
		@javaT.lang.annotation.SingleMemberShortWithDef
		SingleMemberShortAcceptDef,
		@javaT.lang.annotation.SingleMemberIntWithDef
		SingleMemberIntAcceptDef,
		@javaT.lang.annotation.SingleMemberLongWithDef
		SingleMemberLongAcceptDef,
		@javaT.lang.annotation.SingleMemberCharWithDef
		SingleMemberCharAcceptDef,
		@javaT.lang.annotation.SingleMemberFloatWithDef
		SingleMemberFloatAcceptDef,
		@javaT.lang.annotation.SingleMemberDoubleWithDef
		SingleMemberDoubleAcceptDef,
		@javaT.lang.annotation.SingleMemberBooleanWithDef
		SingleMemberBooleanAcceptDef,
		@javaT.lang.annotation.SingleMemberStringWithDef
		SingleMemberStringAcceptDef,
		@javaT.lang.annotation.SingleMemberClassWithDef
		SingleMemberClassAcceptDef,
		@javaT.lang.annotation.SingleMemberEnumWithDef
		SingleMemberEnumAcceptDef,
		@javaT.lang.annotation.SingleMemberByteArray({  })
		SingleMemberByteArrEmpty,
		@javaT.lang.annotation.SingleMemberShortArray({  })
		SingleMemberShortArrEmpty,
		@javaT.lang.annotation.SingleMemberIntArray({  })
		SingleMemberIntArrEmpty,
		@javaT.lang.annotation.SingleMemberLongArray({  })
		SingleMemberLongArrEmpty,
		@javaT.lang.annotation.SingleMemberCharArray({  })
		SingleMemberCharArrEmpty,
		@javaT.lang.annotation.SingleMemberFloatArray({  })
		SingleMemberFloatArrEmpty,
		@javaT.lang.annotation.SingleMemberDoubleArray({  })
		SingleMemberDoubleArrEmpty,
		@javaT.lang.annotation.SingleMemberBooleanArray({  })
		SingleMemberBooleanArrEmpty,
		@javaT.lang.annotation.SingleMemberStringArray({  })
		SingleMemberStringArrEmpty,
		@javaT.lang.annotation.SingleMemberClassArray({  })
		SingleMemberClassArrEmpty,
		@javaT.lang.annotation.SingleMemberEnumArray({  })
		SingleMemberEnumArrEmpty,
		@javaT.lang.annotation.SingleMemberByteArray(1)
		SingleMemberByteArrOne,
		@javaT.lang.annotation.SingleMemberShortArray(2)
		SingleMemberShortArrOne,
		@javaT.lang.annotation.SingleMemberIntArray(3)
		SingleMemberIntArrOne,
		@javaT.lang.annotation.SingleMemberLongArray(4L)
		SingleMemberLongArrOne,
		@javaT.lang.annotation.SingleMemberCharArray('5')
		SingleMemberCharArrOne,
		@javaT.lang.annotation.SingleMemberFloatArray(6.0F)
		SingleMemberFloatArrOne,
		@javaT.lang.annotation.SingleMemberDoubleArray(7.0)
		SingleMemberDoubleArrOne,
		@javaT.lang.annotation.SingleMemberBooleanArray(true)
		SingleMemberBooleanArrOne,
		@javaT.lang.annotation.SingleMemberStringArray("custom")
		SingleMemberStringArrOne,
		@javaT.lang.annotation.SingleMemberClassArray(java.util.Map.class)
		SingleMemberClassArrOne,
		@javaT.lang.annotation.SingleMemberEnumArray(javaT.lang.annotation.Stooge.MOE)
		SingleMemberEnumArrOne,
		@javaT.lang.annotation.SingleMemberByteArray({ 1, 2 })
		SingleMemberByteArrTwo,
		@javaT.lang.annotation.SingleMemberShortArray({ 2, 3 })
		SingleMemberShortArrTwo,
		@javaT.lang.annotation.SingleMemberIntArray({ 3, 4 })
		SingleMemberIntArrTwo,
		@javaT.lang.annotation.SingleMemberLongArray({ 4L, 5L })
		SingleMemberLongArrTwo,
		@javaT.lang.annotation.SingleMemberCharArray({ '5', '6' })
		SingleMemberCharArrTwo,
		@javaT.lang.annotation.SingleMemberFloatArray({ 6.0F, 7.0F })
		SingleMemberFloatArrTwo,
		@javaT.lang.annotation.SingleMemberDoubleArray({ 7.0, 8.0 })
		SingleMemberDoubleArrTwo,
		@javaT.lang.annotation.SingleMemberBooleanArray({ true, false })
		SingleMemberBooleanArrTwo,
		@javaT.lang.annotation.SingleMemberStringArray({ "custom", "paint" })
		SingleMemberStringArrTwo,
		@javaT.lang.annotation.SingleMemberClassArray({ java.util.Map.class, java.util.Set.class })
		SingleMemberClassArrTwo,
		@javaT.lang.annotation.SingleMemberEnumArray({ javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY })
		SingleMemberEnumArrTwo,
		@javaT.lang.annotation.SingleMemberByteArrayDef(1)
		SingleMemberByteArrOvrdDef,
		@javaT.lang.annotation.SingleMemberShortArrayDef(2)
		SingleMemberShortArrOvrdDef,
		@javaT.lang.annotation.SingleMemberIntArrayDef(3)
		SingleMemberIntArrOvrdDef,
		@javaT.lang.annotation.SingleMemberLongArrayDef(4L)
		SingleMemberLongArrOvrdDef,
		@javaT.lang.annotation.SingleMemberCharArrayDef('5')
		SingleMemberCharArrOvrdDef,
		@javaT.lang.annotation.SingleMemberFloatArrayDef(6.0F)
		SingleMemberFloatArrOvrdDef,
		@javaT.lang.annotation.SingleMemberDoubleArrayDef(7.0)
		SingleMemberDoubleArrOvrdDef,
		@javaT.lang.annotation.SingleMemberBooleanArrayDef(true)
		SingleMemberBooleanArrOvrdDef,
		@javaT.lang.annotation.SingleMemberStringArrayDef("custom")
		SingleMemberStringArrOvrdDef,
		@javaT.lang.annotation.SingleMemberClassArrayDef(java.util.Map.class)
		SingleMemberClassArrOvrdDef,
		@javaT.lang.annotation.SingleMemberEnumArrayDef(javaT.lang.annotation.Stooge.MOE)
		SingleMemberEnumArrOvrdDef,
		@javaT.lang.annotation.SingleMemberByteArrayDef
		SingleMemberByteArrAcceptDef,
		@javaT.lang.annotation.SingleMemberShortArrayDef
		SingleMemberShortArrAcceptDef,
		@javaT.lang.annotation.SingleMemberIntArrayDef
		SingleMemberIntArrAcceptDef,
		@javaT.lang.annotation.SingleMemberLongArrayDef
		SingleMemberLongArrAcceptDef,
		@javaT.lang.annotation.SingleMemberCharArrayDef
		SingleMemberCharArrAcceptDef,
		@javaT.lang.annotation.SingleMemberFloatArrayDef
		SingleMemberFloatArrAcceptDef,
		@javaT.lang.annotation.SingleMemberDoubleArrayDef
		SingleMemberDoubleArrAcceptDef,
		@javaT.lang.annotation.SingleMemberBooleanArrayDef
		SingleMemberBooleanArrAcceptDef,
		@javaT.lang.annotation.SingleMemberStringArrayDef
		SingleMemberStringArrAcceptDef,
		@javaT.lang.annotation.SingleMemberClassArrayDef
		SingleMemberClassArrAcceptDef,
		@javaT.lang.annotation.SingleMemberEnumArrayDef
		SingleMemberEnumArrAcceptDef;}

	@javaT.lang.annotation.ScalarTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	public UnitTest(java.util.Iterator it) {
	}

	@javaT.lang.annotation.ScalarTypesWithDefault
	public UnitTest(java.util.Set s) {
	}

	@javaT.lang.annotation.ScalarTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE)
	public UnitTest(java.util.Map s) {
	}

	@javaT.lang.annotation.ArrayTypes(b = {  }, s = {  }, i = {  }, l = {  }, c = {  }, f = {  }, d = {  }, bool = {  }, str = {  }, cls = {  }, e = {  }, a = {  })
	public UnitTest(java.util.List l) {
	}

	@javaT.lang.annotation.ArrayTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	public UnitTest(java.util.Collection c) {
	}

	@javaT.lang.annotation.ArrayTypes(b = { 1, 2 }, s = { 2, 3 }, i = { 3, 4 }, l = { 4L, 5L }, c = { '5', '6' }, f = { 6.0F, 7.0F }, d = { 7.0, 8.0 }, bool = { true, false }, str = { "custom", "paint" }, cls = { java.util.Map.class, java.util.Set.class }, e = { javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY }, a = { @javaT.lang.annotation.Point(x = 1, y = 2), @javaT.lang.annotation.Point(x = 3, y = 4) })
	public UnitTest(java.util.SortedSet ss) {
	}

	@javaT.lang.annotation.ArrayTypesWithDefault
	public UnitTest(java.util.SortedMap sm) {
	}

	@javaT.lang.annotation.ArrayTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	public UnitTest(java.util.RandomAccess r) {
	}

	@javaT.lang.annotation.Marker
	public UnitTest() {
	}

	@javaT.lang.annotation.SingleMemberByte(1)
	public UnitTest(byte b) {
	}

	@javaT.lang.annotation.SingleMemberShort(2)
	public UnitTest(short s) {
	}

	@javaT.lang.annotation.SingleMemberInt(3)
	public UnitTest(int i) {
	}

	@javaT.lang.annotation.SingleMemberLong(4L)
	public UnitTest(long l) {
	}

	@javaT.lang.annotation.SingleMemberChar('5')
	public UnitTest(char c) {
	}

	@javaT.lang.annotation.SingleMemberFloat(6.0F)
	public UnitTest(float f) {
	}

	@javaT.lang.annotation.SingleMemberDouble(7.0)
	public UnitTest(double d) {
	}

	@javaT.lang.annotation.SingleMemberBoolean(true)
	public UnitTest(boolean b) {
	}

	@javaT.lang.annotation.SingleMemberString("custom")
	public UnitTest(java.lang.String s) {
	}

	@javaT.lang.annotation.SingleMemberClass(java.util.Map.class)
	public UnitTest(java.lang.Class c) {
	}

	@javaT.lang.annotation.SingleMemberEnum(javaT.lang.annotation.Stooge.MOE)
	public UnitTest(java.lang.Enum e) {
	}

	@javaT.lang.annotation.SingleMemberByteWithDef(1)
	public UnitTest(byte b, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberShortWithDef(2)
	public UnitTest(short s, java.util.Set x) {
	}

	@javaT.lang.annotation.SingleMemberIntWithDef(3)
	public UnitTest(int i, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberLongWithDef(4L)
	public UnitTest(long l, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberCharWithDef('5')
	public UnitTest(char c, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberFloatWithDef(6.0F)
	public UnitTest(float f, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberDoubleWithDef(7.0)
	public UnitTest(double d, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberBooleanWithDef(true)
	public UnitTest(boolean b, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberStringWithDef("custom")
	public UnitTest(java.lang.String s, java.util.Set x) {
	}

	@javaT.lang.annotation.SingleMemberClassWithDef(java.util.Map.class)
	public UnitTest(java.lang.Class c, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberEnumWithDef(javaT.lang.annotation.Stooge.MOE)
	public UnitTest(java.lang.Enum e, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberByteWithDef
	public UnitTest(byte b, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberShortWithDef
	public UnitTest(short s, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberIntWithDef
	public UnitTest(int i, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberLongWithDef
	public UnitTest(long l, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberCharWithDef
	public UnitTest(char c, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberFloatWithDef
	public UnitTest(float f, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberDoubleWithDef
	public UnitTest(double d, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberBooleanWithDef
	public UnitTest(boolean b, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberStringWithDef
	public UnitTest(java.lang.String s, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberClassWithDef
	public UnitTest(java.lang.Class c, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberEnumWithDef
	public UnitTest(java.lang.Enum e, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberByteArray({  })
	public UnitTest(byte[] b) {
	}

	@javaT.lang.annotation.SingleMemberShortArray({  })
	public UnitTest(short[] s) {
	}

	@javaT.lang.annotation.SingleMemberIntArray({  })
	public UnitTest(int[] i) {
	}

	@javaT.lang.annotation.SingleMemberLongArray({  })
	public UnitTest(long[] l) {
	}

	@javaT.lang.annotation.SingleMemberCharArray({  })
	public UnitTest(char[] c) {
	}

	@javaT.lang.annotation.SingleMemberFloatArray({  })
	public UnitTest(float[] f) {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray({  })
	public UnitTest(double[] d) {
	}

	@javaT.lang.annotation.SingleMemberStringArray({  })
	public UnitTest(java.lang.String[] s) {
	}

	@javaT.lang.annotation.SingleMemberClassArray({  })
	public UnitTest(java.lang.Class[] c) {
	}

	@javaT.lang.annotation.SingleMemberEnumArray({  })
	public UnitTest(java.lang.Enum[] e) {
	}

	@javaT.lang.annotation.SingleMemberByteArray(1)
	public UnitTest(byte[] b, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberShortArray(2)
	public UnitTest(short[] s, java.util.Set x) {
	}

	@javaT.lang.annotation.SingleMemberIntArray(3)
	public UnitTest(int[] i, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberLongArray(4L)
	public UnitTest(long[] l, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberCharArray('5')
	public UnitTest(char[] c, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberFloatArray(6.0F)
	public UnitTest(float[] f, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray(7.0)
	public UnitTest(double[] d, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray(true)
	public UnitTest(boolean[] b, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberStringArray("custom")
	public UnitTest(java.lang.String[] s, java.util.Set x) {
	}

	@javaT.lang.annotation.SingleMemberClassArray(java.util.Map.class)
	public UnitTest(java.lang.Class[] c, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberEnumArray(javaT.lang.annotation.Stooge.MOE)
	public UnitTest(java.lang.Enum[] e, java.util.Set s) {
	}

	@javaT.lang.annotation.SingleMemberByteArray({ 1, 2 })
	public UnitTest(byte[] b, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberShortArray({ 2, 3 })
	public UnitTest(short[] s, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberIntArray({ 3, 4 })
	public UnitTest(int[] i, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberLongArray({ 4L, 5L })
	public UnitTest(long[] l, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberCharArray({ '5', '6' })
	public UnitTest(char[] c, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberFloatArray({ 6.0F, 7.0F })
	public UnitTest(float[] f, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberDoubleArray({ 7.0, 8.0 })
	public UnitTest(double[] d, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray({ true, false })
	public UnitTest(boolean[] b, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberStringArray({ "custom", "paint" })
	public UnitTest(java.lang.String[] s, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberClassArray({ java.util.Map.class, java.util.Set.class })
	public UnitTest(java.lang.Class[] c, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberEnumArray({ javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY })
	public UnitTest(java.lang.Enum[] e, java.util.Map m) {
	}

	@javaT.lang.annotation.SingleMemberByteArrayDef(1)
	public UnitTest(byte[] b, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberShortArrayDef(2)
	public UnitTest(short[] s, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberIntArrayDef(3)
	public UnitTest(int[] i, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberLongArrayDef(4L)
	public UnitTest(long[] l, java.util.List x) {
	}

	@javaT.lang.annotation.SingleMemberCharArrayDef('5')
	public UnitTest(char[] c, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberFloatArrayDef(6.0F)
	public UnitTest(float[] f, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberDoubleArrayDef(7.0)
	public UnitTest(double[] d, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberBooleanArrayDef(true)
	public UnitTest(boolean[] b, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberStringArrayDef("custom")
	public UnitTest(java.lang.String[] s, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberClassArrayDef(java.util.Map.class)
	public UnitTest(java.lang.Class[] c, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberEnumArrayDef(javaT.lang.annotation.Stooge.MOE)
	public UnitTest(java.lang.Enum[] e, java.util.List l) {
	}

	@javaT.lang.annotation.SingleMemberByteArrayDef
	public UnitTest(byte[] b, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberShortArrayDef
	public UnitTest(short[] s, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberIntArrayDef
	public UnitTest(int[] i, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberLongArrayDef
	public UnitTest(long[] l, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberCharArrayDef
	public UnitTest(char[] c, java.util.Collection x) {
	}

	@javaT.lang.annotation.SingleMemberFloatArrayDef
	public UnitTest(float[] f, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberDoubleArrayDef
	public UnitTest(double[] d, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberBooleanArrayDef
	public UnitTest(boolean[] b, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberStringArrayDef
	public UnitTest(java.lang.String[] s, java.util.Collection c) {
	}

	@javaT.lang.annotation.SingleMemberClassArrayDef
	public UnitTest(java.lang.Class[] c, java.util.Collection x) {
	}

	@javaT.lang.annotation.SingleMemberEnumArrayDef
	public UnitTest(java.lang.Enum[] e, java.util.Collection c) {
	}

	public void scalarTypesParam(@javaT.lang.annotation.ScalarTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	int x) {
	}

	public void scalarTypesAcceptDefaultParam(@javaT.lang.annotation.ScalarTypesWithDefault
	int x) {
	}

	public void scalarTypesOverrideDefaultParam(@javaT.lang.annotation.ScalarTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE)
	int x) {
	}

	public void emptyArrayTypesParam(@javaT.lang.annotation.ArrayTypes(b = {  }, s = {  }, i = {  }, l = {  }, c = {  }, f = {  }, d = {  }, bool = {  }, str = {  }, cls = {  }, e = {  }, a = {  })
	int x) {
	}

	public void singleElementArrayTypesParam(@javaT.lang.annotation.ArrayTypes(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = @javaT.lang.annotation.Point(x = 1, y = 2))
	int x) {
	}

	public void twoElementArrayTypesParam(@javaT.lang.annotation.ArrayTypes(b = { 1, 2 }, s = { 2, 3 }, i = { 3, 4 }, l = { 4L, 5L }, c = { '5', '6' }, f = { 6.0F, 7.0F }, d = { 7.0, 8.0 }, bool = { true, false }, str = { "custom", "paint" }, cls = { java.util.Map.class, java.util.Set.class }, e = { javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY }, a = { @javaT.lang.annotation.Point(x = 1, y = 2), @javaT.lang.annotation.Point(x = 3, y = 4) })
	int x) {
	}

	public void arrayTypesAcceptDefaultParam(@javaT.lang.annotation.ArrayTypesWithDefault
	int x) {
	}

	public void arrayTypesOverrideDefaultParam(@javaT.lang.annotation.ArrayTypesWithDefault(b = 1, s = 2, i = 3, l = 4L, c = '5', f = 6.0F, d = 7.0, bool = true, str = "custom", cls = java.util.Map.class, e = javaT.lang.annotation.Stooge.MOE, a = { @javaT.lang.annotation.Point(x = 1, y = 2) })
	int x) {
	}

	public void markerParam(@javaT.lang.annotation.Marker
	int x) {
	}

	public void SingleMemberByteParam(@javaT.lang.annotation.SingleMemberByte(1)
	int x) {
	}

	public void SingleMemberShortParam(@javaT.lang.annotation.SingleMemberShort(2)
	int x) {
	}

	public void SingleMemberIntParam(@javaT.lang.annotation.SingleMemberInt(3)
	int x) {
	}

	public void SingleMemberLongParam(@javaT.lang.annotation.SingleMemberLong(4L)
	int x) {
	}

	public void SingleMemberCharParam(@javaT.lang.annotation.SingleMemberChar('5')
	int x) {
	}

	public void SingleMemberFloatParam(@javaT.lang.annotation.SingleMemberFloat(6.0F)
	int x) {
	}

	public void SingleMemberDoubleParam(@javaT.lang.annotation.SingleMemberDouble(7.0)
	int x) {
	}

	public void SingleMemberBooleanParam(@javaT.lang.annotation.SingleMemberBoolean(true)
	int x) {
	}

	public void SingleMemberStringParam(@javaT.lang.annotation.SingleMemberString("custom")
	int x) {
	}

	public void SingleMemberClassParam(@javaT.lang.annotation.SingleMemberClass(java.util.Map.class)
	int x) {
	}

	public void SingleMemberEnumParam(@javaT.lang.annotation.SingleMemberEnum(javaT.lang.annotation.Stooge.MOE)
	int x) {
	}

	public void SingleMemberByteOvrdDefParam(@javaT.lang.annotation.SingleMemberByteWithDef(1)
	int x) {
	}

	public void SingleMemberShortOvrdDefParam(@javaT.lang.annotation.SingleMemberShortWithDef(2)
	int x) {
	}

	public void SingleMemberIntOvrdDefParam(@javaT.lang.annotation.SingleMemberIntWithDef(3)
	int x) {
	}

	public void SingleMemberLongOvrdDefParam(@javaT.lang.annotation.SingleMemberLongWithDef(4L)
	int x) {
	}

	public void SingleMemberCharOvrdDefParam(@javaT.lang.annotation.SingleMemberCharWithDef('5')
	int x) {
	}

	public void SingleMemberFloatOvrdDefParam(@javaT.lang.annotation.SingleMemberFloatWithDef(6.0F)
	int x) {
	}

	public void SingleMemberDoubleOvrdDefParam(@javaT.lang.annotation.SingleMemberDoubleWithDef(7.0)
	int x) {
	}

	public void SingleMemberBooleanOvrdDefParam(@javaT.lang.annotation.SingleMemberBooleanWithDef(true)
	int x) {
	}

	public void SingleMemberStringOvrdDefParam(@javaT.lang.annotation.SingleMemberStringWithDef("custom")
	int x) {
	}

	public void SingleMemberClassOvrdDefParam(@javaT.lang.annotation.SingleMemberClassWithDef(java.util.Map.class)
	int x) {
	}

	public void SingleMemberEnumOvrdDefParam(@javaT.lang.annotation.SingleMemberEnumWithDef(javaT.lang.annotation.Stooge.MOE)
	int x) {
	}

	public void SingleMemberByteAcceptDefParam(@javaT.lang.annotation.SingleMemberByteWithDef
	int x) {
	}

	public void SingleMemberShortAcceptDefParam(@javaT.lang.annotation.SingleMemberShortWithDef
	int x) {
	}

	public void SingleMemberIntAcceptDefParam(@javaT.lang.annotation.SingleMemberIntWithDef
	int x) {
	}

	public void SingleMemberLongAcceptDefParam(@javaT.lang.annotation.SingleMemberLongWithDef
	int x) {
	}

	public void SingleMemberCharAcceptDefParam(@javaT.lang.annotation.SingleMemberCharWithDef
	int x) {
	}

	public void SingleMemberFloatAcceptDefParam(@javaT.lang.annotation.SingleMemberFloatWithDef
	int x) {
	}

	public void SingleMemberDoubleAcceptDefParam(@javaT.lang.annotation.SingleMemberDoubleWithDef
	int x) {
	}

	public void SingleMemberBooleanAcceptDefParam(@javaT.lang.annotation.SingleMemberBooleanWithDef
	int x) {
	}

	public void SingleMemberStringAcceptDefParam(@javaT.lang.annotation.SingleMemberStringWithDef
	int x) {
	}

	public void SingleMemberClassAcceptDefParam(@javaT.lang.annotation.SingleMemberClassWithDef
	int x) {
	}

	public void SingleMemberEnumAcceptDefParam(@javaT.lang.annotation.SingleMemberEnumWithDef
	int x) {
	}

	public void SingleMemberByteArrEmptyParam(@javaT.lang.annotation.SingleMemberByteArray({  })
	int x) {
	}

	public void SingleMemberShortArrEmptyParam(@javaT.lang.annotation.SingleMemberShortArray({  })
	int x) {
	}

	public void SingleMemberIntArrEmptyParam(@javaT.lang.annotation.SingleMemberIntArray({  })
	int x) {
	}

	public void SingleMemberLongArrEmptyParam(@javaT.lang.annotation.SingleMemberLongArray({  })
	int x) {
	}

	public void SingleMemberCharArrEmptyParam(@javaT.lang.annotation.SingleMemberCharArray({  })
	int x) {
	}

	public void SingleMemberFloatArrEmptyParam(@javaT.lang.annotation.SingleMemberFloatArray({  })
	int x) {
	}

	public void SingleMemberDoubleArrEmptyParam(@javaT.lang.annotation.SingleMemberDoubleArray({  })
	int x) {
	}

	public void SingleMemberBooleanArrEmptyParam(@javaT.lang.annotation.SingleMemberBooleanArray({  })
	int x) {
	}

	public void SingleMemberStringArrEmptyParam(@javaT.lang.annotation.SingleMemberStringArray({  })
	int x) {
	}

	public void SingleMemberClassArrEmptyParam(@javaT.lang.annotation.SingleMemberClassArray({  })
	int x) {
	}

	public void SingleMemberEnumArrEmptyParam(@javaT.lang.annotation.SingleMemberEnumArray({  })
	int x) {
	}

	public void SingleMemberByteArrOneParam(@javaT.lang.annotation.SingleMemberByteArray(1)
	int x) {
	}

	public void SingleMemberShortArrOneParam(@javaT.lang.annotation.SingleMemberShortArray(2)
	int x) {
	}

	public void SingleMemberIntArrOneParam(@javaT.lang.annotation.SingleMemberIntArray(3)
	int x) {
	}

	public void SingleMemberLongArrOneParam(@javaT.lang.annotation.SingleMemberLongArray(4L)
	int x) {
	}

	public void SingleMemberCharArrOneParam(@javaT.lang.annotation.SingleMemberCharArray('5')
	int x) {
	}

	public void SingleMemberFloatArrOneParam(@javaT.lang.annotation.SingleMemberFloatArray(6.0F)
	int x) {
	}

	public void SingleMemberDoubleArrOneParam(@javaT.lang.annotation.SingleMemberDoubleArray(7.0)
	int x) {
	}

	public void SingleMemberBooleanArrOneParam(@javaT.lang.annotation.SingleMemberBooleanArray(true)
	int x) {
	}

	public void SingleMemberStringArrOneParam(@javaT.lang.annotation.SingleMemberStringArray("custom")
	int x) {
	}

	public void SingleMemberClassArrOneParam(@javaT.lang.annotation.SingleMemberClassArray(java.util.Map.class)
	int x) {
	}

	public void SingleMemberEnumArrOneParam(@javaT.lang.annotation.SingleMemberEnumArray(javaT.lang.annotation.Stooge.MOE)
	int x) {
	}

	public void SingleMemberByteArrTwoParam(@javaT.lang.annotation.SingleMemberByteArray({ 1, 2 })
	int x) {
	}

	public void SingleMemberShortArrTwoParam(@javaT.lang.annotation.SingleMemberShortArray({ 2, 3 })
	int x) {
	}

	public void SingleMemberIntArrTwoParam(@javaT.lang.annotation.SingleMemberIntArray({ 3, 4 })
	int x) {
	}

	public void SingleMemberLongArrTwoParam(@javaT.lang.annotation.SingleMemberLongArray({ 4L, 5L })
	int x) {
	}

	public void SingleMemberCharArrTwoParam(@javaT.lang.annotation.SingleMemberCharArray({ '5', '6' })
	int x) {
	}

	public void SingleMemberFloatArrTwoParam(@javaT.lang.annotation.SingleMemberFloatArray({ 6.0F, 7.0F })
	int x) {
	}

	public void SingleMemberDoubleArrTwoParam(@javaT.lang.annotation.SingleMemberDoubleArray({ 7.0, 8.0 })
	int x) {
	}

	public void SingleMemberBooleanArrTwoParam(@javaT.lang.annotation.SingleMemberBooleanArray({ true, false })
	int x) {
	}

	public void SingleMemberStringArrTwoParam(@javaT.lang.annotation.SingleMemberStringArray({ "custom", "paint" })
	int x) {
	}

	public void SingleMemberClassArrTwoParam(@javaT.lang.annotation.SingleMemberClassArray({ java.util.Map.class, java.util.Set.class })
	int x) {
	}

	public void SingleMemberEnumArrTwoParam(@javaT.lang.annotation.SingleMemberEnumArray({ javaT.lang.annotation.Stooge.MOE, javaT.lang.annotation.Stooge.CURLY })
	int x) {
	}

	public void SingleMemberByteArrOvrdDefParam(@javaT.lang.annotation.SingleMemberByteArrayDef(1)
	int x) {
	}

	public void SingleMemberShortArrOvrdDefParam(@javaT.lang.annotation.SingleMemberShortArrayDef(2)
	int x) {
	}

	public void SingleMemberIntArrOvrdDefParam(@javaT.lang.annotation.SingleMemberIntArrayDef(3)
	int x) {
	}

	public void SingleMemberLongArrOvrdDefParam(@javaT.lang.annotation.SingleMemberLongArrayDef(4L)
	int x) {
	}

	public void SingleMemberCharArrOvrdDefParam(@javaT.lang.annotation.SingleMemberCharArrayDef('5')
	int x) {
	}

	public void SingleMemberFloatArrOvrdDefParam(@javaT.lang.annotation.SingleMemberFloatArrayDef(6.0F)
	int x) {
	}

	public void SingleMemberDoubleArrOvrdDefParam(@javaT.lang.annotation.SingleMemberDoubleArrayDef(7.0)
	int x) {
	}

	public void SingleMemberBooleanArrOvrdDefParam(@javaT.lang.annotation.SingleMemberBooleanArrayDef(true)
	int x) {
	}

	public void SingleMemberStringArrOvrdDefParam(@javaT.lang.annotation.SingleMemberStringArrayDef("custom")
	int x) {
	}

	public void SingleMemberClassArrOvrdDefParam(@javaT.lang.annotation.SingleMemberClassArrayDef(java.util.Map.class)
	int x) {
	}

	public void SingleMemberEnumArrOvrdDefParam(@javaT.lang.annotation.SingleMemberEnumArrayDef(javaT.lang.annotation.Stooge.MOE)
	int x) {
	}

	public void SingleMemberByteArrAcceptDefParam(@javaT.lang.annotation.SingleMemberByteArrayDef
	int x) {
	}

	public void SingleMemberShortArrAcceptDefParam(@javaT.lang.annotation.SingleMemberShortArrayDef
	int x) {
	}

	public void SingleMemberIntArrAcceptDefParam(@javaT.lang.annotation.SingleMemberIntArrayDef
	int x) {
	}

	public void SingleMemberLongArrAcceptDefParam(@javaT.lang.annotation.SingleMemberLongArrayDef
	int x) {
	}

	public void SingleMemberCharArrAcceptDefParam(@javaT.lang.annotation.SingleMemberCharArrayDef
	int x) {
	}

	public void SingleMemberFloatArrAcceptDefParam(@javaT.lang.annotation.SingleMemberFloatArrayDef
	int x) {
	}

	public void SingleMemberDoubleArrAcceptDefParam(@javaT.lang.annotation.SingleMemberDoubleArrayDef
	int x) {
	}

	public void SingleMemberBooleanArrAcceptDefParam(@javaT.lang.annotation.SingleMemberBooleanArrayDef
	int x) {
	}

	public void SingleMemberStringArrAcceptDefParam(@javaT.lang.annotation.SingleMemberStringArrayDef
	int x) {
	}

	public void SingleMemberClassArrAcceptDefParam(@javaT.lang.annotation.SingleMemberClassArrayDef
	int x) {
	}

	public void SingleMemberEnumArrAcceptDefParam(@javaT.lang.annotation.SingleMemberEnumArrayDef
	int x) {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray({  })
	public int SingleMemberBooleanArrEmptyField;

	@javaT.lang.annotation.SingleMemberBooleanArray({  })
	public void SingleMemberBooleanArrEmpty() {
	}

	@javaT.lang.annotation.SingleMemberBooleanArray({  })
	public UnitTest(boolean[] b) {
	}
}