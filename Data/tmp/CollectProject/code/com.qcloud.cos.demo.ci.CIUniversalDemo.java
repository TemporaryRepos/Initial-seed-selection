public class CIUniversalDemo {
	public static void main(java.lang.String[] args) throws java.lang.InterruptedException {
		com.qcloud.cos.COSClient client = com.qcloud.cos.demo.ci.ClientUtils.getTestClient();
		com.qcloud.cos.demo.ci.CIUniversalDemo.customCIMethod(client);
	}

	public static void customCIMethod(com.qcloud.cos.COSClient client) {
		com.qcloud.cos.model.ciModel.common.CICommonRequest request = new com.qcloud.cos.model.ciModel.common.CICommonRequest();
	}
}