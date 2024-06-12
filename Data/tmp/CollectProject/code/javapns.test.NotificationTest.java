public class NotificationTest extends javapns.test.TestFoundation {
	public static void main(java.lang.String[] args) {
		if (!javapns.test.TestFoundation.verifyCorrectUsage(javapns.test.NotificationTest.class, args, "keystore-path", "keystore-password", "device-token", "[production|sandbox]", "[complex|simple|threads]", "[#devices]", "[#threads]")) {
			return;
		}
		javapns.test.TestFoundation.configureBasicLogging();
		try {
			javapns.test.NotificationTest.pushTest(args);
		} catch (javapns.communication.exceptions.CommunicationException e) {
			e.printStackTrace();
		} catch (javapns.communication.exceptions.KeystoreException e) {
			e.printStackTrace();
		}
	}

	private NotificationTest() {
	}

	private static void pushTest(java.lang.String[] args) throws javapns.communication.exceptions.CommunicationException, javapns.communication.exceptions.KeystoreException {
		java.lang.String keystore = args[0];
		java.lang.String password = args[1];
		java.lang.String token = args[2];
		boolean production = (args.length >= 4) ? args[3].equalsIgnoreCase("production") : false;
		boolean simulation = (args.length >= 4) ? args[3].equalsIgnoreCase("simulation") : false;
		boolean complex = (args.length >= 5) ? args[4].equalsIgnoreCase("complex") : false;
		boolean threads = (args.length >= 5) ? args[4].equalsIgnoreCase("threads") : false;
		int threadDevices = (args.length >= 6) ? java.lang.Integer.parseInt(args[5]) : 100;
		int threadThreads = (args.length >= 7) ? java.lang.Integer.parseInt(args[6]) : 10;
		boolean simple = (!complex) && (!threads);
		javapns.test.TestFoundation.verifyKeystore(keystore, password, production);
		if (simple) {
			java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.test(keystore, password, production, token);
			javapns.test.NotificationTest.printPushedNotifications(notifications);
		} else if (complex) {
			java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.payload(javapns.test.NotificationTest.createComplexPayload(), keystore, password, production, token);
			javapns.test.NotificationTest.printPushedNotifications(notifications);
		} else if (threads) {
			javapns.test.NotificationTest.pushSimplePayloadUsingThreads(keystore, password, production, token, simulation, threadDevices, threadThreads);
		}
	}

	@java.lang.SuppressWarnings("unchecked")
	private static javapns.notification.Payload createComplexPayload() {
		javapns.notification.PushNotificationPayload complexPayload = javapns.notification.PushNotificationPayload.complex();
		try {
			complexPayload.addCustomAlertBody("My alert message");
			complexPayload.addCustomAlertActionLocKey("Open App");
			complexPayload.addCustomAlertLocKey("javapns rocks %@ %@%@");
			java.util.ArrayList parameters = new java.util.ArrayList();
			parameters.add("Test1");
			parameters.add("Test");
			parameters.add(2);
			complexPayload.addCustomAlertLocArgs(parameters);
			complexPayload.addBadge(45);
			complexPayload.addSound("default");
			complexPayload.addCustomDictionary("acme", "foo");
			complexPayload.addCustomDictionary("acme2", 42);
			java.util.ArrayList values = new java.util.ArrayList();
			values.add("value1");
			values.add(2);
			complexPayload.addCustomDictionary("acme3", values);
		} catch (org.json.JSONException e) {
			java.lang.System.out.println("Error creating complex payload:");
			e.printStackTrace();
		}
		return complexPayload;
	}

	protected static void pushSimplePayloadUsingThreads(java.lang.String keystore, java.lang.String password, boolean production, java.lang.String token, boolean simulation, int devices, int threads) {
		try {
			java.lang.System.out.println("Creating PushNotificationManager and AppleNotificationServer");
			javapns.notification.AppleNotificationServer server = new javapns.notification.AppleNotificationServerBasicImpl(keystore, password, production);
			java.lang.System.out.println("Creating payload (simulation mode)");
			javapns.notification.Payload payload = javapns.notification.PushNotificationPayload.test();
			java.lang.System.out.println(("Generating " + devices) + " fake devices");
			java.util.List<javapns.devices.Device> deviceList = new java.util.ArrayList<javapns.devices.Device>(devices);
			for (int i = 0; i < devices; i++) {
				java.lang.String tokenToUse = token;
				if ((tokenToUse == null) || (tokenToUse.length() != 64)) {
					tokenToUse = "123456789012345678901234567890123456789012345678901234567" + (1000000 + i);
				}
				deviceList.add(new javapns.devices.implementations.basic.BasicDevice(tokenToUse));
			}
			java.lang.System.out.println(("Creating " + threads) + " notification threads");
			javapns.notification.transmission.NotificationThreads work = new javapns.notification.transmission.NotificationThreads(server, simulation ? payload.asSimulationOnly() : payload, deviceList, threads);
			java.lang.System.out.println("Linking notification work debugging listener");
			work.setListener(javapns.test.NotificationTest.DEBUGGING_PROGRESS_LISTENER);
			java.lang.System.out.println("Starting all threads...");
			long timestamp1 = java.lang.System.currentTimeMillis();
			work.start();
			java.lang.System.out.println("All threads started, waiting for them...");
			work.waitForAllThreads();
			long timestamp2 = java.lang.System.currentTimeMillis();
			java.lang.System.out.println(("All threads finished in " + (timestamp2 - timestamp1)) + " milliseconds");
			javapns.test.NotificationTest.printPushedNotifications(work.getPushedNotifications());
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	public static final javapns.notification.transmission.NotificationProgressListener DEBUGGING_PROGRESS_LISTENER = new javapns.notification.transmission.NotificationProgressListener() {
		public void eventThreadStarted(javapns.notification.transmission.NotificationThread notificationThread) {
			java.lang.System.out.println((((("   [EVENT]: thread #" + notificationThread.getThreadNumber()) + " started with ") + notificationThread.getDevices().size()) + " devices beginning at message id #") + notificationThread.getFirstMessageIdentifier());
		}

		public void eventThreadFinished(javapns.notification.transmission.NotificationThread thread) {
			java.lang.System.out.println(((((((("   [EVENT]: thread #" + thread.getThreadNumber()) + " finished: pushed messages #") + thread.getFirstMessageIdentifier()) + " to ") + thread.getLastMessageIdentifier()) + " toward ") + thread.getDevices().size()) + " devices");
		}

		public void eventConnectionRestarted(javapns.notification.transmission.NotificationThread thread) {
			java.lang.System.out.println(((("   [EVENT]: connection restarted in thread #" + thread.getThreadNumber()) + " because it reached ") + thread.getMaxNotificationsPerConnection()) + " notifications per connection");
		}

		public void eventAllThreadsStarted(javapns.notification.transmission.NotificationThreads notificationThreads) {
			java.lang.System.out.println("   [EVENT]: all threads started: " + notificationThreads.getThreads().size());
		}

		public void eventAllThreadsFinished(javapns.notification.transmission.NotificationThreads notificationThreads) {
			java.lang.System.out.println("   [EVENT]: all threads finished: " + notificationThreads.getThreads().size());
		}

		public void eventCriticalException(javapns.notification.transmission.NotificationThread notificationThread, java.lang.Exception exception) {
			java.lang.System.out.println("   [EVENT]: critical exception occurred: " + exception);
		}
	};

	public static void printPushedNotifications(java.util.List<javapns.notification.PushedNotification> notifications) {
		java.util.List<javapns.notification.PushedNotification> failedNotifications = javapns.notification.PushedNotification.findFailedNotifications(notifications);
		java.util.List<javapns.notification.PushedNotification> successfulNotifications = javapns.notification.PushedNotification.findSuccessfulNotifications(notifications);
		int failed = failedNotifications.size();
		int successful = successfulNotifications.size();
		if ((successful > 0) && (failed == 0)) {
			javapns.test.NotificationTest.printPushedNotifications(("All notifications pushed successfully (" + successfulNotifications.size()) + "):", successfulNotifications);
		} else if ((successful == 0) && (failed > 0)) {
			javapns.test.NotificationTest.printPushedNotifications(("All notifications failed (" + failedNotifications.size()) + "):", failedNotifications);
		} else if ((successful == 0) && (failed == 0)) {
			java.lang.System.out.println("No notifications could be sent, probably because of a critical error");
		} else {
			javapns.test.NotificationTest.printPushedNotifications(("Some notifications failed (" + failedNotifications.size()) + "):", failedNotifications);
			javapns.test.NotificationTest.printPushedNotifications(("Others succeeded (" + successfulNotifications.size()) + "):", successfulNotifications);
		}
	}

	public static void printPushedNotifications(java.lang.String description, java.util.List<javapns.notification.PushedNotification> notifications) {
		java.lang.System.out.println(description);
		for (javapns.notification.PushedNotification notification : notifications) {
			try {
				java.lang.System.out.println("  " + notification.toString());
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}
}