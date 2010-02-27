/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.jira.job;

import com.liferay.portal.kernel.job.IntervalJob;
import com.liferay.portal.kernel.job.JobExecutionContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.socialcoding.jira.util.JIRAConstants;
import com.liferay.socialcoding.service.JIRAIssueLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="SynchronizeJIRAJob.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class SynchronizeJIRAJob implements IntervalJob {

	public static final long INTERVAL = GetterUtil.getLong(PortletProps.get(
		"jira.synchronization.interval")) * Time.MINUTE;

	public void execute(JobExecutionContext context) {
		try {
			JIRAIssueLocalServiceUtil.updateJIRAIssues(
				JIRAConstants.PROJECT_LEP);

			JIRAIssueLocalServiceUtil.updateJIRAIssues(
				JIRAConstants.PROJECT_LPS);
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	public long getInterval() {
		return INTERVAL;
	}

	private static Log _log = LogFactoryUtil.getLog(SynchronizeJIRAJob.class);

}