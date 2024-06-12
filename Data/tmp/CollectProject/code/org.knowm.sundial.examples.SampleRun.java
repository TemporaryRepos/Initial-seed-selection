public class SampleRun {
	public static void main(java.lang.String[] args) {
		org.knowm.sundial.SundialJobScheduler.startScheduler("org.knowm.sundial.jobs");
		org.knowm.sundial.SundialJobScheduler.addJob("SampleJob1", "org.knowm.sundial.jobs.SampleJob1");
		org.knowm.sundial.SundialJobScheduler.addCronTrigger("SampleJob1-Cron-Trigger", "SampleJob1", "0/10 * * * * ?");
		org.knowm.sundial.SundialJobScheduler.addSimpleTrigger("SampleJob1-Simple-Trigger", "SampleJob1", -1, java.util.concurrent.TimeUnit.SECONDS.toMillis(3));
		org.knowm.sundial.SundialJobScheduler.shutdown();
	}
}