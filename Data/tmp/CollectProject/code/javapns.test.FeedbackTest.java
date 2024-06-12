public class FeedbackTest extends javapns.test.TestFoundation {
	public static void main(java.lang.String[] args) {
		if (!javapns.test.TestFoundation.verifyCorrectUsage(javapns.test.FeedbackTest.class, args, "keystore-path", "keystore-password", "[production|sandbox]")) {
			return;
		}
		javapns.test.TestFoundation.configureBasicLogging();
		javapns.test.FeedbackTest.feedbackTest(args);
	}

	private FeedbackTest() {
	}

	private static void feedbackTest(java.lang.String[] args) {
		java.lang.String keystore = args[0];
		java.lang.String password = args[1];
		boolean production = (args.length >= 3) ? args[2].equalsIgnoreCase("production") : false;
		try {
			java.util.List<javapns.devices.Device> devices = javapns.Push.feedback(keystore, password, production);
			for (javapns.devices.Device device : devices) {
				java.lang.System.out.println("Inactive device: " + device.getToken());
			}
		} catch (javapns.communication.exceptions.CommunicationException e) {
			e.printStackTrace();
		} catch (javapns.communication.exceptions.KeystoreException e) {
			e.printStackTrace();
		}
	}
}