public class IceJsonTest4 {
	public static void main(java.lang.String[] args) {
		zztest.User user = new zztest.User();
		user.setUsername("zs");
		user.setPassword("pass");
		user.setAge(18L);
		user.setBirthday(new java.util.Date());
		user.setPrice(3.14159265358);
		user.setCars(15);
		user.setEmpty(null);
		user.setSex(true);
		user.setCars(23);
		zztest.Product product = new zztest.Product();
		product.setName("素材");
		product.setCount(33);
		java.util.Map<java.lang.String, java.lang.String> table = new java.util.HashMap<java.lang.String, java.lang.String>();
		table.put("aaa", "bbb");
		table.put("eee", "fff");
		table.put("ggg", "hhh");
		product.setTable(table);
		user.setProduct(product);
		zztest.Product product1 = new zztest.Product();
		product1.setName("素材");
		product1.setCount(33);
		zztest.Product product2 = new zztest.Product();
		product2.setName("测试");
		product2.setCount(55);
		java.util.List<zztest.Product> listProduct = new java.util.ArrayList<zztest.Product>();
		listProduct.add(product1);
		listProduct.add(product2);
		user.setList2(listProduct);
		java.util.List<java.lang.String> listStr = new java.util.ArrayList<java.lang.String>();
		listStr.add("zzz");
		listStr.add("rrr");
		listStr.add("ttt");
		listStr.add("yyy");
		user.setList1(listStr);
		java.lang.String json = null;
		json = com.icexxx.util.IceJsonUtil.format(listStr);
		java.lang.System.out.println(json);
	}
}