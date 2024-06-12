public class MethodInvokerTest {
	public static void main(java.lang.String[] args) {
		com.alibaba.druid.pool.DruidDataSource ds = new com.alibaba.druid.pool.DruidDataSource();
		try {
			cn.ponfee.commons.base.Releasable.release(ds);
		} catch (java.lang.Exception e) {
		}
		try {
			cn.ponfee.commons.base.Initializable.init(ds);
		} catch (java.lang.Exception e) {
		}
		java.lang.System.out.println("\n\n\n\n==============================");
		try {
			java.lang.System.out.println(cn.ponfee.commons.base.Releasable.class.getMethod("release"));
		} catch (java.lang.Exception e) {
		}
		try {
			java.lang.System.out.println(cn.ponfee.commons.util.ObjectUtils.class.getMethod("uuid"));
		} catch (java.lang.Exception e) {
		}
		try {
			java.lang.System.out.println(cn.ponfee.commons.base.MethodInvokerTest.class.getMethod("toStr"));
		} catch (java.lang.Exception e) {
		}
		try {
			java.lang.System.out.println(cn.ponfee.commons.base.MethodInvokerTest.class.getMethod("toString"));
		} catch (java.lang.Exception e) {
		}
	}

	protected java.lang.String toStr() {
		return "";
	}
}