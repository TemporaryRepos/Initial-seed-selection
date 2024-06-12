public class Plot2DCanvas extends org.math.plot.canvas.PlotCanvas {
	private static final long serialVersionUID = 1L;

	public Plot2DCanvas() {
		super();
		ActionMode = org.math.plot.canvas.PlotCanvas.ZOOM;
	}

	public Plot2DCanvas(org.math.plot.plotObjects.Base b, org.math.plot.plotObjects.BasePlot bp) {
		super(b, bp);
		ActionMode = org.math.plot.canvas.PlotCanvas.ZOOM;
	}

	public Plot2DCanvas(double[] min, double[] max, java.lang.String[] axesScales, java.lang.String[] axesLabels) {
		super(min, max, axesScales, axesLabels);
		ActionMode = org.math.plot.canvas.PlotCanvas.ZOOM;
	}

	public void initDrawer() {
		draw = new org.math.plot.render.AWTDrawer2D(this);
	}

	public void initBasenGrid(double[] min, double[] max) {
		initBasenGrid(min, max, new java.lang.String[]{ org.math.plot.plotObjects.Base.LINEAR, org.math.plot.plotObjects.Base.LINEAR }, new java.lang.String[]{ "X", "Y" });
	}

	public void initBasenGrid() {
		initBasenGrid(new double[]{ 0, 0 }, new double[]{ 1, 1 });
	}

	private static double[][] convertY(double[] XY) {
		double[] x = org.math.plot.utils.Array.increment(XY.length, 1, 1);
		return org.math.plot.utils.Array.mergeColumns(x, XY);
	}

	private static double[][] convertXY(double[]... XY) {
		if ((XY.length == 2) && (XY[0].length != 2)) {
			return org.math.plot.utils.Array.mergeColumns(XY[0], XY[1]);
		} else {
			return XY;
		}
	}

	public int addScatterPlot(java.lang.String name, java.awt.Color c, double[] Y) {
		return addPlot(new org.math.plot.plots.ScatterPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertY(Y)));
	}

	public int addScatterPlot(java.lang.String name, java.awt.Color c, double[][] XY) {
		return addPlot(new org.math.plot.plots.ScatterPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(XY)));
	}

	public int addScatterPlot(java.lang.String name, java.awt.Color c, double[] X, double[] Y) {
		return addPlot(new org.math.plot.plots.ScatterPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(X, Y)));
	}

	public int addLinePlot(java.lang.String name, java.awt.Color c, double[] Y) {
		return addPlot(new org.math.plot.plots.LinePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertY(Y)));
	}

	public int addLinePlot(java.lang.String name, java.awt.Color c, double[][] XY) {
		return addPlot(new org.math.plot.plots.LinePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(XY)));
	}

	public int addLinePlot(java.lang.String name, java.awt.Color c, double[] X, double[] Y) {
		return addPlot(new org.math.plot.plots.LinePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(X, Y)));
	}

	public int addBarPlot(java.lang.String name, java.awt.Color c, double[] Y) {
		return addPlot(new org.math.plot.plots.BarPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertY(Y)));
	}

	public int addBarPlot(java.lang.String name, java.awt.Color c, double[][] XY) {
		return addPlot(new org.math.plot.plots.BarPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(XY)));
	}

	public int addBarPlot(java.lang.String name, java.awt.Color c, double[] X, double[] Y) {
		return addPlot(new org.math.plot.plots.BarPlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(X, Y)));
	}

	public int addStaircasePlot(java.lang.String name, java.awt.Color c, double[] Y) {
		return addPlot(new org.math.plot.plots.StaircasePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertY(Y)));
	}

	public int addStaircasePlot(java.lang.String name, java.awt.Color c, double[][] XY) {
		return addPlot(new org.math.plot.plots.StaircasePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(XY)));
	}

	public int addStaircasePlot(java.lang.String name, java.awt.Color c, double[] X, double[] Y) {
		return addPlot(new org.math.plot.plots.StaircasePlot(name, c, org.math.plot.canvas.Plot2DCanvas.convertXY(X, Y)));
	}

	public int addBoxPlot(java.lang.String name, java.awt.Color c, double[][] XY, double[][] dX) {
		return addPlot(new org.math.plot.plots.BoxPlot2D(XY, dX, c, name));
	}

	public int addBoxPlot(java.lang.String name, java.awt.Color c, double[][] XYdX) {
		return addPlot(new org.math.plot.plots.BoxPlot2D(org.math.plot.utils.Array.getColumnsRangeCopy(XYdX, 0, 1), org.math.plot.utils.Array.getColumnsRangeCopy(XYdX, 2, 3), c, name));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[][] XY, double[] dX) {
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, XY, dX));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[][] XY, double dX) {
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, XY, dX));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[][] XYdX) {
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, org.math.plot.utils.Array.getColumnsRangeCopy(XYdX, 0, 1), org.math.plot.utils.Array.getColumnCopy(XYdX, 2)));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[] X, int n) {
		double[][] XY = org.math.plot.utils.Histogram.histogram_classes(X, n);
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, XY, XY[1][0] - XY[0][0]));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[] X, double... bounds) {
		double[][] XY = org.math.plot.utils.Histogram.histogram_classes(X, bounds);
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, XY, XY[1][0] - XY[0][0]));
	}

	public int addHistogramPlot(java.lang.String name, java.awt.Color c, double[] X, double min, double max, int n) {
		double[][] XY = org.math.plot.utils.Histogram.histogram_classes(X, min, max, n);
		return addPlot(new org.math.plot.plots.HistogramPlot2D(name, c, XY, XY[1][0] - XY[0][0]));
	}

	public int addCloudPlot(java.lang.String name, java.awt.Color c, double[][] sampleXY, int nX, int nY) {
		double[][] XYh = org.math.plot.utils.Histogram.histogram_classes_2D(sampleXY, nX, nY);
		return addPlot(new org.math.plot.plots.CloudPlot2D(name, c, XYh, XYh[1][0] - XYh[0][0], XYh[nX][1] - XYh[0][1]));
	}

	public static void main(java.lang.String[] args) {
	}
}