<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		<br />
		&nbsp;&nbsp;&nbsp;${fornavn}<br />
		&nbsp;&nbsp;&nbsp;${etternavn}<br /> 
		&nbsp;&nbsp;&nbsp;${mobil}<br />
	</p>
	<a href="DeltagerListeServlet">Gå til deltagerlisten</a>
</body>
</html> 