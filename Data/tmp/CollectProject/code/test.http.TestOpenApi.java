@java.lang.SuppressWarnings("unchecked")
public class TestOpenApi {
	java.lang.String host = "http://10.202.64.167:8080";

	@org.junit.Test
	public void test1() {
		java.lang.String username = "rnT2s9YMKGHkannrr-kNFSZYk-XOLBRKIIjnY62szVR0E31j8SQx50cym_KVXT5m1yjzcHUHh-M8g24q-oHnPa-MgaNaKR8IK-TUa9I9S9Vo8Xseg25EjgrvONK2X4ahKbSBHqrJfyIrPmE7rO70XHnhhma5HtLLXVukhY7eVJk";
		java.lang.String passowrd = "m6bZQrh72pkbBXBmvA-OoSSYRDDtht4mnH4c9VZ77dPnE6qbD8mMJPC_1Wn6Dhr28IfkSv2o3bS44zraBVZ0b-wxMRJ9meZ9i7Vvkwab2uL-eJOvYQ25xjHbdEinsdEyb7rMq0u8Flw9_KqmojEPQVJvSQyV_fJFin8Ns6p_li4";
		java.lang.Object data = com.google.common.collect.ImmutableMap.of("head", com.google.common.collect.ImmutableMap.of("app_id", "FQ", "trans_id", cn.ponfee.commons.util.ObjectUtils.uuid22()), "body", com.google.common.collect.ImmutableMap.of("username", username, "password", passowrd));
		java.lang.String resp = cn.ponfee.commons.http.Http.post(host + "/open/api/auth").contentType(ContentType.APPLICATION_JSON, "UTF-8").data(Jsons.NORMAL.string(data)).accept(ContentType.APPLICATION_JSON).request();
		java.lang.System.out.println(resp);
	}

	@org.junit.Test
	public void test2() {
		java.lang.Object data = com.google.common.collect.ImmutableMap.of("head", com.google.common.collect.ImmutableMap.of("app_id", "FQ", "trans_id", cn.ponfee.commons.util.ObjectUtils.uuid22()), "body", com.google.common.collect.ImmutableMap.of("username", "rnT2s9YMKGHkannrr-kNFSZYk-XOLBRKIIjnY62szVR0E31j8SQx50cym_KVXT5m1yjzcHUHh-M8g24q-oHnPa-MgaNaKR8IK-TUa9I9S9Vo8Xseg25EjgrvONK2X4ahKbSBHqrJfyIrPmE7rO70XHnhhma5HtLLXVukhY7eVJk"));
		java.util.Map<java.lang.String, java.lang.Object> resp = cn.ponfee.commons.http.Http.post(host + "/open/api/userinfo").contentType(ContentType.APPLICATION_JSON, "UTF-8").data(Jsons.NORMAL.string(data)).accept(ContentType.APPLICATION_JSON).request(java.util.Map.class);
		java.lang.System.out.println(resp);
	}

	@org.junit.Test
	public void test3() {
		java.lang.System.out.println(cn.ponfee.commons.http.Http.post((host + "/open/api/test?a=1=32=14=12=4=3214=2&abcdef&") + java.lang.Math.random()).request());
	}

	public static void main(java.lang.String[] args) {
		java.lang.String captcha = "1234";
		long number = new java.util.Random(captcha.hashCode()).nextLong();
		java.lang.System.out.println(number);
		java.lang.System.out.println(captcha.hashCode());
		number = cn.ponfee.commons.util.Bytes.crc32(cn.ponfee.commons.util.Bytes.toBytes(captcha.hashCode()));
		java.lang.System.out.println(number);
	}
}