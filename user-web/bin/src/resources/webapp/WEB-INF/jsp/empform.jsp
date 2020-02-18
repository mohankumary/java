<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<html>
<body>

<h1>Add New Employee</h1>  
       <form method="post" action="/save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><input type="text" name="first_name"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><input type="number" name="salary" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><input type="text" name="designation" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td> 
         </tr>    
        </table> 
        <div style="color: red">${eror}</div>   
       </form>    


</body>


</html>