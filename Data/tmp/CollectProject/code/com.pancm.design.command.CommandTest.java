public class CommandTest {
	public static void main(java.lang.String[] args) {
		java.lang.String name = "xuwujing";
		com.pancm.design.command.Student student = new com.pancm.design.command.Student();
		com.pancm.design.command.Command command1 = new com.pancm.design.command.LiTeacher(student);
		com.pancm.design.command.Command command2 = new com.pancm.design.command.WangTeacher(student);
		com.pancm.design.command.Invoker invoker = new com.pancm.design.command.Invoker();
		invoker.setCommand(command1);
		invoker.setCommand(command2);
		invoker.executeCommand(name);
	}
}