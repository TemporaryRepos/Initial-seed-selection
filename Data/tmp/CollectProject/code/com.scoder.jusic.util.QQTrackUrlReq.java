public class QQTrackUrlReq {
	public java.lang.String getTrackUrl(java.lang.String mid, java.lang.String quality) {
		return null;
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		com.scoder.jusic.util.QQTrackUrlReq qqTrackUrlReq = new com.scoder.jusic.util.QQTrackUrlReq();
		java.lang.String url = qqTrackUrlReq.getTrackUrl("002eB80M3JAI55", "320k");
		java.lang.System.out.println(url);
	}
}