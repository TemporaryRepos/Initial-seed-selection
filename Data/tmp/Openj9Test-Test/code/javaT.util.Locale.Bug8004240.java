public class Bug8004240 {
	public static void main(java.lang.String[] args) {
		java.util.List<sun.util.locale.provider.LocaleProviderAdapter.Type> types = sun.util.locale.provider.LocaleProviderAdapter.getAdapterPreference();
		try {
			types.set(0, null);
		} catch (java.lang.UnsupportedOperationException e) {
			return;
		}
		throw new java.lang.RuntimeException("LocaleProviderAdapter.getAdapterPrefence() returned a modifiable list.");
	}
}