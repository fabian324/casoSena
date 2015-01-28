<%-- 
    Document   : registrarLinea
    Created on : 22/01/2015, 04:11:39 PM
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
<form name="form1" action="registroLinea" method="post" > 
<div class="tabla">
<center>
<table>
<h1><strong>Registro de Lineas</strong></h1></td>   

<label for="id" class="labele">Numero linea<font color="#FF0000">*</label></font>
<input name="linea" type="text"  autofocus id="nombre" placeholder="linea" required class="form-control inputtext">
<br>
<br>
<label for="cedula" class="labele">Cedula<font color="#FF0000">*</label></font>
<input name="cedula" type="text"  autofocus id="cedula" placeholder="Cedula" required class="form-control inputtext">
<br>
<br>
<label for="telefono" class="labele">Serial<font color="#FF0000">*</label></font>
<input name="telefono" type="text"  autofocus id="telefono" placeholder="Serial" required class="form-control inputtext">
<br>
<br>
<input name="registrar" class="btn btn-success"  type="submit" id="registrar" value="Registrar Linea">
<br>
<br>
<%
 if(request.getParameter("invalida") != null) {
%>
<div>
    <b> la linea ya existe</b>
</div>
<%
 }
%>
<%
 if(request.getParameter("noex") != null) {
%>
<div>
    <b><a href="registro.jsp">el usuario no existe</a></b>
</div>
<%
 }
%>
<%
 if(request.getParameter("msg") != null) {
%>
<div>
    <b>su linea ha sido registrada</b>
</div>
<%
 }
%>
<%
 if(request.getParameter("no") != null) {
%>
<div>
    <b>el serial no exsite. <a href="registrarEquipos.jsp"> Registrelo</a></b>
</div>
<%
 }
%>
</div>
</table>
</form>
</center>
</body>
</html>
