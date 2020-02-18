<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  
<html>
<head>
<!-- <script src="../js/sample.js" type="text/javascript">
	
</script> -->
</head>
<body>

<h1>Add New Employee</h1>  
       <form method="post" action="/save">    
        <table >    
         <tr>    
          <td>First Name : </td>   
          <td><input type="text" name="first_name" id="first_name" onblur="javascript:testing();" /></td>
				<!-- <div>
					<span id="end" style="color: red">&nbsp;</span>
				</div> -->
				<td style="color: red"><div id="errorid"></div></td>
			</tr>
			
         <tr>    
          <td>Last Name : </td>   
          <td><input type="text" name="last_name" id="last_name" onblur="javascript:lastname();"  /></td>
          <td style="color: red"><div id="errori"></div></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><input type="number" name="salary" id="salary" onblur="javascript:salar();" /></td>
          <td style="color: red"><div id="error"></div></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><input type="text" name="designation" id="designation" onblur="javascript:designatio();"  /></td>
          <td style="color: red"><div id="erro"></div></td>   
         </tr>
         <tr>    
          <td>Experience : </td>   
          <td><input type="text" name="experience" id="experience" onblur="javascript:experienc();"  /></td>  
         <td style="color: red"><div id="err"></div></td> 
         </tr>
         <tr>    
          <td>Joining Date : </td>   
          <td><input type="text" name="joining_date" id="joining_date" onblur="javascript:joiningdate();"  /></td>  
         <td style="color: red"><div id="er"></div></td> 
         </tr>
         <tr>    
          <td>Manager : </td>   
          <td><input type="text" name="manager" id="manager" onblur="javascript:manage();"  /></td>  
         <td style="color: red"><div id="e"></div></td> 
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" onclick="return man();" value="Save" /></td> 
         </tr>
         
        </table>
        
        <div style="color: red">${eror}</div>   
       </form>    
<!--  <script src="../js/sample.js" type="text/javascript">
	
</script> -->


<script >
function man() {
	testing();
	lastname();
	salar();
	designatio();
	experienc();
	joiningdate();
	manage();
	
	
    if (testing()&&lastname()&&salar()&&designatio()&&experienc()&&joiningdate()&&manage()) {
        return true;
    }
    
    else {
    	
        return false;
    };
}
function testing() {
	var value=document.getElementById("first_name").value;
	
	
    if (value!=null&&value!="") {
    	error = "";
    	document.getElementById("errorid").innerHTML = error;
        return true;
    } else {
    	//setDiv("end","first_name is mandatory");
    	 error = "first name is mandatory";
    	document.getElementById("errorid").innerHTML = error; 
        return false;
    };
}

    function lastname() {	
    	var last_name=document.getElementById("last_name").value;
    if (last_name!=null&&last_name!="") {
    	error = "";
    	document.getElementById("errori").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "last_name name is mandatory";
    	document.getElementById("errori").innerHTML = error;
        return false;
    };
    }
    function salar() {	
var salary=document.getElementById("salary").value;
	
    if (salary!=null&&salary!=0.0) {
    	error = "";
    	document.getElementById("error").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "salary is mandatory";
    	document.getElementById("error").innerHTML = error;
        return false;
    };
    }
    function designatio() {	
var designation=document.getElementById("designation").value;
	
    if (designation!=null&&designation!="") {
    	error = "";
    	document.getElementById("erro").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "designation name is mandatory";
    	document.getElementById("erro").innerHTML = error;
        return false;
    };
    }
    function experienc() {	
var experience=document.getElementById("experience").value;
	
    if (experience!=null&&experience!="") {
    	error = "";
    	document.getElementById("err").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "experience name is mandatory";
    	document.getElementById("err").innerHTML = error;
        return false;
    };
    }
    function joiningdate() {	
var joining_date=document.getElementById("joining_date").value;
	
    if (joining_date!=null&&joining_date!="") {
    	error = "";
    	document.getElementById("er").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "joining_date name is mandatory";
    	document.getElementById("er").innerHTML = error;
        return false;
    };
    }
    function manage() {	
var manager=document.getElementById("manager").value;
	
    if (manager!=null&&manager!="") {
    	error = "";
    	document.getElementById("e").innerHTML = error;
        return true;
    } else {
    	//setDiv("error","first_name is mandatory");
    	error = "manager name is mandatory";
    	document.getElementById("e").innerHTML = error;
        return false;
    };
    }
    
    
    

</script>
</body>

</html>