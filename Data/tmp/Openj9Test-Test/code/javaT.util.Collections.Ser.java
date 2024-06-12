public class Ser {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			out.writeObject(java.util.Collections.EMPTY_SET);
			out.flush();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bos.toByteArray()));
			if (!java.util.Collections.EMPTY_SET.equals(in.readObject())) {
				throw new java.lang.RuntimeException("empty set Ser/Deser failure.");
			}
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Failed to serialize empty set:" + e);
		}
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			out.writeObject(java.util.Collections.EMPTY_LIST);
			out.flush();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bos.toByteArray()));
			if (!java.util.Collections.EMPTY_LIST.equals(in.readObject())) {
				throw new java.lang.RuntimeException("empty list Ser/Deser failure.");
			}
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Failed to serialize empty list:" + e);
		}
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			java.util.Set gumby = java.util.Collections.singleton("gumby");
			out.writeObject(gumby);
			out.flush();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bos.toByteArray()));
			if (!gumby.equals(in.readObject())) {
				throw new java.lang.RuntimeException("Singleton Ser/Deser failure.");
			}
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Failed to serialize singleton:" + e);
		}
		try {
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(bos);
			java.util.List gumbies = java.util.Collections.nCopies(50, "gumby");
			out.writeObject(gumbies);
			out.flush();
			java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(bos.toByteArray()));
			if (!gumbies.equals(in.readObject())) {
				throw new java.lang.RuntimeException("nCopies Ser/Deser failure.");
			}
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("Failed to serialize nCopies:" + e);
		}
	}
}