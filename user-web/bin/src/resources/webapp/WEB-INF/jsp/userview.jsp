<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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