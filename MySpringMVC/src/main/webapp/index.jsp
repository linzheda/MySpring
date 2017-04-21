<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${errors.size()>0 }">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</c:if>

	<form action="student.action" method="post">
	<input type="hidden" name="op" value="add"/>
		<input  name="sname" type="text" />
		<input type="submit" value="提交" />
	</form>
</body>
</html>