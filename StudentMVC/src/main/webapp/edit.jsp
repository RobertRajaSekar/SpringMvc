<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="edit" modelAttribute="student">

ID		:<form:input path="id" readonly="true" /><br><br>
Name	:<form:input path="name"/><br><br>
Address	:<form:input path="address"/><br><br>
Phone	:<form:input path="phone"/><br><br>

<input type="submit" value="EDIT"> 
</form:form>
</body>
</html>