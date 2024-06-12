public class ThaiTest extends javaT.text.Collator.CollatorTest {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		new javaT.text.Collator.ThaiTest().run(args);
	}

	private static final java.lang.String[] primarySourceData = new java.lang.String[]{ "กก", "งโก้", "ฐิน", "ถามรรคเทศนา", "รมธรรม์ประกันภัย", "รรมสิทธิ์เครื่องหมายและยี่ห้อการค้าขาย", "รรลุนิติภาวะ", "กลือแกง", "มทิลแอลกอฮอล์", "เอี่ยมอ่อง", "สดาปัตติผล", "อนกรรมสิทธิ์", "ม้เท้ายายม่อม", "ส้ละมาน", "ส้ศึก", "ส้อั่ว", "ส้เดือน", "ส้เลื่อน", "ส้แขวน", "ส้แห้ง", "ส้ไก่", "ห", "หซอง", "หน", "หปลาร้า", "หม", "หมทอง", "หมสับปะรด", "หม้", "หรณย์", "หล", "หลน้ำ", "หล่", "หล่ถนน", "หล่ทวีป", "หล่ทาง", "หล่รวบ", "ห้", "อ", "อ้", "ฮโล", "ฮไฟ", "ฮ้" };

	private static final java.lang.String[] primaryTargetData = new java.lang.String[]{ "กก", "งโก้", "ฐิน", "ถามรรคเทศนา", "รมธรรม์ประกันภัย", "รรมสิทธิ์เครื่องหมายและยี่ห้อการค้าขาย", "รรลุนิติภาวะ", "กลือแกง", "มทิลแอลกอฮอล์", "เอี่ยมอ่อง", "สดาปัตติผล", "อนกรรมสิทธิ์", "ม้เท้ายายม่อม", "ส้ละมาน", "ส้ศึก", "ส้อั่ว", "ส้เดือน", "ส้เลื่อน", "ส้แขวน", "ส้แห้ง", "ส้ไก่", "ห", "หซอง", "หน", "หปลาร้า", "หม", "หมทอง", "หมสับปะรด", "หม้", "หรณย์", "หล", "หลน้ำ", "หล่", "หล่ถนน", "หล่ทวีป", "หล่ทาง", "หล่รวบ", "ห้", "อ", "อ้", "ฮโล", "ฮไฟ", "ฮ้" };

	private static final int[] primaryResults = new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public void TestPrimary() {
		doTest(myCollation, java.text.Collator.PRIMARY, javaT.text.Collator.ThaiTest.primarySourceData, javaT.text.Collator.ThaiTest.primaryTargetData, javaT.text.Collator.ThaiTest.primaryResults);
	}

	private final java.text.Collator myCollation = java.text.Collator.getInstance(new java.util.Locale("th"));
}