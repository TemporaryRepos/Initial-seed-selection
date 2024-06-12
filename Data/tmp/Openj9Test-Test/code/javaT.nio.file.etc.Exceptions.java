public class Exceptions {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.nio.file.etc.Exceptions.testFileSystemException();
		javaT.nio.file.etc.Exceptions.testDirectoryIteratorException();
	}

	static void testFileSystemException() throws java.lang.Exception {
		java.lang.String thisFile = "source";
		java.lang.String otherFile = "target";
		java.lang.String reason = "Access denied";
		javaT.nio.file.etc.Exceptions.testFileSystemException(thisFile, otherFile, reason);
		javaT.nio.file.etc.Exceptions.testFileSystemException(null, otherFile, reason);
		javaT.nio.file.etc.Exceptions.testFileSystemException(thisFile, null, reason);
		javaT.nio.file.etc.Exceptions.testFileSystemException(thisFile, otherFile, null);
		java.nio.file.FileSystemException exc;
		exc = new java.nio.file.FileSystemException(thisFile, otherFile, reason);
		exc = ((java.nio.file.FileSystemException) (javaT.nio.file.etc.Exceptions.deserialize(javaT.nio.file.etc.Exceptions.serialize(exc))));
		if ((!exc.getFile().equals(thisFile)) || (!exc.getOtherFile().equals(otherFile))) {
			throw new java.lang.RuntimeException("Exception not reconstituted completely");
		}
	}

	static void testFileSystemException(java.lang.String thisFile, java.lang.String otherFile, java.lang.String reason) {
		java.nio.file.FileSystemException exc = new java.nio.file.FileSystemException(thisFile, otherFile, reason);
		if (!java.util.Objects.equals(thisFile, exc.getFile())) {
			throw new java.lang.RuntimeException("getFile returned unexpected result");
		}
		if (!java.util.Objects.equals(otherFile, exc.getOtherFile())) {
			throw new java.lang.RuntimeException("getOtherFile returned unexpected result");
		}
		if (!java.util.Objects.equals(reason, exc.getReason())) {
			throw new java.lang.RuntimeException("getReason returned unexpected result");
		}
	}

	static void testDirectoryIteratorException() throws java.lang.Exception {
		try {
			new java.nio.file.DirectoryIteratorException(null);
			throw new java.lang.RuntimeException("NullPointerException expected");
		} catch (java.lang.NullPointerException expected) {
		}
		java.nio.file.DirectoryIteratorException exc;
		exc = new java.nio.file.DirectoryIteratorException(new java.io.IOException());
		exc = ((java.nio.file.DirectoryIteratorException) (javaT.nio.file.etc.Exceptions.deserialize(javaT.nio.file.etc.Exceptions.serialize(exc))));
		java.io.IOException ioe = exc.getCause();
		if (ioe == null) {
			throw new java.lang.RuntimeException("Cause should not be null");
		}
		javaT.nio.file.etc.Exceptions.hackCause(exc, null);
		try {
			javaT.nio.file.etc.Exceptions.deserialize(javaT.nio.file.etc.Exceptions.serialize(exc));
			throw new java.lang.RuntimeException("InvalidObjectException expected");
		} catch (java.io.InvalidObjectException expected) {
		}
		javaT.nio.file.etc.Exceptions.hackCause(exc, new java.lang.RuntimeException());
		try {
			javaT.nio.file.etc.Exceptions.deserialize(javaT.nio.file.etc.Exceptions.serialize(exc));
			throw new java.lang.RuntimeException("InvalidObjectException expected");
		} catch (java.io.InvalidObjectException expected) {
		}
	}

	static void hackCause(java.lang.Throwable t, java.lang.Throwable cause) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
		java.lang.reflect.Field f = java.lang.Throwable.class.getDeclaredField("cause");
		f.setAccessible(true);
		f.set(t, cause);
	}

	static byte[] serialize(java.lang.Object o) throws java.io.IOException {
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		return baos.toByteArray();
	}

	static java.lang.Object deserialize(byte[] bytes) throws java.io.IOException, java.lang.ClassNotFoundException {
		java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(bytes);
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(in);
		java.lang.Object result = ois.readObject();
		ois.close();
		return result;
	}
}