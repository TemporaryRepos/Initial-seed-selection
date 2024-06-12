public class LongConversionExampleA {
	static {
		net.openhft.chronicle.core.pool.ClassAliasPool.CLASS_ALIASES.addAlias(net.openhft.chronicle.wire.LongConversionExampleA.House.class);
	}

	public static class House {
		@net.openhft.chronicle.wire.converter.Base64
		long owner;

		public void owner(java.lang.CharSequence owner) {
			this.owner = Base64LongConverter.INSTANCE.parse(owner);
		}

		@java.lang.Override
		public java.lang.String toString() {
			return (("House{" + "owner=") + owner) + '}';
		}
	}

	public static void main(java.lang.String[] args) {
		net.openhft.chronicle.wire.LongConversionExampleA.House house = new net.openhft.chronicle.wire.LongConversionExampleA.House();
		house.owner("Bill");
		java.lang.System.out.println(house);
	}
}