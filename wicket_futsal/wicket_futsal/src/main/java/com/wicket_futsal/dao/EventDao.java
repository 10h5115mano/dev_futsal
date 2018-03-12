package com.wicket_futsal.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EventDao extends BaseDao {

	/**
	 * 最新のイベント情報を取得する。
	 *
	 * @return 最新イベント情報 Map
	 * @throws SQLException
	 */
	public Map<String, Object> selectNextEvent() throws SQLException {

		openMybatisConfig();

		// 設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		Map<String, Object> result;

		// SqlSessionFactory から SqlSession を生成する
		SqlSession session = factory.openSession();

		try {
			// SqlSession を使って SQL を実行する
			result = session.selectOne("futsal.mybatis.selectNextEvent");
		} finally {
			session.close();
			closeMybatisConfig();
		}
		return result;
	}

}
