public class TestConstraint {
	@cn.ponfee.commons.constrain.Constraint(maxLen = 0)
	private java.lang.String s1;

	@cn.ponfee.commons.constrain.Constraint(minLen = 1)
	private java.lang.String s2;

	@cn.ponfee.commons.constrain.Constraint(tense = cn.ponfee.commons.constrain.Constraint.Tense.FUTURE)
	private java.util.Date date = new java.util.Date();

	@cn.ponfee.commons.constrain.Constraint(datePattern = "yyyy-MM-dd", tense = cn.ponfee.commons.constrain.Constraint.Tense.FUTURE)
	private java.lang.String d = "2016-05-01";

	public static void main(java.lang.String[] args) {
		test.constraint.TestConstraint t = new test.constraint.TestConstraint();
		t.s1 = "";
		t.s2 = "1";
		t.date = new java.util.Date(java.lang.System.currentTimeMillis() + 5000000);
		try {
			cn.ponfee.commons.constrain.FieldValidator.newInstance().constrain(t);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}