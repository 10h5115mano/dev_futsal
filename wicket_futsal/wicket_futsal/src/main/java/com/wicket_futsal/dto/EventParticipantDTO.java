package com.wicket_futsal.dto;

import java.sql.Timestamp;

public class EventParticipantDTO {

	/** イベントID */
	private int eventId;

	/** ユーザID */
	private String userId;

	/** 参加コード */
	private String joinCode;

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
	 * @return eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            セットする eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

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
	 * @return joinCode
	 */
	public String getJoinCode() {
		return joinCode;
	}

	/**
	 * @param joinCode セットする joinCode
	 */
	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}

	/**
	 * @return updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            セットする updateDate
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
	 * @param updateUser
	 *            セットする updateUser
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
	 * @param insertDate
	 *            セットする insertDate
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
	 * @param insertUser
	 *            セットする insertUser
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
	 * @param deleteFlg
	 *            セットする deleteFlg
	 */
	public void setDeleteFlg(char deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
