public class Compact {
	static {
		org.apache.cassandra.config.DatabaseDescriptor.clientInitialization(false);
	}

	protected java.util.Collection<org.apache.cassandra.io.sstable.format.SSTableReader> sstables = com.google.common.collect.Sets.newHashSet();

	protected org.apache.cassandra.config.CFMetaData metadata;

	public Compact(java.lang.String... args) {
		for (java.lang.String path : args) {
			try {
				for (java.io.File f : com.csforge.sstable.CassandraUtils.sstablesFromPath(path)) {
					if (metadata == null) {
						metadata = com.csforge.sstable.CassandraUtils.tableFromSSTable(f);
					}
					org.apache.cassandra.io.sstable.Descriptor d = org.apache.cassandra.io.sstable.Descriptor.fromFilename(f.getAbsolutePath());
					sstables.add(org.apache.cassandra.io.sstable.format.SSTableReader.openNoValidation(d, metadata));
				}
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		try {
			org.apache.cassandra.io.sstable.Descriptor desc = new org.apache.cassandra.io.sstable.Descriptor(org.apache.cassandra.io.sstable.format.SSTableFormat.Type.BIG.info.getLatestVersion(), new java.io.File("."), "keyspace", "table", 0, org.apache.cassandra.io.sstable.format.SSTableFormat.Type.BIG, org.apache.cassandra.io.sstable.Component.digestFor(org.apache.cassandra.io.sstable.format.big.BigFormat.latestVersion.uncompressedChecksumType()));
			org.apache.cassandra.io.sstable.SSTableTxnWriter out = org.apache.cassandra.io.sstable.SSTableTxnWriter.create(metadata, desc, 0, org.apache.cassandra.service.ActiveRepairService.UNREPAIRED_SSTABLE, 0, org.apache.cassandra.db.SerializationHeader.make(metadata, sstables), java.util.Collections.emptySet());
			java.lang.System.out.println((("Merging " + sstables.size()) + " sstables to ") + desc.filenameFor(org.apache.cassandra.io.sstable.Component.DATA));
			org.apache.cassandra.db.partitions.UnfilteredPartitionIterator merged = org.apache.cassandra.db.partitions.UnfilteredPartitionIterators.mergeLazily(sstables.stream().map(org.apache.cassandra.io.sstable.format.SSTableReader::getScanner).collect(java.util.stream.Collectors.toList()), org.apache.cassandra.utils.FBUtilities.nowInSeconds());
			while (merged.hasNext()) {
				out.append(merged.next());
			} 
			out.finish(false);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(java.lang.String... args) {
		if (args.length == 0) {
			java.lang.System.err.println("Usage: java -jar sstable-tools.jar compact [sstable ...]");
		} else {
			new com.csforge.sstable.Compact(args).run();
		}
	}
}