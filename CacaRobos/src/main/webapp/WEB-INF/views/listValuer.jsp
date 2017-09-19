<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Cpf</th>

	</tr>
	<c:forEach items="${val }" var="val">
		<tr>
			<td>${val.id }</td>
			<td>${val.name }</td>
			<td>${val.cpf }</td>
			<td><a href="deleteValuer?id=${val.id }"><button>X</button></a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>