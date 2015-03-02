<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <link type="text/css" rel="stylesheet" href="estilos/estilo.css" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
<body>
<form name="form1" action="registro" method="post" > 
<div class="tabla">
<center>
<table>
<h1><strong>Ingreso Usuarios Registrados</strong></h1></td>   
<label for="usu" class="labele">Cedula<font color="#FF0000">*</label></font>
<input name="cedula" type="text" id="cedula" placeholder="Cedula" required class="form-control inputtext">
<br>
<br>
<input name="ingresarr" class="btn btn-success"  type="submit" id="ingresar" value="Ingresar">
<br>
<br>
 <%
 if(request.getParameter("no") != null  ) {
%>
<div>
<b div clas="valido"> sus datos no son validos. <a href="registro.jsp"> Registrese</a></b>
</div>
<%
 }
%>  
</table>
 </center>
</div>
</form>
</body>
</html>
