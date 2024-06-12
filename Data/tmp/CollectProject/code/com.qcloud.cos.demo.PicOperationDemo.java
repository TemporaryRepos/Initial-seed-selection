public class PicOperationDemo {
	public static void main(java.lang.String[] args) {
		com.qcloud.cos.demo.PicOperationDemo.PicPersistentProcessing();
	}

	public static void PicPersistentProcessing() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("SECRET_ID", "SECRET_KEY");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-guangzhou"));
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String bucketName = "examplebucket-1250000000";
		java.lang.String key = "example.jpg";
		java.io.File localFile = new java.io.File("/data/example.jpg");
		com.qcloud.cos.model.ObjectMetadata objectMetadata = new com.qcloud.cos.model.ObjectMetadata();
		objectMetadata.setHeader("Pic-Operations", "{\"is_pic_info\":1,\"rules\":[{\"fileid\":\"example.png\",\"rule\":\"imageView2/format/png\"}]}");
		com.qcloud.cos.model.PutObjectRequest putObjectRequest = new com.qcloud.cos.model.PutObjectRequest(bucketName, key, localFile);
		putObjectRequest.setMetadata(objectMetadata);
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