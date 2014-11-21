<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title><s:text name="regist.welcom"/></title>
<s:head theme="xhtml" />
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
</head>
<body>
	<div aligh=center>
		<s:form action="register" method="post"
		tooltipConfig="%{jsTooltipEnabled':'true'}">
			<tr>
				<td colspan="2" align="center">
					<h1><s:text name="register.welcom" /></h1><br/>
					<s:property value="exception.message" />
				</td>
			</tr>
			<s:textfield name="user.name" key="user.name"
				tooltip="Enter your name!" required="true" />
			<s:password name="user.password" key="user.password"
				tooltip="Enter your password!" required="true" />
			<s:password name="repassword" key="repassword"
				tooltip="Repeat your password!" required="true" />
			<s:submit />
			<s:reset />
		</s:form>
	</div>
</body>
</html>