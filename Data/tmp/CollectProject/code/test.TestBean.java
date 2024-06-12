public class TestBean implements java.io.Serializable {
	static final int MAXIMUM_CAPACITY = 1 << 30;

	private static final long serialVersionUID = 1716190333294826147L;

	@cn.ponfee.commons.constrain.Constraint(tense = Constraint.Tense.FUTURE)
	private int i;

	private java.lang.Long l;

	private java.lang.String s;

	private java.lang.String str;

	public TestBean() {
	}

	public TestBean(int i, java.lang.Long l, java.lang.String s) {
		super();
		this.i = i;
		this.l = l;
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public java.lang.Long getL() {
		return l;
	}

	public void setL(java.lang.Long l) {
		this.l = l;
	}

	public java.lang.String getS() {
		return s;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return ((((("Bean [i=" + i) + ", l=") + l) + ", s=") + s) + "]";
	}

	public void setS(java.lang.String s) {
		this.s = s;
	}

	public java.lang.String getStr() {
		return str;
	}

	public void setStr(java.lang.String str) {
		this.str = str;
	}

	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return n < 0 ? 1 : n >= test.TestBean.MAXIMUM_CAPACITY ? test.TestBean.MAXIMUM_CAPACITY : n + 1;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(test.TestBean.tableSizeFor(9));
		java.lang.System.out.println(test.TestBean.MAXIMUM_CAPACITY);
	}
}