public class SerializerFlatBuffersTest {
	private static final byte[] EMPTY = new byte[]{  };

	@org.junit.Test
	public void testSerializeRoundTripToFlatBuffersSingleArray() throws java.lang.Exception {
		roundTrip(InternalStructure.SINGLE_ARRAY, false);
	}

	@org.junit.Test
	public void testSerializeRoundTripToDefaultStructure() throws java.lang.Exception {
		roundTrip(InternalStructure.DEFAULT, false);
	}

	@org.junit.Test
	public void testSerializeRoundTripToFlatBuffersSingleArrayBackpressure() throws java.lang.Exception {
		roundTrip(InternalStructure.SINGLE_ARRAY, true);
	}

	@org.junit.Test
	public void testSerializeRoundTripToDefaultStructureBackpressure() throws java.lang.Exception {
		roundTrip(InternalStructure.DEFAULT, true);
	}

	private void roundTrip(com.github.davidmoten.rtree.InternalStructure structure, boolean backpressure) throws java.lang.Exception {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.star().maxChildren(10).create();
		tree = tree.add(com.github.davidmoten.rtree.GreekEarthquakes.entries()).last().toBlocking().single();
		long t = java.lang.System.currentTimeMillis();
		java.io.File file = new java.io.File("target/file");
		java.io.FileOutputStream os = new java.io.FileOutputStream(file);
		com.github.davidmoten.rtree.Serializer<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> fbSerializer = com.github.davidmoten.rtree.fbs.SerializerFlatBuffersTest.createSerializer();
		com.github.davidmoten.rtree.fbs.SerializerFlatBuffersTest.serialize(tree, t, file, os, fbSerializer);
		com.github.davidmoten.rtree.fbs.SerializerFlatBuffersTest.deserialize(structure, file, fbSerializer, backpressure);
	}

	private static com.github.davidmoten.rtree.Serializer<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> createSerializer() {
		rx.functions.Func1<java.lang.Object, byte[]> serializer = new rx.functions.Func1<java.lang.Object, byte[]>() {
			@java.lang.Override
			public byte[] call(java.lang.Object o) {
				return com.github.davidmoten.rtree.fbs.SerializerFlatBuffersTest.EMPTY;
			}
		};
		rx.functions.Func1<byte[], java.lang.Object> deserializer = new rx.functions.Func1<byte[], java.lang.Object>() {
			@java.lang.Override
			public java.lang.Object call(byte[] bytes) {
				return null;
			}
		};
		com.github.davidmoten.rtree.Serializer<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> fbSerializer = com.github.davidmoten.rtree.fbs.SerializerFlatBuffers.create(serializer, deserializer);
		return fbSerializer;
	}

	private static void serialize(com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree, long t, java.io.File file, java.io.FileOutputStream os, com.github.davidmoten.rtree.Serializer<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> fbSerializer) throws java.io.IOException {
		fbSerializer.write(tree, os);
		os.close();
		java.lang.System.out.println((((("written in " + (java.lang.System.currentTimeMillis() - t)) + "ms, ") + "file size=") + (file.length() / 1000000.0)) + "MB");
		java.lang.System.out.println("bytes per entry=" + (file.length() / tree.size()));
	}

	private static void deserialize(com.github.davidmoten.rtree.InternalStructure structure, java.io.File file, com.github.davidmoten.rtree.Serializer<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> fbSerializer, boolean backpressure) throws java.lang.Exception {
		long t = java.lang.System.currentTimeMillis();
		java.io.InputStream is = new java.io.FileInputStream(file);
		t = java.lang.System.currentTimeMillis();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tr = fbSerializer.read(is, file.length(), structure);
		java.lang.System.out.println(tr.root().get());
		java.lang.System.out.println(("read in " + (java.lang.System.currentTimeMillis() - t)) + "ms");
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Point>> o = tr.search(com.github.davidmoten.rtree.geometry.Geometries.rectangle(40, 27.0, 40.5, 27.5));
		if (backpressure) {
			o = o.take(10000);
		}
		int found = o.count().toBlocking().single();
		java.lang.System.out.println("found=" + found);
		org.junit.Assert.assertEquals(22, found);
		java.lang.System.out.println(tr.size());
	}

	@org.junit.Test(expected = java.lang.RuntimeException.class)
	public void testInputStreamNotAsLongAsExpected() throws java.io.IOException {
		com.github.davidmoten.rtree.fbs.SerializerFlatBuffers.readFully(new java.io.ByteArrayInputStream(new byte[10]), 12);
	}

	@org.junit.Test
	public void testInputStreamReturnsArrayInSmallChunks() throws java.io.IOException {
		java.io.InputStream is = new java.io.InputStream() {
			int i = 0;

			@java.lang.Override
			public int read() throws java.io.IOException {
				i += 1;
				if (i == 1) {
					return 1;
				} else if (i == 2) {
					throw new java.io.IOException();
				} else {
					return 1;
				}
			}
		};
		byte[] b = com.github.davidmoten.rtree.fbs.SerializerFlatBuffers.readFully(is, 2);
		org.junit.Assert.assertEquals(2, b.length);
		org.junit.Assert.assertEquals(1, b[0]);
		org.junit.Assert.assertEquals(1, b[0]);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
	}
}