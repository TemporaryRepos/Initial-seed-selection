public class QrCodeCreateUtil {
	public static boolean createQrCode(java.io.OutputStream outputStream, java.lang.String content, int qrCodeSize, java.lang.String imageFormat) throws com.google.zxing.WriterException, java.io.IOException {
		java.util.Hashtable<com.google.zxing.EncodeHintType, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel> hintMap = new java.util.Hashtable<com.google.zxing.EncodeHintType, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel>();
		hintMap.put(com.google.zxing.EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L);
		com.google.zxing.qrcode.QRCodeWriter qrCodeWriter = new com.google.zxing.qrcode.QRCodeWriter();
		com.google.zxing.common.BitMatrix byteMatrix = qrCodeWriter.encode(content, com.google.zxing.BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);
		int matrixWidth = byteMatrix.getWidth();
		java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(matrixWidth - 200, matrixWidth - 200, java.awt.image.BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		java.awt.Graphics2D graphics = ((java.awt.Graphics2D) (image.getGraphics()));
		graphics.setColor(java.awt.Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		graphics.setColor(java.awt.Color.BLACK);
		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i - 100, j - 100, 1, 1);
				}
			}
		}
		return javax.imageio.ImageIO.write(image, imageFormat, outputStream);
	}

	public static void readQrCode(java.io.InputStream inputStream) throws java.io.IOException {
		java.awt.image.BufferedImage image = javax.imageio.ImageIO.read(inputStream);
		com.google.zxing.LuminanceSource source = new com.google.zxing.client.j2se.BufferedImageLuminanceSource(image);
		com.google.zxing.BinaryBitmap bitmap = new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(source));
		com.google.zxing.qrcode.QRCodeReader reader = new com.google.zxing.qrcode.QRCodeReader();
		com.google.zxing.Result result = null;
		try {
			result = reader.decode(bitmap);
		} catch (com.google.zxing.ReaderException e) {
			e.printStackTrace();
		}
		java.lang.System.out.println(result.getText());
	}

	public static void main(java.lang.String[] args) throws java.io.IOException, com.google.zxing.WriterException {
		com.pancm.utils.QrCodeCreateUtil.createQrCode(new java.io.FileOutputStream(new java.io.File("d:\\pancm.jpg")), "http://www.panchengming.com", 900, "JPEG");
		com.pancm.utils.QrCodeCreateUtil.readQrCode(new java.io.FileInputStream(new java.io.File("d:\\pancm.jpg")));
	}
}