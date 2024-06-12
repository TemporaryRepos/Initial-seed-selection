public class ApplicationTest {
	public static void main(java.lang.String[] args) {
		if (UserConfig.addressId.length() == 0) {
			java.lang.System.err.println("请先执行UserConfig获取配送地址id");
			return;
		}
		Api.allCheck();
		java.util.Map<java.lang.String, java.lang.Object> cartMap = Api.getCart(false);
		if (cartMap == null) {
			return;
		}
		java.util.Map<java.lang.String, java.lang.Object> multiReserveTimeMap = Api.getMultiReserveTime(UserConfig.addressId, cartMap);
		if (multiReserveTimeMap == null) {
			return;
		}
		java.util.Map<java.lang.String, java.lang.Object> checkOrderMap = Api.getCheckOrder(UserConfig.addressId, cartMap, multiReserveTimeMap);
		if (checkOrderMap == null) {
			return;
		}
		Api.addNewOrder(UserConfig.addressId, cartMap, multiReserveTimeMap, checkOrderMap);
	}
}