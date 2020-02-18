<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>id</th><th>username</th><th>email</th><th>password</th></tr>  
   <c:forEach var="user" items="${User}">   
   <tr>  
   <td>${user.id}</td>  
   <td>${user.userName}</td>  
   <td>${user.email}</td>  
   <td>${user.password}</td> 
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>