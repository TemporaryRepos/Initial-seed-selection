public class RuleMannager {
	public static entity.MatchResult match(java.lang.String str, entity.Rule rule) {
		switch (rule.getType()) {
			case entity.Rule.RULE_TYPE_RESPONSE_DATA :
				return utils.RuleMannager.matchRsqData(str);
			case entity.Rule.RULE_TYPE_REGULAR :
				return utils.RuleMannager.matchByRegular(str, rule.getRule());
			case entity.Rule.RULE_TYPE_POSISTION :
				return utils.RuleMannager.matchByPosistion(str, rule.getnStart(), rule.getnEnd());
			case entity.Rule.RULE_TYPE_START_END_STRING :
				return utils.RuleMannager.matchByStartEndString(str, rule.getStrStart(), rule.getStrEnd());
			case entity.Rule.RULE_TYPE_JSON_MATCH :
				matcher.impl.JsonMatcher jsonMatcher = new matcher.impl.JsonMatcher();
				return jsonMatcher.match(str, rule.getRule());
			case entity.Rule.RULE_TYPE_XML_MATCH :
				matcher.impl.XmlMatcher xmlMatcher = new matcher.impl.XmlMatcher();
				return xmlMatcher.match(str, rule.getRule());
			default :
				entity.MatchResult result = new entity.MatchResult();
				result.setResult("unkown rule type");
				return result;
		}
	}

	public static entity.MatchResult matchRsqData(java.lang.String str) {
		entity.MatchResult result = new entity.MatchResult();
		java.lang.String res = new java.lang.String(utils.Util.getRspBody(str.getBytes()));
		int bodyOffset = str.indexOf(res);
		result.setStart(bodyOffset);
		result.setEnd(bodyOffset + res.length());
		result.setResult(res);
		return result;
	}

	public static entity.MatchResult matchByRegular(java.lang.String str, java.lang.String regular) {
		entity.MatchResult result = new entity.MatchResult();
		java.lang.String res = null;
		int start = 0;
		int end = 0;
		java.util.regex.Pattern r = java.util.regex.Pattern.compile(regular);
		java.util.regex.Matcher m = r.matcher(str);
		if (m.find()) {
			res = m.group(1);
			start = m.start();
			int n = str.substring(start, str.length()).indexOf(res);
			start += n;
			end = start + res.length();
		}
		result.setResult(res);
		result.setStart(start);
		result.setEnd(end);
		return result;
	}

	public static entity.MatchResult matchByPosistion(java.lang.String str, int start, int end) {
		entity.MatchResult result = new entity.MatchResult();
		result.setStart(start);
		result.setEnd(end);
		result.setResult(str.substring(start, end));
		return result;
	}

	public static entity.MatchResult matchByStartEndString(java.lang.String str, java.lang.String start, java.lang.String end) {
		int nStart = str.indexOf(start) + start.length();
		int nEnd = str.indexOf(end);
		entity.MatchResult result = new entity.MatchResult();
		result.setStart(nStart);
		result.setEnd(nEnd);
		result.setResult(str.substring(nStart, nEnd));
		return result;
	}

	public static java.lang.String generateRegular(java.lang.String raw, int start, int end) {
		int newStart = start;
		int newEnd = end;
		java.lang.String startStr = "";
		java.lang.String endStr = "";
		java.lang.String target = raw.substring(start, end);
		java.lang.String strReg = "";
		if (start > 3) {
			newStart -= 3;
		} else if (start > 1) {
			newStart -= 1;
		}
		if (end < (raw.length() - 3)) {
			newEnd += 3;
		}
		for (int i = 0; i < raw.length(); i++) {
			startStr = raw.substring(newStart, start);
			startStr = utils.Util.escapeExprSpecialWord(startStr);
			endStr = raw.substring(end, newEnd);
			endStr = utils.Util.escapeExprSpecialWord(endStr);
			strReg = java.lang.String.format("%s(.*?)%s", startStr, endStr);
			java.lang.System.out.println("---------------------------------------");
			java.lang.System.out.println(strReg);
			burp.BurpExtender.stderr.println("------------------------------");
			burp.BurpExtender.stderr.println("[+] " + target);
			burp.BurpExtender.stderr.println(strReg);
			if (utils.RuleMannager.matchByRegular(raw, strReg).getResult().equals(target)) {
				break;
			}
			if ((newStart == 0) && (newEnd == raw.length())) {
				break;
			}
			if (newStart > 0) {
				newStart -= 1;
			}
			if (newEnd < raw.length()) {
				newEnd += 1;
			}
		}
		return strReg;
	}

	public static java.lang.String generatePositionRule(int start, int end) {
		java.lang.String rule = java.lang.String.format("{\"start\":%d,\"end\":%d}", start, end);
		return rule;
	}

	public static java.lang.String generateStartEndRule(java.lang.String raw, int start, int end) {
		java.lang.String keyword = raw.substring(start, end);
		int s = start;
		java.lang.String strStart = "";
		int e = end;
		java.lang.String strEnd = "";
		while (s >= 0) {
			strStart = raw.substring(s, start);
			int startPosition = raw.indexOf(strStart) + strStart.length();
			if (startPosition == start) {
				break;
			}
			s -= 1;
		} 
		while (e <= raw.length()) {
			strEnd = raw.substring(end, e);
			int endPosition = raw.indexOf(strEnd);
			if (endPosition == end) {
				break;
			}
			e += 1;
		} 
		strStart = utils.Util.escapeJsonString(strStart);
		strEnd = utils.Util.escapeJsonString(strEnd);
		java.lang.String rule = java.lang.String.format("{\"start\":\"%s\",\"end\":\"%s\"}", strStart, strEnd);
		if (utils.RuleMannager.matchByStartEndString(raw, strStart, strEnd).getResult().equals(keyword)) {
			return rule;
		} else {
			return "generate rule fail,try again";
		}
	}

	public static void main(java.lang.String[] args) {
		java.lang.String str = utils.RuleMannager.generateStartEndRule("absdsdsdbsdsfwewwfwfwdsdddcdesdfsdffghijkweweefewffsadfssdgslmnopqrsdsdst", 12, 34);
		java.lang.System.out.println(str);
	}
}