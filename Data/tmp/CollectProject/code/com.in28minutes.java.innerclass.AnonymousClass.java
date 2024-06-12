public class AnonymousClass {
	private static java.lang.String[] reverseSort(java.lang.String[] array) {
		java.util.Comparator<java.lang.String> reverseComparator = new java.util.Comparator<java.lang.String>() {
			@java.lang.Override
			public int compare(java.lang.String string1, java.lang.String string2) {
				return string2.compareTo(string1);
			}
		};
		java.util.Arrays.sort(array, reverseComparator);
		return array;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String[] array = new java.lang.String[]{ "Apple", "Cat", "Boy" };
		java.lang.System.out.println(java.util.Arrays.toString(com.in28minutes.java.innerclass.AnonymousClass.reverseSort(array)));
		com.in28minutes.java.innerclass.Animal animal = new com.in28minutes.java.innerclass.Animal() {
			void bark() {
				java.lang.System.out.println("Subclass bark");
			}
		};
		animal.bark();
	}
}