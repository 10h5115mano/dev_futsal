package com.wicket_futsal.home;

import java.util.logging.Logger;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.basePage.BaseService;
import com.wicket_futsal.common.Constants;

public class HomePageService extends BaseService {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -3397668855113619601L;

	private static final Logger logger = Logger.getLogger(HomePageService.class
			.getName());

	public PageParameters execute() {
		PageParameters result = new PageParameters();

		logger.info(Constants.INFO + "HomePageService.execute:start");

		logger.info(Constants.INFO + "HomePageService.execute:end");

		return result;
	}

}
