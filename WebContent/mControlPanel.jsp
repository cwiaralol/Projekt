<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.MechanicX.beans.User"%>
<%@ page import="pl.MechanicX.beans.User_Car" %>
<%@ page import="pl.MechanicX.beans.xActiv" %>
<%@ page import="pl.MechanicX.beans.xOperation" %>
<%@ page import="pl.MechanicX.beans.xControl" %>

<!DOCTYPE html>
<html>
 <head>
    <title>MechanicX</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>

  <body>  
    <jsp:include page="headerChanger.jsp"/>
	
   	<div class="container">
  	<div class="row">
  
      
   
    <form class ="col-md-2 col-md-offset-1" action="controlPanel" method="GET">
  	<input type="hidden" name="command" value="controlUsers" />
    <input type=submit class="btn btn-primary" value="Kontrola użytkowników">
    </form>
  
    
    <form class ="col-md-3" action="controlPanel" method="GET">
  	<input type="hidden" name="command" value="controlTOperation" />
    <input type=submit class="btn btn-warning" value="Kontrola operacji mechanika">
    </form>
    
    
    
        </div>
  	</div>
  	
	<div class="container">
	
	<br>
	
	
	<c:choose>
  	<c:when test="${command == 'controlUsers' || command == 'filterUsers'}"> 
  	     
    <form action="controlPanel" id="filterUsers" method="GET">
  	<input type="text" name="search" placeholder="Wpisz szukane">
  	<input type="hidden" name="command" value="filterUsers" />
  	<input type="submit">
	</form>

	<select name="parameter" form="filterUsers">
  	<option value="id">Id</option>
 	 <option value="username">Nazwa uzytkownika</option>
 	 <option value="email">Email</option>
 	 <option value="fristName">Imię</option>
 	 <option value="lastName">Nazwisko</option>
 	 <option value="active">Aktywny</option>
	</select>
     
	<table id="tablePreview" class="table table-hover table-bordered">
  	<thead>
    	<tr>
      		<th>ID</th>
      		<th>Nazwa użytkownika</th>
      		<th>Email</th>
      		<th>Imię</th>
      		<th>Drugie Imię</th>
      		<th>Nazwisko</th>
      		<th>Aktywny</th>
    	</tr>
  	</thead>
  	<tbody>
  	<c:forEach var="temp" items="${userList}" > 
    <tr>
      <th scope="row"><c:out value="${temp.getId()}"/></th>
      <td><c:out value="${temp.getUsername()}"/></td>
      <td><c:out value="${temp.getEmail()}"/></td>
      <td><c:out value="${temp.getFirstName()}"/></td>
      <td><c:out value="${temp.getMiddleName()}"/></td>
      <td><c:out value="${temp.getLastName()}"/></td>
      <td><c:out value="${temp.isActive()}"/></td>
      	<c:choose>
  		<c:when test="${temp.isActive() == true}"> 
  	  
  		</c:when>
		<c:when test="${temp.isActive() == false}"> 
  			<td><form action="controlPanel" method=POST>
      <input type="hidden" name="action" value="activateUser"/>
      <input type="hidden" name="userId" value="${temp.getId()}"/>
      <input type="submit" class="btn btn-sm btn-success btn-block" value="Aktywuj użytkownika"> 
      </form></td> 
  		</c:when>
		</c:choose>
    </tr>
   	</c:forEach>
  	</tbody>
	</table>
	</c:when>
  
	
  	<c:when test="${command == 'controlActivsX'}"> 
  	<table id="tablePreview" class="table table-hover table-bordered">
  	<thead>
    <tr>
      <th>ID</th>
      <th>Id użytkownika</th>
      <th>Data zamówienia</th>
      <th>Status</th>
    </tr>
  </thead>
  	<tbody>
 	<c:forEach var="temp" items="${aktivList}" > 
    <tr>
      <th scope="row"><c:out value="${temp.getOrderId()}"/></th>
      <td><c:out value="${temp.getUserId()}"/></td>
      <td><c:out value="${temp.getOrderDate()}"/></td>
      <td><c:out value="${temp.getStatus()}"/></td>
    </tr>
   	</c:forEach>
  	</tbody>
	</table>
  	 </c:when>
  	 
  	<c:when test="${command == 'controlTOperation'}"> 
	<table id="tablePreview" class="table table-hover table-bordered">
  	<thead>
    <tr>
      <th>ID_operacji_mechanika</th>
      <th>ID zamówienia</th>
      <th>ID mechanika</th>
      <th>Garaż</th>
    </tr>
  </thead>
  	<tbody>
 	<c:forEach var="temp" items="${controlstList}" > 
    <tr>
      <th scope="row"><c:out value="${temp.getOperation_id()}"/></th>
      <td><c:out value="${temp.getOrderId()}"/></td>
      <td><c:out value="${temp.getUserId()}"/></td>
      <td><c:out value="${temp.getGarage()}"/></td>
    </tr>
   	</c:forEach>
  	</tbody>
	</table>
  	</c:when>
	
  	<c:when test="${command == 'controlXControl'}"> 
<table id="tablePreview" class="table table-hover table-bordered">
  	<thead>
    <tr>
      <th>ID</th>
      <th>Typ</th>
      <th>ID użytkownika</th>
      <th>ID zamówienia</th>
      <th>Status</th>
      <th>Całość</th>
    </tr>
  </thead>
  	<tbody>
 	<c:forEach var="temp" items="${kontrolsList}" > 
    <tr>
      <th scope="row"><c:out value="${temp.getControl_id()}"/></th>
      <td><c:out value="${temp.getControl_type()}"/></td>
      <td><c:out value="${temp.getUserId()}"/></td>
      <td><c:out value="${temp.getOrderId()}"/></td>
      <td><c:out value="${temp.getStatus()}"/></td>
      <td><c:out value="${temp.getAmount()} zł"/></td>
    </tr>
   	</c:forEach>
  	</tbody>
	</table>
  	</c:when>
  	<c:otherwise>
  	 <div class ="text-center">
  	 <h2>Podstrona mechanika</h2>
  	 </div> 
  	</c:otherwise>
	</c:choose>
	</div>
  	
   
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>