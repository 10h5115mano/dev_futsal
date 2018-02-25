package com.wicket_futsal.login;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.common.Constants;
import com.wicket_futsal.dto.UserDTO;
import com.wicket_futsal.home.HomePage;

/**
 * ログイン画面
 *
 * @author mano
 *
 */
public class LoginPage  extends WebPage {
	private static final long serialVersionUID = 3144355108108420192L;

	private static final Logger logger = Logger.getLogger(LoginPage.class
			.getName());

	/** ページタイトル */
	private static final String pageTitle = "LOGIN";
	private static final Label titleLabel = new Label("wicketTitle", pageTitle);

	/** ログイン画面用業務クラス */
	private static LoginService service = new LoginService();

	/** ログイン用フォーム */
	private Form<String> form = new Form<String>("loginForm");

	/** ログインID用モデル */
	private Model<String> loginIdModel = new Model<String>();

	/** ログインパス用モデル */
	private Model<String> loginPassModel = new Model<String>();

	/** ログインID */
	TextField<String> loginIdText;

	/** ログインパスワード */
	PasswordTextField loginPassText;

	/**
	 * ログインボタン
	 *
	 * */
	private Button loginButton = new Button("loginButton") {
		private static final long serialVersionUID = -5971836288003545423L;

		@Override
		public void onSubmit() {

			logger.info(Constants.INFO + "ログインボタン押下");

			loginIdText = new TextField<String>("loginId", loginIdModel);
			loginPassText = new PasswordTextField("loginPass", loginPassModel);

			// DTOに値をセット
			UserDTO dto = new UserDTO();

			dto.setUserId(loginIdText.getInput());
			dto.setPassword(loginPassText.getInput());

			if (service.loginCheck(dto)) {

				// ホーム画面に遷移
				logger.info(Constants.INFO + "ログイン成功");
				PageParameters parameters = new PageParameters();
				parameters.add("userId", dto.getUserId());
				HomePage result = new HomePage(parameters);
				setResponsePage(result);
			} else {

				PageParameters parameters = new PageParameters();
				LoginPage loginPage = new LoginPage(parameters);

				// ログイン画面に遷移
				logger.warning(Constants.WARN + "ログイン失敗");
				setResponsePage(loginPage);
			}
		}
	};

	/**
	 * ログイン画面コンストラクタ
	 * */
	public LoginPage(final PageParameters parameters) {

		// Page Title
		add(titleLabel);

		logger.info(Constants.INFO + "ログインページを表示します。");

		loginIdText = new TextField<String>("loginId", loginIdModel);
		loginPassText = new PasswordTextField("loginPass", loginPassModel);

		loginIdText.setRequired(true);
		loginPassText.setRequired(true);

		form.add(loginIdText);
		form.add(loginPassText);
		form.add(loginButton);

		add(form);
	}

	/**
	 * @return loginIdModel
	 */
	public Model<String> getLoginIdModel() {
		return loginIdModel;
	}

	/**
	 * @param loginIdModel
	 *            セットする loginIdModel
	 */
	public void setLoginIdModel(Model<String> loginIdModel) {
		this.loginIdModel = loginIdModel;
	}

	/**
	 * @return loginPassModel
	 */
	public Model<String> getLoginPassModel() {
		return loginPassModel;
	}

	/**
	 * @param loginPassModel
	 *            セットする loginPassModel
	 */
	public void setLoginPassModel(Model<String> loginPassModel) {
		this.loginPassModel = loginPassModel;
	}
}
