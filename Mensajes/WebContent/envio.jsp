
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>envio</title>
</head>
<!--captura de datos e inserci�n en el Javabean-->
<jsp:useBean id="mensa" scope="request" class="javabeans.Mensaje" />
<jsp:setProperty name="mensa" property="*" />
<%
	if (request.getParameter("texto") != null) {
%>
<jsp:forward page="Controlador?operacion=grabar" />
<%
	}
%>

<body>
	<center>
		<h1>Generaci�n de mensajes</h1>
		<form method="post">
			<br />
			<br /> <b>Datos del mensaje:</b><br />
			<br /> Introduzca destinatario: <input type="text" name="destino"><br />
			<br /> Introduzca remitente : <input type="text" name="remite"><br />
			<br /> Introduzca texto : <br />
			<textarea name="texto">
  </textarea>
			<hr />
			<br /> <input type="submit" name="Submit" value="Enviar"> <input
				type="reset" value="Reset">
		</form>
	</center>
</body>
</html>