public class GraphApplet extends java.applet.Applet {
	private jit.misctests.fpustack.GraphPanel panel;

	private boolean isApplet = true;

	private boolean initialized = false;

	public static void main(java.lang.String[] args) {
		java.awt.Frame f = new java.awt.Frame("GraphApplet");
		jit.misctests.fpustack.GraphApplet app = new jit.misctests.fpustack.GraphApplet();
		app.isApplet = false;
		app.setSize(600, 400);
		f.setLayout(new java.awt.BorderLayout());
		f.add("Center", app);
		f.setSize(600, 400);
		app.init();
		f.show(true);
		app.start();
		try {
			java.lang.Thread.currentThread().sleep(5 * 1000);
		} catch (java.lang.InterruptedException e) {
		}
		f.show(false);
		app.stop();
		f.dispose();
		return;
	}

	public synchronized void init() {
		java.lang.System.out.println("GraphApplet : init");
		setLayout(new java.awt.BorderLayout());
		panel = new jit.misctests.fpustack.GraphPanel(this, new jit.misctests.fpustack.layout());
		fill(panel);
		add("Center", panel);
		java.awt.Panel p = new java.awt.Panel();
		add("South", p);
		initialized = true;
	}

	public synchronized void start() {
		java.lang.System.out.println("GraphApplet : start");
		panel.formatNodes();
	}

	public synchronized void stop() {
		initialized = false;
		java.lang.System.out.println("GraphApplet : stop");
	}

	public synchronized void destroy() {
		java.lang.System.out.println("GraphApplet : destroy");
	}

	public synchronized void paint(java.awt.Graphics g) {
		try {
			while (!initialized) {
				java.lang.Thread.currentThread().sleep(5);
			} 
		} catch (java.lang.InterruptedException e) {
		}
		if (g instanceof java.awt.PrintGraphics) {
			java.lang.System.out.println("printing GraphApplet ...");
		}
	}

	public synchronized void print(java.awt.Graphics g) {
		try {
			while (!initialized) {
				java.lang.Thread.currentThread().sleep(5);
			} 
		} catch (java.lang.InterruptedException e) {
		}
		java.lang.System.out.println("Print Applet " + g);
		panel.print(g);
	}

	public void print() {
		java.awt.Toolkit kit = getToolkit();
		try {
			java.awt.PrintJob job = kit.getPrintJob(new java.awt.Frame("x"), "PrintableFrame print job", null);
			if (job != null) {
				java.awt.Graphics g = job.getGraphics();
				printAll(g);
				g.dispose();
				job.end();
			}
		} catch (java.lang.Exception ex) {
			java.lang.System.out.println("print exception " + ex);
		}
	}

	private void fill(jit.misctests.fpustack.GraphPanel panel) {
		panel.addNodes("Node1", "Node2", "Node3");
	}
}