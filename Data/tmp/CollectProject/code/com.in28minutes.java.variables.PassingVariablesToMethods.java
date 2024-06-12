public class PassingVariablesToMethods {
	public static void main(java.lang.String[] args) {
		com.in28minutes.java.variables.PassingVariablesToMethods ref = new com.in28minutes.java.variables.PassingVariablesToMethods();
		int n = 50;
		ref.incrementBy2(n);
		java.lang.System.out.println("Passing primitive " + n);
		com.in28minutes.java.variables.Cricketer cric = new com.in28minutes.java.variables.Cricketer();
		cric.runs = 50;
		ref.modifyCricketer(cric);
		java.lang.System.out.println("Passing reference variable " + cric.runs);
	}

	void incrementBy2(int number) {
		number = number + 2;
	}

	void modifyCricketer(com.in28minutes.java.variables.Cricketer cricketer) {
		cricketer.runs += 100;
	}
}