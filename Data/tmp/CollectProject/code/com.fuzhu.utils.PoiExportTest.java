public class PoiExportTest {
	public static void main(java.lang.String[] args) {
		com.fuzhu.utils.PoiExportTest.writeInExcel();
	}

	public static void writeInExcel() {
		java.util.List<java.lang.String> headList = new java.util.ArrayList<>();
		headList.add("专线类型");
		headList.add("业务类型");
		headList.add("工单标题");
		headList.add("工单号");
		headList.add("ESOP单号");
		headList.add("来源渠道");
		org.apache.poi.hssf.usermodel.HSSFWorkbook wkb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFSheet sheet = wkb.createSheet("工单信息表");
		sheet.setDefaultColumnWidth(((short) (15)));
		org.apache.poi.hssf.usermodel.HSSFCellStyle style = wkb.createCellStyle();
		org.apache.poi.hssf.usermodel.HSSFRow row = sheet.createRow(0);
		style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_CENTER);
		org.apache.poi.hssf.usermodel.HSSFCell cell = null;
		for (int i = 0; i < headList.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(headList.get(i));
			cell.setCellStyle(style);
		}
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> dataList = new java.util.ArrayList<>();
		for (int t = 0; t < 1000; t++) {
			java.util.Map<java.lang.String, java.lang.String> temp = new java.util.HashMap<>();
			temp.put("groupid", java.lang.String.valueOf(1 + t));
			temp.put("productcode", "abc" + java.lang.String.valueOf(1 + t));
			dataList.add(temp);
		}
		for (short i = 0; i < dataList.size(); i++) {
			row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(dataList.get(i).get("groupid"));
			row.createCell(1).setCellValue(dataList.get(i).get("productcode"));
		}
		try {
			java.io.FileOutputStream out = new java.io.FileOutputStream("E://工单信息表.xls");
			wkb.write(out);
			out.close();
			java.lang.System.out.println("导出成功!");
		} catch (java.io.FileNotFoundException e) {
			java.lang.System.out.println("导出失败!");
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
			java.lang.System.out.println("导出失败!");
		}
	}
}