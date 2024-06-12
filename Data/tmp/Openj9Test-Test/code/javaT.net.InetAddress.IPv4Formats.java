public class IPv4Formats {
	public static void main(java.lang.String[] args) {
		java.net.InetAddress ad1;
		java.net.InetAddress ad2;
		java.lang.String[][] adds = new java.lang.String[][]{ new java.lang.String[]{ "0", "0.0.0.0" }, new java.lang.String[]{ "126.1", "126.0.0.1" }, new java.lang.String[]{ "128.50.65534", "128.50.255.254" }, new java.lang.String[]{ "192.168.1.2", "192.168.1.2" }, new java.lang.String[]{ "invalidhost.invalid", null }, new java.lang.String[]{ "1024.1.2.3", null }, new java.lang.String[]{ "128.14.66000", null } };
		for (int i = 0; i < adds.length; i++) {
			if (adds[i][1] != null) {
				try {
					ad1 = java.net.InetAddress.getByName(adds[i][0]);
					ad2 = java.net.InetAddress.getByName(adds[i][1]);
				} catch (java.net.UnknownHostException ue) {
					throw new java.lang.RuntimeException((((("Wrong conversion: " + adds[i][0]) + " should be ") + adds[i][1]) + " But throws ") + ue);
				}
				if (!ad1.equals(ad2)) {
					throw new java.lang.RuntimeException((((("Wrong conversion: " + adds[i][0]) + " should be ") + adds[i][1]) + " But is ") + ad1);
				}
			} else {
				try {
					ad1 = java.net.InetAddress.getByName(adds[i][0]);
					throw new java.lang.RuntimeException(adds[i][0] + " should throw UnknownHostException!");
				} catch (java.net.UnknownHostException e) {
				}
			}
		}
	}
}