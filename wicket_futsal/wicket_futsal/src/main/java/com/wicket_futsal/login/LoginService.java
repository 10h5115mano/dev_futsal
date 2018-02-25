package com.wicket_futsal.login;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.basePage.BaseService;
import com.wicket_futsal.common.Constants;
import com.wicket_futsal.common.PassDigest;
import com.wicket_futsal.dao.UserDao;
import com.wicket_futsal.dto.UserDTO;

public class LoginService extends BaseService {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -2689849724430750212L;

	private static final Logger logger = Logger.getLogger(LoginService.class
			.getName());

	private static UserDao loginDao = new UserDao();

	public PageParameters execute(PageParameters parameters) {
		PageParameters result = new PageParameters();

		return result;
	}

	public boolean loginCheck(UserDTO dto) {

		logger.info(Constants.INFO + "LoginService.loginCheck:start");

		Map<String, Object> result = null;

		String inputPass = "";

		try {
			result = loginDao.selectUser(dto);
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		if (result.size() == 1) {

			try {
				inputPass = PassDigest
						.build(dto.getUserId(), dto.getPassword());
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			if (inputPass.equals((String) result.get("password"))) {
				logger.info(Constants.INFO + "ログイン成功");
				logger.info(Constants.INFO + "LoginService.loginCheck:end");
				return true;
			}
		}

		logger.info(Constants.WARN + "ログイン失敗");
		logger.info(Constants.INFO + "LoginService.loginCheck:end");
		return false;
	}

}
