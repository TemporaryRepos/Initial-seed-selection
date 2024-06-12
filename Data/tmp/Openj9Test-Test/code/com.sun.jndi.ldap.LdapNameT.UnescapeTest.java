public class UnescapeTest {
	public static void main(java.lang.String[] args) {
		try {
			java.lang.System.out.println(com.sun.jndi.ldap.LdapName.unescapeAttributeValue("\\uvw"));
		} catch (java.lang.IllegalArgumentException e) {
			java.lang.System.out.println("Caught the right exception");
		}
	}
}