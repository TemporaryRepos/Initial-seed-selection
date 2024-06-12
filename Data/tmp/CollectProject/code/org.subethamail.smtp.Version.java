public final class Version {
	private Version() {
	}

	public static java.lang.String getSpecification() {
		java.lang.Package pkg = org.subethamail.smtp.Version.class.getPackage();
		return pkg == null ? null : pkg.getSpecificationVersion();
	}

	public static java.lang.String getImplementation() {
		java.lang.Package pkg = org.subethamail.smtp.Version.class.getPackage();
		return pkg == null ? null : pkg.getImplementationVersion();
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println("Version: " + org.subethamail.smtp.Version.getSpecification());
		java.lang.System.out.println("Implementation: " + org.subethamail.smtp.Version.getImplementation());
	}
}