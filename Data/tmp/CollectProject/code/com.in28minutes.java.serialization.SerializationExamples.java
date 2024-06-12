public class SerializationExamples {
	public static void main(java.lang.String[] args) throws java.io.IOException, java.lang.ClassNotFoundException {
		java.io.FileOutputStream fileStream = new java.io.FileOutputStream("Rectangle.ser");
		java.io.ObjectOutputStream objectStream = new java.io.ObjectOutputStream(fileStream);
		objectStream.writeObject(new com.in28minutes.java.serialization.Rectangle(5, 6));
		objectStream.close();
		java.io.FileInputStream fileInputStream = new java.io.FileInputStream("Rectangle.ser");
		java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
		com.in28minutes.java.serialization.Rectangle rectangle = ((com.in28minutes.java.serialization.Rectangle) (objectInputStream.readObject()));
		objectInputStream.close();
		java.lang.System.out.println(rectangle.length);
		java.lang.System.out.println(rectangle.breadth);
		java.lang.System.out.println(rectangle.area);
	}
}