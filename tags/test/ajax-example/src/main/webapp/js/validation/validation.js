window.onload = initPage;

function initPage() {
	document.getElementById("username").onblur = checkUsername;
}

function checkUsername() {
	alert("checkUsername");
}