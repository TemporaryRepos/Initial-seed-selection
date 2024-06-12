public class BooleanPojoTest {
	private boolean success1;

	private boolean isSuccess2;

	private java.lang.Boolean success3;

	private java.lang.Boolean isSuccess4;

	public boolean isSuccess1() {
		return success1;
	}

	public void setSuccess1(boolean success1) {
		this.success1 = success1;
	}

	public boolean isSuccess2() {
		return isSuccess2;
	}

	public void setSuccess2(boolean success2) {
		isSuccess2 = success2;
	}

	public java.lang.Boolean getSuccess3() {
		return success3;
	}

	public void setSuccess3(java.lang.Boolean success3) {
		this.success3 = success3;
	}

	public java.lang.Boolean getSuccess4() {
		return isSuccess4;
	}

	public void setSuccess4(java.lang.Boolean success4) {
		isSuccess4 = success4;
	}

	public static void main(java.lang.String[] args) {
		cn.ponfee.commons.json.BooleanPojoTest pojo1 = new cn.ponfee.commons.json.BooleanPojoTest();
		pojo1.success1 = true;
		pojo1.success3 = false;
		java.lang.System.out.println(cn.ponfee.commons.json.Jsons.toJson(pojo1));
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(pojo1));
		java.lang.System.out.println("\n-------------");
		cn.ponfee.commons.json.BooleanPojoTest pojo2 = new cn.ponfee.commons.json.BooleanPojoTest();
		pojo2.success1 = false;
		pojo2.isSuccess4 = false;
		java.lang.System.out.println(cn.ponfee.commons.json.Jsons.toJson(pojo2));
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(pojo2));
		java.lang.System.out.println("\n-------------");
		cn.ponfee.commons.json.BooleanPojoTest pojo3 = new cn.ponfee.commons.json.BooleanPojoTest();
		pojo3.success1 = true;
		java.lang.System.out.println(cn.ponfee.commons.json.Jsons.toJson(pojo3));
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(pojo3));
		java.lang.System.out.println("\n-------------");
		cn.ponfee.commons.json.BooleanPojoTest pojo4 = new cn.ponfee.commons.json.BooleanPojoTest();
		pojo4.success1 = true;
		pojo4.success3 = false;
		pojo4.isSuccess4 = false;
		java.lang.System.out.println(cn.ponfee.commons.json.Jsons.toJson(pojo4));
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(pojo4));
		java.lang.System.out.println("\n-------------");
		java.lang.System.out.println(cn.ponfee.commons.json.Jsons.toJson(cn.ponfee.commons.model.Result.success()));
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(cn.ponfee.commons.model.Result.success()));
	}
}