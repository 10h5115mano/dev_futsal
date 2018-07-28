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
import com.wicket_futsal.dto.EventParticipantDTO;

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

	/** 次回イベント情報 */
	public Map<String, Object> nextEventInfo;

	/** 次回予定日 */
	public Label nextEventDayLabel;

	/** 次回予定時間 */
	public Label nextEventTimeLabel;

	/** イベント参加者確認用フォーム */
	private Form<String> participantForm = new Form<String>("participantForm");

	/** ログインID */
	public String loginId;

	/** 参加ボタン */
	private Button joinButton = new Button("joinButton") {
		private static final long serialVersionUID = -4912279695605489493L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + loginId + ":参加ボタン押下");

			submitJoinButton();
		}
	};

	/**
	 * 参加ボタン押下処理
	 */
	public void submitJoinButton() {
		EventParticipantDTO dto = new EventParticipantDTO();

		dto.setEventId((Integer)nextEventInfo.get("event_id"));
		dto.setUserId(loginId);
		dto.setJoinCode("1");

		service.submitPresenceOrAbsenceButton(dto);
	}

	/** 行けたら行くボタン */
	private Button mayBeButton = new Button("mayBeButton") {
		private static final long serialVersionUID = 9118066775473414897L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "行けたら行くボタン押下");

			submitMayBeButton();
		}
	};

	/**
	 * 行けたら行くボタン押下処理
	 */
	public void submitMayBeButton() {
		EventParticipantDTO dto = new EventParticipantDTO();

		dto.setEventId((Integer)nextEventInfo.get("event_id"));
		dto.setUserId(loginId);
		dto.setJoinCode("2");

		service.submitPresenceOrAbsenceButton(dto);
	}

	/** 不参加ボタン */
	private Button notGoButton = new Button("notGoButton") {
		private static final long serialVersionUID = 4749341266517889189L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "不参加ボタン押下");

			submitNotGoButton();
		}
	};

	/**
	 * 不参加ボタン押下処理
	 */
	public void submitNotGoButton() {
		EventParticipantDTO dto = new EventParticipantDTO();

		dto.setEventId((Integer)nextEventInfo.get("event_id"));
		dto.setUserId(loginId);
		dto.setJoinCode("3");

		service.submitPresenceOrAbsenceButton(dto);
	}

	/**
	 * ホーム画面コンストラクタ
	 *
	 * @param parameters
	 */
	public HomePage(final PageParameters parameters) {

		super(parameters);

		// Page Title
		add(titleLabel);

		logger.info(Constants.INFO + "ホームページを表示します。");

		if (loginExistence(parameters)) {

			// ログインユーザ処理
			loginId = parameters.get("userId").toString();
			logger.info(Constants.INFO + "HomePageログインユーザ:" + loginId);

		} else {

			// 未ログイン処理
			baseService.notLoginExecute(parameters);

		}

		// 次回予定取得
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
		participantForm.add(joinButton);
		participantForm.add(mayBeButton);
		participantForm.add(notGoButton);

		add(participantForm.setVisible(loginExistence(parameters)));

	}
}
