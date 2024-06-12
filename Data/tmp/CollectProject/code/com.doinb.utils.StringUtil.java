public class StringUtil {
	public static void main(java.lang.String[] args) {
		java.util.List<java.lang.String> addressList = java.util.Arrays.asList("湖北省武汉市洪山区", "湖北省恩施土家族苗族自治州恩施市", "北京市市辖区朝阳区", "内蒙古自治区兴安盟科尔沁右翼前旗", "西藏自治区日喀则地区日喀则市", "湖北省武汉市洪山区", "海南省三亚市吉阳区荔枝沟路", "香港特别行政区麻油地区", "海南省海口市老城高新技术产业示范区海南生态软件园A18幢三层201", "贵州省贵阳市南明区花果园E区福家乐超市", "中国海南省省直辖县级行政单位中沙群岛的岛礁及其海域");
		long starTime = new java.util.Date().getTime();
		long eTime = new java.util.Date().getTime();
		java.lang.System.out.println("花费时间：" + (eTime - starTime));
	}

	public static boolean compareProvince(java.lang.String originAddress, java.lang.String newAddress) {
		if ((newAddress.length() <= 3) || (originAddress.length() <= 3)) {
			return originAddress.contains(newAddress);
		}
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> originResolution = com.doinb.utils.StringUtil.addressResolution(originAddress);
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> newResolution = com.doinb.utils.StringUtil.addressResolution(newAddress);
		java.lang.String originProvince;
		java.lang.String newProvince = "";
		if (originResolution.size() > 0) {
			originProvince = originResolution.get(0).get("province");
		} else {
			return false;
		}
		if (newResolution.size() > 0) {
			newProvince = newResolution.get(0).get("province");
		}
		return originProvince.equals(newProvince);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> addressResolution(java.lang.String address) {
		java.lang.String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(address);
		java.lang.String province = null;
		java.lang.String city = null;
		java.lang.String county = null;
		java.lang.String town = null;
		java.lang.String village = null;
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> table = new java.util.concurrent.CopyOnWriteArrayList<>();
		java.util.Map<java.lang.String, java.lang.String> row = null;
		while (m.find()) {
			row = new java.util.concurrent.ConcurrentHashMap<>();
			province = m.group("province");
			row.put("province", province == null ? "" : province.trim());
			city = m.group("city");
			row.put("city", city == null ? "" : city.trim());
			county = m.group("county");
			row.put("county", county == null ? "" : county.trim());
			town = m.group("town");
			row.put("town", town == null ? "" : town.trim());
			village = m.group("village");
			row.put("village", village == null ? "" : village.trim());
			table.add(row);
		} 
		return table;
	}
}