public class FloatContent {
	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(java.lang.Float.MAX_VALUE)));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(java.lang.Double.MAX_VALUE)));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toFloat(new byte[]{ 127, ((byte) (0xff)), ((byte) (0xff)), ((byte) (0xff)) }));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(-12.5F)));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(java.nio.ByteBuffer.allocate(4).putFloat(-12.5F).array()));
		java.lang.System.out.println();
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(17.625F)));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(java.nio.ByteBuffer.allocate(4).putFloat(17.625F).array()));
		java.lang.System.out.println();
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(6.9F)));
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toBinary(cn.ponfee.commons.util.Bytes.toBytes(0.9F)));
		java.lang.System.out.println();
		java.lang.System.out.println(java.nio.ByteOrder.nativeOrder());
		java.lang.System.out.println(cn.ponfee.commons.util.Bytes.toFloat(new byte[]{ 0, 0, 0, 127, 0, 0, 0, 0 }));
		java.lang.System.out.println(0x1.0p-3F);
		java.lang.System.out.println(0x1.2p-4F);
	}
}