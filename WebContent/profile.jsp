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
  <form class ="col-md-2 col-md-offset-1" action="profile" method="GET">
  	<input type="hidden" name="command" value="userProfile" />
    <input type=submit class="btn btn-primary" value="Profil">
    </form>
      
    <form class ="col-md-2" action="profile" method=GET>
  	<input type="hidden" name="command" value="orderHistory" />
    <input type=submit class="btn btn-success" value="Podgląd wydarzeń">
    </form>
    <br>
  <c:choose>
  <c:when test="${command == 'userProfile'}">
  <!--Table-->
  <h3>Dane podstawowe:</h3>
	<table id="tablePreview" class="table table-hover table-bordered">
	<!--Table head-->
  <thead>
    <tr>
      <th>--></th>
      <th>Email</th>
      <th>Imie</th>
      <th>Drugie imie</th>
      <th>Nazwisko</th>
    </tr>
  </thead>
  <!--Table head-->
  <!--Table body-->
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><c:out value="${users.getEmail()}"/></td>
      <td><c:out value="${users.getFirstName()}"/></td>
      <td><c:out value="${users.getMiddleName()}"/></td>
      <td><c:out value="${users.getLastName()}"/></td>
     <td><form action="editProfile" method="GET">
  	<input type="hidden" name="command" value="editProfile" />
    <input type=submit class="btn btn-warning" value="Zaktalizuj dane">
    </form></td>
    <td><form action="editProfile" method="GET">
  	<input type="hidden" name="command" value="changePassword" />
    <input type=submit class="btn btn-success" value="Zmień hasło">
    </form></td>
     
    </tr>
  </tbody>
  <!--Table body-->
</table>

  <h3>Dane samochodu:</h3>
<table id="tablePreview" class="table table-hover table-bordered">
<!--Table head-->
  <thead>
    <tr>
      <th>--></th>
      <th>Marka</th>
      <th>Model</th>
      <th>Rejestracja</th>
    </tr>
  </thead>
  <!--Table head-->
  <!--Table body-->
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><c:out value="${user_UserINFO.getCar_brand()}"/></td>
      <td><c:out value="${user_UserINFO.getCar_model()}"/></td>
      <td><c:out value="${user_UserINFO.getCar_registration()}"/></td>
    <c:if test="${user_UserINFO != null }">
    <td><form action="UserCar" method="GET">
  	<input type="hidden" name="command" value="updateUserCar" />
    <input type=submit class="btn btn-warning" value="Zaktalizuj dane">
    </form></td>
    </c:if>
    <c:if test="${user_UserINFO == null }">
    <td><form action="UserCar" method="GET">
  	<input type="hidden" name="command" value="addUserCar" />
    <input type=submit class="btn btn-success" value="Dodaj dane do płatności">
    </form></td>
    </c:if>

    </tr>
  </tbody>
  <!--Table body-->
</table>
</c:when>
<c:when test="${command == 'orderHistory' }">
<table id="tablePreview" class="table table-hover table-bordered">
  	<thead>
    <tr>
      <th>ID</th>
      <th>Data zamówienia</th>
      <th>Status</th>
    
    </tr>
  </thead>
  	<tbody>
 	<c:forEach var="temp" items="${orderHistory}" > 
    <tr>
      <th scope="row"><c:out value="${temp.getOrderId()}"/></th>
      <td><c:out value="${temp.getOrderDate()}"/></td>
      <td><c:out value="${temp.getStatus()}"/></td>
      
    </tr>
   	</c:forEach>
  	</tbody>
	</table>
</c:when>
</c:choose>
  </div>
</div>
   
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>