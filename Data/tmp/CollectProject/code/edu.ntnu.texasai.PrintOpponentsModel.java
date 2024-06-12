public class PrintOpponentsModel {
	public static void main(java.lang.String[] args) {
		com.google.inject.Injector injector = com.google.inject.Guice.createInjector(new edu.ntnu.texasai.dependencyinjection.TexasModule(edu.ntnu.texasai.dependencyinjection.LogLevel.ALL, edu.ntnu.texasai.dependencyinjection.GamePropertiesParameter.DEMO));
		edu.ntnu.texasai.persistence.OpponentsModelPersistence opponentsModelPersistence = injector.getInstance(edu.ntnu.texasai.persistence.OpponentsModelPersistence.class);
		opponentsModelPersistence.print();
	}
}