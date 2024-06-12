public class AddToReadOnlyPermissionCollection {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			if (args.length == 0) {
				javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryAllPC();
				javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryBasicPC();
				javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryFilePC();
				javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryPropPC();
				javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.trySockPC();
			} else {
				for (int i = 0; i < args.length; i++) {
					switch (args[i].toLowerCase().charAt(1)) {
						case 'a' :
							javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryAllPC();
							break;
						case 'b' :
							javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryBasicPC();
							break;
						case 'f' :
							javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryFilePC();
							break;
						case 'p' :
							javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.tryPropPC();
							break;
						case 's' :
							javaT.securityT.PermissionCollection.AddToReadOnlyPermissionCollection.trySockPC();
							break;
						default :
							throw new java.lang.Exception("usage: AddToReadOnlyPermissonCollection [-a -b -f -p -s]");
					}
				}
			}
		} catch (java.lang.Exception e) {
			throw e;
		}
		java.lang.System.out.println("Passed. OKAY");
	}

	static void tryPropPC() throws java.lang.Exception {
		try {
			java.util.PropertyPermission p0 = new java.util.PropertyPermission("user.home", "read");
			java.security.PermissionCollection pc = p0.newPermissionCollection();
			pc.setReadOnly();
			java.util.PropertyPermission p1 = new java.util.PropertyPermission("java.home", "read");
			pc.add(p1);
			throw new java.lang.Exception("Failed...PropertyPermission added to readonly PropertyPermissionCollection.");
		} catch (java.lang.SecurityException se) {
			java.lang.System.out.println("PropertyPermissionCollection passed");
		}
	}

	static void trySockPC() throws java.lang.Exception {
		try {
			java.net.SocketPermission p0 = new java.net.SocketPermission("example.com", "connect");
			java.security.PermissionCollection pc = p0.newPermissionCollection();
			pc.setReadOnly();
			java.net.SocketPermission p1 = new java.net.SocketPermission("example.net", "connect");
			pc.add(p1);
			throw new java.lang.Exception("Failed...SocketPermission added to readonly SocketPermissionCollection.");
		} catch (java.lang.SecurityException se) {
			java.lang.System.out.println("SocketPermissionCollection passed");
		}
	}

	static void tryFilePC() throws java.lang.Exception {
		try {
			java.io.FilePermission p0 = new java.io.FilePermission("/home/foobar", "read");
			java.security.PermissionCollection pc = p0.newPermissionCollection();
			pc.setReadOnly();
			java.io.FilePermission p1 = new java.io.FilePermission("/home/quux", "read");
			pc.add(p1);
			throw new java.lang.Exception("Failed...FilePermission added to readonly FilePermissionCollection.");
		} catch (java.lang.SecurityException se) {
			java.lang.System.out.println("FilePermissionCollection passed");
		}
	}

	static void tryBasicPC() throws java.lang.Exception {
		try {
			javaT.securityT.PermissionCollection.MyBasicPermission p0 = new javaT.securityT.PermissionCollection.MyBasicPermission("BasicPermision");
			java.security.PermissionCollection pc = p0.newPermissionCollection();
			pc.setReadOnly();
			javaT.securityT.PermissionCollection.MyBasicPermission p1 = new javaT.securityT.PermissionCollection.MyBasicPermission("EvenMoreBasic");
			pc.add(p1);
			throw new java.lang.Exception("Failed...BasicPermission added to readonly BasicPermissionCollection.");
		} catch (java.lang.SecurityException se) {
			java.lang.System.out.println("BasicPermissionCollection passed");
		}
	}

	static void tryAllPC() throws java.lang.Exception {
		try {
			java.security.AllPermission p0 = new java.security.AllPermission("AllOfIt", "read");
			java.security.PermissionCollection pc = p0.newPermissionCollection();
			pc.setReadOnly();
			java.security.AllPermission p1 = new java.security.AllPermission("SomeOfIt", "read");
			pc.add(p1);
			throw new java.lang.Exception("Failed...AllPermission added to readonly AllPermissionCollection.");
		} catch (java.lang.SecurityException se) {
			java.lang.System.out.println("AllPermissionCollection passed");
		}
	}
}