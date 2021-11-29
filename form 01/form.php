<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <?php
  $link = mysqli_connect("localhost", "root", "") or die('No se pudo conectar: ' . mysqli_error($link));
  $db = mysqli_select_db($link, "tst_form01") or die('No se pudo seleccionar la base de datos');

  // volcamos en variables cada uno de los campos que queremos almacenar en la base de datos 
  // en nuestro caso POST(‘name de cada uno de los imput del formulario ) 
  $nombre = $_POST['nombre'];
  $apellidos = $_POST['apellidos'];
  $contrasena = $_POST['contrasena'];
  $DNI = $_POST['DNI'];
  $sexo = $_POST['sexo'];
  $consulta = "INSERT INTO tabla_cv (nombre, apellidos, contrasena, DNI, sexo)  

  VALUES ('$nombre','$apellidos','$contrasena','$DNI','$sexo')";
  // Si queremos visualizar la consulta que se envía al servidor pondremos: 

  echo "----------------------" . $consulta . "--";
  mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
  //Si queremos encriptar la contraseña podemos utilizar la función md5(variable donde se almacena) 
  // echo "¡Graciassss! Hemos recibido sus datos.\n";
  ?>
</body>

</html>