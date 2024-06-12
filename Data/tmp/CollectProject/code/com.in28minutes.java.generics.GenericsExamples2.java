public class GenericsExamples2 {
	static void doSomethingArray(com.in28minutes.java.generics.Animal[] animals) {
	}

	static void doSomethingList(java.util.List<com.in28minutes.java.generics.Animal> animals) {
	}

	static void doSomethingListModified(java.util.List<? extends com.in28minutes.java.generics.Animal> animals) {
	}

	static void doSomethingListModifiedSuper(java.util.List<? super com.in28minutes.java.generics.Dog> animals) {
	}

	static void doSomethingListInterface(java.util.List<? extends java.io.Serializable> animals) {
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.generics.Animal[] animalsArray = new com.in28minutes.java.generics.Animal[]{ new com.in28minutes.java.generics.Animal(), new com.in28minutes.java.generics.Dog() };
		com.in28minutes.java.generics.Dog[] dogsArray = new com.in28minutes.java.generics.Dog[]{ new com.in28minutes.java.generics.Dog(), new com.in28minutes.java.generics.Dog() };
		java.util.List<com.in28minutes.java.generics.Animal> animalsList = java.util.Arrays.asList(animalsArray);
		java.util.List<com.in28minutes.java.generics.Dog> dogsList = java.util.Arrays.asList(dogsArray);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingArray(animalsArray);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingArray(dogsArray);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingList(animalsList);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingListModified(animalsList);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingListModified(dogsList);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingListModifiedSuper(animalsList);
		com.in28minutes.java.generics.GenericsExamples2.doSomethingListModifiedSuper(dogsList);
		java.util.List<? extends com.in28minutes.java.generics.Animal> listAnimals = new java.util.ArrayList<com.in28minutes.java.generics.Dog>();
	}
}