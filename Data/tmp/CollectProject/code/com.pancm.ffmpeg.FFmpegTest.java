public class FFmpegTest {
	public static void main(java.lang.String[] args) {
		java.lang.String ffmpegExePath = "C:\\ffmpeg\\bin\\ffmpeg.exe";
		java.lang.String inputFilePath = "D:\\video\\ts\\25-16_940.ts";
		java.lang.String outputFilePath = "D:\\video\\ts\\t2.jpg";
		java.util.List<java.lang.String> command = new java.util.ArrayList<java.lang.String>();
		command.add(ffmpegExePath);
		command.add("-i");
		command.add(inputFilePath);
		command.add("-f");
		command.add("image2");
		command.add("-ss");
		command.add("1");
		command.add("-t");
		command.add("0.001");
		command.add("-s");
		command.add("320*240");
		command.add(outputFilePath);
		java.lang.ProcessBuilder builder = new java.lang.ProcessBuilder();
		builder.command(command);
		builder.redirectErrorStream(true);
		try {
			java.lang.Process process = builder.start();
			java.lang.StringBuffer sbf = new java.lang.StringBuffer();
			java.lang.String line = null;
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
			while ((line = br.readLine()) != null) {
				sbf.append(line);
				sbf.append(" ");
			} 
			java.lang.String resultInfo = sbf.toString();
			java.lang.System.out.println(resultInfo);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}