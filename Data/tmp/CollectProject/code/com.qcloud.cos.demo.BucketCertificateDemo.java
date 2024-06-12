public class BucketCertificateDemo {
	public static void putGetDeleteBucketCertificate() {
		com.qcloud.cos.auth.COSCredentials cred = new com.qcloud.cos.auth.BasicCOSCredentials("xxxxxxxxxxxxxxxxxxxxxxxxxxxx", "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		com.qcloud.cos.ClientConfig clientConfig = new com.qcloud.cos.ClientConfig(new com.qcloud.cos.region.Region("ap-beijing"));
		java.lang.String bucketName = "mybucket-1251668577";
		com.qcloud.cos.model.bucketcertificate.BucketPutDomainCertificate bucketPutDomainCertificate = new com.qcloud.cos.model.bucketcertificate.BucketPutDomainCertificate();
		com.qcloud.cos.model.bucketcertificate.BucketDomainCertificateInfo bucketDomainCertificateInfo = new com.qcloud.cos.model.bucketcertificate.BucketDomainCertificateInfo();
		bucketDomainCertificateInfo.setCertType(com.qcloud.cos.model.bucketcertificate.BucketDomainCertificateParameters.Custom_CertType);
		java.util.List<java.lang.String> domainlist = new java.util.LinkedList<>();
		domainlist.add("test.com");
		bucketPutDomainCertificate.setDomainList(domainlist);
		try {
			java.lang.String key = com.qcloud.cos.demo.BucketCertificateDemo.getStreamContent("src/test/resources/test.com.key");
			bucketDomainCertificateInfo.setPrivateKey(key);
			java.lang.String pem = com.qcloud.cos.demo.BucketCertificateDemo.getStreamContent("src/test/resources/test.com.pem");
			bucketDomainCertificateInfo.setCert(pem);
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return;
		}
		com.qcloud.cos.COSClient cosclient = new com.qcloud.cos.COSClient(cred, clientConfig);
		bucketPutDomainCertificate.setBucketDomainCertificateInfo(bucketDomainCertificateInfo);
		cosclient.setBucketDomainCertificate(bucketName, bucketPutDomainCertificate);
		com.qcloud.cos.model.bucketcertificate.BucketGetDomainCertificate domainCertificate = cosclient.getBucketDomainCertificate(bucketName, "test.com");
		java.lang.System.out.println(domainCertificate.getStatus());
		cosclient.deleteBucketDomainCertificate(bucketName, "test.com");
		cosclient.shutdown();
	}

	private static java.lang.String getStreamContent(java.lang.String filePath) throws java.io.IOException {
		java.io.InputStream is = new java.io.FileInputStream(filePath);
		java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(is, com.qcloud.cos.utils.StringUtils.UTF8));
		try {
			char[] buf = new char[8192];
			int read = -1;
			while ((read = br.read(buf)) != (-1)) {
				stringBuilder.append(buf, 0, read);
			} 
		} finally {
			is.close();
			br.close();
		}
		return stringBuilder.toString();
	}

	public static void main(java.lang.String[] args) {
		com.qcloud.cos.demo.BucketCertificateDemo.putGetDeleteBucketCertificate();
	}
}