public class RelationalOperators {
	public static void main(java.lang.String[] args) {
		int number = 7;
		java.lang.System.out.println(number > 5);
		java.lang.System.out.println(number > 7);
		java.lang.System.out.println(number >= 7);
		java.lang.System.out.println(number < 9);
		java.lang.System.out.println(number < 7);
		java.lang.System.out.println(number <= 7);
		java.lang.System.out.println(number == 7);
		java.lang.System.out.println(number == 9);
		java.lang.System.out.println(number != 9);
		java.lang.System.out.println(number != 7);
		java.lang.System.out.println(number = 7);
		int a = 5;
		int b = 5;
		java.lang.System.out.println(a == b);
		java.lang.Integer aReference = new java.lang.Integer(5);
		java.lang.Integer bReference = new java.lang.Integer(5);
		java.lang.System.out.println(aReference == bReference);
		bReference = aReference;
		java.lang.System.out.println(aReference == bReference);
	}
}