public class A implements java.io.Serializable {
	static final long serialVersionUID = 3514945074733160196L;

	private java.lang.String name;

	public A(java.lang.String name) {
		this.name = name;
	}

	private void readObject(java.io.ObjectInputStream s) {
		java.lang.System.out.println("xxxwewjriwe");
	}

	public void doTest() {
	}

	public void doA() throws java.io.FileNotFoundException {
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream("/tmp/X.ser");
		java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(A[].class);
	}
}