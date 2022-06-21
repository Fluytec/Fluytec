var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if ( username == "usuario1" && password == "contraseña1"){
alert ("Ingreso como administrador");
window.location = "../Bootstrap-Admin-Theme-master/index.html"; // Redirecting to other page.
return false;
}
if ( username == "usuario2" && password == "contraseña2"){
alert ("Ingreso como vendedor");
window.location = "../Bootstrap-Admin-Theme-master/index-ventas.html"; // Redirecting to other page.
 return false;
}
if ( username == "usuario3" && password == "contraseña3"){
 alert ("Ingreso como auxiliar de bodega");
window.location = "../Bootstrap-Admin-Theme-master/index-bod.html"; // Redirecting to other page.
 return false;
}
else{
attempt --;// Decrementing by one.
alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
if( attempt == 0){
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
}
}
}