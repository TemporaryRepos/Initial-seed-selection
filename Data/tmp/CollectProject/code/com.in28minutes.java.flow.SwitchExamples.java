public class SwitchExamples {
	public static void main(java.lang.String[] args) {
		int number = 2;
		switch (number) {
			case 1 :
				java.lang.System.out.println(1);
				break;
			case 2 :
				java.lang.System.out.println(2);
				break;
			case 3 :
				java.lang.System.out.println(3);
				break;
			default :
				java.lang.System.out.println("Default");
				break;
		}
		number = 2;
		switch (number) {
			case 1 :
				java.lang.System.out.println(1);
			case 2 :
				java.lang.System.out.println(2);
			case 3 :
				java.lang.System.out.println(3);
			default :
				java.lang.System.out.println("Default");
		}
		number = 2;
		switch (number) {
			case 1 :
				java.lang.System.out.println(1);
				break;
			case 2 :
			case 3 :
				java.lang.System.out.println("Number is 2 or 3");
				break;
			default :
				java.lang.System.out.println("Default");
				break;
		}
		number = 10;
		switch (number) {
			case 1 :
				java.lang.System.out.println(1);
				break;
			case 2 :
				java.lang.System.out.println(2);
				break;
			case 3 :
				java.lang.System.out.println(3);
				break;
			default :
				java.lang.System.out.println("Default");
				break;
		}
		number = 10;
		switch (number) {
			default :
				java.lang.System.out.println("Default");
				break;
			case 1 :
				java.lang.System.out.println(1);
				break;
			case 2 :
				java.lang.System.out.println(2);
				break;
			case 3 :
				java.lang.System.out.println(3);
				break;
		}
		long l = 15;
		number = 10;
		switch (number) {
		}
	}
}