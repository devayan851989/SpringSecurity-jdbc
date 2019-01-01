<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Newtonic Info Solution</h2>
<hr>
Welcome to the Newtonic company homepage!
<hr>
<p>
User:<security:authentication property="principal.username"/>
<br><br>
Role(s):<security:authentication property="principal.authorities"/>
<br><br>
<p>


<security:authorize access="hasRole('MANAGER')">
<!-- Add a link to point to /leader.. this is for the manager -->
<p>
<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting(Only for Manager peers)</a><br>
<p>
</security:authorize >
<hr>
<security:authorize access="hasRole('ADMIN')">
<p>
<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting(Only for Admin peers)</a><br>
<p>
</security:authorize >
<hr>

<form:form action="${pageContext.request.contextPath}/logout"
method="POST">

<input type="submit" value="Logout"/>
</form:form>

</body>
</html>