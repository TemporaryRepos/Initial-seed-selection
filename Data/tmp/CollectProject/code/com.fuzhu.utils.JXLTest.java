public class JXLTest {
	public static void main(java.lang.String[] args) {
		com.fuzhu.utils.JXLTest.writeInExcel();
	}

	public static void writeInExcel() {
		java.util.List<java.lang.String> headList = new java.util.ArrayList<>();
		headList.add("专线类型");
		headList.add("业务类型");
		headList.add("工单标题");
		headList.add("工单号");
		headList.add("ESOP单号");
		headList.add("来源渠道");
		java.lang.String basePath = java.lang.Thread.currentThread().getContextClassLoader().getResource("").getPath();
		basePath = org.apache.commons.lang3.StringUtils.substringBeforeLast(basePath, "/");
		basePath = org.apache.commons.lang3.StringUtils.substringBeforeLast(basePath, "/");
		basePath = org.apache.commons.lang3.StringUtils.substringBeforeLast(basePath, "/");
		basePath = basePath + "/src/main/webapp/source/";
		java.io.File templateFile = new java.io.File(basePath + "commonexport.xls");
		java.lang.String resultFilePath = basePath + "导出的文件名.xls";
		java.io.File resultFile = new java.io.File(resultFilePath);
		jxl.Workbook wb = null;
		jxl.WorkbookSettings settings = new jxl.WorkbookSettings();
		settings.setWriteAccess(null);
		jxl.write.WritableWorkbook wwb = null;
		try {
			wb = jxl.Workbook.getWorkbook(templateFile);
			wwb = jxl.Workbook.createWorkbook(resultFile, wb, settings);
			jxl.write.WritableSheet sheet = wwb.createSheet("Sheet1", 0);
			for (int i = 0; i < headList.size(); i++) {
				jxl.write.Label la = new jxl.write.Label(i, 0, wb.getSheet(0).getCell(i, 0).getContents());
				sheet.addCell(la);
			}
			java.util.List<java.util.Map<java.lang.String, java.lang.String>> dataList = new java.util.ArrayList<>();
			sheet.setRowView(0, 300);
			for (int t = 0; t < 1000; t++) {
				java.util.Map<java.lang.String, java.lang.String> temp = new java.util.HashMap<>();
				temp.put("groupid", java.lang.String.valueOf(1 + t));
				temp.put("productcode", "abc" + java.lang.String.valueOf(1 + t));
				dataList.add(temp);
			}
			for (int i = 0; i < dataList.size(); i++) {
				java.util.Map<java.lang.String, java.lang.String> map = dataList.get(i);
				jxl.write.Label C1 = new jxl.write.Label(0, i + 1, map.get("groupid"));
				jxl.write.Label C3 = new jxl.write.Label(2, i + 1, map.get("productcode"));
				sheet.addCell(C1);
				sheet.addCell(C3);
			}
			wwb.write();
			wwb.close();
			wb.close();
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
}