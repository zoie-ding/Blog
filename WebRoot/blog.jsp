<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title><s:text name="blog.welcom"/></title>
<s:head theme="xhtml"/>
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
</head>

<body>
<div aligh=center>
			<tr>
				<td colspan="2" align="center">
					<h1><s:text name="blog.welcom" /></h1><br />
					<s:property value="exception.message"/>
				</td>
			</tr>
			
			<s:iterator value="user.messages">
				<tr>				
					<td>
						<s:property value="title"/>
						<s:text name="global.format.date" >
							<s:param name="message.id" value="%{id}"></s:param>
						</s:text>
					</td>
				
					<td align="right">
						<s:url id="createReplyURL" action="replyAdd">
							<s:param name="message.id" value="%{id}"></s:param>
						</s:url>
						<s:a href="%{createReplyURL}">
							<s:text name="reply.add" />
						</s:a>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<s:property value="content"/>
					</td>
				</tr>
				
				<s:iterator value="replies">
				<tr>
					<td colspan="2">
					<s:property value="title"/>
					<s:text name="global.format.date" >
						<s:param value="pubdate"></s:param>
					</s:text> <s:property value="username" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<s:property value="content" />
					</td>
				</tr>
			
			</s:iterator>
			
			<tr height="2px"><td colspan="2" height="2px"></td></tr>
		</s:iterator>
	</table>
</div>
</body>
</html>
