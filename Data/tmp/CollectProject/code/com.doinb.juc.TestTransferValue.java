public class TestTransferValue {
	private void changeValueInt(int age) {
		age = 30;
	}

	private void changeValuePerson(com.doinb.juc.Person person) {
		person.setPersonName("doinb");
	}

	private void changeValueStr(java.lang.String str) {
		str = "doinb";
	}

	public static void main(java.lang.String[] args) {
		com.doinb.juc.TestTransferValue testTransferValue = new com.doinb.juc.TestTransferValue();
		int age = 20;
		testTransferValue.changeValueInt(age);
		java.lang.System.out.println("age----" + age);
		com.doinb.juc.Person person = new com.doinb.juc.Person(18, "adc");
		testTransferValue.changeValuePerson(person);
		java.lang.System.out.println("personName----" + person.getPersonName());
		java.lang.String str = "abc";
		testTransferValue.changeValueStr(str);
		java.lang.System.out.println("string---" + str);
	}
}