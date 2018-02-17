package com.wicket_futsal.login;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * ホーム画面用アプリケーションクラス
 *
 * @author mano
 *
 */
public class LoginApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return LoginPage.class;
	}

	@Override
	protected void init() {
		super.init();
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		getMarkupSettings().setDefaultMarkupEncoding("Shift_JIS");
	}

}
