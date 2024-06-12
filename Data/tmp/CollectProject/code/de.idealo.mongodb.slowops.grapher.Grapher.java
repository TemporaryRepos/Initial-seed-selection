public class Grapher {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(de.idealo.mongodb.slowops.grapher.Grapher.class);

	private final int scale;

	private final org.jongo.MongoCollection coll;

	public Grapher() {
		coll = getProfilingCollection();
		final java.lang.String scaleStr = de.idealo.mongodb.slowops.util.ConfigReader.getString(de.idealo.mongodb.slowops.util.ConfigReader.CONFIG, de.idealo.mongodb.slowops.util.Util.Y_AXIS_SCALE, de.idealo.mongodb.slowops.util.Util.Y_AXIS_MILLISECONDS);
		if (scaleStr.equals(de.idealo.mongodb.slowops.util.Util.Y_AXIS_MILLISECONDS)) {
			scale = 1;
		} else {
			scale = 1000;
		}
		de.idealo.mongodb.slowops.grapher.Grapher.LOG.info("scaleStr: {} scale: {}", scaleStr, scale);
	}

	private org.jongo.MongoCollection getProfilingCollection() {
		de.idealo.mongodb.slowops.dto.CollectorServerDto serverDto = de.idealo.mongodb.slowops.util.ConfigReader.getCollectorServer();
		try {
			de.idealo.mongodb.slowops.monitor.MongoDbAccessor mongo = new de.idealo.mongodb.slowops.monitor.MongoDbAccessor(60000, -1, true, serverDto.getAdminUser(), serverDto.getAdminPw(), serverDto.getSsl(), serverDto.getHosts());
			com.mongodb.DB db = mongo.getMongoDB(serverDto.getDb());
			org.jongo.Jongo jongo = new org.jongo.Jongo(db);
			org.jongo.MongoCollection result = jongo.getCollection(serverDto.getCollection());
			if (result == null) {
				throw new java.lang.IllegalArgumentException("Can't continue without profile collection for " + serverDto.getHosts());
			}
			return result;
		} catch (com.mongodb.MongoException e) {
			de.idealo.mongodb.slowops.grapher.Grapher.LOG.error("Exception while connecting to: {}", serverDto.getHosts(), e);
		}
		return null;
	}

	public de.idealo.mongodb.slowops.dto.SlowOpsDto aggregateSlowQueries(java.lang.StringBuffer filter, java.lang.Object[] params, java.lang.StringBuffer groupExp, java.lang.StringBuffer groupTime) {
		final de.idealo.mongodb.slowops.dto.SlowOpsDto result = new de.idealo.mongodb.slowops.dto.SlowOpsDto();
		final java.lang.String[] customFields = new java.lang.String[]{ "count", "minSec", "maxSec", "sumSec", "stdDevMs", "nRet", "minRet", "maxRet", "avgRet", "stdDevRet", "len", "minLen", "maxLen", "avgLen", "stdDevLen", "rKeys", "rDocs", "wDocs", "memSort" };
		org.jongo.Aggregate.ResultsIterator<de.idealo.mongodb.slowops.grapher.AggregatedProfiling> queryResult = null;
		de.idealo.mongodb.slowops.grapher.Grapher.LOG.debug("filter: {}", filter);
		de.idealo.mongodb.slowops.grapher.Grapher.LOG.debug("groupExp: {}", groupExp);
		de.idealo.mongodb.slowops.grapher.Grapher.LOG.debug("groupTime: {}", groupTime);
		try {
			final java.util.Date begin = new java.util.Date();
			queryResult = coll.aggregate(filter.toString(), params).and((((((((((((((((((((((((((((("{$group:{" + "_id:{") + groupExp.toString()) + groupTime.toString()) + "},") + "count : { $sum : 1 },") + "millis : { $sum : '$millis' },") + "avgMs : { $avg : '$millis' },") + "minMs : { $min : '$millis' },") + "maxMs : { $max : '$millis' },") + "stdDevMs : { $stdDevPop : '$millis' },") + "nRet : { $sum : '$nret' },") + "avgRet : { $avg : '$nret' },") + "minRet : { $min : '$nret' },") + "maxRet : { $max : '$nret' },") + "stdDevRet : { $stdDevPop : '$nret' },") + "len : { $sum : '$resplen' },") + "avgLen : { $avg : '$resplen' },") + "minLen : { $min : '$resplen' },") + "maxLen : { $max : '$resplen' },") + "stdDevLen : { $stdDevPop : '$resplen' },") + "firstts : { $first : '$ts' },") + "keys : { $sum : '$keys' },") + "docs : { $sum : '$docs' },") + "del : { $sum : '$del' },") + "ins : { $sum : '$ins' },") + "mod : { $sum : '$mod' },") + "sortstages : { $addToSet : '$sortstg' }") + "}") + "}").and("{$sort:{" + (("firstts:1" + "}") + "}")).as(de.idealo.mongodb.slowops.grapher.AggregatedProfiling.class);
			de.idealo.mongodb.slowops.grapher.Grapher.LOG.debug("Duration in ms: {}", new java.util.Date().getTime() - begin.getTime());
		} catch (com.mongodb.MongoException e) {
			de.idealo.mongodb.slowops.grapher.Grapher.LOG.warn("MongoException while aggregating.", e);
			result.setErrorMessage(e.getMessage());
			return result;
		} catch (java.lang.IllegalArgumentException e) {
			de.idealo.mongodb.slowops.grapher.Grapher.LOG.warn("MongoException while aggregating.", e);
			result.setErrorMessage("Please enter only valid values!");
			return result;
		}
		final java.util.Map<java.util.Calendar, java.util.Set<de.idealo.mongodb.slowops.grapher.AggregatedProfiling>> timeSeries = new java.util.TreeMap<java.util.Calendar, java.util.Set<de.idealo.mongodb.slowops.grapher.AggregatedProfiling>>();
		final com.google.common.collect.HashBiMap<java.lang.String, java.lang.Integer> groups = com.google.common.collect.HashBiMap.create();
		final java.util.HashMap<java.lang.String, de.idealo.mongodb.slowops.grapher.AggregatedProfiling> labelSeries = new java.util.HashMap<java.lang.String, de.idealo.mongodb.slowops.grapher.AggregatedProfiling>();
		int index = 0;
		java.util.Calendar minCalendar = new java.util.GregorianCalendar();
		double maxAvgMs = 0;
		double maxMinMs = 0;
		double maxMaxMs = 0;
		long maxSumMs = 0;
		for (de.idealo.mongodb.slowops.grapher.AggregatedProfiling entry : queryResult) {
			final de.idealo.mongodb.slowops.grapher.AggregatedProfilingId id = entry.getId();
			final java.lang.String idLabel = id.getLabel(false);
			if (!groups.containsKey(idLabel)) {
				groups.put(idLabel, java.lang.Integer.valueOf(index++));
			}
			if (!labelSeries.containsKey(idLabel)) {
				labelSeries.put(idLabel, entry.clone());
			} else {
				labelSeries.get(idLabel).combine(entry);
			}
			final java.util.Calendar calendar = id.getCalendar();
			java.util.Set<de.idealo.mongodb.slowops.grapher.AggregatedProfiling> serie = timeSeries.get(calendar);
			if (serie == null) {
				serie = new java.util.HashSet<de.idealo.mongodb.slowops.grapher.AggregatedProfiling>();
				timeSeries.put(calendar, serie);
			}
			serie.add(entry);
			if (minCalendar.after(calendar)) {
				minCalendar = ((java.util.Calendar) (calendar.clone()));
			}
			if (maxAvgMs < entry.getAvgMs()) {
				maxAvgMs = entry.getAvgMs();
			}
			if (maxMinMs < entry.getMinMs()) {
				maxMinMs = entry.getMinMs();
			}
			if (maxMaxMs < entry.getMaxMs()) {
				maxMaxMs = entry.getMaxMs();
			}
			if (maxSumMs < entry.getMillis()) {
				maxSumMs = entry.getMillis();
			}
		}
		final java.lang.StringBuffer labels = new java.lang.StringBuffer("\"Date\",");
		final com.google.common.collect.BiMap<java.lang.Integer, java.lang.String> inversedGroups = groups.inverse();
		for (int i = 0; i < index; i++) {
			labels.append("\"").append(inversedGroups.get(java.lang.Integer.valueOf(i))).append("\",");
			for (int n = 0; n < customFields.length; n++) {
				labels.append("\"").append(customFields[n]).append("\",");
			}
		}
		if (labels.length() > 0) {
			labels.deleteCharAt(labels.length() - 1);
		}
		final java.lang.StringBuffer dataGrid = new java.lang.StringBuffer("[");
		final java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		final java.text.DecimalFormatSymbols symbols = new java.text.DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		final java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#", symbols);
		minCalendar.add(java.util.Calendar.MINUTE, -1);
		dataGrid.append("[new Date(\"").append(dateFormat.format(minCalendar.getTime())).append("\"),");
		dataGrid.append(decimalFormat.format((maxAvgMs / (-scale)) / 10)).append(",0,");
		dataGrid.append(decimalFormat.format((maxMinMs / (-scale)) / 10)).append(",");
		dataGrid.append(decimalFormat.format((maxMaxMs / (-scale)) / 10)).append(",");
		dataGrid.append(decimalFormat.format((maxSumMs / (-scale)) / 10)).append(",");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		dataGrid.append("0,");
		final int lineSize = (groups.size() - 1) * (customFields.length + 1);
		for (int i = 0; i < lineSize; i++) {
			dataGrid.append("0").append(",");
		}
		dataGrid.deleteCharAt(dataGrid.length() - 1);
		dataGrid.append("],\n");
		for (java.util.Calendar calendar : timeSeries.keySet()) {
			final java.util.Set<de.idealo.mongodb.slowops.grapher.AggregatedProfiling> entries = timeSeries.get(calendar);
			dataGrid.append("[new Date(\"").append(dateFormat.format(calendar.getTime())).append("\"),");
			final java.lang.String[] values = new java.lang.String[groups.size() * (customFields.length + 1)];
			for (de.idealo.mongodb.slowops.grapher.AggregatedProfiling entry : entries) {
				final de.idealo.mongodb.slowops.grapher.AggregatedProfilingId id = entry.getId();
				final java.lang.String idLabel = id.getLabel(false);
				final java.lang.Integer idx = ((java.lang.Integer) (groups.get(idLabel)));
				final int startIdx = idx.intValue() * (customFields.length + 1);
				values[startIdx] = decimalFormat.format(entry.getAvgMs() / scale);
				values[startIdx + 1] = "" + entry.getCount();
				values[startIdx + 2] = decimalFormat.format(entry.getMinMs() / scale);
				values[startIdx + 3] = decimalFormat.format(entry.getMaxMs() / scale);
				values[startIdx + 4] = decimalFormat.format(entry.getMillis() / scale);
				values[startIdx + 5] = decimalFormat.format(entry.getStdDevMs());
				values[startIdx + 6] = decimalFormat.format(entry.getNRet());
				values[startIdx + 7] = decimalFormat.format(entry.getMinRet());
				values[startIdx + 8] = decimalFormat.format(entry.getMaxRet());
				values[startIdx + 9] = decimalFormat.format(entry.getAvgRet());
				values[startIdx + 10] = decimalFormat.format(entry.getStdDevRet());
				values[startIdx + 11] = decimalFormat.format(entry.getLen());
				values[startIdx + 12] = decimalFormat.format(entry.getMinLen());
				values[startIdx + 13] = decimalFormat.format(entry.getMaxLen());
				values[startIdx + 14] = decimalFormat.format(entry.getAvgLen());
				values[startIdx + 15] = decimalFormat.format(entry.getStdDevLen());
				values[startIdx + 16] = "" + entry.getKeys();
				values[startIdx + 17] = "" + entry.getDocs();
				values[startIdx + 18] = "" + ((entry.getDel() + entry.getIns()) + entry.getMod());
				values[startIdx + 19] = (entry.hasSortStage()) ? "1" : "0";
			}
			for (int i = 0; i < values.length; i++) {
				dataGrid.append(values[i] == null ? "0" : values[i]).append(",");
			}
			dataGrid.deleteCharAt(dataGrid.length() - 1);
			dataGrid.append("],\n");
		}
		dataGrid.deleteCharAt(dataGrid.length() - 1);
		dataGrid.append("];\n");
		final boolean[] visibilityValues = new boolean[groups.size() * (customFields.length + 1)];
		int c = 0;
		for (int i = 0; i < groups.size(); i++) {
			visibilityValues[c++] = true;
			for (int j = 0; j < customFields.length; j++) {
				visibilityValues[c++] = false;
			}
		}
		result.setLabels(labels);
		result.setDataGrid(dataGrid);
		result.setVisibilityValues(visibilityValues);
		result.setLabelSeries(labelSeries);
		return result;
	}

	public static void main(java.lang.String[] args) {
		java.lang.Boolean[] b = new java.lang.Boolean[]{ true, false };
		java.lang.System.out.println("" + java.util.Arrays.toString(b));
	}
}