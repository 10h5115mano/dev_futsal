package com.wicket_futsal.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wicket_futsal.dto.UserDTO;

public class UserDao extends BaseDao {

	/**
	 * ログインユーザのユーザ情報を取得する。
	 *
	 * @param ユーザID
	 * @return ユーザ情報 Map
	 * @throws SQLException
	 */
	public Map<String, Object> selectUser(UserDTO dto) throws SQLException {

		openMybatisConfig();

		// 設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		Map<String, Object> result;

		// SqlSessionFactory から SqlSession を生成する
		SqlSession session = factory.openSession();
		try {
			// SqlSession を使って SQL を実行する
			result = session.selectOne("futsal.mybatis.selectUser", dto);
		} finally {
			session.close();
			closeMybatisConfig();
		}
		return result;
	}
}
