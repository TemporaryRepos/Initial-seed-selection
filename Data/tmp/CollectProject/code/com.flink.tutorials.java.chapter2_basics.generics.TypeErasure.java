public class TypeErasure {
	public static void main(java.lang.String[] args) {
		java.lang.Class<?> strListClass = new java.util.ArrayList<java.lang.String>().getClass();
		java.lang.Class<?> intListClass = new java.util.ArrayList<java.lang.Integer>().getClass();
		java.lang.System.out.println(strListClass);
		java.lang.System.out.println(intListClass);
		java.lang.System.out.println(strListClass.equals(intListClass));
	}
}