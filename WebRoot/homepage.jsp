<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title><s:text name="logon.welcom"/></title>
<s:head theme="xhtml"/>
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
</head>

<body>
<div aligh=center>
	<h1><s:text name="logon.welcom" /></h1>
	<s:actionmessage />
	<s:url id="createMessageURL" action="messageAdd" />
	<s:a href="%{createMessageURL}" ><s:text name="message.add"></s:text></s:a>
	<table class="wwFormTable">
		<s:iterator value="user.message">
			<tr>
				<td>
					<s:property value="title"/>
					<s:text name="global.format.date">
						<s:param value="pubdate"></s:param>
					</s:text>
				</td>
				
				<td align="right">
					<s:url id="createMessageURL" action="messageUpdate">
						<s:param name="message.id" value="%{id}"></s:param>
					</s:url>
					<s:a href="%{createMessageURL}">
						<s:text name="message.update" />
					</s:a>
					<s:url id="createMessageURL" action="messagedelete">
						<s:param name="message.id" value="%{id}"></s:param>
					</s:url>
					<s:a href="%{createMessageURL}">
						<s:text name="message.delete" />
					</s:a>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<s:property value="content" />
				</td>
			</tr>
			
			<s:iterator value="replies">
				<tr>
					<td>
						<s:property value="title" />
						<s:text name="global.format.date">
							<s:param value="pubdate"></s:param>
						</s:text>
						<s:property value="username" />
					</td>
					
					<td align="right">
					<s:url id="createMessageURL" action="replydelete">
						<s:param name="reply.id" value="%{id}"></s:param>
					</s:url>
					<s:a href="%{createMessageURL}">
						<s:text name="reply.delete" />
					</s:a>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<s:property value="content" />
					</td>
				</tr>
			</s:iterator>
			<tr height="3px"><td colspan="2" height="3px"></td></tr>
		</s:iterator>
	</table>
</div>
</body>
</html>
