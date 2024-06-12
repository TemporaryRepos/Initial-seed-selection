public class FieldsTest {
	public static class ClassA extends cn.ponfee.commons.model.BaseEntity.Creator<java.lang.String> {
		private static final long serialVersionUID = -5617457253295566886L;
	}

	public static void main(java.lang.String[] args) {
		cn.ponfee.commons.reflect.FieldsTest.ClassA a = new cn.ponfee.commons.reflect.FieldsTest.ClassA();
		java.lang.System.out.println(a.getId());
		cn.ponfee.commons.reflect.Fields.put(a, "id", 999L);
		java.lang.System.out.println(a.getId());
	}
}