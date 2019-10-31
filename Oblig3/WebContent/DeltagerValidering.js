

let mobilReg = /^[0-9]{8}$/;


let fornavnInput = document.getElementById("fornavnin");
let etternavnInput = document.getElementById("etternavnin");
let mobilInput = document.getElementById("mobilin");
let passordInput = document.getElementById("passordin");
let repInput = document.getElementById("rpassord");

fornavnInput.addEventListener("input", fornavnValidation);
etternavnInput.addEventListener("input", etternavnValidation);
mobilInput.addEventListener("input", mobilValidation);
passordInput.addEventListener("input", passordValidation);
repInput.addEventListener("input", repetertPassord);

passordInput.addEventListener("mouseover", event => {
	
})

function fornavnValidation() {
	if ((fornavnInput.value.length > 1) && (fornavnInput.value.length < 30)) {
		fornavnInput.style.backgroundColor = "#98FB98";
	} else {
		fornavnInput.style.backgroundColor = "#FF0000";
	}
}


function etternavnValidation() {
	if ((etternavnInput.value.length > 1) && (fornavnInput.value.length < 30)) {
		etternavnInput.style.backgroundColor = "#98FB98";
	} else {
		etternavnInput.style.backgroundColor = "#FF0000";
	}
}


function mobilValidation() {
	if (mobilInput.value.match(mobilReg)) {
		mobilInput.style.backgroundColor = "#98FB98";
	} else {
		mobilInput.style.backgroundColor = "#FF0000";
	}
}


function passordValidation() {
	if (passordInput.value.length >= 8 && passordInput.value.length <= 12) {
		passordInput.style.backgroundColor = "#EFF542";
	} else if (passordInput.value.length >= 13) {
		passordInput.style.backgroundColor = "#98FB98";
	} else {
		passordInput.style.backgroundColor = "#FF0000";
	}
}

function repetertPassord() {
	if (repInput.value === passordInput.value) {
		repInput.style.backgroundColor = "#98FB98";
	} else {
		repInput.style.backgroundColor = "#FF0000";
	}
}
