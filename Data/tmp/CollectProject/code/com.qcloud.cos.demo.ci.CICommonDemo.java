public class CICommonDemo {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		java.lang.String src = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Response><EventName>TaskFinish</EventName><JobsDetail><Code>Success</Code><CreationTime>2021-02-19T15:24:44+0800</CreationTime><EndTime>2021-02-19T15:24:45+0800</EndTime><Input><Object>1.docx</Object></Input><JobId>d89c4cf4a728311ebb1229f23e6c9963b</JobId><Message/><Operation><DocProcess><Comments>1</Comments><DocPassword/><EndPage>-1</EndPage><ImageParams/><PaperDirection>0</PaperDirection><PaperSize>0</PaperSize><Quality>100</Quality><SheetId>0</SheetId><SrcType/><StartPage>0</StartPage><TgtType/><Zoom>100</Zoom></DocProcess><DocProcessResult><FailPageCount>0</FailPageCount><PageInfo><PageNo>1</PageNo><TgtUri>test1/1.jpg</TgtUri></PageInfo><SuccPageCount>1</SuccPageCount><TaskId/><TgtType/><TotalPageCount>1</TotalPageCount></DocProcessResult><Output><Bucket>markjrzhang-1251704708</Bucket><Object>test1/${Page}.jpg</Object><Region>ap-chongqing</Region></Output></Operation><QueueId>p3615c32d66fa493bae4c43a5e655ab7f</QueueId><State>Success</State><Tag>DocProcess</Tag></JobsDetail></Response>";
		com.qcloud.cos.demo.ci.CICommonDemo.processCINotifyResponse(src);
	}

	public static void processCINotifyResponse(java.lang.String response) throws java.lang.Exception {
		com.qcloud.cos.internal.Unmarshallers.DescribeDocJobUnmarshaller describeDocJobUnmarshaller = new com.qcloud.cos.internal.Unmarshallers.DescribeDocJobUnmarshaller();
		java.io.InputStream is = new java.io.ByteArrayInputStream(response.getBytes());
		com.qcloud.cos.model.ciModel.job.DocJobResponse docJobResponse = describeDocJobUnmarshaller.unmarshall(is);
		java.lang.System.out.println(docJobResponse);
	}

	public static void processCINotifyResponse2(java.lang.String response) throws java.lang.Exception {
		com.qcloud.cos.internal.Unmarshallers.AudioAuditingJobUnmarshaller audioAuditingJobUnmarshaller = new com.qcloud.cos.internal.Unmarshallers.AudioAuditingJobUnmarshaller();
		java.io.InputStream is = new java.io.ByteArrayInputStream(response.getBytes());
		com.qcloud.cos.model.ciModel.auditing.AudioAuditingResponse unmarshall = audioAuditingJobUnmarshaller.unmarshall(is);
		java.lang.System.out.println(com.qcloud.cos.utils.Jackson.toJsonString(unmarshall));
	}

	public static void processJsonCINotifyResponse(java.lang.String jsonResponse) throws java.lang.Exception {
	}
}