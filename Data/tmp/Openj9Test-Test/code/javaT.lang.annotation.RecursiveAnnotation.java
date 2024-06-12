@javaT.lang.annotation.Rat
public class RecursiveAnnotation {
	public static void main(java.lang.String[] args) {
		if (!javaT.lang.annotation.RecursiveAnnotation.class.isAnnotationPresent(javaT.lang.annotation.Rat.class)) {
			throw new java.lang.RuntimeException("RecursiveAnnotation");
		}
		if (!javaT.lang.annotation.Rat.class.isAnnotationPresent(javaT.lang.annotation.Rat.class)) {
			throw new java.lang.RuntimeException("Rat");
		}
	}
}