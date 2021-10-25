<%@page import="beans.UsuarioBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tu Web Personal</title>
<link rel="styleSheet" type="text/css" href="css/style.css">
</head>
<body>
	<!-- Creamos el objeto usuario -->
	<jsp:useBean id="usuarioPrincipal" class="beans.UsuarioBean" scope="session"/>
	<!-- Le asignamos los valores del formulario -->
	<jsp:setProperty name="usuarioPrincipal" property="*"/>
	
	<!-- Si el nombre del usuario esta sin rellenar que salte error y envia a la pagina de error-->
	<% if(usuarioPrincipal.getNombre()==null){ 
		throw new Exception("Error en el registro");
	 }
	// Si no hay error, muestra por pantalla los datos del usuario
	else{ %>
		<h1>¡Bienvenido <jsp:getProperty name="usuarioPrincipal" property="nombre"/>!</h1>
		<p class="datos"> Tus datos son <br><br>
		Email: <%=usuarioPrincipal.getEmail()%><br>
		Edad: <%=usuarioPrincipal.getEdad() %><br>
		Fecha de nacimiento: <%=usuarioPrincipal.getFechaEnLocalDate() %><br>
		Sector en el que trabajas o estudias: <%=usuarioPrincipal.getSector() %>
		</p>
		<!-- Segun el sector mostrará unas noticias o otras, relacionadas con el sector-->
		<% if(usuarioPrincipal.getSector().equals("MEDICINA")){ %>
			<div class="datosDerecha"> 
			<p>Noticias relacionadas con tu sector:</p> <br>
				<a href="https://elpais.com/noticias/medicina/"> ElPais</a><br>
				<a href="https://www.redaccionmedica.com/tags/medicina"> RedaccionMedica</a>
			</div>
		<%} 
		else if(usuarioPrincipal.getSector().equals("TECNOLOGICO")){%>
			<div class="datosDerecha"> 
			<p>Noticias relacionadas con tu sector:</p> <br>
				<a href="https://elpais.com/tecnologia/"> ElPais</a><br>
				<a href="https://www.eitb.eus/es/noticias/tecnologia/"> EITB</a>
			</div>
		<%}
		else{%>
			<div class="datosDerecha"> 
			<p>Noticias relacionadas con tu sector:</p> <br>
				<a href="https://elpais.com/noticias/educacion/"> ElPais</a><br>
				<a href="https://www.europapress.es/sociedad/educacion-00468/"> EuropaPress</a>
			</div>
		<%}%>
		<!-- Si el mes y el dia de la fecha de nacimiento del usuario coincide con el mes y dia actual, es que es su cumpleaños y le muestra un gif de cumpleaños -->
		<% if(usuarioPrincipal.getFechaEnLocalDate().getMonthValue() == LocalDate.now().getMonthValue() && usuarioPrincipal.getFechaEnLocalDate().getDayOfMonth() == LocalDate.now().getDayOfMonth()){%>
            <div class="cumple">
            	<p>¡¡Feliz Cumpleaños!!</p>
            </div>
            	<img id="tarta" src="img/tarta.gif" alt="cumpleaños"/>       
		<%}		
	}%>
</body>
</html>
