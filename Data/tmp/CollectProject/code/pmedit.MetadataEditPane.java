public class MetadataEditPane {
	public static interface FieldSetGet {
		public abstract void apply(java.lang.Object field, pmedit.FieldID anno);
	}

	public static interface FieldEnabledCheckBox {
		public abstract void apply(javax.swing.JCheckBox field, pmedit.FieldEnabled anno);
	}

	private static final long serialVersionUID = 6994489903939856136L;

	public javax.swing.JPanel basicMetaPanel;

	@pmedit.FieldID("doc.title")
	public javax.swing.JTextField basicTitle;

	@pmedit.FieldID("doc.author")
	public javax.swing.JTextField basicAuthor;

	@pmedit.FieldID("doc.subject")
	public javax.swing.JTextArea basicSubject;

	@pmedit.FieldID("doc.keywords")
	public javax.swing.JTextArea basicKeywords;

	@pmedit.FieldID("doc.creator")
	public javax.swing.JTextField basicCreator;

	@pmedit.FieldID("doc.producer")
	public javax.swing.JTextField basicProducer;

	@pmedit.FieldID("doc.trapped")
	public javax.swing.JComboBox basicTrapped;

	@pmedit.FieldID(value = "doc.creationDate", type = pmedit.FieldID.FieldType.DateField)
	public com.toedter.calendar.JDateChooser basicCreationDate;

	@pmedit.FieldID(value = "doc.modificationDate", type = pmedit.FieldID.FieldType.DateField)
	public com.toedter.calendar.JDateChooser basicModificationDate;

	@pmedit.FieldID("basic.creatorTool")
	public javax.swing.JTextField xmpBasicCreatorTool;

	@pmedit.FieldID("basic.baseURL")
	public javax.swing.JTextField xmpBasicBaseURL;

	@pmedit.FieldID("basic.rating")
	public javax.swing.JTextField xmpBasicRating;

	@pmedit.FieldID("basic.label")
	public javax.swing.JTextField xmpBasicLabel;

	@pmedit.FieldID("basic.nickname")
	public javax.swing.JTextField xmpBasicNickname;

	@pmedit.FieldID(value = "basic.identifiers", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpBasicIdentifiers;

	@pmedit.FieldID(value = "basic.advisories", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpBasicAdvisories;

	@pmedit.FieldID(value = "basic.modifyDate", type = pmedit.FieldID.FieldType.DateField)
	public com.toedter.calendar.JDateChooser xmpBasicModifyDate;

	@pmedit.FieldID(value = "basic.createDate", type = pmedit.FieldID.FieldType.DateField)
	public com.toedter.calendar.JDateChooser xmpBasicCreateDate;

	@pmedit.FieldID(value = "basic.metadataDate", type = pmedit.FieldID.FieldType.DateField)
	public com.toedter.calendar.JDateChooser xmpBasicMetadataDate;

	@pmedit.FieldID("pdf.keywords")
	public javax.swing.JTextArea xmpPdfKeywords;

	@pmedit.FieldID("pdf.pdfVersion")
	public javax.swing.JTextField xmpPdfVersion;

	@pmedit.FieldID("pdf.producer")
	public javax.swing.JTextField xmpPdfProducer;

	@pmedit.FieldID("dc.title")
	public javax.swing.JTextField xmpDcTitle;

	@pmedit.FieldID("dc.coverage")
	public javax.swing.JTextField xmpDcCoverage;

	@pmedit.FieldID("dc.description")
	public javax.swing.JTextField xmpDcDescription;

	@pmedit.FieldID(value = "dc.dates", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcDates;

	@pmedit.FieldID("dc.format")
	public javax.swing.JTextField xmpDcFormat;

	@pmedit.FieldID("dc.identifier")
	public javax.swing.JTextField xmpDcIdentifier;

	@pmedit.FieldID("dc.rights")
	public javax.swing.JTextField xmpDcRights;

	@pmedit.FieldID("dc.source")
	public javax.swing.JTextField xmpDcSource;

	@pmedit.FieldID(value = "dc.creators", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcCreators;

	@pmedit.FieldID(value = "dc.contributors", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcContributors;

	@pmedit.FieldID(value = "dc.languages", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcLanguages;

	@pmedit.FieldID(value = "dc.publishers", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcPublishers;

	@pmedit.FieldID(value = "dc.relationships", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcRelationships;

	@pmedit.FieldID(value = "dc.subjects", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcSubjects;

	@pmedit.FieldID(value = "dc.types", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpDcTypes;

	@pmedit.FieldID("rights.certificate")
	public javax.swing.JTextField xmpRightsCertificate;

	@pmedit.FieldID(value = "rights.marked", type = pmedit.FieldID.FieldType.BoolField)
	public javax.swing.JComboBox xmpRightsMarked;

	@pmedit.FieldID(value = "rights.owner", type = pmedit.FieldID.FieldType.TextField)
	public javax.swing.JTextArea xmpRightsOwner;

	@pmedit.FieldID("rights.copyright")
	public javax.swing.JTextArea xmpRightsCopyright;

	@pmedit.FieldID("rights.usageTerms")
	public javax.swing.JTextArea xmpRightsUsageTerms;

	@pmedit.FieldID("rights.webStatement")
	public javax.swing.JTextField xmpRightsWebStatement;

	public javax.swing.JPanel xmlBasicMetaPanel;

	public javax.swing.JPanel xmlPdfMetaPanel;

	public javax.swing.JPanel xmpDcMetaPanel;

	public javax.swing.JPanel xmpRightsMetaPanel;

	public javax.swing.JTabbedPane tabbedaPane;

	private javax.swing.JScrollPane scrollPane;

	private javax.swing.JScrollPane scrollPane_1;

	private javax.swing.JScrollPane scrollPane_2;

	@pmedit.FieldEnabled("doc.title")
	public javax.swing.JCheckBox basicTitleEnabled;

	@pmedit.FieldEnabled("doc.author")
	public javax.swing.JCheckBox basicAuthorEnabled;

	@pmedit.FieldEnabled("doc.subject")
	public javax.swing.JCheckBox basicSubjectEnabled;

	@pmedit.FieldEnabled("doc.keywords")
	public javax.swing.JCheckBox basicKeywordsEnabled;

	@pmedit.FieldEnabled("doc.creator")
	public javax.swing.JCheckBox basicCreatorEnabled;

	@pmedit.FieldEnabled("doc.producer")
	public javax.swing.JCheckBox basicProducerEnabled;

	@pmedit.FieldEnabled("doc.creationDate")
	public javax.swing.JCheckBox basicCreationDateEnabled;

	@pmedit.FieldEnabled("doc.modificationDate")
	public javax.swing.JCheckBox basicModificationDateEnabled;

	@pmedit.FieldEnabled("doc.trapped")
	public javax.swing.JCheckBox basicTrappedEnabled;

	@pmedit.FieldEnabled("basic.creatorTool")
	public javax.swing.JCheckBox xmpBasicCreatorToolEnabled;

	@pmedit.FieldEnabled("basic.createDate")
	public javax.swing.JCheckBox xmpBasicCreateDateEnabled;

	@pmedit.FieldEnabled("basic.modifyDate")
	public javax.swing.JCheckBox xmpBasicModifyDateEnabled;

	@pmedit.FieldEnabled("basic.baseURL")
	public javax.swing.JCheckBox xmpBasicBaseURLEnabled;

	@pmedit.FieldEnabled("basic.rating")
	public javax.swing.JCheckBox xmpBasicRatingEnable;

	@pmedit.FieldEnabled("basic.label")
	public javax.swing.JCheckBox xmpBasicLabelEnabled;

	@pmedit.FieldEnabled("basic.nickname")
	public javax.swing.JCheckBox xmpBasicNicknameEnabled;

	@pmedit.FieldEnabled("basic.identifiers")
	public javax.swing.JCheckBox xmpBasicIdentifiersEnabled;

	@pmedit.FieldEnabled("basic.advisories")
	public javax.swing.JCheckBox xmpBasicAdvisoriesEnabled;

	@pmedit.FieldEnabled("basic.metadataDate")
	public javax.swing.JCheckBox xmpBasicMetadataDateEnabled;

	@pmedit.FieldEnabled("pdf.keywords")
	public javax.swing.JCheckBox xmpPdfKeywordsEnabled;

	@pmedit.FieldEnabled("pdf.pdfVersion")
	public javax.swing.JCheckBox xmpPdfVersionEnabled;

	@pmedit.FieldEnabled("pdf.producer")
	public javax.swing.JCheckBox xmpPdfProducerEnabled;

	@pmedit.FieldEnabled("dc.title")
	public javax.swing.JCheckBox xmlDcTitleEnabled;

	@pmedit.FieldEnabled("dc.description")
	public javax.swing.JCheckBox xmpDcDescriptionEnabled;

	@pmedit.FieldEnabled("dc.creators")
	public javax.swing.JCheckBox xmpDcCreatorsEnabled;

	@pmedit.FieldEnabled("dc.contributors")
	public javax.swing.JCheckBox xmpDcContributorsEnabled;

	@pmedit.FieldEnabled("dc.coverage")
	public javax.swing.JCheckBox xmpDcCoverageEnabled;

	@pmedit.FieldEnabled("dc.dates")
	public javax.swing.JCheckBox xmpDcDatesEnabled;

	@pmedit.FieldEnabled("dc.format")
	public javax.swing.JCheckBox xmpDcFormatEnabled;

	@pmedit.FieldEnabled("dc.identifier")
	public javax.swing.JCheckBox xmpDcIdentifierEnabled;

	@pmedit.FieldEnabled("dc.languages")
	public javax.swing.JCheckBox xmpDcLanguagesEnabled;

	@pmedit.FieldEnabled("dc.publishers")
	public javax.swing.JCheckBox xmpDcPublishersEnabled;

	@pmedit.FieldEnabled("dc.relationships")
	public javax.swing.JCheckBox xmpDcRelationshipsEnabled;

	@pmedit.FieldEnabled("dc.rights")
	public javax.swing.JCheckBox xmpDcRightsEnabled;

	@pmedit.FieldEnabled("dc.source")
	public javax.swing.JCheckBox xmpDcSourceEnabled;

	@pmedit.FieldEnabled("dc.subjects")
	public javax.swing.JCheckBox xmpDcSubjectsEnabled;

	@pmedit.FieldEnabled("dc.types")
	public javax.swing.JCheckBox xmpDcTypesEnabled;

	@pmedit.FieldEnabled("rights.certificate")
	public javax.swing.JCheckBox xmpRightsCertificateEnabled;

	@pmedit.FieldEnabled("rights.marked")
	public javax.swing.JCheckBox xmpRightsMarkedEnabled;

	@pmedit.FieldEnabled("rights.owner")
	public javax.swing.JCheckBox xmpRightsOwnerEnabled;

	@pmedit.FieldEnabled("rights.copyright")
	public javax.swing.JCheckBox xmpRightsCopyrightEnabled;

	@pmedit.FieldEnabled("rights.usageTerms")
	public javax.swing.JCheckBox xmpRightsUsageTermsEnabled;

	@pmedit.FieldEnabled("rights.webStatement")
	public javax.swing.JCheckBox xmpRightsWebStatementEnabled;

	private javax.swing.JScrollPane scrollPane_3;

	private javax.swing.JScrollPane scrollPane_4;

	public MetadataEditPane() {
		initialize();
	}

	private void initialize() {
		long startTime = java.lang.System.nanoTime();
		long cnt = 1;
		tabbedaPane = new javax.swing.JTabbedPane(javax.swing.JTabbedPane.TOP);
		javax.swing.JScrollPane basicScrollpane = new javax.swing.JScrollPane();
		basicScrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedaPane.addTab("Document", null, basicScrollpane, null);
		basicMetaPanel = new javax.swing.JPanel();
		basicScrollpane.setViewportView(basicMetaPanel);
		java.awt.GridBagLayout gbl_basicMetaPanel = new java.awt.GridBagLayout();
		gbl_basicMetaPanel.columnWidths = new int[]{ 112, 0, 284, 0 };
		gbl_basicMetaPanel.rowHeights = new int[]{ 26, 26, 16, 16, 26, 26, 26, 26, 27, 0 };
		gbl_basicMetaPanel.columnWeights = new double[]{ 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		gbl_basicMetaPanel.rowWeights = new double[]{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		basicMetaPanel.setLayout(gbl_basicMetaPanel);
		javax.swing.JLabel lblTitle = new javax.swing.JLabel("Title");
		java.awt.GridBagConstraints gbc_lblTitle = new java.awt.GridBagConstraints();
		gbc_lblTitle.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblTitle.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		basicMetaPanel.add(lblTitle, gbc_lblTitle);
		basicTitleEnabled = new javax.swing.JCheckBox("");
		basicTitleEnabled.setSelected(true);
		basicTitleEnabled.setEnabled(false);
		java.awt.GridBagConstraints gbc_basicTitleEnabled = new java.awt.GridBagConstraints();
		gbc_basicTitleEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicTitleEnabled.gridx = 1;
		gbc_basicTitleEnabled.gridy = 0;
		basicMetaPanel.add(basicTitleEnabled, gbc_basicTitleEnabled);
		basicTitle = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_basicTitle = new java.awt.GridBagConstraints();
		gbc_basicTitle.weightx = 1.0;
		gbc_basicTitle.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicTitle.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_basicTitle.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicTitle.gridx = 2;
		gbc_basicTitle.gridy = 0;
		basicMetaPanel.add(basicTitle, gbc_basicTitle);
		basicTitle.setColumns(10);
		javax.swing.JLabel lblNewLabel = new javax.swing.JLabel("Author");
		java.awt.GridBagConstraints gbc_lblNewLabel = new java.awt.GridBagConstraints();
		gbc_lblNewLabel.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		basicMetaPanel.add(lblNewLabel, gbc_lblNewLabel);
		basicAuthorEnabled = new javax.swing.JCheckBox("");
		basicAuthorEnabled.setSelected(true);
		basicAuthorEnabled.setEnabled(false);
		java.awt.GridBagConstraints gbc_basicAuthorEnabled = new java.awt.GridBagConstraints();
		gbc_basicAuthorEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicAuthorEnabled.gridx = 1;
		gbc_basicAuthorEnabled.gridy = 1;
		basicMetaPanel.add(basicAuthorEnabled, gbc_basicAuthorEnabled);
		basicAuthor = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_basicAuthor = new java.awt.GridBagConstraints();
		gbc_basicAuthor.weightx = 1.0;
		gbc_basicAuthor.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicAuthor.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_basicAuthor.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicAuthor.gridx = 2;
		gbc_basicAuthor.gridy = 1;
		basicMetaPanel.add(basicAuthor, gbc_basicAuthor);
		basicAuthor.setColumns(10);
		javax.swing.JLabel lblSubject = new javax.swing.JLabel("Subject");
		java.awt.GridBagConstraints gbc_lblSubject = new java.awt.GridBagConstraints();
		gbc_lblSubject.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblSubject.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblSubject.gridx = 0;
		gbc_lblSubject.gridy = 2;
		basicMetaPanel.add(lblSubject, gbc_lblSubject);
		basicSubjectEnabled = new javax.swing.JCheckBox("");
		basicSubjectEnabled.setSelected(true);
		basicSubjectEnabled.setEnabled(false);
		java.awt.GridBagConstraints gbc_basicSubjectEnabled = new java.awt.GridBagConstraints();
		gbc_basicSubjectEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicSubjectEnabled.gridx = 1;
		gbc_basicSubjectEnabled.gridy = 2;
		basicMetaPanel.add(basicSubjectEnabled, gbc_basicSubjectEnabled);
		scrollPane_1 = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_scrollPane_1 = new java.awt.GridBagConstraints();
		gbc_scrollPane_1.weighty = 0.5;
		gbc_scrollPane_1.anchor = java.awt.GridBagConstraints.WEST;
		gbc_scrollPane_1.fill = java.awt.GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 2;
		basicMetaPanel.add(scrollPane_1, gbc_scrollPane_1);
		basicSubject = new javax.swing.JTextArea();
		basicSubject.setLineWrap(true);
		basicSubject.setWrapStyleWord(true);
		scrollPane_1.setViewportView(basicSubject);
		javax.swing.JLabel lblKeywords = new javax.swing.JLabel("Keywords");
		java.awt.GridBagConstraints gbc_lblKeywords = new java.awt.GridBagConstraints();
		gbc_lblKeywords.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblKeywords.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblKeywords.gridx = 0;
		gbc_lblKeywords.gridy = 3;
		basicMetaPanel.add(lblKeywords, gbc_lblKeywords);
		basicKeywordsEnabled = new javax.swing.JCheckBox("");
		basicKeywordsEnabled.setEnabled(false);
		basicKeywordsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicKeywordsEnabled = new java.awt.GridBagConstraints();
		gbc_basicKeywordsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicKeywordsEnabled.gridx = 1;
		gbc_basicKeywordsEnabled.gridy = 3;
		basicMetaPanel.add(basicKeywordsEnabled, gbc_basicKeywordsEnabled);
		scrollPane_2 = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_scrollPane_2 = new java.awt.GridBagConstraints();
		gbc_scrollPane_2.weighty = 0.5;
		gbc_scrollPane_2.anchor = java.awt.GridBagConstraints.WEST;
		gbc_scrollPane_2.fill = java.awt.GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 3;
		basicMetaPanel.add(scrollPane_2, gbc_scrollPane_2);
		basicKeywords = new javax.swing.JTextArea();
		basicKeywords.setLineWrap(true);
		basicKeywords.setWrapStyleWord(true);
		scrollPane_2.setViewportView(basicKeywords);
		javax.swing.JLabel lblCreator = new javax.swing.JLabel("Creator");
		java.awt.GridBagConstraints gbc_lblCreator = new java.awt.GridBagConstraints();
		gbc_lblCreator.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblCreator.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCreator.gridx = 0;
		gbc_lblCreator.gridy = 4;
		basicMetaPanel.add(lblCreator, gbc_lblCreator);
		basicCreatorEnabled = new javax.swing.JCheckBox("");
		basicCreatorEnabled.setEnabled(false);
		basicCreatorEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicCreatorEnabled = new java.awt.GridBagConstraints();
		gbc_basicCreatorEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicCreatorEnabled.gridx = 1;
		gbc_basicCreatorEnabled.gridy = 4;
		basicMetaPanel.add(basicCreatorEnabled, gbc_basicCreatorEnabled);
		basicCreator = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_basicCreator = new java.awt.GridBagConstraints();
		gbc_basicCreator.weightx = 1.0;
		gbc_basicCreator.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicCreator.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_basicCreator.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicCreator.gridx = 2;
		gbc_basicCreator.gridy = 4;
		basicMetaPanel.add(basicCreator, gbc_basicCreator);
		basicCreator.setColumns(10);
		javax.swing.JLabel lblProducer = new javax.swing.JLabel("Producer");
		java.awt.GridBagConstraints gbc_lblProducer = new java.awt.GridBagConstraints();
		gbc_lblProducer.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblProducer.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblProducer.gridx = 0;
		gbc_lblProducer.gridy = 5;
		basicMetaPanel.add(lblProducer, gbc_lblProducer);
		basicProducerEnabled = new javax.swing.JCheckBox("");
		basicProducerEnabled.setEnabled(false);
		basicProducerEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicProducerEnabled = new java.awt.GridBagConstraints();
		gbc_basicProducerEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicProducerEnabled.gridx = 1;
		gbc_basicProducerEnabled.gridy = 5;
		basicMetaPanel.add(basicProducerEnabled, gbc_basicProducerEnabled);
		basicProducer = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_basicProducer = new java.awt.GridBagConstraints();
		gbc_basicProducer.weightx = 1.0;
		gbc_basicProducer.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicProducer.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_basicProducer.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicProducer.gridx = 2;
		gbc_basicProducer.gridy = 5;
		basicMetaPanel.add(basicProducer, gbc_basicProducer);
		basicProducer.setColumns(10);
		javax.swing.JLabel lblCreationDate = new javax.swing.JLabel("Creation Date");
		java.awt.GridBagConstraints gbc_lblCreationDate = new java.awt.GridBagConstraints();
		gbc_lblCreationDate.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblCreationDate.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCreationDate.gridx = 0;
		gbc_lblCreationDate.gridy = 6;
		basicMetaPanel.add(lblCreationDate, gbc_lblCreationDate);
		basicCreationDateEnabled = new javax.swing.JCheckBox("");
		basicCreationDateEnabled.setEnabled(false);
		basicCreationDateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicCreationDateEnabled = new java.awt.GridBagConstraints();
		gbc_basicCreationDateEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicCreationDateEnabled.gridx = 1;
		gbc_basicCreationDateEnabled.gridy = 6;
		basicMetaPanel.add(basicCreationDateEnabled, gbc_basicCreationDateEnabled);
		basicCreationDate = new com.toedter.calendar.JDateChooser();
		basicCreationDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		java.awt.GridBagConstraints gbc_basicCreationDate = new java.awt.GridBagConstraints();
		gbc_basicCreationDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicCreationDate.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicCreationDate.gridx = 2;
		gbc_basicCreationDate.gridy = 6;
		basicMetaPanel.add(basicCreationDate, gbc_basicCreationDate);
		javax.swing.JLabel lblModificationDate = new javax.swing.JLabel("Modification Date");
		java.awt.GridBagConstraints gbc_lblModificationDate = new java.awt.GridBagConstraints();
		gbc_lblModificationDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_lblModificationDate.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblModificationDate.gridx = 0;
		gbc_lblModificationDate.gridy = 7;
		basicMetaPanel.add(lblModificationDate, gbc_lblModificationDate);
		basicModificationDateEnabled = new javax.swing.JCheckBox("");
		basicModificationDateEnabled.setEnabled(false);
		basicModificationDateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicModificationDateEnabled = new java.awt.GridBagConstraints();
		gbc_basicModificationDateEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_basicModificationDateEnabled.gridx = 1;
		gbc_basicModificationDateEnabled.gridy = 7;
		basicMetaPanel.add(basicModificationDateEnabled, gbc_basicModificationDateEnabled);
		basicModificationDate = new com.toedter.calendar.JDateChooser();
		basicModificationDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		java.awt.GridBagConstraints gbc_basicModificationDate = new java.awt.GridBagConstraints();
		gbc_basicModificationDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicModificationDate.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_basicModificationDate.gridx = 2;
		gbc_basicModificationDate.gridy = 7;
		basicMetaPanel.add(basicModificationDate, gbc_basicModificationDate);
		javax.swing.JLabel lblTrapped = new javax.swing.JLabel("Trapped");
		java.awt.GridBagConstraints gbc_lblTrapped = new java.awt.GridBagConstraints();
		gbc_lblTrapped.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblTrapped.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_lblTrapped.gridx = 0;
		gbc_lblTrapped.gridy = 8;
		basicMetaPanel.add(lblTrapped, gbc_lblTrapped);
		basicTrappedEnabled = new javax.swing.JCheckBox("");
		basicTrappedEnabled.setEnabled(false);
		basicTrappedEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_basicTrappedEnabled = new java.awt.GridBagConstraints();
		gbc_basicTrappedEnabled.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_basicTrappedEnabled.gridx = 1;
		gbc_basicTrappedEnabled.gridy = 8;
		basicMetaPanel.add(basicTrappedEnabled, gbc_basicTrappedEnabled);
		basicTrapped = new javax.swing.JComboBox();
		basicTrapped.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "True", "False", "Unknown" }));
		java.awt.GridBagConstraints gbc_basicTrapped = new java.awt.GridBagConstraints();
		gbc_basicTrapped.anchor = java.awt.GridBagConstraints.WEST;
		gbc_basicTrapped.gridx = 2;
		gbc_basicTrapped.gridy = 8;
		basicMetaPanel.add(basicTrapped, gbc_basicTrapped);
		javax.swing.JScrollPane xmpBasicScrollpane = new javax.swing.JScrollPane();
		xmpBasicScrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedaPane.addTab("XMP Basic", null, xmpBasicScrollpane, null);
		xmlBasicMetaPanel = new javax.swing.JPanel();
		xmpBasicScrollpane.setViewportView(xmlBasicMetaPanel);
		java.awt.GridBagLayout gbl_xmlBasicMetaPanel = new java.awt.GridBagLayout();
		gbl_xmlBasicMetaPanel.columnWidths = new int[]{ 112, 0, 284, 0 };
		gbl_xmlBasicMetaPanel.rowHeights = new int[]{ 26, 26, 26, 26, 26, 26, 26, 16, 16, 26, 0 };
		gbl_xmlBasicMetaPanel.columnWeights = new double[]{ 0.0, 0.0, 1.0, java.lang.Double.MIN_VALUE };
		gbl_xmlBasicMetaPanel.rowWeights = new double[]{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		xmlBasicMetaPanel.setLayout(gbl_xmlBasicMetaPanel);
		javax.swing.JLabel lblCreatorTool = new javax.swing.JLabel("Creator tool");
		java.awt.GridBagConstraints gbc_lblCreatorTool = new java.awt.GridBagConstraints();
		gbc_lblCreatorTool.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblCreatorTool.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCreatorTool.gridx = 0;
		gbc_lblCreatorTool.gridy = 0;
		xmlBasicMetaPanel.add(lblCreatorTool, gbc_lblCreatorTool);
		xmpBasicCreatorToolEnabled = new javax.swing.JCheckBox("");
		xmpBasicCreatorToolEnabled.setEnabled(false);
		xmpBasicCreatorToolEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicCreatorToolEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicCreatorToolEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicCreatorToolEnabled.gridx = 1;
		gbc_xmpBasicCreatorToolEnabled.gridy = 0;
		xmlBasicMetaPanel.add(xmpBasicCreatorToolEnabled, gbc_xmpBasicCreatorToolEnabled);
		xmpBasicCreatorTool = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpBasicCreatorTool = new java.awt.GridBagConstraints();
		gbc_xmpBasicCreatorTool.weightx = 1.0;
		gbc_xmpBasicCreatorTool.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicCreatorTool.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicCreatorTool.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicCreatorTool.gridx = 2;
		gbc_xmpBasicCreatorTool.gridy = 0;
		xmlBasicMetaPanel.add(xmpBasicCreatorTool, gbc_xmpBasicCreatorTool);
		xmpBasicCreatorTool.setColumns(10);
		javax.swing.JLabel lblCreateDate = new javax.swing.JLabel("Create Date");
		java.awt.GridBagConstraints gbc_lblCreateDate = new java.awt.GridBagConstraints();
		gbc_lblCreateDate.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblCreateDate.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCreateDate.gridx = 0;
		gbc_lblCreateDate.gridy = 1;
		xmlBasicMetaPanel.add(lblCreateDate, gbc_lblCreateDate);
		xmpBasicCreateDateEnabled = new javax.swing.JCheckBox("");
		xmpBasicCreateDateEnabled.setEnabled(false);
		xmpBasicCreateDateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicCreateDateEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicCreateDateEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicCreateDateEnabled.gridx = 1;
		gbc_xmpBasicCreateDateEnabled.gridy = 1;
		xmlBasicMetaPanel.add(xmpBasicCreateDateEnabled, gbc_xmpBasicCreateDateEnabled);
		xmpBasicCreateDate = new com.toedter.calendar.JDateChooser();
		xmpBasicCreateDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		java.awt.GridBagConstraints gbc_xmpBasicCreateDate = new java.awt.GridBagConstraints();
		gbc_xmpBasicCreateDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicCreateDate.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicCreateDate.gridx = 2;
		gbc_xmpBasicCreateDate.gridy = 1;
		xmlBasicMetaPanel.add(xmpBasicCreateDate, gbc_xmpBasicCreateDate);
		javax.swing.JLabel lblModifyDate = new javax.swing.JLabel("Modify Date");
		java.awt.GridBagConstraints gbc_lblModifyDate = new java.awt.GridBagConstraints();
		gbc_lblModifyDate.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblModifyDate.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblModifyDate.gridx = 0;
		gbc_lblModifyDate.gridy = 2;
		xmlBasicMetaPanel.add(lblModifyDate, gbc_lblModifyDate);
		xmpBasicModifyDateEnabled = new javax.swing.JCheckBox("");
		xmpBasicModifyDateEnabled.setEnabled(false);
		xmpBasicModifyDateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicModifyDateEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicModifyDateEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicModifyDateEnabled.gridx = 1;
		gbc_xmpBasicModifyDateEnabled.gridy = 2;
		xmlBasicMetaPanel.add(xmpBasicModifyDateEnabled, gbc_xmpBasicModifyDateEnabled);
		xmpBasicModifyDate = new com.toedter.calendar.JDateChooser();
		xmpBasicModifyDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		java.awt.GridBagConstraints gbc_xmpBasicModifyDate = new java.awt.GridBagConstraints();
		gbc_xmpBasicModifyDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicModifyDate.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicModifyDate.gridx = 2;
		gbc_xmpBasicModifyDate.gridy = 2;
		xmlBasicMetaPanel.add(xmpBasicModifyDate, gbc_xmpBasicModifyDate);
		javax.swing.JLabel lblBaseUrl = new javax.swing.JLabel("Base URL");
		java.awt.GridBagConstraints gbc_lblBaseUrl = new java.awt.GridBagConstraints();
		gbc_lblBaseUrl.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblBaseUrl.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblBaseUrl.gridx = 0;
		gbc_lblBaseUrl.gridy = 3;
		xmlBasicMetaPanel.add(lblBaseUrl, gbc_lblBaseUrl);
		xmpBasicBaseURLEnabled = new javax.swing.JCheckBox("");
		xmpBasicBaseURLEnabled.setEnabled(false);
		xmpBasicBaseURLEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicBaseURLEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicBaseURLEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicBaseURLEnabled.gridx = 1;
		gbc_xmpBasicBaseURLEnabled.gridy = 3;
		xmlBasicMetaPanel.add(xmpBasicBaseURLEnabled, gbc_xmpBasicBaseURLEnabled);
		xmpBasicBaseURL = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpBasicBaseURL = new java.awt.GridBagConstraints();
		gbc_xmpBasicBaseURL.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicBaseURL.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicBaseURL.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicBaseURL.gridx = 2;
		gbc_xmpBasicBaseURL.gridy = 3;
		xmlBasicMetaPanel.add(xmpBasicBaseURL, gbc_xmpBasicBaseURL);
		xmpBasicBaseURL.setColumns(10);
		javax.swing.JLabel lblRating = new javax.swing.JLabel("Rating");
		java.awt.GridBagConstraints gbc_lblRating = new java.awt.GridBagConstraints();
		gbc_lblRating.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRating.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 0;
		gbc_lblRating.gridy = 4;
		xmlBasicMetaPanel.add(lblRating, gbc_lblRating);
		xmpBasicRatingEnable = new javax.swing.JCheckBox("");
		xmpBasicRatingEnable.setEnabled(false);
		xmpBasicRatingEnable.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicRatingEnable = new java.awt.GridBagConstraints();
		gbc_xmpBasicRatingEnable.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicRatingEnable.gridx = 1;
		gbc_xmpBasicRatingEnable.gridy = 4;
		xmlBasicMetaPanel.add(xmpBasicRatingEnable, gbc_xmpBasicRatingEnable);
		xmpBasicRating = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpBasicRating = new java.awt.GridBagConstraints();
		gbc_xmpBasicRating.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicRating.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicRating.gridx = 2;
		gbc_xmpBasicRating.gridy = 4;
		xmlBasicMetaPanel.add(xmpBasicRating, gbc_xmpBasicRating);
		javax.swing.JLabel lblLabel = new javax.swing.JLabel("Label");
		java.awt.GridBagConstraints gbc_lblLabel = new java.awt.GridBagConstraints();
		gbc_lblLabel.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblLabel.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 5;
		xmlBasicMetaPanel.add(lblLabel, gbc_lblLabel);
		xmpBasicLabelEnabled = new javax.swing.JCheckBox("");
		xmpBasicLabelEnabled.setEnabled(false);
		xmpBasicLabelEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicLabelEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicLabelEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicLabelEnabled.gridx = 1;
		gbc_xmpBasicLabelEnabled.gridy = 5;
		xmlBasicMetaPanel.add(xmpBasicLabelEnabled, gbc_xmpBasicLabelEnabled);
		xmpBasicLabel = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpBasicLabel = new java.awt.GridBagConstraints();
		gbc_xmpBasicLabel.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicLabel.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicLabel.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicLabel.gridx = 2;
		gbc_xmpBasicLabel.gridy = 5;
		xmlBasicMetaPanel.add(xmpBasicLabel, gbc_xmpBasicLabel);
		xmpBasicLabel.setColumns(10);
		javax.swing.JLabel lblNickname = new javax.swing.JLabel("Nickname");
		java.awt.GridBagConstraints gbc_lblNickname = new java.awt.GridBagConstraints();
		gbc_lblNickname.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblNickname.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 6;
		xmlBasicMetaPanel.add(lblNickname, gbc_lblNickname);
		xmpBasicNicknameEnabled = new javax.swing.JCheckBox("");
		xmpBasicNicknameEnabled.setEnabled(false);
		xmpBasicNicknameEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicNicknameEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicNicknameEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicNicknameEnabled.gridx = 1;
		gbc_xmpBasicNicknameEnabled.gridy = 6;
		xmlBasicMetaPanel.add(xmpBasicNicknameEnabled, gbc_xmpBasicNicknameEnabled);
		xmpBasicNickname = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpBasicNickname = new java.awt.GridBagConstraints();
		gbc_xmpBasicNickname.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicNickname.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicNickname.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicNickname.gridx = 2;
		gbc_xmpBasicNickname.gridy = 6;
		xmlBasicMetaPanel.add(xmpBasicNickname, gbc_xmpBasicNickname);
		xmpBasicNickname.setColumns(10);
		javax.swing.JLabel label_1 = new javax.swing.JLabel("Identifiers");
		java.awt.GridBagConstraints gbc_label_1 = new java.awt.GridBagConstraints();
		gbc_label_1.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_label_1.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 7;
		xmlBasicMetaPanel.add(label_1, gbc_label_1);
		xmpBasicIdentifiersEnabled = new javax.swing.JCheckBox("");
		xmpBasicIdentifiersEnabled.setEnabled(false);
		xmpBasicIdentifiersEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicIdentifiersEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicIdentifiersEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicIdentifiersEnabled.gridx = 1;
		gbc_xmpBasicIdentifiersEnabled.gridy = 7;
		xmlBasicMetaPanel.add(xmpBasicIdentifiersEnabled, gbc_xmpBasicIdentifiersEnabled);
		xmpBasicIdentifiers = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpBasicIdentifiers = new java.awt.GridBagConstraints();
		gbc_xmpBasicIdentifiers.weighty = 0.5;
		gbc_xmpBasicIdentifiers.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicIdentifiers.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpBasicIdentifiers.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicIdentifiers.gridx = 2;
		gbc_xmpBasicIdentifiers.gridy = 7;
		xmlBasicMetaPanel.add(xmpBasicIdentifiers, gbc_xmpBasicIdentifiers);
		javax.swing.JLabel label = new javax.swing.JLabel("Advisories");
		java.awt.GridBagConstraints gbc_label = new java.awt.GridBagConstraints();
		gbc_label.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_label.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 8;
		xmlBasicMetaPanel.add(label, gbc_label);
		xmpBasicAdvisoriesEnabled = new javax.swing.JCheckBox("");
		xmpBasicAdvisoriesEnabled.setEnabled(false);
		xmpBasicAdvisoriesEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicAdvisoriesEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicAdvisoriesEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpBasicAdvisoriesEnabled.gridx = 1;
		gbc_xmpBasicAdvisoriesEnabled.gridy = 8;
		xmlBasicMetaPanel.add(xmpBasicAdvisoriesEnabled, gbc_xmpBasicAdvisoriesEnabled);
		xmpBasicAdvisories = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpBasicAdvisories = new java.awt.GridBagConstraints();
		gbc_xmpBasicAdvisories.weighty = 0.5;
		gbc_xmpBasicAdvisories.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicAdvisories.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpBasicAdvisories.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpBasicAdvisories.gridx = 2;
		gbc_xmpBasicAdvisories.gridy = 8;
		xmlBasicMetaPanel.add(xmpBasicAdvisories, gbc_xmpBasicAdvisories);
		javax.swing.JLabel lblMetadataDate = new javax.swing.JLabel("Metadata Date");
		java.awt.GridBagConstraints gbc_lblMetadataDate = new java.awt.GridBagConstraints();
		gbc_lblMetadataDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_lblMetadataDate.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_lblMetadataDate.gridx = 0;
		gbc_lblMetadataDate.gridy = 9;
		xmlBasicMetaPanel.add(lblMetadataDate, gbc_lblMetadataDate);
		xmpBasicMetadataDateEnabled = new javax.swing.JCheckBox("");
		xmpBasicMetadataDateEnabled.setEnabled(false);
		xmpBasicMetadataDateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpBasicMetadataDateEnabled = new java.awt.GridBagConstraints();
		gbc_xmpBasicMetadataDateEnabled.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_xmpBasicMetadataDateEnabled.gridx = 1;
		gbc_xmpBasicMetadataDateEnabled.gridy = 9;
		xmlBasicMetaPanel.add(xmpBasicMetadataDateEnabled, gbc_xmpBasicMetadataDateEnabled);
		xmpBasicMetadataDate = new com.toedter.calendar.JDateChooser();
		xmpBasicMetadataDate.setDateFormatString("yyyy-MM-dd HH:mm:ss");
		java.awt.GridBagConstraints gbc_xmpBasicMetadataDate = new java.awt.GridBagConstraints();
		gbc_xmpBasicMetadataDate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpBasicMetadataDate.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpBasicMetadataDate.gridx = 2;
		gbc_xmpBasicMetadataDate.gridy = 9;
		xmlBasicMetaPanel.add(xmpBasicMetadataDate, gbc_xmpBasicMetadataDate);
		javax.swing.JScrollPane xmpPdfScrollpane = new javax.swing.JScrollPane();
		xmpPdfScrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedaPane.addTab("XMP PDF", null, xmpPdfScrollpane, null);
		xmlPdfMetaPanel = new javax.swing.JPanel();
		xmpPdfScrollpane.setViewportView(xmlPdfMetaPanel);
		java.awt.GridBagLayout gbl_xmlPdfMetaPanel = new java.awt.GridBagLayout();
		gbl_xmlPdfMetaPanel.columnWidths = new int[]{ 112, 0, 284, 0 };
		gbl_xmlPdfMetaPanel.rowHeights = new int[]{ 16, 26, 26, 0 };
		gbl_xmlPdfMetaPanel.columnWeights = new double[]{ 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		gbl_xmlPdfMetaPanel.rowWeights = new double[]{ 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		xmlPdfMetaPanel.setLayout(gbl_xmlPdfMetaPanel);
		javax.swing.JLabel lblKeywords_1 = new javax.swing.JLabel("Keywords");
		java.awt.GridBagConstraints gbc_lblKeywords_1 = new java.awt.GridBagConstraints();
		gbc_lblKeywords_1.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblKeywords_1.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblKeywords_1.gridx = 0;
		gbc_lblKeywords_1.gridy = 0;
		xmlPdfMetaPanel.add(lblKeywords_1, gbc_lblKeywords_1);
		xmpPdfKeywordsEnabled = new javax.swing.JCheckBox("");
		xmpPdfKeywordsEnabled.setEnabled(false);
		xmpPdfKeywordsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpPdfKeywordsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpPdfKeywordsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpPdfKeywordsEnabled.gridx = 1;
		gbc_xmpPdfKeywordsEnabled.gridy = 0;
		xmlPdfMetaPanel.add(xmpPdfKeywordsEnabled, gbc_xmpPdfKeywordsEnabled);
		scrollPane = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_scrollPane = new java.awt.GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.anchor = java.awt.GridBagConstraints.WEST;
		gbc_scrollPane.fill = java.awt.GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		xmlPdfMetaPanel.add(scrollPane, gbc_scrollPane);
		xmpPdfKeywords = new javax.swing.JTextArea();
		scrollPane.setViewportView(xmpPdfKeywords);
		xmpPdfKeywords.setWrapStyleWord(true);
		xmpPdfKeywords.setLineWrap(true);
		xmpPdfKeywords.setColumns(10);
		javax.swing.JLabel lblPdfVersion = new javax.swing.JLabel("PDF Version");
		java.awt.GridBagConstraints gbc_lblPdfVersion = new java.awt.GridBagConstraints();
		gbc_lblPdfVersion.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblPdfVersion.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblPdfVersion.gridx = 0;
		gbc_lblPdfVersion.gridy = 1;
		xmlPdfMetaPanel.add(lblPdfVersion, gbc_lblPdfVersion);
		xmpPdfVersionEnabled = new javax.swing.JCheckBox("");
		xmpPdfVersionEnabled.setEnabled(false);
		xmpPdfVersionEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpPdfVersionEnabled = new java.awt.GridBagConstraints();
		gbc_xmpPdfVersionEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpPdfVersionEnabled.gridx = 1;
		gbc_xmpPdfVersionEnabled.gridy = 1;
		xmlPdfMetaPanel.add(xmpPdfVersionEnabled, gbc_xmpPdfVersionEnabled);
		xmpPdfVersion = new javax.swing.JTextField();
		xmpPdfVersion.setEditable(false);
		java.awt.GridBagConstraints gbc_xmpPdfVersion = new java.awt.GridBagConstraints();
		gbc_xmpPdfVersion.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpPdfVersion.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpPdfVersion.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpPdfVersion.gridx = 2;
		gbc_xmpPdfVersion.gridy = 1;
		xmlPdfMetaPanel.add(xmpPdfVersion, gbc_xmpPdfVersion);
		xmpPdfVersion.setColumns(10);
		javax.swing.JLabel lblProducer_1 = new javax.swing.JLabel("Producer");
		java.awt.GridBagConstraints gbc_lblProducer_1 = new java.awt.GridBagConstraints();
		gbc_lblProducer_1.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblProducer_1.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_lblProducer_1.gridx = 0;
		gbc_lblProducer_1.gridy = 2;
		xmlPdfMetaPanel.add(lblProducer_1, gbc_lblProducer_1);
		xmpPdfProducerEnabled = new javax.swing.JCheckBox("");
		xmpPdfProducerEnabled.setEnabled(false);
		xmpPdfProducerEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpPdfProducerEnabled = new java.awt.GridBagConstraints();
		gbc_xmpPdfProducerEnabled.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_xmpPdfProducerEnabled.gridx = 1;
		gbc_xmpPdfProducerEnabled.gridy = 2;
		xmlPdfMetaPanel.add(xmpPdfProducerEnabled, gbc_xmpPdfProducerEnabled);
		xmpPdfProducer = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpPdfProducer = new java.awt.GridBagConstraints();
		gbc_xmpPdfProducer.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpPdfProducer.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpPdfProducer.gridx = 2;
		gbc_xmpPdfProducer.gridy = 2;
		xmlPdfMetaPanel.add(xmpPdfProducer, gbc_xmpPdfProducer);
		xmpPdfProducer.setColumns(10);
		javax.swing.JScrollPane xmpDcScrollpane = new javax.swing.JScrollPane();
		xmpDcScrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedaPane.addTab("XMP Dublin Core", null, xmpDcScrollpane, null);
		xmpDcMetaPanel = new javax.swing.JPanel();
		xmpDcScrollpane.setViewportView(xmpDcMetaPanel);
		java.awt.GridBagLayout gbl_xmpDcMetaPanel = new java.awt.GridBagLayout();
		gbl_xmpDcMetaPanel.columnWidths = new int[]{ 112, 0, 284, 0 };
		gbl_xmpDcMetaPanel.rowHeights = new int[]{ 26, 26, 16, 16, 26, 16, 26, 26, 16, 16, 16, 26, 26, 16, 16, 0 };
		gbl_xmpDcMetaPanel.columnWeights = new double[]{ 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		gbl_xmpDcMetaPanel.rowWeights = new double[]{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		xmpDcMetaPanel.setLayout(gbl_xmpDcMetaPanel);
		javax.swing.JLabel lblTitle_2 = new javax.swing.JLabel("Title");
		java.awt.GridBagConstraints gbc_lblTitle_2 = new java.awt.GridBagConstraints();
		gbc_lblTitle_2.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblTitle_2.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblTitle_2.gridx = 0;
		gbc_lblTitle_2.gridy = 0;
		xmpDcMetaPanel.add(lblTitle_2, gbc_lblTitle_2);
		xmlDcTitleEnabled = new javax.swing.JCheckBox("");
		xmlDcTitleEnabled.setEnabled(false);
		xmlDcTitleEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmlDcTitleEnabled = new java.awt.GridBagConstraints();
		gbc_xmlDcTitleEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmlDcTitleEnabled.gridx = 1;
		gbc_xmlDcTitleEnabled.gridy = 0;
		xmpDcMetaPanel.add(xmlDcTitleEnabled, gbc_xmlDcTitleEnabled);
		xmpDcTitle = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcTitle = new java.awt.GridBagConstraints();
		gbc_xmpDcTitle.weightx = 1.0;
		gbc_xmpDcTitle.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcTitle.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcTitle.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcTitle.gridx = 2;
		gbc_xmpDcTitle.gridy = 0;
		xmpDcMetaPanel.add(xmpDcTitle, gbc_xmpDcTitle);
		xmpDcTitle.setColumns(10);
		javax.swing.JLabel lblDescription = new javax.swing.JLabel("Description");
		java.awt.GridBagConstraints gbc_lblDescription = new java.awt.GridBagConstraints();
		gbc_lblDescription.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblDescription.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		xmpDcMetaPanel.add(lblDescription, gbc_lblDescription);
		xmpDcDescriptionEnabled = new javax.swing.JCheckBox("");
		xmpDcDescriptionEnabled.setEnabled(false);
		xmpDcDescriptionEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcDescriptionEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcDescriptionEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcDescriptionEnabled.gridx = 1;
		gbc_xmpDcDescriptionEnabled.gridy = 1;
		xmpDcMetaPanel.add(xmpDcDescriptionEnabled, gbc_xmpDcDescriptionEnabled);
		xmpDcDescription = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcDescription = new java.awt.GridBagConstraints();
		gbc_xmpDcDescription.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcDescription.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcDescription.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcDescription.gridx = 2;
		gbc_xmpDcDescription.gridy = 1;
		xmpDcMetaPanel.add(xmpDcDescription, gbc_xmpDcDescription);
		xmpDcDescription.setColumns(10);
		javax.swing.JLabel lblCreators = new javax.swing.JLabel("Creators");
		java.awt.GridBagConstraints gbc_lblCreators = new java.awt.GridBagConstraints();
		gbc_lblCreators.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblCreators.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCreators.gridx = 0;
		gbc_lblCreators.gridy = 2;
		xmpDcMetaPanel.add(lblCreators, gbc_lblCreators);
		xmpDcCreatorsEnabled = new javax.swing.JCheckBox("");
		xmpDcCreatorsEnabled.setEnabled(false);
		xmpDcCreatorsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcCreatorsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcCreatorsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcCreatorsEnabled.gridx = 1;
		gbc_xmpDcCreatorsEnabled.gridy = 2;
		xmpDcMetaPanel.add(xmpDcCreatorsEnabled, gbc_xmpDcCreatorsEnabled);
		xmpDcCreators = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcCreators = new java.awt.GridBagConstraints();
		gbc_xmpDcCreators.weighty = 0.125;
		gbc_xmpDcCreators.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcCreators.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcCreators.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcCreators.gridx = 2;
		gbc_xmpDcCreators.gridy = 2;
		xmpDcMetaPanel.add(xmpDcCreators, gbc_xmpDcCreators);
		javax.swing.JLabel lblContributors = new javax.swing.JLabel("Contributors");
		java.awt.GridBagConstraints gbc_lblContributors = new java.awt.GridBagConstraints();
		gbc_lblContributors.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblContributors.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblContributors.gridx = 0;
		gbc_lblContributors.gridy = 3;
		xmpDcMetaPanel.add(lblContributors, gbc_lblContributors);
		xmpDcContributorsEnabled = new javax.swing.JCheckBox("");
		xmpDcContributorsEnabled.setEnabled(false);
		xmpDcContributorsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcContributorsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcContributorsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcContributorsEnabled.gridx = 1;
		gbc_xmpDcContributorsEnabled.gridy = 3;
		xmpDcMetaPanel.add(xmpDcContributorsEnabled, gbc_xmpDcContributorsEnabled);
		xmpDcContributors = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcContributors = new java.awt.GridBagConstraints();
		gbc_xmpDcContributors.weighty = 0.125;
		gbc_xmpDcContributors.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcContributors.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcContributors.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcContributors.gridx = 2;
		gbc_xmpDcContributors.gridy = 3;
		xmpDcMetaPanel.add(xmpDcContributors, gbc_xmpDcContributors);
		javax.swing.JLabel lblCoverage = new javax.swing.JLabel("Coverage");
		java.awt.GridBagConstraints gbc_lblCoverage = new java.awt.GridBagConstraints();
		gbc_lblCoverage.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblCoverage.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblCoverage.gridx = 0;
		gbc_lblCoverage.gridy = 4;
		xmpDcMetaPanel.add(lblCoverage, gbc_lblCoverage);
		xmpDcCoverageEnabled = new javax.swing.JCheckBox("");
		xmpDcCoverageEnabled.setEnabled(false);
		xmpDcCoverageEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcCoverageEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcCoverageEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcCoverageEnabled.gridx = 1;
		gbc_xmpDcCoverageEnabled.gridy = 4;
		xmpDcMetaPanel.add(xmpDcCoverageEnabled, gbc_xmpDcCoverageEnabled);
		xmpDcCoverage = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcCoverage = new java.awt.GridBagConstraints();
		gbc_xmpDcCoverage.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcCoverage.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcCoverage.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcCoverage.gridx = 2;
		gbc_xmpDcCoverage.gridy = 4;
		xmpDcMetaPanel.add(xmpDcCoverage, gbc_xmpDcCoverage);
		xmpDcCoverage.setColumns(10);
		javax.swing.JLabel lblDates = new javax.swing.JLabel("Dates");
		java.awt.GridBagConstraints gbc_lblDates = new java.awt.GridBagConstraints();
		gbc_lblDates.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblDates.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblDates.gridx = 0;
		gbc_lblDates.gridy = 5;
		xmpDcMetaPanel.add(lblDates, gbc_lblDates);
		xmpDcDatesEnabled = new javax.swing.JCheckBox("");
		xmpDcDatesEnabled.setEnabled(false);
		xmpDcDatesEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcDatesEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcDatesEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcDatesEnabled.gridx = 1;
		gbc_xmpDcDatesEnabled.gridy = 5;
		xmpDcMetaPanel.add(xmpDcDatesEnabled, gbc_xmpDcDatesEnabled);
		xmpDcDates = new javax.swing.JTextArea();
		xmpDcDates.setEditable(false);
		java.awt.GridBagConstraints gbc_xmpDcDates = new java.awt.GridBagConstraints();
		gbc_xmpDcDates.weighty = 0.125;
		gbc_xmpDcDates.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcDates.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcDates.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcDates.gridx = 2;
		gbc_xmpDcDates.gridy = 5;
		xmpDcMetaPanel.add(xmpDcDates, gbc_xmpDcDates);
		xmpDcDates.setColumns(10);
		javax.swing.JLabel lblFormat = new javax.swing.JLabel("Format");
		java.awt.GridBagConstraints gbc_lblFormat = new java.awt.GridBagConstraints();
		gbc_lblFormat.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblFormat.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblFormat.gridx = 0;
		gbc_lblFormat.gridy = 6;
		xmpDcMetaPanel.add(lblFormat, gbc_lblFormat);
		xmpDcFormatEnabled = new javax.swing.JCheckBox("");
		xmpDcFormatEnabled.setEnabled(false);
		xmpDcFormatEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcFormatEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcFormatEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcFormatEnabled.gridx = 1;
		gbc_xmpDcFormatEnabled.gridy = 6;
		xmpDcMetaPanel.add(xmpDcFormatEnabled, gbc_xmpDcFormatEnabled);
		xmpDcFormat = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcFormat = new java.awt.GridBagConstraints();
		gbc_xmpDcFormat.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcFormat.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcFormat.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcFormat.gridx = 2;
		gbc_xmpDcFormat.gridy = 6;
		xmpDcMetaPanel.add(xmpDcFormat, gbc_xmpDcFormat);
		xmpDcFormat.setColumns(10);
		javax.swing.JLabel lblIdentifier = new javax.swing.JLabel("Identifier");
		java.awt.GridBagConstraints gbc_lblIdentifier = new java.awt.GridBagConstraints();
		gbc_lblIdentifier.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblIdentifier.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblIdentifier.gridx = 0;
		gbc_lblIdentifier.gridy = 7;
		xmpDcMetaPanel.add(lblIdentifier, gbc_lblIdentifier);
		xmpDcIdentifierEnabled = new javax.swing.JCheckBox("");
		xmpDcIdentifierEnabled.setEnabled(false);
		xmpDcIdentifierEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcIdentifierEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcIdentifierEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcIdentifierEnabled.gridx = 1;
		gbc_xmpDcIdentifierEnabled.gridy = 7;
		xmpDcMetaPanel.add(xmpDcIdentifierEnabled, gbc_xmpDcIdentifierEnabled);
		xmpDcIdentifier = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcIdentifier = new java.awt.GridBagConstraints();
		gbc_xmpDcIdentifier.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcIdentifier.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcIdentifier.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcIdentifier.gridx = 2;
		gbc_xmpDcIdentifier.gridy = 7;
		xmpDcMetaPanel.add(xmpDcIdentifier, gbc_xmpDcIdentifier);
		xmpDcIdentifier.setColumns(10);
		javax.swing.JLabel lblLanguages = new javax.swing.JLabel("Languages");
		java.awt.GridBagConstraints gbc_lblLanguages = new java.awt.GridBagConstraints();
		gbc_lblLanguages.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblLanguages.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblLanguages.gridx = 0;
		gbc_lblLanguages.gridy = 8;
		xmpDcMetaPanel.add(lblLanguages, gbc_lblLanguages);
		xmpDcLanguagesEnabled = new javax.swing.JCheckBox("");
		xmpDcLanguagesEnabled.setEnabled(false);
		xmpDcLanguagesEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcLanguagesEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcLanguagesEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcLanguagesEnabled.gridx = 1;
		gbc_xmpDcLanguagesEnabled.gridy = 8;
		xmpDcMetaPanel.add(xmpDcLanguagesEnabled, gbc_xmpDcLanguagesEnabled);
		xmpDcLanguages = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcLanguages = new java.awt.GridBagConstraints();
		gbc_xmpDcLanguages.weighty = 0.125;
		gbc_xmpDcLanguages.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcLanguages.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcLanguages.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcLanguages.gridx = 2;
		gbc_xmpDcLanguages.gridy = 8;
		xmpDcMetaPanel.add(xmpDcLanguages, gbc_xmpDcLanguages);
		javax.swing.JLabel lblPublishers = new javax.swing.JLabel("Publishers");
		java.awt.GridBagConstraints gbc_lblPublishers = new java.awt.GridBagConstraints();
		gbc_lblPublishers.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblPublishers.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblPublishers.gridx = 0;
		gbc_lblPublishers.gridy = 9;
		xmpDcMetaPanel.add(lblPublishers, gbc_lblPublishers);
		xmpDcPublishersEnabled = new javax.swing.JCheckBox("");
		xmpDcPublishersEnabled.setEnabled(false);
		xmpDcPublishersEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcPublishersEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcPublishersEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcPublishersEnabled.gridx = 1;
		gbc_xmpDcPublishersEnabled.gridy = 9;
		xmpDcMetaPanel.add(xmpDcPublishersEnabled, gbc_xmpDcPublishersEnabled);
		xmpDcPublishers = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcPublishers = new java.awt.GridBagConstraints();
		gbc_xmpDcPublishers.weighty = 0.125;
		gbc_xmpDcPublishers.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcPublishers.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcPublishers.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcPublishers.gridx = 2;
		gbc_xmpDcPublishers.gridy = 9;
		xmpDcMetaPanel.add(xmpDcPublishers, gbc_xmpDcPublishers);
		javax.swing.JLabel lblRelationships = new javax.swing.JLabel("Relationships");
		lblRelationships.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		java.awt.GridBagConstraints gbc_lblRelationships = new java.awt.GridBagConstraints();
		gbc_lblRelationships.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblRelationships.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRelationships.gridx = 0;
		gbc_lblRelationships.gridy = 10;
		xmpDcMetaPanel.add(lblRelationships, gbc_lblRelationships);
		xmpDcRelationshipsEnabled = new javax.swing.JCheckBox("");
		xmpDcRelationshipsEnabled.setEnabled(false);
		xmpDcRelationshipsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcRelationshipsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcRelationshipsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcRelationshipsEnabled.gridx = 1;
		gbc_xmpDcRelationshipsEnabled.gridy = 10;
		xmpDcMetaPanel.add(xmpDcRelationshipsEnabled, gbc_xmpDcRelationshipsEnabled);
		xmpDcRelationships = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcRelationships = new java.awt.GridBagConstraints();
		gbc_xmpDcRelationships.weighty = 0.125;
		gbc_xmpDcRelationships.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcRelationships.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcRelationships.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcRelationships.gridx = 2;
		gbc_xmpDcRelationships.gridy = 10;
		xmpDcMetaPanel.add(xmpDcRelationships, gbc_xmpDcRelationships);
		javax.swing.JLabel lblRights = new javax.swing.JLabel("Rights");
		java.awt.GridBagConstraints gbc_lblRights = new java.awt.GridBagConstraints();
		gbc_lblRights.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRights.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRights.gridx = 0;
		gbc_lblRights.gridy = 11;
		xmpDcMetaPanel.add(lblRights, gbc_lblRights);
		xmpDcRightsEnabled = new javax.swing.JCheckBox("");
		xmpDcRightsEnabled.setEnabled(false);
		xmpDcRightsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcRightsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcRightsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcRightsEnabled.gridx = 1;
		gbc_xmpDcRightsEnabled.gridy = 11;
		xmpDcMetaPanel.add(xmpDcRightsEnabled, gbc_xmpDcRightsEnabled);
		xmpDcRights = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcRights = new java.awt.GridBagConstraints();
		gbc_xmpDcRights.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcRights.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcRights.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcRights.gridx = 2;
		gbc_xmpDcRights.gridy = 11;
		xmpDcMetaPanel.add(xmpDcRights, gbc_xmpDcRights);
		xmpDcRights.setColumns(10);
		javax.swing.JLabel lblSource = new javax.swing.JLabel("Source");
		java.awt.GridBagConstraints gbc_lblSource = new java.awt.GridBagConstraints();
		gbc_lblSource.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblSource.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblSource.gridx = 0;
		gbc_lblSource.gridy = 12;
		xmpDcMetaPanel.add(lblSource, gbc_lblSource);
		xmpDcSourceEnabled = new javax.swing.JCheckBox("");
		xmpDcSourceEnabled.setEnabled(false);
		xmpDcSourceEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcSourceEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcSourceEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcSourceEnabled.gridx = 1;
		gbc_xmpDcSourceEnabled.gridy = 12;
		xmpDcMetaPanel.add(xmpDcSourceEnabled, gbc_xmpDcSourceEnabled);
		xmpDcSource = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpDcSource = new java.awt.GridBagConstraints();
		gbc_xmpDcSource.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcSource.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpDcSource.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcSource.gridx = 2;
		gbc_xmpDcSource.gridy = 12;
		xmpDcMetaPanel.add(xmpDcSource, gbc_xmpDcSource);
		xmpDcSource.setColumns(10);
		javax.swing.JLabel lblSubjects = new javax.swing.JLabel("Subjects");
		java.awt.GridBagConstraints gbc_lblSubjects = new java.awt.GridBagConstraints();
		gbc_lblSubjects.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblSubjects.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblSubjects.gridx = 0;
		gbc_lblSubjects.gridy = 13;
		xmpDcMetaPanel.add(lblSubjects, gbc_lblSubjects);
		xmpDcSubjectsEnabled = new javax.swing.JCheckBox("");
		xmpDcSubjectsEnabled.setEnabled(false);
		xmpDcSubjectsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcSubjectsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcSubjectsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcSubjectsEnabled.gridx = 1;
		gbc_xmpDcSubjectsEnabled.gridy = 13;
		xmpDcMetaPanel.add(xmpDcSubjectsEnabled, gbc_xmpDcSubjectsEnabled);
		xmpDcSubjects = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcSubjects = new java.awt.GridBagConstraints();
		gbc_xmpDcSubjects.weighty = 0.125;
		gbc_xmpDcSubjects.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcSubjects.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcSubjects.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcSubjects.gridx = 2;
		gbc_xmpDcSubjects.gridy = 13;
		xmpDcMetaPanel.add(xmpDcSubjects, gbc_xmpDcSubjects);
		javax.swing.JLabel lblTypes = new javax.swing.JLabel("Types");
		java.awt.GridBagConstraints gbc_lblTypes = new java.awt.GridBagConstraints();
		gbc_lblTypes.anchor = java.awt.GridBagConstraints.NORTHEAST;
		gbc_lblTypes.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_lblTypes.gridx = 0;
		gbc_lblTypes.gridy = 14;
		xmpDcMetaPanel.add(lblTypes, gbc_lblTypes);
		xmpDcTypesEnabled = new javax.swing.JCheckBox("");
		xmpDcTypesEnabled.setEnabled(false);
		xmpDcTypesEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpDcTypesEnabled = new java.awt.GridBagConstraints();
		gbc_xmpDcTypesEnabled.insets = new java.awt.Insets(0, 0, 0, 5);
		gbc_xmpDcTypesEnabled.gridx = 1;
		gbc_xmpDcTypesEnabled.gridy = 14;
		xmpDcMetaPanel.add(xmpDcTypesEnabled, gbc_xmpDcTypesEnabled);
		xmpDcTypes = new javax.swing.JTextArea();
		java.awt.GridBagConstraints gbc_xmpDcTypes = new java.awt.GridBagConstraints();
		gbc_xmpDcTypes.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpDcTypes.weighty = 0.125;
		gbc_xmpDcTypes.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpDcTypes.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpDcTypes.gridx = 2;
		gbc_xmpDcTypes.gridy = 14;
		xmpDcMetaPanel.add(xmpDcTypes, gbc_xmpDcTypes);
		javax.swing.JScrollPane xmpRightsScrollpane = new javax.swing.JScrollPane();
		xmpRightsScrollpane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedaPane.addTab("XMP Rights", null, xmpRightsScrollpane, null);
		xmpRightsMetaPanel = new javax.swing.JPanel();
		xmpRightsScrollpane.setViewportView(xmpRightsMetaPanel);
		java.awt.GridBagLayout gbl_xmpRightsMetaPanel = new java.awt.GridBagLayout();
		gbl_xmpRightsMetaPanel.columnWidths = new int[]{ 112, 0, 284, 0 };
		gbl_xmpRightsMetaPanel.rowHeights = new int[]{ 16, 26, 26, 26, 26, 0 };
		gbl_xmpRightsMetaPanel.columnWeights = new double[]{ 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		gbl_xmpRightsMetaPanel.rowWeights = new double[]{ 0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE };
		xmpRightsMetaPanel.setLayout(gbl_xmpRightsMetaPanel);
		javax.swing.JLabel lblRightsCertificate = new javax.swing.JLabel("Certificate");
		java.awt.GridBagConstraints gbc_lblRightsCertificate = new java.awt.GridBagConstraints();
		gbc_lblRightsCertificate.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsCertificate.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsCertificate.gridx = 0;
		gbc_lblRightsCertificate.gridy = 0;
		xmpRightsMetaPanel.add(lblRightsCertificate, gbc_lblRightsCertificate);
		xmpRightsCertificateEnabled = new javax.swing.JCheckBox("");
		xmpRightsCertificateEnabled.setEnabled(false);
		xmpRightsCertificateEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsCertificateEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsCertificateEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsCertificateEnabled.gridx = 1;
		gbc_xmpRightsCertificateEnabled.gridy = 0;
		xmpRightsMetaPanel.add(xmpRightsCertificateEnabled, gbc_xmpRightsCertificateEnabled);
		xmpRightsCertificate = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpRightsCertificate = new java.awt.GridBagConstraints();
		gbc_xmpRightsCertificate.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsCertificate.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpRightsCertificate.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsCertificate.gridx = 2;
		gbc_xmpRightsCertificate.gridy = 0;
		xmpRightsMetaPanel.add(xmpRightsCertificate, gbc_xmpRightsCertificate);
		xmpRightsCertificate.setColumns(10);
		javax.swing.JLabel lblRightsMarked = new javax.swing.JLabel("Marked");
		java.awt.GridBagConstraints gbc_lblRightsMarked = new java.awt.GridBagConstraints();
		gbc_lblRightsMarked.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsMarked.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsMarked.gridx = 0;
		gbc_lblRightsMarked.gridy = 1;
		xmpRightsMetaPanel.add(lblRightsMarked, gbc_lblRightsMarked);
		xmpRightsMarkedEnabled = new javax.swing.JCheckBox("");
		xmpRightsMarkedEnabled.setEnabled(false);
		xmpRightsMarkedEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsMarkedEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsMarkedEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsMarkedEnabled.gridx = 1;
		gbc_xmpRightsMarkedEnabled.gridy = 1;
		xmpRightsMetaPanel.add(xmpRightsMarkedEnabled, gbc_xmpRightsMarkedEnabled);
		xmpRightsMarked = new javax.swing.JComboBox();
		xmpRightsMarked.setModel(new javax.swing.DefaultComboBoxModel(new java.lang.String[]{ "Unset", "Yes", "No" }));
		java.awt.GridBagConstraints gbc_xmpRightsMarked = new java.awt.GridBagConstraints();
		gbc_xmpRightsMarked.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsMarked.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpRightsMarked.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsMarked.gridx = 2;
		gbc_xmpRightsMarked.gridy = 1;
		xmpRightsMetaPanel.add(xmpRightsMarked, gbc_xmpRightsMarked);
		javax.swing.JLabel lblRightsOwner = new javax.swing.JLabel("Owners");
		java.awt.GridBagConstraints gbc_lblRightsOwner = new java.awt.GridBagConstraints();
		gbc_lblRightsOwner.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsOwner.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsOwner.gridx = 0;
		gbc_lblRightsOwner.gridy = 2;
		xmpRightsMetaPanel.add(lblRightsOwner, gbc_lblRightsOwner);
		xmpRightsOwnerEnabled = new javax.swing.JCheckBox("");
		xmpRightsOwnerEnabled.setEnabled(false);
		xmpRightsOwnerEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsOwnerEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsOwnerEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsOwnerEnabled.gridx = 1;
		gbc_xmpRightsOwnerEnabled.gridy = 2;
		xmpRightsMetaPanel.add(xmpRightsOwnerEnabled, gbc_xmpRightsOwnerEnabled);
		javax.swing.JScrollPane xmpRightsOwnerScroll = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_xmpRightsOwner = new java.awt.GridBagConstraints();
		gbc_xmpRightsOwner.weighty = 1.0;
		gbc_xmpRightsOwner.weightx = 1.0;
		gbc_xmpRightsOwner.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsOwner.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpRightsOwner.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsOwner.gridx = 2;
		gbc_xmpRightsOwner.gridy = 2;
		xmpRightsMetaPanel.add(xmpRightsOwnerScroll, gbc_xmpRightsOwner);
		xmpRightsOwner = new javax.swing.JTextArea();
		xmpRightsOwnerScroll.setViewportView(xmpRightsOwner);
		xmpRightsOwner.setWrapStyleWord(true);
		xmpRightsOwner.setLineWrap(true);
		xmpRightsOwner.setColumns(10);
		javax.swing.JLabel lblRightsCopyright = new javax.swing.JLabel("Copyright");
		java.awt.GridBagConstraints gbc_lblRightsCopyright = new java.awt.GridBagConstraints();
		gbc_lblRightsCopyright.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsCopyright.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsCopyright.gridx = 0;
		gbc_lblRightsCopyright.gridy = 3;
		xmpRightsMetaPanel.add(lblRightsCopyright, gbc_lblRightsCopyright);
		xmpRightsCopyrightEnabled = new javax.swing.JCheckBox("");
		xmpRightsCopyrightEnabled.setEnabled(false);
		xmpRightsCopyrightEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsCopyrightEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsCopyrightEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsCopyrightEnabled.gridx = 1;
		gbc_xmpRightsCopyrightEnabled.gridy = 3;
		xmpRightsMetaPanel.add(xmpRightsCopyrightEnabled, gbc_xmpRightsCopyrightEnabled);
		javax.swing.JScrollPane xmpRightsCopyrightScroll = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_xmpRightsCopyright = new java.awt.GridBagConstraints();
		gbc_xmpRightsCopyright.weighty = 1.0;
		gbc_xmpRightsCopyright.weightx = 1.0;
		gbc_xmpRightsCopyright.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsCopyright.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpRightsCopyright.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsCopyright.gridx = 2;
		gbc_xmpRightsCopyright.gridy = 3;
		xmpRightsMetaPanel.add(xmpRightsCopyrightScroll, gbc_xmpRightsCopyright);
		xmpRightsCopyright = new javax.swing.JTextArea();
		xmpRightsCopyrightScroll.setViewportView(xmpRightsCopyright);
		xmpRightsCopyright.setWrapStyleWord(true);
		xmpRightsCopyright.setLineWrap(true);
		xmpRightsCopyright.setColumns(10);
		javax.swing.JLabel lblRightsUsageTerms = new javax.swing.JLabel("Usage Terms");
		java.awt.GridBagConstraints gbc_lblRightsUsageTerms = new java.awt.GridBagConstraints();
		gbc_lblRightsUsageTerms.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsUsageTerms.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsUsageTerms.gridx = 0;
		gbc_lblRightsUsageTerms.gridy = 4;
		xmpRightsMetaPanel.add(lblRightsUsageTerms, gbc_lblRightsUsageTerms);
		xmpRightsUsageTermsEnabled = new javax.swing.JCheckBox("");
		xmpRightsUsageTermsEnabled.setEnabled(false);
		xmpRightsUsageTermsEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsUsageTermsEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsUsageTermsEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsUsageTermsEnabled.gridx = 1;
		gbc_xmpRightsUsageTermsEnabled.gridy = 4;
		xmpRightsMetaPanel.add(xmpRightsUsageTermsEnabled, gbc_xmpRightsUsageTermsEnabled);
		javax.swing.JScrollPane xmpRightsUsageTermsScroll = new javax.swing.JScrollPane();
		java.awt.GridBagConstraints gbc_xmpRightsUsageTerms = new java.awt.GridBagConstraints();
		gbc_xmpRightsUsageTerms.weighty = 1.0;
		gbc_xmpRightsUsageTerms.weightx = 1.0;
		gbc_xmpRightsUsageTerms.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsUsageTerms.fill = java.awt.GridBagConstraints.BOTH;
		gbc_xmpRightsUsageTerms.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsUsageTerms.gridx = 2;
		gbc_xmpRightsUsageTerms.gridy = 4;
		xmpRightsMetaPanel.add(xmpRightsUsageTermsScroll, gbc_xmpRightsUsageTerms);
		xmpRightsUsageTerms = new javax.swing.JTextArea();
		xmpRightsUsageTermsScroll.setViewportView(xmpRightsUsageTerms);
		xmpRightsUsageTerms.setWrapStyleWord(true);
		xmpRightsUsageTerms.setLineWrap(true);
		xmpRightsUsageTerms.setColumns(10);
		javax.swing.JLabel lblRightsWebStatement = new javax.swing.JLabel("Web Statement");
		java.awt.GridBagConstraints gbc_lblRightsWebStatement = new java.awt.GridBagConstraints();
		gbc_lblRightsWebStatement.anchor = java.awt.GridBagConstraints.EAST;
		gbc_lblRightsWebStatement.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_lblRightsWebStatement.gridx = 0;
		gbc_lblRightsWebStatement.gridy = 5;
		xmpRightsMetaPanel.add(lblRightsWebStatement, gbc_lblRightsWebStatement);
		xmpRightsWebStatementEnabled = new javax.swing.JCheckBox("");
		xmpRightsWebStatementEnabled.setEnabled(false);
		xmpRightsWebStatementEnabled.setSelected(true);
		java.awt.GridBagConstraints gbc_xmpRightsWebStatementEnabled = new java.awt.GridBagConstraints();
		gbc_xmpRightsWebStatementEnabled.insets = new java.awt.Insets(0, 0, 5, 5);
		gbc_xmpRightsWebStatementEnabled.gridx = 1;
		gbc_xmpRightsWebStatementEnabled.gridy = 5;
		xmpRightsMetaPanel.add(xmpRightsWebStatementEnabled, gbc_xmpRightsWebStatementEnabled);
		xmpRightsWebStatement = new javax.swing.JTextField();
		java.awt.GridBagConstraints gbc_xmpRightsWebStatement = new java.awt.GridBagConstraints();
		gbc_xmpRightsWebStatement.anchor = java.awt.GridBagConstraints.WEST;
		gbc_xmpRightsWebStatement.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gbc_xmpRightsWebStatement.insets = new java.awt.Insets(0, 0, 5, 0);
		gbc_xmpRightsWebStatement.gridx = 2;
		gbc_xmpRightsWebStatement.gridy = 5;
		xmpRightsMetaPanel.add(xmpRightsWebStatement, gbc_xmpRightsWebStatement);
		javax.swing.text.PlainDocument doc = new javax.swing.text.PlainDocument();
		doc.setDocumentFilter(new javax.swing.text.DocumentFilter() {
			@java.lang.Override
			public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int off, java.lang.String str, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
				fb.insertString(off, str.replaceAll("\\D++", ""), attr);
			}

			@java.lang.Override
			public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int off, int len, java.lang.String str, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
				fb.replace(off, len, str.replaceAll("\\D++", ""), attr);
			}
		});
		xmpBasicRating.setDocument(doc);
	}

	private void traverseFields(pmedit.MetadataEditPane.FieldSetGet setGet, pmedit.MetadataEditPane.FieldEnabledCheckBox fieldEnabled) {
		for (java.lang.reflect.Field field : this.getClass().getFields()) {
			if (setGet != null) {
				pmedit.FieldID annos = field.getAnnotation(pmedit.FieldID.class);
				if (annos != null) {
					if ((annos.value() != null) && (annos.value().length() > 0)) {
						java.lang.Object f = null;
						try {
							f = field.get(this);
						} catch (java.lang.IllegalArgumentException e) {
							java.lang.System.err.println(("traverseFields on (" + annos.value()) + ")");
							e.printStackTrace();
							continue;
						} catch (java.lang.IllegalAccessException e) {
							java.lang.System.err.println(("traverseFields on (" + annos.value()) + ")");
							e.printStackTrace();
							continue;
						}
						setGet.apply(f, annos);
					}
				}
			}
			if (fieldEnabled != null) {
				pmedit.FieldEnabled annosEnabled = field.getAnnotation(pmedit.FieldEnabled.class);
				if (annosEnabled != null) {
					try {
						javax.swing.JCheckBox f = ((javax.swing.JCheckBox) (field.get(this)));
						fieldEnabled.apply(f, annosEnabled);
					} catch (java.lang.IllegalArgumentException e) {
						java.lang.System.err.println(("traverseFields on (" + annosEnabled.value()) + ")");
						e.printStackTrace();
						continue;
					} catch (java.lang.IllegalAccessException e) {
						java.lang.System.err.println(("traverseFields on (" + annosEnabled.value()) + ")");
						e.printStackTrace();
						continue;
					}
				}
			}
		}
	}

	public void showEnabled(final boolean show) {
		traverseFields(null, new pmedit.MetadataEditPane.FieldEnabledCheckBox() {
			@java.lang.Override
			public void apply(javax.swing.JCheckBox field, pmedit.FieldEnabled anno) {
				field.setVisible(show);
				field.setEnabled(show);
			}
		});
	}

	public void disableEdit() {
		traverseFields(new pmedit.MetadataEditPane.FieldSetGet() {
			@java.lang.Override
			public void apply(java.lang.Object field, pmedit.FieldID anno) {
				if (field instanceof javax.swing.JComponent) {
					((javax.swing.JComponent) (field)).setEnabled(false);
				}
			}
		}, null);
	}

	void clear() {
		traverseFields(new pmedit.MetadataEditPane.FieldSetGet() {
			@java.lang.Override
			public void apply(java.lang.Object field, pmedit.FieldID anno) {
				if (field instanceof javax.swing.JTextField) {
					((javax.swing.JTextField) (field)).setText(null);
				}
				if (field instanceof javax.swing.JTextArea) {
					((javax.swing.JTextArea) (field)).setText(null);
				}
				if (field instanceof javax.swing.JComboBox) {
					objectToField(((javax.swing.JComboBox) (field)), null, anno.type() == pmedit.FieldID.FieldType.BoolField);
				}
				if (field instanceof com.toedter.calendar.JDateChooser) {
					objectToField(((com.toedter.calendar.JDateChooser) (field)), null);
				}
				if (field instanceof javax.swing.JSpinner) {
					objectToField(((javax.swing.JSpinner) (field)), null);
				}
			}
		}, new pmedit.MetadataEditPane.FieldEnabledCheckBox() {
			@java.lang.Override
			public void apply(javax.swing.JCheckBox field, pmedit.FieldEnabled anno) {
				field.setSelected(true);
			}
		});
	}

	void fillFromMetadata(final pmedit.MetadataInfo metadataInfo) {
		traverseFields(new pmedit.MetadataEditPane.FieldSetGet() {
			@java.lang.Override
			public void apply(java.lang.Object field, pmedit.FieldID anno) {
				if (field instanceof javax.swing.JTextField) {
					((javax.swing.JTextField) (field)).setText(metadataInfo.getString(anno.value()));
				}
				if (field instanceof javax.swing.JTextArea) {
					((javax.swing.JTextArea) (field)).setText(metadataInfo.getString(anno.value()));
				}
				java.lang.Object value = metadataInfo.get(anno.value());
				if (field instanceof javax.swing.JComboBox) {
					objectToField(((javax.swing.JComboBox) (field)), value, anno.type() == pmedit.FieldID.FieldType.BoolField);
				}
				if (field instanceof com.toedter.calendar.JDateChooser) {
					objectToField(((com.toedter.calendar.JDateChooser) (field)), value);
				}
				if (field instanceof javax.swing.JSpinner) {
					objectToField(((javax.swing.JSpinner) (field)), value);
				}
			}
		}, new pmedit.MetadataEditPane.FieldEnabledCheckBox() {
			@java.lang.Override
			public void apply(javax.swing.JCheckBox field, pmedit.FieldEnabled anno) {
				field.setSelected(metadataInfo.isEnabled(anno.value()));
			}
		});
	}

	void copyToMetadata(final pmedit.MetadataInfo metadataInfo) {
		traverseFields(new pmedit.MetadataEditPane.FieldSetGet() {
			@java.lang.Override
			public void apply(java.lang.Object field, pmedit.FieldID anno) {
				if ((field instanceof javax.swing.JTextField) || (field instanceof javax.swing.JTextArea)) {
					java.lang.String text = (field instanceof javax.swing.JTextField) ? ((javax.swing.JTextField) (field)).getText() : ((javax.swing.JTextArea) (field)).getText();
					if (text.length() == 0) {
						text = null;
					}
					metadataInfo.setFromString(anno.value(), text);
				}
				if (field instanceof javax.swing.JSpinner) {
					switch (anno.type()) {
						case IntField :
							java.lang.Integer i = ((java.lang.Integer) (((javax.swing.JSpinner) (field)).getModel().getValue()));
							metadataInfo.set(anno.value(), i);
							break;
						default :
							throw new java.lang.RuntimeException("Cannot store Integer in :" + anno.type());
					}
				}
				if (field instanceof javax.swing.JComboBox) {
					java.lang.String text = ((java.lang.String) (((javax.swing.JComboBox) (field)).getModel().getSelectedItem()));
					if ((text != null) && (text.length() == 0)) {
						text = null;
					}
					switch (anno.type()) {
						case StringField :
							metadataInfo.set(anno.value(), text);
							break;
						case BoolField :
							metadataInfo.setFromString(anno.value(), text);
							break;
						default :
							throw new java.lang.RuntimeException("Cannot (store (choice text) in :" + anno.type());
					}
				}
				if (field instanceof com.toedter.calendar.JDateChooser) {
					switch (anno.type()) {
						case DateField :
							metadataInfo.set(anno.value(), ((com.toedter.calendar.JDateChooser) (field)).getCalendar());
							break;
						default :
							throw new java.lang.RuntimeException("Cannot store Calendar in :" + anno.type());
					}
				}
			}
		}, new pmedit.MetadataEditPane.FieldEnabledCheckBox() {
			@java.lang.Override
			public void apply(javax.swing.JCheckBox field, pmedit.FieldEnabled anno) {
				metadataInfo.setEnabled(anno.value(), field.isSelected());
			}
		});
	}

	private void objectToField(javax.swing.JComboBox field, java.lang.Object o, boolean oIsBool) {
		if (o instanceof java.lang.String) {
			field.getModel().setSelectedItem(o);
		} else if ((o instanceof java.lang.Boolean) || oIsBool) {
			java.lang.String v = "Unset";
			if (o != null) {
				v = (((java.lang.Boolean) (o))) ? "Yes" : "No";
			}
			field.getModel().setSelectedItem(v);
		} else if (o == null) {
			field.setSelectedIndex(-1);
		} else {
			java.lang.RuntimeException e = new java.lang.RuntimeException("Cannot store non-String object in JComboBox");
			e.printStackTrace();
			throw e;
		}
	}

	private void objectToField(com.toedter.calendar.JDateChooser field, java.lang.Object o) {
		if (o instanceof java.util.Calendar) {
			field.setCalendar(((java.util.Calendar) (o)));
		} else if (o == null) {
			field.setCalendar(null);
		} else {
			java.lang.RuntimeException e = new java.lang.RuntimeException("Cannot store non-Calendar object in JDateChooser");
			e.printStackTrace();
			throw e;
		}
	}

	private void objectToField(javax.swing.JSpinner field, java.lang.Object o) {
		if (o instanceof java.lang.Integer) {
			field.setValue(((java.lang.Integer) (o)));
		} else if (o == null) {
			field.setValue(((java.lang.Integer) (0)));
		} else {
			java.lang.RuntimeException e = new java.lang.RuntimeException("Cannot store non-Integerr object in JSpinner");
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(java.lang.String[] args) {
		java.awt.EventQueue.invokeLater(new java.lang.Runnable() {
			public void run() {
				try {
					pmedit.MetadataEditPane pane = new pmedit.MetadataEditPane();
					javax.swing.JFrame frame = new javax.swing.JFrame();
					frame.getContentPane().add(pane.tabbedaPane);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
					frame.setSize(640, 480);
				} catch (java.lang.Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}