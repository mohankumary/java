<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<head></head>
<div style="color: red">${eror}</div>	
<h1>Login page</h1>  
       <form method="post" action="/submite">    
        <table >    
         <tr>    
          <td>email : </td>   
          <td><input type="text" name="email" id="emailError" onblur="javascript:emails();" /></td>
          <td style="color: red"><div id="errorid"></div></td>  
         </tr>    
         <tr>    
          <td>Password :</td>    
          <td><input type="password" name="Password" id="PasswordError" onblur="javascript:Passwords();"/></td>
          <td style="color: red"><div id="errori"></div></td>  
         </tr>
         <tr>       
          <td><a href="SignIn"><input type="button" value="SignUp" /></a></td>
          <td><input type="submit"  onclick="return man();" value="Submit" /></td> 
         </tr>    
        </table> 
         
       </form>
       
     
 <script type="text/javascript">
 function man() {
	 emails();
	 Passwords();
	 
  if (emails()&&Passwords()) {
      return true;
  } else {
      return false;
  };
  }
     function Passwords() {	
     	var PasswordError=document.getElementById("PasswordError").value;
     if (PasswordError!=null&&PasswordError!="") {
    	 error = "";
      	document.getElementById("errori").innerHTML = error;
         return true;
     } else {
     	//setDiv("error","first_name is mandatory");
     	error = "Password is mandatory";
     	document.getElementById("errori").innerHTML = error;
         return false;
     };
     }
     function emails() {	
      	var emailError=document.getElementById("emailError").value;
      if (emailError!=null&&emailError!="") {
    	  error = "";
        	document.getElementById("errorid").innerHTML = error;
          return true;
      } else {
      	//setDiv("error","first_name is mandatory");
      	error = "email is mandatory";
      	document.getElementById("errorid").innerHTML = error;
          return false;
      };
      } 
</script>  
      
       
       