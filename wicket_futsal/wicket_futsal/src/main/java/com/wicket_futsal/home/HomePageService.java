package com.wicket_futsal.home;

import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import com.wicket_futsal.basePage.BaseService;
import com.wicket_futsal.common.Constants;
import com.wicket_futsal.dao.EventDao;
import com.wicket_futsal.dao.EventParticipantDao;
import com.wicket_futsal.dto.EventParticipantDTO;

public class HomePageService extends BaseService {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -3397668855113619601L;

	private static final Logger logger = Logger.getLogger(HomePageService.class
			.getName());

	private static EventDao eventDao = new EventDao();

	private static EventParticipantDao eventParticipantDao = new EventParticipantDao();

	public Map<String, Object> execute() {

		logger.info(Constants.INFO + "HomePageService.execute:start");

		Map<String, Object> nextEventInfo = null;
		try {
			nextEventInfo = eventDao.selectNextEvent();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		logger.info(Constants.INFO + "HomePageService.execute:end");

		return nextEventInfo;
	}

	/**
	 * 参加ボタン押下処理
	 */
	public void submitJoinButton() {
		logger.info(Constants.INFO + "HomePageService.submitJoinButton:start");

		try {
			EventParticipantDTO dto = new EventParticipantDTO();
			dto.setJoinCode("1");

			eventParticipantDao.insertJoinEvent(dto);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		logger.info(Constants.INFO + "HomePageService.submitJoinButton:end");
	}

	/**
	 * 行けたら行くボタン押下処理
	 */
	public void submitMayBeButton() {
		logger.info(Constants.INFO + "HomePageService.submitMayBeButton:start");

		try {
			EventParticipantDTO dto = new EventParticipantDTO();
			dto.setJoinCode("2");

			eventParticipantDao.insertJoinEvent(dto);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		logger.info(Constants.INFO + "HomePageService.submitMayBeButton:end");

	}

	/**
	 * 不参加ボタン押下処理
	 */
	public void submitNotGoButton() {
		logger.info(Constants.INFO + "HomePageService.submitNotGoButton:start");

		try {
			EventParticipantDTO dto = new EventParticipantDTO();
			dto.setJoinCode("3");

			eventParticipantDao.insertJoinEvent(dto);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		logger.info(Constants.INFO + "HomePageService.submitNotGoButton:end");

	}

}
