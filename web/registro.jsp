<%-- 
    Document   : registro
    Created on : 22/01/2015, 11:26:10 AM
    Author     : fabian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="estilos/estilo.css" />
    </head>
    <body>
<form name="form1" action="registro" method="post" > 
<div class="tabla">
<center>
<table>
<h1><strong>Registro de Usuarios</strong></h1></td> 
<label for="usu" class="labele">Nombre<font color="#FF0000">*</label></font>
<input name="nombre" type="text"  autofocus id="nombre" placeholder="nombre" required class="form-control inputtext">
<br>
<br>
<label for="ape" class="labele">Apellido<font color="#FF0000">*</label></font>
<input name="apellido" type="text"  autofocus id="apellido" placeholder="apellido" required class="form-control inputtext">
<br>
<br>
<label for="con" class="labele">Telefono<font color="#FF0000">*</label></font>
<input name="telefono" type="text" required id="telefono" placeholder="Telefono" required class="form-control inputtext">
<br>
<br>
<label for="date" class="labele">Fecha Nacimiento<font color="#FF0000">*</label></font>
<input name="date" type="date" id="date" required class="form-control inputtext">   
<br>
<br>  
<label for="ced" class="labele">Cedula<font color="#FF0000">*</label></font>
<input name="cedula" type="text" required id="cedula" placeholder="Cedula" required class="form-control inputtext">
<br>
<br>
<input name="registro" class="btn btn-success"  type="submit" id="registro" value="Registrar">
<br>
<br>
</div>
</table>
</center
</form>
</body>
</html>

