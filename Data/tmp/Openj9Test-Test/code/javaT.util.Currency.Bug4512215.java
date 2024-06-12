public class Bug4512215 {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		javaT.util.Currency.Bug4512215.testCurrencyDefined("XBD", -1);
		javaT.util.Currency.Bug4512215.testCountryCurrency("TJ", "TJS", 2);
		javaT.util.Currency.Bug4512215.testCountryCurrency("FO", "DKK", 2);
		javaT.util.Currency.Bug4512215.testCountryCurrency("FK", "FKP", 2);
		javaT.util.Currency.Bug4512215.testCountryCurrency("AF", "AFN", 2);
		javaT.util.Currency.Bug4512215.testCountryCurrency("TL", "USD", 2);
		javaT.util.Currency.Bug4512215.testCountryCurrency("CS", "CSD", 2);
	}

	private static void testCountryCurrency(java.lang.String country, java.lang.String currencyCode, int digits) {
		javaT.util.Currency.Bug4512215.testCurrencyDefined(currencyCode, digits);
		java.util.Currency currency = java.util.Currency.getInstance(new java.util.Locale("", country));
		if (!currency.getCurrencyCode().equals(currencyCode)) {
			throw new java.lang.RuntimeException((((("[" + country) + "] expected: ") + currencyCode) + "; got: ") + currency.getCurrencyCode());
		}
	}

	private static void testCurrencyDefined(java.lang.String currencyCode, int digits) {
		java.util.Currency currency = java.util.Currency.getInstance(currencyCode);
		if (currency.getDefaultFractionDigits() != digits) {
			throw new java.lang.RuntimeException((((("[" + currencyCode) + "] expected: ") + digits) + "; got: ") + currency.getDefaultFractionDigits());
		}
	}
}