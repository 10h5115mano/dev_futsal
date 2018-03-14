package com.wicket_futsal.home;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
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

	/** イベント参加者確認用フォーム */
	private Form<String> form = new Form<String>("participantForm");

	/** 参加ボタン */
	private Button joinButton = new Button("joinButton") {
		private static final long serialVersionUID = -4912279695605489493L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "参加ボタン押下");
		}
	};

	/** 行けたら行くボタン */
	private Button mayBeButton = new Button("mayBeButton") {
		private static final long serialVersionUID = 9118066775473414897L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "行けたら行くボタン押下");
		}
	};

	/** 不参加ボタン */
	private Button notGoButton = new Button("notGoButton") {
		private static final long serialVersionUID = 4749341266517889189L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "参加ボタン押下");
		}
	};

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

		nextEventInfo = service.execute();

		/** 次回予定日 */
		nextEventDayLabel = new Label("nextEventDay",
				(String) nextEventInfo.get("start_day"));

		/** 次回予定時間 */
		nextEventTimeLabel = new Label("nextEventTime",
				(String) nextEventInfo.get("start_time"));

		// 次回予定日
		add(nextEventDayLabel);

		// 次回予定時間
		add(nextEventTimeLabel);

		// 参加者ボタン群
		form.add(joinButton);
		form.add(mayBeButton);
		form.add(notGoButton);

		add(form);

	}
}
