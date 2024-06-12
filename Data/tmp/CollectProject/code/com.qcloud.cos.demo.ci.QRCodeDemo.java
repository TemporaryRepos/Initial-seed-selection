public class QRCodeDemo {
	public static void generateQrcode(com.qcloud.cos.COSClient cosClient) {
		com.qcloud.cos.model.ciModel.image.GenerateQrcodeRequest request = new com.qcloud.cos.model.ciModel.image.GenerateQrcodeRequest();
		request.setBucketName("examplebucket-1250000000");
		request.setQrcodeContent("数据万象");
		request.setWidth("400");
		request.setMode("0");
		java.lang.String imageBase64 = cosClient.generateQrcode(request);
		java.lang.System.out.println(imageBase64);
	}

	public static void identifyQrCodeWithGetObject(com.qcloud.cos.COSClient cosClient) throws java.io.IOException {
		java.lang.String bucketName = "examplebucket-1250000000";
		java.lang.String key = "数据万象.png";
		com.qcloud.cos.model.GetObjectRequest request = new com.qcloud.cos.model.GetObjectRequest(bucketName, key);
		request.putCustomQueryParameter("ci-process", "QRcode");
		request.putCustomQueryParameter("cover", "0");
		com.qcloud.cos.model.COSObject object = cosClient.getObject(request);
		com.qcloud.cos.model.COSObjectInputStream content = object.getObjectContent();
		java.lang.String response = com.qcloud.cos.utils.IOUtils.toString(content);
		java.lang.System.out.println(response);
	}

	public static void identifyQrCode(com.qcloud.cos.COSClient cosClient) {
		java.lang.String bucketName = "examplebucket-1250000000";
		java.lang.String key = "qrcode.png";
		java.io.File localFile = new java.io.File("E://qrcode.png");
		com.qcloud.cos.model.PutObjectRequest putObjectRequest = new com.qcloud.cos.model.PutObjectRequest(bucketName, key, localFile);
		com.qcloud.cos.model.ciModel.persistence.PicOperations picOperations = new com.qcloud.cos.model.ciModel.persistence.PicOperations();
		picOperations.setIsPicInfo(1);
		java.util.List<com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule> ruleList = new java.util.LinkedList<>();
		com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule rule1 = new com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule();
		rule1.setBucket(bucketName);
		rule1.setFileId("qrcode-1.png");
		rule1.setRule("QRcode/cover/1");
		ruleList.add(rule1);
		picOperations.setRules(ruleList);
		putObjectRequest.setPicOperations(picOperations);
		try {
			com.qcloud.cos.model.PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
			com.qcloud.cos.model.ciModel.persistence.CIUploadResult ciUploadResult = putObjectResult.getCiUploadResult();
			java.lang.System.out.println(putObjectResult.getRequestId());
			java.lang.System.out.println(ciUploadResult.getOriginalInfo().getEtag());
			for (com.qcloud.cos.model.ciModel.persistence.CIObject ciObject : ciUploadResult.getProcessResults().getObjectList()) {
				java.lang.System.out.println(ciObject.getLocation());
			}
		} catch (com.qcloud.cos.exception.CosServiceException e) {
			e.printStackTrace();
		} catch (com.qcloud.cos.exception.CosClientException e) {
			e.printStackTrace();
		}
	}

	public static void identifyQrCodeWithMultipart(com.qcloud.cos.COSClient cosClient) throws java.io.FileNotFoundException {
		java.lang.String bucketName = "examplebucket-1250000000";
		java.lang.String key = "qrcode.png";
		java.io.File localFile = new java.io.File("E://qrcode.png");
		com.qcloud.cos.model.InitiateMultipartUploadRequest request = new com.qcloud.cos.model.InitiateMultipartUploadRequest(bucketName, key);
		com.qcloud.cos.model.InitiateMultipartUploadResult initResult = cosClient.initiateMultipartUpload(request);
		java.lang.String uploadId = initResult.getUploadId();
		java.util.List<com.qcloud.cos.model.PartETag> partETags = new java.util.LinkedList<>();
		com.qcloud.cos.model.UploadPartRequest uploadPartRequest = new com.qcloud.cos.model.UploadPartRequest();
		uploadPartRequest.setBucketName(bucketName);
		uploadPartRequest.setKey(key);
		uploadPartRequest.setUploadId(uploadId);
		uploadPartRequest.setInputStream(new java.io.FileInputStream(localFile));
		uploadPartRequest.setPartSize(localFile.length());
		uploadPartRequest.setPartNumber(1);
		com.qcloud.cos.model.UploadPartResult uploadPartResult = cosClient.uploadPart(uploadPartRequest);
		com.qcloud.cos.model.PartETag partETag = uploadPartResult.getPartETag();
		partETags.add(partETag);
		com.qcloud.cos.model.ciModel.persistence.PicOperations picOperations = new com.qcloud.cos.model.ciModel.persistence.PicOperations();
		picOperations.setIsPicInfo(1);
		java.util.List<com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule> ruleList = new java.util.LinkedList<>();
		com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule rule1 = new com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule();
		rule1.setBucket(bucketName);
		rule1.setFileId("qrcode-1.png");
		rule1.setRule("QRcode/cover/1");
		ruleList.add(rule1);
		picOperations.setRules(ruleList);
		com.qcloud.cos.model.CompleteMultipartUploadRequest completeMultipartUploadRequest = new com.qcloud.cos.model.CompleteMultipartUploadRequest(bucketName, key, uploadId, partETags);
		completeMultipartUploadRequest.setPicOperations(picOperations);
		com.qcloud.cos.model.CompleteMultipartUploadResult completeMultipartUploadResult = cosClient.completeMultipartUpload(completeMultipartUploadRequest);
		com.qcloud.cos.model.ciModel.persistence.CIUploadResult ciUploadResult = completeMultipartUploadResult.getCiUploadResult();
		java.lang.System.out.println(completeMultipartUploadResult.getRequestId());
		java.lang.System.out.println(ciUploadResult.getOriginalInfo().getEtag());
		for (com.qcloud.cos.model.ciModel.persistence.CIObject ciObject : ciUploadResult.getProcessResults().getObjectList()) {
			java.lang.System.out.println(ciObject.getLocation());
		}
	}

	public static void identifyQrCodeWithTransferManager(com.qcloud.cos.transfer.TransferManager transferManager) throws java.lang.InterruptedException {
		java.lang.String bucketName = "examplebucket-1250000000";
		java.lang.String key = "qrcode.png";
		java.io.File localFile = new java.io.File("E://qrcode.png");
		com.qcloud.cos.model.PutObjectRequest putObjectRequest = new com.qcloud.cos.model.PutObjectRequest(bucketName, key, localFile);
		com.qcloud.cos.model.ciModel.persistence.PicOperations picOperations = new com.qcloud.cos.model.ciModel.persistence.PicOperations();
		picOperations.setIsPicInfo(1);
		java.util.List<com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule> ruleList = new java.util.LinkedList<>();
		com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule rule1 = new com.qcloud.cos.model.ciModel.persistence.PicOperations.Rule();
		rule1.setBucket(bucketName);
		rule1.setFileId("qrcode-1.png");
		rule1.setRule("QRcode/cover/1");
		ruleList.add(rule1);
		picOperations.setRules(ruleList);
		putObjectRequest.setPicOperations(picOperations);
		com.qcloud.cos.transfer.Upload upload = transferManager.upload(putObjectRequest);
		com.qcloud.cos.model.UploadResult uploadResult = upload.waitForUploadResult();
		com.qcloud.cos.model.ciModel.persistence.CIUploadResult ciUploadResult = uploadResult.getCiUploadResult();
		java.lang.System.out.println(uploadResult.getRequestId());
		java.lang.System.out.println(ciUploadResult.getOriginalInfo().getEtag());
		for (com.qcloud.cos.model.ciModel.persistence.CIObject ciObject : ciUploadResult.getProcessResults().getObjectList()) {
			java.lang.System.out.println(ciObject.getLocation());
		}
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.qcloud.cos.COSClient cosClient = com.qcloud.cos.demo.ci.ClientUtils.getTestClient();
		cosClient.shutdown();
	}
}