<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title><s:text name="logon.welcom"/></title>
<s:head theme="xhtml"/>
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
<script>
function regist() {
	window.location = '<s:url action="/registInput"/>';
}
</script>
</head>

<body>
<div aligh=center>
	<s:form action="logon" method="post"
		tooltipConfig="%{jsTooltipEnabled':'true'}">
			<tr>
				<td colspan="2" align="center">
					<h1><s:text name="logon.welcom" /></h1><br/>
					<s:actionerror />
				</td>
			</tr>
			<s:textfield name="user.name" key="user.name"
				tooltip="Enter your name!" required="true" />
			<s:password name="user.password" key="user.password"
				tooltip="Enter your password!" required="true" />
			<s:submit />
			<tr>
				<td colspan="2" align="right">
					<input type="button" onclick="regist();"
					value='<s:text name="logon.regist"/>'/>
				</td>
			</tr>
			<s:reset />
		</s:form>
</div>
</body>
</html>
