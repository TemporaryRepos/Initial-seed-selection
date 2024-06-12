public class RTreeTest {
	private static final double PRECISION = 1.0E-6;

	@org.junit.Test
	public void testInstantiation() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		org.junit.Assert.assertTrue(tree.entries().isEmpty().toBlocking().single());
	}

	@org.junit.Test
	public void testSearchEmptyTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		org.junit.Assert.assertTrue(tree.search(com.github.davidmoten.rtree.RTreeTest.r(1)).isEmpty().toBlocking().single());
	}

	@java.lang.SuppressWarnings("unchecked")
	@org.junit.Test
	public void testSearchOnOneItem() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry = com.github.davidmoten.rtree.RTreeTest.e(1);
		tree = tree.add(entry);
		org.junit.Assert.assertEquals(java.util.Arrays.asList(entry), tree.search(com.github.davidmoten.rtree.RTreeTest.r(1)).toList().toBlocking().single());
	}

	@org.junit.Test
	public void testTreeWithOneItemIsNotEmpty() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(com.github.davidmoten.rtree.RTreeTest.e(1));
		org.junit.Assert.assertFalse(tree.isEmpty());
	}

	public void testSaveFileException() throws java.io.IOException {
		java.nio.channels.FileLock lock = null;
		java.io.RandomAccessFile file = null;
		try {
			java.lang.String filename = "target/locked.png";
			java.io.File f = new java.io.File(filename);
			f.createNewFile();
			file = new java.io.RandomAccessFile(f, "rw");
			lock = file.getChannel().lock();
			com.github.davidmoten.rtree.RTree.create().visualize(600, 600).save(filename, "PNG");
		} finally {
			try {
				lock.release();
				file.close();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
	}

	@org.junit.Test
	public void testVisualizerWithEmptyTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		tree.visualize(600, 600).save("target/tree.png", "PNG");
	}

	@org.junit.Test
	public void testAddObservable() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e2 = com.github.davidmoten.rtree.RTreeTest.e2(1);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(e1).add(e2).delete(e1);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> emptyTree = com.github.davidmoten.rtree.RTree.maxChildren(4).create();
		rx.Observable<?> deletedtree = emptyTree.add(tree.entries());
		org.junit.Assert.assertEquals(2, ((int) (deletedtree.count().toBlocking().single())));
	}

	@org.junit.Test
	public void testPerformanceAndEntriesCount() {
		long repeats = java.lang.Long.parseLong(java.lang.System.getProperty("r", "1"));
		long n = java.lang.Long.parseLong(java.lang.System.getProperty("n", "10000"));
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = null;
		while ((--repeats) >= 0) {
			long t = java.lang.System.currentTimeMillis();
			tree = com.github.davidmoten.rtree.RTreeTest.createRandomRTree(n);
			long diff = java.lang.System.currentTimeMillis() - t;
			java.lang.System.out.println("inserts/second = " + ((((double) (n)) / diff) * 1000));
		} 
		org.junit.Assert.assertEquals(n, ((int) (tree.entries().count().toBlocking().single())));
		long t = java.lang.System.currentTimeMillis();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> entry = tree.search(com.github.davidmoten.rtree.geometry.Geometries.rectangle(0, 0, 500, 500)).first().toBlocking().single();
		long diff = java.lang.System.currentTimeMillis() - t;
		java.lang.System.out.println("found " + entry);
		java.lang.System.out.println((("time to get nearest with " + n) + " entries=") + diff);
	}

	@org.junit.Test
	public void testSearchOfPoint() {
		java.lang.Object value = new java.lang.Object();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(value, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).toList().toBlocking().single();
		org.junit.Assert.assertEquals(1, list.size());
		org.junit.Assert.assertEquals(value, list.get(0).value());
	}

	@org.junit.Test
	public void testSearchOfPointWithinDistance() {
		java.lang.Object value = new java.lang.Object();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(value, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.point(1, 1), 2).toList().toBlocking().single();
		org.junit.Assert.assertEquals(1, list.size());
		org.junit.Assert.assertEquals(value, list.get(0).value());
	}

	static java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> createRandomEntries(long n) {
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = new java.util.ArrayList<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>>();
		for (long i = 0; i < n; i++) {
			list.add(com.github.davidmoten.rtree.RTreeTest.randomEntry());
		}
		return list;
	}

	static com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> createRandomRTree(long n) {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).create();
		for (long i = 0; i < n; i++) {
			com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> entry = com.github.davidmoten.rtree.RTreeTest.randomEntry();
			tree = tree.add(entry);
		}
		return tree;
	}

	static com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> randomEntry() {
		return com.github.davidmoten.rtree.Entries.entry(new java.lang.Object(), ((com.github.davidmoten.rtree.geometry.Geometry) (com.github.davidmoten.rtree.RTreeTest.random())));
	}

	@org.junit.Test
	public void testDeleteWithGeometry() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry2 = com.github.davidmoten.rtree.RTreeTest.e2(1);
		tree = tree.add(entry).add(entry2);
		tree = tree.delete(entry.value(), entry.geometry(), true);
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> entries = tree.entries().toList().toBlocking().single();
		org.junit.Assert.assertTrue(entries.contains(entry2) && (!entries.contains(entry)));
	}

	@org.junit.Test
	public void testDepthWith0() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		tree = tree.add(com.github.davidmoten.rtree.RTreeTest.createRandomEntries(5));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> entries = tree.entries().toList().toBlocking().single();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> deletedTree = tree.delete(entries, true);
		org.junit.Assert.assertTrue(deletedTree.isEmpty());
	}

	@org.junit.Test
	public void testContext() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		org.junit.Assert.assertNotNull(tree.context());
	}

	@org.junit.Test
	public void testIterableDeletion() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry2 = com.github.davidmoten.rtree.RTreeTest.e(2);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry3 = com.github.davidmoten.rtree.RTreeTest.e(3);
		tree = tree.add(entry1).add(entry2).add(entry3);
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> list = new java.util.ArrayList<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>>();
		list.add(entry1);
		list.add(entry3);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> deletedTree = tree.delete(list);
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> entries = deletedTree.entries().toList().toBlocking().single();
		org.junit.Assert.assertTrue((entries.contains(entry2) && (!entries.contains(entry1))) && (!entries.contains(entry3)));
	}

	@org.junit.Test
	public void testObservableDeletion() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry2 = com.github.davidmoten.rtree.RTreeTest.e(3);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry3 = com.github.davidmoten.rtree.RTreeTest.e(5);
		tree = tree.add(entry1).add(entry2).add(entry3);
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> obs = tree.search(com.github.davidmoten.rtree.RTreeTest.r(2), 5);
		rx.Observable<com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> deleted = tree.delete(obs, true);
		org.junit.Assert.assertTrue(deleted.elementAt(deleted.count().toBlocking().single() - 1).count().toBlocking().single() == 1);
	}

	@org.junit.Test
	public void testFullDeletion() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry = com.github.davidmoten.rtree.RTreeTest.e(1);
		tree = tree.add(entry).add(entry);
		tree = tree.delete(entry, true);
		org.junit.Assert.assertTrue(tree.isEmpty());
	}

	@org.junit.Test
	public void testPartialDeletion() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).create();
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry = com.github.davidmoten.rtree.RTreeTest.e(1);
		tree = tree.add(entry).add(entry);
		tree = tree.delete(entry, false);
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> entries = tree.entries().toList().toBlocking().single();
		int countEntries = tree.entries().count().toBlocking().single();
		org.junit.Assert.assertTrue(countEntries == 1);
		org.junit.Assert.assertTrue(entries.get(0).equals(entry));
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries1() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 1);
		org.junit.Assert.assertEquals(1, tree.calculateDepth());
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries2() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 2);
		org.junit.Assert.assertEquals(1, tree.calculateDepth());
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries3() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 3);
		org.junit.Assert.assertEquals(1, tree.calculateDepth());
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries4() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 4);
		org.junit.Assert.assertEquals(2, tree.calculateDepth());
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries8() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 8);
		tree.visualize(800, 800).save(new java.io.File("target/treeLittle.png"), "PNG");
		org.junit.Assert.assertEquals(3, tree.calculateDepth());
	}

	@org.junit.Test
	public void testDepthWithMaxChildren3Entries10() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 10);
		org.junit.Assert.assertEquals(3, tree.calculateDepth());
	}

	@org.junit.Test
	public void testSizeIsZeroIfTreeEmpty() {
		org.junit.Assert.assertEquals(0, com.github.davidmoten.rtree.RTreeTest.create(3, 0).size());
	}

	@org.junit.Test
	public void testSizeIsOneIfTreeHasOneEntry() {
		org.junit.Assert.assertEquals(1, com.github.davidmoten.rtree.RTreeTest.create(3, 1).size());
	}

	@org.junit.Test
	public void testSizeIsFiveIfTreeHasFiveEntries() {
		org.junit.Assert.assertEquals(5, com.github.davidmoten.rtree.RTreeTest.create(3, 5).size());
	}

	@org.junit.Test
	public void testSizeAfterDelete() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> entry = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 0).add(entry).add(entry).add(entry).delete(entry);
		org.junit.Assert.assertEquals(2, tree.size());
	}

	@java.lang.SuppressWarnings("unchecked")
	@org.junit.Test
	public void testDeletionThatRemovesAllNodesChildren() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 8);
		tree = tree.add(com.github.davidmoten.rtree.RTreeTest.e(10));
		org.junit.Assert.assertEquals(3, tree.calculateDepth());
		tree = tree.delete(com.github.davidmoten.rtree.RTreeTest.e(10));
		org.junit.Assert.assertEquals(3, tree.calculateDepth());
		org.junit.Assert.assertEquals(com.github.davidmoten.guavamini.Sets.newHashSet(com.github.davidmoten.rtree.RTreeTest.e(1), com.github.davidmoten.rtree.RTreeTest.e(2), com.github.davidmoten.rtree.RTreeTest.e(3), com.github.davidmoten.rtree.RTreeTest.e(4), com.github.davidmoten.rtree.RTreeTest.e(5), com.github.davidmoten.rtree.RTreeTest.e(6), com.github.davidmoten.rtree.RTreeTest.e(7), com.github.davidmoten.rtree.RTreeTest.e(8)), com.github.davidmoten.guavamini.Sets.newHashSet(tree.entries().toList().toBlocking().single()));
	}

	@java.lang.SuppressWarnings("unchecked")
	@org.junit.Test
	public void testDeleteOfEntryThatDoesNotExistFromTreeOfOneEntry() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(com.github.davidmoten.rtree.RTreeTest.e(1));
		tree = tree.delete(com.github.davidmoten.rtree.RTreeTest.e(2));
		org.junit.Assert.assertEquals(com.github.davidmoten.guavamini.Lists.newArrayList(com.github.davidmoten.rtree.RTreeTest.e(1)), tree.entries().toList().toBlocking().single());
	}

	@org.junit.Test
	public void testDeleteFromEmptyTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		tree = tree.delete(com.github.davidmoten.rtree.RTreeTest.e(2));
		org.junit.Assert.assertEquals(0, ((int) (tree.entries().count().toBlocking().single())));
	}

	@org.junit.Test
	public void testBuilder1() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.minChildren(1).maxChildren(4).selector(new com.github.davidmoten.rtree.SelectorMinimalAreaIncrease()).splitter(new com.github.davidmoten.rtree.SplitterQuadratic()).create();
		testBuiltTree(tree);
	}

	@org.junit.Test
	public void testDeletionOfEntryThatDoesNotExistFromNonLeaf() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTreeTest.create(3, 100).delete(com.github.davidmoten.rtree.RTreeTest.e(1000));
		org.junit.Assert.assertEquals(100, ((int) (tree.entries().count().toBlocking().single())));
	}

	@org.junit.Test
	public void testBuilder2() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.selector(new com.github.davidmoten.rtree.SelectorMinimalAreaIncrease()).minChildren(1).maxChildren(4).splitter(new com.github.davidmoten.rtree.SplitterQuadratic()).create();
		testBuiltTree(tree);
	}

	@org.junit.Test
	public void testBuilder3() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).selector(new com.github.davidmoten.rtree.SelectorMinimalAreaIncrease()).minChildren(1).splitter(new com.github.davidmoten.rtree.SplitterQuadratic()).create();
		testBuiltTree(tree);
	}

	@org.junit.Test
	public void testBuilder4() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.splitter(new com.github.davidmoten.rtree.SplitterQuadratic()).maxChildren(4).selector(new com.github.davidmoten.rtree.SelectorMinimalAreaIncrease()).minChildren(1).create();
		testBuiltTree(tree);
	}

	@org.junit.Test
	public void testBackpressureIterationForUpTo1000Entries() {
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> entries = com.github.davidmoten.rtree.Utilities.entries1000();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.star().create();
		for (int i = 1; i <= 1000; i++) {
			tree = tree.add(entries.get(i - 1));
			final java.util.HashSet<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> set = new java.util.HashSet<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>>();
			tree.entries().subscribe(com.github.davidmoten.rtree.RTreeTest.createBackpressureSubscriber(set));
			org.junit.Assert.assertEquals(new java.util.HashSet<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>>(entries.subList(0, i)), set);
		}
	}

	private static <T extends com.github.davidmoten.rtree.geometry.Geometry> rx.Subscriber<com.github.davidmoten.rtree.Entry<java.lang.Object, T>> createBackpressureSubscriber(final java.util.Collection<com.github.davidmoten.rtree.Entry<java.lang.Object, T>> collection) {
		return new rx.Subscriber<com.github.davidmoten.rtree.Entry<java.lang.Object, T>>() {
			@java.lang.Override
			public void onStart() {
				request(1);
			}

			@java.lang.Override
			public void onCompleted() {
			}

			@java.lang.Override
			public void onError(java.lang.Throwable e) {
			}

			@java.lang.Override
			public void onNext(com.github.davidmoten.rtree.Entry<java.lang.Object, T> t) {
				collection.add(t);
				request(1);
			}
		};
	}

	private void testBuiltTree(com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree) {
		for (int i = 1; i <= 1000; i++) {
			tree = tree.add(i, com.github.davidmoten.rtree.geometry.Geometries.point(i, i));
		}
		org.junit.Assert.assertEquals(1000, ((int) (tree.entries().count().toBlocking().single())));
	}

	private static com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> create(int maxChildren, int n) {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(maxChildren).create();
		for (int i = 1; i <= n; i++) {
			tree = tree.add(com.github.davidmoten.rtree.RTreeTest.e(i));
		}
		return tree;
	}

	@org.junit.Test
	public void testNearestSameDirection() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(com.github.davidmoten.rtree.RTreeTest.e(1)).add(com.github.davidmoten.rtree.RTreeTest.e(2)).add(com.github.davidmoten.rtree.RTreeTest.e(3)).add(com.github.davidmoten.rtree.RTreeTest.e(10)).add(com.github.davidmoten.rtree.RTreeTest.e(11));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> list = tree.nearest(com.github.davidmoten.rtree.RTreeTest.r(9), 10, 2).toList().toBlocking().single();
		org.junit.Assert.assertEquals(2, list.size());
		java.lang.System.out.println(list);
		org.junit.Assert.assertEquals(10, list.get(0).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
		org.junit.Assert.assertEquals(11, list.get(1).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>> list2 = tree.nearest(com.github.davidmoten.rtree.RTreeTest.r(10), 8, 3).toList().toBlocking().single();
		org.junit.Assert.assertEquals(2, list2.size());
		org.junit.Assert.assertEquals(10, list2.get(1).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
		org.junit.Assert.assertEquals(11, list2.get(0).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
	}

	@org.junit.Test
	public void testNearestDifferentDirections() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).create().add(com.github.davidmoten.rtree.RTreeTest.e(1)).add(com.github.davidmoten.rtree.RTreeTest.e(2)).add(com.github.davidmoten.rtree.RTreeTest.e(3)).add(com.github.davidmoten.rtree.RTreeTest.e(9)).add(com.github.davidmoten.rtree.RTreeTest.e(10));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = tree.nearest(com.github.davidmoten.rtree.RTreeTest.r(6), 10, 2).toList().toBlocking().single();
		org.junit.Assert.assertEquals(2, list.size());
		org.junit.Assert.assertEquals(3, list.get(0).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
		org.junit.Assert.assertEquals(9, list.get(1).geometry().mbr().x1(), com.github.davidmoten.rtree.RTreeTest.PRECISION);
	}

	@org.junit.Test
	public void testNearestToAPoint() {
		java.lang.Object value = new java.lang.Object();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(value, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = tree.nearest(com.github.davidmoten.rtree.geometry.Geometries.point(2, 2), 3, 2).toList().toBlocking().single();
		org.junit.Assert.assertEquals(1, list.size());
		org.junit.Assert.assertEquals(value, list.get(0).value());
	}

	@org.junit.Test
	public void testNearestReturnsInOrder() {
		java.lang.Object value = new java.lang.Object();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(value, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(value, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(value, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3)).add(value, com.github.davidmoten.rtree.geometry.Geometries.point(4, 4));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> list = tree.nearest(com.github.davidmoten.rtree.geometry.Geometries.point(0, 0), 10, 10).toList().toBlocking().single();
		java.lang.System.out.println(list);
		org.junit.Assert.assertEquals(4, list.size());
		org.junit.Assert.assertEquals(com.github.davidmoten.rtree.geometry.Geometries.point(1, 1), list.get(0).geometry());
		org.junit.Assert.assertEquals(com.github.davidmoten.rtree.geometry.Geometries.point(2, 2), list.get(1).geometry());
		org.junit.Assert.assertEquals(com.github.davidmoten.rtree.geometry.Geometries.point(3, 3), list.get(2).geometry());
		org.junit.Assert.assertEquals(com.github.davidmoten.rtree.geometry.Geometries.point(4, 4), list.get(3).geometry());
	}

	@org.junit.Test
	public void testNearestHonoursUnsubscribeJustBeforeCompletion() {
		java.lang.Object value = new java.lang.Object();
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create().add(value, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		final java.util.concurrent.atomic.AtomicBoolean completeCalled = new java.util.concurrent.atomic.AtomicBoolean(false);
		tree.nearest(com.github.davidmoten.rtree.geometry.Geometries.point(0, 0), 10, 10).subscribe(new rx.Subscriber<java.lang.Object>() {
			@java.lang.Override
			public void onCompleted() {
				completeCalled.set(true);
			}

			@java.lang.Override
			public void onError(java.lang.Throwable e) {
			}

			@java.lang.Override
			public void onNext(java.lang.Object t) {
				unsubscribe();
			}
		});
		org.junit.Assert.assertFalse(completeCalled.get());
	}

	@org.junit.Test
	public void testVisualizer() {
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>> entries = com.github.davidmoten.rtree.RTreeTest.createRandomEntries(1000);
		int maxChildren = 8;
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.maxChildren(maxChildren).create().add(entries);
		tree.visualize(600, 600).save("target/tree.png");
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree2 = com.github.davidmoten.rtree.RTree.star().maxChildren(maxChildren).create().add(entries);
		tree2.visualize(600, 600).save("target/tree2.png");
	}

	@org.junit.Test(expected = java.lang.RuntimeException.class)
	public void testSplitterRStarThrowsExceptionOnEmptyList() {
		com.github.davidmoten.rtree.SplitterRStar spl = new com.github.davidmoten.rtree.SplitterRStar();
		spl.split(java.util.Collections.<com.github.davidmoten.rtree.geometry.HasGeometry>emptyList(), 4);
	}

	@org.junit.Test
	public void testSearchOnGreekDataUsingFlatBuffersFactory() {
	}

	@org.junit.Test
	public void testVisualizerWithGreekData() {
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Point>> entries = com.github.davidmoten.rtree.GreekEarthquakes.entriesList();
		int maxChildren = 8;
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.maxChildren(maxChildren).factory(new com.github.davidmoten.rtree.fbs.FactoryFlatBuffers<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>(new rx.functions.Func1<java.lang.Object, byte[]>() {
			@java.lang.Override
			public byte[] call(java.lang.Object o) {
				return "boo".getBytes();
			}
		}, new rx.functions.Func1<byte[], java.lang.Object>() {
			@java.lang.Override
			public java.lang.Object call(byte[] t) {
				return new java.lang.String(t);
			}
		})).<java.lang.Object, com.github.davidmoten.rtree.geometry.Point>create().add(entries);
		tree.visualize(2000, 2000).save("target/greek.png");
		int found = tree.search(com.github.davidmoten.rtree.geometry.Geometries.rectangle(40, 27.0, 40.5, 27.5)).count().toBlocking().single();
		java.lang.System.out.println("found=" + found);
		org.junit.Assert.assertEquals(22, found);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Point> tree2 = com.github.davidmoten.rtree.RTree.maxChildren(maxChildren).star().<java.lang.Object, com.github.davidmoten.rtree.geometry.Point>create().add(entries);
		tree2.visualize(2000, 2000).save("target/greek2.png");
	}

	@org.junit.Test
	public void testDeleteOneFromOne() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(e1).delete(e1);
		org.junit.Assert.assertEquals(0, ((int) (tree.entries().count().toBlocking().single())));
	}

	@org.junit.Test
	public void testDeleteOneFromTreeWithDepthGreaterThanOne() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(4).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(e1).add(com.github.davidmoten.rtree.RTreeTest.e(2)).add(com.github.davidmoten.rtree.RTreeTest.e(3)).add(com.github.davidmoten.rtree.RTreeTest.e(4)).add(com.github.davidmoten.rtree.RTreeTest.e(5)).add(com.github.davidmoten.rtree.RTreeTest.e(6)).add(com.github.davidmoten.rtree.RTreeTest.e(7)).add(com.github.davidmoten.rtree.RTreeTest.e(8)).add(com.github.davidmoten.rtree.RTreeTest.e(9)).add(com.github.davidmoten.rtree.RTreeTest.e(10)).delete(e1);
		org.junit.Assert.assertEquals(9, ((int) (tree.entries().count().toBlocking().single())));
		org.junit.Assert.assertFalse(tree.entries().contains(e1).toBlocking().single());
	}

	@org.junit.Test
	public void testDeleteOneFromLargeTreeThenDeleteAllAndEnsureEmpty() {
		int n = 10000;
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTreeTest.createRandomRTree(n).add(com.github.davidmoten.rtree.RTreeTest.e(1)).add(com.github.davidmoten.rtree.RTreeTest.e(2)).delete(com.github.davidmoten.rtree.RTreeTest.e(1));
		org.junit.Assert.assertEquals(n + 1, ((int) (tree.entries().count().toBlocking().single())));
		org.junit.Assert.assertFalse(tree.entries().contains(com.github.davidmoten.rtree.RTreeTest.e(1)).toBlocking().single());
		org.junit.Assert.assertTrue(tree.entries().contains(com.github.davidmoten.rtree.RTreeTest.e(2)).toBlocking().single());
		n++;
		org.junit.Assert.assertEquals(n, tree.size());
		for (com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> entry : tree.entries().toBlocking().toIterable()) {
			tree = tree.delete(entry);
			n--;
			org.junit.Assert.assertEquals(n, tree.size());
		}
		org.junit.Assert.assertEquals(0, ((int) (tree.entries().count().toBlocking().single())));
		org.junit.Assert.assertTrue(tree.isEmpty());
	}

	@org.junit.Test
	public void testDeleteOnlyDeleteOneIfThereAreMoreThanMaxChildren() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		int count = com.github.davidmoten.rtree.RTree.maxChildren(4).create().add(e1).add(e1).add(e1).add(e1).add(e1).delete(e1).search(e1.geometry().mbr()).count().toBlocking().single();
		org.junit.Assert.assertEquals(4, count);
	}

	@org.junit.Test
	public void testDeleteAllIfThereAreMoreThanMaxChildren() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		int count = com.github.davidmoten.rtree.RTree.maxChildren(4).create().add(e1).add(e1).add(e1).add(e1).add(e1).delete(e1, true).search(e1.geometry().mbr()).count().toBlocking().single();
		org.junit.Assert.assertEquals(0, count);
	}

	@org.junit.Test
	public void testDeleteItemThatIsNotPresentDoesNothing() {
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e1 = com.github.davidmoten.rtree.RTreeTest.e(1);
		com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e2 = com.github.davidmoten.rtree.RTreeTest.e(2);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(e1);
		org.junit.Assert.assertTrue(tree == tree.delete(e2));
	}

	@org.junit.Test
	public void testExampleOnReadMe() {
		com.github.davidmoten.rtree.RTree<java.lang.String, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.maxChildren(5).create();
		tree = tree.add(com.github.davidmoten.rtree.Entries.entry("DAVE", com.github.davidmoten.rtree.geometry.Geometries.point(10, 20))).add(com.github.davidmoten.rtree.Entries.entry("FRED", com.github.davidmoten.rtree.geometry.Geometries.point(12, 25))).add(com.github.davidmoten.rtree.Entries.entry("MARY", com.github.davidmoten.rtree.geometry.Geometries.point(97, 125)));
	}

	@org.junit.Test(timeout = 2000)
	public void testUnsubscribe() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTreeTest.createRandomRTree(1000);
		org.junit.Assert.assertEquals(0, ((int) (tree.entries().take(0).count().toBlocking().single())));
	}

	@org.junit.Test
	public void testSearchConditionAlwaysFalse() {
		@java.lang.SuppressWarnings("unchecked")
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = ((com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>) ((com.github.davidmoten.rtree.RTree<?, ?>) (com.github.davidmoten.rtree.RTreeTest.create(3, 3))));
		org.junit.Assert.assertEquals(0, ((int) (tree.search(com.github.davidmoten.rx.Functions.alwaysFalse()).count().toBlocking().single())));
	}

	@org.junit.Test
	public void testAddOverload() {
		@java.lang.SuppressWarnings("unchecked")
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = ((com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>) ((com.github.davidmoten.rtree.RTree<?, ?>) (com.github.davidmoten.rtree.RTreeTest.create(3, 0))));
		tree = tree.add(123, com.github.davidmoten.rtree.geometry.Geometries.point(1, 2));
		org.junit.Assert.assertEquals(1, ((int) (tree.entries().count().toBlocking().single())));
	}

	@org.junit.Test
	public void testDeleteOverload() {
		@java.lang.SuppressWarnings("unchecked")
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = ((com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry>) ((com.github.davidmoten.rtree.RTree<?, ?>) (com.github.davidmoten.rtree.RTreeTest.create(3, 0))));
		tree = tree.add(123, com.github.davidmoten.rtree.geometry.Geometries.point(1, 2)).delete(123, com.github.davidmoten.rtree.geometry.Geometries.point(1, 2));
		org.junit.Assert.assertEquals(0, ((int) (tree.entries().count().toBlocking().single())));
	}

	@org.junit.Test
	public void testStandardRTreeSearch() {
		com.github.davidmoten.rtree.geometry.Rectangle r = com.github.davidmoten.rtree.geometry.Geometries.rectangle(13.0, 23.0, 50.0, 80.0);
		com.github.davidmoten.rtree.geometry.Point[] points = new com.github.davidmoten.rtree.geometry.Point[]{ com.github.davidmoten.rtree.geometry.Geometries.point(59.0, 91.0), com.github.davidmoten.rtree.geometry.Geometries.point(86.0, 14.0), com.github.davidmoten.rtree.geometry.Geometries.point(36.0, 60.0), com.github.davidmoten.rtree.geometry.Geometries.point(57.0, 36.0), com.github.davidmoten.rtree.geometry.Geometries.point(14.0, 37.0) };
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		for (int i = 0; i < points.length; i++) {
			com.github.davidmoten.rtree.geometry.Point point = points[i];
			java.lang.System.out.println((((("point(" + point.x()) + ",") + point.y()) + "), value=") + (i + 1));
			tree = tree.add(i + 1, point);
		}
		java.lang.System.out.println(tree.asString());
		java.lang.System.out.println("searching " + r);
		java.util.Set<java.lang.Integer> set = new java.util.HashSet<java.lang.Integer>(tree.search(r).map(com.github.davidmoten.rtree.RTreeTest.<java.lang.Integer>toValue()).toList().toBlocking().single());
		org.junit.Assert.assertEquals(new java.util.HashSet<java.lang.Integer>(java.util.Arrays.asList(3, 5)), set);
	}

	@org.junit.Test
	public void testStandardRTreeSearch2() {
		com.github.davidmoten.rtree.geometry.Rectangle r = com.github.davidmoten.rtree.geometry.Geometries.rectangle(10.0, 10.0, 50.0, 50.0);
		com.github.davidmoten.rtree.geometry.Point[] points = new com.github.davidmoten.rtree.geometry.Point[]{ com.github.davidmoten.rtree.geometry.Geometries.point(28.0, 19.0), com.github.davidmoten.rtree.geometry.Geometries.point(29.0, 4.0), com.github.davidmoten.rtree.geometry.Geometries.point(10.0, 63.0), com.github.davidmoten.rtree.geometry.Geometries.point(34.0, 85.0), com.github.davidmoten.rtree.geometry.Geometries.point(62.0, 45.0) };
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		for (int i = 0; i < points.length; i++) {
			com.github.davidmoten.rtree.geometry.Point point = points[i];
			java.lang.System.out.println((((("point(" + point.x()) + ",") + point.y()) + "), value=") + (i + 1));
			tree = tree.add(i + 1, point);
		}
		java.lang.System.out.println(tree.asString());
		java.lang.System.out.println("searching " + r);
		java.util.Set<java.lang.Integer> set = new java.util.HashSet<java.lang.Integer>(tree.search(r).map(com.github.davidmoten.rtree.RTreeTest.<java.lang.Integer>toValue()).toList().toBlocking().single());
		org.junit.Assert.assertEquals(new java.util.HashSet<java.lang.Integer>(java.util.Arrays.asList(1)), set);
	}

	@org.junit.Test
	public void testStarTreeReturnsSameAsStandardRTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree1 = com.github.davidmoten.rtree.RTree.create();
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree2 = com.github.davidmoten.rtree.RTree.star().create();
		com.github.davidmoten.rtree.geometry.Rectangle[] testRects = new com.github.davidmoten.rtree.geometry.Rectangle[]{ com.github.davidmoten.rtree.geometry.Geometries.rectangle(0, 0, 0, 0), com.github.davidmoten.rtree.geometry.Geometries.rectangle(0, 0, 100, 100), com.github.davidmoten.rtree.geometry.Geometries.rectangle(0, 0, 10, 10), com.github.davidmoten.rtree.geometry.Geometries.rectangle(0.12, 0.25, 50.356, 50.756), com.github.davidmoten.rtree.geometry.Geometries.rectangle(1, 0.252, 50, 69.23), com.github.davidmoten.rtree.geometry.Geometries.rectangle(13.12, 23.123, 50.45, 80.9), com.github.davidmoten.rtree.geometry.Geometries.rectangle(10, 10, 50, 50) };
		for (int i = 1; i <= 10000; i++) {
			com.github.davidmoten.rtree.geometry.Point point = com.github.davidmoten.rtree.RTreeTest.nextPoint();
			tree1 = tree1.add(i, point);
			tree2 = tree2.add(i, point);
		}
		for (com.github.davidmoten.rtree.geometry.Rectangle r : testRects) {
			java.util.Set<java.lang.Integer> res1 = new java.util.HashSet<java.lang.Integer>(tree1.search(r).map(com.github.davidmoten.rtree.RTreeTest.<java.lang.Integer>toValue()).toList().toBlocking().single());
			java.util.Set<java.lang.Integer> res2 = new java.util.HashSet<java.lang.Integer>(tree2.search(r).map(com.github.davidmoten.rtree.RTreeTest.<java.lang.Integer>toValue()).toList().toBlocking().single());
			org.junit.Assert.assertEquals(res1.size(), res2.size());
		}
	}

	@org.junit.Test
	public void testUnsubscribeWhileIteratingLeafNode() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(5).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(com.github.davidmoten.rtree.RTreeTest.e(1)).add(com.github.davidmoten.rtree.RTreeTest.e(2));
		tree.entries().subscribe(new rx.Subscriber<java.lang.Object>() {
			@java.lang.Override
			public void onCompleted() {
			}

			@java.lang.Override
			public void onError(java.lang.Throwable e) {
			}

			@java.lang.Override
			public void onNext(java.lang.Object t) {
				unsubscribe();
			}
		});
	}

	@org.junit.Test
	public void testUnsubscribeWhileIteratingNonLeafNode() {
		final java.util.concurrent.atomic.AtomicBoolean completed = new java.util.concurrent.atomic.AtomicBoolean(false);
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.maxChildren(3).<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>create().add(com.github.davidmoten.rtree.RTreeTest.e(1)).add(com.github.davidmoten.rtree.RTreeTest.e(2)).add(com.github.davidmoten.rtree.RTreeTest.e(3)).add(com.github.davidmoten.rtree.RTreeTest.e(4));
		tree.entries().subscribe(new rx.Subscriber<java.lang.Object>() {
			@java.lang.Override
			public void onCompleted() {
				completed.set(true);
			}

			@java.lang.Override
			public void onError(java.lang.Throwable e) {
			}

			@java.lang.Override
			public void onNext(java.lang.Object t) {
				unsubscribe();
			}
		});
		org.junit.Assert.assertFalse(completed.get());
	}

	@org.junit.Test
	public void testSearchWithIntersectsRectangleFunction() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Rectangle> tree = com.github.davidmoten.rtree.RTree.create();
		tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(0, 0, 1), com.github.davidmoten.rtree.geometry.Intersects.rectangleIntersectsCircle);
	}

	@org.junit.Test
	public void testSearchWithIntersectsPointFunctionReturnsOne() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(0, 0));
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> entries = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(0, 0, 1), com.github.davidmoten.rtree.geometry.Intersects.pointIntersectsCircle);
		org.junit.Assert.assertEquals(1, ((int) (entries.count().toBlocking().single())));
	}

	@org.junit.Test
	public void testSearchWithIntersectsPointFunctionReturnsNone() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(10, 10));
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> entries = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(0, 0, 1), com.github.davidmoten.rtree.geometry.Intersects.pointIntersectsCircle);
		org.junit.Assert.assertEquals(0, ((int) (entries.count().toBlocking().single())));
	}

	@org.junit.Test
	public void testSearchWithDistanceFunctionIntersectsMbrButNotActualGeometry() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(0, 0)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> entries = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(0, 0, 1), 0.1, com.github.davidmoten.rtree.RTreeTest.distanceCircleToPoint);
		org.junit.Assert.assertEquals(1, ((int) (entries.count().toBlocking().single())));
	}

	@org.junit.Test
	public void testSearchWithDistanceFunctionIntersectsMbrAndActualGeometry() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(0, 0)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> entries = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(0, 0, 1), 0.5, com.github.davidmoten.rtree.RTreeTest.distanceCircleToPoint);
		org.junit.Assert.assertEquals(2, ((int) (entries.count().toBlocking().single())));
	}

	@org.junit.Test
	public void testSearchWithDistanceFunctionIntersectsNothing() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(0, 0)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1));
		rx.Observable<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> entries = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(10, 10, 1), 0.5, com.github.davidmoten.rtree.RTreeTest.distanceCircleToPoint);
		org.junit.Assert.assertEquals(0, ((int) (entries.count().toBlocking().single())));
	}

	@org.junit.Test
	public void calculateDepthOfEmptyTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		org.junit.Assert.assertEquals(0, tree.calculateDepth());
	}

	@org.junit.Test
	public void calculateAsStringOfEmptyTree() {
		com.github.davidmoten.rtree.RTree<java.lang.Object, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.create();
		org.junit.Assert.assertEquals("", tree.asString());
	}

	@org.junit.Test
	public void testForMeiZhao() {
		for (int minChildren = 1; minChildren <= 2; minChildren++) {
			com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.maxChildren(3).minChildren(minChildren).<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 9)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 10)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(4, 8)).add(4, com.github.davidmoten.rtree.geometry.Geometries.point(6, 7)).add(5, com.github.davidmoten.rtree.geometry.Geometries.point(9, 10)).add(6, com.github.davidmoten.rtree.geometry.Geometries.point(7, 5)).add(7, com.github.davidmoten.rtree.geometry.Geometries.point(5, 6)).add(8, com.github.davidmoten.rtree.geometry.Geometries.point(4, 3)).add(9, com.github.davidmoten.rtree.geometry.Geometries.point(3, 2)).add(10, com.github.davidmoten.rtree.geometry.Geometries.point(9, 1)).add(11, com.github.davidmoten.rtree.geometry.Geometries.point(10, 4)).add(12, com.github.davidmoten.rtree.geometry.Geometries.point(6, 2)).add(13, com.github.davidmoten.rtree.geometry.Geometries.point(8, 3));
			java.lang.System.out.println(tree.asString());
		}
	}

	@org.junit.Test
	public void testSearchWithCircleFindsCentreOnly() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(2, 2, 1)).toList().toBlocking().single();
		org.junit.Assert.assertEquals(1, list.size());
		org.junit.Assert.assertEquals(2, ((int) (list.get(0).value())));
	}

	@org.junit.Test
	public void testSearchWithCircleFindsAll() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.circle(2, 2, 1.5)).toList().toBlocking().single();
		org.junit.Assert.assertEquals(3, list.size());
	}

	@org.junit.Test
	public void testSearchWithLineFindsAll() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.line(0, 0, 4, 4)).toList().toBlocking().single();
		org.junit.Assert.assertEquals(3, list.size());
	}

	@org.junit.Test
	public void testSearchWithLineFindsOne() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.line(1.5, 1.5, 2.5, 2.5)).toList().toBlocking().single();
		org.junit.Assert.assertEquals(1, list.size());
		org.junit.Assert.assertEquals(2, ((int) (list.get(0).value())));
	}

	@org.junit.Test
	public void testSearchWithLineFindsNone() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point> tree = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).add(3, com.github.davidmoten.rtree.geometry.Geometries.point(3, 3));
		java.util.List<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>> list = tree.search(com.github.davidmoten.rtree.geometry.Geometries.line(1.5, 1.5, 2.6, 2.5)).toList().toBlocking().single();
		java.lang.System.out.println(list);
		org.junit.Assert.assertEquals(0, list.size());
	}

	@org.junit.Test
	public void testRTreeRootMbrWhenRTreeEmpty() {
		org.junit.Assert.assertFalse(com.github.davidmoten.rtree.RTree.create().mbr().isPresent());
	}

	@org.junit.Test
	public void testRTreeRootMbrWhenRTreeNonEmpty() {
		com.github.davidmoten.guavamini.Optional<com.github.davidmoten.rtree.geometry.Rectangle> r = com.github.davidmoten.rtree.RTree.<java.lang.Integer, com.github.davidmoten.rtree.geometry.Point>create().add(1, com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)).add(2, com.github.davidmoten.rtree.geometry.Geometries.point(2, 2)).mbr();
		org.junit.Assert.assertEquals(com.github.davidmoten.rtree.geometry.Geometries.rectangle(1, 1, 2, 2), r.get());
	}

	@org.junit.Test
	public void testIntersectsPointLine() {
		org.junit.Assert.assertTrue(Intersects.lineIntersectsPoint.call(com.github.davidmoten.rtree.geometry.Geometries.line(1, 1, 2, 2), com.github.davidmoten.rtree.geometry.Geometries.point(1, 1)));
	}

	@org.junit.Test(timeout = 30000000)
	public void testGroupByIssue40() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.star().create();
		tree = tree.add(1, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(2, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(3, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(4, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(5, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(6, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		com.github.davidmoten.rtree.geometry.Rectangle rectangle = com.github.davidmoten.rtree.geometry.Geometries.rectangle(12.9, 51.9, 13.1, 52.1);
		org.junit.Assert.assertEquals(java.lang.Integer.valueOf(2), tree.search(rectangle).doOnRequest(new rx.functions.Action1<java.lang.Long>() {
			@java.lang.Override
			public void call(java.lang.Long n) {
				java.lang.System.out.println("requestFromGroupBy=" + n);
			}
		}).groupBy(new rx.functions.Func1<com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry>, java.lang.Boolean>() {
			@java.lang.Override
			public java.lang.Boolean call(com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> entry) {
				java.lang.System.out.println(entry);
				return (entry.value() % 2) == 0;
			}
		}).doOnRequest(new rx.functions.Action1<java.lang.Long>() {
			@java.lang.Override
			public void call(java.lang.Long n) {
				java.lang.System.out.println("requestFromFlatMap=" + n);
			}
		}).flatMap(new rx.functions.Func1<rx.observables.GroupedObservable<java.lang.Boolean, com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry>>, rx.Observable<java.lang.Integer>>() {
			@java.lang.Override
			public rx.Observable<java.lang.Integer> call(rx.observables.GroupedObservable<java.lang.Boolean, com.github.davidmoten.rtree.Entry<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry>> group) {
				return group.count();
			}
		}).count().toBlocking().single());
	}

	@org.junit.Test
	public void testBackpressureForOverflow() {
		com.github.davidmoten.rtree.RTree<java.lang.Integer, com.github.davidmoten.rtree.geometry.Geometry> tree = com.github.davidmoten.rtree.RTree.star().create();
		tree = tree.add(1, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(2, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(3, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(4, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(5, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		tree = tree.add(6, com.github.davidmoten.rtree.geometry.Geometries.point(13.0, 52.0));
		final java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger();
		com.github.davidmoten.rtree.geometry.Rectangle rectangle = com.github.davidmoten.rtree.geometry.Geometries.rectangle(12.9, 51.9, 13.1, 52.1);
		tree.search(rectangle).subscribe(new rx.Subscriber<java.lang.Object>() {
			@java.lang.Override
			public void onStart() {
				request(4);
			}

			@java.lang.Override
			public void onCompleted() {
			}

			@java.lang.Override
			public void onError(java.lang.Throwable e) {
			}

			@java.lang.Override
			public void onNext(java.lang.Object t) {
				request(java.lang.Long.MAX_VALUE);
				count.incrementAndGet();
			}
		});
		org.junit.Assert.assertEquals(6, count.get());
		org.junit.Assert.assertEquals(6, ((int) (tree.search(rectangle).count().toBlocking().single())));
	}

	private static rx.functions.Func2<com.github.davidmoten.rtree.geometry.Point, com.github.davidmoten.rtree.geometry.Circle, java.lang.Double> distanceCircleToPoint = new rx.functions.Func2<com.github.davidmoten.rtree.geometry.Point, com.github.davidmoten.rtree.geometry.Circle, java.lang.Double>() {
		@java.lang.Override
		public java.lang.Double call(com.github.davidmoten.rtree.geometry.Point point, com.github.davidmoten.rtree.geometry.Circle circle) {
			return circle.distance(point.mbr());
		}
	};

	private static <T> rx.functions.Func1<com.github.davidmoten.rtree.Entry<T, ?>, T> toValue() {
		return new rx.functions.Func1<com.github.davidmoten.rtree.Entry<T, ?>, T>() {
			@java.lang.Override
			public T call(com.github.davidmoten.rtree.Entry<T, ?> entry) {
				return entry.value();
			}
		};
	}

	private static com.github.davidmoten.rtree.geometry.Point nextPoint() {
		double randomX = java.lang.Math.round(java.lang.Math.random() * 100);
		double randomY = java.lang.Math.round(java.lang.Math.random() * 100);
		return com.github.davidmoten.rtree.geometry.Geometries.point(randomX, randomY);
	}

	static com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e(int n) {
		return com.github.davidmoten.rtree.Entries.<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>entry(n, com.github.davidmoten.rtree.RTreeTest.r(n));
	}

	static com.github.davidmoten.rtree.Entry<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle> e2(int n) {
		return com.github.davidmoten.rtree.Entries.<java.lang.Object, com.github.davidmoten.rtree.geometry.Rectangle>entry(n, com.github.davidmoten.rtree.RTreeTest.r(n - 1));
	}

	private static com.github.davidmoten.rtree.geometry.Rectangle r(int n) {
		return com.github.davidmoten.rtree.geometry.Geometries.rectangle(n, n, n + 1, n + 1);
	}

	private static com.github.davidmoten.rtree.geometry.Rectangle r(double n, double m) {
		return com.github.davidmoten.rtree.geometry.Geometries.rectangle(n, m, n + 1, m + 1);
	}

	static com.github.davidmoten.rtree.geometry.Rectangle random() {
		return com.github.davidmoten.rtree.RTreeTest.r(java.lang.Math.random() * 1000, java.lang.Math.random() * 1000);
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(java.lang.Long.MAX_VALUE);
	}
}