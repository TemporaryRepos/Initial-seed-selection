public class VariableArgumentExamples {
	public int sum(int... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.varargs.VariableArgumentExamples example = new com.in28minutes.java.varargs.VariableArgumentExamples();
		java.lang.System.out.println(example.sum(1, 4, 5));
		java.lang.System.out.println(example.sum(1, 4, 5, 20));
		java.lang.System.out.println(example.sum());
	}

	class Animal {
		void bark() {
			java.lang.System.out.println("Bark");
		}

		void bark(com.in28minutes.java.varargs.VariableArgumentExamples.Animal... animals) {
			for (com.in28minutes.java.varargs.VariableArgumentExamples.Animal animal : animals) {
				animal.bark();
			}
		}
	}
}