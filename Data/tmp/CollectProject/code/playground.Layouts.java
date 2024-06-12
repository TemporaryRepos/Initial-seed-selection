public enum Layouts {
	;

	public static class MyStringParser extends act.app.BuildFileProbe.StringParser {
		@java.lang.Override
		protected act.app.ProjectLayout parse(java.lang.String fileContent) {
			return null;
		}

		@java.lang.Override
		public java.lang.String buildFileName() {
			return "mystring.layout";
		}
	}

	public static class MyLinesParser extends act.app.BuildFileProbe.LinesParser {
		@java.lang.Override
		protected act.app.ProjectLayout parse(java.util.List<java.lang.String> lines) {
			return null;
		}

		@java.lang.Override
		public java.lang.String buildFileName() {
			return "mylines.layout";
		}
	}

	public static void main(java.lang.String[] args) {
		playground.AbstractClassTest.foo();
	}
}