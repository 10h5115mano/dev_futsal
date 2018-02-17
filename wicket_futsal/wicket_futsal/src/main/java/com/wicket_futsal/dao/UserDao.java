package com.wicket_futsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wicket_futsal.common.ResultSetConverter;
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
	 *            LoginDTO
	 * @return ユーザ情報 LoginDTO
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public UserDTO selectUser(UserDTO dto) throws SQLException {

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT PASSWORD FROM M_USER WHERE USER_ID = ?;";

		UserDTO resultDto = new UserDTO();

		pstmt = conn.prepareStatement(sql);

		// ログインID
		pstmt.setString(1, dto.getUserId());

		rs = pstmt.executeQuery();

		if (rs.next()) {

			try {
				@SuppressWarnings({ "rawtypes" })
				ResultSetConverter rsConverter = new ResultSetConverter(rs,
						resultDto.getClass());

				resultDto = (UserDTO) rsConverter.toDTO(rs, resultDto);

			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return resultDto;

		}

		return null;
	}

}
