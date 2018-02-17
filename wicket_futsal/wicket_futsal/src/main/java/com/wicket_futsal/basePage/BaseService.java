package com.wicket_futsal.basePage;

import java.util.logging.Logger;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.wicket_futsal.common.Constants;

public class BaseService {

	private static final Logger logger = Logger.getLogger(BaseService.class
			.getName());

	public void notLoginExecute(PageParameters parameters) {
		logger.info(Constants.INFO + "BaseService.notExecute:start");

		logger.info(Constants.INFO + "BaseService.notExecute:end");

	}

}
