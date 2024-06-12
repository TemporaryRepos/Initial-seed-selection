public class ExportBeanExcel<T> {
	public void exportExcel(java.lang.String title, java.util.List<java.lang.String> headersName, java.util.List<java.lang.String> headersId, java.util.List<T> dtoList) {
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
		java.util.Iterator<java.lang.String> it = c.iterator();
		short size = 0;
		while (it.hasNext()) {
			cell = row.createCell(size);
			cell.setCellValue(it.next().toString());
			cell.setCellStyle(style);
			size++;
		} 
		java.util.Collection zdC = titleFieldMap.values();
		java.util.Iterator<T> labIt = dtoList.iterator();
		int zdRow = 0;
		while (labIt.hasNext()) {
			int zdCell = 0;
			zdRow++;
			row = sheet.createRow(zdRow);
			T l = ((T) (labIt.next()));
			java.lang.reflect.Field[] fields = l.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				java.lang.reflect.Field field = fields[i];
				java.lang.String fieldName = field.getName();
				java.util.Iterator<java.lang.String> zdIt = zdC.iterator();
				while (zdIt.hasNext()) {
					if (zdIt.next().equals(fieldName)) {
						java.lang.String getMethodName = ("get" + fieldName.substring(0, 1).toUpperCase()) + fieldName.substring(1);
						java.lang.Class tCls = l.getClass();
						try {
							java.lang.reflect.Method getMethod = tCls.getMethod(getMethodName, new java.lang.Class[]{  });
							java.lang.Object val = getMethod.invoke(l, new java.lang.Object[]{  });
							java.lang.String textVal = null;
							if (val != null) {
								textVal = java.lang.String.valueOf(val);
							} else {
								textVal = null;
							}
							row.createCell(((short) (zdCell))).setCellValue(textVal);
							zdCell++;
						} catch (java.lang.SecurityException e) {
							e.printStackTrace();
						} catch (java.lang.IllegalArgumentException e) {
							e.printStackTrace();
						} catch (java.lang.NoSuchMethodException e) {
							e.printStackTrace();
						} catch (java.lang.IllegalAccessException e) {
							e.printStackTrace();
						} catch (java.lang.reflect.InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				} 
			}
		} 
		try {
			java.io.FileOutputStream exportXls = new java.io.FileOutputStream("E://工单信息表.xls");
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
		java.util.List<java.lang.String> headerId = new java.util.ArrayList<>();
		java.lang.reflect.Field[] fields = com.fuzhu.entity.Student.class.getDeclaredFields();
		int i = 0;
		while (i < fields.length) {
			java.lang.reflect.Field field = fields[i];
			java.lang.String fieldName = field.getName();
			java.lang.System.out.println(fieldName.toString());
			headerId.add(fieldName);
			i++;
		} 
		java.lang.System.out.println(headerId.toString());
	}
}