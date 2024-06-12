public class XLSX2CSV {
	private class SheetToCSV implements org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler {
		private boolean firstCellOfRow;

		private int currentRow = -1;

		private int currentCol = -1;

		private void outputMissingRows(int number) {
			for (int i = 0; i < number; i++) {
				for (int j = 0; j < minColumns; j++) {
					output.append(',');
				}
				output.append('\n');
			}
		}

		@java.lang.Override
		public void startRow(int rowNum) {
			outputMissingRows((rowNum - currentRow) - 1);
			firstCellOfRow = true;
			currentRow = rowNum;
			currentCol = -1;
		}

		@java.lang.Override
		public void endRow(int rowNum) {
			for (int i = currentCol; i < minColumns; i++) {
				output.append(',');
			}
			output.append('\n');
		}

		@java.lang.Override
		public void cell(java.lang.String cellReference, java.lang.String formattedValue, org.apache.poi.xssf.usermodel.XSSFComment comment) {
			if (firstCellOfRow) {
				firstCellOfRow = false;
			} else {
				output.append(',');
			}
			if (cellReference == null) {
				cellReference = new org.apache.poi.ss.util.CellAddress(currentRow, currentCol).formatAsString();
			}
			int thisCol = new org.apache.poi.ss.util.CellReference(cellReference).getCol();
			int missedCols = (thisCol - currentCol) - 1;
			for (int i = 0; i < missedCols; i++) {
				output.append(',');
			}
			currentCol = thisCol;
			try {
				java.lang.Double.parseDouble(formattedValue);
				output.append(formattedValue);
			} catch (java.lang.NumberFormatException e) {
				output.append('"');
				output.append(formattedValue);
				output.append('"');
			}
		}
	}

	private final org.apache.poi.openxml4j.opc.OPCPackage xlsxPackage;

	private final int minColumns;

	private final java.io.PrintStream output;

	public XLSX2CSV(org.apache.poi.openxml4j.opc.OPCPackage pkg, java.io.PrintStream output, int minColumns) {
		this.xlsxPackage = pkg;
		this.output = output;
		this.minColumns = minColumns;
	}

	public void processSheet(org.apache.poi.xssf.model.Styles styles, org.apache.poi.xssf.model.SharedStrings strings, org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler sheetHandler, java.io.InputStream sheetInputStream) throws java.io.IOException, org.xml.sax.SAXException {
		org.apache.poi.ss.usermodel.DataFormatter formatter = new org.apache.poi.ss.usermodel.DataFormatter();
		org.xml.sax.InputSource sheetSource = new org.xml.sax.InputSource(sheetInputStream);
		try {
			org.xml.sax.XMLReader sheetParser = org.apache.poi.ooxml.util.SAXHelper.newXMLReader();
			org.xml.sax.ContentHandler handler = new org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler(styles, null, strings, sheetHandler, formatter, false);
			sheetParser.setContentHandler(handler);
			sheetParser.parse(sheetSource);
		} catch (javax.xml.parsers.ParserConfigurationException e) {
			throw new java.lang.RuntimeException("SAX parser appears to be broken - " + e.getMessage());
		}
	}

	public void process() throws java.io.IOException, org.apache.poi.openxml4j.exceptions.OpenXML4JException, org.xml.sax.SAXException {
		org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable strings = new org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable(this.xlsxPackage);
		org.apache.poi.xssf.eventusermodel.XSSFReader xssfReader = new org.apache.poi.xssf.eventusermodel.XSSFReader(this.xlsxPackage);
		org.apache.poi.xssf.model.StylesTable styles = xssfReader.getStylesTable();
		org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator iter = ((org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator) (xssfReader.getSheetsData()));
		int index = 0;
		while (iter.hasNext()) {
			try (final java.io.InputStream stream = iter.next()) {
				java.lang.String sheetName = iter.getSheetName();
				this.output.println();
				this.output.println(((sheetName + " [index=") + index) + "]:");
				processSheet(styles, strings, new test.extract.XLSX2CSV.SheetToCSV(), stream);
			}
			++index;
		} 
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.io.File xlsxFile = new java.io.File("d:/test/test_excel_3.xlsx");
		if (!xlsxFile.exists()) {
			java.lang.System.err.println("Not found or not a file: " + xlsxFile.getPath());
			return;
		}
		int minColumns = -1;
		if (args.length >= 2) {
			minColumns = java.lang.Integer.parseInt(args[1]);
		}
		try (final org.apache.poi.openxml4j.opc.OPCPackage p = org.apache.poi.openxml4j.opc.OPCPackage.open(xlsxFile.getPath(), org.apache.poi.openxml4j.opc.PackageAccess.READ)) {
			test.extract.XLSX2CSV xlsx2csv = new test.extract.XLSX2CSV(p, java.lang.System.out, minColumns);
			xlsx2csv.process();
		}
	}
}