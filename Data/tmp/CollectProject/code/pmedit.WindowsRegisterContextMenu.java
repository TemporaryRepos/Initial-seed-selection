public class WindowsRegisterContextMenu {
	public static java.lang.String exePath() throws java.lang.Exception {
		java.lang.String thisJarDir;
		try {
			thisJarDir = new java.io.File(pmedit.PreferencesWindow.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getAbsolutePath();
		} catch (java.net.URISyntaxException e) {
			throw new java.lang.Exception("Cannot find the path to current jar");
		}
		java.lang.String paths = "";
		java.lang.String appName = pmedit.Version.getAppName();
		java.lang.String exePath = ((thisJarDir + java.io.File.separator) + appName) + ".exe";
		if (new java.io.File(exePath).exists()) {
			return exePath;
		}
		paths += exePath;
		exePath = (((thisJarDir + java.io.File.separator) + "..\\") + appName) + ".exe";
		if (new java.io.File(exePath).exists()) {
			return exePath;
		}
		paths += " , ";
		paths += exePath;
		throw new java.lang.Exception("Cannot find the path to current exe, tried: " + paths);
	}

	public static java.lang.String pdfFileType(boolean create) {
		java.lang.String pdfFileType = null;
		if (false) {
		} else if (pmedit.WindowsRegisterContextMenu.hasRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Classes\\.pdf")) {
			pdfFileType = com.sun.jna.platform.win32.Advapi32Util.registryGetStringValue(com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Classes\\.pdf", "");
		} else if (pmedit.WindowsRegisterContextMenu.hasRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Classes\\.pdf")) {
			pdfFileType = com.sun.jna.platform.win32.Advapi32Util.registryGetStringValue(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Classes\\.pdf", "");
		} else if (create) {
			pdfFileType = "pdffiletype";
			com.sun.jna.platform.win32.Advapi32Util.registryCreateKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Classes", ".pdf");
			pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, "SOFTWARE\\Classes\\.pdf", "", pdfFileType);
		}
		return pdfFileType;
	}

	public static java.lang.String applicationKey() {
		return "SOFTWARE\\Classes\\" + pmedit.Version.getAppName();
	}

	public static java.lang.String editCmdShellKey(java.lang.String pdfFileType) {
		return ((("SOFTWARE\\Classes\\" + pdfFileType) + "\\shell\\") + pmedit.Version.getAppName()) + ".Edit.File";
	}

	public static java.lang.String batchMenuShellKey(java.lang.String pdfFileType) {
		return ((("SOFTWARE\\Classes\\" + pdfFileType) + "\\shell\\") + pmedit.Version.getAppName()) + ".Batch.Menu";
	}

	public static java.lang.String batchMenuKey(java.lang.String pdfFileType) {
		return ("SOFTWARE\\Classes\\" + pdfFileType) + "\\Batch.Menu";
	}

	public static java.lang.String batchCmdShellKey(java.lang.String pdfFileType) {
		return pmedit.WindowsRegisterContextMenu.batchMenuKey(pdfFileType) + "\\shell";
	}

	public static void createRegistryKey(java.lang.String keyToCreate) {
		java.lang.String[] keys = keyToCreate.split("\\\\");
		java.lang.String current = "";
		for (java.lang.String key : keys) {
			current += key;
			if (!com.sun.jna.platform.win32.Advapi32Util.registryKeyExists(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, current)) {
				com.sun.jna.platform.win32.Advapi32Util.registryCreateKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, current);
			}
			current += "\\";
		}
	}

	public static boolean hasRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY root, java.lang.String keyToCreate) {
		java.lang.String[] keys = keyToCreate.split("\\\\");
		java.lang.String current = "";
		for (java.lang.String key : keys) {
			current += key;
			if (!com.sun.jna.platform.win32.Advapi32Util.registryKeyExists(root, current)) {
				return false;
			}
			current += "\\";
		}
		current = current.substring(0, current.length() - 1);
		return com.sun.jna.platform.win32.Advapi32Util.registryValueExists(root, current, "");
	}

	public static void setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY root, java.lang.String keyPath, java.lang.String name, java.lang.String value) {
		java.lang.System.out.println((((("Registry Create: " + keyPath) + "(") + name) + ")=") + value);
		try {
			com.sun.jna.platform.win32.Advapi32Util.registrySetStringValue(root, keyPath, name, value);
		} catch (com.sun.jna.platform.win32.Win32Exception e) {
			java.lang.System.out.println(e);
		}
	}

	public static void deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY root, java.lang.String key) {
		java.lang.System.out.println("Registry Delete: " + key);
		try {
			com.sun.jna.platform.win32.Advapi32Util.registryDeleteKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, key);
		} catch (com.sun.jna.platform.win32.Win32Exception e) {
			java.lang.System.out.println(e);
		}
	}

	public static void register() throws java.lang.Exception {
		java.lang.String pdfFileType = pmedit.WindowsRegisterContextMenu.pdfFileType(true);
		java.lang.String exePath = ("\"" + pmedit.WindowsRegisterContextMenu.exePath()) + "\"";
		java.lang.String shellKey = pmedit.WindowsRegisterContextMenu.editCmdShellKey(pdfFileType);
		java.lang.String shellCommandKey = shellKey + "\\command";
		java.lang.String shellDdeExecKey = shellKey + "\\ddeexec";
		java.lang.String shellDdeExecApplicationKey = shellDdeExecKey + "\\application";
		pmedit.WindowsRegisterContextMenu.createRegistryKey(shellCommandKey);
		pmedit.WindowsRegisterContextMenu.createRegistryKey(shellDdeExecKey);
		pmedit.WindowsRegisterContextMenu.createRegistryKey(shellDdeExecApplicationKey);
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellKey, "", "Pdf metadata editor");
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellCommandKey, "", exePath);
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellDdeExecKey, "", "\"%1\"");
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellDdeExecApplicationKey, "", pmedit.Version.getAppName());
		java.lang.String batchMenuShellKey = pmedit.WindowsRegisterContextMenu.batchMenuShellKey(pdfFileType);
		pmedit.WindowsRegisterContextMenu.createRegistryKey(batchMenuShellKey);
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchMenuShellKey, "MUIVerb", "Pdf metadata batch");
		pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchMenuShellKey, "ExtendedSubCommandsKey", pdfFileType + "\\Batch.Menu");
		for (pmedit.CommandDescription desc : pmedit.CommandDescription.batchCommands) {
			java.lang.String batchShellKey = (pmedit.WindowsRegisterContextMenu.batchCmdShellKey(pdfFileType) + "\\") + desc.regKey;
			java.lang.String batchShellCommandKey = batchShellKey + "\\command";
			java.lang.String batchShellDdeExecKey = batchShellKey + "\\ddeexec";
			java.lang.String batchShellDdeExecApplicationKey = batchShellKey + "\\application";
			pmedit.WindowsRegisterContextMenu.createRegistryKey(batchShellCommandKey);
			pmedit.WindowsRegisterContextMenu.createRegistryKey(batchShellDdeExecKey);
			pmedit.WindowsRegisterContextMenu.createRegistryKey(batchShellDdeExecApplicationKey);
			pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellKey, "MUIVerb", desc.description);
			pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellCommandKey, "", (exePath + " ") + desc.name);
			pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellDdeExecKey, "", desc.name + " \"%1\"");
			pmedit.WindowsRegisterContextMenu.setRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellDdeExecApplicationKey, "", pmedit.Version.getAppName());
		}
	}

	public static void unregister() {
		java.lang.String pdfFileType = pmedit.WindowsRegisterContextMenu.pdfFileType(false);
		if (pdfFileType != null) {
			java.lang.String shellKey = pmedit.WindowsRegisterContextMenu.editCmdShellKey(pdfFileType);
			java.lang.String shellCommandKey = shellKey + "\\command";
			java.lang.String shellDdeExecKey = shellKey + "\\ddeexec";
			java.lang.String shellDdeExecApplicationKey = shellDdeExecKey + "\\application";
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellDdeExecApplicationKey);
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellDdeExecKey);
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellCommandKey);
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, shellKey);
			for (pmedit.CommandDescription desc : pmedit.CommandDescription.batchCommands) {
				java.lang.String batchShellKey = (pmedit.WindowsRegisterContextMenu.batchCmdShellKey(pdfFileType) + "\\") + desc.regKey;
				java.lang.String batchShellCommandKey = batchShellKey + "\\command";
				java.lang.String batchShellDdeExecKey = batchShellKey + "\\ddeexec";
				java.lang.String batchShellDdeExecApplicationKey = batchShellKey + "\\application";
				pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellDdeExecApplicationKey);
				pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellDdeExecKey);
				pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellCommandKey);
				pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, batchShellKey);
			}
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, pmedit.WindowsRegisterContextMenu.batchMenuShellKey(pdfFileType));
			pmedit.WindowsRegisterContextMenu.deleteRegistryKey(com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER, pmedit.WindowsRegisterContextMenu.batchMenuKey(pdfFileType));
		}
	}

	public static void main(java.lang.String[] args) {
		if (args.length == 0) {
			java.lang.System.out.println("Specify register or unregister as first argument");
			return;
		}
		if (args[0].toLowerCase().equals("register")) {
			try {
				pmedit.WindowsRegisterContextMenu.register();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
		if (args[0].toLowerCase().equals("unregister")) {
			try {
				pmedit.WindowsRegisterContextMenu.unregister();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}
}