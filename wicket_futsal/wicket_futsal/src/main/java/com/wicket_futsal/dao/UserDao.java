package com.wicket_futsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wicket_futsal.dto.UserDTO;

public class UserDao extends BaseDao {

	Connection conn = null;

	/**
	 * ログインDAOコンストラクタ
	 *
	 * @throws Exception
	 * */
	public UserDao() {
		try {
			dbAccess();
		} catch (Exception e) {
			System.out.println("ドライバーが見つからない");
			e.printStackTrace();
		}

		try {
			conn = getConnection();
		} catch (SQLException e) {
			System.out.println("DB接続ができない");
			e.printStackTrace();
		}
	}

	/**
	 * ログインIDの登録有無を確認する。
	 *
	 * @param ユーザID
	 *            LoginDTO
	 * @return ユーザ取得件数 int
	 * @throws SQLException
	 */
	public int selectUserCount(UserDTO dto) throws SQLException {

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT COUNT(*) FROM M_USER WHERE USER_ID = ?;";

		pstmt = conn.prepareStatement(sql);

		// ログインID
		pstmt.setString(1, dto.getUserId());

		rs = pstmt.executeQuery();

		rs.next();

		return rs.getInt(0);
	}

	/**
	 * ログインユーザのユーザ情報を取得する。
	 *
	 * @param ユーザID
	 * @return ユーザ情報 Map
	 * @throws SQLException
	 */
	public Map<String, Object> selectUser(UserDTO dto) throws SQLException {

		// ★設定ファイルを元に、 SqlSessionFactory を作成する
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(mybatisConfig);

		Map<String, Object> result;

		// ★SqlSessionFactory から SqlSession を生成する
		try (SqlSession session = factory.openSession()) {
			// ★SqlSession を使って SQL を実行する
			result = session
					.selectOne("futsal.mybatis.selectUser", dto);
		}
		return result;
	}
}
