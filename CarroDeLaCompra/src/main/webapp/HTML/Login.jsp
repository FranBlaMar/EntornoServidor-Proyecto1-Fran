<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Log In</title>
	</head>
	<body>
		<form action= "/CarroDeLaCompra/Login" method="POST">
            <label for="usuario"> Usuario: </label><input type="text" name="usuario" id="usuario"><br><br>
            <label for="contraseña"> Contraseña: </label><input type="text" name="contraseña" id="contraseña"><br><br>
            <input type="submit" id="logear" value="Iniciar Sesión"> 
		</form>
		<% if(session.getAttribute("errorLog") == "true") {%>
			<p>Error, usuario o contraseña erroneo</p>
		<%} %>
	</body>
</html>