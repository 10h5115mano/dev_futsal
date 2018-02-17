package com.wicket_futsal.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * パスワードを不可逆暗号化する.
 */
public class PassDigest {

	private static final Logger logger = Logger.getLogger(PassDigest.class
			.getName());

	/**
	 * ユーザ名とパスワードでメッセージダイジェストを作成し文字列化して返す.
	 *
	 * @param userName
	 *            ユーザ名.
	 * @param password
	 *            パスワード.
	 * @return 生成したダイジェスト.
	 * @throws NoSuchAlgorithmException
	 *             Java実行環境にSHA-1が実装されていない.
	 */
	public static String build(String userName, String password)
			throws NoSuchAlgorithmException {

		logger.info(Constants.INFO + "PassDigest.build:start");

		StringBuilder buff = new StringBuilder();
		if (password != null && !password.isEmpty()) {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(userName.getBytes());
			md.update(password.getBytes());
			byte[] digest = md.digest();

			for (byte d : digest) {
				buff.append((int) d & 0xFF);
			}
		}

		logger.info(Constants.INFO + "PassDigest.build:end");
		return buff.toString();
	}
}