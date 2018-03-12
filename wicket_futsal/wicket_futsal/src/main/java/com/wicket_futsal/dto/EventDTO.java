package com.wicket_futsal.dto;

import java.sql.Timestamp;

public class EventDTO {

	/** イベントID */
	private int eventId;

	/** タイトル */
	private String title;

	/** 開始日 */
	private String startDay;

	/** 終了日 */
	private String endDay;

	/** 開始時間 */
	private String startTime;

	/** 終了時間 */
	private String endTime;

	/** 場所 */
	private String place;

	/** 内容 */
	private String contents;

	/** 金額 */
	private int price;

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
	 * @param eventId セットする eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return startDay
	 */
	public String getStartDay() {
		return startDay;
	}

	/**
	 * @param startDay セットする startDay
	 */
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	/**
	 * @return endDay
	 */
	public String getEndDay() {
		return endDay;
	}

	/**
	 * @param endDay セットする endDay
	 */
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	/**
	 * @return startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime セットする startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime セットする endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place セットする place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents セットする contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
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
