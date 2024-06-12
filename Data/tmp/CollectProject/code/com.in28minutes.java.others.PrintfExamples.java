public class PrintfExamples {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.printf("%d", 5);
		java.lang.System.out.printf("My name is %s", "Rithu");
		java.lang.System.out.printf("%s is %d Years old", "Rithu", 5);
		java.lang.System.out.printf("|%5d|", 12);
		java.lang.System.out.printf("|%5d|", 1234);
		java.lang.System.out.printf("|%-5d|", 12);
		java.lang.System.out.printf("%05d", 12);
		java.lang.System.out.printf("%,d", 12345);
		java.lang.System.out.printf("%(d", -12345);
		java.lang.System.out.printf("%(d", 12345);
		java.lang.System.out.printf("%+d", -12345);
		java.lang.System.out.printf("%+d", 12345);
		java.lang.System.out.printf("%5.2f", 1234.5678);
		java.lang.System.out.printf("%3$.1f %2$s %1$d", 123, "Test", 123.4);
		java.lang.System.out.format("%5.2f", 1234.5678);
	}
}