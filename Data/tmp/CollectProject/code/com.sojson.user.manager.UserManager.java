public class UserManager {
	public static com.sojson.common.model.UUser md5Pswd(com.sojson.common.model.UUser user) {
		user.setPswd(com.sojson.user.manager.UserManager.md5Pswd(user.getEmail(), user.getPswd()));
		return user;
	}

	public static java.lang.String md5Pswd(java.lang.String email, java.lang.String pswd) {
		pswd = java.lang.String.format("%s#%s", email, pswd);
		pswd = com.sojson.common.utils.MathUtil.getMD5(pswd);
		return pswd;
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> toTreeData(java.util.List<com.sojson.common.model.URole> roles) {
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> resultData = new java.util.LinkedList<java.util.Map<java.lang.String, java.lang.Object>>();
		for (com.sojson.common.model.URole u : roles) {
			java.util.Map<java.lang.String, java.lang.Object> map = new java.util.LinkedHashMap<java.lang.String, java.lang.Object>();
			map.put("text", u.getName());
			map.put("href", "javascript:void(0)");
			java.util.List<com.sojson.common.model.UPermission> ps = u.getPermissions();
			map.put("tags", new java.lang.Integer[]{ ps.size() });
			if ((null != ps) && (ps.size() > 0)) {
				java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.LinkedList<java.util.Map<java.lang.String, java.lang.Object>>();
				for (com.sojson.common.model.UPermission up : ps) {
					java.util.Map<java.lang.String, java.lang.Object> mapx = new java.util.LinkedHashMap<java.lang.String, java.lang.Object>();
					mapx.put("text", up.getName());
					mapx.put("href", up.getUrl());
					list.add(mapx);
				}
				map.put("nodes", list);
			}
			resultData.add(map);
		}
		return resultData;
	}

	public static void main(java.lang.String[] args) {
		java.lang.System.out.println(com.sojson.user.manager.UserManager.md5Pswd("admin", "admin"));
	}
}