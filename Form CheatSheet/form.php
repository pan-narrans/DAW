
<?php
// Variables conexión
$server = "localhost";
$user = "root";
$password = "";
$database = "db_name";


// Conectar con el servidor
$link = mysqli_connect($server, $user, $password) or die('No se pudo conectar: ' . mysqli_error($link));
// Conectar con la base de datos
$db = mysqli_select_db($link, $database) or die('No se pudo seleccionar la base de datos');


// Volcamos en variables cada uno de los campos de nuestro formulario
$var_name_1 = $_POST['form_var_name_1'];
$var_name_2 = $_POST['form_var_name_2'];
$var_name_3 = $_POST['form_var_name_3'];
$var_name_4 = $_POST['form_var_name_4'];

// Comprobar si un campo del formulario tiene valor o no
$var_name_5 = (isset($_POST['form_var_name_5'])) ? $_POST['form_var_name_5'] : "OTHER VALUE";

/* if (isset($_POST['form_var_name_5'])) {
  $var_name_5 = $_POST['form_var_name_5'];
} else {
  $var_name_5 = "OTHER VALUE";
} */

// Creamos una variable consulta con el comando SQL insert
$consulta = "INSERT INTO formulario (db_var_name_1, db_var_name_2, db_var_name_3, db_var_name_4, db_var_name_5) 
  VALUES ('$var_name_1','$var_name_2','$var_name_3','$var_name_4', '$var_name_5')";


// Si queremos visualizar la consulta que se envía al servidor pondremos: 
echo "----------------------" . $consulta . "--";


// Insertar los datos
mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
?>