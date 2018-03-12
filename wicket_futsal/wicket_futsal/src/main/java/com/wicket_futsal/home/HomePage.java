package com.wicket_futsal.home;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.basePage.BasePage;
import com.wicket_futsal.basePage.BaseService;
import com.wicket_futsal.common.Constants;

/**
 * ホーム画面
 *
 * @author mano
 *
 */
public class HomePage extends BasePage {
	private static final long serialVersionUID = 3154340386289377412L;

	private static final Logger logger = Logger.getLogger(HomePage.class
			.getName());

	/** ページタイトル */
	private static final String pageTitle = "HOME";
	private static final Label titleLabel = new Label("wicketTitle", pageTitle);

	/** 共通Serviseクラス */
	private static BaseService baseService = new BaseService();

	/** Serviseクラス */
	private static HomePageService service = new HomePageService();

	public Map<String, Object> nextEventInfo;

	/** 次回予定日 */
	public Label nextEventDayLabel;

	/** 次回予定時間 */
	public Label nextEventTimeLabel;

	/**
	 * ホーム画面コンストラクタ
	 *
	 * @param parameters
	 */
	public HomePage(final PageParameters parameters) {

		// Page Title
		add(titleLabel);

		logger.info(Constants.INFO + "ホームページを表示します。");

		if (parameters.get("userId").isEmpty() && null == this.getLoginId()) {

			logger.info(Constants.INFO + "ログインしていません。");

			// 未ログイン処理
			baseService.notLoginExecute(parameters);

		} else {

			// ログインユーザ処理
			this.setLoginId(parameters.get("userId").toString());
			logger.info(Constants.INFO + "ログインユーザー：" + this.getLoginId());
		}

//			nextEventInfo = service.execute();

			/** 次回予定日 */
			nextEventDayLabel = new Label("nextEventDay", "test");//(String)nextEventInfo.get("start_day"));

			/** 次回予定時間 */
			nextEventTimeLabel = new Label("nextEventTime",  "test");//(String)nextEventInfo.get("start_time"));



		// 次回予定日
		add(nextEventDayLabel);

		// 次回予定時間
		add(nextEventTimeLabel);


	}
}
