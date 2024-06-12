public class RMRBParse {
	public static void main(java.lang.String[] args) {
		try (final java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("train_file/corpus/rmrb.txt")));final java.io.BufferedOutputStream fos = new java.io.BufferedOutputStream(new java.io.FileOutputStream("train_file/corpus/rmrb_new.txt"))) {
			java.lang.String line = null;
			java.lang.StringBuilder sb = null;
			int skip = 0;
			while ((line = br.readLine()) != null) {
				sb = org.ansj.RMRBParse.parseLine(line);
				java.lang.String str = sb.toString();
				if (str.contains("[") || str.contains("]")) {
					java.lang.System.out.println(skip++);
					continue;
				}
				fos.write(str.getBytes());
				fos.write("\n".getBytes());
			} 
			fos.flush();
			fos.close();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static java.lang.StringBuilder parseLine(java.lang.String line) {
		java.lang.StringBuilder sb = null;
		java.lang.String[] strs = line.split("  ");
		sb = new java.lang.StringBuilder();
		java.lang.String word = null;
		for (int i = 0; i < strs.length; i++) {
			java.lang.String[] split = strs[i].split("\\/");
			word = split[0];
			if ((((word.length() == 1) && (split.length == 2)) && split[1].startsWith("nr")) && (i != (strs.length - 1))) {
				sb.append(word);
				split = strs[++i].split("\\/");
				if ((split.length == 2) && split[1].startsWith("nr")) {
					sb.append(split[0] + "/nr");
				} else {
					sb.append("/nr");
				}
				sb.append("\t");
				continue;
			}
			if (word.startsWith("[")) {
				word = word.replace("[", "");
				sb.append(word);
				if (strs[i].contains("]")) {
					sb.append("\t");
					continue;
				}
				word = strs[++i];
				while (!word.contains("]")) {
					sb.append(word.split("\\/")[0]);
					word = strs[++i];
				} 
				sb.append((word.split("\\/")[0] + "/nt") + "\t");
			} else if (split.length == 1) {
				java.lang.System.out.println(strs[i]);
				sb.append("[");
			} else {
				sb.append(((word + "/") + split[1]) + "\t");
			}
		}
		return sb;
	}
}