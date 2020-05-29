<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.MechanicX.beans.User"%>
<%@ page import="pl.MechanicX.beans.User_Car" %>
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
  

<table id="tablePreview" class="table table-hover table-bordered">
<!--Table head-->
  <thead>
    <tr>
      <th>CZYNNOŚCI</th>
      <th>Nazwa</th>
      <th>Wykonywana czynność</th>
     
    </tr>
  </thead>
  <!--Table head-->
  <!--Table body-->
  <tbody>
  <% int count = 1; %>
  <c:forEach var="temp" items="${statusxList}" > 
    <tr>
      <th scope="row"><%= count %></th>
      <td><img src="<c:out value="${temp.getImageUrl()}"/>" alt="Nie można załadować zdjęcia" height="250" width="250"></td>
      <td><c:out value="${temp.getDescription()}"/></td>
   
      <%
    	if (session.getAttribute("users") == null){
    %>
      	<td><form  action="review" method=GET>
  		<input type="hidden" name="status_id" value="${temp.getStatus_id()}"/>
    	<input type=submit class="btn btn-warning" value="Zobacz oceny">
    	</form></td>
      <td><a href="login" class="btn btn-sm btn-success btn-block">Zaloguj się</a></td>
      <% } 
    	
    	
      
    else if (((User)session.getAttribute("users")).getType().equals("customer")){

    	 %>
       	<td><form  action="review" method=GET>
   		<input type="hidden" name="status_id" value="${temp.getStatus_id()}"/>
     	<input type=submit class="btn btn-warning" value="Zobacz oceny">
     	</form></td>
       <% } 
    	
    	
    	else  { %>
      <td><form  action="review" method=GET>
  		<input type="hidden" name="status_id" value="${temp.getStatus_id()}"/>
    	<input type=submit class="btn btn-warning" value="Sprawdz oceny innych !">
    	</form></td>
		<c:if test="${temp.getQuantity() gt 0 }">
     
        </c:if> 
      
      <td><form action="addOperation" method=GET>
      <input type="hidden" name="status_id" value="${temp.getStatus_id()}"/>
      <input type="submit" class="btn btn-sm btn-success btn-block" value="Przejdz dalej"> 
      </form></td>  
      <% } %>
    </tr>
    <% count++; %>
   </c:forEach>
  </tbody>
  <!--Table body-->
</table>
<!--Table-->
  	
    </div>
</div>
   
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>