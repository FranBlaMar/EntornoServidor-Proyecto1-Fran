<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tu Web Personal</title>
<link rel="styleSheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="cuadrado">
		<!-- &bull es para poner puntos (Simplemente decoracion) -->
		<h1> &bull; Creación de usuario&bull;</h1>
		<form class="formularioUsuario" action="main.jsp" method="POST">
			<label>Nombre: <input type="text" id="nombre" name="nombre"></label><br><br>
               <label>E-mail: <input type="text" id="email" name="email"></label><br><br>
               <label>Fecha Nacimiento (Año-Mes-Día): <input type="date" id="fecha" name="fechaNacimiento"></label><br><br>
               <label>
               	Sector al que pertenece: 
				<select name="trabajo" name="trabajo">
				   <option value="TECNOLOGICO">TECNOLOGICO</option> 
				   <option value="MEDICINA">MEDICINA</option> 
				   <option value="EDUCACION">EDUCACION</option>
				   <option value="SERVICIOS">SERVICIOS</option> 
				</select></label><br><br>
               <label> <input type="submit" id="botonCrearUsuario" value="Crear Usuario"></label>
           </form>
	</div>
</body>
</html>