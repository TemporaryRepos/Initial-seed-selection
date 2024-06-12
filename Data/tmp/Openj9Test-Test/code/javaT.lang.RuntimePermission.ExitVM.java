public class ExitVM {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.RuntimePermission newWildcard = new java.lang.RuntimePermission("exitVM.*");
		java.lang.RuntimePermission oldWildcard = new java.lang.RuntimePermission("exitVM");
		java.lang.RuntimePermission other = new java.lang.RuntimePermission("exitVM.23");
		java.lang.System.out.println("Testing RuntimePermission(\"exitVM.*\")");
		java.lang.System.out.println("    testing getName()");
		if (!newWildcard.getName().equals("exitVM.*")) {
			throw new java.lang.Exception("expected: exitVM.* received:" + newWildcard.getName());
		}
		java.lang.System.out.println("    testing equals(new RuntimePermission(\"exitVM.*\"))");
		if (!newWildcard.equals(new java.lang.RuntimePermission("exitVM.*"))) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing equals(new RuntimePermission(\"exitVM.23\"))");
		if (newWildcard.equals(other)) {
			throw new java.lang.Exception("expected false, received true");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.23\"))");
		if (!newWildcard.implies(other)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.*\"))");
		if (!newWildcard.implies(new java.lang.RuntimePermission("exitVM.*"))) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM\"))");
		if (!newWildcard.implies(oldWildcard)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("Testing RuntimePermission(\"exitVM\")");
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.*\"))");
		if (!oldWildcard.implies(newWildcard)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM\"))");
		if (!oldWildcard.implies(new java.lang.RuntimePermission("exitVM"))) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.23\"))");
		if (!oldWildcard.implies(other)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("Testing PermissionCollection containing " + "RuntimePermission(\"exitVM.*\")");
		java.security.PermissionCollection newPC = newWildcard.newPermissionCollection();
		newPC.add(newWildcard);
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.23\"))");
		if (!newPC.implies(other)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.*\"))");
		if (!newPC.implies(new java.lang.RuntimePermission("exitVM.*"))) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM\"))");
		if (!newPC.implies(oldWildcard)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("Testing PermissionCollection containing " + "RuntimePermission(\"exitVM\")");
		java.security.PermissionCollection oldPC = oldWildcard.newPermissionCollection();
		oldPC.add(oldWildcard);
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.23\"))");
		if (!oldPC.implies(other)) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM.*\"))");
		if (!oldPC.implies(new java.lang.RuntimePermission("exitVM.*"))) {
			throw new java.lang.Exception("expected true, received false");
		}
		java.lang.System.out.println("    testing implies(new RuntimePermission(\"exitVM\"))");
		if (!oldPC.implies(oldWildcard)) {
			throw new java.lang.Exception("expected true, received false");
		}
	}
}