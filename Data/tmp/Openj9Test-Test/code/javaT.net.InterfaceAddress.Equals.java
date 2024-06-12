public class Equals {
	public static void main(java.lang.String[] args) {
		java.net.InterfaceAddress ia1;
		java.net.InterfaceAddress ia2;
		java.net.InetAddress loopbackAddr = java.net.InetAddress.getLoopbackAddress();
		java.net.InetAddress broadcast1 = null;
		java.net.InetAddress broadcast2 = null;
		try {
			broadcast1 = java.net.InetAddress.getByName("255.255.255.0");
			broadcast2 = java.net.InetAddress.getByName("255.255.0.0");
		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}
		ia1 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(loopbackAddr, ((java.net.InetAddress) (null)), ((short) (45)));
		ia2 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(loopbackAddr, ((java.net.InetAddress) (null)), ((short) (45)));
		javaT.net.InterfaceAddress.Equals.compare(ia1, ia2, true);
		ia2 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(loopbackAddr, broadcast1, ((short) (45)));
		javaT.net.InterfaceAddress.Equals.compare(ia1, ia2, false);
		ia2 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(((java.net.InetAddress) (null)), broadcast1, ((short) (45)));
		javaT.net.InterfaceAddress.Equals.compare(ia1, ia2, false);
		ia1 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(loopbackAddr, broadcast2, ((short) (45)));
		ia2 = javaT.net.InterfaceAddress.Equals.createInterfaceAddress(loopbackAddr, broadcast2, ((short) (45)));
		javaT.net.InterfaceAddress.Equals.compare(ia1, ia2, true);
		ia1.equals(null);
	}

	static void compare(java.net.InterfaceAddress ia1, java.net.InterfaceAddress ia2, boolean equal) {
		if (ia1.equals(ia2) != equal) {
			throw new java.lang.RuntimeException((("Failed: " + ia1) + " not equals to ") + ia2);
		}
		if (ia2.equals(ia1) != equal) {
			throw new java.lang.RuntimeException((("Failed: " + ia2) + " not equals to ") + ia1);
		}
	}

	static java.net.InterfaceAddress createInterfaceAddress(java.net.InetAddress address, java.net.InetAddress broadcast, short prefixlength) {
		try {
			java.lang.Class<java.net.InterfaceAddress> IAClass = java.net.InterfaceAddress.class;
			java.net.InterfaceAddress ia;
			java.lang.reflect.Constructor<java.net.InterfaceAddress> ctr = IAClass.getDeclaredConstructor();
			ctr.setAccessible(true);
			java.lang.reflect.Field addressField = IAClass.getDeclaredField("address");
			addressField.setAccessible(true);
			java.lang.reflect.Field broadcastField = IAClass.getDeclaredField("broadcast");
			broadcastField.setAccessible(true);
			java.lang.reflect.Field maskLengthField = IAClass.getDeclaredField("maskLength");
			maskLengthField.setAccessible(true);
			ia = ctr.newInstance();
			addressField.set(ia, address);
			broadcastField.set(ia, broadcast);
			maskLengthField.setShort(ia, prefixlength);
			return ia;
		} catch (java.lang.NoSuchFieldException nsfe) {
			nsfe.printStackTrace();
		} catch (java.lang.NoSuchMethodException e) {
			e.printStackTrace();
		} catch (java.lang.InstantiationException ie) {
			ie.printStackTrace();
		} catch (java.lang.IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (java.lang.reflect.InvocationTargetException ite) {
			ite.printStackTrace();
		}
		return null;
	}
}