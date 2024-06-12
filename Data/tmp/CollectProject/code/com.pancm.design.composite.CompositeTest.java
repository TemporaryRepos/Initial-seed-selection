public class CompositeTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.composite.Student studentLeader = new com.pancm.design.composite.Student("小明", "学生会主席");
		com.pancm.design.composite.Student committeeMember = new com.pancm.design.composite.Student("小刚", "学生会委员");
		com.pancm.design.composite.Student student = new com.pancm.design.composite.Student("小红", "学生");
		committeeMember.add(student);
		studentLeader.add(committeeMember);
		java.lang.System.out.println("-" + studentLeader);
		studentLeader.get().forEach(( sl) -> {
			java.lang.System.out.println("--" + sl);
			sl.get().forEach(( cm) -> {
				java.lang.System.out.println("---" + cm);
			});
		});
	}
}