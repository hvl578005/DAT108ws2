<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${liste}" var="d">
		
		<c:choose>
		<c:when test = "${d.mobil eq mobil}"><tr bgcolor="#68F35F"></c:when>
		<c:otherwise><tr bgcolor="#ffffff"></c:otherwise>
		</c:choose>
			<td align="center">
			<c:choose>
				<c:when test="${d.kjonn eq 'kvinne'}"><font color="pink">&#9792;</font></c:when>
				<c:otherwise><font color="blue">&#9794;</font></c:otherwise>
			</c:choose>
			</td>
			<td>${d.fornavn} ${d.etternavn}</td>
			<td>${d.mobil}</td>
		</c:forEach>
	</table>
	
	<p>
		<a href="ferdig">Ferdig</a>
	</p>
</body>
</html>