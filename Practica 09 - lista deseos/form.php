
<?php
// Variables conexión
$server = "localhost";
$user = "root";
$password = "";
$database = "form_deseos";


// Conectar con el servidor
$link = mysqli_connect($server, $user, $password) or die('No se pudo conectar: ' . mysqli_error($link));
// Conectar con la base de datos
$db = mysqli_select_db($link, $database) or die('No se pudo seleccionar la base de datos');


// Volcamos en variables cada uno de los campos de nuestro formulario
$nombre = $_POST['nombre'];
$direccion = $_POST['direccion'];
$email = $_POST['email'];
$localidad = $_POST['localidad'];
$provincia = $_POST['provincia'];
$deseos = $_POST['deseos'];
//$seguimiento = $_POST['seguimiento'];

// Comprobar si un campo del formulario tiene valor o no
$seguimiento = (isset($_POST['seguimiento'])) ? TRUE : FALSE;


// Creamos una variable consulta con el comando SQL insert
$consulta = "INSERT INTO form (nombre, direccion, email, localidad, provincia, deseos, seguimiento) VALUES ('$nombre','$direccion','$email','$localidad', '$provincia', '$deseos', '$seguimiento')";


// Si queremos visualizar la consulta que se envía al servidor pondremos: 
echo "----------------------" . $consulta . "--";


// Insertar los datos
mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
?>