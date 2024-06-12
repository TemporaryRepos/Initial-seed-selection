public class ProviderInfoCheck {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.security.Provider p = new javaT.securityT.Provider.ProviderInfoCheck.SampleProvider();
		java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
		oos.writeObject(p);
		oos.close();
		java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(baos.toByteArray());
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
		java.security.Provider p2 = ((java.security.Provider) (ois.readObject()));
		ois.close();
		javaT.securityT.Provider.ProviderInfoCheck.checkProviderInfoEntries(p2);
	}

	private static void checkProviderInfoEntries(java.security.Provider p) throws java.lang.Exception {
		java.lang.String value = ((java.lang.String) (p.get("Provider.id name")));
		if ((!javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.NAME.equalsIgnoreCase(value)) || (!p.getName().equalsIgnoreCase(value))) {
			throw new java.lang.Exception("Test Failed: incorrect name!");
		}
		value = ((java.lang.String) (p.get("Provider.id info")));
		if ((!javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.INFO.equalsIgnoreCase(value)) || (!p.getInfo().equalsIgnoreCase(value))) {
			throw new java.lang.Exception("Test Failed: incorrect info!");
		}
		value = ((java.lang.String) (p.get("Provider.id className")));
		if (!p.getClass().getName().equalsIgnoreCase(value)) {
			throw new java.lang.Exception("Test Failed: incorrect className!");
		}
		double dvalue = java.lang.Double.parseDouble(((java.lang.String) (p.get("Provider.id version"))));
		if ((javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.VERSION != dvalue) || (p.getVersion() != dvalue)) {
			throw new java.lang.Exception("Test Failed: incorrect version!");
		}
		java.lang.System.out.println("Test Passed");
	}

	private static class SampleProvider extends java.security.Provider {
		static java.lang.String NAME = "Sample";

		static double VERSION = 1.1;

		static java.lang.String INFO = "Good for nothing";

		SampleProvider() {
			super(javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.NAME, javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.VERSION, javaT.securityT.Provider.ProviderInfoCheck.SampleProvider.INFO);
		}
	}
}