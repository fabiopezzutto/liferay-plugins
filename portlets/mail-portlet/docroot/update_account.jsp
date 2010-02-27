<%
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
%>

<%@ include file="/json_init.jsp" %>

<%
String emailAddress = ParamUtil.getString(request, "emailAddress");
String mailInHostName = ParamUtil.getString(request, "mailInHostName");
String mailInPort = ParamUtil.getString(request, "mailInPort");
boolean mailInSecure = ParamUtil.getBoolean(request, "mailInSecure");
String mailOutHostName = ParamUtil.getString(request, "mailOutHostName");
String mailOutPort = ParamUtil.getString(request, "mailOutPort");
boolean mailOutSecure = ParamUtil.getBoolean(request, "mailOutSecure");
String password = ParamUtil.getString(request, "password");
String username = ParamUtil.getString(request, "username");

MailBoxManager mailBoxManager = new MailBoxManager(user, emailAddress, false, mailInHostName, mailInPort, mailInSecure, mailOutHostName, mailOutPort, mailOutSecure, password, username);
%>

<%= mailBoxManager.storeAccount() %>