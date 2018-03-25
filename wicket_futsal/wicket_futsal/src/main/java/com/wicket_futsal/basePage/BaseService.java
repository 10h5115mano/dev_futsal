package com.wicket_futsal.basePage;

import java.util.logging.Logger;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.common.Constants;
import com.wicket_futsal.home.HomePage;
import com.wicket_futsal.login.LoginPage;

public class BaseService {

	private static final Logger logger = Logger.getLogger(BaseService.class
			.getName());

	public void notLoginExecute(PageParameters parameters) {
		logger.info(Constants.INFO + "BaseService.notExecute:start");

		logger.info(Constants.INFO + "BaseService.notExecute:end");

	}

	/**
	 * ホームボタン処理
	 */
	public HomePage onSubmitHomeButton(String loginId) {

		if (null != loginId) {
			PageParameters parameters = new PageParameters();
			parameters.add("userId", loginId);
			HomePage homePage = new HomePage(parameters);

			return homePage;
		} else {
			return new HomePage(new PageParameters());
		}
	}

	/**
	 * ログインボタン処理
	 */
	public LoginPage onSubmitLoginButton() {
		PageParameters parameters = new PageParameters();
		LoginPage loginPage = new LoginPage(parameters);

		return loginPage;
	}

	/**
	 * ログアウトボタン処理
	 * @return
	 */
	public HomePage onSubmitLogoutButton() {
		PageParameters parameters = new PageParameters();
		HomePage homePage = new HomePage(parameters);

		return homePage;

	}
}
