public class SerializationExamples2 {
	public static void main(java.lang.String[] args) throws java.io.IOException {
		java.io.FileOutputStream fileStream = new java.io.FileOutputStream("House.ser");
		java.io.ObjectOutputStream objectStream = new java.io.ObjectOutputStream(fileStream);
		com.in28minutes.java.serialization.House house = new com.in28minutes.java.serialization.House(10);
		house.wall = new com.in28minutes.java.serialization.Wall();
		objectStream.writeObject(house);
		objectStream.close();
	}
}