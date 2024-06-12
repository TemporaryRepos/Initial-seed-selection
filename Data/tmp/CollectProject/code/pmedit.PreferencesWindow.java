public class PreferencesWindow extends javax.swing.JDialog {
	private javax.swing.JPanel contentPane;

	public pmedit.MetadataEditPane defaultMetadataPane;

	public boolean copyBasicToXmp;

	public boolean copyXmpToBasic;

	public java.lang.String renameTemplate;

	public java.lang.String defaultSaveAction;

	pmedit.MetadataInfo defaultMetadata;

	final java.util.prefs.Preferences prefs;

	java.lang.Runnable onSave;

	protected boolean isWindows;

	public static void main(java.lang.String[] args) {
		java.awt.EventQueue.invokeLater(new java.lang.Runnable() {
			public void run() {
				try {
					pmedit.PreferencesWindow frame = new pmedit.PreferencesWindow(java.util.prefs.Preferences.userRoot().node("PDFMetadataEditor"), null);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				} catch (java.lang.Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PreferencesWindow(final java.util.prefs.Preferences prefs, pmedit.MetadataInfo defaultMetadata) {
		this(prefs, defaultMetadata, null);
	}

	public PreferencesWindow(final java.util.prefs.Preferences prefs, pmedit.MetadataInfo defaultMetadata, final java.awt.Frame owner) {
		super(owner, true);
		setLocationRelativeTo(owner);
		long startTime = java.lang.System.nanoTime();
		final java.util.concurrent.Future<org.apache.http.HttpResponse> status = checkForUpdates();
		isWindows = java.lang.System.getProperty("os.name").startsWith("Windows");
		this.prefs = prefs;
		if (defaultMetadata != null) {
			this.defaultMetadata = defaultMetadata;
		} else {
			this.defaultMetadata = new pmedit.MetadataInfo();
		}
		addWindowListener(new java.awt.event.WindowAdapter() {
			@java.lang.Override
			public void windowClosing(java.awt.event.WindowEvent arg0) {
				save();
				if (onSave != null) {
					onSave.run();
				}
			}
		});
		setTitle("Preferences");
		setMinimumSize(new java.awt.Dimension(640, 480));
		contentPane = new javax.swing.JPanel();
		setContentPane(contentPane);
		java.awt.GridBagLayout gbl_contentPane = new java.awt.GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{ 725, 0 };
		gbl_contentPane.rowHeights = new int[]{ 389, 29, 0 };
		gbl_contentPane.columnWeights = new double[]{ 0.0, java.lang.Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[]{ 0.0, 0.0, java.lang.Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane(javax.swing.JTabbedPane.TOP);
		java.awt.GridBagConstraints gbc_tabbedPane = new java.awt.GridBagConstraints();
		gbc_tabbedPane.weighty = 1.0;
		gbc_tabbedPane.weightx = 1.0;
		gbc_tabbedPane.fill = java.awt.GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		javax.swing.JPanel panelGeneral = new javax.swing.JPanel();
		tabbedPane.addTab("General", null, panelGeneral, null);
		panelGeneral.setLayout(new net.miginfocom.swing.MigLayout("", "[grow]", "[][]"));
		javax.swing.JPanel panel_1 = new javax.swing.JPanel();
		panel_1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(184, 207, 229)), "On Save ...", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(51, 51, 51)));
		panel_1.setLayout(new net.miginfocom.swing.MigLayout("", "[]", "[][]"));
		onsaveCopyDocumentTo = new javax.swing.JCheckBox("Copy Document To XMP");
		onsaveCopyDocumentTo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if (onsaveCopyDocumentTo.isSelected()) {
					onsaveCopyXmpTo.setSelected(false);
				}
				copyBasicToXmp = onsaveCopyDocumentTo.isSelected();
				copyXmpToBasic = onsaveCopyXmpTo.isSelected();
			}
		});
		panel_1.add(onsaveCopyDocumentTo, "cell 0 0,alignx left,aligny top");
		onsaveCopyDocumentTo.setSelected(false);
		onsaveCopyXmpTo = new javax.swing.JCheckBox("Copy XMP To Document");
		onsaveCopyXmpTo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if (onsaveCopyXmpTo.isSelected()) {
					onsaveCopyDocumentTo.setSelected(false);
				}
				copyBasicToXmp = onsaveCopyDocumentTo.isSelected();
				copyXmpToBasic = onsaveCopyXmpTo.isSelected();
			}
		});
		panel_1.add(onsaveCopyXmpTo, "cell 0 1");
		onsaveCopyXmpTo.setSelected(false);
		panelGeneral.add(panel_1, "flowx,cell 0 0,alignx left,aligny top");
		onsaveCopyXmpTo.setSelected(prefs.getBoolean("onsaveCopyXmpTo", false));
		onsaveCopyDocumentTo.setSelected(prefs.getBoolean("onsaveCopyBasicTo", false));
		javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(184, 207, 229)), "Rename template", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(51, 51, 51)));
		panelGeneral.add(panel, "cell 0 1,grow");
		panel.setLayout(new net.miginfocom.swing.MigLayout("", "[grow]", "[][][]"));
		lblNewLabel = new javax.swing.JLabel("Preview:");
		panel.add(lblNewLabel, "cell 0 1");
		javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane();
		scrollPane.setViewportBorder(null);
		panel.add(scrollPane, "cell 0 2,grow");
		javax.swing.JTextPane txtpnAaa = new javax.swing.JTextPane();
		txtpnAaa.setBackground(javax.swing.UIManager.getColor("Panel.background"));
		txtpnAaa.setEditable(false);
		scrollPane.setViewportView(txtpnAaa);
		txtpnAaa.setContentType("text/html");
		txtpnAaa.setText(("Supported fields:<br>\n<pre>\n<i>" + pmedit.CommandLine.mdFieldsHelpMessage(60, "  {", "}", false)) + "</i></pre>");
		txtpnAaa.setFont(javax.swing.UIManager.getFont("TextPane.font"));
		txtpnAaa.setCaretPosition(0);
		comboBox = new javax.swing.JComboBox();
		comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				showPreview(((java.lang.String) (getRenameTemplateCombo().getModel().getSelectedItem())));
			}
		});
		comboBox.setEditable(true);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "", "{doc.author} - {doc.title}.pdf", "{doc.author} - {doc.creationDate}.pdf" }));
		panel.add(comboBox, "cell 0 0,growx");
		javax.swing.JPanel saveActionPanel = new javax.swing.JPanel();
		saveActionPanel.setBorder(new javax.swing.border.TitledBorder(null, "Default save action", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, null, null));
		panelGeneral.add(saveActionPanel, "cell 0 0");
		saveActionPanel.setLayout(new net.miginfocom.swing.MigLayout("", "[][]", "[][]"));
		final javax.swing.JRadioButton rdbtnSave = new javax.swing.JRadioButton("Save");
		buttonGroup.add(rdbtnSave);
		saveActionPanel.add(rdbtnSave, "flowy,cell 0 0,alignx left,aligny top");
		final javax.swing.JRadioButton rdbtnSaveAndRename = new javax.swing.JRadioButton("Save & rename");
		rdbtnSaveAndRename.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtnSaveAndRename);
		final javax.swing.JRadioButton rdbtnSaveAs = new javax.swing.JRadioButton("Save as ...");
		buttonGroup.add(rdbtnSaveAs);
		saveActionPanel.add(rdbtnSaveAndRename, "cell 0 0,alignx left,aligny top");
		saveActionPanel.add(rdbtnSaveAs, "cell 1 0,aligny top");
		final javax.swing.text.JTextComponent tcA = ((javax.swing.text.JTextComponent) (comboBox.getEditor().getEditorComponent()));
		javax.swing.JPanel panelDefaults = new javax.swing.JPanel();
		tabbedPane.addTab("Defaults", null, panelDefaults, null);
		java.awt.GridBagLayout gbl_panelDefaults = new java.awt.GridBagLayout();
		gbl_panelDefaults.columnWidths = new int[]{ 555, 0 };
		gbl_panelDefaults.rowHeights = new int[]{ 32, 100, 0 };
		gbl_panelDefaults.columnWeights = new double[]{ 0.0, java.lang.Double.MIN_VALUE };
		gbl_panelDefaults.rowWeights = new double[]{ 0.0, java.lang.Double.MIN_VALUE };
		panelDefaults.setLayout(gbl_panelDefaults);
		javax.swing.JLabel lblDefineHereDefault = new javax.swing.JLabel("Define here default values for the fields you would like prefilled if not set in the PDF document ");
		java.awt.GridBagConstraints gbc_lblDefineHereDefault = new java.awt.GridBagConstraints();
		gbc_lblDefineHereDefault.insets = new java.awt.Insets(5, 5, 0, 0);
		gbc_lblDefineHereDefault.weightx = 1.0;
		gbc_lblDefineHereDefault.anchor = java.awt.GridBagConstraints.NORTH;
		gbc_lblDefineHereDefault.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_lblDefineHereDefault.gridx = 0;
		gbc_lblDefineHereDefault.gridy = 0;
		panelDefaults.add(lblDefineHereDefault, gbc_lblDefineHereDefault);
		java.awt.GridBagConstraints gbc_lblDefineHereDefault1 = new java.awt.GridBagConstraints();
		gbc_lblDefineHereDefault1.weightx = 1.0;
		gbc_lblDefineHereDefault1.weighty = 1.0;
		gbc_lblDefineHereDefault1.anchor = java.awt.GridBagConstraints.NORTH;
		gbc_lblDefineHereDefault1.fill = java.awt.GridBagConstraints.BOTH;
		gbc_lblDefineHereDefault1.gridx = 0;
		gbc_lblDefineHereDefault1.gridy = 1;
		defaultMetadataPane = new pmedit.MetadataEditPane();
		panelDefaults.add(defaultMetadataPane.tabbedaPane, gbc_lblDefineHereDefault1);
		javax.swing.JPanel panelBatchLicense = new javax.swing.JPanel();
		tabbedPane.addTab("License", null, panelBatchLicense, null);
		java.awt.GridBagLayout gbl_panelBatchLicense = new java.awt.GridBagLayout();
		gbl_panelBatchLicense.columnWidths = new int[]{ 0, 0, 0 };
		gbl_panelBatchLicense.rowHeights = new int[]{ 0, 0, 0, 0, 0 };
		gbl_panelBatchLicense.columnWeights = new double[]{ 0.0, 1.0, java.lang.Double.MIN_VALUE };
		gbl_panelBatchLicense.rowWeights = new double[]{ 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		panelBatchLicense.setLayout(gbl_panelBatchLicense);
		javax.swing.JTextPane txtpnEnterLicenseInformation = new javax.swing.JTextPane();
		txtpnEnterLicenseInformation.setEditable(false);
		txtpnEnterLicenseInformation.setBackground(javax.swing.UIManager.getColor("Panel.background"));
		txtpnEnterLicenseInformation.setContentType("text/html");
		txtpnEnterLicenseInformation.setText(((("<h3 align=\'center\'>Enter license information below to use batch operations.</h3><p align=\'center\'>You can get license at <a href=\"" + pmedit.Constants.batchLicenseUrl) + "\">") + pmedit.Constants.batchLicenseUrl) + "</a></p>");
		java.awt.GridBagConstraints gbc_txtpnEnterLicenseInformation = new java.awt.GridBagConstraints();
		gbc_txtpnEnterLicenseInformation.gridwidth = 2;
		gbc_txtpnEnterLicenseInformation.insets = new java.awt.Insets(15, 0, 5, 0);
		gbc_txtpnEnterLicenseInformation.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_txtpnEnterLicenseInformation.gridx = 0;
		gbc_txtpnEnterLicenseInformation.gridy = 0;
		panelBatchLicense.add(txtpnEnterLicenseInformation, gbc_txtpnEnterLicenseInformation);
		txtpnEnterLicenseInformation.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
			public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent e) {
				if (e.getEventType() != javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
					return;
				}
				if (!java.awt.Desktop.isDesktopSupported()) {
					return;
				}
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					return;
				}
				try {
					java.net.URI uri = e.getURL().toURI();
					desktop.browse(uri);
				} catch (java.lang.Exception e1) {
				}
			}
		});
		javax.swing.JLabel lblNewLabel_2 = new javax.swing.JLabel("Email");
		java.awt.GridBagConstraints gbc_lblNewLabel_2 = new java.awt.GridBagConstraints();
		gbc_lblNewLabel_2.insets = new java.awt.Insets(15, 15, 5, 5);
		gbc_lblNewLabel_2.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panelBatchLicense.add(lblNewLabel_2, gbc_lblNewLabel_2);
		emailField = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_emailField = new java.awt.GridBagConstraints();
		gbc_emailField.insets = new java.awt.Insets(15, 0, 5, 15);
		gbc_emailField.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 1;
		panelBatchLicense.add(emailField, gbc_emailField);
		emailField.setColumns(10);
		emailField.setText(pmedit.Main.getPreferences().get("email", ""));
		emailField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			@java.lang.Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				updateLicense();
			}

			@java.lang.Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				updateLicense();
			}

			@java.lang.Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
			}
		});
		javax.swing.JLabel lblLicenseKey = new javax.swing.JLabel("License key");
		java.awt.GridBagConstraints gbc_lblLicenseKey = new java.awt.GridBagConstraints();
		gbc_lblLicenseKey.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblLicenseKey.insets = new java.awt.Insets(0, 15, 5, 5);
		gbc_lblLicenseKey.gridx = 0;
		gbc_lblLicenseKey.gridy = 2;
		panelBatchLicense.add(lblLicenseKey, gbc_lblLicenseKey);
		keyField = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_keyField = new java.awt.GridBagConstraints();
		gbc_keyField.insets = new java.awt.Insets(0, 0, 5, 15);
		gbc_keyField.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_keyField.gridx = 1;
		gbc_keyField.gridy = 2;
		panelBatchLicense.add(keyField, gbc_keyField);
		keyField.setColumns(10);
		keyField.setText(pmedit.Main.getPreferences().get("key", ""));
		keyField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			@java.lang.Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				updateLicense();
			}

			@java.lang.Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				updateLicense();
			}

			@java.lang.Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
			}
		});
		labelLicenseStatus = new javax.swing.JLabel("No License");
		java.awt.GridBagConstraints gbc_labelLicenseStatus = new java.awt.GridBagConstraints();
		gbc_labelLicenseStatus.gridwidth = 2;
		gbc_labelLicenseStatus.insets = new java.awt.Insets(30, 15, 0, 15);
		gbc_labelLicenseStatus.gridx = 0;
		gbc_labelLicenseStatus.gridy = 3;
		panelBatchLicense.add(labelLicenseStatus, gbc_labelLicenseStatus);
		javax.swing.JScrollPane scrollPane_1 = new javax.swing.JScrollPane();
		tabbedPane.addTab("About", null, scrollPane_1, null);
		txtpnDf = new javax.swing.JTextPane();
		txtpnDf.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
			public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent e) {
				if (e.getEventType() != javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
					return;
				}
				if (!java.awt.Desktop.isDesktopSupported()) {
					return;
				}
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				if (!desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					return;
				}
				try {
					java.net.URI uri = e.getURL().toURI();
					desktop.browse(uri);
				} catch (java.lang.Exception e1) {
				}
			}
		});
		txtpnDf.setContentType("text/html");
		txtpnDf.setEditable(false);
		txtpnDf.setText(aboutMsg = "<h1 align=center>Pdf Metadata editor</h1>\n\n<p align=center><a href=\"http://broken-by.me/pdf-metadata-editor/\">http://broken-by.me/pdf-metadata-editor/</a></p>\n<br>\n<p align=center>If you have suggestions, found bugs or just want to share some idea about it you can write me at : <a href=\"mailto:zarrro@gmail.com\"/>zarrro@gmail.com</a></p>\n<br>");
		scrollPane_1.setViewportView(txtpnDf);
		javax.swing.JPanel panel_3 = new javax.swing.JPanel();
		java.awt.GridBagConstraints gbc_panel_3 = new java.awt.GridBagConstraints();
		gbc_panel_3.insets = new java.awt.Insets(0, 5, 0, 5);
		gbc_panel_3.fill = java.awt.GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		contentPane.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new java.awt.BorderLayout(0, 0));
		javax.swing.JButton btnClose = new javax.swing.JButton("Close");
		panel_3.add(btnClose, java.awt.BorderLayout.EAST);
		updateStatusLabel = new javax.swing.JLabel("...");
		panel_3.add(updateStatusLabel, java.awt.BorderLayout.WEST);
		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
				save();
			}
		});
		java.awt.event.ActionListener onDefaultSaveAction = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (rdbtnSave.isSelected()) {
					defaultSaveAction = "save";
				} else if (rdbtnSaveAndRename.isSelected()) {
					defaultSaveAction = "saveRename";
				} else if (rdbtnSaveAs.isSelected()) {
					defaultSaveAction = "saveAs";
				}
			}
		};
		rdbtnSave.addActionListener(onDefaultSaveAction);
		rdbtnSaveAndRename.addActionListener(onDefaultSaveAction);
		rdbtnSaveAs.addActionListener(onDefaultSaveAction);
		tcA.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			@java.lang.Override
			public void changedUpdate(javax.swing.event.DocumentEvent arg0) {
				showPreview(((java.lang.String) (comboBox.getEditor().getItem())));
			}

			@java.lang.Override
			public void insertUpdate(javax.swing.event.DocumentEvent arg0) {
				showPreview(((java.lang.String) (comboBox.getEditor().getItem())));
			}

			@java.lang.Override
			public void removeUpdate(javax.swing.event.DocumentEvent arg0) {
				showPreview(((java.lang.String) (comboBox.getEditor().getItem())));
			}
		});
		java.lang.String defaultSaveAction = prefs.get("defaultSaveAction", "save");
		if (defaultSaveAction.equals("saveRename")) {
			rdbtnSaveAndRename.setSelected(true);
		} else if (defaultSaveAction.equals("saveAs")) {
			rdbtnSaveAndRename.setSelected(true);
		} else {
			rdbtnSave.setSelected(true);
		}
		javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
			@java.lang.Override
			public void run() {
			}
		});
		load();
		refresh();
		contentPane.doLayout();
		if (status.isDone()) {
			showUpdatesStatus(status);
		} else {
			new java.lang.Thread(new java.lang.Runnable() {
				@java.lang.Override
				public void run() {
					showUpdatesStatus(status);
				}
			}).start();
		}
		updateLicense();
	}

	private java.util.concurrent.Future<org.apache.http.HttpResponse> checkForUpdates() {
		org.apache.http.impl.nio.client.CloseableHttpAsyncClient httpclient = org.apache.http.impl.nio.client.HttpAsyncClients.createDefault();
		httpclient.start();
		org.apache.http.client.methods.HttpGet request = new org.apache.http.client.methods.HttpGet("https://api.github.com/repos/zaro/pdf-metadata-editor/releases?per_page=1");
		java.util.concurrent.Future<org.apache.http.HttpResponse> future = httpclient.execute(request, null);
		return future;
	}

	private void showUpdatesStatus(java.util.concurrent.Future<org.apache.http.HttpResponse> status) {
		pmedit.Version.VersionTuple current = pmedit.Version.get();
		java.lang.String currentVersionMsg = ("<h3 align=center>Version: " + current.getAsString()) + "</h3>";
		java.lang.String versionMsg = "<h3 align=center>Cannot get update information </h3>";
		try {
			org.apache.http.HttpResponse response = status.get();
			updateStatusLabel.setText("");
			java.lang.String lastsVersion = null;
			org.apache.http.HttpEntity entity = response.getEntity();
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
			org.json.simple.JSONArray body = ((org.json.simple.JSONArray) (parser.parse(org.apache.http.util.EntityUtils.toString(entity))));
			if (body.size() >= 1) {
				lastsVersion = ((java.lang.String) (((org.json.simple.JSONObject) (body.get(0))).get("name")));
			}
			if (lastsVersion != null) {
				pmedit.Version.VersionTuple latest = new pmedit.Version.VersionTuple(lastsVersion);
				if (current.cmp(latest) < 0) {
					versionMsg = ((("<h3 align=center>New version available: <a href='http://broken-by.me/pdf-metadata-editor/#download'>" + latest.getAsString()) + "</a> , current: ") + current.getAsString()) + "</h3>";
					updateStatusLabel.setText("Newer version available:" + latest.getAsString());
				} else {
					versionMsg = ("<h3 align=center>Version " + current.getAsString()) + " is the latest version</h3>";
				}
			}
		} catch (java.lang.InterruptedException e1) {
			e1.printStackTrace();
		} catch (java.util.concurrent.ExecutionException e1) {
			versionMsg += ("<h4 align=center>Error: " + e1.getCause().getLocalizedMessage()) + "</h4>";
		} catch (org.apache.http.ParseException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		} finally {
			txtpnDf.setText((aboutMsg + currentVersionMsg) + versionMsg);
		}
	}

	public void save() {
		prefs.putBoolean("onsaveCopyXmpTo", copyXmpToBasic);
		prefs.putBoolean("onsaveCopyBasicTo", copyBasicToXmp);
		if ((renameTemplate != null) && (renameTemplate.length() > 0)) {
			prefs.put("renameTemplate", renameTemplate);
		} else {
			prefs.remove("renameTemplate");
		}
		defaultMetadataPane.copyToMetadata(defaultMetadata);
		prefs.put("defaultMetadata", defaultMetadata.toYAML());
		prefs.put("defaultSaveAction", defaultSaveAction);
		if (onSave != null) {
			onSave.run();
		}
	}

	public void load() {
		copyBasicToXmp = prefs.getBoolean("onsaveCopyBasicTo", false);
		copyXmpToBasic = prefs.getBoolean("onsaveCopyXmpTo", false);
		renameTemplate = prefs.get("renameTemplate", null);
		java.lang.String defaultMetadataYAML = prefs.get("defaultMetadata", null);
		if ((defaultMetadataYAML != null) && (defaultMetadataYAML.length() > 0)) {
			defaultMetadata.fromYAML(defaultMetadataYAML);
		}
		defaultSaveAction = prefs.get("defaultSaveAction", "save");
	}

	public void refresh() {
		onsaveCopyDocumentTo.setSelected(copyBasicToXmp);
		onsaveCopyXmpTo.setSelected(copyXmpToBasic);
		comboBox.setSelectedItem(renameTemplate);
		defaultMetadataPane.fillFromMetadata(defaultMetadata);
		showPreview(renameTemplate);
	}

	public void showPreview(java.lang.String template) {
		renameTemplate = template;
		pmedit.TemplateString ts = new pmedit.TemplateString(template);
		getPreviewLabel().setText("Preview:" + ts.process(pmedit.MetadataInfo.getSampleMetadata()));
	}

	public void onSaveAction(java.lang.Runnable newAction) {
		onSave = newAction;
	}

	protected void updateLicense() {
		java.lang.String key = keyField.getText();
		java.lang.String email = emailField.getText();
		if (key.isEmpty() && email.isEmpty()) {
			labelLicenseStatus.setText("No license");
		} else if (pmedit.BatchMan.maybeHasBatch(key, email)) {
			pmedit.Main.getPreferences().put("key", keyField.getText());
			pmedit.Main.getPreferences().put("email", emailField.getText());
			labelLicenseStatus.setText("Valid license");
		} else {
			labelLicenseStatus.setText("Invalid license");
		}
	}

	private java.lang.String desc = "";

	private javax.swing.JLabel lblNewLabel;

	private javax.swing.JComboBox comboBox;

	private javax.swing.JCheckBox onsaveCopyDocumentTo;

	private javax.swing.JCheckBox onsaveCopyXmpTo;

	private final javax.swing.ButtonGroup buttonGroup = new javax.swing.ButtonGroup();

	private java.lang.String aboutMsg;

	private javax.swing.JTextPane txtpnDf;

	private javax.swing.JLabel updateStatusLabel;

	private javax.swing.JTextField emailField;

	private javax.swing.JTextField keyField;

	private javax.swing.JLabel labelLicenseStatus;

	protected javax.swing.JLabel getPreviewLabel() {
		return lblNewLabel;
	}

	protected javax.swing.JComboBox getRenameTemplateCombo() {
		return comboBox;
	}

	protected javax.swing.JLabel getUpdateStatusLabel() {
		return updateStatusLabel;
	}
}