public class Examples {
	public static void main(java.lang.String[] args) {
		org.zoodb.index.critbit.Examples.ex1D_32();
		org.zoodb.index.critbit.Examples.ex1D_float();
		org.zoodb.index.critbit.Examples.ex1D_256();
		org.zoodb.index.critbit.Examples.ex4D();
	}

	private static void ex1D_32() {
		org.zoodb.index.critbit.Examples.log("Testing 1D 32 bit tree");
		org.zoodb.index.critbit.Examples.log("======================");
		org.zoodb.index.critbit.CritBit1D<java.lang.String> cb = org.zoodb.index.critbit.CritBit.create1D(32);
		long[] key = new long[]{ 1234 };
		cb.put(key, "hello 32");
		org.zoodb.index.critbit.Examples.log("contains() --> " + cb.contains(key));
		org.zoodb.index.critbit.Examples.log("get() --> " + cb.get(key));
		long[] min = new long[]{ 123 };
		long[] max = new long[]{ 12345 };
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator val: " + it.next());
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it2 = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator key: " + it2.nextKey()[0]);
		org.zoodb.index.critbit.Examples.log("remove: " + cb.remove(key));
	}

	private static void ex1D_float() {
		org.zoodb.index.critbit.Examples.log("Testing 1D float tree");
		org.zoodb.index.critbit.Examples.log("=====================");
		org.zoodb.index.critbit.CritBit1D<java.lang.String> cb = org.zoodb.index.critbit.CritBit.create1D(64);
		long[] key = new long[]{ org.zoodb.index.critbit.BitTools.toSortableLong(12.34) };
		cb.put(key, "hello float");
		org.zoodb.index.critbit.Examples.log("contains() --> " + cb.contains(key));
		org.zoodb.index.critbit.Examples.log("get() --> " + cb.get(key));
		long[] min = new long[]{ org.zoodb.index.critbit.BitTools.toSortableLong(1.0) };
		long[] max = new long[]{ org.zoodb.index.critbit.BitTools.toSortableLong(15.0) };
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator val: " + it.next());
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it2 = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator key: " + org.zoodb.index.critbit.BitTools.toDouble(it2.nextKey()[0]));
		org.zoodb.index.critbit.Examples.log("remove: " + cb.remove(key));
	}

	private static void ex1D_256() {
		org.zoodb.index.critbit.Examples.log("Testing 1D 256 bit tree");
		org.zoodb.index.critbit.Examples.log("=======================");
		org.zoodb.index.critbit.CritBit1D<java.lang.String> cb = org.zoodb.index.critbit.CritBit.create1D(256);
		long[] key = new long[]{ 123456789012L, 3456, 4567, 12345678901234L };
		cb.put(key, "hello 256");
		org.zoodb.index.critbit.Examples.log("contains() --> " + cb.contains(key));
		org.zoodb.index.critbit.Examples.log("get() --> " + cb.get(key));
		long[] min = new long[]{ 0, 0, 0, 0 };
		long[] max = new long[]{ java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE };
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator val: " + it.next());
		org.zoodb.index.critbit.CritBit.QueryIterator<java.lang.String> it2 = cb.query(min, max);
		org.zoodb.index.critbit.Examples.log("iterator key: " + it2.nextKey()[0]);
		org.zoodb.index.critbit.Examples.log("remove: " + cb.remove(key));
	}

	private static void ex4D() {
		org.zoodb.index.critbit.Examples.log("Testing 4D tree");
		org.zoodb.index.critbit.Examples.log("===============");
		org.zoodb.index.critbit.CritBitKD<java.lang.String> cb = org.zoodb.index.critbit.CritBit.createKD(64, 4);
		long[] key = new long[]{ 123456789012L, 3456, org.zoodb.index.critbit.BitTools.toSortableLong(1234.5678), 12345678901234L };
		cb.putKD(key, "hello 4D");
		org.zoodb.index.critbit.Examples.log("contains() --> " + cb.containsKD(key));
		org.zoodb.index.critbit.Examples.log("get() --> " + cb.getKD(key));
		long[] min = new long[]{ 0, 0, org.zoodb.index.critbit.BitTools.toSortableLong(1.0), 0 };
		long[] max = new long[]{ java.lang.Long.MAX_VALUE, java.lang.Long.MAX_VALUE, org.zoodb.index.critbit.BitTools.toSortableLong(java.lang.Double.MAX_VALUE), java.lang.Long.MAX_VALUE };
		org.zoodb.index.critbit.CritBit.QueryIteratorKD<java.lang.String> it = cb.queryKD(min, max);
		org.zoodb.index.critbit.Examples.log("iterator val: " + it.next());
		org.zoodb.index.critbit.CritBit.QueryIteratorKD<java.lang.String> it2 = cb.queryKD(min, max);
		org.zoodb.index.critbit.Examples.log("iterator key: " + java.util.Arrays.toString(it2.nextKey()));
		org.zoodb.index.critbit.Examples.log("remove: " + cb.removeKD(key));
	}

	private static void log(java.lang.String msg) {
		java.lang.System.out.println(msg);
	}
}