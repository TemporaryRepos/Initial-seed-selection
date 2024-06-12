public class LibLinear {
	java.util.Map<java.lang.String, java.lang.Double> coeff = null;

	double[] param = null;

	java.util.Map<java.lang.String, java.lang.Double> postVarMap = null;

	double[] postVar = null;

	double[] priorMean = null;

	double[] priorVar = null;

	public double bias = 0;

	double epsilon = 0.01;

	java.lang.String type = com.linkedin.mlease.regression.liblinearfunc.LibLinear.Logistic_L2_primal;

	int max_iter = 10000;

	int verbose = 0;

	double positive_weight = 1;

	public static java.lang.String Logistic_L2_primal = "Logistic_L2_primal";

	public static java.lang.String Do_nothing = "Do_nothing";

	org.apache.hadoop.mapred.Reporter reporter = null;

	long reportFrequency = 10000000;

	boolean computeFullPostVar = false;

	double[][] postVarMatrix = null;

	java.util.Map<java.util.List<java.lang.String>, java.lang.Double> postVarMatrixMap = null;

	void parseOption(java.lang.String option) throws java.lang.Exception {
		if (option == null) {
			return;
		}
		if ("".equals(option)) {
			return;
		}
		java.lang.String[] token = option.split("\\s*,\\s*");
		for (int i = 0; i < token.length; i++) {
			java.lang.String[] pair = token[i].split("\\s*=\\s*");
			if (pair.length != 2) {
				throw new java.lang.Exception(((("Unknown option specification: '" + token[i]) + "' in '") + option) + "'");
			}
			try {
				if (pair[0].equals("epsilon")) {
					epsilon = com.linkedin.mlease.utils.Util.atof(pair[1]);
				} else if (pair[0].equals("type")) {
					type = pair[1];
				} else if (pair[0].equals("max_iter")) {
					max_iter = com.linkedin.mlease.utils.Util.atoi(pair[1]);
				} else if (pair[0].equals("verbose")) {
					verbose = com.linkedin.mlease.utils.Util.atoi(pair[1]);
				} else if (pair[0].equals("positive_weight")) {
					positive_weight = com.linkedin.mlease.utils.Util.atof(pair[1]);
				} else {
					throw new java.lang.Exception();
				}
			} catch (java.lang.Exception e) {
				throw new java.lang.Exception(((("Invalid option specification: '" + token[i]) + "' in '") + option) + "'");
			}
		}
	}

	public void setComputeFullPostVar(boolean compute) {
		computeFullPostVar = compute;
	}

	public void setReporter(org.apache.hadoop.mapred.Reporter rep, long n) {
		reporter = rep;
		if (n < 1000) {
			n = 1000;
		}
		reportFrequency = n;
	}

	public void train(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset, java.util.Map<java.lang.String, java.lang.Double> initParam, java.util.Map<java.lang.String, java.lang.Double> priorMean, java.util.Map<java.lang.String, java.lang.Double> priorVar, double defaultPriorVar, java.lang.String option) throws java.lang.Exception {
		train(dataset, initParam, priorMean, priorVar, 0.0, defaultPriorVar, option);
	}

	public void train(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset, java.util.Map<java.lang.String, java.lang.Double> initParam, java.util.Map<java.lang.String, java.lang.Double> priorMean, java.util.Map<java.lang.String, java.lang.Double> priorVar, double defaultPriorMean, double defaultPriorVar, java.lang.String option) throws java.lang.Exception {
		train(dataset, initParam, priorMean, priorVar, defaultPriorMean, defaultPriorVar, option, false);
	}

	public void train(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset, java.util.Map<java.lang.String, java.lang.Double> initParam, java.util.Map<java.lang.String, java.lang.Double> priorMean, java.util.Map<java.lang.String, java.lang.Double> priorVar, double defaultPriorMean, double defaultPriorVar, java.lang.String option, boolean computePosteriorVar) throws java.lang.Exception {
		if (!dataset.isFinished()) {
			throw new java.io.IOException("Cannot train a model using unfinished dataset");
		}
		bias = dataset.bias;
		parseOption(option);
		param = new double[dataset.nFeatures()];
		initSetup(param, initParam, dataset, 0.0);
		this.priorMean = new double[dataset.nFeatures()];
		initSetup(this.priorMean, priorMean, dataset, defaultPriorMean);
		this.priorVar = new double[dataset.nFeatures()];
		initSetup(this.priorVar, priorVar, dataset, defaultPriorVar);
		postVar = null;
		postVarMap = null;
		postVarMatrix = null;
		postVarMatrixMap = null;
		if (computePosteriorVar) {
			postVar = new double[this.priorVar.length];
			for (int i = 0; i < postVar.length; i++) {
				postVar[i] = this.priorVar[i];
			}
			if (computeFullPostVar) {
				postVarMatrix = new double[postVar.length][];
				for (int i = 0; i < postVarMatrix.length; i++) {
					postVarMatrix[i] = new double[postVarMatrix.length];
					for (int j = 0; j < postVarMatrix.length; j++) {
						if (i == j) {
							postVarMatrix[i][j] = this.priorVar[i];
						} else {
							postVarMatrix[i][j] = 0;
						}
					}
				}
			}
		}
		int pos = 0;
		for (int i = 0; i < dataset.nInstances(); i++) {
			if (dataset.y[i] == 1) {
				pos++;
			}
		}
		int neg = dataset.nInstances() - pos;
		if (type.equals(com.linkedin.mlease.regression.liblinearfunc.LibLinear.Logistic_L2_primal)) {
			double multiplier = 1;
			com.linkedin.mlease.regression.liblinearfunc.LibLinearFunction func;
			if (dataset instanceof com.linkedin.mlease.regression.liblinearfunc.LibLinearBinaryDataset) {
				func = new com.linkedin.mlease.regression.liblinearfunc.LogisticRegressionL2BinaryFeature(((com.linkedin.mlease.regression.liblinearfunc.LibLinearBinaryDataset) (dataset)), this.priorMean, this.priorVar, multiplier, positive_weight, 1);
			} else {
				func = new com.linkedin.mlease.regression.liblinearfunc.LogisticRegressionL2(dataset, this.priorMean, this.priorVar, multiplier, positive_weight, 1);
			}
			if (reporter != null) {
				reporter.setStatus("Start LibLinear of type " + type);
				func.setReporter(reporter, reportFrequency);
			}
			de.bwaldvogel.liblinear.Tron tron = new de.bwaldvogel.liblinear.Tron(func, (epsilon * java.lang.Math.min(pos, neg)) / dataset.nInstances(), max_iter);
			tron.tron(param);
			if (computePosteriorVar) {
				if (computeFullPostVar) {
					func.hessian(param, postVarMatrix);
					org.apache.commons.math3.linear.RealMatrix H = org.apache.commons.math3.linear.MatrixUtils.createRealMatrix(postVarMatrix);
					org.apache.commons.math3.linear.CholeskyDecomposition decomp = new org.apache.commons.math3.linear.CholeskyDecomposition(H);
					org.apache.commons.math3.linear.DecompositionSolver solver = decomp.getSolver();
					org.apache.commons.math3.linear.RealMatrix Var = solver.getInverse();
					postVarMatrix = Var.getData();
					for (int i = 0; i < postVar.length; i++) {
						postVar[i] = postVarMatrix[i][i];
					}
				} else {
					func.hessianDiagonal(param, postVar);
					for (int i = 0; i < postVar.length; i++) {
						postVar[i] = 1.0 / postVar[i];
					}
				}
			}
		} else if (type.equals(com.linkedin.mlease.regression.liblinearfunc.LibLinear.Do_nothing)) {
		} else {
			throw new java.lang.Exception("Unknown type: " + type);
		}
		coeff = new java.util.HashMap<java.lang.String, java.lang.Double>();
		if (computePosteriorVar) {
			postVarMap = new java.util.HashMap<java.lang.String, java.lang.Double>();
		}
		for (int index = 1; index <= dataset.nFeatures(); index++) {
			java.lang.String featureName = dataset.getFeatureName(index);
			coeff.put(featureName, param[index - 1]);
			if (computePosteriorVar) {
				postVarMap.put(featureName, postVar[index - 1]);
			}
		}
		if (computePosteriorVar && computeFullPostVar) {
			postVarMatrixMap = new java.util.HashMap<java.util.List<java.lang.String>, java.lang.Double>();
			for (int i = 1; i <= dataset.nFeatures(); i++) {
				java.lang.String name_i = dataset.getFeatureName(i);
				for (int j = 1; j <= dataset.nFeatures(); j++) {
					double cov = postVarMatrix[i - 1][j - 1];
					if (cov != 0) {
						java.lang.String name_j = dataset.getFeatureName(j);
						java.util.ArrayList<java.lang.String> pair = new java.util.ArrayList<java.lang.String>(2);
						pair.add(name_i);
						pair.add(name_j);
						postVarMatrixMap.put(pair, cov);
					}
				}
			}
		}
		if (priorMean != null) {
			for (java.lang.String key : priorMean.keySet()) {
				if (!coeff.containsKey(key)) {
					coeff.put(key, priorMean.get(key));
				}
			}
		}
		if ((priorVar != null) && computePosteriorVar) {
			for (java.lang.String key : priorVar.keySet()) {
				if (!postVarMap.containsKey(key)) {
					postVarMap.put(key, priorVar.get(key));
				}
				if (computeFullPostVar) {
					java.util.ArrayList<java.lang.String> pair = new java.util.ArrayList<java.lang.String>(2);
					pair.add(key);
					pair.add(key);
					if (!postVarMatrixMap.containsKey(pair)) {
						postVarMatrixMap.put(pair, priorVar.get(key));
					}
				}
			}
		}
	}

	public void train(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset, double priorVar, java.lang.String option) throws java.lang.Exception {
		train(dataset, null, null, null, priorVar, option);
	}

	public java.util.Map<java.lang.String, java.lang.Double> getParamMap() {
		return coeff;
	}

	public java.util.Map<java.lang.String, java.lang.Double> getPostVarMap() {
		return postVarMap;
	}

	public java.util.Map<java.util.List<java.lang.String>, java.lang.Double> getPostVarMatrixMap() {
		return postVarMatrixMap;
	}

	public com.linkedin.mlease.models.LinearModel getLinearModel() throws java.lang.Exception {
		if (coeff == null) {
			throw new java.lang.Exception("This model has not been built.  Please call train() before calling getLinearModel().");
		}
		com.linkedin.mlease.models.LinearModel model = null;
		if (bias > 0) {
			model = new com.linkedin.mlease.models.LinearModel(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME, coeff);
		} else {
			model = new com.linkedin.mlease.models.LinearModel(0.0, coeff);
		}
		return model;
	}

	void initSetup(double[] param, java.util.Map<java.lang.String, java.lang.Double> map, com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset, double defaultValue) {
		for (int i = 0; i < param.length; i++) {
			param[i] = defaultValue;
		}
		if (map != null) {
			java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Double>> iter = map.entrySet().iterator();
			while (iter.hasNext()) {
				java.util.Map.Entry<java.lang.String, java.lang.Double> entry = iter.next();
				if (entry.getKey() == null) {
					throw new java.lang.RuntimeException("input key is null");
				}
				int index = dataset.getFeatureIndex(entry.getKey());
				if (index == (-1)) {
					continue;
				}
				param[index - 1] = entry.getValue();
			} 
		}
	}

	static final java.lang.String RUN_TRAIN = "train";

	static final java.lang.String RUN_PREDICT = "predict";

	static void cmd_line_error(java.lang.String msg, java.lang.String cmd) {
		java.lang.System.err.println("\nERROR: " + msg);
		java.lang.System.err.println("\n" + cmd);
		java.lang.System.exit(0);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String cmd = "Input parameters (separated by space): \n" + ((((((((((((((((((((((((("   run:<command>      (required) train or predict\n" + "   ftype:<file_type>  (required) libsvm or json\n") + "   data:<file_name>   (required) Input data file of the specified type\n") + "   out:<file_name>    (required) Output file\n") + "   bias:<bias>        (optional) Set to 0 if you do not want to add an\n") + "                                 bias/intercept term\n") + "                                 Set to 1 if you want to add a feature with\n") + "                                 value 1 to every instance\n") + "                                 Default: 0\n") + "   param:<file_name>  (optional) for run:train, it specifies the prior mean\n") + "                      (required) for run:predict, it specifies the model\n") + "                                 File format: <featureName>=<value> per line\n") + "   priorVar:<var>     (required) for run:train, <var> is the a number\n") + "                      (not used) for run:predict\n") + "   init:<file_name>   (optional) for run:train, it specifies the initial value\n") + "                                 File format: <featureName>=<value> per line\n") + "   posteriorVar:1/0   (optional) Whether to compute posterior variances\n") + "                                 Default: 1\n") + "   posteriorCov:1/0   (optional) Whether to compute posterior covariances\n") + "                                 Default: 0\n") + "   binaryFeature:1/0  (optional) Whether all of the input features are binary\n") + "   useShort:1/0       (optional) Whether to use short to store feature indices\n") + "   option:<options>   (optional) Comma-separated list of options\n") + "                                 No space is allowed in <options>\n") + "                                 Eg: max_iter=5,epsilon=0.01,positive_weight=2\n") + "                      (not used) for run:predict\n");
		if (args.length < 3) {
			java.lang.System.out.println("\n" + cmd);
			java.lang.System.exit(0);
		}
		java.lang.String run = null;
		java.lang.String ftype = null;
		java.io.File dataFile = null;
		java.io.File outFile = null;
		double bias = 0;
		java.io.File paramFile = null;
		java.io.File initFile = null;
		double priorVar = java.lang.Double.NaN;
		java.lang.String option = null;
		boolean binaryFeature = false;
		boolean useShort = false;
		boolean computePostVar = true;
		boolean computePostCov = false;
		for (int i = 0; i < args.length; i++) {
			if (args[i] == null) {
				continue;
			}
			java.lang.String[] token = args[i].split(":");
			if (token.length < 2) {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("'" + args[i]) + "' is not a valid input parameter string!", cmd);
			}
			for (int k = 2; k < token.length; k++) {
				token[1] += ":" + token[k];
			}
			if (token[0].equals("run")) {
				run = token[1];
			} else if (token[0].equals("ftype")) {
				ftype = token[1];
			} else if (token[0].equals("data")) {
				dataFile = new java.io.File(token[1]);
			} else if (token[0].equals("out")) {
				outFile = new java.io.File(token[1]);
			} else if (token[0].equals("bias")) {
				bias = java.lang.Double.parseDouble(token[1]);
			} else if (token[0].equals("param")) {
				paramFile = new java.io.File(token[1]);
			} else if (token[0].equals("init")) {
				initFile = new java.io.File(token[1]);
			} else if (token[0].equals("priorVar")) {
				priorVar = java.lang.Double.parseDouble(token[1]);
			} else if (token[0].equals("option")) {
				option = token[1];
			} else if (token[0].equals("binaryFeature")) {
				binaryFeature = com.linkedin.mlease.utils.Util.atob(token[1]);
			} else if (token[0].equals("useShort")) {
				useShort = com.linkedin.mlease.utils.Util.atob(token[1]);
			} else if (token[0].equals("posteriorVar")) {
				computePostVar = com.linkedin.mlease.utils.Util.atob(token[1]);
			} else if (token[0].equals("posteriorCov")) {
				computePostCov = com.linkedin.mlease.utils.Util.atob(token[1]);
			} else {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("'" + args[i]) + "' is not a valid input parameter string!", cmd);
			}
		}
		if (run == null) {
			com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Please specify run:<command>", cmd);
		}
		if (ftype == null) {
			com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Please specify ftype:<file_type>", cmd);
		}
		if (dataFile == null) {
			com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Please specify data:<file_name>", cmd);
		}
		if (outFile == null) {
			com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Please specify out:<file_name>", cmd);
		}
		if (run.equals(com.linkedin.mlease.regression.liblinearfunc.LibLinear.RUN_TRAIN)) {
			java.util.Map<java.lang.String, java.lang.Double> priorMean = null;
			java.util.Map<java.lang.String, java.lang.Double> initParam = null;
			if (paramFile != null) {
				if (!paramFile.exists()) {
					com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("Param File '" + paramFile.getPath()) + "' does not exist", cmd);
				}
				priorMean = com.linkedin.mlease.utils.Util.readStringDoubleMap(paramFile, "=");
			}
			if (initFile != null) {
				if (!initFile.exists()) {
					com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("Init File '" + initFile.getPath()) + "' does not exist", cmd);
				}
				initParam = com.linkedin.mlease.utils.Util.readStringDoubleMap(initFile, "=");
			}
			if (priorVar == java.lang.Double.NaN) {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Please specify priorVar:<var>", cmd);
			}
			if (!dataFile.exists()) {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("Data File '" + dataFile.getPath()) + "' does not exist", cmd);
			}
			com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset dataset;
			if (binaryFeature) {
				dataset = new com.linkedin.mlease.regression.liblinearfunc.LibLinearBinaryDataset(bias, useShort);
			} else {
				dataset = new com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset(bias);
			}
			if ("libsvm".equals(ftype)) {
				dataset.readFromLibSVM(dataFile);
			} else {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error(("Unknown file type 'ftype:" + ftype) + "'", cmd);
			}
			if ((computePostCov == true) && (computePostVar == false)) {
				com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Cannot compute posterior covariances with posteriorVar:0", cmd);
			}
			com.linkedin.mlease.regression.liblinearfunc.LibLinear liblinear = new com.linkedin.mlease.regression.liblinearfunc.LibLinear();
			liblinear.setComputeFullPostVar(computePostCov);
			liblinear.train(dataset, initParam, priorMean, null, 0.0, priorVar, option, computePostVar);
			java.io.PrintStream out = new java.io.PrintStream(outFile);
			com.linkedin.mlease.utils.Util.printStringDoubleMap(out, liblinear.getParamMap(), "=", true);
			out.close();
			if (computePostVar) {
				out = new java.io.PrintStream(outFile + ".var");
				com.linkedin.mlease.utils.Util.printStringDoubleMap(out, liblinear.getPostVarMap(), "=", true);
				out.close();
				if (computePostCov) {
					out = new java.io.PrintStream(outFile + ".cov");
					com.linkedin.mlease.utils.Util.printStringListDoubleMap(out, liblinear.getPostVarMatrixMap(), "=");
					out.close();
				}
			}
		} else if (run.equals(com.linkedin.mlease.regression.liblinearfunc.LibLinear.RUN_PREDICT)) {
			throw new java.lang.Exception("run:predict is not supported yet :(");
		} else {
			com.linkedin.mlease.regression.liblinearfunc.LibLinear.cmd_line_error("Unknown run:" + run, cmd);
		}
	}
}