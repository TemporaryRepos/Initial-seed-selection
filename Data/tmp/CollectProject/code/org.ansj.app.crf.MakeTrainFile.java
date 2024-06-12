public class MakeTrainFile {
	private static final org.nlpcn.commons.lang.util.logging.Log logger = org.nlpcn.commons.lang.util.logging.LogFactory.getLog();

	public static void main(java.lang.String[] args) {
		java.lang.String inputPath = "corpus.txt";
		java.lang.String outputPath = "train.txt";
		if ((args != null) && (args.length == 2)) {
			inputPath = args[0];
			outputPath = args[1];
		}
		if (org.nlpcn.commons.lang.util.StringUtil.isBlank(inputPath) || org.nlpcn.commons.lang.util.StringUtil.isBlank(outputPath)) {
			org.ansj.app.crf.MakeTrainFile.logger.info("org.ansj.app.crf.MakeTrainFile [inputPath] [outputPath]");
			return;
		}
		try (final java.io.BufferedReader reader = org.nlpcn.commons.lang.util.IOUtil.getReader(inputPath, "utf-8");final java.io.FileOutputStream fos = new java.io.FileOutputStream(outputPath)) {
			java.lang.String temp = null;
			int i = 0;
			while ((temp = reader.readLine()) != null) {
				java.lang.StringBuilder sb = new java.lang.StringBuilder("\n");
				if (org.nlpcn.commons.lang.util.StringUtil.isBlank(temp)) {
					continue;
				}
				if (i == 0) {
					temp = org.nlpcn.commons.lang.util.StringUtil.trim(temp);
				}
				java.util.List<org.ansj.app.crf.pojo.Element> list = org.ansj.app.crf.Config.makeToElementList(temp, "\\s+");
				for (org.ansj.app.crf.pojo.Element element : list) {
					sb.append((element.nameStr() + " ") + org.ansj.app.crf.Config.getTagName(element.getTag()));
					sb.append("\n");
				}
				fos.write(sb.toString().getBytes(org.nlpcn.commons.lang.util.IOUtil.UTF8));
				java.lang.System.out.println(++i);
			} 
		} catch (java.io.FileNotFoundException e) {
			org.ansj.app.crf.MakeTrainFile.logger.warn("文件没有找到", e);
		} catch (java.io.IOException e) {
			org.ansj.app.crf.MakeTrainFile.logger.warn("IO异常", e);
		}
	}
}