package com.wicket_futsal.dto;

import java.sql.Timestamp;

public class UserDTO {

	/** ユーザID */
	private String userId;

	/** パスワード */
	private String password;

	/** ユーザー名 */
	private String userName;

	/** 誕生日 */
	private String birthday;

	/** 身長 */
	private int height;

	/** 体重 */
	private int weight;

	/** 権限ID */
	private String roleId;

	/** 更新日 */
	private Timestamp updateDate;

	/** 更新者 */
	private String updateUser;

	/** 登録日 */
	private Timestamp insertDate;

	/** 登録者 */
	private String insertUser;

	/** 削除フラグ */
	private char deleteFlg;

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height セットする height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight セットする weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId セットする roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser セットする updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return insertDate
	 */
	public Timestamp getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate セットする insertDate
	 */
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return insertUser
	 */
	public String getInsertUser() {
		return insertUser;
	}

	/**
	 * @param insertUser セットする insertUser
	 */
	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	/**
	 * @return deleteFlg
	 */
	public char getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg セットする deleteFlg
	 */
	public void setDeleteFlg(char deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
