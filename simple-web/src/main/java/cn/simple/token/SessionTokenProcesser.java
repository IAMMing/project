package cn.simple.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

public class SessionTokenProcesser extends TokenProcesser {

	@Override
	public boolean validToken(HttpServletRequest request) {

		String clientToken = getClientToken(request);
		if (StringUtils.isEmpty(clientToken)) {
			return false;
		}
		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		String tokenKey = getTokenKey(request);
		String serverToken = session.getAttribute(tokenKey).toString();

		session.removeAttribute(tokenKey);
		System.out.println("remove servertoken:" + serverToken);
		return clientToken.equals(serverToken);

	}

	@Override
	public String getTokenKey(HttpServletRequest request) {
		System.out.println("pathinfo:"+request.getRequestURI());
		return getTokenField();
	}

	@Override
	public void saveToken(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String tokenKey = getTokenKey(request);
		Object tokenObj = session.getAttribute(tokenKey);
		String token;
		if (tokenObj == null) {
			token = MakeToken.getInstance().getToken();
			// 服务端保存token
			session.setAttribute(tokenKey, token);
		} else {
			token = tokenObj.toString();
		}
		System.out.println("current token:" + token);

		request.setAttribute(getTokenField(), token);
	}

}
