package com.wicket_futsal.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wicket_futsal.dto.EventParticipantDTO;

public class EventParticipantDao extends BaseDao {

	/**
	 * ユーザの参加情報を登録する
	 *
	 * @throws SQLException
	 */
	public Map<String, Object> selectJoinUser(EventParticipantDTO dto)
			throws SQLException {

		openMybatisConfig();

		// 設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		// SqlSessionFactory から SqlSession を生成する
		SqlSession session = factory.openSession();

		Map<String, Object> result;

		try {
			// SqlSession を使って SQL を実行する
			result = session.selectOne("futsal.mybatis.selectJoinUser", dto);
		} finally {
			session.close();
			closeMybatisConfig();
		}

		return result;
	}

	/**
	 * ユーザの参加情報を登録する
	 *
	 * @throws SQLException
	 */
	public int insertJoinEvent(EventParticipantDTO dto) throws SQLException {

		openMybatisConfig();

		// 設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		// SqlSessionFactory から SqlSession を生成する
		SqlSession session = factory.openSession();

		int ret = 0;

		try {
			// SqlSession を使って SQL を実行する
			ret = session.insert("futsal.mybatis.insertJoinEvent", dto);
			session.commit();
		} finally {
			session.close();
			closeMybatisConfig();
		}
		return ret;
	}

}
