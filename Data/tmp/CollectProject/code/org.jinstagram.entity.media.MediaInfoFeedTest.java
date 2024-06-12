public class MediaInfoFeedTest {
	@org.junit.Test
	public void testGetData_1() throws java.lang.Exception {
		MediaInfoFeed fixture = new MediaInfoFeed();
		fixture.setMeta(new org.jinstagram.entity.common.Meta());
		fixture.setData(new org.jinstagram.entity.users.feed.MediaFeedData());
		org.jinstagram.entity.users.feed.MediaFeedData result = fixture.getData();
		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(null, result.getImages());
		org.junit.Assert.assertEquals(null, result.getTags());
		org.junit.Assert.assertEquals(null, result.getUser());
		org.junit.Assert.assertEquals("MediaFeedData [caption=null, comments=null, createdTime=null, id=null, imageFilter=null, images=null, likes=null, link=null, location=null, tags=null, type=null, user=null, userHasLiked=false, usersInPhoto=null]", result.toString());
		org.junit.Assert.assertEquals(null, result.getLocation());
		org.junit.Assert.assertEquals(null, result.getId());
		org.junit.Assert.assertEquals(null, result.getType());
		org.junit.Assert.assertEquals(false, result.isUserHasLiked());
		org.junit.Assert.assertEquals(null, result.getVideos());
		org.junit.Assert.assertEquals(null, result.getUsersInPhotoList());
		org.junit.Assert.assertEquals(null, result.getImageFilter());
		org.junit.Assert.assertEquals(null, result.getCreatedTime());
		org.junit.Assert.assertEquals(null, result.getLikes());
		org.junit.Assert.assertEquals(null, result.getCaption());
		org.junit.Assert.assertEquals(null, result.getLink());
		org.junit.Assert.assertEquals(null, result.getComments());
	}

	@org.junit.Test
	public void testGetMeta_1() throws java.lang.Exception {
		MediaInfoFeed fixture = new MediaInfoFeed();
		fixture.setMeta(new org.jinstagram.entity.common.Meta());
		fixture.setData(new org.jinstagram.entity.users.feed.MediaFeedData());
		org.jinstagram.entity.common.Meta result = fixture.getMeta();
		org.junit.Assert.assertNotNull(result);
		org.junit.Assert.assertEquals(null, result.getErrorMessage());
		org.junit.Assert.assertEquals(0, result.getCode());
		org.junit.Assert.assertEquals("Meta [code=0, errorMessage=null, errorType=null]", result.toString());
		org.junit.Assert.assertEquals(null, result.getErrorType());
	}

	@org.junit.Test
	public void testSetData_1() throws java.lang.Exception {
		MediaInfoFeed fixture = new MediaInfoFeed();
		fixture.setMeta(new org.jinstagram.entity.common.Meta());
		fixture.setData(new org.jinstagram.entity.users.feed.MediaFeedData());
		org.jinstagram.entity.users.feed.MediaFeedData data = new org.jinstagram.entity.users.feed.MediaFeedData();
		fixture.setData(data);
	}

	@org.junit.Test
	public void testSetMeta_1() throws java.lang.Exception {
		MediaInfoFeed fixture = new MediaInfoFeed();
		fixture.setMeta(new org.jinstagram.entity.common.Meta());
		fixture.setData(new org.jinstagram.entity.users.feed.MediaFeedData());
		org.jinstagram.entity.common.Meta meta = new org.jinstagram.entity.common.Meta();
		fixture.setMeta(meta);
	}

	@org.junit.Test
	public void testToString_1() throws java.lang.Exception {
		MediaInfoFeed fixture = new MediaInfoFeed();
		fixture.setMeta(new org.jinstagram.entity.common.Meta());
		fixture.setData(new org.jinstagram.entity.users.feed.MediaFeedData());
		java.lang.String result = fixture.toString();
		org.junit.Assert.assertEquals("MediaInfoFeed [data=MediaFeedData [caption=null, comments=null, createdTime=null, id=null, imageFilter=null, images=null, likes=null, link=null, location=null, tags=null, type=null, user=null, userHasLiked=false, usersInPhoto=null], meta=Meta [code=0, errorMessage=null, errorType=null]]", result);
	}

	@org.junit.Test
	public void testMediaCarouselVideos() throws java.io.IOException {
		final java.lang.String s = org.jinstagram.entity.media.MediaInfoFeedTest.toString("media-carousel-videos-1455920561485265648_25025320.json");
		final MediaInfoFeed feed = org.jinstagram.InstagramBase.createObjectFromResponse(org.jinstagram.entity.media.MediaInfoFeed.class, s);
		final java.util.List<org.jinstagram.entity.users.feed.CarouselMedia> carousel = feed.getData().getCarouselMedia();
		org.junit.Assert.assertEquals(3, carousel.size());
		for (org.jinstagram.entity.users.feed.CarouselMedia media : carousel) {
			org.junit.Assert.assertEquals("video", media.getType());
		}
	}

	@org.junit.Test
	public void testMediaCarouselImages() throws java.io.IOException {
		final java.lang.String s = org.jinstagram.entity.media.MediaInfoFeedTest.toString("media-carousel-images-1477919811501485796_25025320.json");
		final MediaInfoFeed feed = org.jinstagram.InstagramBase.createObjectFromResponse(org.jinstagram.entity.media.MediaInfoFeed.class, s);
		final java.util.List<org.jinstagram.entity.users.feed.CarouselMedia> carousel = feed.getData().getCarouselMedia();
		org.junit.Assert.assertEquals(4, carousel.size());
		for (org.jinstagram.entity.users.feed.CarouselMedia media : carousel) {
			org.junit.Assert.assertEquals("image", media.getType());
		}
	}

	static java.lang.String toString(final java.lang.String s) throws java.io.UnsupportedEncodingException, java.io.IOException {
		java.io.Reader is = new java.io.InputStreamReader(org.jinstagram.entity.media.MediaInfoFeedTest.class.getClassLoader().getResourceAsStream(s), "utf-8");
		try {
			final java.lang.StringBuilder sb = new java.lang.StringBuilder();
			final char[] cb = new char[1024];
			int n;
			while (((-1) != (n = is.read(cb))) && (sb.length() < 120000)) {
				if (n == (-1)) {
					break;
				}
				for (int i = 0; i < n; i++) {
					sb.append(cb[i]);
				}
			} 
			return sb.toString();
		} finally {
			is.close();
		}
	}

	@org.junit.Before
	public void setUp() throws java.lang.Exception {
	}

	@org.junit.After
	public void tearDown() throws java.lang.Exception {
	}

	public static void main(java.lang.String[] args) {
		new org.junit.runner.JUnitCore().run(org.jinstagram.entity.media.MediaInfoFeedTest.class);
	}
}