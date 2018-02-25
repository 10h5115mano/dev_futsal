package com.wicket_futsal.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	/** 設定ファイル */
	InputStream mybatisConfig = BaseDao.class.getResourceAsStream("/mybatis-config.xml");

	/** 接続先DB */
	private static final String dbPath = "jdbc:postgresql://localhost:5432/fcs";

	/** DBユーザ */
	private static final String dbUser = "postgres";

	/** DBパスワード */
	private static final String dbPassword = "postgres";

	Connection conn = null;

	/*
	 * ドライバ設定
	 */
	public void dbAccess() throws Exception {

        // JDBCドライバの読み込み
        try {
            // postgreSQLのJDBCドライバを読み込み
            Class.forName("org.postgresql.Driver");

        } catch(ClassNotFoundException e) {
            // JDBCドライバが見つからない場合
            e.printStackTrace();
        }
	}

	/**
	 * Connection取得
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
		return conn = DriverManager.getConnection(
				dbPath, dbUser, dbPassword);
	}
}