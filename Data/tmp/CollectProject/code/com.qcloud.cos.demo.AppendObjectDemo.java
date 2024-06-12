public class AppendObjectDemo {
	public static void AppendObjectFromLocal() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-guangzhou"));
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		java.lang.String bucketName = "mybucket-1251668577";
		java.lang.String key = "aaa/bbb.txt";
		try {
			java.io.File localFile = new java.io.File("1M.txt");
			com.qcloud.cos.model.AppendObjectRequest appendObjectRequest = new com.qcloud.cos.model.AppendObjectRequest(bucketName, key, localFile);
			appendObjectRequest.setPosition(0L);
			com.qcloud.cos.model.AppendObjectResult appendObjectResult = cosclient.appendObject(appendObjectRequest);
			long nextAppendPosition = appendObjectResult.getNextAppendPosition();
			java.lang.System.out.println(nextAppendPosition);
			localFile = new java.io.File("2M.txt");
			appendObjectRequest = new com.qcloud.cos.model.AppendObjectRequest(bucketName, key, localFile);
			appendObjectRequest.setPosition(nextAppendPosition);
			appendObjectResult = cosclient.appendObject(appendObjectRequest);
			nextAppendPosition = appendObjectResult.getNextAppendPosition();
			java.lang.System.out.println(nextAppendPosition);
		} catch (com.qcloud.cos.exception.CosServiceException e) {
			e.printStackTrace();
		} catch (com.qcloud.cos.exception.CosClientException e) {
			e.printStackTrace();
		}
		cosclient.shutdown();
	}

	public static void main(java.lang.String[] args) {
		com.qcloud.cos.demo.AppendObjectDemo.AppendObjectFromLocal();
	}
}