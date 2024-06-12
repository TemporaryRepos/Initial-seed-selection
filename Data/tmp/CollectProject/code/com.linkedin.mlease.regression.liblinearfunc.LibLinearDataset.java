public class LibLinearDataset extends de.bwaldvogel.liblinear.Problem {
	public double[] offset = null;

	public double[] weight = null;

	java.util.HashMap<java.lang.String, java.lang.Integer> featureIndex = null;

	java.util.ArrayList<java.lang.String> featureName = null;

	public static final java.lang.String INTERCEPT_NAME = "(INTERCEPT)";

	protected java.util.ArrayList<java.lang.Integer> y_temp = new java.util.ArrayList<java.lang.Integer>();

	protected java.util.List<de.bwaldvogel.liblinear.FeatureNode[]> x_temp = new java.util.ArrayList<de.bwaldvogel.liblinear.FeatureNode[]>();

	protected java.util.ArrayList<java.lang.Double> offset_temp = new java.util.ArrayList<java.lang.Double>();

	protected java.util.ArrayList<java.lang.Double> weight_temp = new java.util.ArrayList<java.lang.Double>();

	protected boolean finished = false;

	protected int maxFeatureIndex = 0;

	protected com.linkedin.mlease.regression.liblinearfunc.FeatureNodeComparator featureNodeCmp = new com.linkedin.mlease.regression.liblinearfunc.FeatureNodeComparator();

	public int nInstances() {
		return l;
	}

	public int nFeatures() {
		return n;
	}

	public boolean isFinished() {
		return finished;
	}

	public java.lang.String getFeatureName(int index) {
		if (featureName != null) {
			return featureName.get(index - 1);
		}
		return index + "";
	}

	public int getFeatureIndex(java.lang.String name) {
		if (name == null) {
			throw new java.lang.RuntimeException("the input name is null");
		}
		if (featureIndex != null) {
			java.lang.Integer index = featureIndex.get(name);
			return index != null ? index : -1;
		}
		return com.linkedin.mlease.utils.Util.atoi(name);
	}

	public LibLinearDataset(double bias) {
		this.bias = bias;
		l = 0;
		n = 0;
	}

	public void addInstanceLibSVM(java.lang.String line) throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot add instances to a finished dataset.");
		}
		java.util.StringTokenizer st = new java.util.StringTokenizer(line, " \t\n\r\f:");
		java.lang.String token;
		try {
			token = st.nextToken();
		} catch (java.util.NoSuchElementException e) {
			throw new java.io.IOException("Empty line", e);
		}
		try {
			y_temp.add(com.linkedin.mlease.utils.Util.atoi(token));
		} catch (java.lang.NumberFormatException e) {
			throw new java.io.IOException("Invalid label: " + token, e);
		}
		int m = st.countTokens() / 2;
		de.bwaldvogel.liblinear.FeatureNode[] x;
		if (bias > 0) {
			x = new de.bwaldvogel.liblinear.FeatureNode[m + 1];
		} else {
			x = new de.bwaldvogel.liblinear.FeatureNode[m];
		}
		int indexBefore = 0;
		for (int j = 0; j < m; j++) {
			token = st.nextToken();
			int index;
			try {
				index = com.linkedin.mlease.utils.Util.atoi(token);
			} catch (java.lang.NumberFormatException e) {
				throw new java.io.IOException("Invalid index: " + token, e);
			}
			if (index < 0) {
				throw new java.io.IOException("Invalid index: " + index);
			}
			if (index <= indexBefore) {
				throw new java.io.IOException("Indices must be sorted in ascending order");
			}
			indexBefore = index;
			token = st.nextToken();
			try {
				double value = com.linkedin.mlease.utils.Util.atof(token);
				x[j] = new de.bwaldvogel.liblinear.FeatureNode(index, value);
			} catch (java.lang.NumberFormatException e) {
				throw new java.io.IOException("Invalid value: " + token);
			}
		}
		if (m > 0) {
			maxFeatureIndex = java.lang.Math.max(maxFeatureIndex, x[m - 1].index);
		}
		x_temp.add(x);
	}

	public void addInstanceJSON(java.util.Map<java.lang.String, ?> input) throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot add instances to a finished dataset.");
		}
		int response = com.linkedin.mlease.utils.Util.getInt(input, "response");
		if (((response != 1) && (response != 0)) && (response != (-1))) {
			throw new java.io.IOException(("response = " + response) + " (only 1, 0, -1 are allowed)");
		}
		if (response == 0) {
			response = -1;
		}
		y_temp.add(response);
		double w = 1;
		if (input.containsKey("weight")) {
			w = com.linkedin.mlease.utils.Util.getDouble(input, "weight");
		}
		if (w != 1) {
			if (w < 0) {
				throw new java.io.IOException(("weight = " + w) + " (weight cannot < 0)");
			}
			while (weight_temp.size() < (y_temp.size() - 1)) {
				weight_temp.add(1.0);
			} 
			weight_temp.add(w);
		}
		double o = 0;
		if (input.containsKey("offset")) {
			o = com.linkedin.mlease.utils.Util.getDouble(input, "offset");
		}
		if (o != 0) {
			while (offset_temp.size() < (y_temp.size() - 1)) {
				offset_temp.add(0.0);
			} 
			offset_temp.add(o);
		}
		java.lang.Object temp = input.get("features");
		if (temp == null) {
			throw new java.io.IOException("features is null");
		}
		if (!(temp instanceof java.util.List)) {
			throw new java.io.IOException("features is not a list");
		}
		java.util.List<?> features = ((java.util.List<?>) (temp));
		int m = features.size();
		de.bwaldvogel.liblinear.FeatureNode[] x;
		if (bias > 0) {
			x = new de.bwaldvogel.liblinear.FeatureNode[m + 1];
		} else {
			x = new de.bwaldvogel.liblinear.FeatureNode[m];
		}
		for (int i = 0; i < m; i++) {
			temp = features.get(i);
			if (!(temp instanceof java.util.Map)) {
				throw new java.io.IOException(("features[" + i) + "] is not a map");
			}
			java.util.Map<java.lang.String, ?> feature = ((java.util.Map<java.lang.String, ?>) (temp));
			java.lang.String name = com.linkedin.mlease.utils.Util.getString(feature, "name", false);
			java.lang.String term = com.linkedin.mlease.utils.Util.getString(feature, "term", true);
			if (!"".equals(term)) {
				name = (name + "\u0001") + term;
			}
			double value = com.linkedin.mlease.utils.Util.getDouble(feature, "value");
			if (featureIndex == null) {
				featureIndex = new java.util.HashMap<java.lang.String, java.lang.Integer>();
			}
			if (featureName == null) {
				featureName = new java.util.ArrayList<java.lang.String>();
			}
			if (featureIndex.size() != featureName.size()) {
				throw new java.io.IOException("featureIndex.size() != featureName.size()");
			}
			java.lang.Integer index = featureIndex.get(name);
			if (index == null) {
				if (com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME.equals(name)) {
					throw new java.io.IOException("feature name cannot be " + com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME);
				}
				maxFeatureIndex++;
				featureIndex.put(name, maxFeatureIndex);
				featureName.add(name);
				if (featureName.size() != maxFeatureIndex) {
					throw new java.io.IOException("featureName.size() != maxFeatureIndex");
				}
				index = maxFeatureIndex;
			}
			x[i] = new de.bwaldvogel.liblinear.FeatureNode(index, value);
		}
		if (m > 1) {
			java.util.Arrays.sort(x, 0, m, featureNodeCmp);
		}
		x_temp.add(x);
	}

	public void addInstanceAvro(org.apache.avro.generic.GenericData.Record input) throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot add instances to a finished dataset.");
		}
		int response = com.linkedin.mlease.utils.Util.getIntAvro(input, "response");
		if (((response != 1) && (response != 0)) && (response != (-1))) {
			throw new java.io.IOException(("response = " + response) + " (only 1, 0, -1 are allowed)");
		}
		if (response == 0) {
			response = -1;
		}
		y_temp.add(response);
		double w = 1;
		if (input.get("weight") != null) {
			w = com.linkedin.mlease.utils.Util.getDoubleAvro(input, "weight");
		}
		if (w != 1) {
			if (w < 0) {
				throw new java.io.IOException(("weight = " + w) + " (weight cannot < 0)");
			}
			while (weight_temp.size() < (y_temp.size() - 1)) {
				weight_temp.add(1.0);
			} 
			weight_temp.add(w);
		}
		double o = 0;
		if (input.get("offset") != null) {
			o = com.linkedin.mlease.utils.Util.getDoubleAvro(input, "offset");
		}
		if (o != 0) {
			while (offset_temp.size() < (y_temp.size() - 1)) {
				offset_temp.add(0.0);
			} 
			offset_temp.add(o);
		}
		java.lang.Object temp = input.get("features");
		if (temp == null) {
			throw new java.io.IOException("features is null");
		}
		if (!(temp instanceof java.util.List)) {
			throw new java.io.IOException("features is not a list");
		}
		java.util.List<?> features = ((java.util.List<?>) (temp));
		int m = features.size();
		de.bwaldvogel.liblinear.FeatureNode[] x;
		if (bias > 0) {
			x = new de.bwaldvogel.liblinear.FeatureNode[m + 1];
		} else {
			x = new de.bwaldvogel.liblinear.FeatureNode[m];
		}
		for (int i = 0; i < m; i++) {
			temp = features.get(i);
			if (!(temp instanceof org.apache.avro.generic.GenericData.Record)) {
				throw new java.io.IOException(("features[" + i) + "] is not a Avro record");
			}
			org.apache.avro.generic.GenericData.Record feature = ((org.apache.avro.generic.GenericData.Record) (temp));
			java.lang.String name = com.linkedin.mlease.utils.Util.getStringAvro(feature, "name", false);
			java.lang.String term = com.linkedin.mlease.utils.Util.getStringAvro(feature, "term", true);
			if (!"".equals(term)) {
				name = (name + "\u0001") + term;
			}
			double value = com.linkedin.mlease.utils.Util.getDoubleAvro(feature, "value");
			if (featureIndex == null) {
				featureIndex = new java.util.HashMap<java.lang.String, java.lang.Integer>();
			}
			if (featureName == null) {
				featureName = new java.util.ArrayList<java.lang.String>();
			}
			if (featureIndex.size() != featureName.size()) {
				throw new java.io.IOException("featureIndex.size() != featureName.size()");
			}
			java.lang.Integer index = featureIndex.get(name);
			if (index == null) {
				if (com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME.equals(name)) {
					throw new java.io.IOException("feature name cannot be " + com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME);
				}
				maxFeatureIndex++;
				featureIndex.put(name, maxFeatureIndex);
				featureName.add(name);
				if (featureName.size() != maxFeatureIndex) {
					throw new java.io.IOException("featureName.size() != maxFeatureIndex");
				}
				index = maxFeatureIndex;
			}
			x[i] = new de.bwaldvogel.liblinear.FeatureNode(index, value);
		}
		if (m > 1) {
			java.util.Arrays.sort(x, 0, m, featureNodeCmp);
		}
		x_temp.add(x);
	}

	public void addInstanceAvro(com.linkedin.mlease.regression.avro.RegressionPrepareOutput input) throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot add instances to a finished dataset.");
		}
		int response = input.response;
		if (((response != 1) && (response != 0)) && (response != (-1))) {
			throw new java.io.IOException(("response = " + response) + " (only 1, 0, -1 are allowed)");
		}
		if (response == 0) {
			response = -1;
		}
		y_temp.add(response);
		double w = input.weight;
		if (w != 1) {
			if (w < 0) {
				throw new java.io.IOException(("weight = " + w) + " (weight cannot < 0)");
			}
			while (weight_temp.size() < (y_temp.size() - 1)) {
				weight_temp.add(1.0);
			} 
			weight_temp.add(w);
		}
		double o = input.offset;
		if (o != 0) {
			while (offset_temp.size() < (y_temp.size() - 1)) {
				offset_temp.add(0.0);
			} 
			offset_temp.add(o);
		}
		java.util.List<com.linkedin.mlease.regression.avro.feature> features = input.features;
		int m = features.size();
		de.bwaldvogel.liblinear.FeatureNode[] x;
		if (bias > 0) {
			x = new de.bwaldvogel.liblinear.FeatureNode[m + 1];
		} else {
			x = new de.bwaldvogel.liblinear.FeatureNode[m];
		}
		for (int i = 0; i < m; i++) {
			java.lang.String name = features.get(i).name.toString();
			java.lang.String term = features.get(i).term.toString();
			if (!"".equals(term)) {
				name = (name + "\u0001") + term;
			}
			double value = features.get(i).value;
			if (featureIndex == null) {
				featureIndex = new java.util.HashMap<java.lang.String, java.lang.Integer>();
			}
			if (featureName == null) {
				featureName = new java.util.ArrayList<java.lang.String>();
			}
			if (featureIndex.size() != featureName.size()) {
				throw new java.io.IOException("featureIndex.size() != featureName.size()");
			}
			java.lang.Integer index = featureIndex.get(name);
			if (index == null) {
				if (com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME.equals(name)) {
					throw new java.io.IOException("feature name cannot be " + com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME);
				}
				maxFeatureIndex++;
				featureIndex.put(name, maxFeatureIndex);
				featureName.add(name);
				if (featureName.size() != maxFeatureIndex) {
					throw new java.io.IOException("featureName.size() != maxFeatureIndex");
				}
				index = maxFeatureIndex;
			}
			x[i] = new de.bwaldvogel.liblinear.FeatureNode(index, value);
		}
		if (m > 1) {
			java.util.Arrays.sort(x, 0, m, featureNodeCmp);
		}
		x_temp.add(x);
	}

	public void reset() throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot reset a finished dataset.");
		}
		y_temp.clear();
		x_temp.clear();
		offset_temp.clear();
		weight_temp.clear();
		maxFeatureIndex = 0;
	}

	public void readFromLibSVM(java.io.File file) throws java.io.IOException, de.bwaldvogel.liblinear.InvalidInputDataException {
		java.io.BufferedReader fp = new java.io.BufferedReader(new java.io.FileReader(file));
		int lineNr = 0;
		try {
			while (true) {
				java.lang.String line = fp.readLine();
				if (line == null) {
					break;
				}
				lineNr++;
				try {
					addInstanceLibSVM(line);
				} catch (java.lang.Exception e) {
					throw new de.bwaldvogel.liblinear.InvalidInputDataException("Error found when processing " + line, file, lineNr, e);
				}
			} 
			finish();
		} finally {
			fp.close();
		}
	}

	public void finish() throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot finish a finished dataset.");
		}
		l = y_temp.size();
		n = maxFeatureIndex;
		if (bias > 0) {
			n++;
			if ((n == 1) && ((featureIndex == null) || (featureName == null))) {
				featureIndex = new java.util.HashMap<java.lang.String, java.lang.Integer>();
				featureName = new java.util.ArrayList<java.lang.String>();
			}
			if (featureIndex != null) {
				featureIndex.put(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME, n);
			}
			if (featureName != null) {
				featureName.add(com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME);
			}
		}
		x = new de.bwaldvogel.liblinear.FeatureNode[l][];
		for (int i = 0; i < l; i++) {
			x[i] = x_temp.get(i);
			if (bias > 0) {
				assert x[i][x[i].length - 1] == null;
				x[i][x[i].length - 1] = new de.bwaldvogel.liblinear.FeatureNode(maxFeatureIndex + 1, bias);
			}
		}
		y = new int[l];
		for (int i = 0; i < l; i++) {
			y[i] = y_temp.get(i);
		}
		offset = new double[l];
		if (offset_temp.size() > 0) {
			int i;
			for (i = 0; i < offset_temp.size(); i++) {
				offset[i] = offset_temp.get(i);
			}
			for (; i < l; i++) {
				offset[i] = 0;
			}
		} else {
			for (int i = 0; i < offset.length; i++) {
				offset[i] = 0;
			}
		}
		weight = new double[l];
		if (weight_temp.size() > 0) {
			int i;
			for (i = 0; i < weight_temp.size(); i++) {
				weight[i] = weight_temp.get(i);
			}
			for (; i < l; i++) {
				weight[i] = 1;
			}
		} else {
			for (int i = 0; i < weight.length; i++) {
				weight[i] = 1;
			}
		}
		sanity_check(1);
		y_temp.clear();
		x_temp.clear();
		offset_temp.clear();
		weight_temp.clear();
		finished = true;
	}

	public java.lang.String toString() {
		if (l == 0) {
			return "";
		}
		java.lang.StringBuilder out = new java.lang.StringBuilder();
		try {
			sanity_check(1);
		} catch (java.io.IOException e) {
			return ("ERROR: " + e.getMessage()) + "\n";
		}
		for (int i = 0; i < l; i++) {
			out.append(y[i]);
			out.append("\t");
			for (int j = 0; j < x[i].length; j++) {
				if (j > 0) {
					out.append(" ");
				}
				java.lang.String name;
				if (featureName == null) {
					name = x[i][j].getIndex() + "";
				} else {
					name = featureName.get(x[i][j].getIndex() - 1);
				}
				out.append((name + "=") + x[i][j].getValue());
			}
			if (weight != null) {
				out.append("\t" + weight[i]);
			} else if (offset != null) {
				out.append("\t1");
			}
			if (offset != null) {
				out.append("\t" + offset[i]);
			}
			out.append("\n");
		}
		return out.toString();
	}

	public void sanity_check(int level) throws java.io.IOException {
		if (l != y.length) {
			throw new java.io.IOException((("l = " + l) + ", but y.length =") + y.length);
		}
		if (l != x.length) {
			throw new java.io.IOException((("l = " + l) + ", but x.length =") + x.length);
		}
		if ((offset != null) && (l != offset.length)) {
			throw new java.io.IOException((("l = " + l) + ", but offset.length =") + offset.length);
		}
		if ((weight != null) && (l != weight.length)) {
			throw new java.io.IOException((("l = " + l) + ", but weight.length =") + weight.length);
		}
		if ((featureIndex != null) && (featureName == null)) {
			throw new java.io.IOException("featureIndex != null && featureName == null");
		}
		if ((featureIndex == null) && (featureName != null)) {
			throw new java.io.IOException("featureIndex == null && featureName != null");
		}
		if (featureIndex != null) {
			if ((bias > 0) && (!com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME.equals(featureName.get(featureName.size() - 1)))) {
				throw new java.io.IOException("The last feature is not " + com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset.INTERCEPT_NAME);
			}
			if (featureIndex.size() != featureName.size()) {
				throw new java.io.IOException((("featureIndex.size()=" + featureIndex.size()) + ", but featureName.size()=") + featureName.size());
			}
			if (featureIndex.size() != n) {
				throw new java.io.IOException((("featureIndex.size()=" + featureIndex.size()) + ", but n=") + n);
			}
		}
		if (level >= 1) {
			if (featureIndex != null) {
				java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Integer>> entrySet = featureIndex.entrySet();
				java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Integer>> iter = entrySet.iterator();
				while (iter.hasNext()) {
					java.util.Map.Entry<java.lang.String, java.lang.Integer> entry = iter.next();
					if (featureName.get(entry.getValue() - 1) != entry.getKey()) {
						throw new java.io.IOException((((("featureName[" + (entry.getValue() - 1)) + "] = ") + featureName.get(entry.getValue() - 1)) + ", instead of ") + entry.getKey());
					}
				} 
			}
		}
		if (level >= 2) {
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < x[i].length; j++) {
					int index = x[i][j].getIndex();
					if ((index < 1) || (index > n)) {
						throw new java.io.IOException((((("feature index out of bound x[" + i) + "][") + j) + "].index=") + index);
					}
				}
			}
			for (int i = 0; i < y.length; i++) {
				if (((y[i] != 1) && (y[i] != (-1))) && (y[i] != 0)) {
					throw new java.io.IOException((("y[" + i) + "] = ") + y[i]);
				}
			}
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length != 2) {
			java.lang.System.out.println("Please give two input parameters: <type> <filename>, where type = libsvm or json");
			java.lang.System.exit(0);
		}
		java.lang.String type = args[0];
		java.io.File file = new java.io.File(args[1]);
		if (!file.exists()) {
			java.lang.System.out.println(("File " + file.toString()) + " does not exist");
			java.lang.System.exit(0);
		}
		com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset d = new com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset(0);
		if ("libsvm".equals(type)) {
			d.readFromLibSVM(file);
		} else {
			java.lang.System.out.println("Unknown file type: " + type);
			java.lang.System.exit(0);
		}
		d.sanity_check(10);
		java.lang.System.out.println(d.toString());
	}
}