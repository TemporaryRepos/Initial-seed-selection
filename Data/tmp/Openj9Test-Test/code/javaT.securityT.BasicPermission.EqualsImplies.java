public class EqualsImplies {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Permission p1 = new javaT.securityT.BasicPermission.A("foo");
		java.security.Permission p2 = new javaT.securityT.BasicPermission.B("foo");
		if ((p1.implies(p2) || p2.implies(p1)) || p1.equals(p2)) {
			throw new java.lang.Exception("Test failed");
		}
		if (!(p1.implies(p1) && p1.equals(p1))) {
			throw new java.lang.Exception("Test failed");
		}
	}
}