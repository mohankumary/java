<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<html>
<body>

<h1>Sign up page </h1>  
       <form method="post" action="/submi">    
        <table >    
         <tr>    
          <td>userName: </td>   
          <td><input type="text" name="first_name" id="first_nameError" onblur="javascript:firstname();" /></td>
          <td style="color: red"><div id="errorid"></div></td>    
         </tr>    
         <tr>    
          <td>email :</td>    
          <td><input type="text" name="email" id="emailError" onblur="javascript:emails();"/></td> 
          <td style="color: red"><div id="errori"></div></td>   
         </tr>   
         <tr>    
          <td>password :</td>    
          <td><input type="text" name="password"  id="PasswordError" onblur="javascript:Passwords();" /></td>
          <td style="color: red"><div id="error"></div></td>    
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" onclick="return man();" value="Save" /></td> 
         </tr>    
        </table> 
        <div style="color: red">${eror}</div>   
       </form>    
</body>
</html>
 <script type="text/javascript">
 
 function man() {	
	 firstname();
	 emails();
	 Passwords();
	 
  if (firstname()&&emails()&&Passwords()) {
      return true;
  } else {
      return false;
  };
  }
     function Passwords() {	
     	var PasswordError=document.getElementById("PasswordError").value;
     if (PasswordError!=null&&PasswordError!="") {
    	 error = "";
      	document.getElementById("error").innerHTML = error;
         return true;
     } else {
     	//setDiv("error","first_name is mandatory");
     	error = "Password is mandatory";
     	document.getElementById("error").innerHTML = error;
         return false;
     };
     }
  
     function firstname() {	
      	var first_nameError=document.getElementById("first_nameError").value;
      if (first_nameError!=null&&first_nameError!="") {
    	  error = "";
        	document.getElementById("errorid").innerHTML = error;
          return true;
      } else {
      	//setDiv("error","first_name is mandatory");
      	error = "username is mandatory";
      	document.getElementById("errorid").innerHTML = error;
          return false;
      };
      } 
     function emails() {	
      	var emailError=document.getElementById("emailError").value;
      if (emailError!=null&&emailError!="") {
    		error = "";
          	document.getElementById("errori").innerHTML = error;
          return true;
      } else {
      	//setDiv("error","first_name is mandatory");
      	error = "email is mandatory";
      	document.getElementById("errori").innerHTML = error;
          return false;
      };
      } 
</script>  
