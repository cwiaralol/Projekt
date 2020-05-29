<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.MechanicX.beans.User"%>
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
		<div class="col-sm-6 col-md-4 col-md-offset-4">
  	 <form action="finalOperation" id="options" method="POST">
	</form>
	<H3>Kim jesteś?</H3>
	<select name="mechanic" form="options">
	<c:if test="${user_UserINFO != null }">
 	 </c:if>
 	 <option value="Mechanik Miłosz">Mechanik Miłosz</option>
 	 <option value="Mechanik Marcel">Mechanik Marcel</option>
	</select>
	
	<H3>Wybierz garaż</H3>
	<select name="garage" form="options">
 	 <option value="Garaż 1">Garaż 1</option>
 	 <option value="Garaż 2">Garaż 2</option>
 	 <option value="Garaż 3">Garaż 3</option>
	</select>
   	
   	<H3>ID_użytkownika</H3>
	<select name="id_uzytkownika" form="options">
 	 <option value="1">1</option>
 	 <option value="2">2</option>
 	 <option value="3">3</option>
 	 <option value="4">4</option>
	</select>

   
   	<input type="submit" form="options" value="Zapłać">
   	</div>
    </div>
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>