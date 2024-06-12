public class TablePreSplitter {
	org.apache.hadoop.conf.Configuration conf;

	public static final java.lang.String usage = "tablepresplit commands ...\n" + (("  help - print this message and exit.\n" + "  create - create a new table with the provided start key, end key and number of splits.\n") + "     syntax: create <tableName> <familyName> <start key> <end key> <number of splits>\n");

	public TablePreSplitter() {
		conf = org.apache.hadoop.hbase.HBaseConfiguration.create();
	}

	public boolean createPreSplitTable(java.lang.String tableName, java.lang.String family, java.lang.String startKey, java.lang.String endKey, int splits) throws java.io.IOException {
		java.util.List<java.lang.String> l = new java.util.ArrayList<java.lang.String>();
		l.add(family);
		return createPreSplitTable(tableName, l, startKey, endKey, splits);
	}

	public boolean createPreSplitTable(java.lang.String tableName, java.util.List<java.lang.String> families, java.lang.String startKey, java.lang.String endKey, int splits) throws java.io.IOException {
		org.apache.hadoop.hbase.client.HBaseAdmin admin = new org.apache.hadoop.hbase.client.HBaseAdmin(conf);
		byte[] table = org.apache.hadoop.hbase.util.Bytes.toBytes(tableName);
		byte[] start = org.apache.hadoop.hbase.util.Bytes.toBytes(startKey);
		byte[] end = org.apache.hadoop.hbase.util.Bytes.toBytes(endKey);
		org.apache.hadoop.hbase.HTableDescriptor desc = new org.apache.hadoop.hbase.HTableDescriptor(table);
		for (java.lang.String f : families) {
			org.apache.hadoop.hbase.HColumnDescriptor col = new org.apache.hadoop.hbase.HColumnDescriptor(f);
			desc.addFamily(col);
		}
		admin.createTable(desc, start, end, splits);
		return admin.tableExists(table) && (admin.getTableRegions(table).size() == splits);
	}

	public static void main(java.lang.String[] args) {
		if ((args.length == 0) || "help".equals(args[0])) {
			java.lang.System.out.println(utils.TablePreSplitter.usage);
			java.lang.System.exit(0);
		}
		if ("create".equals(args[0])) {
			utils.TablePreSplitter mysplitter = new utils.TablePreSplitter();
			java.lang.String tableName = args[1];
			java.lang.String familyName = args[2];
			java.lang.String startKey = args[3];
			java.lang.String endKey = args[4];
			int numOfSplits = java.lang.Integer.parseInt(args[5]);
			try {
				boolean status = mysplitter.createPreSplitTable(tableName, familyName, startKey, endKey, numOfSplits);
				if (status) {
					java.lang.System.out.println("Table created successfully.");
				} else {
					java.lang.System.out.println("Table creation failed.");
				}
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
	}
}