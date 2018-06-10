package com.wicket_futsal.dao;

import java.sql.SQLException;

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
	public void insertJoinEvent(EventParticipantDTO dto) throws SQLException {

		openMybatisConfig();

		// 設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		// SqlSessionFactory から SqlSession を生成する
		SqlSession session = factory.openSession();

		try {
			// SqlSession を使って SQL を実行する
			session.selectOne("futsal.mybatis.insertJoinEvent", dto);
		} finally {
			session.close();
			closeMybatisConfig();
		}
	}

}
