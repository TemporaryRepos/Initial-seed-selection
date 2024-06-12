public class ClassLoadTest {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("-----------------------------------------------");
		java.lang.System.out.println("-----------AbstractInstant---------------------");
		java.lang.Class cls = org.joda.time.base.AbstractInstant.class;
		java.lang.System.out.println("-----------ReadableDateTime--------------------");
		cls = org.joda.time.ReadableDateTime.class;
		java.lang.System.out.println("-----------AbstractDateTime--------------------");
		cls = org.joda.time.base.AbstractDateTime.class;
		java.lang.System.out.println("-----------DateTime----------------------------");
		cls = org.joda.time.DateTime.class;
		java.lang.System.out.println("-----------DateTimeZone------------------------");
		cls = org.joda.time.DateTimeZone.class;
		java.lang.System.out.println("-----------new DateTime()----------------------");
		org.joda.time.DateTime dt = new org.joda.time.DateTime();
		java.lang.System.out.println("-----------new DateTime(ReadableInstant)-------");
		dt = new org.joda.time.DateTime(dt);
		java.lang.System.out.println("-----------new DateTime(Long)------------------");
		dt = new org.joda.time.DateTime(new java.lang.Long(0));
		java.lang.System.out.println("-----------------------------------------------");
	}
}