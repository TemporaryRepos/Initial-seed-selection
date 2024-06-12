public class Start extends javax.swing.JFrame {
	private static final long serialVersionUID = 85744461208L;

	public Start() {
		this.setTitle("相似度计算演示程序");
		this.setSize(420, 700);
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
		java.awt.Container contentPane = this.getContentPane();
		javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
		tabbedPane.add("词语", ruc.irm.ui.WordSimlarityUI.createPanel());
		tabbedPane.add("短语", ruc.irm.ui.PhraseSimilarityUI.createPanel());
		tabbedPane.add("句子", ruc.irm.ui.SentenceSimilarityUI.createPanel());
		tabbedPane.add("词法分析", ruc.irm.similarity.sentence.SegmentProxy.createPanel());
		tabbedPane.add("义原树", ruc.irm.ui.SememeTreeUI.createPanel());
		tabbedPane.add("情感分析", ruc.irm.ui.TendencyUI.createPanel());
		tabbedPane.add("关于", ruc.irm.similarity.util.About.createPanel());
		javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tabbedPane);
		contentPane.add(scrollPane);
		this.pack();
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	public static void InitGlobalFont(java.awt.Font font) {
		javax.swing.plaf.FontUIResource fontRes = new javax.swing.plaf.FontUIResource(font);
		for (java.util.Enumeration<java.lang.Object> keys = javax.swing.UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			java.lang.Object key = keys.nextElement();
			java.lang.Object value = javax.swing.UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				javax.swing.UIManager.put(key, fontRes);
			}
		}
	}

	public static void main(java.lang.String[] args) {
		ruc.irm.ui.Start.InitGlobalFont(new java.awt.Font("Microsoft YaHei", java.awt.Font.TRUETYPE_FONT, 12));
		javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
			public void run() {
				ruc.irm.ui.Start w = new ruc.irm.ui.Start();
				w.setVisible(true);
			}
		});
	}
}