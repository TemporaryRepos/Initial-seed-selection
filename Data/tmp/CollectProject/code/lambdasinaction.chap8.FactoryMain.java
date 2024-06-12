public class FactoryMain {
	public static void main(java.lang.String[] args) {
		lambdasinaction.chap8.FactoryMain.Product p1 = lambdasinaction.chap8.FactoryMain.ProductFactory.createProduct("loan");
		java.util.function.Supplier<lambdasinaction.chap8.FactoryMain.Product> loanSupplier = lambdasinaction.chap8.FactoryMain.Loan::new;
		lambdasinaction.chap8.FactoryMain.Product p2 = loanSupplier.get();
		lambdasinaction.chap8.FactoryMain.Product p3 = lambdasinaction.chap8.FactoryMain.ProductFactory.createProductLambda("loan");
	}

	private static class ProductFactory {
		public static lambdasinaction.chap8.FactoryMain.Product createProduct(java.lang.String name) {
			switch (name) {
				case "loan" :
					return new lambdasinaction.chap8.FactoryMain.Loan();
				case "stock" :
					return new lambdasinaction.chap8.FactoryMain.Stock();
				case "bond" :
					return new lambdasinaction.chap8.FactoryMain.Bond();
				default :
					throw new java.lang.RuntimeException("No such product " + name);
			}
		}

		public static lambdasinaction.chap8.FactoryMain.Product createProductLambda(java.lang.String name) {
			java.util.function.Supplier<lambdasinaction.chap8.FactoryMain.Product> p = lambdasinaction.chap8.FactoryMain.map.get(name);
			if (p != null) {
				return p.get();
			}
			throw new java.lang.RuntimeException("No such product " + name);
		}
	}

	private static interface Product {}

	private static class Loan implements lambdasinaction.chap8.FactoryMain.Product {}

	private static class Stock implements lambdasinaction.chap8.FactoryMain.Product {}

	private static class Bond implements lambdasinaction.chap8.FactoryMain.Product {}

	private static final java.util.Map<java.lang.String, java.util.function.Supplier<lambdasinaction.chap8.FactoryMain.Product>> map = new java.util.HashMap<>();

	static {
		map.put("loan", lambdasinaction.chap8.FactoryMain.Loan::new);
		map.put("stock", lambdasinaction.chap8.FactoryMain.Stock::new);
		map.put("bond", lambdasinaction.chap8.FactoryMain.Bond::new);
	}
}