public class ChainClient {
	public static void main(java.lang.String[] args) {
		javatips.designpattern.cor.NoiseReductionHandler noiseReductionHandler = new javatips.designpattern.cor.NoiseReductionHandler();
		javatips.designpattern.cor.SubtitleHandler subtitleHandler = new javatips.designpattern.cor.SubtitleHandler();
		javatips.designpattern.cor.ExportHandler exportHandler = new javatips.designpattern.cor.ExportHandler();
		noiseReductionHandler.setNext(subtitleHandler);
		subtitleHandler.setNext(exportHandler);
		javatips.designpattern.cor.Video video = new javatips.designpattern.cor.Video("ok", null, false);
		noiseReductionHandler.handle(video);
	}
}