public class SpecificNotificationTests extends javapns.test.TestFoundation {
	public static void main(java.lang.String[] args) {
		if (!javapns.test.TestFoundation.verifyCorrectUsage(javapns.test.NotificationTest.class, args, "keystore-path", "keystore-password", "device-token", "[production|sandbox]", "[test-name]")) {
			return;
		}
		javapns.test.TestFoundation.configureBasicLogging();
		javapns.test.SpecificNotificationTests.runTest(args);
	}

	private SpecificNotificationTests() {
	}

	private static void runTest(java.lang.String[] args) {
		java.lang.String keystore = args[0];
		java.lang.String password = args[1];
		java.lang.String token = args[2];
		boolean production = (args.length >= 4) ? args[3].equalsIgnoreCase("production") : false;
		boolean simulation = (args.length >= 4) ? args[3].equalsIgnoreCase("simulation") : false;
		java.lang.String testName = (args.length >= 5) ? args[4] : null;
		if ((testName == null) || (testName.length() == 0)) {
			testName = "default";
		}
		try {
			javapns.test.SpecificNotificationTests.class.getDeclaredMethod("test_" + testName, java.lang.String.class, java.lang.String.class, java.lang.String.class, boolean.class).invoke(null, keystore, password, token, production);
		} catch (java.lang.NoSuchMethodException e) {
			java.lang.System.out.println(java.lang.String.format("Error: test '%s' not found.  Test names are case-sensitive", testName));
		} catch (java.lang.Exception e) {
			(e.getCause() != null ? e.getCause() : e).printStackTrace();
		}
	}

	private static void test_PushHelloWorld(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) throws javapns.communication.exceptions.CommunicationException, javapns.communication.exceptions.KeystoreException {
		java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.alert("Hello World!", keystore, password, production, token);
		javapns.test.NotificationTest.printPushedNotifications(notifications);
	}

	private static void test_Issue74(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING 257-BYTES PAYLOAD WITH SIZE ESTIMATION ENABLED");
			javapns.test.SpecificNotificationTests.pushSpecificPayloadSize(keystore, password, token, production, true, 257);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING 257-BYTES PAYLOAD WITH SIZE ESTIMATION DISABLED");
			javapns.test.SpecificNotificationTests.pushSpecificPayloadSize(keystore, password, token, production, false, 257);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING 256-BYTES PAYLOAD");
			javapns.test.SpecificNotificationTests.pushSpecificPayloadSize(keystore, password, token, production, false, 256);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue75(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING 257-BYTES PAYLOAD WITH SIZE ESTIMATION ENABLED");
			javapns.notification.NewsstandNotificationPayload payload = javapns.notification.NewsstandNotificationPayload.contentAvailable();
			javapns.test.SpecificNotificationTests.debugPayload(payload);
			java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.payload(payload, keystore, password, production, token);
			javapns.test.NotificationTest.printPushedNotifications(notifications);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue82(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("");
			javapns.notification.Payload payload = javapns.notification.PushNotificationPayload.test();
			java.lang.System.out.println("TESTING ISSUE #82 PART 1");
			java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.payload(payload, keystore, password, production, 1, token);
			javapns.test.NotificationTest.printPushedNotifications(notifications);
			java.lang.System.out.println("ISSUE #82 PART 1 TESTED");
			java.lang.System.out.println("TESTING ISSUE #82 PART2");
			javapns.notification.AppleNotificationServer server = new javapns.notification.AppleNotificationServerBasicImpl(keystore, password, production);
			javapns.notification.transmission.NotificationThread thread = new javapns.notification.transmission.NotificationThread(new javapns.notification.PushNotificationManager(), server, payload, token);
			thread.setListener(javapns.test.NotificationTest.DEBUGGING_PROGRESS_LISTENER);
			thread.start();
			java.lang.System.out.println("ISSUE #82 PART 2 TESTED");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue87(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("TESTING ISSUES #87 AND #88");
			java.io.InputStream ks = new java.io.BufferedInputStream(new java.io.FileInputStream(keystore));
			javapns.notification.transmission.PushQueue queue = javapns.Push.queue(ks, password, false, 3);
			queue.start();
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			java.lang.Thread.sleep(10000);
			java.util.List<java.lang.Exception> criticalExceptions = queue.getCriticalExceptions();
			for (java.lang.Exception exception : criticalExceptions) {
				exception.printStackTrace();
			}
			java.lang.Thread.sleep(10000);
			java.util.List<javapns.notification.PushedNotification> pushedNotifications = queue.getPushedNotifications();
			javapns.test.NotificationTest.printPushedNotifications("BEFORE CLEAR:", pushedNotifications);
			queue.clearPushedNotifications();
			pushedNotifications = queue.getPushedNotifications();
			javapns.test.NotificationTest.printPushedNotifications("AFTER CLEAR:", pushedNotifications);
			java.lang.Thread.sleep(50000);
			java.lang.System.out.println("ISSUES #87 AND #88 TESTED");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue88(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("TESTING ISSUES #88");
			javapns.notification.transmission.PushQueue queue = javapns.Push.queue(keystore, password, false, 1);
			queue.start();
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			queue.add(javapns.notification.PushNotificationPayload.test(), token);
			java.lang.Thread.sleep(10000);
			javapns.notification.PushedNotifications notifications = queue.getPushedNotifications();
			javapns.test.NotificationTest.printPushedNotifications(notifications);
			java.lang.Thread.sleep(5000);
			java.lang.System.out.println("ISSUES #88 TESTED");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue99(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING ISSUE #99");
			javapns.notification.PushNotificationPayload payload = javapns.notification.PushNotificationPayload.complex();
			payload.addCustomAlertBody("Hello World!");
			payload.addCustomAlertActionLocKey(null);
			javapns.test.SpecificNotificationTests.debugPayload(payload);
			java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.payload(payload, keystore, password, production, token);
			javapns.test.NotificationTest.printPushedNotifications(notifications);
			java.lang.System.out.println("ISSUE #99 TESTED");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_Issue102(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) {
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING ISSUE #102");
			int devices = 10000;
			int threads = 20;
			boolean simulation = false;
			java.lang.String realToken = token;
			token = null;
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
				deviceList.add(new javapns.devices.implementations.basic.BasicDevice(realToken));
				java.lang.System.out.println(("Creating " + threads) + " notification threads");
				javapns.notification.transmission.NotificationThreads work = new javapns.notification.transmission.NotificationThreads(server, simulation ? payload.asSimulationOnly() : payload, deviceList, threads);
				java.lang.System.out.println("Starting all threads...");
				long timestamp1 = java.lang.System.currentTimeMillis();
				work.start();
				java.lang.System.out.println("All threads started, waiting for them...");
				work.waitForAllThreads();
				long timestamp2 = java.lang.System.currentTimeMillis();
				java.lang.System.out.println(("All threads finished in " + (timestamp2 - timestamp1)) + " milliseconds");
				javapns.test.NotificationTest.printPushedNotifications(work.getSuccessfulNotifications());
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
			java.lang.System.out.println("ISSUE #102 TESTED");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void test_ThreadPoolFeature(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production) throws java.lang.Exception {
		try {
			java.lang.System.out.println("");
			java.lang.System.out.println("TESTING THREAD POOL FEATURE");
			javapns.notification.AppleNotificationServer server = new javapns.notification.AppleNotificationServerBasicImpl(keystore, password, production);
			javapns.notification.transmission.NotificationThreads pool = new javapns.notification.transmission.NotificationThreads(server, 3).start();
			javapns.devices.Device device = new javapns.devices.implementations.basic.BasicDevice(token);
			java.lang.System.out.println("Thread pool started and waiting...");
			java.lang.System.out.println("Sleeping 5 seconds before queuing payloads...");
			java.lang.Thread.sleep(5 * 1000);
			for (int i = 1; i <= 4; i++) {
				javapns.notification.Payload payload = javapns.notification.PushNotificationPayload.alert("Test " + i);
				javapns.notification.transmission.NotificationThread threadForPayload = ((javapns.notification.transmission.NotificationThread) (pool.add(new javapns.notification.PayloadPerDevice(payload, device))));
				java.lang.System.out.println((("Queued payload " + i) + " to ") + threadForPayload.getThreadNumber());
				java.lang.System.out.println("Sleeping 10 seconds before queuing another payload...");
				java.lang.Thread.sleep(10 * 1000);
			}
			java.lang.System.out.println("Sleeping 10 more seconds let threads enough times to push the latest payload...");
			java.lang.Thread.sleep(10 * 1000);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	private static void pushSpecificPayloadSize(java.lang.String keystore, java.lang.String password, java.lang.String token, boolean production, boolean checkWhenAdding, int targetPayloadSize) throws javapns.communication.exceptions.CommunicationException, javapns.communication.exceptions.KeystoreException, org.json.JSONException {
		java.lang.StringBuilder buf = new java.lang.StringBuilder();
		for (int i = 0; i < (targetPayloadSize - 20); i++) {
			buf.append('x');
		}
		java.lang.String alertMessage = buf.toString();
		javapns.notification.PushNotificationPayload payload = javapns.notification.PushNotificationPayload.complex();
		if (checkWhenAdding) {
			payload.setPayloadSizeEstimatedWhenAdding(true);
		}
		javapns.test.SpecificNotificationTests.debugPayload(payload);
		boolean estimateValid = payload.isEstimatedPayloadSizeAllowedAfterAdding("alert", alertMessage);
		java.lang.System.out.println("Payload size estimated to be allowed: " + (estimateValid ? "yes" : "no"));
		payload.addAlert(alertMessage);
		javapns.test.SpecificNotificationTests.debugPayload(payload);
		java.util.List<javapns.notification.PushedNotification> notifications = javapns.Push.payload(payload, keystore, password, production, token);
		javapns.test.NotificationTest.printPushedNotifications(notifications);
	}

	private static void debugPayload(javapns.notification.Payload payload) {
		java.lang.System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		try {
			java.lang.System.out.println("Payload size: " + payload.getPayloadSize());
		} catch (java.lang.Exception e) {
		}
		try {
			java.lang.System.out.println("Payload representation: " + payload);
		} catch (java.lang.Exception e) {
		}
		java.lang.System.out.println(payload.isPayloadSizeEstimatedWhenAdding() ? "Payload size is estimated when adding properties" : "Payload size is only checked when it is complete");
		java.lang.System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	}
}