



function formValidation() {

let fornavnInput = document.getElementById("fornavn");
let etternavnInput = document.getElementById("etternavn");
let mobilInput = document.getElementById("mobil");
let passordInput = document.getElementById("passord");
let repInput = document.getElementById("rpassord");
let form = document.getElementByTagName("form"); 
let mkjonn = document.registration.mann;
let kkjonn = document.registration.kvinne;
{

if(fornavnValidation(fornavnInput))
{
if(etternavnValidation(etternavnInput))
{
if(mobilValidation(mobilInput))
{ 
if(passordValidation(passordInput))
{
if(repetertPassord(repInput))
{
if(kjonnValidation(mkjonn, kkjonn))
{

}
} 
}
} 
}
}
}
return true;
}

function fornavnValidation(fornavnInput) {
	let fornavnReg = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{2,20}$/;
	if (fornavnInput.value.match(fornavnReg)) {
		fornavnInput.style.backgroundcolor = "green";
		return true
	} else {
		fornavnInput.style.backgroundColor = "red";
		return false;
	}
}

function etternavnValidation(etternavnInput) {
	let etternavnReg = /"^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]*{2,20}$/;
	if (etternavnInput.value.match(etternavnReg)) {
		etternavnInput.style.backgroundColor = "green";
		return true
	} else {
		etternavnInput.style.backgroundColor = "red";
		return false;
	}
}

function mobilValidation(mobilInput) {
	let mobilReg = /^[0-9]{8}$/;
	if (mobilInput.value.match(mobilReg)) {
		mobilInput.setAttribute("style", "border-color: green");
		mobilInput.setAttribute("style", "background-color: green");
		return true
	} else {
		mobilInput.setAttribute("style", "border-color: red");
		return false;
	}
}

function passordValidation(passordInput) {
	let passordReg = /^[a-zA-Z0-9_-]{8,20}+$/;
	if (passordInput.value.match(passordReg)) {
		passordInput.setAttribute("style", "border-color: green");
		paamelding.getElementById("passord").style.borderColor = "green";
		return true
	} else {
		alert("Ugyldig passord");
		passordInput.setAttribute("style", "border-color: red");
		paamelding.getElementById("passord").style.borderColor = "red";
		passordInput.focus();
	}
}

function repetertPassord(repInput) {
	if (repInput.value.match(passordInput)) {
		repInput.setAttribute("style", "border-color: green");
		return true
	} else {
		alert("Ikke like");
		repInput.setAttribute("style", "border-color: red");
		repInput.focus();
	}
}

 
 function kjonnValidation(mkjonn, kkjonn) {
x=0;

if(mkjonn.checked) 
{
x++;
} if(kkjonn.checked)
{
x++; 
}
if(x==0)
{
alert('Velg kjønn');
mkjonn.focus();
return false;
}
else
{
alert('Form Successfully Submitted');
window.location.reload()
return true;}
}
 


	