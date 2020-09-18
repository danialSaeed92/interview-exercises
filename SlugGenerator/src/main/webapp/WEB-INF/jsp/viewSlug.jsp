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
			var slug = document.getElementById("slug");
			
			if(slug.value!=null && slug.value!=''){
				alert('Enter slug');
				slug.focus();
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
				
				<table align="center" width="60%">
					<tr>
						<td>Description:</td>
						<td>${desc}<td>
					</tr>
					<tr>
						<td>URL</td>
						<td>${url}
					</tr>
					<tr>
				 	<td>Slug </td>
				 	<td>${slug}</td>
				 	</tr>
					
				</table>
				
				<form method="post" id="urlForm" action="<%=request.getContextPath() %>/redirectSlug" onsubmit="return validateIt();">
					<table align = "center" width ="60%">
						<tr>
							<td>Enter Slug to redirect</td>
							<td><input type="text" name="slug" id="slug" required/></td>
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