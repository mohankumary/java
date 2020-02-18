<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<html>
<body>

<h1>Add New Employee</h1>  
       <form:form method="post" action="/pagenation/submit">    
        <table >    
         <tr>    
          <td>userName: </td>   
          <td><input type="text" name="userName"  /></td>  
         </tr>    
         <tr>    
          <td>email :</td>    
          <td><input type="text" name="email" /></td>  
         </tr>   
         <tr>    
          <td>password :</td>    
          <td><input type="text" name="password" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td> 
         </tr>    
        </table> 
        <div style="color: red">${eror}</div>   
       </form:form>    
</body>
</html>