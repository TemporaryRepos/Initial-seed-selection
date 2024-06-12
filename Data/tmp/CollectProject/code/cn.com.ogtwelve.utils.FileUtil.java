public class FileUtil {
	public static int Video = 0;

	public static int Pic = 1;

	public static int Share = 2;

	public static java.lang.String[] pictype = new java.lang.String[]{ ".gif", ".jpg", ".jpeg", ".bmp" };

	public static java.lang.String[] videotype = new java.lang.String[]{ ".rm", ".ram", ".rmvb", ".wmv", ".mp3", ".wav", ".avi", ".swf", ".asf", ".mov", ".ra", ".mpg", ".mpeg", ".mpe" };

	public static java.lang.String[] sharefiletype = new java.lang.String[]{ ".zip", ".rar", ".exe", ".doc", ".ppt", ".bmp", ".gif", ".jpg", ".jpeg", ".rm", ".ram", ".rmvb", ".wmv", ".mp3", ".wav", ".avi", ".swf", ".asf", ".mov", ".ra", ".mpg", ".mpeg", ".mpe", ".ppt", ".xsl", ".swf", ".html", ".txt", ".xls" };

	public FileUtil() {
	}

	public static java.lang.String getFilePhysicalLocation(long userid) {
		java.lang.String uploadPath = "";
		uploadPath = "uploadfiles/album/";
		java.lang.String[] dirs = new java.lang.String[3];
		for (int i = 1; i < 4; i++) {
			long temp = ((long) (userid / java.lang.Math.pow(10, i)));
			dirs[i - 1] = new java.lang.Long(temp % 10).toString();
		}
		try {
			java.lang.String root = null;
			try {
				java.net.URL url = cn.com.ogtwelve.utils.FileUtil.class.getResource("/");
				java.io.File classDir = new java.io.File(url.getPath());
				java.io.File f = new java.io.File(classDir.getParent());
				java.io.File f1 = new java.io.File(f.getParent());
				root = f1.getAbsolutePath();
			} catch (java.lang.Exception e) {
			}
			root = java.net.URLDecoder.decode(root, "UTF-8");
			java.io.File dir = new java.io.File((((((((root + java.lang.System.getProperty("file.separator")) + uploadPath) + java.lang.System.getProperty("file.separator")) + dirs[2]) + java.lang.System.getProperty("file.separator")) + dirs[1]) + java.lang.System.getProperty("file.separator")) + dirs[0]);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			java.lang.String tempdir = dir.toString();
			int i = tempdir.indexOf("uploadfiles");
			tempdir = tempdir.substring(i);
			tempdir = tempdir.replace('\\', '/');
			return tempdir;
		} catch (java.lang.Exception e) {
		}
		return null;
	}

	public static java.lang.String getFilePhysicalLocation(long userid, java.lang.String uploadPath) {
		java.lang.String[] dirs = new java.lang.String[3];
		for (int i = 1; i < 4; i++) {
			long temp = ((long) (userid / java.lang.Math.pow(10, i)));
			dirs[i - 1] = new java.lang.Long(temp % 10).toString();
		}
		try {
			java.lang.String root = null;
			try {
				java.net.URL url = cn.com.ogtwelve.utils.FileUtil.class.getResource("/");
				java.io.File classDir = new java.io.File(url.getPath());
				java.io.File f = new java.io.File(classDir.getParent());
				java.io.File f1 = new java.io.File(f.getParent());
				root = f1.getAbsolutePath();
			} catch (java.lang.Exception e) {
			}
			root = java.net.URLDecoder.decode(root, "UTF-8");
			java.io.File dir = new java.io.File((((((((root + java.lang.System.getProperty("file.separator")) + uploadPath) + java.lang.System.getProperty("file.separator")) + dirs[2]) + java.lang.System.getProperty("file.separator")) + dirs[1]) + java.lang.System.getProperty("file.separator")) + dirs[0]);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			java.lang.String tempdir = dir.toString();
			int i = tempdir.indexOf("uploadfiles");
			tempdir = tempdir.substring(i);
			tempdir = tempdir.replace('\\', '/');
			return tempdir;
		} catch (java.lang.Exception e) {
		}
		return null;
	}

	public static void Create_dir(java.lang.String path) throws java.lang.Exception {
		java.io.File dirName = new java.io.File(path);
		if (dirName.exists()) {
			dirName.delete();
		}
		dirName.mkdirs();
	}

	public static java.io.File Create_file(java.lang.String path, java.lang.String filename) throws java.lang.Exception {
		java.io.File fileName = new java.io.File(path, filename);
		if (fileName.exists()) {
			fileName.delete();
		}
		fileName.createNewFile();
		return fileName;
	}

	public static void Write_file(java.lang.String str, java.io.File file, boolean overwrite) throws java.lang.Exception {
		java.io.FileWriter fw = new java.io.FileWriter(file, !overwrite);
		fw.write(str);
		fw.close();
	}

	public static void Delete_dir(java.lang.String path) throws java.lang.Exception {
		java.io.File dirName = new java.io.File(path);
		if (dirName.exists()) {
			dirName.delete();
		}
	}

	public static boolean Deldir(java.lang.String vpath) {
		java.lang.String pathName = "";
		try {
			pathName = vpath;
			java.io.File delPath = new java.io.File(pathName);
			if (delPath.exists()) {
				java.lang.String[] strList;
				strList = delPath.list();
				for (int i = 0; i < strList.length; i++) {
					java.lang.String fileTree = (pathName + "/") + strList[i];
					java.io.File turePath = new java.io.File(delPath.getPath(), strList[i]);
					boolean isdir = turePath.isDirectory();
					if (isdir) {
						boolean reDir = cn.com.ogtwelve.utils.FileUtil.Deldir(turePath.getPath());
					} else {
						boolean reBool = turePath.delete();
					}
				}
				boolean rBool = delPath.delete();
				return true;
			}
		} catch (java.lang.Exception e) {
			return false;
		}
		return false;
	}

	public java.lang.String getFileTypeImg(java.lang.String filename) {
		java.lang.String str = "00.gif";
		if ((filename == null) || (filename.trim().length() < 5)) {
			str = "00.gif";
		} else {
			filename = filename.trim();
			filename = filename.substring(filename.length() - 4, filename.length());
			filename = filename.toLowerCase();
			if (filename.equals(".txt")) {
				str = "txt.gif";
			} else if (filename.equals(".xml")) {
				str = "xml.gif";
			} else if (filename.equals(".xsl") || filename.equals("xslt")) {
				str = "xsl.gif";
			} else if (filename.equals(".doc")) {
				str = "doc.gif";
			} else if (filename.equals(".css")) {
				str = "css.gif";
			} else if (filename.equals(".htm") || filename.equals("html")) {
				str = "htm.gif";
			} else if (filename.equals(".gif")) {
				str = "gif.gif";
			} else if (filename.equals(".jpg") || filename.equals("jpeg")) {
				str = "jpg.gif";
			} else if (filename.equals(".psd")) {
				str = "psd.gif";
			} else if (filename.equals(".mid")) {
				str = "mid.gif";
			} else if (filename.equals(".wav")) {
				str = "wav.gif";
			} else if (filename.equals(".avi")) {
				str = "avi.gif";
			} else if (filename.equals(".rar")) {
				str = "rar.gif";
			} else if (filename.equals(".zip")) {
				str = "zip.gif";
			} else {
				str = "00.gif";
			}
			filename = filename.substring(filename.length() - 3, filename.length());
			if (filename.equals(".js")) {
				str = "js.gif";
			}
		}
		return str;
	}

	public static void Delete_file(java.lang.String path) throws java.lang.Exception {
		java.io.File fileName = new java.io.File(path);
		if (fileName.exists()) {
			fileName.delete();
		}
	}

	public static java.lang.String[] List_files(java.lang.String dirpath) throws java.lang.Exception {
		java.io.File file = new java.io.File(dirpath);
		java.io.File[] files = file.listFiles();
		java.lang.String[] fileslist = new java.lang.String[files.length];
		for (int i = 0; i < files.length; i++) {
			java.lang.String NewsFileName = files[i].getName();
			fileslist[i] = (dirpath + "\\") + NewsFileName;
		}
		return fileslist;
	}

	public static boolean copy(java.lang.String from, java.lang.String to) {
		try {
			to = cn.com.ogtwelve.utils.FileUtil.replace(to, " \\", "/ <file://\\> ");
			java.lang.String toPath = to.substring(0, to.lastIndexOf("/"));
			java.io.File f = new java.io.File(toPath);
			if (!f.exists()) {
				f.mkdirs();
			}
			java.io.BufferedInputStream bin = new java.io.BufferedInputStream(new java.io.FileInputStream(from));
			java.io.BufferedOutputStream bout = new java.io.BufferedOutputStream(new java.io.FileOutputStream(to));
			int c;
			while ((c = bin.read()) != (-1)) {
				bout.write(c);
			} 
			bin.close();
			bout.close();
			return true;
		} catch (java.lang.Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static long downloadHTTP(java.lang.String srcHttpFile, java.lang.String destFile, long fileSize) {
		srcHttpFile = srcHttpFile.replaceAll("\\\\", "/");
		destFile = destFile.replaceAll("\\\\", "/");
		long bytesum = 0;
		int byteread = 0;
		java.io.InputStream is = null;
		java.io.RandomAccessFile raf = null;
		java.net.HttpURLConnection httpConnection = null;
		try {
			srcHttpFile = java.net.URLEncoder.encode(srcHttpFile, "UTF-8");
			srcHttpFile = srcHttpFile.replaceAll("%3A", ":").replaceAll("%2F", "/");
			java.net.URL url = new java.net.URL(srcHttpFile);
			httpConnection = ((java.net.HttpURLConnection) (url.openConnection()));
			httpConnection.setRequestProperty("User-Agent", "NetFox");
			java.lang.String sProperty = ("bytes=" + fileSize) + "-";
			httpConnection.setRequestProperty("RANGE", sProperty);
			is = httpConnection.getInputStream();
			raf = new java.io.RandomAccessFile(destFile, "rw");
			raf.seek(fileSize);
			byte[] buffer = new byte[1204 * 100];
			while ((byteread = is.read(buffer)) != (-1)) {
				bytesum += byteread;
				raf.write(buffer, 0, byteread);
			} 
		} catch (java.io.FileNotFoundException e) {
			return 0;
		} catch (java.io.IOException e) {
			return 0;
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
				if (is != null) {
					is.close();
				}
				if (httpConnection != null) {
					httpConnection.disconnect();
				}
			} catch (java.io.IOException e) {
				return 0;
			}
		}
		return bytesum;
	}

	public static long copyAndEncrypt(java.lang.String from, java.lang.String to) {
		java.io.FileInputStream bin = null;
		java.io.FileOutputStream bout = null;
		try {
			java.lang.String fileName = cn.com.ogtwelve.utils.FileUtil.getFileName(to);
			java.security.SecureRandom sr = new java.security.SecureRandom();
			java.security.Key privateKey = cn.com.ogtwelve.utils.FileUtil.getKey(fileName);
			javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			javax.crypto.spec.IvParameterSpec spec = new javax.crypto.spec.IvParameterSpec(privateKey.getEncoded());
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, privateKey, spec, sr);
			java.io.File f = new java.io.File(to);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			bin = new java.io.FileInputStream(from);
			bout = new java.io.FileOutputStream(to);
			int c = 0;
			long result = 0;
			byte[] d;
			byte[] bytes = new byte[1024];
			while ((c = bin.read(bytes)) != (-1)) {
				result += c;
				if (c != 1040) {
					d = new byte[c];
					for (int i = 0; i < c; i++) {
						d[i] = bytes[i];
					}
					bout.write(cipher.doFinal(d));
				} else {
					bout.write(cipher.doFinal(bytes));
				}
			} 
			return result;
		} catch (java.lang.Exception e) {
			return 0;
		} finally {
			try {
				if (bin != null) {
					bin.close();
				}
				if (bout != null) {
					bout.close();
				}
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static java.lang.String replace(java.lang.String srcStr, java.lang.String oldStr, java.lang.String newStr) {
		int i = srcStr.indexOf(oldStr);
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		if (i == (-1)) {
			return srcStr;
		}
		sb.append(srcStr.substring(0, i) + newStr);
		if ((i + oldStr.length()) < srcStr.length()) {
			sb.append(cn.com.ogtwelve.utils.FileUtil.replace(srcStr.substring(i + oldStr.length(), srcStr.length()), oldStr, newStr));
		}
		return sb.toString();
	}

	public static void MoveFile(java.lang.String from, java.lang.String to) throws java.lang.Exception {
		boolean ok = cn.com.ogtwelve.utils.FileUtil.copy(from, to);
		if (ok) {
			cn.com.ogtwelve.utils.FileUtil.Delete_file(from);
		}
	}

	public static long getFileSize(java.io.File f) {
		long size = 0;
		java.io.FileInputStream fis = null;
		try {
			fis = new java.io.FileInputStream(f);
			size = fis.available();
			fis.close();
			return size;
		} catch (java.lang.Exception e) {
			return 0;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (java.io.IOException e) {
					return size;
				}
			}
		}
	}

	private static javax.crypto.SecretKey getKey(java.lang.String strKey) {
		try {
			javax.crypto.KeyGenerator _generator = javax.crypto.KeyGenerator.getInstance("AES");
			java.security.SecureRandom secureRandom = java.security.SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(strKey.getBytes());
			_generator.init(128, secureRandom);
			return _generator.generateKey();
		} catch (java.lang.Exception e) {
			throw new java.lang.RuntimeException("初始化密钥出现异常");
		}
	}

	public static long fileChannelCopy(java.io.File inFile, java.io.File outFile) throws java.lang.Exception {
		java.io.FileInputStream fin = new java.io.FileInputStream(inFile);
		java.io.FileOutputStream fout = new java.io.FileOutputStream(outFile);
		java.nio.channels.FileChannel inc = fin.getChannel();
		java.nio.channels.FileChannel outc = fout.getChannel();
		int bufferLen = 2097152;
		java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocateDirect(bufferLen);
		while (true) {
			int ret = inc.read(bb);
			if (ret == (-1)) {
				fin.close();
				fout.flush();
				fout.close();
				break;
			}
			bb.flip();
			outc.write(bb);
			bb.clear();
		} 
		return inFile.length();
	}

	public static java.lang.String getFileName(java.lang.String filePath) {
		if ((filePath != null) && (!filePath.isEmpty())) {
			if (filePath.lastIndexOf('\\') > filePath.lastIndexOf('/')) {
				filePath = filePath.substring(filePath.lastIndexOf('\\') + 1);
			} else {
				filePath = filePath.substring(filePath.lastIndexOf('/') + 1);
			}
		}
		return filePath;
	}

	public static java.lang.String getFilePath(java.lang.String filePath) {
		if (filePath.isEmpty()) {
			return null;
		}
		java.lang.String fileName = cn.com.ogtwelve.utils.FileUtil.getFileName(filePath);
		return filePath.replace(fileName, "");
	}

	public static java.lang.String getParentFilePath(java.lang.String filePath) {
		if (filePath.isEmpty()) {
			return null;
		}
		java.lang.String fileName = cn.com.ogtwelve.utils.FileUtil.getFileName(filePath);
		filePath = filePath.replace(fileName, "");
		filePath = filePath.substring(0, filePath.length() - 1);
		java.lang.String szParentFilePath = cn.com.ogtwelve.utils.FileUtil.getFileName(filePath);
		return szParentFilePath;
	}

	public static java.util.List<java.io.File> iteratorFile(java.io.File rootFile, java.lang.String fileRegex) {
		if (!rootFile.exists()) {
			return null;
		}
		java.util.List<java.io.File> fileList = new java.util.ArrayList<java.io.File>();
		if (rootFile.isDirectory()) {
			java.io.File[] fileArr = rootFile.listFiles();
			for (java.io.File file : fileArr) {
				fileList.addAll(cn.com.ogtwelve.utils.FileUtil.iteratorFile(file, fileRegex));
			}
		} else if (fileRegex == null) {
			fileList.add(rootFile);
		} else if (rootFile.getName().matches(fileRegex)) {
			fileList.add(rootFile);
		}
		return fileList;
	}

	public static java.util.List<java.io.File> iteratorDirectory(java.io.File rootFile, java.lang.String fileRegex) {
		if ((!rootFile.exists()) || (!rootFile.isDirectory())) {
			return null;
		}
		java.util.List<java.io.File> fileList = new java.util.ArrayList<java.io.File>();
		if (rootFile.getName().matches(fileRegex)) {
			fileList.add(rootFile);
		} else {
			java.io.File[] fileArr = rootFile.listFiles();
			for (java.io.File file : fileArr) {
				fileList.addAll(cn.com.ogtwelve.utils.FileUtil.iteratorFile(file, fileRegex));
			}
		}
		return fileList;
	}

	public static boolean readFileRecode(java.lang.String fileDb, java.lang.String keyword) {
		boolean result = false;
		java.io.File file = new java.io.File(fileDb);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			if (file.isFile() && file.exists()) {
				java.io.InputStreamReader read = new java.io.InputStreamReader(new java.io.FileInputStream(file), "GBK");
				java.io.BufferedReader bufferedReader = new java.io.BufferedReader(read);
				java.lang.String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (lineTxt.equals(keyword)) {
						result = true;
					}
				} 
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		try {
			cn.com.ogtwelve.utils.FileUtil.Write_file("%%%%%%%%%%%%%%%%%%%aa\r\n", new java.io.File("D:\\China_XjRaster_Code1.txt"), true);
		} catch (java.lang.Exception e) {
		}
	}
}