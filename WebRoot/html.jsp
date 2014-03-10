<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head></head>

	<body>
		<s:iterator value="data.competitors">
			<s:property value="url" /><br />
			<s:property value="prices" /><br />
			<s:property value="quotas" /><br />
		</s:iterator>
	</body>
</html>
