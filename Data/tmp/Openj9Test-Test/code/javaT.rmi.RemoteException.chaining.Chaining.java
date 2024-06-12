public class Chaining {
	static void check(java.lang.Throwable t, java.lang.String msg, java.lang.Throwable cause) throws java.lang.Exception {
		java.lang.String tmsg = t.getMessage();
		if (msg == null ? tmsg != null : !msg.equals(tmsg)) {
			throw new java.lang.RuntimeException("message does not match");
		}
		if (t.getClass().getField("detail").get(t) != cause) {
			throw new java.lang.RuntimeException("detail field does not match");
		}
		if (t.getCause() != cause) {
			throw new java.lang.RuntimeException("getCause value does not match");
		}
		try {
			t.initCause(cause);
			throw new java.lang.RuntimeException("initCause succeeded");
		} catch (java.lang.IllegalStateException e) {
		}
	}

	static void test(java.lang.Throwable t, java.lang.String msg, java.lang.Throwable cause) throws java.lang.Exception {
		javaT.rmi.RemoteException.chaining.Chaining.check(t, msg, cause);
		java.lang.Throwable[] pair = new java.lang.Throwable[]{ t, cause };
		pair = ((java.lang.Throwable[]) (new java.rmi.MarshalledObject(pair).get()));
		javaT.rmi.RemoteException.chaining.Chaining.check(pair[0], msg, pair[1]);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.Exception t = new java.lang.RuntimeException();
		java.lang.String foo = "foo";
		java.lang.String fooMsg = "foo; nested exception is: \n\t" + t;
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.RemoteException(), null, null);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.RemoteException(foo), foo, null);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.RemoteException(foo, t), fooMsg, t);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.activation.ActivationException(), null, null);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.activation.ActivationException(foo), foo, null);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.activation.ActivationException(foo, t), fooMsg, t);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.server.ServerCloneException(foo), foo, null);
		javaT.rmi.RemoteException.chaining.Chaining.test(new java.rmi.server.ServerCloneException(foo, t), fooMsg, t);
	}
}