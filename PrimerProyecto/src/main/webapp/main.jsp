<%@page import="beans.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tu Web Personal</title>
<link rel="styleSheet" type="text/css" href="css/style.css">
</head>
<body>
	<jsp:useBean id="usuarioPrincipal" class="beans.UsuarioBean" scope="session"/>
	<jsp:setProperty name="usuarioPrincipal" property="*"/>
	<% if(usuarioPrincipal.getNombre()==null){ %>
		<h1> OOOPS... Parece que aún no te has registrado</h1>
		<a href="crearUsr.jsp">Haz Click aquí para registrate</a>
	<% }
	else{ %>
		<h1>¡Bienvenido <jsp:getProperty name="usuarioPrincipal" property="nombre"/>!</h1>
		<% LocalDate fechaNacimiento = usuarioPrincipal.getFechaNacimiento();%>
		<h2><%=fechaNacimiento%></h2>
	<% } %>
</body>
</html>
