public class IfElseExamples {
	public static void main(java.lang.String[] args) {
		if (true) {
			java.lang.System.out.println("Will be printed");
		}
		if (false) {
			java.lang.System.out.println("Will NOT be printed");
		}
		int x = 5;
		if (x == 5) {
			java.lang.System.out.println("x is 5");
		}
		x = 6;
		if (x == 5) {
			java.lang.System.out.println("x is 5");
		}
		int y = 10;
		if (y == 10) {
			java.lang.System.out.println("Y is 10");
		} else {
			java.lang.System.out.println("Y is Not 10");
		}
		y = 11;
		if (y == 10) {
			java.lang.System.out.println("Y is 10");
		} else {
			java.lang.System.out.println("Y is Not 10");
		}
		int z = 15;
		if (z == 10) {
			java.lang.System.out.println("Z is 10");
		} else if (z == 12) {
			java.lang.System.out.println("Z is 12");
		} else if (z == 15) {
			java.lang.System.out.println("Z is 15");
		} else {
			java.lang.System.out.println("Z is Something Else.");
		}
		z = 18;
		if (z == 10) {
			java.lang.System.out.println("Z is 10");
		} else if (z == 12) {
			java.lang.System.out.println("Z is 12");
		} else if (z == 15) {
			java.lang.System.out.println("Z is 15");
		} else {
			java.lang.System.out.println("Z is Something Else.");
		}
		int number = 5;
		if (number < 0) {
			number = number + 10;
		}
		number++;
		java.lang.System.out.println(number);
		int k = 15;
		if (k > 20) {
			java.lang.System.out.println(1);
		} else if (k > 10) {
			java.lang.System.out.println(2);
		} else if (k < 20) {
			java.lang.System.out.println(3);
		} else {
			java.lang.System.out.println(4);
		}
		int l = 15;
		if (l < 20) {
			java.lang.System.out.println("l<20");
		}
		if (l > 20) {
			java.lang.System.out.println("l>20");
		} else {
			java.lang.System.out.println("Who am I?");
		}
		int m = 15;
		if (m > 20) {
			if (m < 20) {
				java.lang.System.out.println("m>20");
			} else {
				java.lang.System.out.println("Who am I?");
			}
		}
		if (m > 20) {
			if (m < 20) {
				java.lang.System.out.println("m>20");
			} else {
				java.lang.System.out.println("Who am I?");
			}
		}
		int x1 = 0;
		boolean isTrue = false;
		if (isTrue == true) {
			java.lang.System.out.println("TRUE TRUE");
		}
		if (isTrue = true) {
			java.lang.System.out.println("TRUE");
		}
	}
}