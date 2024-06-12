public class Main {
	public static void main(java.lang.String[] args) {
		com.alibaba.json.bvtVO.Page<com.alibaba.json.bvtVO.Bean> page = new com.alibaba.json.bvtVO.Page<com.alibaba.json.bvtVO.Bean>();
		page.setCount(1);
		java.util.List<com.alibaba.json.bvtVO.Bean> items = new java.util.ArrayList<com.alibaba.json.bvtVO.Bean>();
		com.alibaba.json.bvtVO.Bean item = new com.alibaba.json.bvtVO.Bean();
		item.setId(1);
		item.setName("name");
		item.setDesc("desc");
		items.add(item);
		page.setItems(items);
		java.lang.String json = com.alibaba.fastjson.JSON.toJSONString(page);
		com.alibaba.json.bvtVO.Page<com.alibaba.json.bvtVO.Bean> jsonPage = com.alibaba.fastjson.JSON.parseObject(json, new com.alibaba.fastjson.TypeReference<com.alibaba.json.bvtVO.Page<com.alibaba.json.bvtVO.Bean>>() {});
		java.lang.System.out.println(jsonPage.getItems().get(0).getName());
	}
}