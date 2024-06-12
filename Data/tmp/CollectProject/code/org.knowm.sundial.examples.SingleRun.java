public class SingleRun {
	public static void main(java.lang.String[] args) {
		org.knowm.sundial.SundialJobScheduler.startScheduler();
		org.knowm.sundial.SundialJobScheduler.addJob("SampleJob9", "org.knowm.sundial.jobs.SampleJob9");
		org.knowm.sundial.SundialJobScheduler.startJob("SampleJob9");
		org.knowm.sundial.SundialJobScheduler.shutdown();
	}
}