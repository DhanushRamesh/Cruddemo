  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>UserName</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="usr" items="${list}">   
   <tr>  
   <td>${usr.id}</td>  
   <td>${usr.name}</td>  
   <td>${usr.email}</td>  
   <td>${usr.username}</td>  
   <td><a href="editemp/${usr.id}">Edit</a></td>  
   <td><a href="deleteuser/${usr.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="userform">Add New Employee</a>  