package com.wicket_futsal.dao;

import java.io.InputStream;

public class BaseDao {

	/** mybatis設定ファイル */
	InputStream mybatisConfig = BaseDao.class
			.getResourceAsStream("/mybatis-config.xml");

}