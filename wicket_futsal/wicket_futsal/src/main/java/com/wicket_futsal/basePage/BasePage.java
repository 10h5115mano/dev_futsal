package com.wicket_futsal.basePage;

import java.io.Serializable;
import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.common.Constants;

/**
 * 共通テンプレート用のページクラスです。
 *
 * @author mano
 *
 */
public abstract class BasePage extends WebPage implements Serializable {
	private static final long serialVersionUID = -8807632799217641737L;

	private static final Logger logger = Logger.getLogger(BasePage.class
			.getName());

	/** 共通Serviseクラス */
	private static BaseService baseService = new BaseService();

	/** 共通クラス ログインID */
	private String loginId;

	public BasePage(final PageParameters params) {
		basePage(params);
	}

	/** エラーメッセージ */
	private FeedbackPanel errorMessage = new FeedbackPanel("errorMessage");

	/** ヘッダ用フォーム */
	@SuppressWarnings("rawtypes")
	private Form headerForm = new Form("headerForm");

	/** フッタ用フォーム */
	@SuppressWarnings("rawtypes")
	private Form footerForm = new Form("footerForm");

	/** ヘッダホームボタン */
	private Button headerHomeButton = new Button("headerHome") {
		private static final long serialVersionUID = 6739382416550965963L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ホームボタン押下");

			onSubmitHomeButton();
		}
	};

	/**
	 * ホームボタン処理
	 */
	public void onSubmitHomeButton() {
		setResponsePage(baseService.onSubmitHomeButton(this.getLoginId()));
	}

	/** ヘッダログインボタン */
	private Button headerLoginButton = new Button("headerLogin") {
		private static final long serialVersionUID = -8020517682442280795L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ログインボタン押下");

			onSubmitLoginButton();
		}

	};

	/**
	 * ログインボタン処理
	 */
	public void onSubmitLoginButton() {
		setResponsePage(baseService.onSubmitLoginButton());
	}

	/** ヘッダログアウトボタン */
	private Button headerLogoutButton = new Button("headerLogout") {
		private static final long serialVersionUID = -4585865358198295889L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ログアウトボタン押下");

			onSubmitLogoutButton();
		}

	};

	/**
	 * ログアウトボタン処理
	 */
	public void onSubmitLogoutButton() {
		setResponsePage(baseService.onSubmitLogoutButton());
	}

	/**
	 * 共通処理
	 */
	private void basePage(final PageParameters parameters) {

		// ログイン有無確認
		if (loginExistence(parameters)) {

			this.setLoginId(parameters.get("userId").toString());
			logger.info(Constants.INFO + "ログインユーザ：" + this.getLoginId());

		} else {
			logger.info(Constants.INFO + "ログインしていません。");
		}

		add(errorMessage);

		headerForm.add(headerHomeButton);

		headerForm.add(headerLoginButton.setVisible(!this
				.loginExistence(parameters)));
		headerForm.add(headerLogoutButton.setVisible(this
				.loginExistence(parameters)));

		add(headerForm);

		add(footerForm);
	}

	/**
	 * @return 共通クラス ログインID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param 共通クラス
	 *            ログインIDをセットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * ログイン有無を確認する
	 *
	 * @return true:ログインあり<br>
	 *         false:ログインなし
	 */
	public boolean loginExistence(final PageParameters parameters) {

		if (parameters.get("userId").isEmpty() && null == this.getLoginId()) {
			// ログインなし
			return false;
		}

		// ログインあり
		return true;
	}
}
