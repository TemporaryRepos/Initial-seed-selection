public class TaxCalculator {
	public static double calculate(lambdasinaction.dsl.model.Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
		double value = order.getValue();
		if (useRegional) {
			value = lambdasinaction.dsl.model.Tax.regional(value);
		}
		if (useGeneral) {
			value = lambdasinaction.dsl.model.Tax.general(value);
		}
		if (useSurcharge) {
			value = lambdasinaction.dsl.model.Tax.surcharge(value);
		}
		return value;
	}

	private boolean useRegional;

	private boolean useGeneral;

	private boolean useSurcharge;

	public lambdasinaction.dsl.TaxCalculator withTaxRegional() {
		useRegional = true;
		return this;
	}

	public lambdasinaction.dsl.TaxCalculator withTaxGeneral() {
		useGeneral = true;
		return this;
	}

	public lambdasinaction.dsl.TaxCalculator withTaxSurcharge() {
		useSurcharge = true;
		return this;
	}

	public double calculate(lambdasinaction.dsl.model.Order order) {
		return lambdasinaction.dsl.TaxCalculator.calculate(order, useRegional, useGeneral, useSurcharge);
	}

	public java.util.function.Function<java.lang.Double, java.lang.Double> taxFuncion = java.util.function.Function.identity();

	public lambdasinaction.dsl.TaxCalculator with(java.util.function.Function<java.lang.Double, java.lang.Double> f) {
		taxFuncion.andThen(f);
		return this;
	}

	public double calculateF(lambdasinaction.dsl.model.Order order) {
		return taxFuncion.apply(order.getValue());
	}

	public static void main(java.lang.String[] args) {
		lambdasinaction.dsl.model.Order order = new lambdasinaction.dsl.model.Order();
		double value = lambdasinaction.dsl.TaxCalculator.calculate(order, true, false, true);
		value = new lambdasinaction.dsl.TaxCalculator().withTaxRegional().withTaxSurcharge().calculate(order);
		value = new lambdasinaction.dsl.TaxCalculator().with(lambdasinaction.dsl.model.Tax::regional).with(lambdasinaction.dsl.model.Tax::surcharge).calculate(order);
	}
}