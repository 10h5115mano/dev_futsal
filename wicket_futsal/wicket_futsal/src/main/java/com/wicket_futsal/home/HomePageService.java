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
	 * 出欠ボタン押下処理
	 */
	public void submitPresenceOrAbsenceButton(EventParticipantDTO dto) {
		logger.info(Constants.INFO + "HomePageService.submitJoinButton:start");

		Map<String, Object> joinDto;

		try {
			logger.info(Constants.INFO + dto.getUserId() + "の参加有無を検索します。");
			joinDto = eventParticipantDao.selectJoinUser(dto);

			if (joinDto == null) {
				logger.info(Constants.INFO + dto.getUserId() + "の参加有無を新規登録します。");

				// 新規登録
				int ret = eventParticipantDao.insertJoinEvent(dto);
				logger.info(Constants.INFO + ret + "件の登録を行いました。");
			} else {
				logger.info(Constants.INFO + joinDto.get("user_id")
						+ "の参加有無を更新します。");

				// 更新

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		logger.info(Constants.INFO + "HomePageService.submitJoinButton:end");
	}
}
