public class VerifyDialog extends javax.swing.JDialog {
	private static final long serialVersionUID = -6374807677043142313L;

	private javax.swing.JPanel ivjJDialogContentPane = null;

	private javax.swing.JPanel ivjPass1Panel = null;

	private javax.swing.JPanel ivjPass2Panel = null;

	private javax.swing.JPanel ivjPass3Panel = null;

	private javax.swing.JButton ivjPass1Button = null;

	private javax.swing.JButton ivjPass2Button = null;

	private javax.swing.JButton ivjPass3Button = null;

	private final org.apache.bcel.verifier.VerifyDialog.IvjEventHandler ivjEventHandler = new org.apache.bcel.verifier.VerifyDialog.IvjEventHandler();

	private java.lang.String class_name = "java.lang.Object";

	private static int classes_to_verify;

	class IvjEventHandler implements java.awt.event.ActionListener {
		@java.lang.Override
		public void actionPerformed(final java.awt.event.ActionEvent e) {
			if (e.getSource() == VerifyDialog.this.getPass1Button()) {
				connEtoC1(e);
			}
			if (e.getSource() == VerifyDialog.this.getPass2Button()) {
				connEtoC2(e);
			}
			if (e.getSource() == VerifyDialog.this.getPass3Button()) {
				connEtoC3(e);
			}
			if (e.getSource() == VerifyDialog.this.getFlushButton()) {
				connEtoC4(e);
			}
		}
	}

	private javax.swing.JButton ivjFlushButton = null;

	public VerifyDialog() {
		super();
		initialize();
	}

	public VerifyDialog(final java.awt.Dialog owner) {
		super(owner);
	}

	public VerifyDialog(final java.awt.Dialog owner, final java.lang.String title) {
		super(owner, title);
	}

	public VerifyDialog(final java.awt.Dialog owner, final java.lang.String title, final boolean modal) {
		super(owner, title, modal);
	}

	public VerifyDialog(final java.awt.Dialog owner, final boolean modal) {
		super(owner, modal);
	}

	public VerifyDialog(final java.awt.Frame owner) {
		super(owner);
	}

	public VerifyDialog(final java.awt.Frame owner, final java.lang.String title) {
		super(owner, title);
	}

	public VerifyDialog(final java.awt.Frame owner, final java.lang.String title, final boolean modal) {
		super(owner, title, modal);
	}

	public VerifyDialog(final java.awt.Frame owner, final boolean modal) {
		super(owner, modal);
	}

	public VerifyDialog(java.lang.String fully_qualified_class_name) {
		super();
		final int dotclasspos = fully_qualified_class_name.lastIndexOf(".class");
		if (dotclasspos != (-1)) {
			fully_qualified_class_name = fully_qualified_class_name.substring(0, dotclasspos);
		}
		fully_qualified_class_name = fully_qualified_class_name.replace('/', '.');
		class_name = fully_qualified_class_name;
		initialize();
	}

	private void connEtoC1(final java.awt.event.ActionEvent arg1) {
		try {
			this.pass1Button_ActionPerformed(arg1);
		} catch (final java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	private void connEtoC2(final java.awt.event.ActionEvent arg1) {
		try {
			this.pass2Button_ActionPerformed(arg1);
		} catch (final java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	private void connEtoC3(final java.awt.event.ActionEvent arg1) {
		try {
			this.pass4Button_ActionPerformed(arg1);
		} catch (final java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	private void connEtoC4(final java.awt.event.ActionEvent arg1) {
		try {
			this.flushButton_ActionPerformed(arg1);
		} catch (final java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	}

	public void flushButton_ActionPerformed(final java.awt.event.ActionEvent actionEvent) {
		org.apache.bcel.verifier.VerifierFactory.getVerifier(class_name).flush();
		org.apache.bcel.Repository.removeClass(class_name);
		getPass1Panel().setBackground(java.awt.Color.gray);
		getPass1Panel().repaint();
		getPass2Panel().setBackground(java.awt.Color.gray);
		getPass2Panel().repaint();
		getPass3Panel().setBackground(java.awt.Color.gray);
		getPass3Panel().repaint();
	}

	private javax.swing.JButton getFlushButton() {
		if (ivjFlushButton == null) {
			try {
				ivjFlushButton = new javax.swing.JButton();
				ivjFlushButton.setName("FlushButton");
				ivjFlushButton.setText("Flush: Forget old verification results");
				ivjFlushButton.setBackground(java.awt.SystemColor.controlHighlight);
				ivjFlushButton.setBounds(60, 215, 300, 30);
				ivjFlushButton.setForeground(java.awt.Color.red);
				ivjFlushButton.setActionCommand("FlushButton");
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjFlushButton;
	}

	private javax.swing.JPanel getJDialogContentPane() {
		if (ivjJDialogContentPane == null) {
			try {
				ivjJDialogContentPane = new javax.swing.JPanel();
				ivjJDialogContentPane.setName("JDialogContentPane");
				ivjJDialogContentPane.setLayout(null);
				getJDialogContentPane().add(getPass1Panel(), getPass1Panel().getName());
				getJDialogContentPane().add(getPass3Panel(), getPass3Panel().getName());
				getJDialogContentPane().add(getPass2Panel(), getPass2Panel().getName());
				getJDialogContentPane().add(getPass1Button(), getPass1Button().getName());
				getJDialogContentPane().add(getPass2Button(), getPass2Button().getName());
				getJDialogContentPane().add(getPass3Button(), getPass3Button().getName());
				getJDialogContentPane().add(getFlushButton(), getFlushButton().getName());
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjJDialogContentPane;
	}

	private javax.swing.JButton getPass1Button() {
		if (ivjPass1Button == null) {
			try {
				ivjPass1Button = new javax.swing.JButton();
				ivjPass1Button.setName("Pass1Button");
				ivjPass1Button.setText("Pass1: Verify binary layout of .class file");
				ivjPass1Button.setBackground(java.awt.SystemColor.controlHighlight);
				ivjPass1Button.setBounds(100, 40, 300, 30);
				ivjPass1Button.setActionCommand("Button1");
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass1Button;
	}

	private javax.swing.JPanel getPass1Panel() {
		if (ivjPass1Panel == null) {
			try {
				ivjPass1Panel = new javax.swing.JPanel();
				ivjPass1Panel.setName("Pass1Panel");
				ivjPass1Panel.setLayout(null);
				ivjPass1Panel.setBackground(java.awt.SystemColor.controlShadow);
				ivjPass1Panel.setBounds(30, 30, 50, 50);
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass1Panel;
	}

	private javax.swing.JButton getPass2Button() {
		if (ivjPass2Button == null) {
			try {
				ivjPass2Button = new javax.swing.JButton();
				ivjPass2Button.setName("Pass2Button");
				ivjPass2Button.setText("Pass 2: Verify static .class file constraints");
				ivjPass2Button.setBackground(java.awt.SystemColor.controlHighlight);
				ivjPass2Button.setBounds(100, 100, 300, 30);
				ivjPass2Button.setActionCommand("Button2");
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass2Button;
	}

	private javax.swing.JPanel getPass2Panel() {
		if (ivjPass2Panel == null) {
			try {
				ivjPass2Panel = new javax.swing.JPanel();
				ivjPass2Panel.setName("Pass2Panel");
				ivjPass2Panel.setLayout(null);
				ivjPass2Panel.setBackground(java.awt.SystemColor.controlShadow);
				ivjPass2Panel.setBounds(30, 90, 50, 50);
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass2Panel;
	}

	private javax.swing.JButton getPass3Button() {
		if (ivjPass3Button == null) {
			try {
				ivjPass3Button = new javax.swing.JButton();
				ivjPass3Button.setName("Pass3Button");
				ivjPass3Button.setText("Passes 3a+3b: Verify code arrays");
				ivjPass3Button.setBackground(java.awt.SystemColor.controlHighlight);
				ivjPass3Button.setBounds(100, 160, 300, 30);
				ivjPass3Button.setActionCommand("Button2");
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass3Button;
	}

	private javax.swing.JPanel getPass3Panel() {
		if (ivjPass3Panel == null) {
			try {
				ivjPass3Panel = new javax.swing.JPanel();
				ivjPass3Panel.setName("Pass3Panel");
				ivjPass3Panel.setLayout(null);
				ivjPass3Panel.setBackground(java.awt.SystemColor.controlShadow);
				ivjPass3Panel.setBounds(30, 150, 50, 50);
			} catch (final java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return ivjPass3Panel;
	}

	private void handleException(final java.lang.Throwable exception) {
		java.lang.System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		exception.printStackTrace(java.lang.System.out);
		if (exception instanceof java.lang.ThreadDeath) {
			throw ((java.lang.ThreadDeath) (exception));
		}
		if (exception instanceof java.lang.VirtualMachineError) {
			throw ((java.lang.VirtualMachineError) (exception));
		}
	}

	private void initConnections() throws java.lang.Exception {
		getPass1Button().addActionListener(ivjEventHandler);
		getPass2Button().addActionListener(ivjEventHandler);
		getPass3Button().addActionListener(ivjEventHandler);
		getFlushButton().addActionListener(ivjEventHandler);
	}

	private void initialize() {
		try {
			setName("VerifyDialog");
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			setSize(430, 280);
			setVisible(true);
			setModal(true);
			setResizable(false);
			setContentPane(getJDialogContentPane());
			initConnections();
		} catch (final java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		setTitle(("'" + class_name) + "' verification - JustIce / BCEL");
	}

	public static void main(final java.lang.String[] args) {
		org.apache.bcel.verifier.VerifyDialog.classes_to_verify = args.length;
		for (final java.lang.String arg : args) {
			try {
				org.apache.bcel.verifier.VerifyDialog aVerifyDialog;
				aVerifyDialog = new org.apache.bcel.verifier.VerifyDialog(arg);
				aVerifyDialog.setModal(true);
				aVerifyDialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@java.lang.Override
					public void windowClosing(final java.awt.event.WindowEvent e) {
						org.apache.bcel.verifier.VerifyDialog.classes_to_verify--;
						if (org.apache.bcel.verifier.VerifyDialog.classes_to_verify == 0) {
							java.lang.System.exit(0);
						}
					}
				});
				aVerifyDialog.setVisible(true);
			} catch (final java.lang.Throwable exception) {
				java.lang.System.err.println("Exception occurred in main() of javax.swing.JDialog");
				exception.printStackTrace(java.lang.System.out);
			}
		}
	}

	public void pass1Button_ActionPerformed(final java.awt.event.ActionEvent actionEvent) {
		final org.apache.bcel.verifier.Verifier v = org.apache.bcel.verifier.VerifierFactory.getVerifier(class_name);
		final org.apache.bcel.verifier.VerificationResult vr = v.doPass1();
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_OK) {
			getPass1Panel().setBackground(java.awt.Color.green);
			getPass1Panel().repaint();
		}
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_REJECTED) {
			getPass1Panel().setBackground(java.awt.Color.red);
			getPass1Panel().repaint();
		}
	}

	public void pass2Button_ActionPerformed(final java.awt.event.ActionEvent actionEvent) {
		pass1Button_ActionPerformed(actionEvent);
		final org.apache.bcel.verifier.Verifier v = org.apache.bcel.verifier.VerifierFactory.getVerifier(class_name);
		final org.apache.bcel.verifier.VerificationResult vr = v.doPass2();
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_OK) {
			getPass2Panel().setBackground(java.awt.Color.green);
			getPass2Panel().repaint();
		}
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_NOTYET) {
			getPass2Panel().setBackground(java.awt.Color.yellow);
			getPass2Panel().repaint();
		}
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_REJECTED) {
			getPass2Panel().setBackground(java.awt.Color.red);
			getPass2Panel().repaint();
		}
	}

	public void pass4Button_ActionPerformed(final java.awt.event.ActionEvent actionEvent) {
		pass2Button_ActionPerformed(actionEvent);
		java.awt.Color color = java.awt.Color.green;
		final org.apache.bcel.verifier.Verifier v = org.apache.bcel.verifier.VerifierFactory.getVerifier(class_name);
		org.apache.bcel.verifier.VerificationResult vr = v.doPass2();
		if (vr.getStatus() == org.apache.bcel.verifier.VerificationResult.VERIFIED_OK) {
			org.apache.bcel.classfile.JavaClass jc = null;
			try {
				jc = org.apache.bcel.Repository.lookupClass(class_name);
				final int nr = jc.getMethods().length;
				for (int i = 0; i < nr; i++) {
					vr = v.doPass3b(i);
					if (vr.getStatus() != org.apache.bcel.verifier.VerificationResult.VERIFIED_OK) {
						color = java.awt.Color.red;
						break;
					}
				}
			} catch (final java.lang.ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		} else {
			color = java.awt.Color.yellow;
		}
		getPass3Panel().setBackground(color);
		getPass3Panel().repaint();
	}
}