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
  	<c:if test="${param.success eq 1}">
    <div class="alert alert-success" role="alert">
  	Zarejsetrowano pomyślnie!
	</div>
	</c:if>
    <jsp:include page="headerChanger.jsp"/>
    <div class="row" id="center">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
    	<br><br><br>
   		<font size="5"><p>Regulamin !</p> </font>
   		<font size="3"><p>
   		link 1:<a href="https://drive.google.com/file/d/1eYkVoztcCPHEnYg4pkybGDIMgIcQFn3k/view?usp=sharing">Powierzenie danych osobowych</a><br>
link 2:<a href="https://drive.google.com/file/d/1wOswtgYwNXjw4VpnIMCKInRmx7YJdYTD/view?usp=sharing">Regulamin szczegółowy serwisu</a><br>
link 3:<a href="https://drive.google.com/file/d/1D4BV3OLU86Je911I2FvcKjZhyb3jh5i8/view?usp=sharing">Regulamin świadczenia usług</a>
   		

</p> </font>
 <img src="https://i.ibb.co/zrL0sjx/na-g-wn.png" alt="na-g-wn" border="0">
   </div>
   </div>
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>