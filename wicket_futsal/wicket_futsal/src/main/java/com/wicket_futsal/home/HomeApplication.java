package com.wicket_futsal.home;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * ホーム画面用アプリケーションクラス
 *
 * @author mano
 *
 */
public class HomeApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		getMarkupSettings().setDefaultMarkupEncoding("Shift_JIS");
	}

}
