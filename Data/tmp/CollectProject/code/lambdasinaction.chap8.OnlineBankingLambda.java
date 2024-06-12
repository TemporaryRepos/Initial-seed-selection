public class OnlineBankingLambda {
	public static void main(java.lang.String[] args) {
		new lambdasinaction.chap8.OnlineBankingLambda().processCustomer(1337, (lambdasinaction.chap8.OnlineBankingLambda.Customer c) -> java.lang.System.out.println("Hello!"));
	}

	public void processCustomer(int id, java.util.function.Consumer<lambdasinaction.chap8.OnlineBankingLambda.Customer> makeCustomerHappy) {
		lambdasinaction.chap8.OnlineBankingLambda.Customer c = lambdasinaction.chap8.OnlineBankingLambda.Database.getCustomerWithId(id);
		makeCustomerHappy.accept(c);
	}

	private static class Customer {}

	private static class Database {
		static lambdasinaction.chap8.OnlineBankingLambda.Customer getCustomerWithId(int id) {
			return new lambdasinaction.chap8.OnlineBankingLambda.Customer();
		}
	}
}