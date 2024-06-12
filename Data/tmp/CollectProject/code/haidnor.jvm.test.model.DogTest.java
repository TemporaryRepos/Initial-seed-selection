public class DogTest {
	public static void main(java.lang.String[] args) {
		haidnor.jvm.test.model.ThinDog dog1 = new haidnor.jvm.test.model.ThinDog();
		if (dog1 instanceof haidnor.jvm.test.model.Dog) {
			java.lang.System.out.println("细狗是一种狗");
		}
	}

	static class InnerClass {}
}