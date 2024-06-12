public class ProxyTester extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	private javax.swing.JComboBox<com.github.markusbernhardt.proxy.ProxySearch.Strategy> modes;

	private javax.swing.JButton testButton;

	private javax.swing.JTextField urlField;

	private javax.swing.JTextArea logArea;

	public ProxyTester() {
		super();
		init();
	}

	private void init() {
		setTitle("Proxy Vole Tester");
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		javax.swing.JPanel p = new javax.swing.JPanel();
		p.add(new javax.swing.JLabel("Mode:"));
		this.modes = new javax.swing.JComboBox<com.github.markusbernhardt.proxy.ProxySearch.Strategy>(com.github.markusbernhardt.proxy.ProxySearch.Strategy.values());
		p.add(this.modes);
		p.add(new javax.swing.JLabel("URL:"));
		this.urlField = new javax.swing.JTextField(30);
		this.urlField.setText("http://www.google.com/");
		p.add(this.urlField);
		this.testButton = new javax.swing.JButton("Test");
		this.testButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				testUrl();
			}
		});
		p.add(this.testButton);
		this.logArea = new javax.swing.JTextArea(5, 50);
		javax.swing.JPanel contenPane = new javax.swing.JPanel(new java.awt.BorderLayout());
		contenPane.add(p, java.awt.BorderLayout.NORTH);
		contenPane.add(new javax.swing.JScrollPane(this.logArea), java.awt.BorderLayout.CENTER);
		setContentPane(contenPane);
		pack();
		setLocationRelativeTo(null);
		installLogger();
	}

	private void installLogger() {
		com.github.markusbernhardt.proxy.util.Logger.setBackend(new com.github.markusbernhardt.proxy.util.Logger.LogBackEnd() {
			public void log(java.lang.Class<?> clazz, com.github.markusbernhardt.proxy.util.Logger.LogLevel loglevel, java.lang.String msg, java.lang.Object... params) {
				ProxyTester.this.logArea.append(((loglevel + "\t") + java.text.MessageFormat.format(msg, params)) + "\n");
			}
		});
	}

	protected void testUrl() {
		try {
			if (this.urlField.getText().trim().length() == 0) {
				this.logArea.append("ERROR\tPlease enter an URL first.\n");
				return;
			}
			this.logArea.setText("");
			com.github.markusbernhardt.proxy.ProxySearch.Strategy pss = ((com.github.markusbernhardt.proxy.ProxySearch.Strategy) (this.modes.getSelectedItem()));
			com.github.markusbernhardt.proxy.ProxySearch ps = new com.github.markusbernhardt.proxy.ProxySearch();
			ps.addStrategy(pss);
			java.net.ProxySelector psel = ps.getProxySelector();
			if (psel == null) {
				this.logArea.append("ERROR\tNo proxy settings available for this mode.\n");
				return;
			}
			java.net.ProxySelector.setDefault(psel);
			java.net.URL url = new java.net.URL(this.urlField.getText().trim());
			java.util.List<java.net.Proxy> result = psel.select(url.toURI());
			if ((result == null) || (result.size() == 0)) {
				this.logArea.append("INFO\tNo proxy found for this url.\n");
				return;
			}
			this.logArea.append(("INFO\tProxy Settings found using " + pss) + " strategy.\n");
			this.logArea.append(("INFO\tProxy used for URL is: " + result.get(0)) + "\n");
		} catch (java.lang.Exception e) {
			javax.swing.JOptionPane.showMessageDialog(this, "Error:" + e.getMessage(), "Error checking URL.", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(java.lang.String[] args) {
		javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
			public void run() {
				com.github.markusbernhardt.proxy.ui.ProxyTester.setLookAndFeel();
				com.github.markusbernhardt.proxy.ui.ProxyTester mainFrame = new com.github.markusbernhardt.proxy.ui.ProxyTester();
				mainFrame.setVisible(true);
			}
		});
	}

	private static void setLookAndFeel() {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (java.lang.Exception e) {
		}
	}
}