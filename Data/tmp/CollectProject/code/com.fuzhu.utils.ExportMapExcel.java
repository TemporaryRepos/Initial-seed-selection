public class ExportMapExcel {
	public void exportExcel(java.lang.String title, java.util.List<java.lang.String> headersName, java.util.List<java.lang.String> headersId, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> dtoList) {
		java.util.Map<java.lang.Integer, java.lang.String> headersNameMap = new java.util.HashMap<>();
		int key = 0;
		for (int i = 0; i < headersName.size(); i++) {
			if (!headersName.get(i).equals(null)) {
				headersNameMap.put(key, headersName.get(i));
				key++;
			}
		}
		java.util.Map<java.lang.Integer, java.lang.String> titleFieldMap = new java.util.HashMap<>();
		int value = 0;
		for (int i = 0; i < headersId.size(); i++) {
			if (!headersId.get(i).equals(null)) {
				titleFieldMap.put(value, headersId.get(i));
				value++;
			}
		}
		org.apache.poi.hssf.usermodel.HSSFWorkbook wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFSheet sheet = wb.createSheet(title);
		sheet.setDefaultColumnWidth(((short) (15)));
		org.apache.poi.hssf.usermodel.HSSFCellStyle style = wb.createCellStyle();
		org.apache.poi.hssf.usermodel.HSSFRow row = sheet.createRow(0);
		style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_CENTER);
		org.apache.poi.hssf.usermodel.HSSFCell cell;
		java.util.Collection c = headersNameMap.values();
		java.util.Iterator<java.lang.String> headersNameIt = c.iterator();
		short size = 0;
		while (headersNameIt.hasNext()) {
			cell = row.createCell(size);
			cell.setCellValue(headersNameIt.next().toString());
			cell.setCellStyle(style);
			size++;
		} 
		java.util.Collection zdC = titleFieldMap.values();
		java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> titleFieldIt = dtoList.iterator();
		int zdRow = 1;
		while (titleFieldIt.hasNext()) {
			java.util.Map<java.lang.String, java.lang.Object> mapTemp = titleFieldIt.next();
			row = sheet.createRow(zdRow);
			zdRow++;
			int zdCell = 0;
			java.util.Iterator<java.lang.String> zdIt = zdC.iterator();
			while (zdIt.hasNext()) {
				java.lang.String tempField = zdIt.next();
				if (mapTemp.get(tempField) != null) {
					row.createCell(((short) (zdCell))).setCellValue(java.lang.String.valueOf(mapTemp.get(tempField)));
					zdCell++;
				}
			} 
		} 
		try {
			java.io.FileOutputStream exportXls = new java.io.FileOutputStream("E://工单信息表Map.xls");
			wb.write(exportXls);
			exportXls.close();
			java.lang.System.out.println("导出成功!");
		} catch (java.io.FileNotFoundException e) {
			java.lang.System.out.println("导出失败!");
			e.printStackTrace();
		} catch (java.io.IOException e) {
			java.lang.System.out.println("导出失败!");
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> listName = new java.util.ArrayList<>();
		listName.add("id");
		listName.add("名字");
		listName.add("性别");
		java.util.List<java.lang.String> listId = new java.util.ArrayList<>();
		listId.add("id");
		listId.add("name");
		listId.add("sex");
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> listB = new java.util.ArrayList<>();
		for (int t = 0; t < 6; t++) {
			java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
			map.put("id", t);
			map.put("name", "abc" + t);
			map.put("sex", "男" + t);
			listB.add(map);
		}
		java.lang.System.out.println("listB  : " + listB.toString());
		com.fuzhu.utils.ExportMapExcel exportExcelUtil = new com.fuzhu.utils.ExportMapExcel();
		exportExcelUtil.exportExcel("测试POI导出EXCEL文档", listName, listId, listB);
	}
}