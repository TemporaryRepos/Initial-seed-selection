public class IPWhiteCheck {
	private static java.lang.String VERTICAL = "\\|";

	private static java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\." + (("(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\." + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\.") + "(1\\d{1,2}|2[0-4]\\d|25[0-5]|\\d{1,2})"));

	private static java.util.Set<java.lang.String> getAvaliIpList(java.lang.String allowIp) {
		java.util.Set<java.lang.String> ipList = new java.util.HashSet<java.lang.String>();
		for (java.lang.String allow : allowIp.replaceAll("\\s", "").split(";")) {
			if (allow.indexOf("*") > (-1)) {
				java.lang.String[] ips = allow.split("\\.");
				java.lang.String[] from = new java.lang.String[]{ "0", "0", "0", "0" };
				java.lang.String[] end = new java.lang.String[]{ "255", "255", "255", "255" };
				java.util.List<java.lang.String> tem = new java.util.ArrayList<java.lang.String>();
				for (int i = 0; i < ips.length; i++) {
					if (ips[i].indexOf("*") > (-1)) {
						tem = com.pancm.utils.IPWhiteCheck.complete(ips[i]);
						from[i] = null;
						end[i] = null;
					} else {
						from[i] = ips[i];
						end[i] = ips[i];
					}
				}
				java.lang.StringBuffer fromIP = new java.lang.StringBuffer();
				java.lang.StringBuffer endIP = new java.lang.StringBuffer();
				for (int i = 0; i < 4; i++) {
					if (from[i] != null) {
						fromIP.append(from[i]).append(".");
						endIP.append(end[i]).append(".");
					} else {
						fromIP.append("[*].");
						endIP.append("[*].");
					}
				}
				fromIP.deleteCharAt(fromIP.length() - 1);
				endIP.deleteCharAt(endIP.length() - 1);
				for (java.lang.String s : tem) {
					java.lang.String ip = (fromIP.toString().replace("[*]", s.split(";")[0]) + "-") + endIP.toString().replace("[*]", s.split(";")[1]);
					if (com.pancm.utils.IPWhiteCheck.validate(ip)) {
						ipList.add(ip);
					}
				}
			} else if (com.pancm.utils.IPWhiteCheck.validate(allow)) {
				ipList.add(allow);
			}
		}
		return ipList;
	}

	private static java.util.List<java.lang.String> complete(java.lang.String arg) {
		java.util.List<java.lang.String> com = new java.util.ArrayList<java.lang.String>();
		if (arg.length() == 1) {
			com.add("0;255");
		} else if (arg.length() == 2) {
			java.lang.String s1 = IPWhiteCheck.complete(arg, 1);
			if (s1 != null) {
				com.add(s1);
			}
			java.lang.String s2 = IPWhiteCheck.complete(arg, 2);
			if (s2 != null) {
				com.add(s2);
			}
		} else {
			java.lang.String s1 = IPWhiteCheck.complete(arg, 1);
			if (s1 != null) {
				com.add(s1);
			}
		}
		return com;
	}

	private static java.lang.String complete(java.lang.String arg, int length) {
		java.lang.String from = "";
		java.lang.String end = "";
		if (length == 1) {
			from = arg.replace("*", "0");
			end = arg.replace("*", "9");
		} else {
			from = arg.replace("*", "00");
			end = arg.replace("*", "99");
		}
		if (java.lang.Integer.valueOf(from) > 255) {
			return null;
		}
		if (java.lang.Integer.valueOf(end) > 255) {
			end = "255";
		}
		return (from + ";") + end;
	}

	private static boolean validate(java.lang.String ip) {
		for (java.lang.String s : ip.split("-")) {
			if (!com.pancm.utils.IPWhiteCheck.pattern.matcher(s).matches()) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkLoginIP(java.lang.String ip, java.util.Set<java.lang.String> ipList) {
		if (ipList.isEmpty() || ipList.contains(ip)) {
			return true;
		} else {
			for (java.lang.String allow : ipList) {
				if (allow.indexOf("-") > (-1)) {
					java.lang.String[] from = allow.split("-")[0].split("\\.");
					java.lang.String[] end = allow.split("-")[1].split("\\.");
					java.lang.String[] tag = ip.split("\\.");
					boolean check = true;
					for (int i = 0; i < 4; i++) {
						int s = java.lang.Integer.valueOf(from[i]);
						int t = java.lang.Integer.valueOf(tag[i]);
						int e = java.lang.Integer.valueOf(end[i]);
						if (!((s <= t) && (t <= e))) {
							check = false;
							break;
						}
					}
					if (check) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean checkLoginIP(java.lang.String ip, java.lang.String ipWhiteConfig) {
		if ((ip == null) || (ipWhiteConfig == null)) {
			return false;
		}
		java.util.Set<java.lang.String> ipList = com.pancm.utils.IPWhiteCheck.getAvaliIpList(ipWhiteConfig);
		return com.pancm.utils.IPWhiteCheck.checkLoginIP(ip, ipList);
	}

	public static boolean checkLoginIPS(java.lang.String ip, java.lang.String ipWhiteConfig) {
		if ((ip == null) || (ipWhiteConfig == null)) {
			return false;
		}
		java.lang.String[] ips = ipWhiteConfig.split(com.pancm.utils.IPWhiteCheck.VERTICAL);
		boolean falg = false;
		for (java.lang.String i : ips) {
			falg = com.pancm.utils.IPWhiteCheck.checkLoginIP(ip, i);
			if (falg) {
				break;
			}
		}
		return falg;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String ip = "192.169.0.10";
		java.lang.String ipWhiteConfig = "192.169.0.1-192.169.0.11";
		java.lang.String ip2 = "192.169.0.10";
		java.lang.String ipWhiteConfig2 = "192.169.1.*";
		java.lang.String ipWhiteConfig3 = "192.169.1.*|192.169.0.1-192.169.0.11";
		java.lang.String[] ips = ipWhiteConfig3.split("\\|");
		boolean falg = false;
		for (java.lang.String i : ips) {
			falg = com.pancm.utils.IPWhiteCheck.checkLoginIP(ip2, i);
			if (falg) {
				break;
			}
		}
		java.lang.System.out.println("是否通过1：" + falg);
		java.lang.System.out.println("是否通过2：" + com.pancm.utils.IPWhiteCheck.checkLoginIP(ip, ipWhiteConfig));
		java.lang.System.out.println("是否通过3：" + com.pancm.utils.IPWhiteCheck.checkLoginIP(ip2, ipWhiteConfig2));
	}
}