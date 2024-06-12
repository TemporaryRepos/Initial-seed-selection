public class Mule implements ch6.s2.IHorse , ch6.s2.IDonkey , ch6.s2.IAnimal {
	@java.lang.Override
	public void eat() {
		java.lang.System.out.println("Mule eat");
	}

	@java.lang.Override
	public void run() {
		ch6.s2.IHorse.super.run();
	}

	public static void main(java.lang.String[] args) {
		ch6.s2.Mule m = new ch6.s2.Mule();
		m.run();
		m.breath();
	}
}