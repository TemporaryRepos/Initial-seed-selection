public class PrintPreFlop {
	public static void main(java.lang.String[] args) {
		com.google.inject.Injector injector = com.google.inject.Guice.createInjector(new edu.ntnu.texasai.dependencyinjection.TexasModule(edu.ntnu.texasai.dependencyinjection.LogLevel.ALL, edu.ntnu.texasai.dependencyinjection.GamePropertiesParameter.DEMO));
		edu.ntnu.texasai.persistence.PreFlopPersistence preFlopPersistence = injector.getInstance(edu.ntnu.texasai.persistence.PreFlopPersistence.class);
		preFlopPersistence.print();
	}
}