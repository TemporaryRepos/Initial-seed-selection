public class SimpleUploadFileDemo {
	public static void main(java.lang.String[] args) {
		com.qcloud.cos.demo.SimpleUploadFileDemo.SimpleUploadFileFromLocal(false);
	}

	public static void SimpleUploadFileFromLocal(boolean useTrafficLimit) {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-beijing-1"));
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String key = "aaa/bbb.txt";
		java.io.File localFile = new java.io.File("src/test/resources/len10M.txt");
		com.qcloud.cos.model.PutObjectRequest putObjectRequest = new com.qcloud.cos.model.PutObjectRequest(bucketName, key, localFile);
		if (useTrafficLimit) {
			putObjectRequest.setTrafficLimit((8 * 1024) * 1024);
		}
		putObjectRequest.setStorageClass(com.qcloud.cos.model.StorageClass.Standard_IA);
		try {
			com.qcloud.cos.model.PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			java.lang.String etag = putObjectResult.getETag();
			java.lang.String crc64 = putObjectResult.getCrc64Ecma();
		} catch (com.qcloud.cos.exception.CosServiceException e) {
			e.printStackTrace();
		} catch (com.qcloud.cos.exception.CosClientException e) {
			e.printStackTrace();
		}
		cosclient.shutdown();
	}

	public static void SimpleUploadFileFromStream() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-beijing-1"));
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String key = "aaa/bbb.jpg";
		java.io.File localFile = new java.io.File("src/test/resources/len10M.txt");
		java.io.InputStream input = new java.io.ByteArrayInputStream(new byte[10]);
		com.qcloud.cos.model.ObjectMetadata objectMetadata = new com.qcloud.cos.model.ObjectMetadata();
		objectMetadata.setContentLength(10);
		objectMetadata.setContentType("image/jpeg");
		com.qcloud.cos.model.PutObjectRequest putObjectRequest = new com.qcloud.cos.model.PutObjectRequest(bucketName, key, input, objectMetadata);
		putObjectRequest.setStorageClass(com.qcloud.cos.model.StorageClass.Standard_IA);
		try {
			com.qcloud.cos.model.PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			java.lang.String etag = putObjectResult.getETag();
		} catch (com.qcloud.cos.exception.CosServiceException e) {
			e.printStackTrace();
		} catch (com.qcloud.cos.exception.CosClientException e) {
			e.printStackTrace();
		}
		cosclient.shutdown();
	}
}