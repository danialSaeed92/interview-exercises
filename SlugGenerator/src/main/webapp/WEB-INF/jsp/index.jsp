<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Asurint Interview</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<script type="text/javascript">
			function validateIt(){
				var desc = document.getElementById("desc");
				var url = document.getElementById("url");
				if(desc.value!=null && desc.value!=''){
					alert('Enter desc');
					desc.focus();
					return false;
				}else
				if(url.value!=null && url.value!=''){
						alert('Enter url');
						url.focus();
						return false;
				}else{
					return true;
				}
		</script>
	</head>
	<body>
		<div class="page">
			<div class="header">
				
			</div>
			<div class="body">
				<c:if test="${!empty msg }">
					<div style="color: red;">${msg}</div>
				</c:if>
				<c:if test="${!empty slug }">
					<div style="color: red;">${slug}</div>
				</c:if>
				<form method="post" id="urlForm" action="<%=request.getContextPath() %>/addUrl" onsubmit="return validateIt();">
				<table align="center" width="60%">
					<tr>
						<td>Description *</td>
						<td><input type="text" name="desc" id="desc"  required/></td>
					</tr>
					<tr>
						<td>URL *</td>
						<td><input type="text" name="url" id="url" required/></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="left"><input type="Submit" value="submit"/></td>
					</tr>
					
				</table>
				</form>
				
			</div>
			
		</div>
	</body>
</html>