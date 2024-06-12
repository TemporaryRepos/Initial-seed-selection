public class SerializationExamples3 {
	public static void main(java.lang.String[] args) throws java.io.IOException, java.lang.ClassNotFoundException {
		java.io.FileOutputStream fileStream = new java.io.FileOutputStream("Hero.ser");
		java.io.ObjectOutputStream objectStream = new java.io.ObjectOutputStream(fileStream);
		com.in28minutes.java.serialization.Hero hero = new com.in28minutes.java.serialization.Hero();
		hero.danceType = "Ganganam";
		hero.name = "Hero1";
		java.lang.System.out.println((("Before -> DanceType :" + hero.danceType) + " Name:") + hero.name);
		objectStream.writeObject(hero);
		objectStream.close();
		java.io.FileInputStream fileInputStream = new java.io.FileInputStream("Hero.ser");
		java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(fileInputStream);
		hero = ((com.in28minutes.java.serialization.Hero) (objectInputStream.readObject()));
		objectInputStream.close();
		java.lang.System.out.println((("After -> DanceType :" + hero.danceType) + " Name:") + hero.name);
	}
}