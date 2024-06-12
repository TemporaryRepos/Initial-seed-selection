public class GetObjectURLDemo {
	public static void main(java.lang.String[] args) {
		com.qcloud.cos.demo.GetObjectURLDemo.getObjectUrlWithEndpoint();
	}

	public static void getObjectUrl() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.AnonymousCOSCredentials();
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-guangzhou"));
		clientConfig.setHttpProtocol(com.qcloud.cos.http.HttpProtocol.https);
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String key = "test/my_test中文.json";
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.System.out.println(cosclient.getObjectUrl(bucketName, key));
	}

	public static void getObjectUrlWithVersionId() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.AnonymousCOSCredentials();
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-guangzhou"));
		clientConfig.setHttpProtocol(com.qcloud.cos.http.HttpProtocol.https);
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String key = "test/my_test中文.json";
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String versionId = "xxxyyyzzz111222333";
		java.lang.System.out.println(cosclient.getObjectUrl(bucketName, key, versionId));
	}

	public static void getObjectUrlWithEndpoint() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.AnonymousCOSCredentials();
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-guangzhou"));
		clientConfig.setHttpProtocol(com.qcloud.cos.http.HttpProtocol.https);
		com.qcloud.cos.endpoint.UserSpecifiedEndpointBuilder endpointBuilder = new com.qcloud.cos.endpoint.UserSpecifiedEndpointBuilder("test.endpoint.com", "service.cos.myqcloud.com");
		clientConfig.setEndpointBuilder(endpointBuilder);
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String key = "test/my_test中文.json";
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String versionId = "xxxyyyzzz111222333";
		java.lang.System.out.println(cosclient.getObjectUrl(bucketName, key, versionId));
	}
}