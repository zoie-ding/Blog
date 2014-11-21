<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title><s:text name="reply.add.welcom"/></title>
<s:head theme="xhtml"/>
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
</head>

<body>
<div aligh=center>
	<s:form action="replySave" method="post"
		tooltipConfig="%{jsTooltipEnabled':'true'}">
		<s:hidden name="reply.message.id" value="%{message.id}" />;
			<tr>
				<td colspan="2" align="center">
					<h1><s:text name="reply.add.welcom" /></h1><br/>
					<s:actionerror />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<s:property value="message.title" />
					<s:text name="global.format.date">
						<s:param value="meaage.pubdate"></s:param>
					</s:text>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<s:property value="message.content" />
				</td>
			</tr>
			
			<s:textfield name="reply.title" key="reply.title"
				tooltip="Enter article title!" required="true" />
			<s:password name="reply.username" key="reply.username"
				tooltip="Enter your name!" required="true" />
			<s:password name="reply.content" key="reply.content"
				tooltip="Enter article content!" required="true" />
			<s:submit />
			<s:reset />
		</s:form>
</div>
</body>
</html>
