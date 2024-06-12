public class MapToObjTest {
	public static class A {
		private int a_b;

		private java.lang.String str;

		private cn.ponfee.commons.jce.DigestAlgorithms mode;

		public A() {
		}

		public A(int a_b, java.lang.String str) {
			super();
			this.a_b = a_b;
			this.str = str;
		}

		public int getA_b() {
			return a_b;
		}

		public void setA_b(int a_b) {
			this.a_b = a_b;
		}

		public java.lang.String getStr() {
			return str;
		}

		public void setStr(java.lang.String str) {
			this.str = str;
		}

		public cn.ponfee.commons.jce.DigestAlgorithms getMode() {
			return mode;
		}

		public void setMode(cn.ponfee.commons.jce.DigestAlgorithms mode) {
			this.mode = mode;
		}

		@java.lang.Override
		public java.lang.String toString() {
			return ((((("A [a_b=" + a_b) + ", str=") + str) + ", mode=") + (mode == null ? "null" : mode.name())) + "]";
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_HYPHEN.to(com.google.common.base.CaseFormat.LOWER_CAMEL, "test-data"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_UNDERSCORE.to(com.google.common.base.CaseFormat.LOWER_CAMEL, "test_data"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.UPPER_UNDERSCORE.to(com.google.common.base.CaseFormat.UPPER_CAMEL, "test_data"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_CAMEL.to(com.google.common.base.CaseFormat.LOWER_UNDERSCORE, "testdata"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_CAMEL.to(com.google.common.base.CaseFormat.LOWER_UNDERSCORE, "TestData"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_CAMEL.to(com.google.common.base.CaseFormat.LOWER_UNDERSCORE, "testData"));
		java.lang.System.out.println(com.google.common.base.CaseFormat.LOWER_CAMEL.to(com.google.common.base.CaseFormat.LOWER_HYPHEN, "testData"));
		test.utils.MapToObjTest.A a = new test.utils.MapToObjTest.A(1, "aaa");
		a = BeanMaps.PROPS.toBean(com.google.common.collect.ImmutableMap.of("aB", 123, "str", "abc", "mode", "RipeMD128"), test.utils.MapToObjTest.A.class);
		java.lang.System.out.println(a);
		java.lang.System.out.println(BeanMaps.PROPS.toMap(a));
	}
}