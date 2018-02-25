package com.wicket_futsal.basePage;

import java.io.Serializable;
import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.common.Constants;
import com.wicket_futsal.home.HomePage;
import com.wicket_futsal.login.LoginPage;

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

	/** 共通クラス ログインID */
	private String loginId;

	public BasePage() {
		basePage();
	}

	public BasePage(final PageParameters params) {
		basePage();
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

	/** ヘッダログインボタン */
	private Button headerLoginButton = new Button("headerLogin") {
		private static final long serialVersionUID = -8020517682442280795L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ログインボタン押下");

			PageParameters parameters = new PageParameters();
			LoginPage loginPage = new LoginPage(parameters);

			setResponsePage(loginPage);
		}

	};

	/** フッタホームボタン */
	private Button footerHomeButton = new Button("footerHome") {
		private static final long serialVersionUID = 6739382416550965963L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ホームボタン押下");

			onSubmitHomeButton();
		}
	};

	/**
	 * ヘッダ・フッタ用 ホームボタン
	 */
	public void onSubmitHomeButton() {
		String loginId = this.getLoginId();

		if (null != loginId) {
			PageParameters parameters = new PageParameters();
			parameters.add("userId", loginId);
			HomePage homePage = new HomePage(parameters);

			setResponsePage(homePage);
		} else {
			setResponsePage(HomePage.class);
		}
	}

	/**
	 * 共通処理
	 */
	private void basePage() {

		add(errorMessage);

		headerForm.add(headerHomeButton);
		headerForm.add(headerLoginButton);

		add(headerForm);

		footerForm.add(footerHomeButton);
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

}
