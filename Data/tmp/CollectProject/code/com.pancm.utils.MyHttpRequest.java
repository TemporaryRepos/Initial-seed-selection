public class MyHttpRequest {
	@java.lang.SuppressWarnings("rawtypes")
	public static java.lang.String sendGet(java.lang.String url, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String charset) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		if ((map != null) && (map.size() > 0)) {
			java.util.Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				java.util.Map.Entry er = ((java.util.Map.Entry) (it.next()));
				sb.append(er.getKey());
				sb.append("=");
				sb.append(er.getValue());
				sb.append("&");
			} 
		}
		return com.pancm.utils.MyHttpRequest.sendGet(url, sb.toString(), charset);
	}

	public static java.lang.String sendPost(java.lang.String url, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String charset) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		if ((map != null) && (map.size() > 0)) {
			for (java.util.Map.Entry<java.lang.String, java.lang.Object> e : map.entrySet()) {
				sb.append(e.getKey());
				sb.append("=");
				sb.append(e.getValue());
				sb.append("&");
			}
		}
		return com.pancm.utils.MyHttpRequest.sendPost(url, sb.toString(), charset);
	}

	public static java.lang.String sendGet(java.lang.String url, java.lang.String param, java.lang.String charset) {
		java.lang.String result = "";
		java.lang.String line;
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		java.io.BufferedReader in = null;
		try {
			java.lang.String urlNameString = (url + "?") + param;
			java.net.URL realUrl = new java.net.URL(urlNameString);
			java.net.URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("contentType", charset);
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			conn.setConnectTimeout(60);
			conn.setReadTimeout(60);
			conn.connect();
			in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), charset));
			while ((line = in.readLine()) != null) {
				sb.append(line);
			} 
			result = sb.toString();
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (java.lang.Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static java.lang.String sendPost(java.lang.String url, java.lang.String param, java.lang.String charset) {
		java.io.PrintWriter out = null;
		java.io.BufferedReader in = null;
		java.lang.String result = "";
		java.lang.String line;
		java.lang.StringBuffer sb = new java.lang.StringBuffer();
		try {
			java.net.URL realUrl = new java.net.URL(url);
			java.net.URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("contentType", charset);
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			conn.setReadTimeout(60);
			conn.setConnectTimeout(60);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			out = new java.io.PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), charset));
			while ((line = in.readLine()) != null) {
				sb.append(line);
			} 
			result = sb.toString();
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("发送 POST请求出现异常!" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (java.io.IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static void main(java.lang.String[] args) {
		java.lang.String getUrl = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
		java.lang.String postUrl = "http://gc.ditu.aliyun.com/geocoding";
		java.lang.String param = "format=json&ip=218.4.255.255";
		java.lang.String param1 = "a=苏州市";
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<java.lang.String, java.lang.Object>();
		map.put("format", "json");
		map.put("ip", "218.4.255.255");
		java.util.Map<java.lang.String, java.lang.Object> map1 = new java.util.HashMap<java.lang.String, java.lang.Object>();
		map1.put("a", "苏州市");
		java.lang.System.out.println("Get请求1:" + com.pancm.utils.MyHttpRequest.sendGet(getUrl, param, "utf-8"));
		java.lang.System.out.println("Get请求2:" + com.pancm.utils.MyHttpRequest.sendGet(getUrl, map, "utf-8"));
		java.lang.System.out.println("Post请求1:" + com.pancm.utils.MyHttpRequest.sendPost(postUrl, param1, "utf-8"));
		java.lang.System.out.println("Post请求2:" + com.pancm.utils.MyHttpRequest.sendPost(postUrl, map1, "utf-8"));
	}
}