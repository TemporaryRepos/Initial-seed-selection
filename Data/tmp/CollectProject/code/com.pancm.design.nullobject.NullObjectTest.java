public class NullObjectTest {
	public static void main(java.lang.String[] args) {
		com.pancm.design.nullobject.AbstractUser au1 = com.pancm.design.nullobject.UserFactory.getUser("wangwu");
		com.pancm.design.nullobject.AbstractUser au2 = com.pancm.design.nullobject.UserFactory.getUser("xuwujing");
		java.lang.System.out.println(au1.isNull());
		java.lang.System.out.println(au1.getName());
		java.lang.System.out.println(au2.isNull());
		java.lang.System.out.println(au2.getName());
	}
}