public class Bug4387255 {
	private static final double[] doubles = new double[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35 };

	private static final java.lang.String[] strings = new java.lang.String[]{ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	private static final java.lang.String pattern = "0#0|1#1|2#2|3#3|4#4|5#5|6#6|7#7|8#8|9#9" + (("|10#A|11#B|12#C|13#D|14#E|15#F|16#G|17#H|18#I|19#J" + "|20#K|21#L|22#M|23#N|24#O|25#P|26#Q|27#R|28#S|29#T") + "|30#U|31#V|32#W|33#X|34#Y|35#Z");

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.text.ChoiceFormat choiceFormat1 = new java.text.ChoiceFormat(javaT.text.Format.ChoiceFormat.Bug4387255.doubles, javaT.text.Format.ChoiceFormat.Bug4387255.strings);
		java.text.ChoiceFormat choiceFormat2 = new java.text.ChoiceFormat(javaT.text.Format.ChoiceFormat.Bug4387255.pattern);
		if (!choiceFormat1.equals(choiceFormat2)) {
			java.lang.System.out.println("choiceFormat1: " + choiceFormat1.toPattern());
			java.lang.System.out.println("choiceFormat2: " + choiceFormat2.toPattern());
			throw new java.lang.RuntimeException();
		}
		for (int i = 0; i < javaT.text.Format.ChoiceFormat.Bug4387255.doubles.length; i++) {
			java.lang.String result = choiceFormat2.format(javaT.text.Format.ChoiceFormat.Bug4387255.doubles[i]);
			if (!result.equals(javaT.text.Format.ChoiceFormat.Bug4387255.strings[i])) {
				throw new java.lang.RuntimeException((("Wrong format result - expected " + javaT.text.Format.ChoiceFormat.Bug4387255.strings[i]) + ", got ") + result);
			}
		}
	}
}