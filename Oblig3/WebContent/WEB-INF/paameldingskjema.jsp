<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel ="stylesheet" href ="hover.css">
<title>Påmeldingsskjema</title>
</head>
<body >
	<h2>Påmelding</h2>
		<form action ="paamelding" method="post" class="pure-form pure-form-aligned">
			<fieldset>
			
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name ="fornavn" id ="fornavnin" value="${paamelding.fornavn}"/> 
					<font color="red" >${paamelding.fornavnFeil}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name ="etternavn" id="etternavnin" value="${paamelding.etternavn}"/> 
					<font color="red" >${paamelding.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name ="mobil" id="mobilin" value="${paamelding.mobil}" /> 
					<font color="red">${paamelding.mobilFeil}</font>
			</div>
			<div class="pure-control-group">
				<div class ="tooltip"><label for="passord">Passord:<span class="tooltiptext">
				Svakt passord: 8 tegn<br>Sterkt passord: 12 tegn eller mer</span>
						</label></div><input type="password"
					name="passord" id="passordin" value="${paamelding.passord}" /> 
					<font color="red" >${paamelding.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" id="rpassord" name="rpassord"
					value="${paamelding.passordr}" /> 
					<font color="red">${paamelding.passordrf}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn" id ="kjonn">Kjønn:</label> 
				<input type="radio" name ="kjonn" value="mann" ${paamelding.mann} />mann
				<input type="radio" name="kjonn" value="kvinne" ${paamelding.kvinne} />kvinne
				<font color="red" class ="error">${paamelding.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
			</fieldset>
		</form>
		<p>Allerede påmeldt? <a href="logginn">Trykk her.</a></p>
		
		<script type="text/javascript" src="DeltagerValidering.js" defer></script>
    
</body>
</html>