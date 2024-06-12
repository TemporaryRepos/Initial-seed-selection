public class Case {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.sun.jndi.ldap.LdapName name = new com.sun.jndi.ldap.LdapName("cn=Kuwabatake Sanjuro");
		name.setValuesCaseSensitive(false);
		name.size();
	}
}