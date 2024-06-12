public class ProxyDemo {
	public static void ProxyUploadDemo(java.lang.String proxyIp, int proxyPort, java.lang.String username, java.lang.String password) {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-shanghai"));
		clientConfig.setHttpProxyIp(proxyIp);
		clientConfig.setHttpProxyPort(proxyPort);
		clientConfig.setProxyUsername(username);
		clientConfig.setProxyPassword(password);
		clientConfig.setUseBasicAuth(true);
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String key = "aaa/bbb.txt";
		try {
			com.qcloud.cos.model.PutObjectResult putObjectResult = cosclient.putObject(bucketName, key, "data");
			java.lang.String etag = putObjectResult.getETag();
		} catch (com.qcloud.cos.exception.CosServiceException e) {
			e.printStackTrace();
		} catch (com.qcloud.cos.exception.CosClientException e) {
			e.printStackTrace();
		}
		cosclient.shutdown();
	}

	public static void main(java.lang.String[] args) {
		if (args.length < 4) {
			java.lang.System.out.println("proxy ip, port, username and password required!");
			return;
		}
		com.qcloud.cos.demo.ProxyDemo.ProxyUploadDemo(args[0], java.lang.Integer.valueOf(args[1]), args[2], args[3]);
	}
}