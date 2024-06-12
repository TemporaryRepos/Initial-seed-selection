public class WrapperExamples {
	public static void main(java.lang.String[] args) {
		java.lang.Integer number = new java.lang.Integer(55);
		java.lang.Integer value = 10;
		value = value + 1;
		java.lang.Integer number2 = new java.lang.Integer("55");
		java.lang.Float number3 = new java.lang.Float(55.0);
		java.lang.Float number4 = new java.lang.Float(55.0F);
		java.lang.Float number5 = new java.lang.Float("55.0f");
		java.lang.Character c1 = new java.lang.Character('C');
		java.lang.Boolean b = new java.lang.Boolean(true);
		java.lang.Boolean b1 = new java.lang.Boolean("true");
		java.lang.Boolean b2 = new java.lang.Boolean("True");
		java.lang.Boolean b3 = new java.lang.Boolean("False");
		java.lang.Boolean b4 = new java.lang.Boolean("SomeString");
		b = false;
		int i = 5;
		i = 6;
		i = 7;
		java.lang.Integer integer = 6;
		integer = 7;
		java.lang.Integer seven = java.lang.Integer.valueOf("111", 2);
		java.lang.Integer hundred = java.lang.Integer.valueOf("100", 10);
		int primitive = seven.intValue();
		float primitiveFloat = seven.floatValue();
		java.lang.Float floatWrapper = java.lang.Float.valueOf(57.0F);
		int floatToInt = floatWrapper.intValue();
		float floatToFloat = floatWrapper.floatValue();
		int sevenPrimitive = java.lang.Integer.parseInt("111", 2);
		int hundredPrimitive = java.lang.Integer.parseInt("100");
		java.lang.Integer wrapperEight = new java.lang.Integer(8);
		java.lang.System.out.println(java.lang.Integer.toString(wrapperEight));
		java.lang.System.out.println(java.lang.Integer.toString(wrapperEight, 2));
		java.lang.System.out.println(java.lang.Integer.toHexString(wrapperEight));
		java.lang.System.out.println(java.lang.Integer.toBinaryString(wrapperEight));
		java.lang.System.out.println(java.lang.Integer.toOctalString(wrapperEight));
		java.lang.Integer ten = new java.lang.Integer(10);
		ten++;
		java.lang.Integer nineA = new java.lang.Integer(9);
		java.lang.Integer nineB = new java.lang.Integer(9);
		java.lang.System.out.println(nineA == nineB);
		java.lang.System.out.println(nineA.equals(nineB));
		java.lang.Integer nineC = 9;
		java.lang.Integer nineD = 9;
		java.lang.System.out.println(nineC == nineD);
		java.lang.System.out.println(nineC.equals(nineD));
	}
}