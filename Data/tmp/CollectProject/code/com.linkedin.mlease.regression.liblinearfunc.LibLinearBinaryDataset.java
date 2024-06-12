public class LibLinearBinaryDataset extends com.linkedin.mlease.regression.liblinearfunc.LibLinearDataset {
	public java.util.ArrayList<int[]> x_int = null;

	public java.util.ArrayList<short[]> x_short = null;

	public boolean useShort;

	public int getNumNonzeroFeatures(int i) {
		return useShort ? x_short.get(i).length : x_int.get(i).length;
	}

	public int getFeatureIndex(int i, int j) {
		return useShort ? x_short.get(i)[j] : x_int.get(i)[j];
	}

	public LibLinearBinaryDataset(double bias, boolean useShort) throws java.io.IOException {
		super(bias);
		if ((bias != 1) && (bias != 0)) {
			throw new java.io.IOException("Bias can only be either 0 or 1: input value = " + bias);
		}
		this.useShort = useShort;
		if (useShort) {
			x_short = new java.util.ArrayList<short[]>();
		} else {
			x_int = new java.util.ArrayList<int[]>();
		}
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
		int[] x_current;
		if (bias > 0) {
			x_current = new int[m + 1];
			x_current[m] = -1;
		} else {
			x_current = new int[m];
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
				if (value != 1) {
					throw new java.io.IOException("Cannot handle non-binary features (all feature values have to be 1): " + line);
				}
				x_current[j] = index;
			} catch (java.lang.NumberFormatException e) {
				throw new java.io.IOException("Invalid value: " + token);
			}
		}
		if (m > 0) {
			maxFeatureIndex = java.lang.Math.max(maxFeatureIndex, x_current[m - 1]);
		}
		if (useShort) {
			if (maxFeatureIndex >= java.lang.Short.MAX_VALUE) {
				throw new java.io.IOException(("When using short to store feature indices, you cannot have more than " + (java.lang.Short.MAX_VALUE - 1)) + " features!!");
			}
			short[] temp = new short[x_current.length];
			for (int k = 0; k < temp.length; k++) {
				temp[k] = ((short) (x_current[k]));
			}
			x_short.add(temp);
		} else {
			x_int.add(x_current);
		}
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
		int[] x_current;
		if (bias > 0) {
			x_current = new int[m + 1];
			x_current[m] = -1;
		} else {
			x_current = new int[m];
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
			if (feature.containsKey("value")) {
				double value = com.linkedin.mlease.utils.Util.getDouble(feature, "value");
				if (value != 1) {
					throw new java.io.IOException("Cannot handle non-binary feature value (all feature values have to be 1; or just do not specify the value): " + feature.toString());
				}
			}
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
			x_current[i] = index;
		}
		if (m > 1) {
			java.util.Arrays.sort(x_current, 0, m);
		}
		if (useShort) {
			if (maxFeatureIndex >= java.lang.Short.MAX_VALUE) {
				throw new java.io.IOException(("When using short to store feature indices, you cannot have more than " + (java.lang.Short.MAX_VALUE - 1)) + " features!!");
			}
			short[] temp2 = new short[x_current.length];
			for (int k = 0; k < temp2.length; k++) {
				temp2[k] = ((short) (x_current[k]));
			}
			x_short.add(temp2);
		} else {
			x_int.add(x_current);
		}
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
		int[] x_current;
		if (bias > 0) {
			x_current = new int[m + 1];
			x_current[m] = -1;
		} else {
			x_current = new int[m];
		}
		for (int i = 0; i < m; i++) {
			temp = features.get(i);
			if (!(temp instanceof org.apache.avro.generic.GenericData.Record)) {
				throw new java.io.IOException(("features[" + i) + "] is not a record");
			}
			org.apache.avro.generic.GenericData.Record feature = ((org.apache.avro.generic.GenericData.Record) (temp));
			java.lang.String name = com.linkedin.mlease.utils.Util.getStringAvro(feature, "name", false);
			java.lang.String term = com.linkedin.mlease.utils.Util.getStringAvro(feature, "term", true);
			if (!"".equals(term)) {
				name = (name + "\u0001") + term;
			}
			if (feature.get("value") != null) {
				double value = com.linkedin.mlease.utils.Util.getDoubleAvro(feature, "value");
				if (value != 1) {
					throw new java.io.IOException("Cannot handle non-binary feature value (all feature values have to be 1; or just do not specify the value): " + feature.toString());
				}
			}
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
			x_current[i] = index;
		}
		if (m > 1) {
			java.util.Arrays.sort(x_current, 0, m);
		}
		if (useShort) {
			if (maxFeatureIndex >= java.lang.Short.MAX_VALUE) {
				throw new java.io.IOException(("When using short to store feature indices, you cannot have more than " + (java.lang.Short.MAX_VALUE - 1)) + " features!!");
			}
			short[] temp2 = new short[x_current.length];
			for (int k = 0; k < temp2.length; k++) {
				temp2[k] = ((short) (x_current[k]));
			}
			x_short.add(temp2);
		} else {
			x_int.add(x_current);
		}
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
		int[] x_current;
		if (bias > 0) {
			x_current = new int[m + 1];
			x_current[m] = -1;
		} else {
			x_current = new int[m];
		}
		for (int i = 0; i < m; i++) {
			java.lang.String name = features.get(i).name.toString();
			java.lang.String term = features.get(i).term.toString();
			if (!"".equals(term)) {
				name = (name + "\u0001") + term;
			}
			double value = features.get(i).value;
			if (value != 1) {
				throw new java.io.IOException("Cannot handle non-binary feature value (all feature values have to be 1; or just do not specify the value): " + features.get(i).toString());
			}
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
			x_current[i] = index;
		}
		if (m > 1) {
			java.util.Arrays.sort(x_current, 0, m);
		}
		if (useShort) {
			if (maxFeatureIndex >= java.lang.Short.MAX_VALUE) {
				throw new java.io.IOException(("When using short to store feature indices, you cannot have more than " + (java.lang.Short.MAX_VALUE - 1)) + " features!!");
			}
			short[] temp2 = new short[x_current.length];
			for (int k = 0; k < temp2.length; k++) {
				temp2[k] = ((short) (x_current[k]));
			}
			x_short.add(temp2);
		} else {
			x_int.add(x_current);
		}
	}

	public void reset() throws java.io.IOException {
		if (finished) {
			throw new java.io.IOException("Cannot reset a finished dataset.");
		}
		n = 0;
		l = 0;
		y_temp.clear();
		if (x_int != null) {
			x_int.clear();
		}
		if (x_short != null) {
			x_short.clear();
		}
		offset_temp.clear();
		weight_temp.clear();
		maxFeatureIndex = 0;
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
		if (useShort) {
			for (int i = 0; i < l; i++) {
				short[] x_current = x_short.get(i);
				if (bias > 0) {
					assert x_current[x_current.length - 1] == (-1);
					x_current[x_current.length - 1] = ((short) (maxFeatureIndex + 1));
				}
			}
		} else {
			for (int i = 0; i < l; i++) {
				int[] x_current = x_int.get(i);
				if (bias > 0) {
					assert x_current[x_current.length - 1] == (-1);
					x_current[x_current.length - 1] = maxFeatureIndex + 1;
				}
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
			if (useShort) {
				for (int j = 0; j < x_short.get(i).length; j++) {
					if (j > 0) {
						out.append(" ");
					}
					java.lang.String name;
					if (featureName == null) {
						name = x_short.get(i)[j] + "";
					} else {
						name = featureName.get(x_short.get(i)[j] - 1);
					}
					out.append(name + "=1");
				}
			} else {
				for (int j = 0; j < x_int.get(i).length; j++) {
					if (j > 0) {
						out.append(" ");
					}
					java.lang.String name;
					if (featureName == null) {
						name = x_int.get(i)[j] + "";
					} else {
						name = featureName.get(x_int.get(i)[j] - 1);
					}
					out.append(name + "=1");
				}
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
			throw new java.io.IOException((("l = " + l) + ", but y.length = ") + y.length);
		}
		if ((!useShort) && (l != x_int.size())) {
			throw new java.io.IOException((("l = " + l) + ", but x.size() = ") + x_int.size());
		}
		if (useShort && (l != x_short.size())) {
			throw new java.io.IOException((("l = " + l) + ", but x.size() = ") + x_short.size());
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
			if (useShort) {
				for (int i = 0; i < x_short.size(); i++) {
					for (int j = 0; j < x_short.get(i).length; j++) {
						int index = x_short.get(i)[j];
						if ((index < 1) || (index > n)) {
							throw new java.io.IOException((((("feature index out of bound x[" + i) + "][") + j) + "].index=") + index);
						}
					}
				}
			} else {
				for (int i = 0; i < x_int.size(); i++) {
					for (int j = 0; j < x_int.get(i).length; j++) {
						int index = x_int.get(i)[j];
						if ((index < 1) || (index > n)) {
							throw new java.io.IOException((((("feature index out of bound x[" + i) + "][") + j) + "].index=") + index);
						}
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
		com.linkedin.mlease.regression.liblinearfunc.LibLinearBinaryDataset d = new com.linkedin.mlease.regression.liblinearfunc.LibLinearBinaryDataset(0, false);
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