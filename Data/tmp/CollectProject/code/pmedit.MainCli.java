public class MainCli {
	public static void executeCommand(final pmedit.CommandLine cmdLine) {
		if (cmdLine.showHelp) {
			java.lang.System.out.print(pmedit.MainCli.helpMessage);
			return;
		}
		pmedit.PDFMetadataEditBatch.ActionStatus status = new pmedit.PDFMetadataEditBatch.ActionStatus() {
			@java.lang.Override
			public void addStatus(java.lang.String filename, java.lang.String message) {
				java.lang.System.out.print(filename);
				java.lang.System.out.print(" -> ");
				java.lang.System.out.println(message);
			}

			@java.lang.Override
			public void addError(java.lang.String filename, java.lang.String error) {
				java.lang.System.out.print(filename);
				java.lang.System.out.print(" -> ");
				java.lang.System.out.println(error);
			}
		};
		if (cmdLine.hasCommand()) {
			pmedit.PDFMetadataEditBatch batch = new pmedit.PDFMetadataEditBatch(cmdLine.params);
			batch.runCommand(cmdLine.command, pmedit.FileList.fileList(cmdLine.fileList), status);
			return;
		} else if (cmdLine.batchGui) {
			status.addError("*", "Batch gui command not allowed in console mode");
		} else {
			status.addError("*", "No command specified");
		}
	}

	public static void main(pmedit.CommandLine cmdLine) {
		if ((cmdLine.licenseEmail != null) && (cmdLine.licenseKey != null)) {
			if (pmedit.BatchMan.giveBatch(cmdLine.licenseKey, cmdLine.licenseEmail)) {
				java.lang.System.out.println("Installed license for email: " + cmdLine.licenseEmail);
			} else {
				java.lang.System.out.println("Invalid license!");
			}
			return;
		}
		pmedit.MainCli.executeCommand(cmdLine);
	}

	public static void main(final java.lang.String[] args) {
		try {
			pmedit.MainCli.main(pmedit.CommandLine.parse(args));
		} catch (pmedit.CommandLine.ParseError e) {
			java.lang.System.err.println(e);
		}
	}

	static java.lang.String helpMessage = ((((((((((((((((((((((((((((((((((((("Usage pmedit-cli [OPTIONS] COMMAND [METADATA FIELD(S)] file [files...]\n" + (((((((((((("\n" + "OPTIONS\n") + "\n") + "  -h,  --help                     show this help message\n") + "  -rt, --renameTemplate=STRING    set a rename template for \'rename\' command\n") + "                                  any metadata field enclosed in {} will be substituted\n") + "                                  with the actual field value\n") + "       --license=email,key        install batch license and quit\n") + "                                  pass email and key separated with comma (no spaces) to \n") + "                                  install batch license from the command line.\n") + "\n") + "COMMANDS\n") + "\n")) + pmedit.CommandDescription.helpMessage(32)) + "\n") + "METADATA FIELDS\n") + "\n") + "Enable field : [!]FIEDLNAME\n") + "  A field is enabled by specifying it\'s name. If the name is prefixed wiht ! it will be disabled.\n") + "  There are two special fields `all` and `none` which respectively enable and disable all of the fields.\n") + "  By default all fields are disabled, so you must enable at least one or the command will be a no-op.\n") + "\n") + "Set a value: FIEDLNAME=value\n") + "  A field can be assigned a value with =, for example doc.title=WeeklyReport.\n") + "  Assigning a value to field also enables it.\n") + "  Fields that represent lists can be specified multiple times. \n") + "  Dates can be specified in ISO format, e.g : \n") + "    \"2016-06-16\'T\'00:15:00.000\'Z\'\" or \"2016-06-16\'T\'00:15:00\"  or\n") + "    \"2016-06-16 00:15:00\" or \"2016-06-16\"\n") + "\n") + "Available fields :\n") + pmedit.CommandLine.mdFieldsHelpMessage(80, true)) + "\n  * field is read only, assignment to it will be ignored\n") + "EXAMPLES\n") + "\n") + "Clear all metadata:\n") + "  pmedit-cli clear all file1.pdf file2.pdf\n") + "\n") + "Clear only author and title:\n") + "  pmedit-cli clear doc.title doc.author file1.pdf file2.pdf\n") + "\n") + "Clear all except author and title:\n") + "  pmedit-cli clear all !doc.title !doc.author file1.pdf file2.pdf\n") + "\n") + "Set author and title:\n") + "  pmedit-cli edit \"doc.title=The funniest book ever\" \"doc.author=Funny Guy\" file1.pdf file2.pdf\n") + "\n") + "Rename file from author and title:\n") + "  pmedit-cli --renameTemplate \"{doc.author} - {doc.title}.pdf\" rename file1.pdf file2.pdf\n") + "\n";
}