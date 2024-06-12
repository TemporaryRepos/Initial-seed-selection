public class Space {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		if (java.io.File.separatorChar == '\\') {
			try {
				java.lang.Process p = java.lang.Runtime.getRuntime().exec("cmd /c echo hello");
				java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
				p.waitFor();
				java.lang.String echo = reader.readLine();
				if (echo.length() == 6) {
					throw new java.lang.RuntimeException("Extra space in command.");
				}
			} catch (java.io.IOException e) {
				return;
			}
		}
	}
}