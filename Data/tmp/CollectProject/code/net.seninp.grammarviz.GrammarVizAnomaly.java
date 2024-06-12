public class GrammarVizAnomaly {
	static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.StandardCharsets.UTF_8;

	private static final java.lang.String CR = "\n";

	private static net.seninp.jmotif.sax.TSProcessor tp = new net.seninp.jmotif.sax.TSProcessor();

	private static net.seninp.jmotif.distance.EuclideanDistance ed = new net.seninp.jmotif.distance.EuclideanDistance();

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(net.seninp.grammarviz.GrammarVizAnomaly.class);

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomalyParameters params = new net.seninp.grammarviz.GrammarVizAnomalyParameters();
		com.beust.jcommander.JCommander jct = new com.beust.jcommander.JCommander(params);
		if (0 == args.length) {
			jct.usage();
		} else {
			jct.parse(args);
			java.lang.StringBuffer sb = new java.lang.StringBuffer(1024);
			sb.append(net.seninp.grammarviz.GrammarVizAnomaly.CR).append("GrammarViz2 CLI anomaly discovery").append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			sb.append("parameters:").append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			sb.append(" input file:                  ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.IN_FILE).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			sb.append(" output files prefix:         ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.OUT_FILE).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			sb.append(" Algorithm implementation:    ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			sb.append(" Num. of discords to report:  ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			if (!(net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM))) {
				sb.append(" SAX sliding window size:     ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_WINDOW_SIZE).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			}
			if (!net.seninp.grammarviz.anomaly.AnomalyAlgorithm.BRUTEFORCE.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				if (!(net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM))) {
					sb.append(" SAX PAA size:                ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_PAA_SIZE).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
					sb.append(" SAX alphabet size:           ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_ALPHABET_SIZE).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
				}
				sb.append(" SAX numerosity reduction:    ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
				sb.append(" SAX normalization threshold: ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			}
			if (((net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRA.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRAPRUNED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				sb.append(" GI Algorithm:                ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.GI_ALGORITHM_IMPLEMENTATION).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			}
			if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				sb.append(" Grid boundaries:             ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.GRID_BOUNDARIES).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			}
			if ((net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM) || net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) && (!java.lang.Double.isNaN(net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION))) {
				sb.append(" Subsampling fraction:        ").append(net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION).append(net.seninp.grammarviz.GrammarVizAnomaly.CR);
			}
			java.lang.System.out.println(sb.toString());
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("Reading data ...");
			double[] series = net.seninp.grammarviz.GrammarVizAnomaly.tp.readTS(net.seninp.grammarviz.GrammarVizAnomalyParameters.IN_FILE, 0);
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((("read " + series.length) + " points from ") + net.seninp.grammarviz.GrammarVizAnomalyParameters.IN_FILE);
			if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.BRUTEFORCE.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findBruteForce(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_WINDOW_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			} else if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.HOTSAX.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findHotSax(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_WINDOW_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_PAA_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_ALPHABET_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			} else if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRA.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findRRA(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_WINDOW_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_PAA_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_ALPHABET_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.GI_ALGORITHM_IMPLEMENTATION, net.seninp.grammarviz.GrammarVizAnomalyParameters.OUT_FILE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			} else if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRAPRUNED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_WINDOW_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_PAA_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_ALPHABET_SIZE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.GI_ALGORITHM_IMPLEMENTATION, net.seninp.grammarviz.GrammarVizAnomalyParameters.OUT_FILE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			} else if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.RRASAMPLED.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findRRASampled(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.GRID_BOUNDARIES, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.GI_ALGORITHM_IMPLEMENTATION, net.seninp.grammarviz.GrammarVizAnomalyParameters.OUT_FILE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			} else if (net.seninp.grammarviz.anomaly.AnomalyAlgorithm.EXPERIMENT.equals(net.seninp.grammarviz.GrammarVizAnomalyParameters.ALGORITHM)) {
				net.seninp.grammarviz.GrammarVizAnomaly.findRRAExperiment(series, net.seninp.grammarviz.GrammarVizAnomalyParameters.GRID_BOUNDARIES, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.DISCORDS_NUM, net.seninp.grammarviz.GrammarVizAnomalyParameters.GI_ALGORITHM_IMPLEMENTATION, net.seninp.grammarviz.GrammarVizAnomalyParameters.OUT_FILE, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
			}
		}
	}

	private static void findRRAExperiment(double[] ts, java.lang.String boundaries, net.seninp.jmotif.sax.NumerosityReductionStrategy saxNRStrategy, int discordsToReport, net.seninp.gi.GIAlgorithm giImplementation, java.lang.String outputPrefix, double normalizationThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running RRA with experiment sampling algorithm...");
		int[] bounds = net.seninp.grammarviz.GrammarVizAnomaly.toBoundaries(net.seninp.grammarviz.GrammarVizAnomalyParameters.GRID_BOUNDARIES);
		java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint> res = new java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint>();
		net.seninp.gi.rulepruner.RulePruner rp;
		if (net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION.isNaN()) {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("sampling on full time series length");
			rp = new net.seninp.gi.rulepruner.RulePruner(ts);
		} else {
			int sampleIntervalStart = 0;
			int sampleIntervalEnd = ((int) (java.lang.Math.round(ts.length * net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION)));
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info(((("sampling parameters on interval [" + sampleIntervalStart) + ", ") + sampleIntervalEnd) + "]");
			rp = new net.seninp.gi.rulepruner.RulePruner(java.util.Arrays.copyOfRange(ts, sampleIntervalStart, sampleIntervalEnd));
		}
		for (int WINDOW_SIZE = bounds[0]; WINDOW_SIZE < bounds[1]; WINDOW_SIZE += bounds[2]) {
			for (int PAA_SIZE = bounds[3]; PAA_SIZE < bounds[4]; PAA_SIZE += bounds[5]) {
				if (PAA_SIZE > WINDOW_SIZE) {
					continue;
				}
				for (int ALPHABET_SIZE = bounds[6]; ALPHABET_SIZE < bounds[7]; ALPHABET_SIZE += bounds[8]) {
					net.seninp.gi.rulepruner.SampledPoint p = rp.sample(WINDOW_SIZE, PAA_SIZE, ALPHABET_SIZE, net.seninp.gi.GIAlgorithm.REPAIR, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
					res.add(p);
					net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((((((((((((((((((("# " + WINDOW_SIZE) + ",") + PAA_SIZE) + ",") + ALPHABET_SIZE) + ",") + p.getApproxDist()) + ",") + p.getGrammarSize()) + ",") + p.getCompressedGrammarSize()) + ",") + p.getGrammarRules()) + ",") + p.getPrunedRules()) + ",") + p.getCoverage()) + ",") + p.getMaxFrequency());
				}
			}
		}
		java.util.Collections.sort(res, new net.seninp.grammarviz.GrammarSizeSorter());
		java.lang.System.out.println(((((net.seninp.grammarviz.GrammarVizAnomaly.CR + "# GLOBALLY MIN GRAMMAR size is ") + res.get(0).toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Running RRAPruned ...") + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		int windowSize = res.get(0).getWindow();
		int paaSize = res.get(0).getPAA();
		int alphabetSize = res.get(0).getAlphabet();
		net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(ts, windowSize, alphabetSize, paaSize, saxNRStrategy, discordsToReport, giImplementation, outputPrefix, normalizationThreshold);
		java.util.Collections.sort(res, new net.seninp.gi.rulepruner.ReducedGrammarSizeSorter());
		java.lang.System.out.println(((((net.seninp.grammarviz.GrammarVizAnomaly.CR + "# GLOBALLY MIN PRUNED grammar size: ") + res.get(0).toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Running RRAPruned ...") + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		windowSize = res.get(0).getWindow();
		paaSize = res.get(0).getPAA();
		alphabetSize = res.get(0).getAlphabet();
		net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(ts, windowSize, alphabetSize, paaSize, saxNRStrategy, discordsToReport, giImplementation, outputPrefix, normalizationThreshold);
		double threshold = 0.99;
		java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint> resCovered = new java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint>();
		for (net.seninp.gi.rulepruner.SampledPoint p : res) {
			if (p.getCoverage() >= threshold) {
				resCovered.add(p);
			}
		}
		java.util.Collections.sort(resCovered, new net.seninp.grammarviz.GrammarSizeSorter());
		java.lang.System.out.println(((((net.seninp.grammarviz.GrammarVizAnomaly.CR + "# COVERED ABOVE THRESHOLD MIN GRAMMAR parameters are ") + resCovered.get(0).toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Running RRAPruned ...") + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		windowSize = resCovered.get(0).getWindow();
		paaSize = resCovered.get(0).getPAA();
		alphabetSize = resCovered.get(0).getAlphabet();
		net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(ts, windowSize, alphabetSize, paaSize, saxNRStrategy, discordsToReport, giImplementation, outputPrefix, normalizationThreshold);
		java.util.Collections.sort(resCovered, new net.seninp.gi.rulepruner.ReducedGrammarSizeSorter());
		java.lang.System.out.println(((((net.seninp.grammarviz.GrammarVizAnomaly.CR + "# COVERED ABOVE THRESHOLD MIN PRUNED GRAMMAR : ") + resCovered.get(0).toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Running RRAPruned ...") + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		windowSize = resCovered.get(0).getWindow();
		paaSize = resCovered.get(0).getPAA();
		alphabetSize = resCovered.get(0).getAlphabet();
		net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(ts, windowSize, alphabetSize, paaSize, saxNRStrategy, discordsToReport, giImplementation, outputPrefix, normalizationThreshold);
	}

	private static void findRRASampled(double[] ts, java.lang.String boundaries, net.seninp.jmotif.sax.NumerosityReductionStrategy saxNRStrategy, int discordsToReport, net.seninp.gi.GIAlgorithm giImplementation, java.lang.String outputPrefix, double normalizationThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running RRA with sampling algorithm...");
		int[] bounds = net.seninp.grammarviz.GrammarVizAnomaly.toBoundaries(net.seninp.grammarviz.GrammarVizAnomalyParameters.GRID_BOUNDARIES);
		java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint> res = new java.util.ArrayList<net.seninp.gi.rulepruner.SampledPoint>();
		net.seninp.gi.rulepruner.RulePruner rp;
		if (net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION.isNaN()) {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("sampling on full time series length");
			rp = new net.seninp.gi.rulepruner.RulePruner(ts);
		} else {
			int sampleIntervalStart = 0;
			int sampleIntervalEnd = ((int) (java.lang.Math.round(ts.length * net.seninp.grammarviz.GrammarVizAnomalyParameters.SUBSAMPLING_FRACTION)));
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info(((("sampling parameters on interval [" + sampleIntervalStart) + ", ") + sampleIntervalEnd) + "]");
			rp = new net.seninp.gi.rulepruner.RulePruner(java.util.Arrays.copyOfRange(ts, sampleIntervalStart, sampleIntervalEnd));
		}
		for (int WINDOW_SIZE = bounds[0]; WINDOW_SIZE < bounds[1]; WINDOW_SIZE += bounds[2]) {
			for (int PAA_SIZE = bounds[3]; PAA_SIZE < bounds[4]; PAA_SIZE += bounds[5]) {
				if (PAA_SIZE > WINDOW_SIZE) {
					continue;
				}
				for (int ALPHABET_SIZE = bounds[6]; ALPHABET_SIZE < bounds[7]; ALPHABET_SIZE += bounds[8]) {
					net.seninp.gi.rulepruner.SampledPoint p = rp.sample(WINDOW_SIZE, PAA_SIZE, ALPHABET_SIZE, net.seninp.gi.GIAlgorithm.REPAIR, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NR_STRATEGY, net.seninp.grammarviz.GrammarVizAnomalyParameters.SAX_NORM_THRESHOLD);
					res.add(p);
				}
			}
		}
		java.util.Collections.sort(res, new net.seninp.gi.rulepruner.ReductionSorter());
		java.lang.System.out.println(((((net.seninp.grammarviz.GrammarVizAnomaly.CR + "Apparently, the best parameters are ") + res.get(0).toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Running RRAPRUNED...") + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		int windowSize = res.get(0).getWindow();
		int paaSize = res.get(0).getPAA();
		int alphabetSize = res.get(0).getAlphabet();
		net.seninp.grammarviz.GrammarVizAnomaly.findRRAPruned(ts, windowSize, alphabetSize, paaSize, saxNRStrategy, discordsToReport, giImplementation, outputPrefix, normalizationThreshold);
	}

	private static void findRRAPruned(double[] ts, int windowSize, int paaSize, int alphabetSize, net.seninp.jmotif.sax.NumerosityReductionStrategy saxNRStrategy, int discordsToReport, net.seninp.gi.GIAlgorithm giImplementation, java.lang.String outputPrefix, double normalizationThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running RRA with pruning algorithm, building the grammar ...");
		java.util.Date start = new java.util.Date();
		net.seninp.gi.logic.GrammarRules rules;
		if (net.seninp.gi.GIAlgorithm.SEQUITUR.equals(giImplementation)) {
			rules = net.seninp.gi.sequitur.SequiturFactory.series2SequiturRules(ts, windowSize, paaSize, alphabetSize, saxNRStrategy, normalizationThreshold);
		} else {
			net.seninp.jmotif.sax.parallel.ParallelSAXImplementation ps = new net.seninp.jmotif.sax.parallel.ParallelSAXImplementation();
			net.seninp.jmotif.sax.datastructure.SAXRecords parallelRes = ps.process(ts, 2, windowSize, paaSize, alphabetSize, saxNRStrategy, normalizationThreshold);
			net.seninp.gi.repair.RePairGrammar rePairGrammar = net.seninp.gi.repair.RePairFactory.buildGrammar(parallelRes);
			rePairGrammar.expandRules();
			rePairGrammar.buildIntervals(parallelRes, ts, windowSize);
			rules = rePairGrammar.toGrammarRulesData();
		}
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info(((rules.size() + " rules inferred in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), new java.util.Date().getTime())) + ", pruning ...");
		net.seninp.gi.logic.GrammarRules prunedRulesSet = net.seninp.gi.rulepruner.RulePrunerFactory.performPruning(ts, rules);
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info(((("finished pruning in " + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), new java.util.Date().getTime())) + ", keeping ") + prunedRulesSet.size()) + " rules for anomaly discovery ...");
		java.util.ArrayList<net.seninp.gi.logic.RuleInterval> intervals = new java.util.ArrayList<net.seninp.gi.logic.RuleInterval>();
		for (net.seninp.gi.logic.GrammarRuleRecord rule : prunedRulesSet) {
			if (0 == rule.ruleNumber()) {
				continue;
			}
			for (net.seninp.gi.logic.RuleInterval ri : rule.getRuleIntervals()) {
				ri.setCoverage(rule.getRuleIntervals().size());
				ri.setId(rule.ruleNumber());
				intervals.add(ri);
			}
		}
		int[] coverageArray = new int[ts.length];
		for (net.seninp.gi.logic.GrammarRuleRecord rule : prunedRulesSet) {
			if (0 == rule.ruleNumber()) {
				continue;
			}
			java.util.ArrayList<net.seninp.gi.logic.RuleInterval> arrPos = rule.getRuleIntervals();
			for (net.seninp.gi.logic.RuleInterval saxPos : arrPos) {
				int startPos = saxPos.getStart();
				int endPos = saxPos.getEnd();
				for (int j = startPos; j < endPos; j++) {
					coverageArray[j] = coverageArray[j] + 1;
				}
			}
		}
		java.util.List<net.seninp.gi.logic.RuleInterval> zeros = net.seninp.grammarviz.GrammarVizAnomaly.getZeroIntervals(coverageArray);
		if (zeros.size() > 0) {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((("found " + zeros.size()) + " intervals not covered by rules: ") + net.seninp.grammarviz.GrammarVizAnomaly.intervalsToString(zeros));
			intervals.addAll(zeros);
		} else {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("the whole timeseries is covered by rule intervals ...");
		}
		net.seninp.jmotif.sax.discord.DiscordRecords discords = net.seninp.grammarviz.anomaly.RRAImplementation.series2RRAAnomalies(ts, discordsToReport, intervals, normalizationThreshold);
		java.util.Date end = new java.util.Date();
		java.lang.System.out.println((((discords.toString() + net.seninp.grammarviz.GrammarVizAnomaly.CR) + "Discords found in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime())) + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		if (!outputPrefix.isEmpty()) {
			java.lang.String currentPath = new java.io.File(".").getCanonicalPath();
			java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(((currentPath + java.io.File.separator) + outputPrefix) + "_coverage.txt")));
			for (int i : coverageArray) {
				bw.write(i + "\n");
			}
			bw.close();
			java.util.Collections.sort(intervals, new java.util.Comparator<net.seninp.gi.logic.RuleInterval>() {
				public int compare(net.seninp.gi.logic.RuleInterval c1, net.seninp.gi.logic.RuleInterval c2) {
					if (c1.getStart() > c2.getStart()) {
						return 1;
					} else if (c1.getStart() < c2.getStart()) {
						return -1;
					}
					return 0;
				}
			});
			double[] distances = new double[ts.length];
			double[] widths = new double[ts.length];
			for (net.seninp.gi.logic.RuleInterval ri : intervals) {
				int ruleStart = ri.getStart();
				int ruleEnd = ruleStart + ri.getLength();
				int window = ruleEnd - ruleStart;
				double[] cw = net.seninp.grammarviz.GrammarVizAnomaly.tp.subseriesByCopy(ts, ruleStart, ruleStart + window);
				double cwNNDist = java.lang.Double.MAX_VALUE;
				for (int j = 0; j < ((ts.length - window) - 1); j++) {
					if (java.lang.Math.abs(ruleStart - j) > window) {
						double[] currentSubsequence = net.seninp.grammarviz.GrammarVizAnomaly.tp.subseriesByCopy(ts, j, j + window);
						double dist = net.seninp.grammarviz.GrammarVizAnomaly.ed.distance(cw, currentSubsequence);
						if (dist < cwNNDist) {
							cwNNDist = dist;
						}
					}
				}
				distances[ruleStart] = cwNNDist;
				widths[ruleStart] = ri.getLength();
			}
			bw = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(((currentPath + java.io.File.separator) + outputPrefix) + "_distances.txt")));
			for (int i = 0; i < distances.length; i++) {
				bw.write(((((i + ",") + distances[i]) + ",") + widths[i]) + "\n");
			}
			bw.close();
		}
	}

	private static void findRRA(double[] ts, int windowSize, int paaSize, int alphabetSize, net.seninp.jmotif.sax.NumerosityReductionStrategy saxNRStrategy, int discordsToReport, net.seninp.gi.GIAlgorithm giImplementation, java.lang.String outputPrefix, double normalizationThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running RRA algorithm...");
		java.util.Date start = new java.util.Date();
		net.seninp.gi.logic.GrammarRules rules;
		if (net.seninp.gi.GIAlgorithm.SEQUITUR.equals(giImplementation)) {
			rules = net.seninp.gi.sequitur.SequiturFactory.series2SequiturRules(ts, windowSize, paaSize, alphabetSize, saxNRStrategy, normalizationThreshold);
			java.util.Date end = new java.util.Date();
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((rules.size() + " Sequitur rules inferred in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime()));
		} else {
			net.seninp.jmotif.sax.parallel.ParallelSAXImplementation ps = new net.seninp.jmotif.sax.parallel.ParallelSAXImplementation();
			net.seninp.jmotif.sax.datastructure.SAXRecords parallelRes = ps.process(ts, 2, windowSize, paaSize, alphabetSize, saxNRStrategy, normalizationThreshold);
			net.seninp.gi.repair.RePairGrammar rePairGrammar = net.seninp.gi.repair.RePairFactory.buildGrammar(parallelRes);
			rePairGrammar.expandRules();
			rePairGrammar.buildIntervals(parallelRes, ts, windowSize);
			rules = rePairGrammar.toGrammarRulesData();
			java.util.Date end = new java.util.Date();
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((rules.size() + " RePair rules inferred in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime()));
		}
		java.util.ArrayList<net.seninp.gi.logic.RuleInterval> intervals = new java.util.ArrayList<net.seninp.gi.logic.RuleInterval>(rules.size() * 2);
		for (net.seninp.gi.logic.GrammarRuleRecord rule : rules) {
			if (0 == rule.ruleNumber()) {
				continue;
			}
			for (net.seninp.gi.logic.RuleInterval ri : rule.getRuleIntervals()) {
				net.seninp.gi.logic.RuleInterval i = ((net.seninp.gi.logic.RuleInterval) (ri.clone()));
				i.setCoverage(rule.getRuleIntervals().size());
				i.setId(rule.ruleNumber());
				intervals.add(i);
			}
		}
		int[] coverageArray = new int[ts.length];
		for (net.seninp.gi.logic.GrammarRuleRecord rule : rules) {
			if (0 == rule.ruleNumber()) {
				continue;
			}
			java.util.ArrayList<net.seninp.gi.logic.RuleInterval> arrPos = rule.getRuleIntervals();
			for (net.seninp.gi.logic.RuleInterval saxPos : arrPos) {
				int startPos = saxPos.getStart();
				int endPos = saxPos.getEnd();
				for (int j = startPos; j < endPos; j++) {
					coverageArray[j] = coverageArray[j] + 1;
				}
			}
		}
		java.util.List<net.seninp.gi.logic.RuleInterval> zeros = net.seninp.grammarviz.GrammarVizAnomaly.getZeroIntervals(coverageArray);
		if (zeros.size() > 0) {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info((("found " + zeros.size()) + " intervals not covered by rules: ") + net.seninp.grammarviz.GrammarVizAnomaly.intervalsToString(zeros));
			intervals.addAll(zeros);
		} else {
			net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("the whole timeseries is covered by rule intervals ...");
		}
		net.seninp.jmotif.sax.discord.DiscordRecords discords = net.seninp.grammarviz.anomaly.RRAImplementation.series2RRAAnomalies(ts, discordsToReport, intervals, normalizationThreshold);
		java.util.Date end = new java.util.Date();
		java.lang.System.out.println(((((discords.toString() + net.seninp.grammarviz.GrammarVizAnomaly.CR) + discords.getSize()) + " discords found in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime())) + net.seninp.grammarviz.GrammarVizAnomaly.CR);
		if (!outputPrefix.isEmpty()) {
			java.lang.String currentPath = new java.io.File(".").getCanonicalPath();
			java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(((currentPath + java.io.File.separator) + outputPrefix) + "_coverage.txt")));
			for (int i : coverageArray) {
				bw.write(i + "\n");
			}
			bw.close();
			java.util.Collections.sort(intervals, new java.util.Comparator<net.seninp.gi.logic.RuleInterval>() {
				public int compare(net.seninp.gi.logic.RuleInterval c1, net.seninp.gi.logic.RuleInterval c2) {
					if (c1.getStart() > c2.getStart()) {
						return 1;
					} else if (c1.getStart() < c2.getStart()) {
						return -1;
					}
					return 0;
				}
			});
			double[] distances = new double[ts.length];
			double[] widths = new double[ts.length];
			for (net.seninp.gi.logic.RuleInterval ri : intervals) {
				int ruleStart = ri.getStart();
				int ruleEnd = ruleStart + ri.getLength();
				int window = ruleEnd - ruleStart;
				double[] cw = net.seninp.grammarviz.GrammarVizAnomaly.tp.subseriesByCopy(ts, ruleStart, ruleStart + window);
				double cwNNDist = java.lang.Double.MAX_VALUE;
				for (int j = 0; j < ((ts.length - window) - 1); j++) {
					if (java.lang.Math.abs(ruleStart - j) > window) {
						double[] currentSubsequence = net.seninp.grammarviz.GrammarVizAnomaly.tp.subseriesByCopy(ts, j, j + window);
						double dist = net.seninp.grammarviz.GrammarVizAnomaly.ed.distance(cw, currentSubsequence);
						if (dist < cwNNDist) {
							cwNNDist = dist;
						}
					}
				}
				distances[ruleStart] = cwNNDist;
				widths[ruleStart] = ri.getLength();
			}
			bw = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(((currentPath + java.io.File.separator) + outputPrefix) + "_distances.txt")));
			for (int i = 0; i < distances.length; i++) {
				bw.write(((((i + ",") + distances[i]) + ",") + widths[i]) + "\n");
			}
			bw.close();
		}
	}

	private static void findBruteForce(double[] ts, int windowSize, int discordsToReport, double nThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running brute force algorithm...");
		java.util.Date start = new java.util.Date();
		net.seninp.jmotif.sax.discord.DiscordRecords discords = net.seninp.jmotif.sax.discord.BruteForceDiscordImplementation.series2BruteForceDiscords(ts, windowSize, discordsToReport, new net.seninp.jmotif.sax.registry.LargeWindowAlgorithm(), nThreshold);
		java.util.Date end = new java.util.Date();
		java.lang.System.out.println((((((net.seninp.grammarviz.GrammarVizAnomaly.CR + discords.toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + discords.getSize()) + " discords found in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime())) + net.seninp.grammarviz.GrammarVizAnomaly.CR);
	}

	private static void findHotSax(double[] ts, int discordsToReport, int windowSize, int paaSize, int alphabetSize, net.seninp.jmotif.sax.NumerosityReductionStrategy saxNRStrategy, double normalizationThreshold) throws java.lang.Exception {
		net.seninp.grammarviz.GrammarVizAnomaly.LOGGER.info("running HOT SAX hashtable-based algorithm...");
		java.util.Date start = new java.util.Date();
		net.seninp.jmotif.sax.discord.DiscordRecords discords = net.seninp.jmotif.sax.discord.HOTSAXImplementation.series2Discords(ts, discordsToReport, windowSize, paaSize, alphabetSize, saxNRStrategy, normalizationThreshold);
		java.util.Date end = new java.util.Date();
		java.lang.System.out.println((((((net.seninp.grammarviz.GrammarVizAnomaly.CR + discords.toString()) + net.seninp.grammarviz.GrammarVizAnomaly.CR) + discords.getSize()) + " discords found in ") + net.seninp.jmotif.sax.SAXProcessor.timeToString(start.getTime(), end.getTime())) + net.seninp.grammarviz.GrammarVizAnomaly.CR);
	}

	private static java.lang.String intervalsToString(java.util.List<net.seninp.gi.logic.RuleInterval> zeros) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (net.seninp.gi.logic.RuleInterval i : zeros) {
			sb.append(i.toString()).append(",");
		}
		return sb.toString();
	}

	public static java.util.List<net.seninp.gi.logic.RuleInterval> getZeroIntervals(int[] coverageArray) {
		java.util.ArrayList<net.seninp.gi.logic.RuleInterval> res = new java.util.ArrayList<net.seninp.gi.logic.RuleInterval>();
		int start = -1;
		boolean inInterval = false;
		int intervalsCounter = -1;
		for (int i = 0; i < coverageArray.length; i++) {
			if ((0 == coverageArray[i]) && (!inInterval)) {
				start = i;
				inInterval = true;
			}
			if ((coverageArray[i] > 0) && inInterval) {
				res.add(new net.seninp.gi.logic.RuleInterval(intervalsCounter, start, i, 0));
				inInterval = false;
				intervalsCounter--;
			}
		}
		return res;
	}

	private static int[] toBoundaries(java.lang.String str) {
		int[] res = new int[9];
		java.lang.String[] split = str.split("\\s+");
		for (int i = 0; i < 9; i++) {
			res[i] = java.lang.Integer.valueOf(split[i]);
		}
		return res;
	}
}