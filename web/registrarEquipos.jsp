<%-- 
    Document   : registrarEquipos
    Created on : 23/01/2015, 05:51:57 PM
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
  
<form name="form1" action="registroEquipo" method="post" > 
<div class="tabla">
<center>
<table>
<h1><strong>Registro de Lineas</strong></h1> 
<label for="id" class="labele">Serial<font color="#FF0000">*</label></font>
<input name="serial" type="text"  autofocus id="serial" placeholder="serial" required class="form-control inputtext">
<br>
<br>
<label for="numeroLinea" class="labele">Numero linea<font color="#FF0000">*</label></font>
<input name="numeroLinea" type="text"  autofocus id="numeroLinea" placeholder="Numero Linea" required class="form-control inputtext">
<br>
<br>
<label for="marca" class="labele">Marca<font color="#FF0000">*</label></font>
<input name="marca" type="text"  autofocus id="marca" placeholder="Marca" required class="form-control inputtext">
<br>
<br>
<label for="descri" class="labele">Descripcion<font color="#FF0000">*</label></font>
<input name="descri" type="text"  autofocus id="descri" required class="form-control inputtext">
<br>
<br>
<input name="registrar" class="btn btn-success"  type="submit" id="registrar" value="Registrar Equipo">
<br>
<br>
</div>
</form>
</center>
</table>
</body>
</html>
