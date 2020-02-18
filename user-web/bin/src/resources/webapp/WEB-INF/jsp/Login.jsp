<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<h1>Add New Employee</h1>  
       <form:form method="post" action="submite">    
        <table >    
         <tr>    
          <td>email : </td>   
          <td><input type="text" name="email"  /></td>  
         </tr>    
         <tr>    
          <td>Password :</td>    
          <td><input type="password" name="Password" /></td>  
         </tr>
         <tr>       
          <td><a href="SignIn"><input type="button" value="SignIn" /></a></td>
          <td><input type="submit" value="Submit" /></td> 
         </tr>    
        </table> 
        <div style="color: red">${eror}</div>   
       </form:form>
       <br>
       <a href="/pagenation/view">check your password</a>
       
       