public class Base64GetEncoderTest {
	public static void main(java.lang.String[] args) throws java.lang.Throwable {
		final java.util.Base64.Encoder encoder = java.util.Base64.getMimeEncoder(0, "$$$".getBytes(java.nio.charset.StandardCharsets.US_ASCII));
		javaT.util.Base64.Base64GetEncoderTest.testEncodeToString(encoder);
		javaT.util.Base64.Base64GetEncoderTest.testWrapEncode1(encoder);
		javaT.util.Base64.Base64GetEncoderTest.testEncodeToStringWithLongInputData(encoder);
		javaT.util.Base64.Base64GetEncoderTest.testWrapEncode2(encoder);
	}

	private static void testWrapEncode2(final java.util.Base64.Encoder encoder) throws java.io.IOException {
		java.lang.System.err.println("\nEncoder.wrap test II ");
		final byte[] secondTestBuffer = "api/java_util/Base64/index.html#GetEncoderMimeCustom[noLineSeparatorInEncodedString]".getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		java.lang.String base64EncodedString;
		java.io.ByteArrayOutputStream secondEncodingStream = new java.io.ByteArrayOutputStream();
		java.io.OutputStream base64EncodingStream = encoder.wrap(secondEncodingStream);
		base64EncodingStream.write(secondTestBuffer);
		base64EncodingStream.close();
		final byte[] encodedByteArray = secondEncodingStream.toByteArray();
		java.lang.System.err.print(("result = " + new java.lang.String(encodedByteArray, java.nio.charset.StandardCharsets.US_ASCII)) + "  after wrap Base64 encoding of string");
		base64EncodedString = new java.lang.String(encodedByteArray, java.nio.charset.StandardCharsets.US_ASCII);
		if (base64EncodedString.contains("$$$")) {
			throw new java.lang.RuntimeException("Base64 encoding contains line separator after wrap 2 invoked  ... \n");
		}
	}

	private static void testEncodeToStringWithLongInputData(final java.util.Base64.Encoder encoder) {
		java.lang.System.err.println("\n\nEncoder.encodeToStringWithLongInputData test  ");
		final byte[] secondTestBuffer = "api/java_util/Base64/index.html#GetEncoderMimeCustom[noLineSeparatorInEncodedString]".getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		java.lang.String base64EncodedString;
		base64EncodedString = encoder.encodeToString(secondTestBuffer);
		java.lang.System.err.println("Second Base64 encoded string is " + base64EncodedString);
		if (base64EncodedString.contains("$$$")) {
			throw new java.lang.RuntimeException("Base64 encoding contains line separator after encodeToString invoked  ... \n");
		}
	}

	private static void testWrapEncode1(final java.util.Base64.Encoder encoder) throws java.io.IOException {
		java.lang.System.err.println("\nEncoder.wrap test I ");
		final byte[] bytesIn = "fo".getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		java.lang.String base64EncodedString;
		java.io.ByteArrayOutputStream encodingStream = new java.io.ByteArrayOutputStream();
		java.io.OutputStream encoding = encoder.wrap(encodingStream);
		encoding.write(bytesIn);
		encoding.close();
		final byte[] encodedBytes = encodingStream.toByteArray();
		java.lang.System.err.print(("result = " + new java.lang.String(encodedBytes, java.nio.charset.StandardCharsets.US_ASCII)) + "  after the Base64 encoding \n");
		base64EncodedString = new java.lang.String(encodedBytes, java.nio.charset.StandardCharsets.US_ASCII);
		if (base64EncodedString.contains("$$$")) {
			throw new java.lang.RuntimeException("Base64 encoding contains line separator after wrap I test ... \n");
		}
	}

	private static void testEncodeToString(final java.util.Base64.Encoder encoder) {
		final byte[] bytesIn = "fo".getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		java.lang.System.err.println("\nEncoder.encodeToString test  ");
		java.lang.String base64EncodedString = encoder.encodeToString(bytesIn);
		java.lang.System.err.println("Base64 encoded string is " + base64EncodedString);
		if (base64EncodedString.contains("$$$")) {
			throw new java.lang.RuntimeException("Base64 encoding contains line separator after Encoder.encodeToString invoked ... \n");
		}
	}
}