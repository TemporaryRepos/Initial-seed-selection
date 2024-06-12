public class FileUtil {
	public java.lang.String getFileExt(java.lang.String s) {
		java.lang.String s1 = new java.lang.String();
		int i = 0;
		int j = 0;
		if (s == null) {
			return null;
		}
		i = s.lastIndexOf(46) + 1;
		j = s.length();
		s1 = s.substring(i, j);
		if (s.lastIndexOf(46) > 0) {
			return s1.toLowerCase();
		} else {
			return "";
		}
	}

	private java.lang.String getNameWithoutExtension(java.lang.String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	public boolean isImgFile(java.lang.String file) {
		if (com.megagao.production.ssm.util.UtilFuns.isNotEmpty(file)) {
			java.lang.String s1 = "." + this.getFileExt(file);
			if (".jpg.jpeg.bmp.gif.png".indexOf(s1) > (-1)) {
				return true;
			}
		}
		return false;
	}

	public java.lang.String getFileName(java.lang.String s) {
		try {
			s = s.replaceAll("/", "\\\\");
			int fileIndex = s.lastIndexOf("\\") + 1;
			return s.substring(fileIndex, s.length());
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public java.lang.String getFilePath(java.lang.String s) {
		try {
			s = s.replaceAll("/", "\\\\");
			int fileIndex = s.lastIndexOf("\\");
			return s.substring(0, fileIndex);
		} catch (java.lang.Exception e) {
			return "";
		}
	}

	public java.lang.String newFile(java.lang.String sPath, java.lang.String sFile) {
		java.lang.String newFileName = new java.lang.String();
		java.lang.String withoutExt = new java.lang.String();
		java.io.File curFile = new java.io.File((sPath + "\\") + sFile);
		if (curFile.exists()) {
			for (int counter = 1; curFile.exists(); counter++) {
				withoutExt = this.getNameWithoutExtension(curFile.getName());
				if (withoutExt.endsWith((counter - 1) + ")")) {
					withoutExt = withoutExt.substring(0, withoutExt.indexOf("("));
				}
				newFileName = ((((withoutExt + "(") + counter) + ")") + ".") + getFileExt(curFile.getName());
				curFile = new java.io.File((sPath + "\\") + newFileName);
			}
		} else {
			newFileName = curFile.getName();
		}
		return newFileName;
	}

	public static synchronized void clearDir(java.lang.String dir_path) throws java.io.FileNotFoundException {
		java.io.File file = new java.io.File(dir_path);
		if (!file.exists()) {
			throw new java.io.FileNotFoundException();
		}
		if (file.isDirectory()) {
			java.io.File[] fe = file.listFiles();
			for (int i = 0; i < fe.length; i++) {
				com.megagao.production.ssm.util.FileUtil.deleteFiles(fe[i].toString());
				fe[i].delete();
			}
		}
	}

	public static synchronized void deleteDir(java.lang.String dir_path) throws java.io.FileNotFoundException, java.io.IOException {
		com.megagao.production.ssm.util.FileUtil.deleteDir(new java.io.File(dir_path));
	}

	public static synchronized void deleteDir(java.io.File f) throws java.io.FileNotFoundException, java.io.IOException {
		if (!f.exists()) {
			throw new java.io.IOException("指定目录不存在:" + f.getName());
		}
		boolean rslt = true;
		if (!(rslt = f.delete())) {
			java.io.File[] subs = f.listFiles();
			for (int i = 0; i <= (subs.length - 1); i++) {
				if (subs[i].isDirectory()) {
					com.megagao.production.ssm.util.FileUtil.deleteDir(subs[i]);
				}
				rslt = subs[i].delete();
			}
			rslt = f.delete();
		}
	}

	public static synchronized void makeDir(java.lang.String dirPath) throws java.io.FileNotFoundException {
		java.lang.String s = "";
		dirPath = dirPath.replaceAll("\\t", "/t");
		dirPath = dirPath.replaceAll("\\\\", "/");
		java.lang.String[] aPath = dirPath.split("/");
		for (int i = 0; i < aPath.length; i++) {
			s = (s + aPath[i]) + "/";
			java.io.File d = new java.io.File(s);
			if (!d.exists()) {
				d.mkdir();
			}
		}
	}

	public static synchronized void rename(java.lang.String sOld, java.lang.String sNew) throws java.io.FileNotFoundException {
		boolean b = false;
		java.io.File d = new java.io.File(sOld);
		if (d.exists()) {
			b = d.renameTo(new java.io.File(sNew));
		}
	}

	public static synchronized java.lang.String formulaDirName(java.lang.String dirName) {
		dirName = dirName.replaceAll("/", "\\\\");
		return dirName;
	}

	public static synchronized java.lang.String formulaPath(java.lang.String dirName) {
		dirName = dirName.replaceAll("\\\\", "/");
		return dirName;
	}

	public static synchronized java.lang.String lastDir(java.lang.String dir_path) {
		if (dir_path.trim().compareTo("") == 0) {
			return "";
		} else {
			int i = (dir_path.lastIndexOf("\\") > dir_path.lastIndexOf("/")) ? dir_path.lastIndexOf("\\") : dir_path.lastIndexOf("/");
			if (i > 0) {
				return dir_path.substring(i);
			} else {
				return "";
			}
		}
	}

	public static void deleteFile(java.lang.String FileName) {
		java.io.File f2 = new java.io.File(FileName);
		f2.delete();
		f2 = null;
	}

	public static boolean deleteFiles(java.lang.String dir) {
		if ((dir == null) || "".equals(dir)) {
			return true;
		}
		java.io.File f0 = new java.io.File(dir);
		if (!f0.isDirectory()) {
			return false;
		}
		java.io.File[] files = f0.listFiles();
		boolean status = true;
		for (int i = 0; i < files.length; i++) {
			java.io.File f = files[i];
			if (!f.isFile()) {
				continue;
			}
			boolean b = f.delete();
			status = status && b;
		}
		return status;
	}

	public static boolean deleteFiles(java.lang.String path, java.lang.String[] files) {
		if ((path == null) || (files == null)) {
			return true;
		}
		boolean status = true;
		for (int i = 0; i < files.length; i++) {
			java.io.File f = new java.io.File(path, files[i]);
			if (!f.isFile()) {
				continue;
			}
			boolean b = f.delete();
			status = status && b;
		}
		return status;
	}

	public static boolean deleteFiles(java.util.List files) {
		if ((files == null) || (files.size() <= 0)) {
			return true;
		}
		java.lang.String fileName = "";
		boolean status = true;
		for (int i = 0; i < files.size(); i++) {
			fileName = ((java.lang.String) (files.get(i)));
			java.io.File f = new java.io.File(fileName);
			if (!f.isFile()) {
				continue;
			}
			boolean b = f.delete();
			status = status && b;
		}
		return status;
	}

	public static void fileToOutputStream(java.io.File f, java.io.OutputStream os) throws java.io.IOException {
		java.io.InputStream is = new java.io.BufferedInputStream(new java.io.FileInputStream(f));
		byte[] barr = new byte[1024];
		int count;
		while (true) {
			count = is.read(barr);
			if (count == (-1)) {
				break;
			}
			os.write(barr, 0, count);
		} 
		is.close();
		return;
	}

	public java.util.List<java.lang.String> readTxtFile(java.lang.String sFile) {
		java.lang.String str = "";
		java.util.List<java.lang.String> sList = new java.util.ArrayList<java.lang.String>();
		try {
			java.io.FileReader fr = new java.io.FileReader(sFile);
			java.io.BufferedReader bfr = new java.io.BufferedReader(fr);
			while ((str = bfr.readLine()) != null) {
				sList.add(str);
			} 
			fr.close();
		} catch (java.io.IOException ex) {
			java.lang.System.out.println("readTxtFile IOException Error." + ex.getMessage());
		} catch (java.lang.Exception ex) {
			java.lang.System.out.println("readTxtFile Exception Error." + ex.getMessage());
		}
		return sList;
	}

	public java.lang.String WriteTxt(java.lang.String sPath, java.lang.String sFile, java.lang.String sContent) {
		java.lang.String s = "";
		java.io.File d = new java.io.File(sPath);
		if (!d.exists()) {
			d.mkdir();
		}
		try {
			java.io.FileWriter fw = new java.io.FileWriter((sPath + "\\") + sFile, true);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			bfw.write(sContent);
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			s = "WriteTxt IOException Error.";
		} catch (java.lang.Exception ex) {
			s = "WriteTxt Exception Error.";
		}
		return s;
	}

	public java.lang.String createTxt(java.lang.String sPathFile, java.lang.String sContent) throws java.io.FileNotFoundException {
		java.lang.String s = "";
		java.lang.String sPath = this.getFilePath(sPathFile);
		java.lang.String sFile = this.getFileName(sPathFile);
		java.io.File d = new java.io.File(sPath);
		if (!d.exists()) {
			this.makeDir(sPath);
		}
		try {
			java.io.FileWriter fw = new java.io.FileWriter((sPath + "\\") + sFile, false);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			bfw.write(sContent);
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			s = "createTxt IOException Error.";
		} catch (java.lang.Exception ex) {
			s = "createTxt Exception Error.";
		}
		return s;
	}

	public java.lang.String createTxt(java.lang.String sPath, java.lang.String sFile, java.lang.String sContent) throws java.io.FileNotFoundException {
		java.lang.String s = "";
		java.io.File d = new java.io.File(sPath);
		if (!d.exists()) {
			this.makeDir(sPath);
		}
		try {
			java.io.FileWriter fw = new java.io.FileWriter((sPath + "\\") + sFile, false);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			bfw.write(sContent);
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			s = "createTxt IOException Error.";
		} catch (java.lang.Exception ex) {
			s = "createTxt Exception Error.";
		}
		return s;
	}

	public java.lang.String createTxt(java.lang.String sPath, java.lang.String sFile, java.lang.String sContent, java.lang.String enCoding) throws java.io.FileNotFoundException {
		java.lang.String s = "";
		java.io.File d = new java.io.File(sPath);
		if (!d.exists()) {
			this.makeDir(sPath);
		}
		try {
			java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(new java.io.FileOutputStream((sPath + "\\") + sFile), enCoding);
			out.write(sContent);
			out.flush();
			out.close();
		} catch (java.io.IOException ex) {
			s = "createTxt IOException Error.";
		} catch (java.lang.Exception ex) {
			s = "createTxt Exception Error.";
		}
		return s;
	}

	public java.lang.String newTxt(java.lang.String sPath, java.lang.String sFile, java.lang.String sContent, java.lang.String enCoding) throws java.io.FileNotFoundException {
		java.lang.String s = "";
		java.io.File d = new java.io.File(sPath);
		if (!d.exists()) {
			this.makeDir(sPath);
		}
		try {
			java.io.OutputStreamWriter out = new java.io.OutputStreamWriter(new java.io.FileOutputStream((sPath + "\\") + sFile, false), enCoding);
			out.write(sContent);
			out.flush();
			out.close();
		} catch (java.io.IOException ex) {
			s = "createTxt IOException Error.";
		} catch (java.lang.Exception ex) {
			s = "createTxt Exception Error.";
		}
		return s;
	}

	public java.lang.String WriteTxt(java.lang.String sFile, java.lang.String[] aTitle, java.lang.String[] aContent, java.lang.String sSplitFlag, int iColumns) {
		java.lang.String sMsg = "";
		long lTime = java.lang.System.currentTimeMillis();
		try {
			if (aTitle != null) {
				if (aTitle.length != iColumns) {
					throw new java.lang.Exception("Title Length is not right!");
				}
			}
			java.io.File f = new java.io.File(sFile);
			if (f.exists()) {
				f.delete();
			}
			java.io.FileWriter fw = new java.io.FileWriter(sFile, true);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			if (aTitle != null) {
				for (int i = 0; i < aTitle.length; i++) {
					bfw.write(aTitle[i] + sSplitFlag);
				}
				bfw.newLine();
			}
			for (int i = 0; i < aContent.length; i++) {
				bfw.write(aContent[i] + sSplitFlag);
				if (((i + 1) % iColumns) == 0) {
					bfw.newLine();
				}
			}
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			sMsg = "WriteTxt IOException Error." + ex.getMessage();
		} catch (java.lang.Exception ex) {
			sMsg = "WriteTxt Exception Error." + ex.getMessage();
		}
		return sMsg;
	}

	public java.lang.String WriteXML(java.lang.String sFile, java.lang.String indent, java.lang.String root, java.lang.String[] aTrunk, java.lang.String[] aLeaf, java.lang.String[] aContent) {
		int i = 0;
		int j = 0;
		int k = 0;
		java.lang.String sIndent = "";
		java.lang.String[] aTrunkSuffix = new java.lang.String[aTrunk.length];
		java.lang.String[] aLeafSuffix = new java.lang.String[aLeaf.length];
		java.lang.String sMsg = "";
		long lTime = java.lang.System.currentTimeMillis();
		try {
			java.io.File f = new java.io.File(sFile);
			if (f.exists()) {
				f.delete();
			}
			for (i = 0; i < aTrunk.length; i++) {
				for (j = 0; j < i; j++) {
					sIndent = indent + sIndent;
				}
				aTrunk[i] = ((sIndent + "<") + aTrunk[i]) + ">";
				aTrunkSuffix[i] = aTrunk[i].replaceFirst("<", "</");
			}
			sIndent = indent + sIndent;
			for (i = 0; i < aLeaf.length; i++) {
				aLeafSuffix[i] = ("</" + aLeaf[i]) + ">";
				aLeaf[i] = ((sIndent + "<") + aLeaf[i]) + ">";
			}
			java.io.FileWriter fw = new java.io.FileWriter(sFile, true);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			bfw.write("<?xml version=\"1.0\" ?>");
			bfw.newLine();
			if (root.length() > 0) {
				bfw.write(("<" + root) + ">");
				bfw.newLine();
			}
			while (k < aContent.length) {
				for (i = 0; i < aTrunk.length; i++) {
					bfw.write(aTrunk[i]);
					bfw.newLine();
				}
				for (i = 0; i < aLeaf.length; i++) {
					bfw.write((aLeaf[i] + aContent[k++]) + aLeafSuffix[i]);
					bfw.newLine();
				}
				for (i = aTrunkSuffix.length - 1; i > (-1); i--) {
					bfw.write(aTrunkSuffix[i]);
					bfw.newLine();
				}
			} 
			if (root.length() > 0) {
				bfw.write(("</" + root) + ">");
				bfw.newLine();
			}
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			sMsg = (this.getClass().getName() + " WriteXML IOException Error.") + ex.getMessage();
		} catch (java.lang.Exception ex) {
			sMsg = (this.getClass().getName() + " WriteXML Exception Error.") + ex.getMessage();
		}
		return sMsg;
	}

	public java.util.ArrayList CreateXML(java.lang.String StartIndent, java.lang.String indent, java.lang.String[] aTrunk, java.lang.String[] aLeaf, java.lang.String[] aContent) {
		java.util.ArrayList aList = new java.util.ArrayList();
		int i = 0;
		int j = 0;
		int k = 0;
		java.lang.String sIndent = StartIndent;
		java.lang.String[] aTrunkSuffix = new java.lang.String[aTrunk.length];
		java.lang.String[] aLeafSuffix = new java.lang.String[aLeaf.length];
		java.lang.String sMsg = "";
		long lTime = java.lang.System.currentTimeMillis();
		try {
			for (i = 0; i < aTrunk.length; i++) {
				for (j = 0; j < i; j++) {
					sIndent = indent + sIndent;
				}
				aTrunk[i] = ((sIndent + "<") + aTrunk[i]) + ">";
				aTrunkSuffix[i] = aTrunk[i].replaceFirst("<", "</");
			}
			sIndent = indent + sIndent;
			for (i = 0; i < aLeaf.length; i++) {
				aLeafSuffix[i] = ("</" + aLeaf[i]) + ">";
				aLeaf[i] = ((sIndent + "<") + aLeaf[i]) + ">";
			}
			while (k < aContent.length) {
				for (i = 0; i < aTrunk.length; i++) {
					aList.add(aTrunk[i]);
				}
				for (i = 0; i < aLeaf.length; i++) {
					aList.add((aLeaf[i] + aContent[k++]) + aLeafSuffix[i]);
				}
				for (i = aTrunkSuffix.length - 1; i > (-1); i--) {
					aList.add(aTrunkSuffix[i]);
				}
			} 
			return aList;
		} catch (java.lang.Exception ex) {
			sMsg = (this.getClass().getName() + " CreateXML Exception Error.") + ex.getMessage();
		}
		return null;
	}

	public java.lang.String WriteXML(java.lang.String sFile, java.lang.String sXmlVer, java.lang.String root, java.util.ArrayList aList) {
		java.lang.String sMsg = "";
		long lTime = java.lang.System.currentTimeMillis();
		try {
			java.io.File f = new java.io.File(sFile);
			if (f.exists()) {
				f.delete();
			}
			java.io.FileWriter fw = new java.io.FileWriter(sFile, true);
			java.io.BufferedWriter bfw = new java.io.BufferedWriter(fw);
			bfw.write(("<?" + sXmlVer) + "?>");
			bfw.newLine();
			if (root.length() > 0) {
				bfw.write(("<" + root) + ">");
				bfw.newLine();
			}
			for (int i = 0; i < aList.size(); i++) {
				bfw.write(((java.lang.String) (aList.get(i))));
				bfw.newLine();
			}
			if (root.length() > 0) {
				bfw.write(("</" + root.substring(0, root.indexOf(" "))) + ">");
			}
			bfw.flush();
			fw.close();
		} catch (java.io.IOException ex) {
			sMsg = (this.getClass().getName() + " WriteXML IOException Error.") + ex.getMessage();
		} catch (java.lang.Exception ex) {
			sMsg = (this.getClass().getName() + " WriteXML Exception Error.") + ex.getMessage();
		}
		return sMsg;
	}

	public boolean isExist(java.lang.String filename) {
		try {
			java.io.File file = new java.io.File(filename);
			if (!file.exists()) {
				return false;
			} else {
				return true;
			}
		} catch (java.lang.Exception e) {
			return false;
		}
	}

	public boolean isAbsolutePath(java.lang.String path) {
		if (path.indexOf(":") > 0) {
			return true;
		}
		return false;
	}

	public void copyFile(java.lang.String srcFile, java.lang.String destFile) throws java.io.FileNotFoundException, java.io.IOException {
		java.io.FileInputStream fis = new java.io.FileInputStream(srcFile);
		java.io.FileOutputStream fos = new java.io.FileOutputStream(destFile);
		java.nio.channels.FileChannel fcin = fis.getChannel();
		java.nio.channels.FileChannel fcout = fos.getChannel();
		fcin.transferTo(0, fcin.size(), fcout);
		fcin.close();
		fcout.close();
		fis.close();
		fos.close();
	}

	public boolean copyFileIgnore(java.lang.String file1, java.lang.String file2) {
		try {
			java.io.File file_in = new java.io.File(file1);
			java.io.File file_out = new java.io.File(file2);
			java.io.FileInputStream in1 = new java.io.FileInputStream(file_in);
			java.io.FileOutputStream out1 = new java.io.FileOutputStream(file_out);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = in1.read(bytes)) != (-1)) {
				out1.write(bytes, 0, c);
			} 
			in1.close();
			out1.close();
			return true;
		} catch (java.lang.Exception e) {
			return false;
		}
	}

	public void copyDir(java.lang.String dir1, java.lang.String dir2) throws java.io.FileNotFoundException, java.io.IOException {
		new java.io.File(dir2).mkdir();
		java.io.File[] file = new java.io.File(dir1).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].getName().compareTo("Thumbs.db") != 0) {
				if (file[i].isFile()) {
					copyFile((dir1 + "\\") + file[i].getName(), (dir2 + "\\") + file[i].getName());
				} else if (file[i].isDirectory()) {
					copyDir((dir1 + "\\") + file[i].getName(), (dir2 + "\\") + file[i].getName());
				}
			}
		}
	}

	public void copyDirectory(java.lang.String srcDirectory, java.lang.String destDirectory) throws java.io.FileNotFoundException, java.io.IOException {
		java.io.File srcDir = new java.io.File(srcDirectory);
		java.io.File[] fileList = srcDir.listFiles();
		if (fileList == null) {
			throw new java.io.FileNotFoundException();
		}
		new java.io.File(destDirectory).mkdir();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				java.io.File descDir = new java.io.File(destDirectory);
				if (!descDir.exists()) {
					descDir.mkdir();
				}
				if (fileList[i].getName().compareTo("Thumbs.db") != 0) {
					copyFile((srcDirectory + "/") + fileList[i].getName(), (destDirectory + "/") + fileList[i].getName());
				}
			} else {
				java.io.File subDir = new java.io.File((destDirectory + "/") + fileList[i].getName());
				if (!subDir.exists()) {
					subDir.mkdir();
				}
				copyDirectory((srcDirectory + "/") + fileList[i].getName(), (destDirectory + "/") + fileList[i].getName());
			}
		}
	}

	public java.util.List fileList(java.lang.String dir) {
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			if (!files[i].isDirectory()) {
				list.add(files[i]);
			}
		}
		return list;
	}

	public java.util.List fileList(java.lang.String dir, java.lang.String prefix) {
		com.megagao.production.ssm.util.FormatStyle formatStyle = new com.megagao.production.ssm.util.FormatStyle();
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			if (!files[i].isDirectory()) {
				list.add(java.lang.String.valueOf(files[i]).substring(prefix.length()));
				list.add(formatStyle.fileSize(java.lang.String.valueOf(files[i].length())));
			}
		}
		return list;
	}

	public java.util.List<java.lang.String> fileList(java.lang.String dir, java.lang.String prefix, java.lang.String suffix) {
		com.megagao.production.ssm.util.FormatStyle formatStyle = new com.megagao.production.ssm.util.FormatStyle();
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List _list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			if (!files[i].isDirectory()) {
				if (files[i].getName().startsWith(prefix) && files[i].getName().endsWith(suffix)) {
					_list.add((dir + "/") + files[i].getName());
				}
			}
		}
		return _list;
	}

	public java.util.List fileDir(java.lang.String dir) {
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			if (files[i].isDirectory()) {
				list.add(files[i]);
			}
		}
		return list;
	}

	public java.util.List fileDir(java.lang.String dir, java.lang.String prefix) {
		com.megagao.production.ssm.util.FormatStyle formatStyle = new com.megagao.production.ssm.util.FormatStyle();
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			if (files[i].isDirectory()) {
				list.add(java.lang.String.valueOf(files[i]).substring(prefix.length()));
				list.add(java.lang.String.valueOf(files[i].listFiles().length));
			}
		}
		return list;
	}

	public java.util.List dirfileList(java.lang.String dir) {
		java.io.File f = new java.io.File(dir);
		java.io.File[] files = f.listFiles();
		if (files == null) {
			return null;
		}
		int count = files.length;
		java.util.List list = new java.util.ArrayList(count);
		for (int i = 0; i < count; i++) {
			list.add(files[i]);
		}
		return list;
	}

	public boolean moveFile(java.lang.String srcFile, java.lang.String destPath) {
		java.io.File file = new java.io.File(srcFile);
		java.io.File dir = new java.io.File(destPath);
		boolean success = file.renameTo(new java.io.File(dir, file.getName()));
		return success;
	}

	public static void main(java.lang.String[] args) throws java.io.IOException {
		com.megagao.production.ssm.util.FileUtil fu = new com.megagao.production.ssm.util.FileUtil();
		fu.rename("c:\\t", "c:\\a");
	}
}