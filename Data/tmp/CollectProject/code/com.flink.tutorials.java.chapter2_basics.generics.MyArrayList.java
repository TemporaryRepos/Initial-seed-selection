public class MyArrayList<T> {
	private int size;

	T[] elements;

	public MyArrayList(int capacity) {
		this.size = capacity;
		this.elements = ((T[]) (new java.lang.Object[capacity]));
	}

	public void set(T element, int position) {
		elements[position] = element;
	}

	@java.lang.Override
	public java.lang.String toString() {
		java.lang.String result = "";
		for (int i = 0; i < size; i++) {
			result += elements[i].toString();
		}
		return result;
	}

	public <E> void printInfo(E element) {
		java.lang.System.out.println(element.toString());
	}

	public static void main(java.lang.String[] args) {
		com.flink.tutorials.java.chapter2_basics.generics.MyArrayList<java.lang.String> strList = new com.flink.tutorials.java.chapter2_basics.generics.MyArrayList<java.lang.String>(2);
		strList.set("first", 0);
		strList.set("second", 1);
		com.flink.tutorials.java.chapter2_basics.generics.MyArrayList<java.lang.Integer> intList = new com.flink.tutorials.java.chapter2_basics.generics.MyArrayList<java.lang.Integer>(2);
		intList.set(11, 0);
		intList.set(22, 1);
		java.lang.System.out.println(strList.toString());
		java.lang.System.out.println(intList.toString());
		intList.printInfo("function");
	}
}