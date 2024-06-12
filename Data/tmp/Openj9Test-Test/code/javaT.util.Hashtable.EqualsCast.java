public class EqualsCast {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.util.Map m1 = new javaT.util.Hashtable.MyProvider("foo", 69, "baz");
		java.util.Map m2 = new javaT.util.Hashtable.MyProvider("foo", 69, "baz");
		m1.equals(m2);
	}
}