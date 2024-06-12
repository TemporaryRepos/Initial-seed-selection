public class SamplerAnomaly {
	static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.StandardCharsets.UTF_8;

	private static final java.lang.String CR = "\n";

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(net.seninp.tinker.SamplerAnomaly.class);

	public static void main(java.lang.String[] args) {
		try {
			net.seninp.tinker.SamplerAnomalyParameters params = new net.seninp.tinker.SamplerAnomalyParameters();
			com.beust.jcommander.JCommander jct = new com.beust.jcommander.JCommander(params);
			if (0 == args.length) {
				jct.usage();
			} else {
				jct.parse(args);
				java.lang.StringBuffer sb = new java.lang.StringBuffer(1024);
				sb.append("Sampler anomaly").append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("parameters:").append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  input file:                  ").append(net.seninp.tinker.SamplerAnomalyParameters.IN_FILE).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  output file:                 ").append(net.seninp.tinker.SamplerAnomalyParameters.OUT_FILE).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  SAX sliding window size:     ").append(net.seninp.tinker.SamplerAnomalyParameters.SAX_WINDOW_SIZE).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  SAX PAA size:                ").append(net.seninp.tinker.SamplerAnomalyParameters.SAX_PAA_SIZE).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  SAX alphabet size:           ").append(net.seninp.tinker.SamplerAnomalyParameters.SAX_ALPHABET_SIZE).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  SAX numerosity reduction:    ").append(net.seninp.tinker.SamplerAnomalyParameters.SAX_NR_STRATEGY).append(net.seninp.tinker.SamplerAnomaly.CR);
				sb.append("  SAX normalization threshold: ").append(net.seninp.tinker.SamplerAnomalyParameters.SAX_NORM_THRESHOLD).append(net.seninp.tinker.SamplerAnomaly.CR);
				java.lang.String dataFName = net.seninp.tinker.SamplerAnomalyParameters.IN_FILE;
				double[] ts = net.seninp.jmotif.sax.TSProcessor.readFileColumn(dataFName, 0, 0);
				net.seninp.jmotif.sax.parallel.ParallelSAXImplementation ps = new net.seninp.jmotif.sax.parallel.ParallelSAXImplementation();
				net.seninp.jmotif.sax.datastructure.SAXRecords parallelRes = ps.process(ts, 2, net.seninp.tinker.SamplerAnomalyParameters.SAX_WINDOW_SIZE, net.seninp.tinker.SamplerAnomalyParameters.SAX_PAA_SIZE, net.seninp.tinker.SamplerAnomalyParameters.SAX_ALPHABET_SIZE, net.seninp.tinker.SamplerAnomalyParameters.SAX_NR_STRATEGY, net.seninp.tinker.SamplerAnomalyParameters.SAX_NORM_THRESHOLD);
				net.seninp.gi.repair.RePairGrammar rePairGrammar = net.seninp.gi.repair.RePairFactory.buildGrammar(parallelRes);
				rePairGrammar.expandRules();
				rePairGrammar.buildIntervals(parallelRes, ts, net.seninp.tinker.SamplerAnomalyParameters.SAX_WINDOW_SIZE);
				net.seninp.gi.logic.GrammarRules rules = rePairGrammar.toGrammarRulesData();
				java.util.ArrayList<net.seninp.gi.logic.RuleInterval> intervals = new java.util.ArrayList<net.seninp.gi.logic.RuleInterval>();
				for (net.seninp.gi.logic.GrammarRuleRecord rule : rules) {
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
				java.util.List<net.seninp.gi.logic.RuleInterval> zeros = net.seninp.tinker.SamplerAnomaly.getZeroIntervals(coverageArray);
				if (zeros.size() > 0) {
					net.seninp.tinker.SamplerAnomaly.LOGGER.info((("found " + zeros.size()) + " intervals not covered by rules: ") + net.seninp.tinker.SamplerAnomaly.intervalsToString(zeros));
					intervals.addAll(net.seninp.tinker.SamplerAnomaly.getZeroIntervals(coverageArray));
				} else {
					net.seninp.tinker.SamplerAnomaly.LOGGER.info("the whole timeseries covered by rule intervals ...");
				}
				net.seninp.jmotif.sax.discord.DiscordRecords discords = net.seninp.grammarviz.anomaly.RRAImplementation.series2RRAAnomalies(ts, net.seninp.tinker.SamplerAnomalyParameters.DISCORDS_NUM, intervals, net.seninp.tinker.SamplerAnomalyParameters.SAX_NORM_THRESHOLD);
				int[] isAnomaly = new int[ts.length];
				for (int discordId = 0; discordId < discords.getSize(); discordId++) {
					net.seninp.jmotif.sax.discord.DiscordRecord d = discords.get(discordId);
					for (int i = d.getPosition(); i < (d.getPosition() + d.getLength()); i++) {
						isAnomaly[i] = discordId + 1;
					}
				}
				java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(net.seninp.tinker.SamplerAnomalyParameters.OUT_FILE)));
				for (int i : isAnomaly) {
					bw.write(i + "\n");
				}
				bw.close();
			}
		} catch (java.lang.Exception e) {
			java.lang.System.err.println((("error occured while parsing parameters " + java.util.Arrays.toString(args)) + net.seninp.tinker.SamplerAnomaly.CR) + net.seninp.util.StackTrace.toString(e));
			java.lang.System.exit(-1);
		}
	}

	private static java.util.List<net.seninp.gi.logic.RuleInterval> getZeroIntervals(int[] coverageArray) {
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

	private static java.lang.String intervalsToString(java.util.List<net.seninp.gi.logic.RuleInterval> zeros) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		for (net.seninp.gi.logic.RuleInterval i : zeros) {
			sb.append(i.toString()).append(",");
		}
		return sb.toString();
	}
}