public class WordSimlarityUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 632985744461208L;

	public WordSimlarityUI() {
		this.setTitle("同义词词林演示程序");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		this.setJMenuBar(menuBar);
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
		menuBar.add(fileMenu);
		fileMenu.add(new javax.swing.JMenuItem("Exit"));
		javax.swing.JMenu helpMenu = new javax.swing.JMenu("Help");
		menuBar.add(helpMenu);
		helpMenu.add(new javax.swing.JMenuItem("Help"));
		javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
		this.add(toolBar, java.awt.BorderLayout.PAGE_START);
		toolBar.add(new javax.swing.JLabel("选项:"));
		java.awt.Container contentPane = this.getContentPane();
		javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(ruc.irm.ui.WordSimlarityUI.createPanel());
		contentPane.add(scrollPane);
	}

	public static javax.swing.JPanel createPanel() {
		final javax.swing.JPanel fullPanel = new javax.swing.JPanel();
		fullPanel.setLayout(new java.awt.BorderLayout());
		javax.swing.JPanel northPanel = new javax.swing.JPanel();
		fullPanel.add(northPanel, "North");
		javax.swing.JPanel centerPanel = new javax.swing.JPanel();
		fullPanel.add(centerPanel, "Center");
		centerPanel.setLayout(new java.awt.BorderLayout());
		final javax.swing.JTextArea result = new javax.swing.JTextArea();
		result.setLineWrap(true);
		javax.swing.JScrollPane centerScrollPane = new javax.swing.JScrollPane(result);
		centerPanel.add(centerScrollPane, "Center");
		northPanel.setLayout(new java.awt.GridLayout(2, 1));
		final javax.swing.JTextField wordField1 = new javax.swing.JTextField("电动车");
		final javax.swing.JTextField wordField2 = new javax.swing.JTextField("助力车");
		wordField1.setColumns(50);
		wordField2.setColumns(50);
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.GridLayout(3, 1));
		javax.swing.JPanel linePanel = new javax.swing.JPanel();
		linePanel.add(new javax.swing.JLabel("词语1:"));
		linePanel.add(wordField1);
		mainPanel.add(linePanel);
		linePanel = new javax.swing.JPanel();
		linePanel.add(new javax.swing.JLabel("词语2:"));
		linePanel.add(wordField2);
		mainPanel.add(linePanel);
		linePanel = new javax.swing.JPanel();
		javax.swing.JButton loadButton = new javax.swing.JButton("加载自定义概念文件");
		linePanel.add(loadButton);
		javax.swing.JButton goButton = new javax.swing.JButton("计算词语相似度");
		linePanel.add(goButton);
		mainPanel.add(linePanel);
		loadButton.addActionListener(new java.awt.event.ActionListener() {
			@java.lang.Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				java.lang.StringBuilder sb = new java.lang.StringBuilder();
				sb.append("[Help]概念词典格式举例：\n");
				sb.append("<?xml version=\"1.0\"?>\n");
				sb.append("<concepts>\n");
				sb.append("  <!--\n");
				sb.append("  <c w=\"汉语词语\" p=\"词性，取值为：V|N|ADJ|NUM|PREP等\" d=\"对应的义原形式的定义\"/>\n");
				sb.append("  -->\n");
				sb.append("  <c w=\"三聚氰胺\" p=\"N\" d=\"material|材料,#drinks|饮品\"/>\n");
				sb.append("  <c w=\"山寨\" p=\"V\" d=\"pretend|假装,content=RegardAs|当作\"/>\n");
				sb.append("</concepts>");
				result.setText(sb.toString());
				result.setCaretPosition(0);
				javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
				chooser.setDialogTitle("选择要打开的概念文件");
				chooser.showOpenDialog(fullPanel);
				java.io.File choosedFile = chooser.getSelectedFile();
				if (choosedFile != null) {
					try {
						ruc.irm.similarity.word.hownet2.concept.BaseConceptParser.load(choosedFile);
						result.setText("加载完毕.\n------------------------------\n" + result.getText());
					} catch (java.io.IOException e1) {
						result.setText((e1.getMessage() + "\n------------------------------\n") + result.getText());
						result.setCaretPosition(0);
					}
				}
			}
		});
		goButton.addActionListener(new java.awt.event.ActionListener() {
			@java.lang.Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				java.lang.String word1 = wordField1.getText();
				java.lang.String word2 = wordField2.getText();
				java.lang.String text = ((("[" + word1) + "]与[") + word2) + "]的相似度为:";
				text = (text + "\n词林:") + ruc.irm.similarity.word.cilin.Cilin.getInstance().getSimilarity(word1, word2);
				text = (text + "\n刘群:") + ruc.irm.similarity.word.hownet2.concept.LiuConceptParser.getInstance().getSimilarity(word1, word2);
				text = (text + "\n夏天:") + ruc.irm.similarity.word.hownet2.concept.XiaConceptParser.getInstance().getSimilarity(word1, word2);
				text = (text + "\n字面:") + new ruc.irm.similarity.word.CharBasedSimilarity().getSimilarity(word1, word2);
				text += "\n__________________________________\n";
				text += result.getText();
				result.setText(text);
				result.setCaretPosition(0);
			}
		});
		mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		northPanel.add(mainPanel);
		mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.GridLayout(2, 1));
		final javax.swing.JTextField cilinField = new javax.swing.JTextField("中国");
		cilinField.setColumns(50);
		linePanel = new javax.swing.JPanel();
		linePanel.add(new javax.swing.JLabel("词语或编码:"));
		linePanel.add(cilinField);
		mainPanel.add(linePanel);
		linePanel = new javax.swing.JPanel();
		javax.swing.JButton viewWordsInCodeButton = new javax.swing.JButton("该编码下的词林词语");
		javax.swing.JButton viewCodeButton = new javax.swing.JButton("该词语的词林编码");
		javax.swing.JButton viewConceptButton = new javax.swing.JButton("知网概念");
		viewWordsInCodeButton.addActionListener(new java.awt.event.ActionListener() {
			@java.lang.Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				java.lang.String text = (("具有编码" + cilinField.getText()) + "的词语有:") + ruc.irm.similarity.word.cilin.CilinDb.getInstance().getCilinWords(cilinField.getText());
				text += "\n__________________________________\n";
				text += result.getText();
				result.setText(text);
				result.setCaretPosition(0);
			}
		});
		viewCodeButton.addActionListener(new java.awt.event.ActionListener() {
			@java.lang.Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				java.lang.String text = (cilinField.getText() + "的编码为:") + ruc.irm.similarity.word.cilin.CilinDb.getInstance().getCilinCoding(cilinField.getText());
				text += "\n__________________________________\n";
				text += result.getText();
				result.setText(text);
				result.setCaretPosition(0);
			}
		});
		viewConceptButton.addActionListener(new java.awt.event.ActionListener() {
			@java.lang.Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				java.lang.String text = "";
				java.util.Collection<ruc.irm.similarity.word.hownet2.concept.Concept> concepts = ruc.irm.similarity.word.hownet2.concept.XiaConceptParser.getInstance().getConcepts(cilinField.getText());
				if ((concepts == null) || (concepts.size() == 0)) {
					text = "自动组合概念结果:\n";
					concepts = ruc.irm.similarity.word.hownet2.concept.XiaConceptParser.getInstance().autoCombineConcepts(cilinField.getText(), null);
				}
				int i = 1;
				for (ruc.irm.similarity.word.hownet2.concept.Concept c : concepts) {
					text = ((((text + "概念") + i) + ": ") + c.toString()) + "\n\n";
					i++;
				}
				text += "__________________________________\n";
				text += result.getText();
				result.setText(text);
				result.setCaretPosition(0);
			}
		});
		linePanel.add(viewWordsInCodeButton);
		linePanel.add(viewCodeButton);
		linePanel.add(viewConceptButton);
		mainPanel.add(linePanel);
		northPanel.add(mainPanel);
		return fullPanel;
	}

	public static void main(java.lang.String[] args) {
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
		javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
			public void run() {
				ruc.irm.ui.WordSimlarityUI w = new ruc.irm.ui.WordSimlarityUI();
				w.setVisible(true);
			}
		});
	}
}