<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title><s:text name="message.add.welcom"/></title>
<s:head theme="xhtml"/>
<link href='<s:url value="/CSS/common.css"></s:url>' rel="stylesheet" type="text/css" />
</head>

<body>
<div aligh=center>
	<s:form action="messageSave" method="post"
		tooltipConfig="%{jsTooltipEnabled':'true'}">
			<tr>
				<td colspan="2" align="center">
					<h1><s:text name="message.add.welcom" /></h1><br/>
					<s:actionerror />
				</td>
			</tr>
			
			<s:textfield name="message.title" key="message.title" 
			tooltip = "Enter article title!" required="true">
			</s:textfield>
			<s:textarea name="message.content" key="message.content" 
			tooltip = "Enter article content!" required="true">
			</s:textarea>>
			<s:submit />
			<s:reset />
			
		</s:form>
</div>
</body>
</html>