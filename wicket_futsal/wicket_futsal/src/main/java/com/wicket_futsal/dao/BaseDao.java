package com.wicket_futsal.dao;

import java.io.IOException;
import java.io.InputStream;

public class BaseDao {

	/** mybatis設定ファイル */
	public InputStream mybatisConfig;

	/**
	 * mybatis設定ファイルを開く
	 *
	 */
	public void openMybatisConfig() {
		mybatisConfig = BaseDao.class
				.getResourceAsStream("/mybatis-config.xml");
	}

	/**
	 * mybatis設定ファイルを閉じる
	 *
	 */
	public void closeMybatisConfig() {
		try {
			mybatisConfig.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		;
	}

}