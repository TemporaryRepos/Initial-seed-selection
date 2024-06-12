public class Actor {
	private java.lang.String name;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public static void main(java.lang.String[] args) {
		com.in28minutes.java.basics.Actor bradPitt = new com.in28minutes.java.basics.Actor();
		bradPitt.setName("Brad Pitt");
		com.in28minutes.java.basics.Actor tomCruise = new com.in28minutes.java.basics.Actor();
		tomCruise.setName("Tom Cruise");
	}
}