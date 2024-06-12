public final strictfp class Bug6355009 {
	private final java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(javaT.util.ResourceBundle.Bug6355009.class.getName());

	public static final strictfp void main(java.lang.String[] args) {
		try {
			new javaT.util.ResourceBundle.Bug6355009();
		} catch (java.util.MissingResourceException e) {
			java.lang.Throwable cause = e;
			int count = 0;
			while ((cause = cause.getCause()) != null) {
				if (cause instanceof java.util.MissingResourceException) {
					count++;
				}
			} 
			if (count > 0) {
				throw new java.lang.RuntimeException("too many causes: " + count);
			}
		}
	}
}