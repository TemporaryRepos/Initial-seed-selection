public class EasyExcelUtils {
	public static void main(java.lang.String[] args) {
		java.lang.String[] headMap = new java.lang.String[]{ "项目名称", "楼栋名称", "单元名称", "楼层名称", "房间名称", "业主/租户姓名", "房间状态", "房间功能", "认证人数", "测试" };
		java.lang.String[] dataStrMap = new java.lang.String[]{ "hName", "bName", "uName", "fName", "pName", "cName", "pState", "pFunction", "pNum" };
		com.pancm.excel.NoModelWriteData d = new com.pancm.excel.NoModelWriteData();
		d.setFileName("认证统计");
		d.setHeadMap(headMap);
		d.setDataStrMap(dataStrMap);
		java.util.List<com.alibaba.fastjson.JSONObject> listDatas = new java.util.ArrayList<>();
		com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
		jsonObject.put("hName", "项目1");
		jsonObject.put("bName", "二楼");
		jsonObject.put("aa", "测试");
		d.setDataList(listDatas);
		com.pancm.excel.EasyExcelUtils easyExcelUtils = new com.pancm.excel.EasyExcelUtils();
	}

	public void jsonWrite(com.pancm.excel.NoModelWriteData data, javax.servlet.http.HttpServletResponse response) throws java.io.IOException {
		try {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setCharacterEncoding("utf-8");
			java.lang.String fileName = java.net.URLEncoder.encode(data.getFileName(), "UTF-8");
			response.setHeader("Content-disposition", ("attachment;filename=" + fileName) + ".xlsx");
			com.alibaba.excel.EasyExcel.write(response.getOutputStream()).head(head(data.getHeadMap())).sheet(data.getFileName()).doWrite(dataList(data.getDataList(), data.getDataStrMap()));
		} catch (java.lang.Exception e) {
			response.reset();
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			java.util.Map<java.lang.String, java.lang.String> map = new java.util.HashMap<java.lang.String, java.lang.String>();
			map.put("status", "failure");
			map.put("message", "下载文件失败" + e.getMessage());
			response.getWriter().println(com.alibaba.fastjson.JSON.toJSONString(map));
		}
	}

	public <T> void simpleWrite(com.pancm.excel.SimpleWriteData data, java.lang.Class<T> clazz, javax.servlet.http.HttpServletResponse response) throws java.io.IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setCharacterEncoding("utf-8");
		java.lang.String fileName = java.net.URLEncoder.encode(data.getFileName(), "UTF-8");
		response.setHeader("Content-disposition", ("attachment;filename=" + fileName) + ".xlsx");
		com.alibaba.excel.EasyExcel.write(response.getOutputStream(), clazz).sheet(data.getFileName()).doWrite(data.getDataList());
	}

	private java.util.List<java.util.List<java.lang.String>> head(java.lang.String[] headMap) {
		java.util.List<java.util.List<java.lang.String>> list = new java.util.ArrayList<java.util.List<java.lang.String>>();
		for (java.lang.String head : headMap) {
			java.util.List<java.lang.String> headList = new java.util.ArrayList<java.lang.String>();
			headList.add(head);
			list.add(headList);
		}
		return list;
	}

	private java.util.List<java.util.List<java.lang.Object>> dataList(java.util.List<com.alibaba.fastjson.JSONObject> dataList, java.lang.String[] dataStrMap) {
		java.util.List<java.util.List<java.lang.Object>> list = new java.util.ArrayList<java.util.List<java.lang.Object>>();
		for (com.alibaba.fastjson.JSONObject map : dataList) {
			java.util.List<java.lang.Object> data = new java.util.ArrayList<java.lang.Object>();
			for (int i = 0; i < dataStrMap.length; i++) {
				data.add(map.get(dataStrMap[i]));
			}
			list.add(data);
		}
		return list;
	}
}