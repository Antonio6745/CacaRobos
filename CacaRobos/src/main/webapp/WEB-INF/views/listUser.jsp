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
		<th>Nickname</th>

	</tr>
	<c:forEach items="${us }" var="us">
		<tr>
			<td>${us.id }</td>
			<td>${us.nickname }</td>
			<td><a href=""><button>Gerar Recibo De Sa�da</button></a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>