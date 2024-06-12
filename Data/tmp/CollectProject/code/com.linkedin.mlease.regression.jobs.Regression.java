public class Regression extends com.linkedin.mapred.AbstractAvroJob {
	private static final org.apache.log4j.Logger _log = org.apache.log4j.Logger.getLogger(com.linkedin.mlease.regression.jobs.Regression.class);

	public static final java.lang.String OUTPUT_BASE_PATH = "output.base.path";

	public static final java.lang.String TEST_PATH = "test.path";

	public Regression(java.lang.String jobId, com.linkedin.mapred.JobConfig config) {
		super(jobId, config);
	}

	@java.lang.Override
	public void run() throws java.lang.Exception {
		com.linkedin.mapred.JobConfig config = super.getJobConfig();
		org.apache.hadoop.fs.Path outBasePath = new org.apache.hadoop.fs.Path(config.get(com.linkedin.mlease.regression.jobs.Regression.OUTPUT_BASE_PATH));
		org.apache.hadoop.mapred.JobConf conf = super.createJobConf();
		if (config.getBoolean("force.output.overwrite", false)) {
			org.apache.hadoop.fs.FileSystem fs = outBasePath.getFileSystem(conf);
			fs.delete(outBasePath, true);
		}
		java.lang.String prepareOutputPath = outBasePath + "/tmp-data";
		com.linkedin.mapred.JobConfig configPrepare = com.linkedin.mapred.JobConfig.clone(config);
		configPrepare.put(com.linkedin.mapred.AbstractAvroJob.OUTPUT_PATH, prepareOutputPath);
		com.linkedin.mlease.regression.jobs.RegressionPrepare regressionPrepareJob = new com.linkedin.mlease.regression.jobs.RegressionPrepare("Regression-Prepare", configPrepare);
		regressionPrepareJob.run();
		com.linkedin.mapred.JobConfig configTrain = com.linkedin.mapred.JobConfig.clone(config);
		configTrain.put(com.linkedin.mapred.AbstractAvroJob.INPUT_PATHS, prepareOutputPath);
		com.linkedin.mlease.regression.jobs.RegressionAdmmTrain regressionAdmmTrainJob = new com.linkedin.mlease.regression.jobs.RegressionAdmmTrain("Regression-Admm-Train", configTrain);
		regressionAdmmTrainJob.run();
		if (config.containsKey(com.linkedin.mlease.regression.jobs.Regression.TEST_PATH)) {
			com.linkedin.mapred.JobConfig configTest = com.linkedin.mapred.JobConfig.clone(config);
			configTest.put(com.linkedin.mapred.AbstractAvroJob.INPUT_PATHS, config.get(com.linkedin.mlease.regression.jobs.Regression.TEST_PATH));
			configTest.put(com.linkedin.mlease.regression.jobs.RegressionTest.MODEL_BASE_PATH, outBasePath.toString());
			java.lang.String outTestBasePath = outBasePath.toString() + "/test";
			configTest.put(com.linkedin.mlease.regression.jobs.RegressionTest.OUTPUT_BASE_PATH, outTestBasePath);
			com.linkedin.mlease.regression.jobs.RegressionTest regressionTestJob = new com.linkedin.mlease.regression.jobs.RegressionTest("Regression-Test", configTest);
			regressionTestJob.run();
			com.linkedin.mapred.JobConfig configTestLoglik = com.linkedin.mapred.JobConfig.clone(config);
			configTestLoglik.put(com.linkedin.mlease.regression.jobs.RegressionTestLoglik.INPUT_BASE_PATHS, outTestBasePath);
			configTestLoglik.put(com.linkedin.mlease.regression.jobs.RegressionTestLoglik.OUTPUT_BASE_PATH, outTestBasePath);
			com.linkedin.mlease.regression.jobs.RegressionTestLoglik regressionTestLoglikJob = new com.linkedin.mlease.regression.jobs.RegressionTestLoglik("Regression-Test-Loglik", configTestLoglik);
			regressionTestLoglikJob.run();
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (args.length < 1) {
			com.linkedin.mlease.regression.jobs.Regression._log.error("[Usage]: Regression <Job config path>");
			return;
		}
		com.linkedin.mapred.JobConfig config = new com.linkedin.mapred.JobConfig(args[0]);
		com.linkedin.mlease.regression.jobs.Regression regression = new com.linkedin.mlease.regression.jobs.Regression("Regression-ADMM", config);
		regression.run();
	}
}