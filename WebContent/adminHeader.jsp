<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <a href="home" class="navbar-brand">MechanicX</a>
        
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>
        
        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="home">Główna</a></li>
            <li><a href="calendar">Kalendarz</a></li>
            <li><a href="controlPanel">Panel Kontrolny</a><li>
            <li><a href="profile">Profil</a><li>
        	<li><a href="operation">Zmień status</a><li>	
        	<li><a href="rules">Regulamin</a><li>	
        	<li><a href="contact">Kontakt</a><li>
            <li><a href="logout">Wyloguj się <c:out value="${users.getUsername()}"/> </a></li>
          </ul>
        </div>
        
      </div>
    </nav>