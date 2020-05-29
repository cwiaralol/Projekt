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
   		<font size="5"><p>Zarejestruj się na naprawę !</p> </font>
  <iframe src="https://calendar.google.com/calendar/embed?src=akroutgk8kkadc1fobrl1q6n60%40group.calendar.google.com&ctz=Europe%2FWarsaw" style="border: 0" width="800" height="600" frameborder="0" scrolling="no"></iframe>
   <iframe src="https://docs.google.com/forms/d/e/1FAIpQLSdebjrvUz05c7xZakJ8smOrSgN3KzpFsQq5XsOOt9nnzlViKw/viewform?embedded=true" width="640" height="1255" frameborder="0" marginheight="0" marginwidth="0">Ładuję…</iframe>
   </div>
   </div>
   <jsp:include page="footer.jsp"/>
   	
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>